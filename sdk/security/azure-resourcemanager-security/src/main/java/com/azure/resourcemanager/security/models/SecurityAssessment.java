// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.util.Context;
import com.azure.resourcemanager.security.fluent.models.SecurityAssessmentInner;
import java.util.Map;

/** An immutable client-side representation of SecurityAssessment. */
public interface SecurityAssessment {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the resourceDetails property: Details of the resource that was assessed.
     *
     * @return the resourceDetails value.
     */
    ResourceDetails resourceDetails();

    /**
     * Gets the displayName property: User friendly display name of the assessment.
     *
     * @return the displayName value.
     */
    String displayName();

    /**
     * Gets the status property: The result of the assessment.
     *
     * @return the status value.
     */
    AssessmentStatus status();

    /**
     * Gets the additionalData property: Additional data regarding the assessment.
     *
     * @return the additionalData value.
     */
    Map<String, String> additionalData();

    /**
     * Gets the links property: Links relevant to the assessment.
     *
     * @return the links value.
     */
    AssessmentLinks links();

    /**
     * Gets the metadata property: Describes properties of an assessment metadata.
     *
     * @return the metadata value.
     */
    SecurityAssessmentMetadataProperties metadata();

    /**
     * Gets the partnersData property: Data regarding 3rd party partner integration.
     *
     * @return the partnersData value.
     */
    SecurityAssessmentPartnerData partnersData();

    /**
     * Gets the inner com.azure.resourcemanager.security.fluent.models.SecurityAssessmentInner object.
     *
     * @return the inner object.
     */
    SecurityAssessmentInner innerModel();

    /** The entirety of the SecurityAssessment definition. */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithScope, DefinitionStages.WithCreate {
    }
    /** The SecurityAssessment definition stages. */
    interface DefinitionStages {
        /** The first stage of the SecurityAssessment definition. */
        interface Blank extends WithScope {
        }
        /** The stage of the SecurityAssessment definition allowing to specify parent resource. */
        interface WithScope {
            /**
             * Specifies resourceId.
             *
             * @param resourceId The identifier of the resource.
             * @return the next definition stage.
             */
            WithCreate withExistingResourceId(String resourceId);
        }
        /**
         * The stage of the SecurityAssessment definition which contains all the minimum required properties for the
         * resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate
            extends DefinitionStages.WithResourceDetails,
                DefinitionStages.WithStatus,
                DefinitionStages.WithAdditionalData,
                DefinitionStages.WithMetadata,
                DefinitionStages.WithPartnersData {
            /**
             * Executes the create request.
             *
             * @return the created resource.
             */
            SecurityAssessment create();

            /**
             * Executes the create request.
             *
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            SecurityAssessment create(Context context);
        }
        /** The stage of the SecurityAssessment definition allowing to specify resourceDetails. */
        interface WithResourceDetails {
            /**
             * Specifies the resourceDetails property: Details of the resource that was assessed.
             *
             * @param resourceDetails Details of the resource that was assessed.
             * @return the next definition stage.
             */
            WithCreate withResourceDetails(ResourceDetails resourceDetails);
        }
        /** The stage of the SecurityAssessment definition allowing to specify status. */
        interface WithStatus {
            /**
             * Specifies the status property: The result of the assessment.
             *
             * @param status The result of the assessment.
             * @return the next definition stage.
             */
            WithCreate withStatus(AssessmentStatus status);
        }
        /** The stage of the SecurityAssessment definition allowing to specify additionalData. */
        interface WithAdditionalData {
            /**
             * Specifies the additionalData property: Additional data regarding the assessment.
             *
             * @param additionalData Additional data regarding the assessment.
             * @return the next definition stage.
             */
            WithCreate withAdditionalData(Map<String, String> additionalData);
        }
        /** The stage of the SecurityAssessment definition allowing to specify metadata. */
        interface WithMetadata {
            /**
             * Specifies the metadata property: Describes properties of an assessment metadata..
             *
             * @param metadata Describes properties of an assessment metadata.
             * @return the next definition stage.
             */
            WithCreate withMetadata(SecurityAssessmentMetadataProperties metadata);
        }
        /** The stage of the SecurityAssessment definition allowing to specify partnersData. */
        interface WithPartnersData {
            /**
             * Specifies the partnersData property: Data regarding 3rd party partner integration.
             *
             * @param partnersData Data regarding 3rd party partner integration.
             * @return the next definition stage.
             */
            WithCreate withPartnersData(SecurityAssessmentPartnerData partnersData);
        }
    }
    /**
     * Begins update for the SecurityAssessment resource.
     *
     * @return the stage of resource update.
     */
    SecurityAssessment.Update update();

    /** The template for SecurityAssessment update. */
    interface Update
        extends UpdateStages.WithResourceDetails,
            UpdateStages.WithStatus,
            UpdateStages.WithAdditionalData,
            UpdateStages.WithMetadata,
            UpdateStages.WithPartnersData {
        /**
         * Executes the update request.
         *
         * @return the updated resource.
         */
        SecurityAssessment apply();

        /**
         * Executes the update request.
         *
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        SecurityAssessment apply(Context context);
    }
    /** The SecurityAssessment update stages. */
    interface UpdateStages {
        /** The stage of the SecurityAssessment update allowing to specify resourceDetails. */
        interface WithResourceDetails {
            /**
             * Specifies the resourceDetails property: Details of the resource that was assessed.
             *
             * @param resourceDetails Details of the resource that was assessed.
             * @return the next definition stage.
             */
            Update withResourceDetails(ResourceDetails resourceDetails);
        }
        /** The stage of the SecurityAssessment update allowing to specify status. */
        interface WithStatus {
            /**
             * Specifies the status property: The result of the assessment.
             *
             * @param status The result of the assessment.
             * @return the next definition stage.
             */
            Update withStatus(AssessmentStatus status);
        }
        /** The stage of the SecurityAssessment update allowing to specify additionalData. */
        interface WithAdditionalData {
            /**
             * Specifies the additionalData property: Additional data regarding the assessment.
             *
             * @param additionalData Additional data regarding the assessment.
             * @return the next definition stage.
             */
            Update withAdditionalData(Map<String, String> additionalData);
        }
        /** The stage of the SecurityAssessment update allowing to specify metadata. */
        interface WithMetadata {
            /**
             * Specifies the metadata property: Describes properties of an assessment metadata..
             *
             * @param metadata Describes properties of an assessment metadata.
             * @return the next definition stage.
             */
            Update withMetadata(SecurityAssessmentMetadataProperties metadata);
        }
        /** The stage of the SecurityAssessment update allowing to specify partnersData. */
        interface WithPartnersData {
            /**
             * Specifies the partnersData property: Data regarding 3rd party partner integration.
             *
             * @param partnersData Data regarding 3rd party partner integration.
             * @return the next definition stage.
             */
            Update withPartnersData(SecurityAssessmentPartnerData partnersData);
        }
    }
    /**
     * Refreshes the resource to sync with Azure.
     *
     * @return the refreshed resource.
     */
    SecurityAssessment refresh();

    /**
     * Refreshes the resource to sync with Azure.
     *
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    SecurityAssessment refresh(Context context);
}
