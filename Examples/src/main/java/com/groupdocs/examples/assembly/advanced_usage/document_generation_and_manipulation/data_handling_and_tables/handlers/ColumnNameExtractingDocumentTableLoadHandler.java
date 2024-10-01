package com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.data_handling_and_tables.handlers;

import com.groupdocs.assembly.DocumentTableLoadArgs;
import com.groupdocs.assembly.DocumentTableOptions;
import com.groupdocs.assembly.IDocumentTableLoadHandler;

public class ColumnNameExtractingDocumentTableLoadHandler implements IDocumentTableLoadHandler {
    public void handle(DocumentTableLoadArgs args) {
        args.setOptions(new DocumentTableOptions());
        args.getOptions().setFirstRowContainsColumnNames(true);
    }
}