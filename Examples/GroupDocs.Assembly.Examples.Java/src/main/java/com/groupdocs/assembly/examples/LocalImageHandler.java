package com.groupdocs.assembly.examples;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.groupdocs.assembly.ExternalResourceHandler;
import com.groupdocs.assembly.ExternalResourceLoadingArgs;
import com.groupdocs.assembly.ExternalResourceOrigin;

//ExStart:LocalImageHandler
/**
 * Sees every decision about an external resource and provides the content of the allowed ones
 * itself, from a local file, so the example needs no network access.
 * Feature is supported by version 26.11 or greater
 */
public class LocalImageHandler extends ExternalResourceHandler {

	private final String mImagePath;

	public LocalImageHandler(String imagePath) {
		mImagePath = imagePath;
	}

	@Override
	public void onLoading(ExternalResourceLoadingArgs args) {
		System.out.println(ExternalResourceOrigin.toString(args.getOrigin()) + " resource " + args.getUri() + ": "
				+ (args.isSkipped() ? "skipped" : "allowed"));

		// Provide the content instead of requesting it.
		if (!args.isSkipped() && args.getUri().toLowerCase().startsWith("https://images.example.com/")) {
			try {
				args.setData(Files.readAllBytes(Paths.get(mImagePath)));
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
	}
}
//ExEnd:LocalImageHandler
