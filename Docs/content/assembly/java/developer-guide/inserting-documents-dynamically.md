---
id: inserting-documents-dynamically
url: assembly/java/inserting-documents-dynamically
title: Inserting Documents Dynamically
weight: 43
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}This feature is supported by version 20.3 or greater.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

You can insert contents of outer documents to your reports dynamically using doc tags. A doc tag denotes a placeholder within a template for a document to be inserted during run time.

Syntax of a doc tag is defined as follows.

```csharp
<<doc [document_expression]>>
```

And simply call the assembler method to generate report like following code snippets:

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-insertdocumentdynamicallyinword_20-3-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-insertdocumentdynamicallyinword_20-3-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-insertdocumentdynamicallyinword_20-3-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-insertdocumentdynamicallyinword_20-3-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Setting up source document template (Email or Word Document)</span></td></tr><tr><td id="file-insertdocumentdynamicallyinword_20-3-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-insertdocumentdynamicallyinword_20-3-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> strDocumentTemplate <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Word Templates/DynamicDocInsert.docx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-insertdocumentdynamicallyinword_20-3-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-insertdocumentdynamicallyinword_20-3-java-LC4" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-insertdocumentdynamicallyinword_20-3-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-insertdocumentdynamicallyinword_20-3-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Setting up destination for reports</span></td></tr><tr><td id="file-insertdocumentdynamicallyinword_20-3-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-insertdocumentdynamicallyinword_20-3-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> strDocumentReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Word Reports/DynamicDocInsert Out.docx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-insertdocumentdynamicallyinword_20-3-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-insertdocumentdynamicallyinword_20-3-java-LC7" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-insertdocumentdynamicallyinword_20-3-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-insertdocumentdynamicallyinword_20-3-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Instantiate DocumentAssembler class</span></td></tr><tr><td id="file-insertdocumentdynamicallyinword_20-3-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-insertdocumentdynamicallyinword_20-3-java-LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-insertdocumentdynamicallyinword_20-3-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-insertdocumentdynamicallyinword_20-3-java-LC10" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-insertdocumentdynamicallyinword_20-3-java-L11" class="blob-num js-line-number" data-line-number="11"></td><td id="file-insertdocumentdynamicallyinword_20-3-java-LC11" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getDataPath(strDocumentTemplate),</td></tr><tr><td id="file-insertdocumentdynamicallyinword_20-3-java-L12" class="blob-num js-line-number" data-line-number="12"></td><td id="file-insertdocumentdynamicallyinword_20-3-java-LC12" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOutPath(strDocumentReport),</td></tr><tr><td id="file-insertdocumentdynamicallyinword_20-3-java-L13" class="blob-num js-line-number" data-line-number="13"></td><td id="file-insertdocumentdynamicallyinword_20-3-java-LC13" class="blob-code blob-code-inner js-file-line"><span class="pl-k">new</span> <span class="pl-smi">DataSourceInfo</span>(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOuterDoc(<span class="pl-s"><span class="pl-pds">"</span>OuterDoc.docx<span class="pl-pds">"</span></span>),<span class="pl-s"><span class="pl-pds">"</span>document_expression<span class="pl-pds">"</span></span>));</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/ecbe5e7331f08a3f0bccd81a1ef57995/raw/0af1bfaf1c09cb31563f8f9d8d94eeb618f8a49b/insertDocumentDynamicallyInWord_20.3.java) [insertDocumentDynamicallyInWord\_20.3.java](https://gist.github.com/GroupDocsGists/ecbe5e7331f08a3f0bccd81a1ef57995#file-insertdocumentdynamicallyinword_20-3-java) hosted with ❤ by [GitHub](https://github.com)

{{< alert style="warning" >}}A doc tag can be used almost anywhere in a template document except textboxes and charts.{{< /alert >}}

An expression declared within a doc tag is used by the assembler to load a document to be inserted during runtime. The expression must return a value of one of the following types:

*   A byte array containing document data
*   An InputStream[ instance able to read document data](http://msdn.microsoft.com/en-us/library/system.io.stream(v=vs.110).aspx)
*   An instance of the Document class
*   A string containing a document URI, path, or Base64-encoded document data

While building a report, an expression declared within a doc tag is evaluated and its result is used to load a document which content replaces the doc tag then.

{{< alert style="warning" >}}If an expression declared within a doc tag returns a stream object, then the stream is closed by the assembler as soon as a corresponding document is loaded.{{< /alert >}}

By default, a document being inserted is not checked against template syntax and is not populated with data. However, you can enable this by using a build switch as follows.

```csharp
<<doc [document_expression] -build>>
```

When a build switch is used, the assembler treats a document being inserted as a template that can access the following data available at the scope of a corresponding doc tag:

*   Data sources
*   Variables
*   A contextual object 
*   Known external types 

{{< alert style="warning" >}}Dynamic insertion of documents from Base64-encoded bytes is available for file formats where dynamic document insertion is available for Word Processing documents and emails with HTML and RTF bodies only.{{< /alert >}}
