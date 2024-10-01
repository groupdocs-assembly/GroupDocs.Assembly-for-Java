package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class MulticoloredNumberedListTests extends TestsSetUp {

    @Test
    public void testGenerateReportInDocumentFormat() {
        final Path outputPath = MulticoloredNumberedList.generateReportInDocumentFormat(SampleFiles.MULTICOLORED_NUMBERED_LIST_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInSpreadsheetFormat() {
        final Path outputPath = MulticoloredNumberedList.generateReportInSpreadsheetFormat(SampleFiles.MULTICOLORED_NUMBERED_LIST_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInPresentationFormat() {
        final Path outputPath = MulticoloredNumberedList.generateReportInPresentationFormat(SampleFiles.MULTICOLORED_NUMBERED_LIST_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInHtmlFormat() {
        final Path outputPath = MulticoloredNumberedList.generateReportInHtmlFormat(SampleFiles.MULTICOLORED_NUMBERED_LIST_HTML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInEmailFormat() {
        final Path outputPath = MulticoloredNumberedList.generateReportInEmailFormat(SampleFiles.MULTICOLORED_NUMBERED_LIST_EML);
        Assertions.assertThat(outputPath).exists();
    }
}