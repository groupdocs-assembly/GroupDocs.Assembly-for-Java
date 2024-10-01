package com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.data_handling_and_tables;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class TableCellsMergingTests extends TestsSetUp {

    @Test
    public void testInWordProcessing() {
        final Path outputPath = TableCellsMerging.inWordProcessing(SampleFiles.MERGING_CELLS_DYNAMICALLY_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testInPresentations() {
        final Path outputPath = TableCellsMerging.inPresentations(SampleFiles.MERGING_CELLS_DYNAMICALLY_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testInSpreadsheets() {
        final Path outputPath = TableCellsMerging.inSpreadsheets(SampleFiles.MERGING_CELLS_DYNAMICALLY_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testInEmails() {
        final Path outputPath = TableCellsMerging.inEmails(SampleFiles.MERGING_CELLS_DYNAMICALLY_MSG);
        Assertions.assertThat(outputPath).exists();
    }
}