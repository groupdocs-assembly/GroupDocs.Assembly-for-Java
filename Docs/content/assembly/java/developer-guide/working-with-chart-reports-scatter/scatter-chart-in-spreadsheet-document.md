---
id: scatter-chart-in-spreadsheet-document
url: assembly/java/scatter-chart-in-spreadsheet-document
title: Scatter Chart in Spreadsheet Document
weight: 2
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026732767 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026732767 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026732767 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026732767"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#ScatterChartinSpreadsheetDocument-ScatterChartinMicrosoftExcelDocument">Scatter Chart in Microsoft Excel Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#ScatterChartinSpreadsheetDocument-CreatingaScatterChart">Creating a Scatter Chart</a></li><li><span class="TOCOutline">1.2</span> <a href="#ScatterChartinSpreadsheetDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.3</span> <a href="#ScatterChartinSpreadsheetDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a><ul class="toc-indentation"><li><span class="TOCOutline">1.3.1</span> <a href="#ScatterChartinSpreadsheetDocument-ChartTitle">Chart Title</a></li><li><span class="TOCOutline">1.3.2</span> <a href="#ScatterChartinSpreadsheetDocument-ChartData">Chart Data</a></li></ul></li><li><span class="TOCOutline">1.4</span> <a href="#ScatterChartinSpreadsheetDocument-DownloadScatterChartTemplate">Download Scatter Chart Template</a></li><li><span class="TOCOutline">1.5</span> <a href="#ScatterChartinSpreadsheetDocument-GeneratingTheReport">Generating The Report</a></li></ul></li><li><span class="TOCOutline">2</span> <a href="#ScatterChartinSpreadsheetDocument-ScatterChartinOpenOfficeSpreadsheetDocument">Scatter Chart in OpenOffice Spreadsheet Document</a></li></ul></div></div></div></td><td valign="top" width="15%">&nbsp;</td><td valign="top" width="35%">&nbsp;</td></tr></tbody></table>

{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Scatter Chart report in Spreadsheet Document format.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Scatter Chart in Microsoft Excel Document

### Creating a Scatter Chart

Please follow below steps to create Scatter Chart in MS Excel 2013:

1.  Add a new Workbook.
2.  Click in the workbook where you want to insert the chart, click the "Insert" tab, and then click "Insert Scatter Chart Icon" in the charts group.
3.  A drop-down with charts will appear, select the "Scatter" and press "OK" to insert the chart.
4.  Click on the chart you just inserted, then click the "Change Data" icon in Data group.
5.  Now add legend entries. See [Chart Data]({{< ref "assembly/java/developer-guide/working-with-chart-reports-scatter/scatter-chart-in-spreadsheet-document.md" >}})
6.  Save your Document.

### Reporting Requirement

As a report developer, you are required to show contract prices by month with the following key requirements:

*   Report must show information on a Scatter Chart.
*   It must indicate total contract prices by month.
*   Report must be generated in the Spreadsheet Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

#### Chart Title

```csharp
Total Contract Prices by Months<<foreach [in getContracts()
.groupBy(c => c.getDate().getMonth())]>>

```

#### Chart Data

**Legend Entries**

```csharp
="Total Contract Price<<x [key + 1]>><<y [sum(c => c.getPrice())]>>"

```

### Download Scatter Chart Template

Please download the sample Scatter Chart document we created in this article:

*   [Scatter Chart.xlsx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Spreadsheet%20Templates/Scatter%20Chart.xlsx?raw=true)

### Generating The Report

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Spreadsheet Templates/Scatter Chart.xlsx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Spreadsheet Reports/Scatter Chart_report.xlsx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">try</span> {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-LC6" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestDataPath(srcDocument),</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-LC7" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestOutPath(docReport), <span class="pl-k">new</span> <span class="pl-smi">DataSourceInfo</span>(<span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>(), <span class="pl-c1">null</span>));</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-LC8" class="blob-code blob-code-inner js-file-line">} <span class="pl-k">catch</span> (<span class="pl-smi">Exception</span> exp) {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">System</span><span class="pl-k">.</span>out<span class="pl-k">.</span>println(<span class="pl-s"><span class="pl-pds">"</span>Exception: <span class="pl-pds">"</span></span> <span class="pl-k">+</span> exp<span class="pl-k">.</span>getMessage());</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java-LC10" class="blob-code blob-code-inner js-file-line">}</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/9f23eb8da0d619df8b7c873b6bbd482c/raw/3538fcfc89269c6b0b1972164260dbca58751472/Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-scatterchartspreadsheet.java) [Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-scatterchartspreadsheet.java](https://gist.github.com/GroupDocsGists/9f23eb8da0d619df8b7c873b6bbd482c#file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-scatterchartspreadsheet-java) hosted with ❤ by [GitHub](https://github.com)

## Scatter Chart in OpenOffice Spreadsheet Document

To be investigated.
