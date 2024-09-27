package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.assembly.DataSourceInfo;
import com.groupdocs.assembly.DocumentAssembler;
import com.groupdocs.examples.assembly.utils.DataStorage;
import com.groupdocs.examples.assembly.utils.FilesUtils;

import java.nio.file.Path;

public class BulletedList {

    public static Path generateReportInDocumentFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("Bulleted_List/GenerateReportInDocumentFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path generateReportInSpreadsheetFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("Bulleted_List/GenerateReportInSpreadsheetFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path generateReportInPresentationFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("Bulleted_List/GenerateReportInPresentationFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path generateReportInHtmlFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("Bulleted_List/GenerateReportInHtmlFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path generateReportInTextFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("Bulleted_List/GenerateReportInTextFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path generateReportInEmailFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("Bulleted_List/GenerateReportInEmailFormat" + FilesUtils.obtainExtension(inputFile));
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}
