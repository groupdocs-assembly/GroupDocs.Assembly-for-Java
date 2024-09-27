package com.groupdocs.examples.assembly.licensing;

import com.groupdocs.assembly.License;
import com.groupdocs.examples.assembly.utils.LicenseUtils;

/**
 * <p>
 * This example demonstrates how to set license from file.
 * </p><p>
 * <hr>
 * The SetLicense method attempts to set a license from several locations
 * relative to the executable and GroupDocs.Assembly.dll. You can also use the
 * additional overload to load a license from a stream, this is useful for
 * instance when the License is stored as an embedded resource.
 * </hr></p>
 */
public class SetLicenseFromFile {

    public static void run() {
        final String licensePath = LicenseUtils.obtainLicensePath();
        try {
            if (!LicenseUtils.isUrl(licensePath)) {

                License license = new License();
                license.setLicense(licensePath);

                System.out.println("License set successfully.");
            } else {
                System.out.println(
                        "\nWe do not ship any license with this example. " +
                                "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                                "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                                "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license." +
                                "\nCheck README.md to see how to configure the project to obtain license file"
                );
            }
        } catch (Exception e) {
            System.out.println("License was NOT set.");
            throw new RuntimeException(e);
        }
    }
}
