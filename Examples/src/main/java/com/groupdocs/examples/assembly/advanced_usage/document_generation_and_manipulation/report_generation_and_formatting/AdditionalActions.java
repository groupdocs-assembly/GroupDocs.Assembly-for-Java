package com.groupdocs.examples.assembly.advanced_usage.document_generation_and_manipulation.report_generation_and_formatting;

import com.groupdocs.assembly.DataSourceInfo;
import com.groupdocs.assembly.DocumentAssembler;
import com.groupdocs.assembly.FileFormat;
import com.groupdocs.assembly.LoadSaveOptions;
import com.groupdocs.examples.assembly.utils.DataStorage;
import com.groupdocs.examples.assembly.utils.FailureRegister;
import com.groupdocs.examples.assembly.utils.FilesUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class AdditionalActions {

    public static Path templateSyntaxFormatting(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdditionalActions/TemplateSyntaxFormatting" + FilesUtils.obtainExtension(inputFile));
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

    public static Path outerDocumentInsertion(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdditionalActions/TemplateSyntaxFormatting" + FilesUtils.obtainExtension(inputFile));
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

    public static Path changeTargetFileFormat(Path inputFile, String newFileExtension) {
        final Path outputPath = FilesUtils.makeOutputPath("AdditionalActions/ChangeTargetFileFormat" + newFileExtension);
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

    public static Path changeTargetFileFormatUsingExplicitSpecifying(Path inputFile, int newFileFormat) {
        final String newFileFormatString = FileFormat.toString(newFileFormat);
        final Path outputPath = FilesUtils.makeOutputPath("AdditionalActions/ChangeTargetFileFormatUsingExplicitSpecifying" + "." + newFileFormatString.toLowerCase());
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new LoadSaveOptions(newFileFormat), new DataSourceInfo(new DataStorage(), null));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path removeSelectiveChartSeries(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdditionalActions/RemoveSelectiveChartSeries" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            //Set mode 1 or 2 to remove 1st or 2nd Quarter data
            int mode = 1;
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(new DataStorage(), "orders"), new DataSourceInfo(mode, "mode"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path dynamicChartAxisTitleSpreadSheet(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdditionalActions/DynamicChartAxisTitleSpreadSheet" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            String title = "Total Order Quantity by Quarters";
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(new DataStorage(), "orders"), new DataSourceInfo(title, "title"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path dynamicChartAxisTitleEmail(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdditionalActions/DynamicChartAxisTitleEmail" + FilesUtils.obtainExtension(inputFile));
        try {
            String title = "Total Order Quantity by Quarters";
            DataStorage.EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("Chart with Filtering, Grouping, and Ordering.msg", ".msg", title);
            DataStorage.EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".msg", title);
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
                    new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
                    new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
                    new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
                    new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
                    new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()),
                    new DataSourceInfo(getDataSourceDetails.getTitle(), dataSourceNames.getTitle()));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path dynamicColor(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdditionalActions/DynamicColor" + FilesUtils.obtainExtension(inputFile));
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            String color = "red";
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo(new DataStorage(), "orders"),
                    new DataSourceInfo(color, "color"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static String usingStringTemplate(String sourceString) {
        final String resultString;
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            ByteArrayInputStream sourceStream = new ByteArrayInputStream(sourceString.getBytes(StandardCharsets.UTF_8));
            ByteArrayOutputStream targetStream = new ByteArrayOutputStream();
            assembler.assembleDocument(sourceStream, targetStream, new DataSourceInfo("Hello, World!", "yourValue"));
            final byte[] resultBytes = targetStream.toByteArray();
            resultString = new String(resultBytes, StandardCharsets.UTF_8);
            System.out.println(resultString);
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        return resultString;
    }

    public static Path saveDocToHTMLWithResource(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdditionalActions/SaveDocToHTMLWithResource.htm");
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(inputFile.toString(), outputPath.toString(), new DataSourceInfo("Hello!", "value"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path saveWordOrEmailToMarkdownUsingExtension(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdditionalActions/SaveWordOrEmailToMarkdownUsingExtension.md");
        try {
            String description = "GroupDocs.Assembly for Java is a class library that enables you to generate documents in popular " +
                    "office and email file formats based upon template documents and data obtained from various sources " +
                    "including databases, XML, JSON, OData, objects of custom Java types, external documents, and more.";

            DocumentAssembler assembler = new DocumentAssembler();

            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo("GroupDocs.Assembly for Java", "product"),
                    new DataSourceInfo(description, "description"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path saveMarkdownToWordUsingExtension(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdditionalActions/SaveMarkdownToWordUsingExtension.docx");
        try {
            String description = "GroupDocs.Assembly for Java is a class library that enables you to generate documents in popular " +
                    "office and email file formats based upon template documents and data obtained from various sources " +
                    "including databases, XML, JSON, OData, objects of custom Java types, external documents, and more.";

            DocumentAssembler assembler = new DocumentAssembler();

            assembler.assembleDocument(inputFile.toString(), outputPath.toString(),
                    new DataSourceInfo("GroupDocs.Assembly for Java", "product"),
                    new DataSourceInfo(description, "description"));
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }

    public static Path saveWordOrEmailToMarkdownExplicit(Path inputFile) {
        final Path outputPath = FilesUtils.makeOutputPath("AdditionalActions/SaveWordOrEmailToMarkdownExplicit.md");

        try (final InputStream inputStream = Files.newInputStream(inputFile);
             final OutputStream targetStream = Files.newOutputStream(outputPath)) {

            String description = "GroupDocs.Assembly for Java is a class library that enables you to generate documents in popular " +
                    "office and email file formats based upon template documents and data obtained from various sources " +
                    "including databases, XML, JSON, OData, objects of custom Java types, external documents, and more.";

            DocumentAssembler assembler = new DocumentAssembler();

            DataSourceInfo dataSourceInfo1 = new DataSourceInfo("The GroupDocs.Assembly for Java", "product");
            DataSourceInfo dataSourceInfo2 = new DataSourceInfo(description, "description");

            assembler.assembleDocument(inputStream, targetStream, new LoadSaveOptions(FileFormat.MARKDOWN), dataSourceInfo1, dataSourceInfo2);
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            return null;
        }
        System.out.println("\nDocument saved successfully.\nCheck output: " + outputPath.getParent());
        return outputPath;
    }
}
