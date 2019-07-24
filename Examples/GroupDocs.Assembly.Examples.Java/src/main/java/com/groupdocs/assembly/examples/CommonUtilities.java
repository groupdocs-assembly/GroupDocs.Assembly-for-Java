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
	public static final String licensePath = "D:/GroupDocs.Total.Java.lic";
	public static final Path dataPath = getProjectBaseDir().resolve("Data/");
	public static final Path storagePath = getProjectBaseDir().resolve("Data/Storage/");
	public static final Path outputPath = getProjectBaseDir().resolve("Data/Output/");
	public static final Path image = getProjectBaseDir().resolve("Data/Images/");
	public static final Path outerDoc = getProjectBaseDir().resolve("Data/OuterDocument/");
	public static final Path wordDataFile = getProjectBaseDir().resolve("Data/Data Sources/Word DataSource/");
	public static final Path excelDataFile = getProjectBaseDir().resolve("Data/Data Sources/Excel DataSource/");
	public static final Path presentationDataFile = getProjectBaseDir().resolve("Data/Data Sources/Presentation DataSource/");
	 public static String publicKey = "[Your Dynabic.Metered public key]";
	 public static String privateKey = "[Your Dynabic.Metered private key]";
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
	 /* This method applies Dynabic Metered license
     *
     * @throws Exception
     */
    public static void useDynabicMeteredAccount() throws Exception {
        // initialize Metered API and set-up credentials
        new com.groupdocs.assembly.Metered().setMeteredKey(publicKey, privateKey);
       
        //Do Something like assembling a document.....
        
        //and get consumption quantity
        double used_quantity = com.groupdocs.assembly.Metered.getConsumptionQuantity();
        
        // get consumption credit (Supported since version 19.7)
        double used_credit = com.groupdocs.assembly.Metered.getConsumptionCredit();
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
	public static String getSourceFolder(String FolderName) throws Exception {
		
		return dataPath + FolderName+"\\";
		
	}

	public static String getDataPath(String fileName) throws Exception {
		//ExStart:getTestDataPath
		return storagePath + fileName;
		//ExEnd:getTestDataPath
	}

	public static String getOutPath(String fileName) throws Exception {
		//ExStart:getTestOutPath
		return outputPath + fileName;
		//ExEnd:getTestOutPath
	}

}
//ExEnd:CommonUtilities
