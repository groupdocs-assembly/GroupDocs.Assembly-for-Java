package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.assembly.DataSourceInfo;
import com.groupdocs.assembly.DocumentAssembler;
import com.groupdocs.examples.assembly.utils.AssemblyUtils;
import com.groupdocs.examples.assembly.utils.DataStorage;
import com.groupdocs.examples.assembly.utils.FailureRegister;
import com.groupdocs.examples.assembly.utils.FilesUtils;
import com.groupdocs.examples.assembly.utils.businessentities.Manager;

import java.nio.file.Path;

public class SingleRow {

    public static Path generateReportInDocumentFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("SingleRow/GenerateReportInDocumentFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            Manager manager = new DataStorage().getManagers().iterator().next();
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(manager, "manager"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path generateReportInSpreadsheetFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("SingleRow/GenerateReportInSpreadsheetFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            Manager manager = new DataStorage().getManagers().iterator().next();
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(manager, "manager"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path generateReportInPresentationFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("SingleRow/GenerateReportInPresentationFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            Manager manager = new DataStorage().getManagers().iterator().next();
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(manager, "manager"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path generateReportInHtmlFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("SingleRow/GenerateReportInHtmlFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            Manager manager = new DataStorage().getManagers().iterator().next();
            DocumentAssembler assembler = new DocumentAssembler();
            // This is needed solely for images in HTML documents (Look at 'Resources/SampleFiles/Templates/HtmlTemplates/Single_Row.html' file).
            assembler.getKnownTypes().add(AssemblyUtils.class);
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(manager, "manager"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path generateReportInTextFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("SingleRow/GenerateReportInTextFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            Manager manager = new DataStorage().getManagers().iterator().next();
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(manager, "manager"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path generateReportInEmailFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("SingleRow/GenerateReportInEmailFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DataStorage.EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject(inputFile.toString(), ".eml");
            DataStorage.EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
                    new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
                    new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
                    new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
                    new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
                    new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
