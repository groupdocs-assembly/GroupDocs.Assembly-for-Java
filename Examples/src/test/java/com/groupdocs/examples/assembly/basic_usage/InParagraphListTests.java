package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class InParagraphListTests extends TestsSetUp {

    @Test
    public void testGenerateReportInDocumentFormat() {
        final Path outputPath = InParagraphList.generateReportInDocumentFormat(SampleFiles.IN_PARAGRAPH_LIST_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInSpreadsheetFormat() {
        final Path outputPath = InParagraphList.generateReportInSpreadsheetFormat(SampleFiles.IN_PARAGRAPH_LIST_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInPresentationFormat() {
        final Path outputPath = InParagraphList.generateReportInPresentationFormat(SampleFiles.IN_PARAGRAPH_LIST_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInHtmlFormat() {
        final Path outputPath = InParagraphList.generateReportInHtmlFormat(SampleFiles.IN_PARAGRAPH_LIST_HTML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInTextFormat() {
        final Path outputPath = InParagraphList.generateReportInTextFormat(SampleFiles.IN_PARAGRAPH_LIST_TXT);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInEmailFormat() {
        final Path outputPath = InParagraphList.generateReportInEmailFormat(SampleFiles.IN_PARAGRAPH_LIST_EML);
        Assertions.assertThat(outputPath).exists();
    }
}