package com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.dynamic_content_and_advanced_features;

import com.groupdocs.assembly.DataSourceInfo;
import com.groupdocs.assembly.DocumentAssembler;
import com.groupdocs.assembly.DocumentTable;
import com.groupdocs.assembly.DocumentTableOptions;
import com.groupdocs.examples.assembly.utils.DataStorage;
import com.groupdocs.examples.assembly.utils.FailureRegister;
import com.groupdocs.examples.assembly.utils.FilesUtils;

import java.nio.file.Path;
import java.util.Objects;

public class DynamicContent {
    public static Path dynamicChartSeriesColor(Path inputFile, Path dataSourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/DynamicChartSeriesColor" + FilesUtils.obtainExtension(inputFile));
        try {
            //Define series color
            String color1 = "blue";
            String color2 = "red";
            // Set table column names to be extracted from the document.
            DocumentTableOptions options = new DocumentTableOptions();
            options.setFirstRowContainsColumnNames(true);

            DocumentTable table = new DocumentTable(dataSourceFile.toString(), 1, options);

            // NOTE: For non-Spreadsheet documents, the type of document table
            // column is always string by default.
            assert Objects.equals(table.getColumns().get("Total_Contract_Price").getType(), String.class);

            // Change the column's type to double thus enabling to use arithmetic
            // operations on values of the column
            // such as summing in templates.
            table.getColumns().get("Total_Contract_Price").setType(double.class);

            // Pass DocumentTable as a data source.
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(table, "managers"), new DataSourceInfo(color1, "color1"), new DataSourceInfo(color2, "color2"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path dynamicChartSeriesColorSpreadsheet(Path inputFile, Path dataSourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/DynamicChartSeriesColorSpreadsheet" + FilesUtils.obtainExtension(inputFile));
        try {
            //Define series color
            String color1 = "blue";
            String color2 = "red";
            // Set table column names to be extracted from the document.
            DocumentTableOptions options = new DocumentTableOptions();
            options.setFirstRowContainsColumnNames(true);

            DocumentTable table = new DocumentTable(dataSourceFile.toString(), 1, options);

            // NOTE: For non-Spreadsheet documents, the type of document table
            // column is always string by default.
            assert Objects.equals(table.getColumns().get("Total_Contract_Price").getType(), String.class);

            // Change the column's type to double thus enabling to use arithmetic
            // operations on values of the column
            // such as summing in templates.
            table.getColumns().get("Total_Contract_Price").setType(double.class);

            // Pass DocumentTable as a data source.
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(table, "managers"), new DataSourceInfo(color1, "color1"), new DataSourceInfo(color2, "color2"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path dynamicChartSeriesColorEmail(Path inputFile, Path dataSourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/DynamicChartSeriesColorEmail" + FilesUtils.obtainExtension(inputFile));
        try {
            //Define series color
            String color = "blue";
            // Set table column names to be extracted from the document.
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
            DocumentAssembler.setUseReflectionOptimization(false);
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(table, "managers"), new DataSourceInfo(color, "color"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path dynamicChartPointSeriesColor(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/DynamicChartPointSeriesColor" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path dynamicChartSeriesPointColorSpreadsheet(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/DynamicChartSeriesPointColorSpreadsheet" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path dynamicChartSeriesPointColorEmail(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/DynamicChartSeriesPointColorEmail" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path dynamicHyperlinkInsertionWord(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/DynamicHyperlinkInsertionWord" + FilesUtils.obtainExtension(inputFile));
        try {
            final String uriExpression = "https://www.groupdocs.com/";
            final String displayTextExpression = "GroupDocs";

            DocumentAssembler assembler = new DocumentAssembler();
            //Call AssembleDocument to assemble document
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(uriExpression, "uriExpression"), new DataSourceInfo(displayTextExpression, "displayTextExpression"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path dynamicHyperlinkInsertionPresentation(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/DynamicHyperlinkInsertionPresentation" + FilesUtils.obtainExtension(inputFile));
        try {
            String uriExpression = "https://www.groupdocs.com/";
            String displayTextExpression = "GroupDocs";

            DocumentAssembler assembler = new DocumentAssembler();
            //Call AssembleDocument to assemble document
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(uriExpression, "uriExpression"), new DataSourceInfo(displayTextExpression, "displayTextExpression"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path dynamicHyperlinkInsertionSpreadsheet(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/DynamicHyperlinkInsertionSpreadsheet" + FilesUtils.obtainExtension(inputFile));
        try {
            String uriExpression = "https://www.groupdocs.com/";
            String displayTextExpression = "GroupDocs";

            DocumentAssembler assembler = new DocumentAssembler();
            //Call AssembleDocument to assemble document
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(uriExpression, "uriExpression"), new DataSourceInfo(displayTextExpression, "displayTextExpression"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path dynamicHyperlinkInsertionEmail(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/DynamicHyperlinkInsertionEmail" + FilesUtils.obtainExtension(inputFile));
        try {
            String uriExpression = "https://www.groupdocs.com/";
            String displayTextExpression = "GroupDocs";

            DocumentAssembler assembler = new DocumentAssembler();
            //Call AssembleDocument to assemble document
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(uriExpression, "uriExpression"), new DataSourceInfo(displayTextExpression, "displayTextExpression"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path dynamicBookmarkInsertionWord(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/DynamicBookmarkInsertionWord" + FilesUtils.obtainExtension(inputFile));
        try {
            final String bookmark_expression = "gd_bookmark";
            final String displayTextExpression = "GroupDocs";

            DocumentAssembler assembler = new DocumentAssembler();

            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(bookmark_expression, "bookmark_expression"), new DataSourceInfo(displayTextExpression, "displayTextExpression"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path dynamicBookmarkInsertionSpreadsheet(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/DynamicBookmarkInsertionSpreadsheet" + FilesUtils.obtainExtension(inputFile));
        try {
            final String bookmark_expression = "gd_bookmark";
            final String displayTextExpression = "GroupDocs";

            DocumentAssembler assembler = new DocumentAssembler();

            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(bookmark_expression, "bookmark_expression"), new DataSourceInfo(displayTextExpression, "displayTextExpression"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path insertImageDynamicallyInWord(Path inputFile, Path dataSourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/InsertImageDynamicallyInWord" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();

            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(dataSourceFile.toString(), "image_expression"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path insertDocumentDynamicallyInWord(Path inputFile, Path dataSourceFile) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/InsertDocumentDynamicallyInWord" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();

            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(dataSourceFile.toString(), "document_expression"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path setCheckboxValueDynamicallyInWord(Path inputFile, Boolean enable) {
        final Path outputPath = FilesUtils.makeOutputPath("DynamicContent/SetCheckboxValueDynamicallyInWord" + (enable ? "Enabled" : "Disabled") + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();

            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(enable, "conditional_expression"));

            System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
