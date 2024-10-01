package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class MultipleDataSourcesTests extends TestsSetUp {

    @Test
    public void testGenerateReportInDocumentFormat() {
        final Path outputPath = MultipleDataSources.generateReportInDocumentFormat(SampleFiles.MULTIPLE_DATA_SOURCES_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInSpreadsheetFormat() {
        final Path outputPath = MultipleDataSources.generateReportInSpreadsheetFormat(SampleFiles.MULTIPLE_DATA_SOURCES_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInPresentationFormat() {
        final Path outputPath = MultipleDataSources.generateReportInPresentationFormat(SampleFiles.MULTIPLE_DATA_SOURCES_PPTX);
        Assertions.assertThat(outputPath).exists();
    }
}