package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class BulletedListTests extends TestsSetUp {

    @Test
    public void testGenerateReportInDocumentFormat() {
        final Path outputPath = BulletedList.generateReportInDocumentFormat(SampleFiles.BULLETED_LIST_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInSpreadsheetFormat() {
        final Path outputPath = BulletedList.generateReportInSpreadsheetFormat(SampleFiles.BULLETED_LIST_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInPresentationFormat() {
        final Path outputPath = BulletedList.generateReportInPresentationFormat(SampleFiles.BULLETED_LIST_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInHtmlFormat() {
        final Path outputPath = BulletedList.generateReportInHtmlFormat(SampleFiles.BULLETED_LIST_HTML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInTextFormat() {
        final Path outputPath = BulletedList.generateReportInTextFormat(SampleFiles.BULLETED_LIST_TXT);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInEmailFormat() {
        final Path outputPath = BulletedList.generateReportInEmailFormat(SampleFiles.BULLETED_LIST_EML);
        Assertions.assertThat(outputPath).exists();
    }
}