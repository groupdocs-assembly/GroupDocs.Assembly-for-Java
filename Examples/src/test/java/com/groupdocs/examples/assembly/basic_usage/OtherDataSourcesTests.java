package com.groupdocs.examples.assembly.basic_usage;

import com.groupdocs.examples.assembly.SampleFiles;
import com.groupdocs.examples.assembly.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class OtherDataSourcesTests extends TestsSetUp {

    @Test
    public void testUseSpreadsheetAsDataSource() {
        final Path outputPath = OtherDataSources.useSpreadsheetAsDataSource(SampleFiles.SPREADSHEET_AS_TABLE_OF_DATA_DOCX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testImportingWordProcessingTableIntoPresentation() {
        final Path outputPath = OtherDataSources.importingWordProcessingTableIntoPresentation(SampleFiles.WORD_PROCESSING_TABLE_PPTX);
        Assertions.assertThat(outputPath).exists();
    }

    @Test
    public void testUsePresentationTableAsDataSource() {
        final Path outputPath = OtherDataSources.usePresentationTableAsDataSource(SampleFiles.PRESENTATION_AS_TABLE_OF_DATA_PPTX);
        Assertions.assertThat(outputPath).exists();
    }
}