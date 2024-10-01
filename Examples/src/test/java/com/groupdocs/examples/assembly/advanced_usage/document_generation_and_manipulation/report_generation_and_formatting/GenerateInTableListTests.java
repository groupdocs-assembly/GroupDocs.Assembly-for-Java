package com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.report_generation_and_formatting;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import com.groupdocs.examples.assembly.basic_usage.BulletedList;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class GenerateInTableListTests extends TestsSetUp {

    @Test
    public void testWithAlternateContentInDocumentFormat() {
        final Path outputPath = GenerateInTableList.withAlternateContentInDocumentFormat(SampleFiles.IN_TABLE_LIST_WITH_ALTERNATE_CONTENT_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWithAlternateContentInSpreadsheetFormat() {
        final Path outputPath = GenerateInTableList.withAlternateContentInSpreadsheetFormat(SampleFiles.IN_TABLE_LIST_WITH_ALTERNATE_CONTENT_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWithAlternateContentInPresentationFormat() {
        final Path outputPath = GenerateInTableList.withAlternateContentInPresentationFormat(SampleFiles.IN_TABLE_LIST_WITH_ALTERNATE_CONTENT_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWithAlternateContentInHtmlFormat() {
        final Path outputPath = GenerateInTableList.withAlternateContentInHtmlFormat(SampleFiles.IN_TABLE_LIST_WITH_ALTERNATE_CONTENT_HTML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWithAlternateContentInEmailFormat() {
        final Path outputPath = GenerateInTableList.withAlternateContentInEmailFormat(SampleFiles.IN_TABLE_LIST_WITH_ALTERNATE_CONTENT_EML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWithFilteringGroupingAndOrderingInDocumentFormat() {
        final Path outputPath = GenerateInTableList.withFilteringGroupingAndOrderingInDocumentFormat(SampleFiles.IN_TABLE_LIST_WITH_FILTERING_GROUPING_AND_ORDERING_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWithFilteringGroupingAndOrderingInSpreadsheetFormat() {
        final Path outputPath = GenerateInTableList.withFilteringGroupingAndOrderingInSpreadsheetFormat(SampleFiles.IN_TABLE_LIST_WITH_FILTERING_GROUPING_AND_ORDERING_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWithFilteringGroupingAndOrderingInPresentationFormat() {
        final Path outputPath = GenerateInTableList.withFilteringGroupingAndOrderingInPresentationFormat(SampleFiles.IN_TABLE_LIST_WITH_FILTERING_GROUPING_AND_ORDERING_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWithFilteringGroupingAndOrderingInHtmlFormat() {
        final Path outputPath = GenerateInTableList.withFilteringGroupingAndOrderingInHtmlFormat(SampleFiles.IN_TABLE_LIST_WITH_FILTERING_GROUPING_AND_ORDERING_HTML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWithFilteringGroupingAndOrderingInEmailFormat() {
        final Path outputPath = GenerateInTableList.withFilteringGroupingAndOrderingInEmailFormat(SampleFiles.IN_TABLE_LIST_WITH_FILTERING_GROUPING_AND_ORDERING_EML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWithHighlightedRowsInDocumentFormat() {
        final Path outputPath = GenerateInTableList.withHighlightedRowsInDocumentFormat(SampleFiles.IN_TABLE_LIST_WITH_HIGHLIGHTED_ROWS_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWithHighlightedRowsInSpreadsheetFormat() {
        final Path outputPath = GenerateInTableList.withHighlightedRowsInSpreadsheetFormat(SampleFiles.IN_TABLE_LIST_WITH_HIGHLIGHTED_ROWS_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWithHighlightedRowsInPresentationFormat() {
        final Path outputPath = GenerateInTableList.withHighlightedRowsInPresentationFormat(SampleFiles.IN_TABLE_LIST_WITH_HIGHLIGHTED_ROWS_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWithHighlightedRowsInHtmlFormat() {
        final Path outputPath = GenerateInTableList.withHighlightedRowsInHtmlFormat(SampleFiles.IN_TABLE_LIST_WITH_HIGHLIGHTED_ROWS_HTML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWithHighlightedRowsInEmailFormat() {
        final Path outputPath = GenerateInTableList.withHighlightedRowsInEmailFormat(SampleFiles.IN_TABLE_LIST_WITH_HIGHLIGHTED_ROWS_EML);
        Assertions.assertThat(outputPath).exists();
    }
}