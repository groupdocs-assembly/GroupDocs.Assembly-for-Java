---
id: generating-report-using-multiple-data-sources-in-presentation-document
url: assembly/java/generating-report-using-multiple-data-sources-in-presentation-document
title: Generating Report using Multiple Data Sources in Presentation Document
weight: 3
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a report. This report will fetch data from multiple data sources.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Generating Report in Microsoft PowerPoint Document

### Creating a Template

1.  Add a bullet list at the place where you want it to display clients' names.
2.  Insert a table with two columns, that will show managers' and their contact prices.
3.  Save your Document

### Reporting Requirement

As a report developer, you are required to generate a report that fetches data from two different data sources (e:g custom object, excel data table). Report must show following information:

*   Bulleted list of clients
*   A table showing managers' along with their contract prices and sum of contract prices

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

**We provide support for the following clients:**

• **<<foreach \[in getClients()\]>><<\[getName()\]>>**

**Total Contract Prices by Managers**  
  

<table class="MsoNormalTable" border="0" cellspacing="0" cellpadding="0" align="left" width="623" style="width: 467pt; border-collapse: collapse; margin-left: 6.75pt; margin-right: 6.75pt;"><tbody><tr><td width="311" valign="top" style="width: 233.4pt; border-top-color: white; border-top-style: solid; border-top-width: 1pt; border-right-color: white; border-right-style: solid; border-right-width: 1pt; border-bottom-color: white; border-bottom-style: solid; border-bottom-width: 3pt; border-left-color: white; border-left-style: solid; border-left-width: 1pt; background-color: rgb(91, 155, 213); background-image: initial; padding-top: 0.75pt; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p class="MsoNormal"><b><span style="color: black;">Manager</span></b></p></td><td width="311" valign="top" style="width: 233.6pt; border-top-color: white; border-top-style: solid; border-top-width: 1pt; border-left-color: initial; border-left-style: none; border-left-width: initial; border-bottom-color: white; border-bottom-style: solid; border-bottom-width: 3pt; border-right-color: white; border-right-style: solid; border-right-width: 1pt; background-color: rgb(91, 155, 213); background-image: initial; padding-top: 0.75pt; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p class="MsoNormal"><b><span style="color: black;">Total Contract Price</span></b></p></td></tr><tr><td width="311" valign="top" style="width: 233.4pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-right-color: white; border-right-style: solid; border-right-width: 1pt; border-bottom-color: white; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: white; border-left-style: solid; border-left-width: 1pt; background-color: rgb(91, 155, 213); background-image: initial; padding-top: 0.75pt; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p class="MsoNormal"><b><span style="color: black;">&lt;&lt;foreach [group in contracts</span></b></p><p class="MsoNormal"><b><span style="color: black;">&nbsp;&nbsp;&nbsp; .groupBy(c =&gt; c.Manager)</span></b></p><p class="MsoNormal"><b><span style="color: black;">&nbsp;&nbsp;&nbsp; .orderBy(g =&gt; g.key)]&gt;&gt;&lt;&lt;[group.key]&gt;&gt;</span></b></p></td><td width="311" valign="top" style="width: 233.6pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-left-color: initial; border-left-style: none; border-left-width: initial; border-bottom-color: white; border-bottom-style: solid; border-bottom-width: 1pt; border-right-color: white; border-right-style: solid; border-right-width: 1pt; background-color: rgb(210, 222, 239); background-image: initial; padding-top: 0.75pt; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt;"><p class="MsoNormal"><b><span style="color: black;">&lt;&lt;[group.sum(</span></b></p><p class="MsoNormal"><b><span style="color: black;">&nbsp;&nbsp;&nbsp; c =&gt; c.Contract_Price)]&gt;&gt;&lt;&lt;/foreach&gt;&gt;</span></b></p></td></tr></tbody></table>

  
  
  
  
  
  

### Download Template

Get the template from here.

*   [Multiple DS.pptx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Presentation%20Templates/Multiple%20DS.pptx?raw=true)

### Generating the Report

{{< gist GroupDocsGists 3ab9d5c532752f52d597b6cb5fb39ed9 >}}


