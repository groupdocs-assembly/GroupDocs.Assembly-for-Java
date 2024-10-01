package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class CommonMasterDetailTests extends TestsSetUp {

    @Test
    public void testGenerateReportInDocumentFormat() {
        final Path outputPath = CommonMasterDetail.generateReportInDocumentFormat(SampleFiles.COMMON_MASTER_DETAIL_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInSpreadsheetFormat() {
        final Path outputPath = CommonMasterDetail.generateReportInSpreadsheetFormat(SampleFiles.COMMON_MASTER_DETAIL_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInPresentationFormat() {
        final Path outputPath = CommonMasterDetail.generateReportInPresentationFormat(SampleFiles.COMMON_MASTER_DETAIL_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInHtmlFormat() {
        final Path outputPath = CommonMasterDetail.generateReportInHtmlFormat(SampleFiles.COMMON_MASTER_DETAIL_HTML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInTextFormat() {
        final Path outputPath = CommonMasterDetail.generateReportInTextFormat(SampleFiles.COMMON_MASTER_DETAIL_TXT);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInEmailFormat() {
        final Path outputPath = CommonMasterDetail.generateReportInEmailFormat(SampleFiles.COMMON_MASTER_DETAIL_EML);
        Assertions.assertThat(outputPath).exists();
    }
}