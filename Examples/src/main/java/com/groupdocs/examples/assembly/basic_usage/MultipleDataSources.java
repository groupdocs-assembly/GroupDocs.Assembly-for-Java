package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.assembly.DataSourceInfo;
import com.groupdocs.assembly.DocumentAssembler;
import com.groupdocs.examples.assembly.utils.DataStorage;
import com.groupdocs.examples.assembly.utils.FilesUtils;

import java.nio.file.Path;

public class MultipleDataSources {

    public static Path generateReportInDocumentFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("MultipleDataSources/GenerateReportInDocumentFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(new DataStorage(), null), new DataSourceInfo(DataStorage.excelData(), "contracts"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path generateReportInSpreadsheetFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("MultipleDataSources/GenerateReportInSpreadsheetFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(new DataStorage(), null), new DataSourceInfo(DataStorage.excelData(), "contracts"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path generateReportInPresentationFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("MultipleDataSources/GenerateReportInPresentationFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(new DataStorage(), null), new DataSourceInfo(DataStorage.excelData(), "contracts"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}
