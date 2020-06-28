---
id: individual-series-point-coloring-in-spreadsheet-document
url: assembly/java/individual-series-point-coloring-in-spreadsheet-document
title: Individual Series Point Coloring in Spreadsheet Document
weight: 3
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026733287 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026733287 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026733287 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026733287"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#IndividualSeriesPointColoringinSpreadsheetDocument-IndividualSeriesPointColoringinSpreadsheetDocument">Individual Series Point Coloring in Spreadsheet Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#IndividualSeriesPointColoringinSpreadsheetDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.2</span> <a href="#IndividualSeriesPointColoringinSpreadsheetDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a><ul class="toc-indentation"><li><span class="TOCOutline">1.2.1</span> <a href="#IndividualSeriesPointColoringinSpreadsheetDocument-ChartTitle">Chart Title</a></li><li><span class="TOCOutline">1.2.2</span><a href="#IndividualSeriesPointColoringinSpreadsheetDocument-ChartData"><br>Chart Data</a></li></ul></li><li><span class="TOCOutline">1.3</span> <a href="#IndividualSeriesPointColoringinSpreadsheetDocument-DownloadPieChartTemplate">Download Pie Chart Template</a></li><li><span class="TOCOutline">1.4</span> <a href="#IndividualSeriesPointColoringinSpreadsheetDocument-GeneratingTheReport">Generating The Report</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%">&nbsp;</td><td valign="top" width="35%">&nbsp;</td></tr></tbody></table>

{{< alert style="info" >}}This feature is supported by version 18.5 or greater.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Individual Series Point Coloring in Spreadsheet Document

Please follow below steps to can create Pie Chart in MS Excel 2013.

1.  Add a new Workbook
2.  Click on the workbook where you want to insert the chart, click the "Insert" tab, and then click "Pie Chart Icon" in the charts group
3.  A drop-down with charts will appear, select the "Pie" and press "OK" to insert the chart
4.  Click on the chart you just inserted, then click the "Change Data" icon in Data group
5.  Now add legend entries. See [Chart Data](https://docs.dynabic.com/display/assemblynet/Pie+Chart+in+Spreadsheet+Document#PieChartinSpreadsheetDocument-ChartData)
6.  Save your Document

### Reporting Requirement

As a report developer, you are required to share your customers' orders details dynamically with the following key requirements:

*   The report must show information on a Pie Chart
*   It must indicate customer name with value (price of the orders purchased)
*   The report must be generated in the Spreadsheet Document

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

#### Chart Title

```csharp
Total Order Price<<foreach [in customers]>>
<<x [CustomerName]>>

```

####   
Chart Data

**Legend Entries**

```csharp
="Total Order Price<<y [Order.Sum(c => c.Price)]>><<pointColor[color]>>"
```

{{< alert style="success" >}}For detailed technical information about syntax,expressions and report generation by the engine, please visit: Working with GroupDocs.Assembly Engine{{< /alert >}}

### Download Pie Chart Template

Please download the sample Pie Chart document we created in this article:

*   [Dynamic Chart Point Series Color.xlsx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Spreadsheet%20Templates/Dynamic%20Chart%20Point%20Series%20Color.xlsx) (Template for CustomObject and JSON examples) 

### Generating The Report

For a chart with dynamic data, you can set colors of individual chart series points dynamically based upon expressions. To use the feature, do the following steps:

*   Declare a chart with dynamic data in the usual way
*   For chart series with points to be colored dynamically, define corresponding color expressions in names of these series using **pointColor** tags having the following syntax:
    
    ```csharp
    <<pointColor [color_expression]>>
    ```
    

A color expression must return a value of one of the following types:

*   A string containing the name of a known color, that is, the case-insensitive name of a member of the [KnownColor](https://msdn.microsoft.com/en-us/library/system.drawing.knowncolor(v=vs.110).aspx) enumeration such as "red"
*   An integer value defining RGB (red, green, blue) components of the color such as 0xFFFF00 (yellow)
*   A value of the [Color](http://msdn.microsoft.com/en-us/library/system.drawing.color(v=vs.110).aspx) type

Following code snippet generates the report:

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-dynamicchartseriespointcolorspreadsheet-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-dynamicchartseriespointcolorspreadsheet-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-dynamicchartseriespointcolorspreadsheet-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-dynamicchartseriespointcolorspreadsheet-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Spreadsheet Templates/Dynamic Chart Point Series Color.xlsx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-dynamicchartseriespointcolorspreadsheet-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-dynamicchartseriespointcolorspreadsheet-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Spreadsheet Reports/Dynamic Chart Point Series Color.xlsx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-dynamicchartseriespointcolorspreadsheet-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-dynamicchartseriespointcolorspreadsheet-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">try</span> {</td></tr><tr><td id="file-dynamicchartseriespointcolorspreadsheet-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-dynamicchartseriespointcolorspreadsheet-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">Manager</span> manager <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>()<span class="pl-k">.</span>getManagers()<span class="pl-k">.</span>iterator()<span class="pl-k">.</span>next();</td></tr><tr><td id="file-dynamicchartseriespointcolorspreadsheet-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-dynamicchartseriespointcolorspreadsheet-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-dynamicchartseriespointcolorspreadsheet-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-dynamicchartseriespointcolorspreadsheet-java-LC7" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getDataPath(srcDocument),</td></tr><tr><td id="file-dynamicchartseriespointcolorspreadsheet-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-dynamicchartseriespointcolorspreadsheet-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOutPath(docReport), <span class="pl-k">new</span> <span class="pl-smi">DataSourceInfo</span>(<span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>(), <span class="pl-c1">null</span>));</td></tr><tr><td id="file-dynamicchartseriespointcolorspreadsheet-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-dynamicchartseriespointcolorspreadsheet-java-LC9" class="blob-code blob-code-inner js-file-line">} <span class="pl-k">catch</span> (<span class="pl-smi">Exception</span> exp) {</td></tr><tr><td id="file-dynamicchartseriespointcolorspreadsheet-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-dynamicchartseriespointcolorspreadsheet-java-LC10" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">System</span><span class="pl-k">.</span>out<span class="pl-k">.</span>println(<span class="pl-s"><span class="pl-pds">"</span>Exception: <span class="pl-pds">"</span></span> <span class="pl-k">+</span> exp<span class="pl-k">.</span>getMessage());</td></tr><tr><td id="file-dynamicchartseriespointcolorspreadsheet-java-L11" class="blob-num js-line-number" data-line-number="11"></td><td id="file-dynamicchartseriespointcolorspreadsheet-java-LC11" class="blob-code blob-code-inner js-file-line">}</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/c89788f56c4881a270764bdc0aee2bfd/raw/a27e7d3a70379a52898f2f95b45dc43243a2a9c9/dynamicChartSeriesPointColorSpreadsheet.java) [dynamicChartSeriesPointColorSpreadsheet.java](https://gist.github.com/GroupDocsGists/c89788f56c4881a270764bdc0aee2bfd#file-dynamicchartseriespointcolorspreadsheet-java) hosted with ❤ by [GitHub](https://github.com)
