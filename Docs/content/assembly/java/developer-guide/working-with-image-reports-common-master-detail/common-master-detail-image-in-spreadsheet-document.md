---
id: common-master-detail-image-in-spreadsheet-document
url: assembly/java/common-master-detail-image-in-spreadsheet-document
title: Common Master-Detail Image in Spreadsheet Document
weight: 2
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026732991 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026732991 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026732991 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026732991"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#CommonMaster-DetailImageinSpreadsheetDocument-CommonMaster-DetailImageinMicrosoftExcelDocument">Common Master-Detail Image in Microsoft Excel Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#CommonMaster-DetailImageinSpreadsheetDocument-CreatingaCommonMaster-DetailImage">Creating a Common Master-Detail Image</a></li><li><span class="TOCOutline">1.2</span> <a href="#CommonMaster-DetailImageinSpreadsheetDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.3</span> <a href="#CommonMaster-DetailImageinSpreadsheetDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a></li><li><span class="TOCOutline">1.4</span> <a href="#CommonMaster-DetailImageinSpreadsheetDocument-DownloadCommonMaster-DetailTemplate">Download Common Master-DetailTemplate</a></li><li><span class="TOCOutline">1.5</span> <a href="#CommonMaster-DetailImageinSpreadsheetDocument-GeneratingTheReport">Generating The Report</a></li><li><span class="TOCOutline">1.6</span> <a href="#CommonMaster-DetailImageinSpreadsheetDocument-ODSTemplateandReportinApacheOpenOffice">ODS Template and Report in Apache OpenOffice</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%">&nbsp;</td><td valign="top" width="35%">&nbsp;</td></tr></tbody></table>

{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Common Master-Detail Image report in Spreadsheet Document format.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Common Master-Detail Image in Microsoft Excel Document

### Creating a Common Master-Detail Image

Please follow below steps to create Common Master-Detail Image Template in MS Excel 2013:

1.  Create a new Workbook.
2.  Insert a shape to display image in it.
3.  Go to Insert Tab and select shape by clicking on Shape Icon.
4.  Save the document.

### Reporting Requirement

As a report developer, you are required to represent the information of the managers and clients with the following key requirements:

*   Report must show managers' picture and name.
*   It must associate the managers with their clients.
*   Report must be generated in the Spreadsheet Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

```csharp
<<foreach [in getManagers()]>>
>" style="outline: 0px !important;">
<<[getName()]>>
Clients: <<foreach [in getContracts()]>><<[indexOf() != 0 ? ", " : ""]>><<[getClient().getName()]>><</foreach>>
<</foreach>>

```

### Download Common Master-DetailTemplate

Please download the sample Common Master-Detail document we created in this article:

*   [Common Master-Detail.xlsx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Spreadsheet%20Templates/Common%20Master-Detail.xlsx?raw=true)

### Generating The Report

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Spreadsheet Templates/Common Master-Detail.xlsx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Spreadsheet Reports/Common Master-Detail_report.xlsx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">try</span> {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-LC6" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestDataPath(srcDocument),</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-LC7" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestOutPath(docReport),<span class="pl-k">new</span> <span class="pl-smi">DataSourceInfo</span>( <span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>(), <span class="pl-c1">null</span>));</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-LC8" class="blob-code blob-code-inner js-file-line">} <span class="pl-k">catch</span> (<span class="pl-smi">Exception</span> exp) {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">System</span><span class="pl-k">.</span>out<span class="pl-k">.</span>println(<span class="pl-s"><span class="pl-pds">"</span>Exception: <span class="pl-pds">"</span></span> <span class="pl-k">+</span> exp<span class="pl-k">.</span>getMessage());</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java-LC10" class="blob-code blob-code-inner js-file-line">}</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/4b830352e9eb0a5ca52a2576173f64e6/raw/d75714d003f149ab649a0b81ccec3587a4007b9f/Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-commonmasterdetailspreadsheet.java) [Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-commonmasterdetailspreadsheet.java](https://gist.github.com/GroupDocsGists/4b830352e9eb0a5ca52a2576173f64e6#file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailspreadsheet-java) hosted with ❤ by [GitHub](https://github.com)

### ODS Template and Report in Apache OpenOffice

In order to check compatibility of ODS between Microsoft Office 2010 and Apache OpenOffice 4.1.2, we performed below tests:

*   We opened the ODS template created through Microsoft Office 2010 in Apache OpenOffice 4.1.2. The template opened successfully in Apache OpenOffice without any issues or formatting losses.
*   We opened the ODS report generated through GroupDocs.Assembly in Apache OpenOffice 4.1.2. The report opened successfully in Apache OpenOffice without any issues or formatting losses.
