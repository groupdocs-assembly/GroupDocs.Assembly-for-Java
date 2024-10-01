package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class InTableListTests extends TestsSetUp {

    @Test
    public void testGenerateReportInDocumentFormat() {
        final Path outputPath = InTableList.generateReportInDocumentFormat(SampleFiles.IN_TABLE_LIST_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInSpreadsheetFormat() {
        final Path outputPath = InTableList.generateReportInSpreadsheetFormat(SampleFiles.IN_TABLE_LIST_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInPresentationFormat() {
        final Path outputPath = InTableList.generateReportInPresentationFormat(SampleFiles.IN_TABLE_LIST_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInHtmlFormat() {
        final Path outputPath = InTableList.generateReportInHtmlFormat(SampleFiles.IN_TABLE_LIST_HTML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInEmailFormat() {
        final Path outputPath = InTableList.generateReportInEmailFormat(SampleFiles.IN_TABLE_LIST_EML);
        Assertions.assertThat(outputPath).exists();
    }
}