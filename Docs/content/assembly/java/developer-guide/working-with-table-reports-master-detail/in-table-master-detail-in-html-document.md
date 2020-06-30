---
id: in-table-master-detail-in-html-document
url: assembly/java/in-table-master-detail-in-html-document
title: In-Table Master-Detail in HTML Document
weight: 4
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate In-TableMaster-Detail report in HTML Document format.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## In-Table Master-Detail in HTML Document

### Reporting Requirement

As a report developer, you are required to represent the following key requirements:

*   Report must show each manager along with his total contract prices.
*   It must also show each individual client within the contract.
*   It must show sum of the contract prices.
*   It must represent all the information in tabular form.
*   Report must be generated in the Word Processing Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

<<foreach \[in getManagers()\]>> <<foreach \[in getContracts()\]>> <</foreach>> <</foreach>>

| Manager/Client | Contract Price |
| --- | --- |
| **<<\[getName()\]>>** | <<\[getContracts().sum(c => c.getPrice())\]>> |
| *  <<\[getClient().getName()\]>>* | <<\[getPrice()\]>> |
| **Total:** | <<\[getManagers().sum( m => m.getContracts().sum( c => c.getPrice()))\]>> |

### Download In-Table Master-Detail Template

Please download the sample document we created in this article:

*   [In-Table Master-Detail.html](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Html%20Templates/In-Table%20Master-Detail.html?raw=true)

### Generating The Report

{{< gist GroupDocsGists a467de2001915d62ae4eb9404c1772b5 >}}


