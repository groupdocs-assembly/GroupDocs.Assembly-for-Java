package com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.dynamic_content_and_advanced_features;

import com.groupdocs.assembly.DocumentTableSet;
import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import com.groupdocs.examples.assembly.basic_usage.BulletedList;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.*;

public class AdvancedFeaturesTests extends TestsSetUp {

    @Test
    public void testInsertNestedExternalDocumentsInWord() {
        final Path outputPath = AdvancedFeatures.insertNestedExternalDocumentsInWord(SampleFiles.NESTED_EXTERNAL_DOCUMENT_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testInsertNestedExternalDocumentsInEmail() {
        final Path outputPath = AdvancedFeatures.insertNestedExternalDocumentsInEmail(SampleFiles.NESTED_EXTERNAL_DOCUMENT_MSG);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testUpdateWordDocFieldsInSpreadsheet() {
        final Path outputPath = AdvancedFeatures.updateWordDocFieldsInSpreadsheet(SampleFiles.UPDATE_FORMULA_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testLoadDocTableSet() {
        final DocumentTableSet documentTableSet = AdvancedFeatures.loadDocTableSet(SampleFiles.MULTIPLE_TABLES_DATA_DOCX);
        Assertions.assertThat(documentTableSet).isNotNull();
        Assertions.assertThat(documentTableSet.getTables()).isNotNull();
    }

    @Test
    public void testWorkingWithTableRowDataBandsSpreadSheet() {
        final Path outputPath = AdvancedFeatures.workingWithTableRowDataBandsSpreadSheet(SampleFiles.WORKING_WITH_TABLE_ROW_DATA_BANDS_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWorkingWithTableRowDataBandsPresentation() {
        final Path outputPath = AdvancedFeatures.workingWithTableRowDataBandsPresentation(SampleFiles.WORKING_WITH_TABLE_ROW_DATA_BANDS_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWorkingWithTableRowDataBandsEmail() {
        final Path outputPath = AdvancedFeatures.workingWithTableRowDataBandsEmail(SampleFiles.WORKING_WITH_TABLE_ROW_DATA_BANDS_MSG);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testEmptyParagraphInWordProcessing() {
        final Path outputPath = AdvancedFeatures.emptyParagraphInWordProcessing(SampleFiles.EMPTY_PARAGRAPH_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testEmptyParagraphInPresentation() {
        final Path outputPath = AdvancedFeatures.emptyParagraphInPresentation(SampleFiles.EMPTY_PARAGRAPH_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testEmptyParagraphInEmail() {
        final Path outputPath = AdvancedFeatures.emptyParagraphInEmail(SampleFiles.EMPTY_PARAGRAPH_MSG);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testDemoInLineSyntaxError() {
        final Path outputPath = AdvancedFeatures.demoInLineSyntaxError(SampleFiles.INLINE_ERROR_DEMO_DOCX);
        Assertions.assertThat(outputPath).exists();
    }
}