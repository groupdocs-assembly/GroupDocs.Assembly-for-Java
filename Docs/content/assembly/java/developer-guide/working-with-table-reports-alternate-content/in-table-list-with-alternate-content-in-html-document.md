---
id: in-table-list-with-alternate-content-in-html-document
url: assembly/java/in-table-list-with-alternate-content-in-html-document
title: In-Table List With Alternate Content in HTML Document
weight: 4
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate In-TableList WithAlternateContent report in HTML Document format.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## In-Table List With Alternate Content in HTML Document

### Reporting Requirement

As a report developer, you are required to represent your clients and their prices with the following key requirements:

*   Report must show each client along with its price.
*   It must show sum of all the prices.
*   It must represent all the information in tabular form.
*   Report must be generated in the HTML Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

<<if \[!getContracts().any()\]>> <<else>><<foreach \[in getContracts()\]>> <</foreach>> <</if>>

| Client | Contract Price |
| --- | --- |
| **No data** |
| **<<\[getClient().getName()\]>>** | <<\[getPrice()\]>> |
| **Total:** | <<\[getContracts().sum(c => c.getPrice())\]>> |

### Download In-Paragraph List Template

Please download the sample In-Table List With Alternate Content document we created in this article:

*   [In-Table List With Alternate Content.html](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Html%20Templates/In-Table%20List%20with%20Alternate%20Content.html?raw=true)

### Generating The Report

{{< gist GroupDocsGists 7b0cb529d9df041f753402fca04f03cc >}}


