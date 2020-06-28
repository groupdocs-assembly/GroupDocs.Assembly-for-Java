---
id: common-master-detail-image-in-presentation-document
url: assembly/java/common-master-detail-image-in-presentation-document
title: Common Master-Detail Image in Presentation Document
weight: 3
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026732999 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026732999 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026732999 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026732999"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#CommonMaster-DetailImageinPresentationDocument-CommonMaster-DetailinMicrosoftPowerPointDocument">Common Master-Detail in Microsoft PowerPoint Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#CommonMaster-DetailImageinPresentationDocument-CreatingaCommonMaster-Detail">Creating a Common Master-Detail</a></li><li><span class="TOCOutline">1.2</span> <a href="#CommonMaster-DetailImageinPresentationDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.3</span> <a href="#CommonMaster-DetailImageinPresentationDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a></li><li><span class="TOCOutline">1.4</span> <a href="#CommonMaster-DetailImageinPresentationDocument-DownloadCommonMaster-DetailTemplate">Download Common Master-Detail Template</a></li><li><span class="TOCOutline">1.5</span> <a href="#CommonMaster-DetailImageinPresentationDocument-GeneratingTheReport">Generating The Report</a></li><li><span class="TOCOutline">1.6</span> <a href="#CommonMaster-DetailImageinPresentationDocument-ODPTemplateandReportinApacheOpenOffice">ODP Template and Report in Apache OpenOffice</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%">&nbsp;</td><td valign="top" width="35%">&nbsp;</td></tr></tbody></table>

{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Common Master-Detail report in Presentation Document format.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Common Master-Detail in Microsoft PowerPoint Document

### Creating a Common Master-Detail

Please follow below steps to create Common Master-Detail Template in MS PowerPoint 2013:

1.  Create a new Presentation.
2.  Insert two shapes, one for holding image and other for holding other details.  
    #Save the document.

### Reporting Requirement

As a report developer, you are required to represent the information of the managers and clients with the following key requirements:

*   Report must show managers' picture and name.
*   It must associate the managers with their clients.
*   Report must be generated in the Presentation Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

```csharp
<<foreach [in getManagers()]>>Manager: <<[getName()]>>
Clients: <<foreach [in getContracts()]>><<[indexOf() != 0 ? ", " : ""]>>
<<[getClient().getName()]>><</foreach>>
<</foreach>>

```

### Download Common Master-Detail Template

Please download the sample Common Master-Detail document we created in this article:

*   [Common Master-Detail.pptx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Presentation%20Templates/Common%20Master-Detail.pptx?raw=true)

### Generating The Report

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-LC1" class="blob-code blob-code-inner js-file-line">// For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-LC2" class="blob-code blob-code-inner js-file-line">String srcDocument = "/Presentation Templates/Common Master-Detail.pptx";</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-LC3" class="blob-code blob-code-inner js-file-line">String docReport = "/Presentation Reports/Common Master-Detail_report.pptx";</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-LC4" class="blob-code blob-code-inner js-file-line">try {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-LC5" class="blob-code blob-code-inner js-file-line">DocumentAssembler assembler = new DocumentAssembler();</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-LC6" class="blob-code blob-code-inner js-file-line">assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-LC7" class="blob-code blob-code-inner js-file-line">CommonUtilities.getTestOutPath(docReport),new DataSourceInfo( new DataStorage(), null));</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-LC8" class="blob-code blob-code-inner js-file-line">} catch (Exception exp) {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-LC9" class="blob-code blob-code-inner js-file-line">System.out.println("Exception: " + exp.getMessage());</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav-LC10" class="blob-code blob-code-inner js-file-line">}</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/fbe130505d1b084c64b66835338c3688/raw/edaced5c60f0d43b3c578244050970eafc3b855f/Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-commonmasterdetailpresentation.jav) [Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-commonmasterdetailpresentation.jav](https://gist.github.com/GroupDocsGists/fbe130505d1b084c64b66835338c3688#file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-commonmasterdetailpresentation-jav) hosted with ❤ by [GitHub](https://github.com)

### ODP Template and Report in Apache OpenOffice

In order to check compatibility of ODP between Microsoft Office 2010 and Apache OpenOffice 4.1.2, we performed below tests:

*   We opened the ODP template created through Microsoft Office 2010 in Apache OpenOffice 4.1.2. The template opened successfully in Apache OpenOffice without any issues or formatting losses.
*   We opened the ODP report generated through GroupDocs.Assembly in Apache OpenOffice 4.1.2. The report opened successfully in Apache OpenOffice without any issues or formatting losses.
