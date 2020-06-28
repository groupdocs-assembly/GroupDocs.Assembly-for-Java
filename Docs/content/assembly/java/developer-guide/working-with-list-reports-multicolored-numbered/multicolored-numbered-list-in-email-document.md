---
id: multicolored-numbered-list-in-email-document
url: assembly/java/multicolored-numbered-list-in-email-document
title: Multicolored Numbered List in Email Document
weight: 5
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Multicolored Numbered List report in Email Document format.{{< /alert >}}

<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026732497 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026732497 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026732497 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026732497"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#MulticoloredNumberedListinEmailDocument-MulticoloredNumberedListinEmailDocument">Multicolored Numbered List in Email Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#MulticoloredNumberedListinEmailDocument-CreatingaMulticoloredNumberedList">Creating a Multicolored Numbered List</a></li><li><span class="TOCOutline">1.2</span> <a href="#MulticoloredNumberedListinEmailDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.3</span> <a href="#MulticoloredNumberedListinEmailDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a></li><li><span class="TOCOutline">1.4</span> <a href="#MulticoloredNumberedListinEmailDocument-DownloadMulticoloredNumberedListTemplate">Download Multicolored Numbered List Template</a></li><li><span class="TOCOutline">1.5</span> <a href="#MulticoloredNumberedListinEmailDocument-GeneratingTheReport">Generating The Report</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%"></td><td valign="top" width="35%"></td></tr></tbody></table>

## Multicolored Numbered List in Email Document

### Creating a Multicolored Numbered List

Practicing the following steps you can create Multicolored Numbered List Template in MS Outlook 2013.

1.  In your email, write a sentence like "We provide support for the following clients:".
2.  Start numbered list.
3.  Go to the "Design" tab and select color to make it colored list.
4.  Save the template.

### Reporting Requirement

As a report developer, you are required to represent the following key requirements:

*   Report must be in .eml or .msg format.
*   It must add email recipient, css and subject of the email.
*   Report must show the clients in numbered list.
*   It must highlight the products.
*   Report must be generated in the Presentation Document.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

We provide support for the following clients:

1. <<foreach \[in getClients()\]>><<if \[indexOf() % 2 == 0\]>>      <<\[numberOf()\]>>.    <<\[getName()\]>>

2. <<else>>      <<\[numberOf()\]>>.    <<\[getName()\]>>

<</if>><</foreach>>

### Download Multicolored Numbered List Template

Please download the sample Multicolored Numbered List document we created in this article:

*   [Multicolored Numbered List.eml](https://raw.githubusercontent.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Email%20Templates/Bulleted%20List.eml?raw=true)

### Generating The Report

{{< alert style="info" >}}The code uses some of the objects defined in: The Business Layer{{< /alert >}}

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-emailmulticolorednumberedlist-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-emailmulticolorednumberedlist-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-emailmulticolorednumberedlist-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-emailmulticolorednumberedlist-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Email Templates/Multicolored Numbered List.eml<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-emailmulticolorednumberedlist-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-emailmulticolorednumberedlist-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Email Reports/Multicolored Numbered List_report.eml<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-emailmulticolorednumberedlist-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-emailmulticolorednumberedlist-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">Object</span>[] getDataSourceDetails <span class="pl-k">=</span> <span class="pl-smi">DataStorage</span><span class="pl-k">.</span>emailDataSourceObject(<span class="pl-s"><span class="pl-pds">"</span>Multicolored Numbered List.eml<span class="pl-pds">"</span></span>, <span class="pl-s"><span class="pl-pds">"</span>.eml<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-emailmulticolorednumberedlist-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-emailmulticolorednumberedlist-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-k">String</span>[] dataSourceNames <span class="pl-k">=</span> <span class="pl-smi">DataStorage</span><span class="pl-k">.</span>emailDataSourceName(<span class="pl-s"><span class="pl-pds">"</span>.eml<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-emailmulticolorednumberedlist-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-emailmulticolorednumberedlist-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-emailmulticolorednumberedlist-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-emailmulticolorednumberedlist-java-LC7" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getDataPath(srcDocument),</td></tr><tr><td id="file-emailmulticolorednumberedlist-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-emailmulticolorednumberedlist-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOutPath(docReport), getDataSourceDetails,</td></tr><tr><td id="file-emailmulticolorednumberedlist-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-emailmulticolorednumberedlist-java-LC9" class="blob-code blob-code-inner js-file-line">dataSourceNames);</td></tr></tbody></table>

[view raw](https://gist.github.com/samicheemagroupdocs/533045e35a5ec69a56e3e94092e301b6/raw/b5f4a89dacf15407bcb81330a1ffd6b7481eca3d/emailMulticoloredNumberedList.java) [emailMulticoloredNumberedList.java](https://gist.github.com/samicheemagroupdocs/533045e35a5ec69a56e3e94092e301b6#file-emailmulticolorednumberedlist-java) hosted with ❤ by [GitHub](https://github.com)
