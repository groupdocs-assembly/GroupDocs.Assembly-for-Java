package com.groupdocs.assembly.examples;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class FileUtil {
	 public static String getBytesAsBase64(String path) throws Exception
     {
         ByteArrayOutputStream stream = new ByteArrayOutputStream();
         Files.copy(Paths.get(path), stream);

         return Base64.getEncoder().encodeToString(stream.toByteArray());
     }
}
