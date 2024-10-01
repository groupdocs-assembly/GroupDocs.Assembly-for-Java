package com.groupdocs.examples.assembly.advanced_usage.chart_and_data_visualization;

import com.groupdocs.assembly.DataSourceInfo;
import com.groupdocs.assembly.DocumentAssembler;
import com.groupdocs.examples.assembly.utils.DataStorage;
import com.groupdocs.examples.assembly.utils.FailureRegister;
import com.groupdocs.examples.assembly.utils.FilesUtils;

import java.nio.file.Path;

public class GenerateChartWith {

    public static Path filteringGroupingAndOrderingInDocumentFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateChartWith/FilteringGroupingAndOrderingInDocumentFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path filteringGroupingAndOrderingInSpreadsheetFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateChartWith/FilteringGroupingAndOrderingInSpreadsheetFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path filteringGroupingAndOrderingInPresentationFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateChartWith/FilteringGroupingAndOrderingInPresentationFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path filteringGroupingAndOrderingInEmailFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateChartWith/FilteringGroupingAndOrderingInEmailFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DataStorage.EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject(inputFile.toString(), ".msg");
            DataStorage.EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".msg");
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
                    new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
                    new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
                    new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
                    new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
                    new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}
