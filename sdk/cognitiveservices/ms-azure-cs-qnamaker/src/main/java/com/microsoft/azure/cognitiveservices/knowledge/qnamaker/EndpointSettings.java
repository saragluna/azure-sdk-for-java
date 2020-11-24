/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.knowledge.qnamaker;

import com.microsoft.azure.cognitiveservices.knowledge.qnamaker.models.EndpointSettingsDTO;
import com.microsoft.azure.cognitiveservices.knowledge.qnamaker.models.EndpointSettingsDTOActiveLearning;
import com.microsoft.azure.cognitiveservices.knowledge.qnamaker.models.ErrorResponseException;
import com.microsoft.azure.cognitiveservices.knowledge.qnamaker.models.UpdateSettingsOptionalParameter;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in EndpointSettings.
 */
public interface EndpointSettings {

    /**
     * Gets endpoint settings for an endpoint.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the EndpointSettingsDTO object if successful.
     */
    EndpointSettingsDTO getSettings();

    /**
     * Gets endpoint settings for an endpoint.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the EndpointSettingsDTO object
     */
    Observable<EndpointSettingsDTO> getSettingsAsync();


    /**
     * Updates endpoint settings for an endpoint.
     *
     * @param updateSettingsOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    void updateSettings(UpdateSettingsOptionalParameter updateSettingsOptionalParameter);

    /**
     * Updates endpoint settings for an endpoint.
     *
     * @param updateSettingsOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return a representation of the deferred computation of this call if successful.
     */
    Observable<Void> updateSettingsAsync(UpdateSettingsOptionalParameter updateSettingsOptionalParameter);

    /**
     * Updates endpoint settings for an endpoint.
     *
     * @return the first stage of the updateSettings call
     */
    EndpointSettingsUpdateSettingsDefinitionStages.WithExecute updateSettings();

    /**
     * Grouping of updateSettings definition stages.
     */
    interface EndpointSettingsUpdateSettingsDefinitionStages {

        /**
         * The stage of the definition which allows for any other optional settings to be specified.
         */
        interface WithAllOptions {
            /**
             * Active Learning settings of the endpoint.
             *
             * @return next definition stage
             */
            EndpointSettingsUpdateSettingsDefinitionStages.WithExecute withActiveLearning(EndpointSettingsDTOActiveLearning activeLearning);

        }

        /**
         * The last stage of the definition which will make the operation call.
        */
        interface WithExecute extends EndpointSettingsUpdateSettingsDefinitionStages.WithAllOptions {
            /**
             * Execute the request.
             *
             */
            void execute();

            /**
             * Execute the request asynchronously.
             *
             * @return a representation of the deferred computation of this call if successful.
             */
            Observable<Void> executeAsync();
        }
    }

    /**
     * The entirety of updateSettings definition.
     */
    interface EndpointSettingsUpdateSettingsDefinition extends
        EndpointSettingsUpdateSettingsDefinitionStages.WithExecute {
    }

}
