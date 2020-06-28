---
id: individual-series-point-coloring-in-presentation-document
url: assembly/java/individual-series-point-coloring-in-presentation-document
title: Individual Series Point Coloring in Presentation Document
weight: 2
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026733265 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026733265 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026733265 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026733265"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#IndividualSeriesPointColoringinPresentationDocument-IndividualSeriesPointColoringinPresentationDocument">Individual Series Point Coloring in Presentation Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#IndividualSeriesPointColoringinPresentationDocument-CreatingaPieChart">Creating a Pie Chart</a></li><li><span class="TOCOutline">1.2</span> <a href="#IndividualSeriesPointColoringinPresentationDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.3</span> <a href="#IndividualSeriesPointColoringinPresentationDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a><ul class="toc-indentation"><li><span class="TOCOutline">1.3.1</span> <a href="#IndividualSeriesPointColoringinPresentationDocument-ChartTitle">Chart Title</a></li><li><span class="TOCOutline">1.3.2</span> <a href="#IndividualSeriesPointColoringinPresentationDocument-ChartData(Excel)">Chart Data (Excel)</a></li></ul></li><li><span class="TOCOutline">1.4</span> <a href="#IndividualSeriesPointColoringinPresentationDocument-DownloadPieChartTemplate">Download Pie Chart Template</a></li><li><span class="TOCOutline">1.5</span> <a href="#IndividualSeriesPointColoringinPresentationDocument-GeneratingTheReport">Generating The Report</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%">&nbsp;</td><td valign="top" width="35%">&nbsp;</td></tr></tbody></table>

{{< alert style="info" >}}This feature is supported by version 18.5 or greater.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Individual Series Point Coloring in Presentation Document

### Creating a Pie Chart

Please follow below steps to can create Pie Chart in MS PowerPoint 2013:

1.  Add a new presentation slide
2.  Click the "Insert" tab, and then click "Chart" in the illustrations group to open the "Insert Chart" dialog box
3.  Select "Pie"
4.  Preview "Pie" and press OK to insert the chart and Worksheet template to your document
5.  Edit the Worksheet with your data to update the chart. See [Chart Data (Excel)](https://docs.dynabic.com/display/assemblynet/Pie+Chart+in+Presentation+Document#PieChartinPresentationDocument-ChartData(Excel))
6.  Save the template

### Reporting Requirement

As a report developer, you are required to share your customers' orders details dynamically with the following key requirements:

*   The report must show information on a Pie Chart
*   It must indicate customer name with value (price of the orders purchased)
*   The report must be generated in the Presentation Document

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

#### Chart Title

```csharp
Total Order Price<<foreach [in customers]>>
<<x [CustomerName]>>

```

#### Chart Data (Excel)

|   | Total Order Price<<y [Order.Sum(c => c.Price)]>><<pointColor [Color] >> |
| --- | --- |
| A | 8.2 |
| B | 3.2 |
| C | 1.5 |
| D | 1.2 |

{{< alert style="success" >}}For detailed technical information about syntax, expressions and report generation by the engine, please visit: Working with GroupDocs.Assembly Engine{{< /alert >}}

### Download Pie Chart Template

Please download the sample Pie Chart document we created in this article:

*   [Dynamic Chart Point Series Color.pptx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Presentation%20Templates/Dynamic%20Chart%20Point%20Series%20Color.pptx) (Template for CustomObject and JSON examples) 

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

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-dynamicchartseriespointcolorpresentation-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-dynamicchartseriespointcolorpresentation-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-dynamicchartseriespointcolorpresentation-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-dynamicchartseriespointcolorpresentation-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Presentation Templates/Dynamic Chart Point Series Color.pptx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-dynamicchartseriespointcolorpresentation-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-dynamicchartseriespointcolorpresentation-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Presentation Reports/Dynamic Chart Point Series Color.pptx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-dynamicchartseriespointcolorpresentation-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-dynamicchartseriespointcolorpresentation-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">try</span> {</td></tr><tr><td id="file-dynamicchartseriespointcolorpresentation-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-dynamicchartseriespointcolorpresentation-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">Manager</span> manager <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>()<span class="pl-k">.</span>getManagers()<span class="pl-k">.</span>iterator()<span class="pl-k">.</span>next();</td></tr><tr><td id="file-dynamicchartseriespointcolorpresentation-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-dynamicchartseriespointcolorpresentation-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-dynamicchartseriespointcolorpresentation-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-dynamicchartseriespointcolorpresentation-java-LC7" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getDataPath(srcDocument),</td></tr><tr><td id="file-dynamicchartseriespointcolorpresentation-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-dynamicchartseriespointcolorpresentation-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOutPath(docReport),<span class="pl-k">new</span> <span class="pl-smi">DataSourceInfo</span>( <span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>(), <span class="pl-c1">null</span>));</td></tr><tr><td id="file-dynamicchartseriespointcolorpresentation-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-dynamicchartseriespointcolorpresentation-java-LC9" class="blob-code blob-code-inner js-file-line">} <span class="pl-k">catch</span> (<span class="pl-smi">Exception</span> exp) {</td></tr><tr><td id="file-dynamicchartseriespointcolorpresentation-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-dynamicchartseriespointcolorpresentation-java-LC10" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">System</span><span class="pl-k">.</span>out<span class="pl-k">.</span>println(<span class="pl-s"><span class="pl-pds">"</span>Exception: <span class="pl-pds">"</span></span> <span class="pl-k">+</span> exp<span class="pl-k">.</span>getMessage());</td></tr><tr><td id="file-dynamicchartseriespointcolorpresentation-java-L11" class="blob-num js-line-number" data-line-number="11"></td><td id="file-dynamicchartseriespointcolorpresentation-java-LC11" class="blob-code blob-code-inner js-file-line">}</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/30eca90c820e3063f4336dcdeb356c47/raw/920b6e8cab7f20229a1c477e9aa68017bdcb1dfd/dynamicChartSeriesPointColorPresentation.java) [dynamicChartSeriesPointColorPresentation.java](https://gist.github.com/GroupDocsGists/30eca90c820e3063f4336dcdeb356c47#file-dynamicchartseriespointcolorpresentation-java) hosted with ❤ by [GitHub](https://github.com)
