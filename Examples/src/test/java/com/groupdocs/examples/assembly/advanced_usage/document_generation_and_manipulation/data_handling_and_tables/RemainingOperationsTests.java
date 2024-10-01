package com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.data_handling_and_tables;

import com.groupdocs.assembly.DocumentTableSet;
import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class RemainingOperationsTests extends TestsSetUp {

    @Test
    public void testLoadDocTableSetWithCustomOptions() {
        final DocumentTableSet documentTableSet = RemainingOperations.loadDocTableSetWithCustomOptions(SampleFiles.MULTIPLE_TABLES_DATA_DOCX);
        Assertions.assertThat(documentTableSet).isNotNull();
    }

    @Test
    public void testUseDocumentTableSetAsDataSource() {
        Path outputPath = RemainingOperations.useDocumentTableSetAsDataSource(SampleFiles.USING_DOCUMENT_TABLE_SET_AS_DATA_SOURCE_PPTX, SampleFiles.MULTIPLE_TABLES_DATA_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testDefiningDocumentTableRelations() {
        Path outputPath = RemainingOperations.definingDocumentTableRelations(SampleFiles.USING_DOCUMENT_TABLE_RELATIONS_DOCX, SampleFiles.RELATED_TABLES_DATA_XLSX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testChangingDocumentTableColumnType() {
        Path outputPath = RemainingOperations.changingDocumentTableColumnType(SampleFiles.CHANGING_DOCUMENT_TABLE_COLUMN_TYPE_PPTX, SampleFiles.MANAGERS_DATA_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testWorkingWithTableRowDataBandsWord() {
        Path outputPath = RemainingOperations.workingWithTableRowDataBandsWord(SampleFiles.WORKING_WITH_TABLE_ROW_DATA_BANDS_DOCX);
        Assertions.assertThat(outputPath).exists();
    }
}