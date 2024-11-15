package com.groupdocs.examples.assembly.advanced_usage.data_import_export_and_integration;

import com.groupdocs.assembly.*;
import com.groupdocs.examples.assembly.utils.AssemblyUtils;
import com.groupdocs.examples.assembly.utils.FailureRegister;
import com.groupdocs.examples.assembly.utils.FilesUtils;

import java.nio.file.Path;
import java.util.Objects;

public class DataOperations {

    public static Path importingSpreadsheetIntoHtml(Path inputFile, Path dataSourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DataOperations/ImportingSpreadsheetIntoHtml" + FilesUtils.obtainExtension(inputFile));
        try {
            // Use data of the _first_ worksheet.
            // Do not extract column names from the first row, so the names to be
            // imported as well.
            DocumentTable table = new DocumentTable(dataSourceFile.toString(), 0);
            // Check column count, names, and types.
            assert table.getColumns().getCount() == 3;
            assert table.getColumns().get(0).getName().equals("A");
            assert Objects.equals(table.getColumns().get(0).getType(), String.class);
            assert table.getColumns().get(1).getName().equals("B");
            assert Objects.equals(table.getColumns().get(1).getType(), String.class);
            assert table.getColumns().get(2).getName().equals("C");
            assert Objects.equals(table.getColumns().get(2).getType(), String.class);
            // testCore(sourceTemplate, table, "table");
            DocumentAssembler assembler = new DocumentAssembler();
            // This is needed solely for images in HTML documents.
            assembler.getKnownTypes().add(AssemblyUtils.class);
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(table, "table"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path loadDocFromHTMLWithResource(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DataOperations/LoadDocFromHTMLWithResource" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();

            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo("It should be a jeep image.", "value"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path loadDocFromHTMLWithResourceExplicitFolder(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DataOperations/LoadDocFromHTMLWithResourceExplicitFolder" + FilesUtils.obtainExtension(inputFile));
        final Path alternativeInputResourcesPath = inputFile.getParent().resolve("Alternative");
        try {
            DocumentAssembler assembler = new DocumentAssembler();

            LoadSaveOptions loadSaveOptions = new LoadSaveOptions();
            loadSaveOptions.setResourceLoadBaseUri(alternativeInputResourcesPath.toString());

            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    loadSaveOptions, new DataSourceInfo("It should be a sport car image.", "value"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path saveDocToHTMLWithResourceExplicitFolder(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DataOperations/SaveDocToHTMLWithResourceExplicitFolder.html");
        final Path alternativeInputResourcesPath = inputFile.getParent().resolve("Alternative");
        try {
            DocumentAssembler assembler = new DocumentAssembler();

            LoadSaveOptions loadSaveOptions = new LoadSaveOptions();
            loadSaveOptions.setResourceSaveFolder(alternativeInputResourcesPath.toString());

            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), loadSaveOptions,
                    new DataSourceInfo("Hello!", "value"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path simpleXML(Path inputFile, Path dataSourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DataOperations/SimpleXML" + FilesUtils.obtainExtension(inputFile));
        try {

            DocumentAssembler assembler = new DocumentAssembler();

            XmlDataSource datasource = new XmlDataSource(dataSourceFile.toString());

            DataSourceInfo dataSourceInfo = new DataSourceInfo(datasource, "managers");


            //Assemble document
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), dataSourceInfo);

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path simpleCsv(Path inputFile, Path dataSourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DataOperations/SimpleCsv" + FilesUtils.obtainExtension(inputFile));
        try {
            //set load csv by column name
            CsvDataLoadOptions options = new CsvDataLoadOptions(true);

            CsvDataSource datasource = new CsvDataSource(dataSourceFile.toString(), options);

            DataSourceInfo dataSourceInfo = new DataSourceInfo(datasource, "persons");

            //Instantiate DocumentAssembler class
            DocumentAssembler assembler = new DocumentAssembler();

            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), dataSourceInfo);

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path simpleJson(Path inputFile, Path dataSourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DataOperations/SimpleJson" + FilesUtils.obtainExtension(inputFile));
        try {

            //Instantiate Json data source
            JsonDataSource datasource = new JsonDataSource(dataSourceFile.toString());

            DataSourceInfo dataSourceInfo = new DataSourceInfo(datasource, "managers");

            //Instantiate DocumentAssembler class
            DocumentAssembler assembler = new DocumentAssembler();

            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), dataSourceInfo);

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
