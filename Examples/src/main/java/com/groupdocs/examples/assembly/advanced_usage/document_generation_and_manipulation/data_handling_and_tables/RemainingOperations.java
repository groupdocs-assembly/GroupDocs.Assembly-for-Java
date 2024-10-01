package com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.data_handling_and_tables;

import com.groupdocs.assembly.*;
import com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.data_handling_and_tables.handlers.ColumnNameExtractingDocumentTableLoadHandler;
import com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.data_handling_and_tables.handlers.CustomDocumentTableLoadHandler;
import com.groupdocs.examples.assembly.utils.DataStorage;
import com.groupdocs.examples.assembly.utils.FailureRegister;
import com.groupdocs.examples.assembly.utils.FilesUtils;

import java.nio.file.Path;

public class RemainingOperations {
    public static DocumentTableSet loadDocTableSetWithCustomOptions(Path inputFile) {
        try {
            // Load document tables using custom options.
            DocumentTableSet tableSet = new DocumentTableSet(inputFile.toString(), new CustomDocumentTableLoadHandler());

            // Ensure that the second table is not loaded.
            assert tableSet.getTables().getCount() == 2;
            assert tableSet.getTables().get(0).getName().equals("Table1");
            assert tableSet.getTables().get(1).getName().equals("Table3");

            // Ensure that default options are used to load the first table (that
            // is, default column names are used).
            assert tableSet.getTables().get(0).getColumns().getCount() == 2;
            assert tableSet.getTables().get(0).getColumns().get(0).getName().equals("Column1");
            assert tableSet.getTables().get(0).getColumns().get(1).getName().equals("Column2");

            // Ensure that custom options are used to load the third table (that is,
            // column names are extracted).
            assert tableSet.getTables().get(1).getColumns().getCount() == 2;
            assert tableSet.getTables().get(1).getColumns().get(0).getName().equals("Name");
            assert tableSet.getTables().get(1).getColumns().get(1).getName().equals("Address");

            return tableSet;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }

    public static Path useDocumentTableSetAsDataSource(Path inputFile, Path dataSourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("RemainingOperations/UseDocumentTableSetAsDataSource" + FilesUtils.obtainExtension(inputFile));
        try {
            // Set table column names to be extracted from the document.
            DocumentTableSet tableSet = new DocumentTableSet(dataSourceFile.toString(), new ColumnNameExtractingDocumentTableLoadHandler());

            // Set table names for convenience.
            tableSet.getTables().get(0).setName("Planets");
            tableSet.getTables().get(1).setName("Persons");
            tableSet.getTables().get(2).setName("Companies");

            // Pass DocumentTableSet as a data source.
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(tableSet));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path definingDocumentTableRelations(Path inputFile, Path dataSourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("RemainingOperations/DefiningDocumentTableRelations" + FilesUtils.obtainExtension(inputFile));
        try {
            // Set table column names to be extracted from the document.
            DocumentTableSet tableSet = new DocumentTableSet(dataSourceFile.toString(), new ColumnNameExtractingDocumentTableLoadHandler());

            // Define relations between tables.
            // NOTE: For Spreadsheet documents, table names are extracted from sheet names.
            tableSet.getRelations().add(tableSet.getTables().get("CLIENT").getColumns().get("ID"),
                    tableSet.getTables().get("CONTRACT").getColumns().get("CLIENT_ID"));

            tableSet.getRelations().add(tableSet.getTables().get("MANAGER").getColumns().get("ID"),
                    tableSet.getTables().get("CONTRACT").getColumns().get("MANAGER_ID"));

            // Pass DocumentTableSet as a data source.
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(tableSet));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path changingDocumentTableColumnType(Path inputFile, Path dataSourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("RemainingOperations/ChangingDocumentTableColumnType" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentTableOptions options = new DocumentTableOptions();
            options.setFirstRowContainsColumnNames(true);

            DocumentTable table = new DocumentTable(dataSourceFile.toString(), 1, options);

            // NOTE: For non-Spreadsheet documents, the type of document table
            // column is always string by default.
            assert table.getColumns().get("Total_Contract_Price").getType() == String.class;

            // Change the column's type to double thus enabling to use arithmetic
            // operations on values of the column
            // such as summing in templates.
            table.getColumns().get("Total_Contract_Price").setType(double.class);

            // Pass DocumentTable as a data source.
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(table, "Managers"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path workingWithTableRowDataBandsWord(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("RemainingOperations/WorkingWithTableRowDataBandsWord" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(new DataStorage(), null),
                    new DataSourceInfo(DataStorage.excelData(), "ds"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}
