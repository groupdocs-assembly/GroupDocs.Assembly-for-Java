package com.groupdocs.examples.assembly;

import com.groupdocs.assembly.FileFormat;
import com.groupdocs.examples.assembly.advanced_usage.chart_and_data_visualization.DynamicChart;
import com.groupdocs.examples.assembly.advanced_usage.chart_and_data_visualization.GenerateChartWith;
import com.groupdocs.examples.assembly.advanced_usage.data_import_export_and_integration.DataOperations;
import com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.data_handling_and_tables.RemainingOperations;
import com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.data_handling_and_tables.TableCellsMerging;
import com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.dynamic_content_and_advanced_features.AdvancedFeatures;
import com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.dynamic_content_and_advanced_features.DynamicContent;
import com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.report_generation_and_formatting.AdditionalActions;
import com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.report_generation_and_formatting.GenerateInTableList;
import com.groupdocs.examples.assembly.basic_usage.*;
import com.groupdocs.examples.assembly.licensing.SetLicenseFromStream;
import com.groupdocs.examples.assembly.utils.FailureRegister;

public class Main {
    public static void main(String[] args) {
        System.out.println("Open `src/main/java/com/groupdocs/examples/assembly/Main.java` file. \nIn runExamples() method uncomment the example that you want to run.");
        System.out.println("=====================================================");

        runExamples();

        final boolean printFailedSamplesStacktrace = System.getenv("PRINT_FAILED_SAMPLES_STACKTRACE") != null;
        FailureRegister.getInstance().printFailedSamples(printFailedSamplesStacktrace);

        System.out.println("\nAll done.");
        System.exit(FailureRegister.getInstance().getFailedSamplesCount());
    }

    public static void runExamples() {
        // TODO: Comment examples which you don't want to run

        { // Licensing
//            SetLicenseFromFile.run();
            SetLicenseFromStream.run();
//            SetMeteredLicense.run();
        }
        { // Basic Usage

            { // Generating Bubble Chart
                BubbleChart.generateReportInDocumentFormat(SampleFiles.BUBBLE_CHART_DOCX);
                BubbleChart.generateReportInSpreadsheetFormat(SampleFiles.BUBBLE_CHART_XLSX);
                BubbleChart.generateReportInPresentationFormat(SampleFiles.BUBBLE_CHART_PPTX);
                BubbleChart.generateReportInEmailFormat(SampleFiles.BUBBLE_CHART_EML);
            }
            { // Generating Bulleted List
                BulletedList.generateReportInDocumentFormat(SampleFiles.BULLETED_LIST_DOCX);
                BulletedList.generateReportInSpreadsheetFormat(SampleFiles.BULLETED_LIST_XLSX);
                BulletedList.generateReportInPresentationFormat(SampleFiles.BULLETED_LIST_PPTX);
                BulletedList.generateReportInHtmlFormat(SampleFiles.BULLETED_LIST_HTML);
                BulletedList.generateReportInTextFormat(SampleFiles.BULLETED_LIST_TXT);
                BulletedList.generateReportInEmailFormat(SampleFiles.BULLETED_LIST_EML);
            }
            { // Generating Common List Report
                CommonList.generateReportInDocumentFormat(SampleFiles.COMMON_LIST_DOCX);
                CommonList.generateReportInSpreadsheetFormat(SampleFiles.COMMON_LIST_XLSX);
                CommonList.generateReportInPresentationFormat(SampleFiles.COMMON_LIST_PPTX);
                CommonList.generateReportInHtmlFormat(SampleFiles.COMMON_LIST_HTML);
                CommonList.generateReportInTextFormat(SampleFiles.COMMON_LIST_TXT);
                CommonList.generateReportInEmailFormat(SampleFiles.COMMON_LIST_EML);
            }
            { // Generating Common Master-Detail Report
                CommonMasterDetail.generateReportInDocumentFormat(SampleFiles.COMMON_MASTER_DETAIL_DOCX);
                CommonMasterDetail.generateReportInSpreadsheetFormat(SampleFiles.COMMON_MASTER_DETAIL_XLSX);
                CommonMasterDetail.generateReportInPresentationFormat(SampleFiles.COMMON_MASTER_DETAIL_PPTX);
                CommonMasterDetail.generateReportInHtmlFormat(SampleFiles.COMMON_MASTER_DETAIL_HTML);
                CommonMasterDetail.generateReportInTextFormat(SampleFiles.COMMON_MASTER_DETAIL_TXT);
                CommonMasterDetail.generateReportInEmailFormat(SampleFiles.COMMON_MASTER_DETAIL_EML);
            }
            { // Generating In-Paragraph List Report
                InParagraphList.generateReportInDocumentFormat(SampleFiles.IN_PARAGRAPH_LIST_DOCX);
                InParagraphList.generateReportInSpreadsheetFormat(SampleFiles.IN_PARAGRAPH_LIST_XLSX);
                InParagraphList.generateReportInPresentationFormat(SampleFiles.IN_PARAGRAPH_LIST_PPTX);
                InParagraphList.generateReportInHtmlFormat(SampleFiles.IN_PARAGRAPH_LIST_HTML);
                InParagraphList.generateReportInTextFormat(SampleFiles.IN_PARAGRAPH_LIST_TXT);
                InParagraphList.generateReportInEmailFormat(SampleFiles.IN_PARAGRAPH_LIST_EML);
            }
            { // Generating In-Table List Report
                InTableList.generateReportInDocumentFormat(SampleFiles.IN_TABLE_LIST_DOCX);
                InTableList.generateReportInSpreadsheetFormat(SampleFiles.IN_TABLE_LIST_XLSX);
                InTableList.generateReportInPresentationFormat(SampleFiles.IN_TABLE_LIST_PPTX);
                InTableList.generateReportInHtmlFormat(SampleFiles.IN_TABLE_LIST_HTML);
                InTableList.generateReportInEmailFormat(SampleFiles.IN_TABLE_LIST_EML);
            }
            { // In-Table Master-Detail
                InTableMasterDetail.generateReportInDocumentFormat(SampleFiles.IN_TABLE_MASTER_DETAIL_DOCX);
                InTableMasterDetail.generateReportInSpreadsheetFormat(SampleFiles.IN_TABLE_MASTER_DETAIL_XLSX);
                InTableMasterDetail.generateReportInPresentationFormat(SampleFiles.IN_TABLE_MASTER_DETAIL_PPTX);
                InTableMasterDetail.generateReportInHtmlFormat(SampleFiles.IN_TABLE_MASTER_DETAIL_HTML);
                InTableMasterDetail.generateReportInEmailFormat(SampleFiles.IN_TABLE_MASTER_DETAIL_EML);
            }
            { // Multicolored Numbered List
                MulticoloredNumberedList.generateReportInDocumentFormat(SampleFiles.MULTICOLORED_NUMBERED_LIST_DOCX);
                MulticoloredNumberedList.generateReportInSpreadsheetFormat(SampleFiles.MULTICOLORED_NUMBERED_LIST_XLSX);
                MulticoloredNumberedList.generateReportInPresentationFormat(SampleFiles.MULTICOLORED_NUMBERED_LIST_PPTX);
                MulticoloredNumberedList.generateReportInHtmlFormat(SampleFiles.MULTICOLORED_NUMBERED_LIST_HTML);
                MulticoloredNumberedList.generateReportInEmailFormat(SampleFiles.MULTICOLORED_NUMBERED_LIST_EML);
            }
            { // Numbered List
                NumberedList.generateReportInDocumentFormat(SampleFiles.NUMBERED_LIST_DOCX);
                NumberedList.generateReportInSpreadsheetFormat(SampleFiles.NUMBERED_LIST_XLSX);
                NumberedList.generateReportInPresentationFormat(SampleFiles.NUMBERED_LIST_PPTX);
                NumberedList.generateReportInHtmlFormat(SampleFiles.NUMBERED_LIST_HTML);
                NumberedList.generateReportInTextFormat(SampleFiles.NUMBERED_LIST_TXT);
                NumberedList.generateReportInEmailFormat(SampleFiles.NUMBERED_LIST_EML);
                NumberedList.generateReportInDocumentFormatWithRestart(SampleFiles.NUMBERED_LIST_RESTART_NUM_DOCX);
                NumberedList.generateReportInEmailFormatWithRestart(SampleFiles.NUMBERED_LIST_RESTART_NUM_MSG);
            }
            { // Pie Chart
                PieChart.generateReportInDocumentFormat(SampleFiles.PIE_CHART_DOCX);
                PieChart.generateReportInSpreadsheetFormat(SampleFiles.PIE_CHART_XLSX);
                PieChart.generateReportInPresentationFormat(SampleFiles.PIE_CHART_PPTX);
                PieChart.generateReportInEmailFormat(SampleFiles.PIE_CHART_EML);
            }
            { // Scatter Chart
                ScatterChart.generateReportInDocumentFormat(SampleFiles.SCATTER_CHART_DOCX);
                ScatterChart.generateReportInSpreadsheetFormat(SampleFiles.SCATTER_CHART_XLSX);
                ScatterChart.generateReportInPresentationFormat(SampleFiles.SCATTER_CHART_PPTX);
                ScatterChart.generateReportInEmailFormat(SampleFiles.SCATTER_CHART_EML);
            }
            { // Single row
                SingleRow.generateReportInDocumentFormat(SampleFiles.SINGLE_ROW_DOCX);
                SingleRow.generateReportInSpreadsheetFormat(SampleFiles.SINGLE_ROW_XLSX);
                SingleRow.generateReportInPresentationFormat(SampleFiles.SINGLE_ROW_PPTX);
                SingleRow.generateReportInHtmlFormat(SampleFiles.SINGLE_ROW_HTML);
                SingleRow.generateReportInTextFormat(SampleFiles.SINGLE_ROW_TXT);
                SingleRow.generateReportInEmailFormat(SampleFiles.SINGLE_ROW_EML);
            }
            { // Barcode Insertion
                BarcodeInsertion.generateReportInDocumentFormat(SampleFiles.BARCODE_INSERTION_DOCX);
                BarcodeInsertion.generateReportInSpreadsheetFormat(SampleFiles.BARCODE_INSERTION_XLSX);
                BarcodeInsertion.generateReportInPresentationFormat(SampleFiles.BARCODE_INSERTION_PPTX);
            }
            { // Generate report from other data sources
                OtherDataSources.useSpreadsheetAsDataSource(SampleFiles.SPREADSHEET_AS_TABLE_OF_DATA_DOCX);
                OtherDataSources.importingWordProcessingTableIntoPresentation(SampleFiles.WORD_PROCESSING_TABLE_PPTX);
                OtherDataSources.usePresentationTableAsDataSource(SampleFiles.PRESENTATION_AS_TABLE_OF_DATA_PPTX);
            }
            { // Multiple Data sources
                MultipleDataSources.generateReportInDocumentFormat(SampleFiles.MULTIPLE_DATA_SOURCES_DOCX);
                MultipleDataSources.generateReportInSpreadsheetFormat(SampleFiles.MULTIPLE_DATA_SOURCES_XLSX);
                MultipleDataSources.generateReportInPresentationFormat(SampleFiles.MULTIPLE_DATA_SOURCES_PPTX);
            }
        }
        { // Advanced Usage

            { // Document Generation and Manipulation

                { // Report Generation and Formatting
                    // Generate in table list with alternate content report in document format
                    GenerateInTableList.withAlternateContentInDocumentFormat(SampleFiles.IN_TABLE_LIST_WITH_ALTERNATE_CONTENT_DOCX);
                    // Generate in table list with alternate content report in spreadsheet format
                    GenerateInTableList.withAlternateContentInSpreadsheetFormat(SampleFiles.IN_TABLE_LIST_WITH_ALTERNATE_CONTENT_XLSX);
                    // Generate in table list with alternate content report in presentation format
                    GenerateInTableList.withAlternateContentInPresentationFormat(SampleFiles.IN_TABLE_LIST_WITH_ALTERNATE_CONTENT_PPTX);
                    // Generate in table list with alternate content report in html format
                    GenerateInTableList.withAlternateContentInHtmlFormat(SampleFiles.IN_TABLE_LIST_WITH_ALTERNATE_CONTENT_HTML);
                    GenerateInTableList.withAlternateContentInEmailFormat(SampleFiles.IN_TABLE_LIST_WITH_ALTERNATE_CONTENT_EML);
                    // Generate in table list with filtering, grouping and order report in document format
                    GenerateInTableList.withFilteringGroupingAndOrderingInDocumentFormat(SampleFiles.IN_TABLE_LIST_WITH_FILTERING_GROUPING_AND_ORDERING_DOCX);
                    // Generate in table list with filtering, grouping and order report in spreadsheet format
                    GenerateInTableList.withFilteringGroupingAndOrderingInSpreadsheetFormat(SampleFiles.IN_TABLE_LIST_WITH_FILTERING_GROUPING_AND_ORDERING_XLSX);
                    // Generate in table list with filtering, grouping and order report in presentation format
                    GenerateInTableList.withFilteringGroupingAndOrderingInPresentationFormat(SampleFiles.IN_TABLE_LIST_WITH_FILTERING_GROUPING_AND_ORDERING_PPTX);
                    // Generate in table list with filtering, grouping and order report in html format
                    GenerateInTableList.withFilteringGroupingAndOrderingInHtmlFormat(SampleFiles.IN_TABLE_LIST_WITH_FILTERING_GROUPING_AND_ORDERING_HTML);
                    GenerateInTableList.withFilteringGroupingAndOrderingInEmailFormat(SampleFiles.IN_TABLE_LIST_WITH_FILTERING_GROUPING_AND_ORDERING_EML);
                    // Generate In-Table List with Highlighted Rows report in document format
                    GenerateInTableList.withHighlightedRowsInDocumentFormat(SampleFiles.IN_TABLE_LIST_WITH_HIGHLIGHTED_ROWS_DOCX);
                    // Generate In-Table List with Highlighted Rows report in spreadsheet format
                    GenerateInTableList.withHighlightedRowsInSpreadsheetFormat(SampleFiles.IN_TABLE_LIST_WITH_HIGHLIGHTED_ROWS_XLSX);
                    // Generate In-Table List with Highlighted Rows report in presentation format
                    GenerateInTableList.withHighlightedRowsInPresentationFormat(SampleFiles.IN_TABLE_LIST_WITH_HIGHLIGHTED_ROWS_PPTX);
                    // Generate In-Table List with Highlighted Rows report in html format
                    GenerateInTableList.withHighlightedRowsInHtmlFormat(SampleFiles.IN_TABLE_LIST_WITH_HIGHLIGHTED_ROWS_HTML);
                    GenerateInTableList.withHighlightedRowsInEmailFormat(SampleFiles.IN_TABLE_LIST_WITH_HIGHLIGHTED_ROWS_EML);
                    // Generate template syntax formatting report in document format
                    AdditionalActions.templateSyntaxFormatting(SampleFiles.NUMERIC_UPPER_DOCX);
                    // Generate report with outer document insertion
                    AdditionalActions.outerDocumentInsertion(SampleFiles.OUTER_DOC_INSERTION_DOCX);
                    // Change target file format using the file extension
                    AdditionalActions.changeTargetFileFormat(SampleFiles.BUBBLE_CHART_DOCX, ".pdf");
                    // Change target file format using explicit specifying
                    AdditionalActions.changeTargetFileFormatUsingExplicitSpecifying(SampleFiles.BUBBLE_CHART_DOCX, FileFormat.PDF);
                    // Ability to remove selective chart series
                    AdditionalActions.removeSelectiveChartSeries(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_REMOVEIF_DOCX);
                    // Dynamic Chart Axis Title in Spreadsheet Document
                    AdditionalActions.dynamicChartAxisTitleSpreadSheet(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_DYNAMIC_TITLE_XLSX);
                    // Dynamic Chart Axis Title in Presentation Document
                    AdditionalActions.dynamicChartAxisTitleEmail(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_REPORT_MSG);
                    // Dynamic Color in wordpressing document
                    AdditionalActions.dynamicColor(SampleFiles.IN_TABLE_LIST_BACKGROUND_COLOR_DOCX);
                    AdditionalActions.usingStringTemplate("<<[yourValue]>>");
                    // Saving of external resource files at relative path
                    AdditionalActions.saveDocToHTMLWithResource(SampleFiles.TEST_WORDS_RESOURCE_SAVE_DOCX);
                    // Saving an assembled Word Processing document or email to Markdown using file extension.
                    AdditionalActions.saveWordOrEmailToMarkdownUsingExtension(SampleFiles.README_DOCX);
                    // Saving an assembled Markdown document to a Word Processing format using file extension.
                    AdditionalActions.saveMarkdownToWordUsingExtension(SampleFiles.README_MD);
                    // Saving an assembled Word Processing document or email to Markdown using explicit specifying.
                    AdditionalActions.saveWordOrEmailToMarkdownExplicit(SampleFiles.README_DOCX);
                }
                { // Data Handling and Tables
                    // Merging table cells dynamically in Word Processing
                    TableCellsMerging.inWordProcessing(SampleFiles.MERGING_CELLS_DYNAMICALLY_DOCX);
                    // Merging table cells dynamically in Presentations
                    TableCellsMerging.inPresentations(SampleFiles.MERGING_CELLS_DYNAMICALLY_PPTX);
                    // Merging table cells dynamically in Spreadsheets
                    TableCellsMerging.inSpreadsheets(SampleFiles.MERGING_CELLS_DYNAMICALLY_XLSX);
                    // Merging table cells dynamically in Email
                    TableCellsMerging.inEmails(SampleFiles.MERGING_CELLS_DYNAMICALLY_MSG);
                    // loading document table with custom options
                    RemainingOperations.loadDocTableSetWithCustomOptions(SampleFiles.MULTIPLE_TABLES_DATA_DOCX);
                    // use document table set as data source
                    RemainingOperations.useDocumentTableSetAsDataSource(SampleFiles.USING_DOCUMENT_TABLE_SET_AS_DATA_SOURCE_PPTX, SampleFiles.MULTIPLE_TABLES_DATA_DOCX);
                    // define relations between doc table instances
                    RemainingOperations.definingDocumentTableRelations(SampleFiles.USING_DOCUMENT_TABLE_RELATIONS_DOCX, SampleFiles.RELATED_TABLES_DATA_XLSX);
                    RemainingOperations.changingDocumentTableColumnType(SampleFiles.CHANGING_DOCUMENT_TABLE_COLUMN_TYPE_PPTX, SampleFiles.MANAGERS_DATA_DOCX);
                    // Working With Table Row DataBands in Word Processing Document
                    RemainingOperations.workingWithTableRowDataBandsWord(SampleFiles.WORKING_WITH_TABLE_ROW_DATA_BANDS_DOCX);
                }
                { // Dynamic Content and Advanced Features
                    // Insert nested external output documents in word
                    AdvancedFeatures.insertNestedExternalDocumentsInWord(SampleFiles.NESTED_EXTERNAL_DOCUMENT_DOCX);
                    // Insert nested external output documents in email
                    AdvancedFeatures.insertNestedExternalDocumentsInEmail(SampleFiles.NESTED_EXTERNAL_DOCUMENT_MSG);
                    AdvancedFeatures.updateWordDocFieldsInSpreadsheet(SampleFiles.UPDATE_FORMULA_XLSX);
                    AdvancedFeatures.loadDocTableSet(SampleFiles.MULTIPLE_TABLES_DATA_DOCX);
                    // Working With Table Row DataBands in SpreadSheet Document
                    AdvancedFeatures.workingWithTableRowDataBandsSpreadSheet(SampleFiles.WORKING_WITH_TABLE_ROW_DATA_BANDS_DOCX);
                    // Working With Table Row DataBands in Presentation Document
                    AdvancedFeatures.workingWithTableRowDataBandsPresentation(SampleFiles.WORKING_WITH_TABLE_ROW_DATA_BANDS_PPTX);
                    // Working With Table Row DataBands in Email Format
                    AdvancedFeatures.workingWithTableRowDataBandsEmail(SampleFiles.WORKING_WITH_TABLE_ROW_DATA_BANDS_MSG);
                    // Sets colors of chart series dynamically based upon expressions word processing document
                    DynamicContent.dynamicChartSeriesColor(SampleFiles.DYNAMIC_CHART_SERIES_COLOR_DOCX, SampleFiles.MANAGERS_DATA_DOCX);
                    // Sets colors of chart series dynamically based upon expressions Spreadsheet document
                    DynamicContent.dynamicChartSeriesColorSpreadsheet(SampleFiles.DYNAMIC_CHART_SERIES_COLOR_XLSX, SampleFiles.MANAGERS_DATA_DOCX);
                    // Sets colors of chart series dynamically based upon expressions email document
                    DynamicContent.dynamicChartSeriesColorEmail(SampleFiles.DYNAMIC_CHART_SERIES_COLOR_MSG, SampleFiles.MANAGERS_DATA_DOCX);
                    // Sets colors of chart series point color dynamically based upon expressions word processing document
                    DynamicContent.dynamicChartPointSeriesColor(SampleFiles.DYNAMIC_POINT_CHART_SERIES_COLOR_DOCX);
                    // Sets colors of chart series point color dynamically based upon expressions spreadsheet document
                    DynamicContent.dynamicChartSeriesPointColorSpreadsheet(SampleFiles.DYNAMIC_CHART_SERIES_POINT_COLOR_XLSX);
                    // Sets colors of chart series point color dynamically based upon expressions email document
                    DynamicContent.dynamicChartSeriesPointColorEmail(SampleFiles.DYNAMIC_CHARTS_POINT_SERIES_COLOR_MSG);
                    // Insert Hyperlink Dynamically in Word Document
                    DynamicContent.dynamicHyperlinkInsertionWord(SampleFiles.DYNAMIC_HYPERLINK_DOCX);
                    // Insert Hyperlink Dynamically in Presentation Document
                    DynamicContent.dynamicHyperlinkInsertionPresentation(SampleFiles.DYNAMIC_HYPERLINK_PPTX);
                    // Insert Hyperlink Dynamically in Spreadsheet Document
                    DynamicContent.dynamicHyperlinkInsertionSpreadsheet(SampleFiles.DYNAMIC_HYPERLINK_XLSX);
                    // Insert Hyperlink Dynamically in Email Document
                    DynamicContent.dynamicHyperlinkInsertionEmail(SampleFiles.DYNAMIC_HYPERLINK_MSG);
                    // Working with word processing document
                    AdvancedFeatures.emptyParagraphInWordProcessing(SampleFiles.EMPTY_PARAGRAPH_DOCX);
                    // Working with presentation document
                    AdvancedFeatures.emptyParagraphInPresentation(SampleFiles.EMPTY_PARAGRAPH_PPTX);
                    // Working with email documents
                    AdvancedFeatures.emptyParagraphInEmail(SampleFiles.EMPTY_PARAGRAPH_MSG);
                    // Demonstrate how to enable in-line syntax errors in the template without throw any exception
                    AdvancedFeatures.demoInLineSyntaxError(SampleFiles.INLINE_ERROR_DEMO_DOCX);
                    // Insert Bookmarks Dynamically in Word Document
                    DynamicContent.dynamicBookmarkInsertionWord(SampleFiles.DYNAMIC_BOOKMARKS_DOCX);
                    // Insert Bookmarks Dynamically in Excel Document
                    DynamicContent.dynamicBookmarkInsertionSpreadsheet(SampleFiles.DYNAMIC_CELL_RANGE_XLSX);
                    // Insert Image Dynamically in Word Document
                    DynamicContent.insertImageDynamicallyInWord(SampleFiles.DYNAMIC_IMAGE_DEMO_DOCX, SampleFiles.NO_PHOTO_JPG);
                    // Insert Document Dynamically in Word Document
                    DynamicContent.insertDocumentDynamicallyInWord(SampleFiles.DYNAMIC_DOC_INSERT_DOCX, SampleFiles.OUTER_DOC_DOCX);
                    // Set checkbox value dynamically in Word document
                    DynamicContent.setCheckboxValueDynamicallyInWord(SampleFiles.CHECKBOX_VALUE_SET_DEMO_DOCX, true);
                }
            }
            { // Chart and Data Visualization
                // Generate chart with filtering grouping and ordering in document word processing format
                GenerateChartWith.filteringGroupingAndOrderingInDocumentFormat(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_DOCX);
                // Generate chart with filtering grouping and ordering in document spreadsheet format
                GenerateChartWith.filteringGroupingAndOrderingInSpreadsheetFormat(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_XLSX);
                // Generate chart with filtering grouping and ordering in presentation format
                GenerateChartWith.filteringGroupingAndOrderingInPresentationFormat(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_PPTX);
                GenerateChartWith.filteringGroupingAndOrderingInEmailFormat(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_MSG);
                // Dynamic Chart Axis Title
                DynamicChart.axisTitle(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_DYNAMIC_TITLE_DOCX);
                // Dynamic Chart Axis Title in Presentation Document
                DynamicChart.axisTitlePresentation(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_DYNAMIC_TITLE_PPTX);
                // Sets colors of chart series dynamically based upon expressions presentation document
                DynamicChart.seriesColorPresentation(SampleFiles.DYNAMIC_CHART_SERIES_COLOR_PPTX, SampleFiles.MANAGERS_DATA_DOCX);
                // Sets colors of chart series point color dynamically based upon expressions presentation document
                DynamicChart.seriesPointColorPresentation(SampleFiles.DYNAMIC_CHART_POINT_SERIES_COLOR_PPTX);
            }

            { // Data Import, Export, and Integration
                DataOperations.importingSpreadsheetIntoHtml(SampleFiles.IMPORTING_SPREADSHEET_INTO_HTML_DOCUMENT_HTML, SampleFiles.CONTRACTS_DATA_XLSX);
                // Loading of template documents from HTML with resources
                DataOperations.loadDocFromHTMLWithResource(SampleFiles.TEST_WORDS_RESOURCE_LOAD_HTM);
                // Loading of template documents from HTML with resources from an explicitly specified folder
                DataOperations.loadDocFromHTMLWithResourceExplicitFolder(SampleFiles.TEST_WORDS_RESOURCE_LOAD_HTM);
                // Saving of external resource files in a specified folder at relative path while saving output to HTML
                DataOperations.saveDocToHTMLWithResourceExplicitFolder(SampleFiles.TEST_WORDS_RESOURCE_SAVE_DOCX);
                // Working with XML data sources.
                DataOperations.simpleXML(SampleFiles.SIMPLE_DATASET_DEMO_DOCX, SampleFiles.MANAGERS_XML);
                // Working with CSV data sources.
                DataOperations.simpleCsv(SampleFiles.CSV_DATASET_DEMO_TXT, SampleFiles.PERSONS_CSV);
                // Working with Json Data Source
                DataOperations.simpleJson(SampleFiles.SIMPLE_DATASET_DEMO_DOCX, SampleFiles.MANAGER_DATA_JSON);
            }
        }
    }
}
