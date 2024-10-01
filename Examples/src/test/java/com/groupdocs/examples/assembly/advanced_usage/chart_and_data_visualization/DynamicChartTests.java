package com.groupdocs.examples.assembly.advanced_usage.chart_and_data_visualization;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.dynamic_content_and_advanced_features.DynamicContent;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class DynamicChartTests extends TestsSetUp {

    @Test
    public void testAxisTitle() {
        final Path outputPath = DynamicChart.axisTitle(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_DYNAMIC_TITLE_DOCX);
        Assertions.assertThat(outputPath).exists();
    }
    @Test
    public void testAxisTitlePresentation() {
        final Path outputPath = DynamicChart.axisTitlePresentation(SampleFiles.CHART_WITH_FILTERING_GROUPING_AND_ORDERING_DYNAMIC_TITLE_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testSeriesColorPresentation() {
        final Path outputPath = DynamicChart.seriesColorPresentation(SampleFiles.DYNAMIC_CHART_SERIES_COLOR_PPTX, SampleFiles.MANAGERS_DATA_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testSeriesPointColorPresentation() {
        final Path outputPath = DynamicChart.seriesPointColorPresentation(SampleFiles.DYNAMIC_CHART_POINT_SERIES_COLOR_PPTX);
        Assertions.assertThat(outputPath).exists();
    }
}