---
id: common-list-image-in-spreadsheet-document
url: assembly/java/common-list-image-in-spreadsheet-document
title: Common List Image in Spreadsheet Document
weight: 2
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Common List Image report in Spreadsheet Document format.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Common List in Microsoft Excel Document

### Creating a Common List

Please follow below steps to create Common List Image in MS Excel 2013:

1.  Insert the desired shape to display image in it.
2.  Go to Insert Tab and select shape by clicking on Shape Icon.
3.  Save your Document.

### Reporting Requirement

As a report developer, you are required to represent the following key requirements:

*   Report must show multiple managers' picture and name.
*   Report must be generated in the Spreadsheet Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

<table class="MsoNormalTable" border="0" cellspacing="0" cellpadding="0" width="293" style="width: 219.75pt; border-collapse: collapse;"><tbody><tr style="height: 15pt;"><td width="293" nowrap="" colspan="4" style="width: 219.75pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><span style="color: black;">&lt;&lt;foreach [in getManagers()]&gt;&gt;</span></p></td></tr><tr style="height: 15pt;"><td width="149" nowrap="" valign="bottom" style="width: 111.55pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><span style="position: absolute; z-index: 251658240; margin-left: 0px; margin-top: 0px; width: 194px; height: 142px;"><img width="194" height="142" src="" alt="<<image [getPhoto()]>>"></span></p><table class="MsoNormalTable" border="0" cellspacing="0" cellpadding="0"><tbody><tr style="height: 15pt;"><td width="64" nowrap="" valign="bottom" style="width: 48pt; padding-top: 0in; padding-right: 0in; padding-bottom: 0in; padding-left: 0in; height: 15pt;"></td></tr></tbody></table></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="142" nowrap="" valign="bottom" style="width: 106.8pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td></tr><tr style="height: 15pt;"><td width="149" nowrap="" valign="bottom" style="width: 111.55pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="142" nowrap="" valign="bottom" style="width: 106.8pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td></tr><tr style="height: 15pt;"><td width="149" nowrap="" valign="bottom" style="width: 111.55pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="142" nowrap="" valign="bottom" style="width: 106.8pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td></tr><tr style="height: 15pt;"><td width="149" nowrap="" valign="bottom" style="width: 111.55pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="142" nowrap="" valign="bottom" style="width: 106.8pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td></tr><tr style="height: 15pt;"><td width="149" nowrap="" valign="bottom" style="width: 111.55pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="142" nowrap="" valign="bottom" style="width: 106.8pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td></tr><tr style="height: 15pt;"><td width="149" nowrap="" valign="bottom" style="width: 111.55pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="142" nowrap="" valign="bottom" style="width: 106.8pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td></tr><tr style="height: 15pt;"><td width="149" nowrap="" valign="bottom" style="width: 111.55pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="142" nowrap="" valign="bottom" style="width: 106.8pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td></tr><tr style="height: 15pt;"><td width="149" nowrap="" valign="bottom" style="width: 111.55pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="142" nowrap="" valign="bottom" style="width: 106.8pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td></tr><tr style="height: 21pt;"><td width="151" nowrap="" colspan="3" style="width: 112.95pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 21pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><b><span style="font-size: 16pt; color: black;">&lt;&lt;[getName()]&gt;&gt;</span></b></p></td><td width="142" nowrap="" style="width: 106.8pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 21pt;"><p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;"><span style="color: black;">&lt;&lt;/foreach&gt;&gt;</span></p></td></tr><tr style="height: 15pt;"><td width="149" nowrap="" style="width: 111.55pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="1" nowrap="" valign="bottom" style="width: 0.7pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td><td width="142" nowrap="" valign="bottom" style="width: 106.8pt; padding-top: 0in; padding-right: 5.4pt; padding-bottom: 0in; padding-left: 5.4pt; height: 15pt;"></td></tr></tbody></table>

### Download Template

Please download the sample Common List document we created in this article:

*   [Common List.xlsx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Spreadsheet%20Templates/Common%20List.xlsx?raw=true)

### Generating The Report

{{< gist GroupDocsGists aaa7f940daf32fbedc127e02ed97f261 >}}



### ODS Template and Report in Apache OpenOffice

In order to check compatibility of ODS between Microsoft Office 2010 and Apache OpenOffice 4.1.2, we performed below tests:

*   We opened the ODS template created through Microsoft Office 2010 in Apache OpenOffice 4.1.2. The template opened successfully in Apache OpenOffice without any issues or formatting losses.

*   We opened the ODS report generated through GroupDocs.Assembly in Apache OpenOffice 4.1.2. The report opened successfully in Apache OpenOffice without any issues or formatting losses.
