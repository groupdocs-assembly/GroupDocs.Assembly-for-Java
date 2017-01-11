package com.groupdocs.assembly.examples;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

import com.groupdocs.assembly.License;

//ExStart:CommonUtilities
public class CommonUtilities {
	//ExStart:commonPaths
	public static final String licensePath = "D:/GroupDocs.Assembly Product Family.lic";
	public static final Path storagePath = getProjectBaseDir().resolve("Data/Storage/");
	public static final Path outputPath = getProjectBaseDir().resolve("Data/Output/");
	public static final Path image = getProjectBaseDir().resolve("Data/Images/");
	public static final Path outerDoc = getProjectBaseDir().resolve("Data/OuterDocument/");
	public static final Path wordDataFile = getProjectBaseDir().resolve("Data/Data Sources/Word DataSource/Managers Data.docx");
	public static final Path excelDataFile = getProjectBaseDir().resolve("Data/Data Sources/Excel DataSource/");
	public static final Path presentationDataFile = getProjectBaseDir().resolve("Data/Data Sources/Word DataSource/Managers Data.pptx");
	//ExEnd:commonPaths

	public static void applyLicense() {
		//ExStart:applyLicense
		try {
			// Setup license
			License lic = new License();
			lic.setLicense(licensePath);
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
		}
		//ExEnd:applyLicense
	}

	public static Path getProjectBaseDir() {
		//ExStart:getProjectBaseDir
		Properties props = new Properties();
		try {
			InputStream i = CommonUtilities.class.getResourceAsStream("/project.properties");
			props.load(i);
		} catch (IOException x) {
			throw new RuntimeException(x);
		}
		return FileSystems.getDefault().getPath(props.getProperty("project.basedir"));
		//ExEnd:getProjectBaseDir
	}

	public static String getTestDataPath(String fileName) throws Exception {
		//ExStart:getTestDataPath
		return storagePath + fileName;
		//ExEnd:getTestDataPath
	}

	public static String getTestOutPath(String fileName) throws Exception {
		//ExStart:getTestOutPath
		return outputPath + fileName;
		//ExEnd:getTestOutPath
	}

}
//ExEnd:CommonUtilities
