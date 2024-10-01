package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class NumberedListTests extends TestsSetUp {

    @Test
    public void testGenerateReportInDocumentFormat() {
        final Path outputPath = NumberedList.generateReportInDocumentFormat(SampleFiles.NUMBERED_LIST_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInSpreadsheetFormat() {
        final Path outputPath = NumberedList.generateReportInSpreadsheetFormat(SampleFiles.NUMBERED_LIST_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInPresentationFormat() {
        final Path outputPath = NumberedList.generateReportInPresentationFormat(SampleFiles.NUMBERED_LIST_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInHtmlFormat() {
        final Path outputPath = NumberedList.generateReportInHtmlFormat(SampleFiles.NUMBERED_LIST_HTML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInTextFormat() {
        final Path outputPath = NumberedList.generateReportInTextFormat(SampleFiles.NUMBERED_LIST_TXT);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInEmailFormat() {
        final Path outputPath = NumberedList.generateReportInEmailFormat(SampleFiles.NUMBERED_LIST_EML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInDocumentFormatWithRestart() {
        final Path outputPath = NumberedList.generateReportInDocumentFormatWithRestart(SampleFiles.NUMBERED_LIST_RESTART_NUM_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInEmailFormatWithRestart() {
        final Path outputPath = NumberedList.generateReportInEmailFormatWithRestart(SampleFiles.NUMBERED_LIST_RESTART_NUM_MSG);
        Assertions.assertThat(outputPath).exists();
    }
}