---
id: in-table-list-with-filtering-grouping-and-ordering-in-word-processing-document
url: assembly/java/in-table-list-with-filtering-grouping-and-ordering-in-word-processing-document
title: In-Table List with Filtering Grouping and Ordering in Word Processing Document
weight: 1
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
# In-Table List with Filtering, Grouping, and Ordering in Word Processing Document

{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate In-TableList with Filtering, Grouping, and Ordering report in Word Processing Document format.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in [The Business Layer](https://docs.groupdocs.com/assembly/java/the-business-layer/).{{< /alert >}}

## In-Table List with Filtering, Grouping, and Ordering in Microsoft Word Document

### Creating a In-Table List with Filtering, Grouping, and Ordering

Practicing the following steps you can create In-Table List with Filtering, Grouping, and Ordering Template in MS Word 2013.

1.  Click the document where you want to add the table.
2.  Press "Insert" tab to insert the table.
3.  Insert a 2x2 table.
4.  Save the template.

### Reporting Requirement

As a report developer, you are required to represent managers' contract information with the following key requirements:

*   Report must show each manager along with sum of prices of his contracts.
*   It must represent all the information in tabular form.
*   Report must be generated in the Word Processing Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

<table class="MsoNormalTable" border="0" cellspacing="0" cellpadding="0" width="632" style="width: 474pt; border-collapse: collapse;"><tbody><tr style="height: 15.75pt;"><td width="376" style="width: 282pt; border-top-color: rgb(153, 153, 153); border-top-style: solid; border-top-width: 1pt; border-right-color: rgb(153, 153, 153); border-right-style: solid; border-right-width: 1pt; border-bottom-color: rgb(102, 102, 102); border-bottom-style: solid; border-bottom-width: 1.5pt; border-left-color: rgb(153, 153, 153); border-left-style: solid; border-left-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15.75pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b><span style="color: black;">Manager</span></b></p></td><td width="256" style="width: 192pt; border-top-color: rgb(153, 153, 153); border-top-style: solid; border-top-width: 1pt; border-left-color: initial; border-left-style: none; border-left-width: initial; border-bottom-color: rgb(102, 102, 102); border-bottom-style: solid; border-bottom-width: 1.5pt; border-right-color: rgb(153, 153, 153); border-right-style: solid; border-right-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15.75pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b><span style="color: black;">Contract Price</span></b></p></td></tr><tr style="height: 61.5pt;"><td width="376" style="width: 282pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-right-color: rgb(153, 153, 153); border-right-style: solid; border-right-width: 1pt; border-bottom-color: rgb(153, 153, 153); border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: rgb(153, 153, 153); border-left-style: solid; border-left-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 61.5pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b><span style="color: black;">&lt;&lt;foreach [in getContracts()<br>&nbsp;&nbsp;&nbsp; .where(c =&gt; c.getDate().getYear() + 1900 == 2015)<br>&nbsp;&nbsp;&nbsp; .groupBy(c =&gt; c.getManager())<br>&nbsp;&nbsp;&nbsp; .orderBy(g =&gt; g.key.getName())]&gt;&gt;&lt;&lt;[key.getName()]&gt;&gt;</span></b></p></td><td width="256" style="width: 192pt; border-top-color: initial; border-top-style: none; border-top-width: initial; border-left-color: initial; border-left-style: none; border-left-width: initial; border-bottom-color: rgb(153, 153, 153); border-bottom-style: solid; border-bottom-width: 1pt; border-right-color: rgb(153, 153, 153); border-right-style: solid; border-right-width: 1pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 61.5pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><span style="color: black;">&lt;&lt;[sum(c =&gt; c.getPrice())]&gt;&gt;&lt;&lt;/foreach&gt;&gt;</span></p></td></tr></tbody></table>

### Download In-Table List with Filtering, Grouping, and Ordering Template

Please download the sample In-Table List with Filtering, Grouping, and Ordering document we created in this article:

*   [In-Table List with Filtering, Grouping, and Ordering.docx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Word%20Templates/In-Table%20List%20with%20Filtering%2C%20Grouping%2C%20and%20Ordering.docx?raw=true)

### Generating The Report

{{< gist GroupDocsGists 729c3fe954b072ffea852e64521ecca4 >}}

### ODT Template and Report in Apache OpenOffice

In order to check compatibility of ODT between Microsoft Office 2010 and Apache OpenOffice 4.1.2, we performed below tests:

*   We opened the ODT template created through Microsoft Office 2010 in Apache OpenOffice 4.1.2. The template opened successfully in Apache OpenOffice without any issues or formatting losses.
*   We opened the ODT report generated through GroupDocs.Assembly in Apache OpenOffice 4.1.2. The report opened successfully in Apache OpenOffice without any issues or formatting losses.
