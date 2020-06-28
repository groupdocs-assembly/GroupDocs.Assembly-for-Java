---
id: in-paragraph-list-in-email-document
url: assembly/java/in-paragraph-list-in-email-document
title: In-Paragraph List in Email Document
weight: 6
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a In-Paragraph List report in Email Document format.{{< /alert >}}

<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026732919 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026732919 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026732919 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026732919"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#In-ParagraphListinEmailDocument-In-ParagraphListinEmailDocument">In-Paragraph List in Email Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#In-ParagraphListinEmailDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.2</span> <a href="#In-ParagraphListinEmailDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a></li><li><span class="TOCOutline">1.3</span> <a href="#In-ParagraphListinEmailDocument-DownloadIn-ParagraphListTemplate">Download In-Paragraph List Template</a></li><li><span class="TOCOutline">1.4</span> <a href="#In-ParagraphListinEmailDocument-GeneratingTheReport">Generating The Report</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%"></td><td valign="top" width="35%"></td></tr></tbody></table>

## In-Paragraph List in Email Document

### Reporting Requirement

As a report developer, you are required to share the following key requirements:

*   Report must be in .eml or .msg format.
*   It must add email recipient, css and subject of the email.
*   A descriptive or informative line like "We provide support for the following clients:".
*   Show all the clients along with the above sentence.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

```csharp
We provide support for the following clients: <<foreach [in getClients()]>><<[indexOf() != 0 ? ", " : ""]>><<[getName()]>><</foreach>>

```

### Download In-Paragraph List Template

Please download the sample Common List document we created in this article:

*   [In-Paragraph List.eml](https://raw.githubusercontent.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Email%20Templates/Bulleted%20List.eml?raw=true)

### Generating The Report

{{< alert style="info" >}}The code uses some of the objects defined in: The Business Layer{{< /alert >}}

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-emailinparagraphlist-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-emailinparagraphlist-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-emailinparagraphlist-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-emailinparagraphlist-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Email Templates/In-Paragraph List.eml<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-emailinparagraphlist-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-emailinparagraphlist-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Email Reports/In-Paragraph List_report.eml<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-emailinparagraphlist-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-emailinparagraphlist-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">Object</span>[] getDataSourceDetails <span class="pl-k">=</span> <span class="pl-smi">DataStorage</span><span class="pl-k">.</span>emailDataSourceObject(<span class="pl-s"><span class="pl-pds">"</span>In-Paragraph List.eml<span class="pl-pds">"</span></span>, <span class="pl-s"><span class="pl-pds">"</span>.eml<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-emailinparagraphlist-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-emailinparagraphlist-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-k">String</span>[] dataSourceNames <span class="pl-k">=</span> <span class="pl-smi">DataStorage</span><span class="pl-k">.</span>emailDataSourceName(<span class="pl-s"><span class="pl-pds">"</span>.eml<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-emailinparagraphlist-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-emailinparagraphlist-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-emailinparagraphlist-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-emailinparagraphlist-java-LC7" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getDataPath(srcDocument),</td></tr><tr><td id="file-emailinparagraphlist-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-emailinparagraphlist-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOutPath(docReport), getDataSourceDetails,</td></tr><tr><td id="file-emailinparagraphlist-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-emailinparagraphlist-java-LC9" class="blob-code blob-code-inner js-file-line">dataSourceNames);</td></tr></tbody></table>

[view raw](https://gist.github.com/samicheemagroupdocs/3ff4323ee0af247c4d071c002294dff6/raw/7982f1478a2c94672f9559e62d8a19b89057d4e4/emailInParagraphList.java) [emailInParagraphList.java](https://gist.github.com/samicheemagroupdocs/3ff4323ee0af247c4d071c002294dff6#file-emailinparagraphlist-java) hosted with ❤ by [GitHub](https://github.com)
