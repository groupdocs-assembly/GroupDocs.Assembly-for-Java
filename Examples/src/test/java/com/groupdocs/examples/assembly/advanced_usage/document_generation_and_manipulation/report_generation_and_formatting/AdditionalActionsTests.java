package com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.report_generation_and_formatting;

import com.groupdocs.assembly.FileFormat;
import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class AdditionalActionsTests extends TestsSetUp {

    @Test
    public void testTemplateSyntaxFormatting() {
        final Path outputPath = AdditionalActions.templateSyntaxFormatting(SampleFiles.NUMERIC_UPPER_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testOuterDocumentInsertion() {
        Path outputPath = AdditionalActions.outerDocumentInsertion(SampleFiles.OUTER_DOC_INSERTION_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testChangeTargetFileFormat() {
        Path outputPath = AdditionalActions.changeTargetFileFormat(SampleFiles.BUBBLE_CHART_DOCX, ".pdf");
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testChangeTargetFileFormatUsingExplicitSpecifying() {
        Path outputPath = AdditionalActions.changeTargetFileFormatUsingExplicitSpecifying(SampleFiles.BUBBLE_CHART_DOCX, FileFormat.PDF);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testRemoveSelectiveChartSeries() {
        Path outputPath = AdditionalActions.removeSelectiveChartSeries(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_REMOVEIF_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testDynamicChartAxisTitleSpreadSheet() {
        Path outputPath = AdditionalActions.dynamicChartAxisTitleSpreadSheet(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_DYNAMIC_TITLE_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testDynamicChartAxisTitleEmail() {
        Path outputPath = AdditionalActions.dynamicChartAxisTitleEmail(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_REPORT_MSG);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testDynamicColor() {
        Path outputPath = AdditionalActions.dynamicColor(SampleFiles.IN_TABLE_LIST_BACKGROUND_COLOR_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testUsingStringTemplate() {
        String outputPath = AdditionalActions.usingStringTemplate("<<[yourValue]>>");
        Assertions.assertThat(outputPath).isNotNull().isNotBlank();
    }

    @Test
    public void testSaveDocToHTMLWithResource() {
        Path outputPath = AdditionalActions.saveDocToHTMLWithResource(SampleFiles.TEST_WORDS_RESOURCE_SAVE_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testSaveWordOrEmailToMarkdownUsingExtension() {
        Path outputPath = AdditionalActions.saveWordOrEmailToMarkdownUsingExtension(SampleFiles.README_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testSaveMarkdownToWordUsingExtension() {
        Path outputPath = AdditionalActions.saveMarkdownToWordUsingExtension(SampleFiles.README_MD);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testSaveWordOrEmailToMarkdownExplicit() {
        Path outputPath = AdditionalActions.saveWordOrEmailToMarkdownExplicit(SampleFiles.README_DOCX);
        Assertions.assertThat(outputPath).exists();
    }
}