package com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.report_generation_and_formatting;

import com.groupdocs.assembly.DataSourceInfo;
import com.groupdocs.assembly.DocumentAssembler;
import com.groupdocs.examples.assembly.utils.DataStorage;
import com.groupdocs.examples.assembly.utils.FailureRegister;
import com.groupdocs.examples.assembly.utils.FilesUtils;

import java.nio.file.Path;

public class GenerateInTableList {

    public static Path withAlternateContentInDocumentFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithAlternateContentInDocumentFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path withAlternateContentInSpreadsheetFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithAlternateContentInSpreadsheetFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path withAlternateContentInPresentationFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithAlternateContentInPresentationFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path withAlternateContentInHtmlFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithAlternateContentInHtmlFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path withAlternateContentInEmailFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithAlternateContentInEmailFormat" + FilesUtils.obtainExtension(inputFile));
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
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path withFilteringGroupingAndOrderingInDocumentFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithFilteringGroupingAndOrderingInDocumentFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path withFilteringGroupingAndOrderingInSpreadsheetFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithFilteringGroupingAndOrderingInSpreadsheetFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path withFilteringGroupingAndOrderingInPresentationFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithFilteringGroupingAndOrderingInPresentationFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path withFilteringGroupingAndOrderingInHtmlFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithFilteringGroupingAndOrderingInHtmlFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path withFilteringGroupingAndOrderingInEmailFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithFilteringGroupingAndOrderingInEmailFormat" + FilesUtils.obtainExtension(inputFile));
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
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path withHighlightedRowsInDocumentFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithHighlightedRowsInDocumentFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path withHighlightedRowsInSpreadsheetFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithHighlightedRowsInSpreadsheetFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path withHighlightedRowsInPresentationFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithHighlightedRowsInPresentationFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path withHighlightedRowsInHtmlFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithHighlightedRowsInHtmlFormat" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path withHighlightedRowsInEmailFormat(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("GenerateInTableList/WithHighlightedRowsInEmailFormat" + FilesUtils.obtainExtension(inputFile));
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
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}
