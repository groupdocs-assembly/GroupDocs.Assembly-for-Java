package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.assembly.DataSourceInfo;
import com.groupdocs.assembly.DocumentAssembler;
import com.groupdocs.examples.assembly.utils.DataStorage;
import com.groupdocs.examples.assembly.utils.FailureRegister;
import com.groupdocs.examples.assembly.utils.FilesUtils;

import java.nio.file.Path;

public class BarcodeInsertion {

    /**
     * Data storage ({@link  DataStorage}) has method {@link  DataStorage#getManagers()} which will be used during assembling process.
     */
    public static Path generateReportInDocumentFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("BarcodeInsertion/GenerateReportInDocumentFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            // Setting up data set, Method DataStorage().getManagers().iterator().next()  is defined here : https://docs.groupdocs.com/display/assemblyjava/The+Business+Layer#TheBusinessLayer-DataStorageClass
            DocumentAssembler assembler = new DocumentAssembler();
            //Call AssembleDocument to generate   Report in open document format
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(new DataStorage().getManagers().iterator().next(), "value"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path generateReportInSpreadsheetFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("BarcodeInsertion/GenerateReportInSpreadsheetFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo("854283", "value"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path generateReportInPresentationFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("BarcodeInsertion/GenerateReportInPresentationFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo("854283", "value"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
