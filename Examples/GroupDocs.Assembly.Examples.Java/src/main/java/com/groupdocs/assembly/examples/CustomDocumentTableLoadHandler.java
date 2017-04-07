package com.groupdocs.assembly.examples;

import com.groupdocs.assembly.DocumentTableLoadArgs;
import com.groupdocs.assembly.DocumentTableOptions;
import com.groupdocs.assembly.IDocumentTableLoadHandler;

public class CustomDocumentTableLoadHandler implements IDocumentTableLoadHandler
{
    public void handle(DocumentTableLoadArgs args)
    {
        switch (args.getTableIndex())
        {
            case 0:
                // Do nothing. The table is to be loaded with default options.
                break;
            case 1:
                // Discard loading of the table completely.
                args.isLoaded(false);
                break;
            case 2:
                // Load the table with custom options.
                args.setOptions(new DocumentTableOptions());
                args.getOptions().setFirstRowContainsColumnNames(true);
                break;
            default:
                throw new IllegalStateException();
        }
    }
}