package com.groupdocs.assembly.examples;

import com.groupdocs.assembly.DocumentTableLoadArgs;
import com.groupdocs.assembly.DocumentTableOptions;
import com.groupdocs.assembly.IDocumentTableLoadHandler;

public class ColumnNameExtractingDocumentTableLoadHandler implements IDocumentTableLoadHandler
{
    public void handle(DocumentTableLoadArgs args)
    {
        args.setOptions(new DocumentTableOptions());
        args.getOptions().setFirstRowContainsColumnNames(true);
    }
}