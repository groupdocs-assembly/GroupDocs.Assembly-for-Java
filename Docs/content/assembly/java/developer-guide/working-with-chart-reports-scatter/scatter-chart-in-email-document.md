---
id: scatter-chart-in-email-document
url: assembly/java/scatter-chart-in-email-document
title: Scatter Chart in Email Document
weight: 4
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Scatter Chart report in Email Document format.{{< /alert >}}

<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026732799 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026732799 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026732799 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026732799"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#ScatterChartinEmailDocument-ScatterChartinMicrosoftPowerPointDocument">Scatter Chart in Microsoft PowerPoint Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#ScatterChartinEmailDocument-CreatingaScatterChart">Creating a Scatter Chart</a></li><li><span class="TOCOutline">1.2</span> <a href="#ScatterChartinEmailDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.3</span> <a href="#ScatterChartinEmailDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a><ul class="toc-indentation"><li><span class="TOCOutline">1.3.1</span> <a href="#ScatterChartinEmailDocument-ChartTitle">Chart Title</a></li><li><span class="TOCOutline">1.3.2</span> <a href="#ScatterChartinEmailDocument-ChartData(Email)">Chart Data (Email)</a></li></ul></li><li><span class="TOCOutline">1.4</span> <a href="#ScatterChartinEmailDocument-DownloadScatterChartTemplate">Download Scatter Chart Template</a></li><li><span class="TOCOutline">1.5</span> <a href="#ScatterChartinEmailDocument-GeneratingTheReport">Generating The Report</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%"></td><td valign="top" width="35%"></td></tr></tbody></table>

## Scatter Chart in Microsoft PowerPoint Document

### Creating a Scatter Chart

Please following below steps to create Scatter Chart in MS Outlook 2013:

1.  Create a new Email.
2.  Click in the email where you want to insert the chart, click the "Insert" tab, and then click "Chart" in the illustrations group to open the "Insert Chart" dialog box.
3.  Select "XY (Scatter)".
4.  Preview "Scatter" and press OK to insert the chart and Worksheet template to your email.
5.  Edit the Worksheet with your data to update the chart.
6.  Save the template.

### Reporting Requirement

As a report developer, you are required to show contract prices by month with the following key requirements:

*   Report must be in .eml or .msg format.
*   It must add email recipient, css and subject of the email.
*   Report must show information on a Scatter Chart.
*   It must indicate total contract prices by month.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

#### Chart Title

```csharp
Total Contract Prices by Months<<foreach [in getContracts()
.groupBy(c => c.getDate().getMonth())]>>

```

#### Chart Data (Email)

<table border="1" cellspacing="0" cellpadding="0" align="left" width="623" style="width: 467.5pt; border-collapse: collapse; border-top-color: initial; border-top-style: none; border-top-width: initial; border-right-color: initial; border-right-style: none; border-right-width: initial; border-bottom-color: initial; border-bottom-style: none; border-bottom-width: initial; border-left-color: initial; border-left-style: none; border-left-width: initial; margin-left: 6.75pt; margin-right: 6.75pt;"><tbody><tr><td width="312" valign="top" style="width: 233.75pt; border-top-color: windowtext; border-top-style: solid; border-top-width: 1pt; border-right-color: windowtext; border-right-style: solid; border-right-width: 1pt; border-bottom-color: windowtext; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: windowtext; border-left-style: solid; border-left-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p style="margin-bottom: 0.0001pt; line-height: normal;">X-Values</p></td><td width="312" valign="top" style="width: 233.75pt; border-top-color: windowtext; border-top-style: solid; border-top-width: 1pt; border-right-color: windowtext; border-right-style: solid; border-right-width: 1pt; border-bottom-color: windowtext; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: initial; border-left-style: none; border-left-width: initial; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p style="margin-bottom: 0.0001pt; line-height: normal;"><span style="color: black;">Total Contract Price&lt;&lt;x [key + 1]&gt;&gt;&lt;&lt;y [sum(c =&gt; c.getPrice())]&gt;&gt;</span></p></td></tr><tr><td width="312" valign="top" style="width: 233.75pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-right-color: windowtext; border-right-style: solid; border-right-width: 1pt; border-bottom-color: windowtext; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: windowtext; border-left-style: solid; border-left-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p style="margin-bottom: 0.0001pt; line-height: normal;">0.7</p></td><td width="312" valign="top" style="width: 233.75pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-left-color: initial; border-left-style: none; border-left-width: initial; border-bottom-color: windowtext; border-bottom-style: solid; border-bottom-width: 1pt; border-right-color: windowtext; border-right-style: solid; border-right-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p align="right" style="margin-bottom: 0.0001pt; text-align: right; line-height: normal;"><span style="color: black;">2.7</span></p></td></tr><tr><td width="312" valign="top" style="width: 233.75pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-right-color: windowtext; border-right-style: solid; border-right-width: 1pt; border-bottom-color: windowtext; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: windowtext; border-left-style: solid; border-left-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p style="margin-bottom: 0.0001pt; line-height: normal;">1.8</p></td><td width="312" valign="top" style="width: 233.75pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-left-color: initial; border-left-style: none; border-left-width: initial; border-bottom-color: windowtext; border-bottom-style: solid; border-bottom-width: 1pt; border-right-color: windowtext; border-right-style: solid; border-right-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p align="right" style="margin-bottom: 0.0001pt; text-align: right; line-height: normal;"><span style="color: black;">3.2</span></p></td></tr><tr><td width="312" valign="top" style="width: 233.75pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-right-color: windowtext; border-right-style: solid; border-right-width: 1pt; border-bottom-color: windowtext; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: windowtext; border-left-style: solid; border-left-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p style="margin-bottom: 0.0001pt; line-height: normal;">2.6</p></td><td width="312" valign="top" style="width: 233.75pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-left-color: initial; border-left-style: none; border-left-width: initial; border-bottom-color: windowtext; border-bottom-style: solid; border-bottom-width: 1pt; border-right-color: windowtext; border-right-style: solid; border-right-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p align="right" style="margin-bottom: 0.0001pt; text-align: right; line-height: normal;"><span style="color: black;">0.8</span></p></td></tr></tbody></table>

  
  
  
  
  
  
  
  

### Download Scatter Chart Template

Please download the sample Scatter Chart document we created in this article:

*   [Scatter Chart.eml](https://raw.githubusercontent.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Email%20Templates/Bulleted%20List.eml?raw=true)

### Generating The Report

{{< alert style="info" >}}The code uses some of the objects defined in: The Business Layer{{< /alert >}}

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-emailscatterchart-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-emailscatterchart-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-emailscatterchart-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-emailscatterchart-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Email Templates/Scatter Chart.eml<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-emailscatterchart-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-emailscatterchart-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Email Reports/Scatter Chart_report.eml<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-emailscatterchart-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-emailscatterchart-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">Object</span>[] getDataSourceDetails <span class="pl-k">=</span> <span class="pl-smi">DataStorage</span><span class="pl-k">.</span>emailDataSourceObject(<span class="pl-s"><span class="pl-pds">"</span>Scatter Chart.eml<span class="pl-pds">"</span></span>, <span class="pl-s"><span class="pl-pds">"</span>.eml<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-emailscatterchart-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-emailscatterchart-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-k">String</span>[] dataSourceNames <span class="pl-k">=</span> <span class="pl-smi">DataStorage</span><span class="pl-k">.</span>emailDataSourceName(<span class="pl-s"><span class="pl-pds">"</span>.eml<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-emailscatterchart-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-emailscatterchart-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-emailscatterchart-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-emailscatterchart-java-LC7" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getDataPath(srcDocument),</td></tr><tr><td id="file-emailscatterchart-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-emailscatterchart-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOutPath(docReport), getDataSourceDetails,</td></tr><tr><td id="file-emailscatterchart-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-emailscatterchart-java-LC9" class="blob-code blob-code-inner js-file-line">dataSourceNames);</td></tr></tbody></table>

[view raw](https://gist.github.com/samicheemagroupdocs/0127601c204a7ff3449fd2dae98eb7d6/raw/cc1f989074fd331dc80e9e5d1c100741d3d7ccad/emailScatterChart.java) [emailScatterChart.java](https://gist.github.com/samicheemagroupdocs/0127601c204a7ff3449fd2dae98eb7d6#file-emailscatterchart-java) hosted with ❤ by [GitHub](https://github.com)
