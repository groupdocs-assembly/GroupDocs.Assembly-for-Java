package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class ScatterChartTests extends TestsSetUp {

    @Test
    public void testGenerateReportInDocumentFormat() {
        final Path outputPath = ScatterChart.generateReportInDocumentFormat(SampleFiles.SCATTER_CHART_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInSpreadsheetFormat() {
        final Path outputPath = ScatterChart.generateReportInSpreadsheetFormat(SampleFiles.SCATTER_CHART_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInPresentationFormat() {
        final Path outputPath = ScatterChart.generateReportInPresentationFormat(SampleFiles.SCATTER_CHART_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInEmailFormat() {
        final Path outputPath = ScatterChart.generateReportInEmailFormat(SampleFiles.SCATTER_CHART_EML);
        Assertions.assertThat(outputPath).exists();
    }
}