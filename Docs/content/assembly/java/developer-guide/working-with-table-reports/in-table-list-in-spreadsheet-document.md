---
id: in-table-list-in-spreadsheet-document
url: assembly/java/in-table-list-in-spreadsheet-document
title: In-Table List in Spreadsheet Document
weight: 2
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a In-TableList report in Spreadsheet format.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in [The Business Layer](https://docs.groupdocs.com/assembly/java/the-business-layer/).{{< /alert >}}

## In-Table List in Microsoft Excel Document

### Creating a In-Table List

Practising the following steps you can create In-Table List Template in MS Excel 2013.

1.  Add a new Workbook.
2.  Select the range of cells that you want to include in the table.
3.  On the Insert tab, in the Tables group, click Table.
4.  Save your Document.

### Reporting Requirement

As a report developer, you are required to represent the information of the managers with the following key requirements:

*   Report must show managers' name.
*   It must show the sum of contract prices against each manager.
*   It must sum up all the contract prices for all the managers.
*   All the representation must be in tabular form.
*   Report must be generated in the Spreadsheet Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

<table class="MsoNormalTable" border="0" cellspacing="0" cellpadding="0" width="597" style="width: 448pt; border-collapse: collapse;"><tbody><tr style="height: 15.75pt;"><td width="384" style="width: 4in; border-top-color: rgb(153, 153, 153); border-top-style: solid; border-top-width: 1pt; border-right-color: rgb(153, 153, 153); border-right-style: solid; border-right-width: 1pt; border-bottom-color: rgb(102, 102, 102); border-bottom-style: solid; border-bottom-width: 1.5pt; border-left-color: rgb(153, 153, 153); border-left-style: solid; border-left-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15.75pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b><span style="color: black;">Manager</span></b></p></td><td width="213" style="width: 160pt; border-top-color: rgb(153, 153, 153); border-top-style: solid; border-top-width: 1pt; border-left-color: initial; border-left-style: none; border-left-width: initial; border-bottom-color: rgb(102, 102, 102); border-bottom-style: solid; border-bottom-width: 1.5pt; border-right-color: rgb(153, 153, 153); border-right-style: solid; border-right-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15.75pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b><span style="color: black;">Contract Price</span></b></p></td></tr><tr style="height: 46.5pt;"><td width="384" style="width: 4in; border-top-color: initial; border-top-style: none; border-top-width: initial; border-right-color: rgb(153, 153, 153); border-right-style: solid; border-right-width: 1pt; border-bottom-color: rgb(153, 153, 153); border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: rgb(153, 153, 153); border-left-style: solid; border-left-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 46.5pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b><span style="color: black;">&lt;&lt;foreach [in getManagers()]&gt;&gt;&lt;&lt;[getName()]&gt;&gt;</span></b></p></td><td width="213" style="width: 160pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-left-color: initial; border-left-style: none; border-left-width: initial; border-bottom-color: rgb(153, 153, 153); border-bottom-style: solid; border-bottom-width: 1pt; border-right-color: rgb(153, 153, 153); border-right-style: solid; border-right-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 46.5pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><span style="color: black;">&lt;&lt;[getContracts().sum(<br>&nbsp; c =&gt; c.getPrice())]&gt;&gt;&lt;&lt;/foreach&gt;&gt;</span></p></td></tr><tr style="height: 45.75pt;"><td width="384" style="width: 4in; border-top-color: initial; border-top-style: none; border-top-width: initial; border-right-color: rgb(153, 153, 153); border-right-style: solid; border-right-width: 1pt; border-bottom-color: rgb(153, 153, 153); border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: rgb(153, 153, 153); border-left-style: solid; border-left-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 45.75pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b><span style="color: black;">Total:</span></b></p></td><td width="213" style="width: 160pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-left-color: initial; border-left-style: none; border-left-width: initial; border-bottom-color: rgb(153, 153, 153); border-bottom-style: solid; border-bottom-width: 1pt; border-right-color: rgb(153, 153, 153); border-right-style: solid; border-right-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 45.75pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><span style="color: black;">&lt;&lt;[getManagers().sum(<br>&nbsp; m =&gt; m.getContracts().sum(<br>&nbsp;&nbsp;&nbsp; c =&gt; c.getPrice()))]&gt;&gt;</span></p></td></tr></tbody></table>
### Download In-Table List Template

Please download the sample In-Table List document we created in this article:

*   [In-Table List.xlsx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Spreadsheet%20Templates/In-Table%20List.xlsx?raw=true)

### Generating The Report

{{< gist GroupDocsGists a85a917d5602e18168b0f98f7de9f1bd >}}

### ODS Template and Report in Apache OpenOffice

In order to check compatibility of ODS between Microsoft Office 2010 and Apache OpenOffice 4.1.2, we performed below tests:

*   We opened the ODS template created through Microsoft Office 2010 in Apache OpenOffice 4.1.2. The template opened successfully in Apache OpenOffice without any issues or formatting losses.
*   We opened the ODS report generated through GroupDocs.Assembly in Apache OpenOffice 4.1.2. The report opened successfully in Apache OpenOffice without any issues or formatting losses.
