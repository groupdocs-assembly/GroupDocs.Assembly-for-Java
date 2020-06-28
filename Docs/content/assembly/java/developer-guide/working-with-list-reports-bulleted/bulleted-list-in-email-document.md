---
id: bulleted-list-in-email-document
url: assembly/java/bulleted-list-in-email-document
title: Bulleted List in Email Document
weight: 6
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Bulleted List report in Email format.{{< /alert >}}

<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026732017 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026732017 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026732017 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026732017"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#BulletedListinEmailDocument-BulletedListinEmail">Bulleted List in Email</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#BulletedListinEmailDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.2</span> <a href="#BulletedListinEmailDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a><ul class="toc-indentation"><li><span class="TOCOutline">1.2.1</span> <a href="#BulletedListinEmailDocument-Recipients,CcandSubject">Recipients, Cc and Subject</a></li><li><span class="TOCOutline">1.2.2</span> <a href="#BulletedListinEmailDocument-Body">Body</a></li></ul></li><li><span class="TOCOutline">1.3</span> <a href="#BulletedListinEmailDocument-DownloadBulletedListTemplate">Download Bulleted List Template</a></li><li><span class="TOCOutline">1.4</span> <a href="#BulletedListinEmailDocument-GeneratingTheReport">Generating The Report</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%"></td><td valign="top" width="35%"></td></tr></tbody></table>

## Bulleted List in Email

### Reporting Requirement

As a report developer, you are required to share the following key requirements:

*   Report must be in .eml or .msg format.
*   It must add email recipient, css and subject of the email.
*   Report must show all the clients in a bulleted list format.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

#### Recipients, Cc and Subject

```csharp
<<foreach [r in recipients]>><<[r]>>; <</foreach>>
<<[cc]>>
<<[subject]>>

```

#### Body

```csharp
We provide support for the following clients:
<<foreach [in getClients()]>>•	<<[getName()]>>
<</foreach>>

```

### Download Bulleted List Template

Please download the sample Bulleted List document we created in this article:

*   [Bulleted List.eml](https://raw.githubusercontent.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Email%20Templates/Bulleted%20List.eml?raw=true)

### Generating The Report

{{< alert style="info" >}}The code uses some of the objects defined in: The Business Layer{{< /alert >}}

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-emailgeneratebulletedlist-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-emailgeneratebulletedlist-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-emailgeneratebulletedlist-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-emailgeneratebulletedlist-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Email Templates/Bulleted List.msg<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-emailgeneratebulletedlist-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-emailgeneratebulletedlist-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Email Reports/Bulleted List_report.msg<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-emailgeneratebulletedlist-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-emailgeneratebulletedlist-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">Object</span>[] getDataSourceDetails <span class="pl-k">=</span> <span class="pl-smi">DataStorage</span><span class="pl-k">.</span>emailDataSourceObject(<span class="pl-s"><span class="pl-pds">"</span>Bulleted List.msg<span class="pl-pds">"</span></span>, <span class="pl-s"><span class="pl-pds">"</span>.msg<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-emailgeneratebulletedlist-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-emailgeneratebulletedlist-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-k">String</span>[] dataSourceNames <span class="pl-k">=</span> <span class="pl-smi">DataStorage</span><span class="pl-k">.</span>emailDataSourceName(<span class="pl-s"><span class="pl-pds">"</span>.msg<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-emailgeneratebulletedlist-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-emailgeneratebulletedlist-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-emailgeneratebulletedlist-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-emailgeneratebulletedlist-java-LC7" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getDataPath(srcDocument),</td></tr><tr><td id="file-emailgeneratebulletedlist-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-emailgeneratebulletedlist-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOutPath(docReport), getDataSourceDetails,</td></tr><tr><td id="file-emailgeneratebulletedlist-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-emailgeneratebulletedlist-java-LC9" class="blob-code blob-code-inner js-file-line">dataSourceNames);</td></tr></tbody></table>

[view raw](https://gist.github.com/samicheemagroupdocs/e61f2df361bc042a989380c1fdc20435/raw/131f6e020266856b25b6a24503f872fd42ca0f22/emailgenerateBulletedList.java) [emailgenerateBulletedList.java](https://gist.github.com/samicheemagroupdocs/e61f2df361bc042a989380c1fdc20435#file-emailgeneratebulletedlist-java) hosted with ❤ by [GitHub](https://github.com)
