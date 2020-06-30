---
id: groupdocs-assembly-engine-apis
url: assembly/java/groupdocs-assembly-engine-apis
title: GroupDocs.Assembly Engine APIs
weight: 3
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will discuss the behavior of GroupDocs.Assembly APIs.{{< /alert >}}

## Overview of the API

Classes of GroupDocs.Assembly are located within the GroupDocs.Assembly namespace. The main of the classes is [DocumentAssembler](https://apireference.groupdocs.com/java/assembly/com.groupdocs.assembly/DocumentAssembler). All the functionality required to build a report from a template is assembled within the class.

### Building Reports

To build a report from a template, you can use one of the [com.groupdocs.assembly.DocumentAssembler](https://apireference.groupdocs.com/java/assembly/com.groupdocs.assembly/DocumentAssembler) overloads. The following table describes parameters of these overloads.

| Parameter | Description |
| --- | --- |
| document | A template document. At runtime, this document instance is populated with a data from the specified source and becomes a ready report. |
| dataSource | An object providing a data to populate the specified template. The object must be of one of the following types:  
• A traditional mail merge data source (see "Working with Traditional Mail Merge Data Sources" for more information)  
• An object of a custom visible type (see "Working with Types" for more information) |
| dataSourceName | The identifier of the specified data source object within the specified template. You can omit this identifier, if the template uses the [contextual object member access](https://docs.groupdocs.com/display/assemblynet/Template+Syntax+-+Part+1+of+2#TemplateSyntax-Part1of2-UsingContextualObjectMemberAccess) when dealing with the data source. |

Given a template to be populated with a data from a [DataSet](https://apireference.groupdocs.com/java/assembly/com.groupdocs.assembly.system.data/DataSet) instance that is identified as "ds" within the template, you can use the following code to build the corresponding report.

```java
//Setting up source document template
const String strDocumentTemplate = "Template Folder/wordTemplate.docx";
//Setting up destination document report
const String strDocumentReport = "Report Folder/wordReport.docx";
// Setting up a data set.
DataSet ds = ........

DocumentAssembler assembler = new DocumentAssembler();
assembler.assembleDocument(strDocumentTemplate, strDocumentReport, new DataSourceInfo(ds, "ds"));

```

Given a visible `Person` class defined in your application and a template to be populated with a data about a single Person instance using the contextual object member access, you can use the following code to build the corresponding report.

```java
//Setting up source document template
const String strDocumentTemplate = "Template Folder/wordTemplate.docx";
//Setting up destination document report
const String strDocumentReport = "Report Folder/wordReport.docx";
// Setting up a person data
Person person = ........

DocumentAssembler assembler = new DocumentAssembler();
assembler.assembleDocument(strDocumentTemplate, strDocumentReport, new DataSourceInfo(person, "PersonDS"));

```

### Setting up Known External Types

GroupDocs.Assembly Engine must be aware of custom external types that you reference in your template before the engine processes the template. You can set up external types known by the engine through the [DocumentAssembler.getKnownTypes()](https://apireference.groupdocs.com/java/assembly/com.groupdocs.assembly/DocumentAssembler#getKnownTypes--) property. The property represents an unordered set (that is, a collection of unique items) of [Class](http://docs.oracle.com/javase/7/docs/api/java/lang/Class.html) objects. Every type in the set must meet requirements declared at [Working with Types](https://docs.groupdocs.com/display/assemblynet/Template+Syntax+-+Part+1+of+2#TemplateSyntax-Part1of2-UsingTypes).

**Note:** Aliases of simple types like int, string, and others are known by the engine by default.

Consider the following example. Given an ImageUtil class declared at your application and a template accessing a static member of this class, you can use the following code to make the engine be aware of the class before processing the template.

```java
DocumentAssembler assembler = new DocumentAssembler;
assembler.knownTypes.add(typeof(ImageUtil));
assembler.assembleDocument(...);

```

### Optimizing Reflection Calls

GroupDocs.Assembly Engine uses reflection calls while accessing members of custom external types. However, reflection calls are much slower than direct calls, which creates a performance overhead.

Due to the performance overhead, the engine provides a strategy minimizing the reflection usage. The strategy is based upon the runtime type generation. That is, the engine generates a proxy type per an external type. The proxy directly calls members of the corresponding external type, the engine to access these members in a uniform way with no reflection involved. The proxy is [lazily initialized](http://en.wikipedia.org/wiki/Lazy_initialization) and reused in further. Thus, the reflection is used only while building the proxy.

Although this strategy can significantly minimize the reflection usage in a long run, it creates a performance overhead of the runtime type generation. So, if you deal with small data collections all the time while building your reports, consider the disabling of the strategy.

You can control the enabling of the strategy through the `[DocumentAssembler.setUseReflectionOptimization](https://apireference.groupdocs.com/java/assembly/com.groupdocs.assembly/DocumentAssembler#setUseReflectionOptimization-boolean-)` static property. By default, the strategy is enabled.

## Technical Considerations

Here, we will reveal some technical aspects and implementation details related to the GroupDocs.Assembly Engine which can be useful for you while making design decisions for your applications.

### Implicit Enumeration Determination

If you do not specify the type of an enumeration item in a `foreach` statement or lambda function signature within your template explicitly, the type is implicitly determined by the engine from the type of the enumeration as follows:

1.  If the enumeration represents a [DataTable](https://apireference.groupdocs.com/java/assembly/com.groupdocs.assembly.system.data/DataTable) instance, then the item represents its row.
2.  Otherwise, if the enumeration represents child rows of a DataTable row, then the item represents a child row.
3.  Otherwise, if the enumeration implements generic Iterable<T>, then the item type is a type argument corresponding to T. Note, that in some cases it is impossible to extract type arguments at runtime due to the Java [Type Erasure](http://docs.oracle.com/javase/tutorial/java/generics/erasure.html) feature. That is why, the engine is capable to extract the item type only if one of the following conditions is met:
    
    *   The enumeration expression represents an invocation of a type member which return type is a parameterized type like Iterable<String>, ArrayList<Integer>, and so forth.
    *   The type of the enumeration implements or extends a parameterized type like Iterable<String>, ArrayList<Integer>, and so forth.
4.  Otherwise, the item type is Object.
