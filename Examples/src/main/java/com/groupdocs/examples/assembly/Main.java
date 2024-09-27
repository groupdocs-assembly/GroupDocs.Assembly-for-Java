package com.groupdocs.examples.assembly;

import com.groupdocs.examples.assembly.basic_usage.*;
import com.groupdocs.examples.assembly.licensing.SetLicenseFromStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Open `src/main/java/com/groupdocs/examples/assembly/Main.java` file. \nIn runExamples() method uncomment the example that you want to run.");
        System.out.println("=====================================================");

        runExamples();

        System.out.println("\nAll done.");
    }

    public static void runExamples() {
        // TODO: Comment examples which you don't want to run

        { // Licensing
//            SetLicenseFromFile.run();
            SetLicenseFromStream.run();
//            SetMeteredLicense.run();
        }
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
}
