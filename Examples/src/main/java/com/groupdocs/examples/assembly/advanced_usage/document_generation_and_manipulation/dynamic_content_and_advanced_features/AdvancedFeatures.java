package com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.dynamic_content_and_advanced_features;

import com.groupdocs.assembly.*;
import com.groupdocs.examples.assembly.utils.DataStorage;
import com.groupdocs.examples.assembly.utils.FailureRegister;
import com.groupdocs.examples.assembly.utils.FilesUtils;
import com.groupdocs.examples.assembly.utils.businessentities.Manager;

import java.nio.file.Path;
import java.util.Optional;

public class AdvancedFeatures {
    public static Path insertNestedExternalDocumentsInWord(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdvancedFeatures/InsertNestedExternalDocumentsInWord" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path insertNestedExternalDocumentsInEmail(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdvancedFeatures/InsertNestedExternalDocumentsInEmail" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path updateWordDocFieldsInSpreadsheet(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdvancedFeatures/UpdateWordDocFieldsInSpreadsheet" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.setOptions(DocumentAssemblyOptions.UPDATE_FIELDS_AND_FORMULAS);
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static DocumentTableSet loadDocTableSet(Path dataSourceFile) {
        try {
            DocumentTableSet tableSet = new DocumentTableSet(dataSourceFile.toString());

            // Check loading.
            assert tableSet.getTables().getCount() == 3;
            assert tableSet.getTables().get(0).getName().equals("Table1");
            assert tableSet.getTables().get(1).getName().equals("Table2");
            assert tableSet.getTables().get(2).getName().equals("Table3");

            return tableSet;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
    }

    public static Path workingWithTableRowDataBandsSpreadSheet(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdvancedFeatures/WorkingWithTableRowDataBandsSpreadSheet" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null), new DataSourceInfo(DataStorage.excelData(), "ds"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path workingWithTableRowDataBandsPresentation(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdvancedFeatures/WorkingWithTableRowDataBandsPresentation" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null), new DataSourceInfo(DataStorage.excelData(), "ds"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path workingWithTableRowDataBandsEmail(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdvancedFeatures/WorkingWithTableRowDataBandsEmail" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();

            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo(new DataStorage(), null), new DataSourceInfo(DataStorage.excelData(), "ds"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path emptyParagraphInWordProcessing(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdvancedFeatures/EmptyParagraphInWordProcessing" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.setOptions(DocumentAssemblyOptions.REMOVE_EMPTY_PARAGRAPHS);
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo("dummy", "dummy"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path emptyParagraphInPresentation(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdvancedFeatures/EmptyParagraphInPresentation" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.setOptions(DocumentAssemblyOptions.REMOVE_EMPTY_PARAGRAPHS);
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo("dummy", "dummy"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path emptyParagraphInEmail(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdvancedFeatures/EmptyParagraphInEmail" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.setOptions(DocumentAssemblyOptions.REMOVE_EMPTY_PARAGRAPHS);
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo("dummy", "dummy"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path demoInLineSyntaxError(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdvancedFeatures/DemoInLineSyntaxError" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            //Enable the In-line error messaging
            assembler.setOptions(DocumentAssemblyOptions.INLINE_ERROR_MESSAGES);
            //Create sample data source object
            Optional<Manager> manager = new DataStorage().getManagers().stream().findFirst();
            assert manager.isPresent();

            //Call AssembleDocument to show the demo Report and save the report in PDF format
            //The AssembleDocument will return a boolean value to indicate the success or failed with inline error.
            if (assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new LoadSaveOptions(FileFormat.PDF), new DataSourceInfo(manager.get(), "manager"))) {
                System.out.println("No error found in the template.");
            } else {
                System.out.println("Do something with a report containing a template syntax error.");
            }
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}
