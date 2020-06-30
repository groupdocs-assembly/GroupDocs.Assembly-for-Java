---
id: in-table-list-in-html
url: assembly/java/in-table-list-in-html
title: In-Table List in HTML
weight: 4
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a In-TableList report in HTML Document format.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## In-Table List in HTML Document

### Reporting Requirement

As a report developer, you are required to represent the information of the managers with the following key requirements:

*   Report must show managers' name.
*   It must show the sum of contract prices against each manager.
*   It must sum up all the contract prices for all the managers.
*   All the representation must be in tabular form.
*   Report must be generated in the HTML Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

<<foreach \[in getManagers()\]>> <</foreach>>

| Manager | Contract Price |
| --- | --- |
| **<<\[getName()\]>>** | <<\[getContracts().sum(c => c.getPrice())\]>> |
| **Total:** | <<\[getManagers().sum( m => m.getContracts().sum( c => c.getPrice()))\]>> |

### Download In-Table List Template

Please download the sample In-Table List document we created in this article:

*   [In-Table List.html](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Html%20Templates/In-Table%20List.html?raw=true)

### Generating The Report

{{< gist GroupDocsGists bd2c72eba6ad72cf8bc7c89341cb3d24 >}}


