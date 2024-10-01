package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class BarcodeInsertionTests extends TestsSetUp {

    @Test
    public void testGenerateReportInDocumentFormat() {
        final Path outputPath = BarcodeInsertion.generateReportInDocumentFormat(SampleFiles.BARCODE_INSERTION_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInSpreadsheetFormat() {
        final Path outputPath = BarcodeInsertion.generateReportInSpreadsheetFormat(SampleFiles.BARCODE_INSERTION_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testGenerateReportInPresentationFormat() {
        final Path outputPath = BarcodeInsertion.generateReportInPresentationFormat(SampleFiles.BARCODE_INSERTION_PPTX);
        Assertions.assertThat(outputPath).exists();
    }
}