package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class CommonListTests extends TestsSetUp {

    @Test
    public void testGenerateReportInDocumentFormat() {
        final Path outputPath = CommonList.generateReportInDocumentFormat(SampleFiles.COMMON_LIST_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInSpreadsheetFormat() {
        final Path outputPath = CommonList.generateReportInSpreadsheetFormat(SampleFiles.COMMON_LIST_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInPresentationFormat() {
        final Path outputPath = CommonList.generateReportInPresentationFormat(SampleFiles.COMMON_LIST_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInHtmlFormat() {
        final Path outputPath = CommonList.generateReportInHtmlFormat(SampleFiles.COMMON_LIST_HTML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInTextFormat() {
        final Path outputPath = CommonList.generateReportInTextFormat(SampleFiles.COMMON_LIST_TXT);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInEmailFormat() {
        final Path outputPath = CommonList.generateReportInEmailFormat(SampleFiles.COMMON_LIST_EML);
        Assertions.assertThat(outputPath).exists();
    }
}