---
id: bulleted-list-in-word-processing-document
url: assembly/java/bulleted-list-in-word-processing-document
title: Bulleted List in Word Processing Document
weight: 1
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026731945 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026731945 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026731945 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026731945"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#BulletedListinWordProcessingDocument-BulletedListinMicrosoftWordDocument">Bulleted List in Microsoft Word Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#BulletedListinWordProcessingDocument-CreatingaBulletedList">Creating a Bulleted List</a></li><li><span class="TOCOutline">1.2</span> <a href="#BulletedListinWordProcessingDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.3</span> <a href="#BulletedListinWordProcessingDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a></li><li><span class="TOCOutline">1.4</span> <a href="#BulletedListinWordProcessingDocument-DownloadBulletedListTemplate">Download Bulleted List Template</a></li><li><span class="TOCOutline">1.5</span> <a href="#BulletedListinWordProcessingDocument-GeneratingTheReport">Generating The Report</a></li><li><span class="TOCOutline">1.6</span> <a href="#BulletedListinWordProcessingDocument-ODTTemplateandReportinApacheOpenOffice">ODT Template and Report in Apache OpenOffice</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%">&nbsp;</td><td valign="top" width="35%">&nbsp;</td></tr></tbody></table>

{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Bulleted List report in Word Processing Document format.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Bulleted List in Microsoft Word Document

### Creating a Bulleted List

Practising the following steps you can insert Bulleted List in MS Word 2013.

1.  Add a bullet list at the place where you want it.
2.  Save your Document.

### Reporting Requirement

As a report developer, you are required to share the following key requirements:

*   Report must show all the clients in a bulleted list format.
*   Report must be generated in the Word Processing Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

**Template Syntax**

```csharp
We provide support for the following clients:
•<<foreach [in getClients()]>><<[getName()]>>
<</foreach>>


```

### Download Bulleted List Template

Please download the sample Bulleted List document we created in this article:

*   [Bulleted List.docx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Word%20Templates/Bulleted%20List.docx?raw=true)

### Generating The Report

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Word Templates/Bulleted List.docx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Word Reports/Bulleted List_report.docx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">try</span> {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-LC6" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestDataPath(srcDocument),</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-LC7" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestOutPath(docReport),</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-k">new</span> <span class="pl-smi">DataSourceInfo</span>(<span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>(), <span class="pl-c1">null</span>));</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-LC9" class="blob-code blob-code-inner js-file-line">} <span class="pl-k">catch</span> (<span class="pl-smi">Exception</span> exp) {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-LC10" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">System</span><span class="pl-k">.</span>out<span class="pl-k">.</span>println(<span class="pl-s"><span class="pl-pds">"</span>Exception: <span class="pl-pds">"</span></span> <span class="pl-k">+</span> exp<span class="pl-k">.</span>getMessage());</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-L11" class="blob-num js-line-number" data-line-number="11"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java-LC11" class="blob-code blob-code-inner js-file-line">}</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/0d492aa10208d139d02c698495c6ae63/raw/41b7d846e98b22b385ec81c766a934ffd0053de5/Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-bulletedlistdocument.java) [Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-bulletedlistdocument.java](https://gist.github.com/GroupDocsGists/0d492aa10208d139d02c698495c6ae63#file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-bulletedlistdocument-java) hosted with ❤ by [GitHub](https://github.com)

### ODT Template and Report in Apache OpenOffice

In order to check compatibility of ODT between Microsoft Office 2010 and Apache OpenOffice 4.1.2, we performed below tests:

*   We opened the ODT template created through Microsoft Office 2010 in Apache OpenOffice 4.1.2. The template opened successfully in Apache OpenOffice without any issues or formatting losses.
*   We opened the ODT report generated through GroupDocs.Assembly in Apache OpenOffice 4.1.2. The report opened successfully in Apache OpenOffice without any issues or formatting losses.
