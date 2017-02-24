/*
 * Copyright 2010-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package iam.src.main.java.aws.example.iam;

import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder;
import com.amazonaws.services.identitymanagement.model.UpdateServerCertificateRequest;
import com.amazonaws.services.identitymanagement.model.UpdateServerCertificateResult;

/**
 * Updates a server certificate name
 */
public class UpdateServerCertificate {

    public static void main(String[] args) {

        final String USAGE =
            "To run this example, supply the current certificate name and a new name\n" +
            "Ex: UpdateServerCertificate <current-certificate-name> <new-certificate-name>\n";

        if (args.length != 2) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String currentCertificateName = args[0];
        String newCertificateName = args[1];

        final AmazonIdentityManagement iam = AmazonIdentityManagementClientBuilder.defaultClient();

        UpdateServerCertificateRequest request = new UpdateServerCertificateRequest()
            .withServerCertificateName(currentCertificateName)
            .withNewServerCertificateName(newCertificateName);

        UpdateServerCertificateResult response = iam.updateServerCertificate(request);

        System.out.printf("Successfully updated server certificate to name %s", newCertificateName);
    }
}
