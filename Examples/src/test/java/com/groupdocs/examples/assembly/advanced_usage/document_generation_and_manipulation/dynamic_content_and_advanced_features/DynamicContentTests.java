package com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.dynamic_content_and_advanced_features;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class DynamicContentTests extends TestsSetUp {

    @Test
    public void testDynamicChartSeriesColorSpreadsheet() {
        final Path outputPath = DynamicContent.dynamicChartSeriesColorSpreadsheet(SampleFiles.DYNAMIC_CHART_SERIES_COLOR_XLSX, SampleFiles.MANAGERS_DATA_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testDynamicChartSeriesColor() {
        final Path outputPath = DynamicContent.dynamicChartSeriesColor(SampleFiles.DYNAMIC_CHART_SERIES_COLOR_DOCX, SampleFiles.MANAGERS_DATA_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testDynamicChartPointSeriesColor() {
        final Path outputPath = DynamicContent.dynamicChartPointSeriesColor(SampleFiles.DYNAMIC_POINT_CHART_SERIES_COLOR_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testDynamicChartSeriesPointColorSpreadsheet() {
        final Path outputPath = DynamicContent.dynamicChartSeriesPointColorSpreadsheet(SampleFiles.DYNAMIC_CHART_SERIES_POINT_COLOR_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testDynamicHyperlinkInsertionWord() {
        final Path outputPath = DynamicContent.dynamicHyperlinkInsertionWord(SampleFiles.DYNAMIC_HYPERLINK_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testDynamicHyperlinkInsertionPresentation() {
        final Path outputPath = DynamicContent.dynamicHyperlinkInsertionPresentation(SampleFiles.DYNAMIC_HYPERLINK_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testDynamicHyperlinkInsertionSpreadsheet() {
        final Path outputPath = DynamicContent.dynamicHyperlinkInsertionSpreadsheet(SampleFiles.DYNAMIC_HYPERLINK_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testDynamicHyperlinkInsertionEmail() {
        final Path outputPath = DynamicContent.dynamicHyperlinkInsertionEmail(SampleFiles.DYNAMIC_HYPERLINK_MSG);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testDynamicBookmarkInsertionWord() {
        final Path outputPath = DynamicContent.dynamicBookmarkInsertionWord(SampleFiles.DYNAMIC_BOOKMARKS_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testDynamicBookmarkInsertionSpreadsheet() {
        final Path outputPath = DynamicContent.dynamicBookmarkInsertionSpreadsheet(SampleFiles.DYNAMIC_CELL_RANGE_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testInsertImageDynamicallyInWord() {
        final Path outputPath = DynamicContent.insertImageDynamicallyInWord(SampleFiles.DYNAMIC_IMAGE_DEMO_DOCX, SampleFiles.NO_PHOTO_JPG);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testInsertDocumentDynamicallyInWord() {
        final Path outputPath = DynamicContent.insertDocumentDynamicallyInWord(SampleFiles.DYNAMIC_DOC_INSERT_DOCX, SampleFiles.OUTER_DOC_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testSetCheckboxValueDynamicallyInWord() {
        final Path outputPath = DynamicContent.setCheckboxValueDynamicallyInWord(SampleFiles.CHECKBOX_VALUE_SET_DEMO_DOCX, true);
        Assertions.assertThat(outputPath).exists();
    }
}