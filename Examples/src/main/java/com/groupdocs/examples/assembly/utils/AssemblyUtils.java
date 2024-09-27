package com.groupdocs.examples.assembly.utils;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class AssemblyUtils {

    public static String getBytesAsBase64(String path) throws Exception {
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            Files.copy(Paths.get(path), stream);

            return Base64.getEncoder().encodeToString(stream.toByteArray());
        }
    }
}
