package com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.data_handling_and_tables;

import com.groupdocs.assembly.DataSourceInfo;
import com.groupdocs.assembly.DocumentAssembler;
import com.groupdocs.assembly.FileFormat;
import com.groupdocs.assembly.LoadSaveOptions;
import com.groupdocs.examples.assembly.utils.DataStorage;
import com.groupdocs.examples.assembly.utils.FailureRegister;
import com.groupdocs.examples.assembly.utils.FilesUtils;
import com.groupdocs.examples.assembly.utils.businessentities.Manager;

import java.nio.file.Path;

public class TableCellsMerging {
    public static Path inWordProcessing(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("TableCellsMerging/InWordProcessing" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            Manager manager = new DataStorage().getManagers().iterator().next();
            //Call AssembleDocument to Merging Cells Dynamically Report in PDF format
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new LoadSaveOptions(FileFormat.PDF), new DataSourceInfo(manager, "manager"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path inPresentations(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("TableCellsMerging/InPresentations" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            Manager manager = new DataStorage().getManagers().iterator().next();
            //Call AssembleDocument to Merging Cells Dynamically Report in PDF format
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new LoadSaveOptions(FileFormat.PDF), new DataSourceInfo(manager, "manager"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path inSpreadsheets(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("TableCellsMerging/InSpreadsheets" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            Manager manager = new DataStorage().getManagers().iterator().next();
            //Call AssembleDocument to Merging Cells Dynamically Report in PDF format
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new LoadSaveOptions(FileFormat.PDF), new DataSourceInfo(manager, "manager"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path inEmails(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("TableCellsMerging/InEmails" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            //Call AssembleDocument to Merging Cells Dynamically Report in PDF format
            DataStorage.EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject(inputFile.toString(), ".msg");
            DataStorage.EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".msg");
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
