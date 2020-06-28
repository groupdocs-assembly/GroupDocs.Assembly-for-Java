---
id: column-chart-in-spreadsheet-document
url: assembly/java/column-chart-in-spreadsheet-document
title: Column Chart in Spreadsheet Document
weight: 2
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026732141 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026732141 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026732141 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026732141"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#ColumnChartinSpreadsheetDocument-ColumnChartinMicrosoftExcelDocument">Column Chart in Microsoft Excel Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#ColumnChartinSpreadsheetDocument-CreatingaColumnChart">Creating a Column Chart</a></li><li><span class="TOCOutline">1.2</span> <a href="#ColumnChartinSpreadsheetDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.3</span> <a href="#ColumnChartinSpreadsheetDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a><ul class="toc-indentation"><li><span class="TOCOutline">1.3.1</span> <a href="#ColumnChartinSpreadsheetDocument-ChartTitle">Chart Title</a></li><li><span class="TOCOutline">1.3.2</span> <a href="#ColumnChartinSpreadsheetDocument-ChartData">Chart Data</a></li></ul></li><li><span class="TOCOutline">1.4</span> <a href="#ColumnChartinSpreadsheetDocument-DownloadTemplate">Download Template</a></li><li><span class="TOCOutline">1.5</span> <a href="#ColumnChartinSpreadsheetDocument-GeneratingTheReport">Generating The Report</a></li></ul></li><li><span class="TOCOutline">2</span> <a href="#ColumnChartinSpreadsheetDocument-ColumnChartinOpenOfficeSpreadsheetDocument">Column Chart in OpenOffice Spreadsheet Document</a></li></ul></div></div></div></td><td valign="top" width="15%">&nbsp;</td><td valign="top" width="35%">&nbsp;</td></tr></tbody></table>

{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Column Chart Report with Filtered, Ordered and Grouped Data in Spreadsheet Document format.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Column Chart in Microsoft Excel Document

### Creating a Column Chart

Following below steps, you can create column chart in MS Excel 2013:

1.  Create a new Workbook.
2.  Click the "Insert" tab, and then click "Insert Column Chart" icon in the Charts group to view the drop-down list.
3.  Select the "100% Stacked Column" and press "OK" to insert the chart and Worksheet template to your Worksheet.
4.  Edit the Worksheet with your data to update the chart. See [Chart Data]({{< ref "assembly/java/developer-guide/working-with-chart-reports-filtered-ordered-grouped/column-chart-in-spreadsheet-document.md" >}}).
5.  Save your Document.

### Reporting Requirement

As a report developer, you are required to share orders quantity of the customers dynamically with the following key requirements:

*   Report must show total Contract Prices by Quarters
*   Report must be generated in the Spreadsheet Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

#### Chart Title

```csharp
Total Contract Prices by Quarters<<foreach [in getContracts()
.where(c => c.getDate().getYear() + 1900 == 2015)
.groupBy(c => c.getManager())
.orderBy(g => g.key.getName())]>><<x [key.getName()]>>

```

#### Chart Data

**Legend Entries**

```csharp
="1st Quarter<<y [where(c => c.getDate().getMonth() >= 0 && c.getDate().getMonth() <= 2).sum(c => c.getPrice())]>>"
="2nd Quarter<<y [where(c => c.getDate().getMonth() >= 3 && c.getDate().getMonth() <= 5).sum(c => c.getPrice())]>>"
="3rd Quarter<<y [where(c => c.getDate().getMonth() >= 6 && c.getDate().getMonth() <= 8).sum(c => c.getPrice())]>>"
="4th Quarter<<y [where(c => c.getDate().getMonth() >= 9 && c.getDate().getMonth() <= 11).sum(c => c.getPrice())]>>"

```

### Download Template

Please download the sample Chart with Filtering, Grouping, and Ordering document we created in this article:

*   [Chart Template.xlsx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Spreadsheet%20Templates/Chart%20with%20Filtering%2C%20Grouping%2C%20and%20Ordering.xlsx?raw=true)

### Generating The Report

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Spreadsheet Templates/Chart with Filtering, Grouping, and Ordering.xlsx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Spreadsheet Reports/Chart with Filtering, Grouping, and Ordering_report.xlsx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">try</span> {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-LC6" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestDataPath(srcDocument),</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-LC7" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestOutPath(docReport), <span class="pl-k">new</span> <span class="pl-smi">DataSourceInfo</span>(<span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>(), <span class="pl-c1">null</span>));</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-LC8" class="blob-code blob-code-inner js-file-line">} <span class="pl-k">catch</span> (<span class="pl-smi">Exception</span> exp) {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">System</span><span class="pl-k">.</span>out<span class="pl-k">.</span>println(<span class="pl-s"><span class="pl-pds">"</span>Exception: <span class="pl-pds">"</span></span> <span class="pl-k">+</span> exp<span class="pl-k">.</span>getMessage());</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java-LC10" class="blob-code blob-code-inner js-file-line">}</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/90f1cfd555c77ca915ba4284903bc892/raw/c599688003fcaaa711c070b5aef69a97ef794cec/Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-chartwithfilteringgroupingandorderingspreadsheet.java) [Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-chartwithfilteringgroupingandorderingspreadsheet.java](https://gist.github.com/GroupDocsGists/90f1cfd555c77ca915ba4284903bc892#file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-chartwithfilteringgroupingandorderingspreadsheet-java) hosted with ❤ by [GitHub](https://github.com)

## Column Chart in OpenOffice Spreadsheet Document

To be investigated.
