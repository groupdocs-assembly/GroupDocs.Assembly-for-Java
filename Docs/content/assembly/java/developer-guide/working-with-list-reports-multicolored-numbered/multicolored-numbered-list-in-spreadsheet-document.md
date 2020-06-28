---
id: multicolored-numbered-list-in-spreadsheet-document
url: assembly/java/multicolored-numbered-list-in-spreadsheet-document
title: Multicolored Numbered List in Spreadsheet Document
weight: 2
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Multicolored Numbered List report in Spreadsheet Document format.{{< /alert >}}

<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026732451 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026732451 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026732451 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026732451"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#MulticoloredNumberedListinSpreadsheetDocument-MulticoloredNumberedListinMicrosoftExcelDocument">Multicolored Numbered List in Microsoft Excel Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#MulticoloredNumberedListinSpreadsheetDocument-CreatingaMulticoloredNumberedList">Creating a Multicolored Numbered List</a></li><li><span class="TOCOutline">1.2</span> <a href="#MulticoloredNumberedListinSpreadsheetDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.3</span> <a href="#MulticoloredNumberedListinSpreadsheetDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a></li><li><span class="TOCOutline">1.4</span> <a href="#MulticoloredNumberedListinSpreadsheetDocument-DownloadMulticoloredNumberedListTemplate">Download Multicolored Numbered List Template</a></li><li><span class="TOCOutline">1.5</span> <a href="#MulticoloredNumberedListinSpreadsheetDocument-GeneratingTheReport">Generating The Report</a></li><li><span class="TOCOutline">1.6</span> <a href="#MulticoloredNumberedListinSpreadsheetDocument-ODSTemplateandReportinApacheOpenOffice">ODS Template and Report in Apache OpenOffice</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%"></td><td valign="top" width="35%"></td></tr></tbody></table>

## Multicolored Numbered List in Microsoft Excel Document

### Creating a Multicolored Numbered List

Practicing the following steps you can create Multicolored Numbered List Template in MS Excel 2013.

1.  Add a new Workbook.
2.  In one cell, write a sentence like "We provide support for the following clients:".
3.  Select the cell, and assign a color by pressing "Cell Styles" in Styles group.
4.  Save the template.

### Reporting Requirement

As a report developer, you are required to represent the following key requirements:

*   Report must show the clients in numbered list.
*   It must highlight the products.
*   Report must be generated in the Spreadsheet Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

We provide support for the following clients:

1. <<foreach \[in getClients()\]>><<if \[indexOf() % 2 == 0\]>><<\[getName()\]>>

2. <<else>><<\[getName()\]>>

<</if>><</foreach>>

### Download Multicolored Numbered List Template

Please download the sample Multicolored Numbered List document we created in this article:

*   [Multicolored Numbered List.xlsx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Spreadsheet%20Templates/Multicolored%20Numbered%20List.xlsx?raw=true)

### Generating The Report

{{< alert style="info" >}}The code uses some of the objects defined in: The Business Layer{{< /alert >}}

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Spreadsheet Templates/Multicolored Numbered List.xlsx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Spreadsheet Reports/Multicolored Numbered List_report.xlsx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">try</span> {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-LC6" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestDataPath(srcDocument),</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-LC7" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestOutPath(docReport), <span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>(), <span class="pl-c1">null</span>);</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-LC8" class="blob-code blob-code-inner js-file-line">} <span class="pl-k">catch</span> (<span class="pl-smi">Exception</span> exp) {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">System</span><span class="pl-k">.</span>out<span class="pl-k">.</span>println(<span class="pl-s"><span class="pl-pds">"</span>Exception: <span class="pl-pds">"</span></span> <span class="pl-k">+</span> exp<span class="pl-k">.</span>getMessage());</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java-LC10" class="blob-code blob-code-inner js-file-line">}</td></tr></tbody></table>

[view raw](https://gist.github.com/atirtahirgroupdocs/d6c0fde163b9edd0cc9dda4bcd01843a/raw/39b58eddc8c74f8ccc7ab479a4bfd98ef4760505/Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-multicolorednumberedlistspreadsheet.java) [Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-multicolorednumberedlistspreadsheet.java](https://gist.github.com/atirtahirgroupdocs/d6c0fde163b9edd0cc9dda4bcd01843a#file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistspreadsheet-java) hosted with ❤ by [GitHub](https://github.com)

### ODS Template and Report in Apache OpenOffice

In order to check compatibility of ODS between Microsoft Office 2010 and Apache OpenOffice 4.1.2, we performed below tests:

*   We opened the ODS template created through Microsoft Office 2010 in Apache OpenOffice 4.1.2. The template opened successfully in Apache OpenOffice without any issues or formatting losses.
*   We opened the ODS report generated through GroupDocs.Assembly in Apache OpenOffice 4.1.2. The report opened successfully in Apache OpenOffice without any issues or formatting losses.
