---
id: multicolored-numbered-list-in-presentation-document
url: assembly/java/multicolored-numbered-list-in-presentation-document
title: Multicolored Numbered List in Presentation Document
weight: 3
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Multicolored Numbered List report in Presentation Document format.{{< /alert >}}

<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026732466 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026732466 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026732466 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026732466"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#MulticoloredNumberedListinPresentationDocument-MulticoloredNumberedListinMicrosoftPowerPointDocument">Multicolored Numbered List in Microsoft PowerPoint Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#MulticoloredNumberedListinPresentationDocument-CreatingaMulticoloredNumberedList">Creating a Multicolored Numbered List</a></li><li><span class="TOCOutline">1.2</span> <a href="#MulticoloredNumberedListinPresentationDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.3</span> <a href="#MulticoloredNumberedListinPresentationDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a></li><li><span class="TOCOutline">1.4</span> <a href="#MulticoloredNumberedListinPresentationDocument-DownloadMulticoloredNumberedListTemplate">Download Multicolored Numbered List Template</a></li><li><span class="TOCOutline">1.5</span> <a href="#MulticoloredNumberedListinPresentationDocument-GeneratingTheReport">Generating The Report</a></li><li><span class="TOCOutline">1.6</span> <a href="#MulticoloredNumberedListinPresentationDocument-ODPTemplateandReportinApacheOpenOffice">ODP Template and Report in Apache OpenOffice</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%"></td><td valign="top" width="35%"></td></tr></tbody></table>

## Multicolored Numbered List in Microsoft PowerPoint Document

### Creating a Multicolored Numbered List

Practicing the following steps you can create Multicolored Numbered List Template in MS PowerPoint 2013.

1.  In your document, write a sentence like "We provide support for the following clients:".
2.  Start numbered list.
3.  Go to the "Design" tab and select color to make it colored list.
4.  Save the template.

### Reporting Requirement

As a report developer, you are required to represent the following key requirements:

*   Report must show the clients in numbered list.
*   It must highlight the products.
*   Report must be generated in the Presentation Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

We provide support for the following clients:

1. <<foreach \[in getClients()\]>><<if \[indexOf() % 2 == 0\]>><<\[getName()\]>>

2. <<else>><<\[getName()\]>>

<</if>><</foreach>>

### Download Multicolored Numbered List Template

Please download the sample Multicolored Numbered List document we created in this article:

*   [Multicolored Numbered List.pptx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Presentation%20Templates/Multicolored%20Numbered%20List.pptx?raw=true)

### Generating The Report

{{< alert style="info" >}}The code uses some of the objects defined in: The Business Layer{{< /alert >}}

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Presentation Templates/Multicolored Numbered List.pptx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Presentation Reports/Multicolored Numbered List_report.pptx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">try</span> {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-LC6" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestDataPath(srcDocument),</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-LC7" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestOutPath(docReport), <span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>(), <span class="pl-c1">null</span>);</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-LC8" class="blob-code blob-code-inner js-file-line">} <span class="pl-k">catch</span> (<span class="pl-smi">Exception</span> exp) {</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">System</span><span class="pl-k">.</span>out<span class="pl-k">.</span>println(<span class="pl-s"><span class="pl-pds">"</span>Exception: <span class="pl-pds">"</span></span> <span class="pl-k">+</span> exp<span class="pl-k">.</span>getMessage());</td></tr><tr><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java-LC10" class="blob-code blob-code-inner js-file-line">}</td></tr></tbody></table>

[view raw](https://gist.github.com/atirtahirgroupdocs/12b6ec3b323811a352fe887de98e37b7/raw/6ea9f5e3cb092ee3f1b193772415a780605e8cbf/Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-multicolorednumberedlistpresentation.java) [Examples-GroupDocs.Assembly.Examples.Java-src-main-java-com-groupdocs-assembly-examples-GenerateReport-multicolorednumberedlistpresentation.java](https://gist.github.com/atirtahirgroupdocs/12b6ec3b323811a352fe887de98e37b7#file-examples-groupdocs-assembly-examples-java-src-main-java-com-groupdocs-assembly-examples-generatereport-multicolorednumberedlistpresentation-java) hosted with ❤ by [GitHub](https://github.com)

### ODP Template and Report in Apache OpenOffice

In order to check compatibility of ODP between Microsoft Office 2010 and Apache OpenOffice 4.1.2, we performed below tests:

*   We opened the ODP template created through Microsoft Office 2010 in Apache OpenOffice 4.1.2. The template opened successfully in Apache OpenOffice without any issues or formatting losses.
*   We opened the ODP report generated through GroupDocs.Assembly in Apache OpenOffice 4.1.2. The report opened successfully in Apache OpenOffice without any issues or formatting losses.
