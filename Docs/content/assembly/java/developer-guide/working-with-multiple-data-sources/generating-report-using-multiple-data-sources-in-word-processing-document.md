---
id: generating-report-using-multiple-data-sources-in-word-processing-document
url: assembly/java/generating-report-using-multiple-data-sources-in-word-processing-document
title: Generating Report using Multiple Data Sources in Word Processing Document
weight: 1
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a report. This report will fetch data from multiple data sources.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Generating Report in Microsoft Word Document

### Creating a Template

1.  Add a bullet list at the place where you want it to display clients' names.
2.  Insert a table with two columns, that will show managers' and their contact prices.
3.  Save your Document

### Reporting Requirement

As a report developer, you are required to generate a report that fetches data from two different data sources (e:g custom object, excel data table). Report must show following information:

*   Bulleted list of clients
*   A table showing managers' along with their contract prices and sum of contract prices

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

We provide support for the following clients:

\- <<foreach \[in getClients()\]>><<\[getName()\]>>

<</foreach>>

**Total Contract Prices by Managers**

<table class="MsoTable15Grid1Light" border="1" cellspacing="0" cellpadding="0" style="border-collapse: collapse; border-top-color: initial; border-top-style: none; border-top-width: initial; border-right-color: initial; border-right-style: none; border-right-width: initial; border-bottom-color: initial; border-bottom-style: none; border-bottom-width: initial; border-left-color: initial; border-left-style: none; border-left-width: initial;"><tbody><tr><td width="311" valign="top" style="width: 233.6pt; border-top-color: rgb(153, 153, 153); border-top-style: solid; border-top-width: 1pt; border-right-color: rgb(153, 153, 153); border-right-style: solid; border-right-width: 1pt; border-bottom-color: rgb(102, 102, 102); border-bottom-style: solid; border-bottom-width: 1.5pt; border-left-color: rgb(153, 153, 153); border-left-style: solid; border-left-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b>Manager</b></p></td><td width="312" valign="top" style="width: 233.65pt; border-top-color: rgb(153, 153, 153); border-top-style: solid; border-top-width: 1pt; border-left-color: initial; border-left-style: none; border-left-width: initial; border-bottom-color: rgb(102, 102, 102); border-bottom-style: solid; border-bottom-width: 1.5pt; border-right-color: rgb(153, 153, 153); border-right-style: solid; border-right-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b>Total Contract Price</b></p></td></tr><tr><td width="311" valign="top" style="width: 233.6pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-right-color: rgb(153, 153, 153); border-right-style: solid; border-right-width: 1pt; border-bottom-color: rgb(153, 153, 153); border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: rgb(153, 153, 153); border-left-style: solid; border-left-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b>&lt;&lt;foreach [group in contracts</b></p><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b>&nbsp;&nbsp;&nbsp; .groupBy(c =&gt; c.Manager)</b></p><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b>&nbsp;&nbsp;&nbsp; .orderBy(g =&gt; g.key)]&gt;&gt;&lt;&lt;[group.key]&gt;&gt;</b></p></td><td width="312" valign="top" style="width: 233.65pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-left-color: initial; border-left-style: none; border-left-width: initial; border-bottom-color: rgb(153, 153, 153); border-bottom-style: solid; border-bottom-width: 1pt; border-right-color: rgb(153, 153, 153); border-right-style: solid; border-right-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">&lt;&lt;[group.sum(</p><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">&nbsp;&nbsp;&nbsp; c =&gt; c.Contract_Price)]&gt;&gt;&lt;&lt;/foreach&gt;&gt;</p></td></tr></tbody></table>

### Download Template

Get template from here.

*   [Multiple DS.docx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Word%20Templates/Multiple%20DS.docx?raw=true)

### Generating the ReportGenerating Report using Excel Data Source and Custom Objects

{{< gist GroupDocsGists b9d4a5a09feb9868d1da9e07f3496f00 >}}


