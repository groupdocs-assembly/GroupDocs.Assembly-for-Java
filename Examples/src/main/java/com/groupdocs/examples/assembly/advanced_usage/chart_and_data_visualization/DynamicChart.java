package com.groupdocs.examples.assembly.advanced_usage.chart_and_data_visualization;

import com.groupdocs.assembly.DataSourceInfo;
import com.groupdocs.assembly.DocumentAssembler;
import com.groupdocs.assembly.DocumentTable;
import com.groupdocs.assembly.DocumentTableOptions;
import com.groupdocs.examples.assembly.utils.DataStorage;
import com.groupdocs.examples.assembly.utils.FailureRegister;
import com.groupdocs.examples.assembly.utils.FilesUtils;

import java.nio.file.Path;
import java.util.Objects;

public class DynamicChart {

    public static Path axisTitle(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicChart/AxisTitle" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            String title = "Total Order Quantity by Quarters";
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(new DataStorage(), "orders"),
                    new DataSourceInfo(title, "title"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path axisTitlePresentation(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicChart/AxisTitlePresentation" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            String title = "Total Order Quantity by Quarters";
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(new DataStorage(), "orders"),
                    new DataSourceInfo(title, "title"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path seriesColorPresentation(Path inputFile, Path dataSourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicChart/SeriesColorPresentation" + FilesUtils.obtainExtension(inputFile));
        try {
            String color1 = "blue";
            String color2 = "red";
            // Set table column names to be extracted from the document.
            DocumentTableOptions options = new DocumentTableOptions();
            options.setFirstRowContainsColumnNames(true);

            DocumentTable table = new DocumentTable(dataSourceFile.toString(), 1, options);

            // NOTE: For non-Spreadsheet documents, the type of a document table
            // column is always string by default.
            assert Objects.equals(table.getColumns().get("Total_Contract_Price").getType(), String.class);

            // Change the column's type to double thus enabling to use arithmetic
            // operations on values of the column
            // such as summing in templates.
            table.getColumns().get("Total_Contract_Price").setType(double.class);

            // Pass DocumentTable as a data source.
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(table, "managers"),
                    new DataSourceInfo(color1, "color1"),
                    new DataSourceInfo(color2, "color2"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path seriesPointColorPresentation(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicChart/SeriesPointColorPresentation" + FilesUtils.obtainExtension(inputFile));
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
}
