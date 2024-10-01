package com.groupdocs.examples.assembly.licensing;

import com.groupdocs.assembly.Metered;

/**
 * <p>
 * This example demonstrates how to set Metered license. Learn more about
 * Metered license at <a href="https://purchase.groupdocs.com/faqs/licensing/metered">documentation</a>.
 * </p>
 */
public class SetMeteredLicense {

    public static void run() {
        String publicKey = "*****";
        String privateKey = "*****";
        Metered metered = new Metered();
        metered.setMeteredKey(publicKey, privateKey);
        System.out.println("License set successfully.");
    }
}
