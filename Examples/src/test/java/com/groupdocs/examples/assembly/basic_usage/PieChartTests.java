package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class PieChartTests extends TestsSetUp {

    @Test
    public void testGenerateReportInDocumentFormat() {
        final Path outputPath = PieChart.generateReportInDocumentFormat(SampleFiles.PIE_CHART_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInSpreadsheetFormat() {
        final Path outputPath = PieChart.generateReportInSpreadsheetFormat(SampleFiles.PIE_CHART_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInPresentationFormat() {
        final Path outputPath = PieChart.generateReportInPresentationFormat(SampleFiles.PIE_CHART_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInEmailFormat() {
        final Path outputPath = PieChart.generateReportInEmailFormat(SampleFiles.PIE_CHART_EML);
        Assertions.assertThat(outputPath).exists();
    }
}