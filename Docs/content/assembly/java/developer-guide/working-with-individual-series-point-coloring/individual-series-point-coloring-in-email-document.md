---
id: individual-series-point-coloring-in-email-document
url: assembly/java/individual-series-point-coloring-in-email-document
title: Individual Series Point Coloring in Email Document
weight: 4
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026733297 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026733297 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026733297 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026733297"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#IndividualSeriesPointColoringinEmailDocument-IndividualSeriesPointColoringinEmailDocument">Individual Series Point Coloring in Email Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#IndividualSeriesPointColoringinEmailDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.2</span> <a href="#IndividualSeriesPointColoringinEmailDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a><ul class="toc-indentation"><li><span class="TOCOutline">1.2.1</span> <a href="#IndividualSeriesPointColoringinEmailDocument-ChartTitle">Chart Title</a></li><li><span class="TOCOutline">1.2.2</span> <a href="#IndividualSeriesPointColoringinEmailDocument-ChartData(Excel)">Chart Data (Excel)</a></li></ul></li><li><span class="TOCOutline">1.3</span> <a href="#IndividualSeriesPointColoringinEmailDocument-DownloadPieChartTemplate">Download Pie Chart Template</a></li><li><span class="TOCOutline">1.4</span> <a href="#IndividualSeriesPointColoringinEmailDocument-GeneratingTheReport">Generating The Report</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%">&nbsp;</td><td valign="top" width="35%">&nbsp;</td></tr></tbody></table>

{{< alert style="info" >}}This feature is supported by version 18.6 or greater.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Individual Series Point Coloring in Email Document

Please follow below steps to create Pie Chart in MS Outlook 2013:

1.  Create a new Email
2.  Click the "Insert" tab, and then click "Chart" in the illustrations group to open the "Insert Chart" dialog box
3.  Select "Pie"
4.  Preview "Pie" and press OK to insert the chart and Worksheet template to your email
5.  Edit the Worksheet with your data to update the chart

### Reporting Requirement

As a report developer, you are required to share your customer orders details dynamically with the following key requirements:

*   The report must show information on a Pie Chart
*   It must indicate customer name with value (price of the orders purchased)
*   The report must be generated in the Word Processing Document

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

*   [Dynamic Chart Point Series Color.msg](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Email%20Templates/Dynamic%20Chart%20Point%20Series%20Color.msg) (Template for CustomObject and JSON examples) 

### Generating The Report

For a chart with dynamic data, you can set colors of individual chart series points dynamically based upon expressions. To use the feature, do the following steps:

*   Declare a chart with dynamic data in the usual way
*   For chart series with points to be colored dynamically, define corresponding color expressions in names of these series using **pointColor** tags having the following syntax:
    
    ```csharp
    <<pointColor [color_expression]>>
    ```
    

A color expression must return a value of one of the following types:

*   A string containing the name of a known color, that is, the case-insensitive name of a member of the [KnownColor](https://msdn.microsoft.com/en-us/library/system.drawing.knowncolor(v=vs.110).aspx) enumeration such as "red"
*   An integer value defining RGB (red, green, blue) components of the color such as 0xFFFF00 (yellow)
*   A value of the [Color](http://msdn.microsoft.com/en-us/library/system.drawing.color(v=vs.110).aspx) type

Following code snippet generates the report:

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-dynamicchartseriespointcolor-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-dynamicchartseriespointcolor-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-dynamicchartseriespointcolor-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-dynamicchartseriespointcolor-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Word Templates/Dynamic Chart Point Series Color.docx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-dynamicchartseriespointcolor-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-dynamicchartseriespointcolor-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Word Reports/Dynamic Chart Point Series Color.docx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-dynamicchartseriespointcolor-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-dynamicchartseriespointcolor-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">try</span> {</td></tr><tr><td id="file-dynamicchartseriespointcolor-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-dynamicchartseriespointcolor-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">Manager</span> manager <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>()<span class="pl-k">.</span>getManagers()<span class="pl-k">.</span>iterator()<span class="pl-k">.</span>next();</td></tr><tr><td id="file-dynamicchartseriespointcolor-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-dynamicchartseriespointcolor-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-dynamicchartseriespointcolor-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-dynamicchartseriespointcolor-java-LC7" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span><span class="pl-k">.</span>setUseReflectionOptimization(<span class="pl-c1">false</span>);</td></tr><tr><td id="file-dynamicchartseriespointcolor-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-dynamicchartseriespointcolor-java-LC8" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getDataPath(srcDocument),</td></tr><tr><td id="file-dynamicchartseriespointcolor-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-dynamicchartseriespointcolor-java-LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOutPath(docReport), <span class="pl-k">new</span> <span class="pl-smi">DataSourceInfo</span>(<span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>(), <span class="pl-c1">null</span>));</td></tr><tr><td id="file-dynamicchartseriespointcolor-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-dynamicchartseriespointcolor-java-LC10" class="blob-code blob-code-inner js-file-line">} <span class="pl-k">catch</span> (<span class="pl-smi">Exception</span> exp) {</td></tr><tr><td id="file-dynamicchartseriespointcolor-java-L11" class="blob-num js-line-number" data-line-number="11"></td><td id="file-dynamicchartseriespointcolor-java-LC11" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">System</span><span class="pl-k">.</span>out<span class="pl-k">.</span>println(<span class="pl-s"><span class="pl-pds">"</span>Exception: <span class="pl-pds">"</span></span> <span class="pl-k">+</span> exp<span class="pl-k">.</span>getMessage());</td></tr><tr><td id="file-dynamicchartseriespointcolor-java-L12" class="blob-num js-line-number" data-line-number="12"></td><td id="file-dynamicchartseriespointcolor-java-LC12" class="blob-code blob-code-inner js-file-line">}</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/e7243f17c5067c01c1b77bdf2aca1813/raw/a7ce6f70a46bfc24dd77d35570d00d93ffa026af/dynamicChartSeriesPointColor.java) [dynamicChartSeriesPointColor.java](https://gist.github.com/GroupDocsGists/e7243f17c5067c01c1b77bdf2aca1813#file-dynamicchartseriespointcolor-java) hosted with ❤ by [GitHub](https://github.com)
