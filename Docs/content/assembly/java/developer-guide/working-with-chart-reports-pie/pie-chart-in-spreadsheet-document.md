---
id: pie-chart-in-spreadsheet-document
url: assembly/java/pie-chart-in-spreadsheet-document
title: Pie Chart in Spreadsheet Document
weight: 2
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026732631 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026732631 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026732631 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026732631"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#PieChartinSpreadsheetDocument-PieChartinMicrosoftExcelDocument">Pie Chart in Microsoft Excel Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#PieChartinSpreadsheetDocument-CreatingaPieChart">Creating a Pie Chart</a></li><li><span class="TOCOutline">1.2</span> <a href="#PieChartinSpreadsheetDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.3</span> <a href="#PieChartinSpreadsheetDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a><ul class="toc-indentation"><li><span class="TOCOutline">1.3.1</span> <a href="#PieChartinSpreadsheetDocument-ChartTitle">Chart Title</a></li><li><span class="TOCOutline">1.3.2</span> <a href="#PieChartinSpreadsheetDocument-ChartData">Chart Data</a></li></ul></li><li><span class="TOCOutline">1.4</span> <a href="#PieChartinSpreadsheetDocument-DownloadPieChartTemplate">Download Pie Chart Template</a></li><li><span class="TOCOutline">1.5</span> <a href="#PieChartinSpreadsheetDocument-GeneratingTheReport">Generating The Report</a></li></ul></li><li><span class="TOCOutline">2</span> <a href="#PieChartinSpreadsheetDocument-PieChartinOpenOfficeSpreadsheetDocument">Pie Chart in OpenOffice Spreadsheet Document</a></li></ul></div></div></div></td><td valign="top" width="15%">&nbsp;</td><td valign="top" width="35%">&nbsp;</td></tr></tbody></table>

{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Pie Chart report in Spreadsheet Document format.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Pie Chart in Microsoft Excel Document

### Creating a Pie Chart

Please follow below steps to create Pie Chart in MS Excel 2013.

1.  Add a new Workbook.
2.  Click in the workbook where you want to insert the chart, click the "Insert" tab, and then click "Pie Chart Icon" in the charts group.
3.  A drop-down with charts will appear, select the "Pie" and press "OK" to insert the chart.
4.  Click on the chart you just inserted, then click the "Change Data" icon in Data group.
5.  Now add legend entries. See [Chart Data]({{< ref "assembly/java/developer-guide/working-with-chart-reports-pie/pie-chart-in-spreadsheet-document.md" >}})
6.  Save your Document.

### Reporting Requirement

As a report developer, you are required to share managers' contract prices dynamically with the following key requirements:

*   Report must show information on a Pie Chart.
*   It must indicate manager name with value (price of the contract).
*   Report must be generated in the Spreadsheet Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

#### Chart Title

```csharp
Total Contract Price<<foreach [in getManagers()]>><<x [getName()]>>

```

#### Chart Data

**Legend Entries**

```csharp
="Total Contract Price<<y [getContracts().sum(c => c.getPrice())]>>"

```

### Download Pie Chart Template

Please download the sample Pie Chart document we created in this article:

*   [Pie Chart.xlsx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Spreadsheet%20Templates/Pie%20Chart.xlsx?raw=true)

### Generating The Report

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Spreadsheet Templates/Pie Chart.xlsx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Spreadsheet Reports/Pie Chart_report.xlsx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">try</span> {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-LC6" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestDataPath(srcDocument),</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-LC7" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestOutPath(docReport), <span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>(), <span class="pl-c1">null</span>);</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-LC8" class="blob-code blob-code-inner js-file-line">} <span class="pl-k">catch</span> (<span class="pl-smi">Exception</span> exp) {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">System</span><span class="pl-k">.</span>out<span class="pl-k">.</span>println(<span class="pl-s"><span class="pl-pds">"</span>Exception: <span class="pl-pds">"</span></span> <span class="pl-k">+</span> exp<span class="pl-k">.</span>getMessage());</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java-LC10" class="blob-code blob-code-inner js-file-line">}</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/a8997c78d41078faf2b39601411357b8/raw/57a5fc23a5e5a7fc0c4c967650ed63967352c3a9/Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-piechartspreadsheet.java) [Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-piechartspreadsheet.java](https://gist.github.com/GroupDocsGists/a8997c78d41078faf2b39601411357b8#file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-piechartspreadsheet-java) hosted with ❤ by [GitHub](https://github.com)

## Pie Chart in OpenOffice Spreadsheet Document

To be investigated.
