---
id: generating-report-using-multiple-data-sources-in-spreadsheet-document
url: assembly/java/generating-report-using-multiple-data-sources-in-spreadsheet-document
title: Generating Report using Multiple Data Sources in Spreadsheet Document
weight: 2
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a report. This report will fetch data from multiple data sources.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Generating Report in Microsoft Excel Document

### Creating a Template

1.  Add a bullet list at the place where you want it to display clients' names.
2.  Insert a table with two columns, that will show managers' and their contact prices.
3.  Save your Document

### Reporting Requirement

As a report developer, you are required to generate a report that fetches data from two different data sources (e:g custom object, excel data table). Report must show following information:

*   Bulleted list of clients
*   A table showing managers' along with their contract prices and sum of contract prices

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

<table class="MsoNormalTable" border="0" cellspacing="0" cellpadding="0" width="433" style="width: 324.45pt; border-collapse: collapse;"><tbody><tr style="height: 15pt;"><td width="433" nowrap="" valign="bottom" style="width: 324.45pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b><span style="color: black;">In-cell list</span></b></p></td></tr><tr style="height: 15pt;"><td width="433" nowrap="" valign="bottom" style="width: 324.45pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td></tr><tr style="height: 45pt;"><td width="433" style="width: 324.45pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 45pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><span style="color: black;">We provide support for the following clients:&lt;&lt;foreach [in getClients()]&gt;&gt;<br>- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;&lt;[getName()]&gt;&gt;&lt;&lt;/foreach&gt;&gt;</span></p></td></tr><tr style="height: 15pt;"><td width="433" nowrap="" style="width: 324.45pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td></tr><tr style="height: 15pt;"><td width="433" nowrap="" style="width: 324.45pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b><span style="color: black;">Multiple-cell list</span></b></p></td></tr><tr style="height: 15pt;"><td width="433" nowrap="" style="width: 324.45pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td></tr><tr style="height: 15pt;"><td width="433" nowrap="" valign="bottom" style="width: 324.45pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><span style="color: black;">We provide support for the following clients:</span></p></td></tr><tr style="height: 15pt;"><td width="433" nowrap="" valign="bottom" style="width: 324.45pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><span style="color: black;">&lt;&lt;foreach [in getClients()]&gt;&gt;- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt;&lt;[getName()]&gt;&gt;</span></p></td></tr><tr style="height: 15pt;"><td width="433" nowrap="" valign="bottom" style="width: 324.45pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td></tr><tr style="height: 15pt;"><td width="433" nowrap="" valign="bottom" style="width: 324.45pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td></tr><tr style="height: 15pt;"><td width="433" nowrap="" valign="bottom" style="width: 324.45pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"><table class="MsoTableGrid" border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse; border-top-color: initial; border-top-style: none; border-top-width: initial; border-right-color: initial; border-right-style: none; border-right-width: initial; border-bottom-color: initial; border-bottom-style: none; border-bottom-width: initial; border-left-color: initial; border-left-style: none; border-left-width: initial;"><tbody><tr><td width="200" valign="top" style="width: 150.2pt; border-top-color: windowtext; border-top-style: solid; border-top-width: 1pt; border-right-color: windowtext; border-right-style: solid; border-right-width: 1pt; border-bottom-color: windowtext; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: windowtext; border-left-style: solid; border-left-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b><span style="color: black;">&nbsp;</span></b><span style="color: black;">Total Contract Prices by Managers</span></p></td><td width="217" valign="top" style="width: 162.45pt; border-top-color: windowtext; border-top-style: solid; border-top-width: 1pt; border-right-color: windowtext; border-right-style: solid; border-right-width: 1pt; border-bottom-color: windowtext; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: initial; border-left-style: none; border-left-width: initial; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><span style="font-size: 10pt; font-family: &quot;Times New Roman&quot;, serif;">&nbsp;</span></p></td></tr><tr><td width="200" style="width: 150.2pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-right-color: windowtext; border-right-style: solid; border-right-width: 1pt; border-bottom-color: windowtext; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: windowtext; border-left-style: solid; border-left-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b><span style="color: black;">&nbsp;</span></b><span style="color: black;">&lt;&lt;foreach [group in contracts<br>&nbsp;&nbsp;&nbsp; .groupBy(c =&gt; c.Manager)<br>&nbsp;&nbsp;&nbsp; .orderBy(g =&gt; g.key)]&gt;&gt;&lt;&lt;[group.key]&gt;&gt;</span></p></td><td width="217" valign="top" style="width: 162.45pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-left-color: initial; border-left-style: none; border-left-width: initial; border-bottom-color: windowtext; border-bottom-style: solid; border-bottom-width: 1pt; border-right-color: windowtext; border-right-style: solid; border-right-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><span style="color: black;">&nbsp;&lt;&lt;[group.sum(<br>&nbsp;&nbsp;&nbsp; c =&gt; c.Contract_Price)]&gt;&gt;&lt;&lt;/foreach&gt;&gt;</span></p></td></tr></tbody></table></td></tr></tbody></table>

### Download Template

Get the template from here.

*   [Multiple DS.xlsx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Spreadsheet%20Templates/Multiple%20DS.xlsx?raw=true)

### Generating the ReportGenerating Report using Custom Objects and Excel Data Source

{{< gist GroupDocsGists b758da2fedf86e75aefafe122a297cad >}}


