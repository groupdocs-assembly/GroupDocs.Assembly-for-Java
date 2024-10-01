package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class SingleRowTests extends TestsSetUp {

    @Test
    public void testGenerateReportInDocumentFormat() {
        final Path outputPath = SingleRow.generateReportInDocumentFormat(SampleFiles.SINGLE_ROW_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInSpreadsheetFormat() {
        final Path outputPath = SingleRow.generateReportInSpreadsheetFormat(SampleFiles.SINGLE_ROW_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInPresentationFormat() {
        final Path outputPath = SingleRow.generateReportInPresentationFormat(SampleFiles.SINGLE_ROW_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInHtmlFormat() {
        final Path outputPath = SingleRow.generateReportInHtmlFormat(SampleFiles.SINGLE_ROW_HTML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInTextFormat() {
        final Path outputPath = SingleRow.generateReportInTextFormat(SampleFiles.SINGLE_ROW_TXT);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInEmailFormat() {
        final Path outputPath = SingleRow.generateReportInEmailFormat(SampleFiles.SINGLE_ROW_EML);
        Assertions.assertThat(outputPath).exists();
    }
}