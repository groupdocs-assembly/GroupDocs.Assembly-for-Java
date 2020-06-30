---
id: removing-selective-chart-series-dynamically
url: assembly/java/removing-selective-chart-series-dynamically
title: Removing Selective Chart Series Dynamically
weight: 5
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}This feature is supported by version 17.11 or greater{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Column Chart in Microsoft Word Document

### Creating a Column Chart

Practising the following steps, you can insert a Column Chart in MS Word 2013:

1.  Click in the document where you want to insert the chart, click the "Insert" tab, and then click "Chart" in the illustrations group to open the "Insert Chart" dialog box.
2.  Select "Column" in the sidebar, you will see a gallery of charts.
3.  Select the "100% Stacked Column" and press "OK" to insert the chart and Worksheet template to your document.
4.  Edit the Worksheet with your data to update the chart. See [Chart Data (Excel)]({{< ref "assembly/java/developer-guide/working-with-chart-reports-filtered-ordered-grouped/column-chart-in-word-processing-document.md#chart-data(excel" >}})).
5.  Save your Document.

### Reporting Requirement

As a report developer, you are required to share orders quantity of the customers dynamically with the following key requirements:

*   Report must show total Contract Prices by Quarters
*   Report must be generated in the Word Processing Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

#### Chart Title

```java
Total Contract Prices by Quarters
<<foreach[in getContracts()
.where(c => c.getDate().getYear() + 1900 == 2015)
.groupBy(c => c.getManager())
.orderBy(g => g.key.getName())]>><<x[key.getName()]>>
```

#### Chart Data (Excel)

|   | 1st Quarter<<y[where(c => c.getDate().getMonth()>= 0 && c.getDate().getMonth() <= 2).sum(c => c.getPrice())]>><<removeif [mode==1]>> | 2nd Quarter<<y[where(c => c.getDate().getMonth()>= 3 && c.getDate().getMonth() <= 5).sum(c => c.getPrice())]>><<removeif [mode==2]>> | 3rd Quarter<<y[where(c => c.getDate().getMonth()>= 6 && c.getDate().getMonth()<= 8).sum(c => c.getPrice())]>> | 4th Quarter<<y[where(c => c.getDate().getMonth()>= 9 && c.getDate().getMonth()<= 11).sum(c => c.getPrice())]>> |
| --- | --- | --- | --- | --- |
| Category 1 | 4.3 | 2.4 | 2 | 3 |
| Category 2 | 2.5 | 4.4 | 2 | 2 |
| Category 3 | 3.5 | 1.8 | 3 | 5 |
| Category 4 | 4.5 | 2.8 | 5 | 2 |

### Download Template

Please download the sample Chart with Filtering, Grouping, and Ordering document we created in this article:

*   [Chart Template.docx](https://github.com/aliahmedgroupdocs/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Word%20Templates/Chart%20with%20Filtering%2C%20Grouping%2C%20and%20Ordering_RemoveIf.docx)

### Generating The Report

{{< gist GroupDocsGists 18be56c4d11e2e602f786be46736bf2a >}}


