---
id: groupdocs-assembly-for-java-18-9-release-notes
url: assembly/java/groupdocs-assembly-for-java-18-9-release-notes
title: GroupDocs.Assembly for Java 18.9 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Assembly for Java 18.9.{{< /alert >}}

## Major Features

This release of GroupDocs.Assembly brings a new powerful feature: Abilities to change target file format of an assembled document using file extension or explicit specifying.

## Full List of Features Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| ASSEMBLYNET-80  | Add ability to change target file format when assembling Word Processing documents  | Feature  |
| ASSEMBLYNET-81  | Add ability to change target file format when assembling Spreadsheet documents  | Feature  |
| ASSEMBLYNET-82  | Add ability to change target file format when assembling Presentation documents  | Feature  |
| ASSEMBLYNET-83  | Add ability to change target file format when assembling Email documents  | Feature  |
| ASSEMBLYNET-84  | Add ability to change target file format when assembling Text documents  | Feature  |
| ASSEMBLYNET-88  | Add support for Conholdate licenses  | Feature  |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Assembly for Java 18.9. It includes not only new and obsoleted public methods, but also a description of any changes in the behaviour behind the scenes in GroupDocs.Assembly which may affect existing code. Any behaviour introduced that could be seen as a regression and modifies existing behaviour is especially important and is documented here.{{< /alert >}}

## Ability to change the target file format of an assembled document 

Starting from the 18.9 version, GroupDocs.Assembly provides abilities to change target file format of an assembled document using file extension or explicit specifying. Supported output file formats depending on input file formats can be found at [this page](https://docs.groupdocs.com/display/assemblyjava/Introducing+GroupDocs.Assembly+for+Java#IntroducingGroupDocs.AssemblyforJava-SupportedOutputFileFormatsDependingonInputFileFormats).

### Changing target file format using the file extension

**Java**

```csharp
DataSourceInfo dataSourceInfo = new DataSourceInfo(...);
DocumentAssembler assembler = new DocumentAssembler();
 
assembler.assembleDocument("template.docx", "result.pdf", dataSourceInfo);
```

### Changing target file format using explicit specifying

**Java**

```csharp
InputStream sourceStream = ...;
OutputStream targetStream = ...;
 
DataSourceInfo dataSourceInfo = new DataSourceInfo(...);
DocumentAssembler assembler = new DocumentAssembler();
 
assembler.assembleDocument(sourceStream, targetStream, new LoadSaveOptions(FileFormat.PDF), dataSourceInfo);
```

### Newly added types

**Java**

```csharp
/**
  * Provides information on a single data source object to be used to assemble a document from a template.
  */
public class DataSourceInfo
```

**Java**

```csharp
/**
  * A utility class providing constants. Specifies the format of a file.
  */
public final class FileFormat
```

**Java**

```csharp
/**
  * Specifies additional options for loading and saving of a document to be assembled.
  */
public class LoadSaveOptions
```

### New members of DocumentAssembler

**Java**

```csharp
/**
  * Loads a template document from the specified source path, populates the template document with data from the specified single or multiple sources, and stores the result document to the target path using default {@link com.groupdocs.assembly.LoadSaveOptions}.
  * 
  * @param sourcePath The path to a template document to be populated with data.
  * @param targetPath The path to a result document.
  * @param dataSourceInfos Provides information on data source objects to be used.
  */
public void assembleDocument(String sourcePath, String targetPath, DataSourceInfo... dataSourceInfos) throws Exception
```

**Java**

```csharp
/**
  * Loads a template document from the specified source path, populates the template document with data from the specified single or multiple sources, and stores the result document to the target path using the given {@link com.groupdocs.assembly.LoadSaveOptions}.
  * 
  * @param sourcePath The path to a template document to be populated with data.
  * @param targetPath The path to a result document.
  * @param loadSaveOptions Specifies additional options for document loading and saving.
  * @param dataSourceInfos Provides information on data source objects to be used.
  */
public void assembleDocument(String sourcePath, String targetPath, LoadSaveOptions loadSaveOptions, DataSourceInfo... dataSourceInfos) throws Exception
```

**Java**

```csharp
/**
  * Loads a template document from the specified source stream, populates the template document with data from the specified single or multiple sources, and stores the result document to the target stream using default {@link com.groupdocs.assembly.LoadSaveOptions}.
  * 
  * @param sourceStream The stream to read a template document from.
  * @param targetStream The stream to write a result document.
  * @param dataSourceInfos Provides information on data source objects to be used.
  */
public void assembleDocument(InputStream sourceStream, OutputStream targetStream, DataSourceInfo... dataSourceInfos) throws Exception
```

**Java**

```csharp
/**
  * Loads a template document from the specified source stream, populates the template document with data from the specified single or multiple sources, and stores the result document to the target stream using the given {@link com.groupdocs.assembly.LoadSaveOptions}.
  * 
  * @param sourceStream The stream to read a template document from.
  * @param targetStream The stream to write a result document.
  * @param loadSaveOptions Specifies additional options for document loading and saving.
  * @param dataSourceInfos Provides information on data source objects to be used.
  */
public void assembleDocument(InputStream sourceStream, OutputStream targetStream, LoadSaveOptions loadSaveOptions, DataSourceInfo... dataSourceInfos) throws Exception
```

### Removed members of DocumentAssembler

**Java**

```csharp
public void assembleDocument(String sourcePath, String targetPath, Object dataSource)
public void assembleDocument(String sourcePath, String targetPath, Object dataSource, String dataSourceName)
public void assembleDocument(String sourcePath, String targetPath, Object[] dataSources, String[] dataSourceNames)
public void assembleDocument(InputStream sourceStream, OutputStream targetStream, Object dataSource)
public void assembleDocument(InputStream sourceStream, OutputStream targetStream, Object dataSource, String dataSourceName)
public void assembleDocument(InputStream sourceStream, OutputStream targetStream, Object[] dataSources, String[] dataSourceNames)
```

### Breaking changes

Removed members of DocumentAssembler were replaced with new ones. Removed members were not marked as obsolete (deprecated) before removal as usual, because this would complicate migration to new members of DocumentAssembler in Java. Thus, we have introduced a breaking change and customers need to migrate their code from removed members of DocumentAssembler to newly added ones when upgrading to the new version of GroupDocs.Assembly.

### Migrating code from removed members of DocumentAssembler to newly added ones

The following table shows how to migrate code from removed members of DocumentAssembler to newly added ones.

| Old Code | New Code |
| --- | --- |
| 
**Java**

```csharp
assembler.assembleDocument(sourcePath, targetPath, dataSource);
```





 | 

**Java**

```csharp
 assembler.assembleDocument(sourcePath, targetPath, new DataSourceInfo(dataSource));
```





 |
| 

**Java**

```csharp
assembler.assembleDocument(sourcePath, targetPath, dataSource, dataSourceName);
```





 | 

**Java**

```csharp
assembler.assembleDocument(sourcePath, targetPath, new DataSourceInfo(dataSource, dataSourceName));
```





 |
| 

**Java**

```csharp
Object[] dataSources = new Object[] { dataSource1, dataSource2 };
String[] dataSourceNames = new String[] { dataSourceName1, dataSourceName2 };
 
assembler.assembleDocument(sourcePath, targetPath, dataSources, dataSourceNames);
```





 | 

**Java**

```csharp
assembler.assembleDocument(sourcePath, targetPath, new DataSourceInfo(dataSource1, dataSourceName1), new DataSourceInfo(dataSource2, dataSourceName2));
```





 |
| 

**Java**

```csharp
assembler.assembleDocument(sourceStream, targetStream, dataSource);
```





 | 

**Java**

```csharp
assembler.assembleDocument(sourceStream, targetStream, new DataSourceInfo(dataSource));
```





 |
| 

**Java**

```csharp
assembler.assembleDocument(sourceStream, targetStream, dataSource, dataSourceName);
```





 | 

**Java**

```csharp
assembler.assembleDocument(sourceStream, targetStream, new DataSourceInfo(dataSource, dataSourceName));
```





 |
| 

**Java**

```csharp
Object[] dataSources = new Object[] { dataSource1, dataSource2 };
String[] dataSourceNames = new String[] { dataSourceName1, dataSourceName2 };
 
assembler.assembleDocument(sourceStream, targetStream, dataSources, dataSourceNames);
```





 | 

**Java**

```csharp
assembler.assembleDocument(sourceStream, targetStream, new DataSourceInfo(dataSource1, dataSourceName1), new DataSourceInfo(dataSource2, dataSourceName2));
```





 |

### Add support for Conholdate licenses 

Since version 18.9, the Metered licensing security has been improved. Metered licensing is now applicable only in Java runtime version *8u101* or above. Please use other types of licensing if you are using v18.9 or greater in Java 7.
