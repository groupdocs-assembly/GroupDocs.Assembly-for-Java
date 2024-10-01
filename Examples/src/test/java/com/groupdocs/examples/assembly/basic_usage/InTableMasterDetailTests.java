package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class InTableMasterDetailTests extends TestsSetUp {

    @Test
    public void testGenerateReportInDocumentFormat() {
        final Path outputPath = InTableMasterDetail.generateReportInDocumentFormat(SampleFiles.IN_TABLE_MASTER_DETAIL_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInSpreadsheetFormat() {
        final Path outputPath = InTableMasterDetail.generateReportInSpreadsheetFormat(SampleFiles.IN_TABLE_MASTER_DETAIL_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInPresentationFormat() {
        final Path outputPath = InTableMasterDetail.generateReportInPresentationFormat(SampleFiles.IN_TABLE_MASTER_DETAIL_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInHtmlFormat() {
        final Path outputPath = InTableMasterDetail.generateReportInHtmlFormat(SampleFiles.IN_TABLE_MASTER_DETAIL_HTML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInEmailFormat() {
        final Path outputPath = InTableMasterDetail.generateReportInEmailFormat(SampleFiles.IN_TABLE_MASTER_DETAIL_EML);
        Assertions.assertThat(outputPath).exists();
    }
}