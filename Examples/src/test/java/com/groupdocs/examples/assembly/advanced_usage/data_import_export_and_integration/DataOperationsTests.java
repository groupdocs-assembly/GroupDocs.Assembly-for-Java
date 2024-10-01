package com.groupdocs.examples.assembly.advanced_usage.data_import_export_and_integration;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class DataOperationsTests extends TestsSetUp {

    @Test
    public void testImportingSpreadsheetIntoHtml() {
        final Path outputPath = DataOperations.importingSpreadsheetIntoHtml(SampleFiles.IMPORTING_SPREADSHEET_INTO_HTML_DOCUMENT_HTML, SampleFiles.CONTRACTS_DATA_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testLoadDocFromHTMLWithResource() {
        Path outputPath = DataOperations.loadDocFromHTMLWithResource(SampleFiles.TEST_WORDS_RESOURCE_LOAD_HTM);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testLoadDocFromHTMLWithResourceExplicitFolder() {
        Path outputPath = DataOperations.loadDocFromHTMLWithResourceExplicitFolder(SampleFiles.TEST_WORDS_RESOURCE_LOAD_HTM);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testSaveDocToHTMLWithResourceExplicitFolder() {
        Path outputPath = DataOperations.saveDocToHTMLWithResourceExplicitFolder(SampleFiles.TEST_WORDS_RESOURCE_SAVE_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testSimpleXML() {
        Path outputPath = DataOperations.simpleXML(SampleFiles.SIMPLE_DATASET_DEMO_DOCX, SampleFiles.MANAGERS_XML);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testSimpleCsv() {
        Path outputPath = DataOperations.simpleCsv(SampleFiles.CSV_DATASET_DEMO_TXT, SampleFiles.PERSONS_CSV);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testSimpleJson() {
        Path outputPath = DataOperations.simpleJson(SampleFiles.SIMPLE_DATASET_DEMO_DOCX, SampleFiles.MANAGER_DATA_JSON);
        Assertions.assertThat(outputPath).exists();
    }
}