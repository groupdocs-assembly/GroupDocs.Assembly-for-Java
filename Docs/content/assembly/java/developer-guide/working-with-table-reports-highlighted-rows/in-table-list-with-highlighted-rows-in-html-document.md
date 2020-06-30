---
id: in-table-list-with-highlighted-rows-in-html-document
url: assembly/java/in-table-list-with-highlighted-rows-in-html-document
title: In-Table List with Highlighted Rows in HTML Document
weight: 4
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a In-TableList with Highlighted Rows report in HTML Document format.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## In-Table List with Highlighted Rows in HTML Document

#### Reporting Requirement

As a report developer, you are required to represent the following key requirements:

*   Report must show all the client names with price.
*   Show single client and his single contract price in a single row.
*   It must highlight the record with contract price more than or equal to 1000000.
*   It must show sum of the contract prices.
*   It must represent all the information in tabular form.
*   Report must be generated in the Word Processing Document.

#### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

<<foreach \[in getContracts()\]>> <</foreach>>

| Client | Contract Price |
| --- | --- |
| **<<\[getClient().getName()\]>>** | <<\[getPrice()\]>> |
| **Total:** | <<\[getContracts().sum(c => c.getPrice())\]>> |

#### Download In-Table List with Highlighted Rows Template

Please download the sample template we created in this article:

*   [In-Table List with Highlighted Rows.html](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Html%20Templates/In-Table%20List%20with%20Highlighted%20Rows.html?raw=true)

#### Generating The Report

{{< gist GroupDocsGists 511a909679524da572f03b687e1e4d98 >}}


