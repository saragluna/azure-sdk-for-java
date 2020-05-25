// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.azure.test.keyvault;

import com.microsoft.azure.test.AppRunner;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import static org.junit.Assert.assertEquals;

public class KeyVaultIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(KeyVaultIT.class);
    private static final String AZURE_KEYVAULT_ENDPOINT = System.getenv("AZURE_KEYVAULT_ENDPOINT");
    private static final String SPRING_CLIENT_ID = System.getenv("SPRING_CLIENT_ID");
    private static final String SPRING_CLIENT_SECRET = System.getenv("SPRING_CLIENT_SECRET");
    private static final String SPRING_TENANT_ID = System.getenv("SPRING_TENANT_ID");
    private static final String KEY_VAULT_SECRET_VALUE = System.getenv("KEY_VAULT_SECRET_VALUE");
    private static final String KEY_VAULT_SECRET_NAME = System.getenv("KEY_VAULT_SECRET_NAME");

//    private static RestTemplate restTemplate;
//    private static final String prefix = "test-keyvault";
//    private static final String VM_USER_NAME = "deploy";
//    private static final String VM_USER_PASSWORD = "12NewPAwX0rd!";
//    private static final String KEY_VAULT_VALUE = "value";
//    private static final String TEST_KEY_VAULT_JAR_FILE_NAME = "app.jar";
//    private static final int DEFAULT_MAX_RETRY_TIMES = 3;
//    private static String TEST_KEYVAULT_APP_JAR_PATH;
//    private static String TEST_KEYVAULT_APP_ZIP_PATH;

//    @BeforeClass
//    public static void createKeyVault() throws IOException {
//        restTemplate = new RestTemplate();
//
//        TEST_KEYVAULT_APP_JAR_PATH = new File(System.getProperty("keyvault.app.jar.path")).getCanonicalPath();
//        TEST_KEYVAULT_APP_ZIP_PATH = new File(System.getProperty("keyvault.app.zip.path")).getCanonicalPath();
//        log.info("keyvault.app.jar.path={}", TEST_KEYVAULT_APP_JAR_PATH);
//        log.info("keyvault.app.zip.path={}", TEST_KEYVAULT_APP_ZIP_PATH);
//        log.info("--------------------->resources provision over");
//    }

//    @AfterClass
//    public static void deleteResourceGroup() {
//        final ResourceGroupTool tool = new ResourceGroupTool(access);
//        tool.deleteGroup(resourceGroupName);
//        log.info("--------------------->resources clean over");
//    }

    @Test
    public void keyVaultAsPropertySource() {
        try (AppRunner app = new AppRunner(DumbApp.class)) {
            app.property("azure.keyvault.enabled", "true");
            app.property("azure.keyvault.uri", AZURE_KEYVAULT_ENDPOINT);
            app.property("azure.keyvault.client-id", SPRING_CLIENT_ID);
            app.property("azure.keyvault.client-key", SPRING_CLIENT_SECRET);
            app.property("azure.keyvault.tenant-id", SPRING_TENANT_ID);

            final ConfigurableApplicationContext dummy = app.start("dummy");
            final ConfigurableEnvironment environment = dummy.getEnvironment();
            final MutablePropertySources propertySources = environment.getPropertySources();
            for (final PropertySource<?> propertySource : propertySources) {
                System.out.println("name =  " + propertySource.getName() + "\nsource = " + propertySource
                        .getSource().getClass() + "\n");
            }

            assertEquals(KEY_VAULT_SECRET_VALUE, app.getProperty(KEY_VAULT_SECRET_NAME));
            LOGGER.info("--------------------->test over");
        }
    }

    @Test
    public void keyVaultAsPropertySourceWithSpecificKeys() {
        try (AppRunner app = new AppRunner(DumbApp.class)) {
            app.property("azure.keyvault.enabled", "true");
            app.property("azure.keyvault.uri", AZURE_KEYVAULT_ENDPOINT);
            app.property("azure.keyvault.client-id", SPRING_CLIENT_ID);
            app.property("azure.keyvault.client-key", SPRING_CLIENT_SECRET);
            app.property("azure.keyvault.tenant-id", SPRING_TENANT_ID);
            app.property("azure.keyvault.secret.keys", KEY_VAULT_SECRET_NAME + " , azure-cosmosdb-key");

            app.start();
            assertEquals(KEY_VAULT_SECRET_VALUE, app.getProperty("key"));
            LOGGER.info("--------------------->test over");
        }
    }

//    @Test
   /* public void keyVaultWithAppServiceMSI() {
        final AppServiceTool appServiceTool = new AppServiceTool(access);

        final Map<String, String> appSettings = new HashMap<>();
        appSettings.put("AZURE_KEYVAULT_URI", vault.vaultUri());

        final WebApp appService = appServiceTool.createAppService(resourceGroupName, prefix, appSettings);

        // Grant System Assigned MSI access to key vault
        KeyVaultTool.grantSystemAssignedMSIAccessToKeyVault(vault,
                appService.systemAssignedManagedServiceIdentityPrincipalId());

        // Deploy zip
        // Add retry logic here to avoid Kudu's socket timeout issue.
        // More details: https://github.com/Microsoft/azure-maven-plugins/issues/339
        int retryCount = 0;
        final File zipFile = new File(TEST_KEYVAULT_APP_ZIP_PATH);
        while (retryCount < DEFAULT_MAX_RETRY_TIMES) {
            retryCount += 1;
            try {
                appService.zipDeploy(zipFile);
                log.info(String.format("Successfully deployed the artifact to https://%s",
                        appService.defaultHostName()));
                break;
            } catch (Exception e) {
                log.debug(
                        String.format("Exception occurred when deploying the zip package: %s, " +
                                "retrying immediately (%d/%d)", e.getMessage(), retryCount, DEFAULT_MAX_RETRY_TIMES));
            }
        }

        // Restart App Service
        log.info("restarting app service...");
        appService.restart();
        log.info("restarting app service finished...");

        final String resourceUrl = "https://" + appService.name() + ".azurewebsites.net" + "/get";
        // warm up
        final ResponseEntity<String> response = curlWithRetry(resourceUrl, 3, 120_000, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(KEY_VAULT_SECRET_VALUE, response.getBody());
        log.info("--------------------->test app service with MSI over");
    }

    @Test
    public void keyVaultWithVirtualMachineMSI() throws Exception {
        final VirtualMachineTool vmTool = new VirtualMachineTool(access);

        // create virtual machine
        final VirtualMachine vm = vmTool.createVM(resourceGroupName, prefix, VM_USER_NAME, VM_USER_PASSWORD);
        final String host = vm.getPrimaryPublicIPAddress().ipAddress();

        // Grant System Assigned MSI access to key vault
        KeyVaultTool.grantSystemAssignedMSIAccessToKeyVault(vault,
                vm.systemAssignedManagedServiceIdentityPrincipalId());

        // Upload app.jar to virtual machine
        final File file = new File(TEST_KEYVAULT_APP_JAR_PATH);
        if (!file.exists()) {
            throw new FileNotFoundException("There's no file found on " + TEST_KEYVAULT_APP_JAR_PATH);
        }
        try (SSHShell sshShell = SSHShell.open(host, 22, VM_USER_NAME, VM_USER_PASSWORD);
             FileInputStream fis = new FileInputStream(file)) {

            log.info(String.format("Uploading jar file %s", TEST_KEYVAULT_APP_JAR_PATH));
            sshShell.upload(fis, TEST_KEY_VAULT_JAR_FILE_NAME, "", true, "4095");
        }

        // run java application
        final List<String> commands = new ArrayList<>();
        commands.add(String.format("cd /home/%s", VM_USER_NAME));
        commands.add(
                String.
                format("nohup java -jar -Xdebug " +
                                "-Xrunjdwp:server=y,transport=dt_socket,address=4000,suspend=n " +
                                "-Dazure.keyvault.uri=%s %s &" +
                                " >/log.txt  2>&1"
                        , vault.vaultUri(),
                TEST_KEY_VAULT_JAR_FILE_NAME));
        vmTool.runCommandOnVM(vm, commands);

        final ResponseEntity<String> response = curlWithRetry(
                String.format("http://%s:8080/get", host),
                3,
                60_000,
                String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(KEY_VAULT_SECRET_VALUE, response.getBody());
        log.info("key vault value is: {}", response.getBody());
        log.info("--------------------->test virtual machine with MSI over");
    }

    private static <T> ResponseEntity<T> curlWithRetry(String resourceUrl,
                                                    final int retryTimes,
                                                    int sleepMills,
                                                    Class<T> clazz) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ResponseEntity<T> response = ResponseEntity.of(Optional.empty());
        int rt = retryTimes;

        while (rt-- > 0 && httpStatus != HttpStatus.OK) {
            SdkContext.sleep(sleepMills);

            log.info("CURLing " + resourceUrl);

            try {
                response = restTemplate.getForEntity(resourceUrl, clazz);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

            httpStatus = response.getStatusCode();
        }
        return response;
    }*/

    @SpringBootApplication
    public static class DumbApp {

    }
}
