package com.groupdocs.examples.assembly.advanced_usage.chart_and_data_visualization;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class GenerateChartWithTests extends TestsSetUp {

    @Test
    public void testFilteringGroupingAndOrderingInDocumentFormat() {
        final Path outputPath = GenerateChartWith.filteringGroupingAndOrderingInDocumentFormat(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testFilteringGroupingAndOrderingInSpreadsheetFormat() {
        final Path outputPath = GenerateChartWith.filteringGroupingAndOrderingInSpreadsheetFormat(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testFilteringGroupingAndOrderingInPresentationFormat() {
        final Path outputPath = GenerateChartWith.filteringGroupingAndOrderingInPresentationFormat(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testFilteringGroupingAndOrderingInEmailFormat() {
        final Path outputPath = GenerateChartWith.filteringGroupingAndOrderingInEmailFormat(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_MSG);
        Assertions.assertThat(outputPath).exists();
    }
}