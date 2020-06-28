---
id: single-row-image-in-email-document
url: assembly/java/single-row-image-in-email-document
title: Single Row Image in Email Document
weight: 6
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Single Row Image report in Email Document format.{{< /alert >}}

<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026732720 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026732720 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026732720 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026732720"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#SingleRowImageinEmailDocument-SingleRowImageinEmailDocument">Single Row Image in Email Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#SingleRowImageinEmailDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.2</span> <a href="#SingleRowImageinEmailDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a></li><li><span class="TOCOutline">1.3</span> <a href="#SingleRowImageinEmailDocument-DownloadSingleRowImageTemplate">Download Single Row Image Template</a></li><li><span class="TOCOutline">1.4</span> <a href="#SingleRowImageinEmailDocument-GeneratingTheReport">Generating The Report</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%"></td><td valign="top" width="35%"></td></tr></tbody></table>

## Single Row Image in Email Document

### Reporting Requirement

As a report developer, you are required to represent information of first single manager with the following key requirements:

*   Report must be in .eml or .msg format.
*   It must add email recipient, css and subject of the email.
*   Report must show image of the manager
*   It must show Name and age of manager

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

{{< alert style="warning" >}}Inserting Images Dynamically is not Supported yet{{< /alert >}}

```csharp
Name:	<<[manager.getName()]>>
Age:	<<[manager.getAge()]>>

```

### Download Single Row Image Template

Please download the sample template we created in this article:

*   [Single Row Image.eml](https://raw.githubusercontent.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Email%20Templates/Bulleted%20List.eml?raw=true)

### Generating The Report

{{< alert style="info" >}}The code uses some of the objects defined in: The Business Layer{{< /alert >}}

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-emailsinglerow-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-emailsinglerow-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-emailsinglerow-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-emailsinglerow-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Email Templates/Single Row.eml<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-emailsinglerow-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-emailsinglerow-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Email Reports/Single Row_report.eml<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-emailsinglerow-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-emailsinglerow-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">Manager</span> manager <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>()<span class="pl-k">.</span>getManagers()<span class="pl-k">.</span>iterator()<span class="pl-k">.</span>next();</td></tr><tr><td id="file-emailsinglerow-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-emailsinglerow-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-k">Object</span>[] getDataSourceDetails <span class="pl-k">=</span> <span class="pl-smi">DataStorage</span><span class="pl-k">.</span>emailDataSourceObject(<span class="pl-s"><span class="pl-pds">"</span>Single Row.eml<span class="pl-pds">"</span></span>, <span class="pl-s"><span class="pl-pds">"</span>.eml<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-emailsinglerow-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-emailsinglerow-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-k">String</span>[] dataSourceNames <span class="pl-k">=</span> <span class="pl-smi">DataStorage</span><span class="pl-k">.</span>emailDataSourceName(<span class="pl-s"><span class="pl-pds">"</span>.eml<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-emailsinglerow-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-emailsinglerow-java-LC7" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-emailsinglerow-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-emailsinglerow-java-LC8" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getDataPath(srcDocument),</td></tr><tr><td id="file-emailsinglerow-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-emailsinglerow-java-LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOutPath(docReport), getDataSourceDetails,</td></tr><tr><td id="file-emailsinglerow-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-emailsinglerow-java-LC10" class="blob-code blob-code-inner js-file-line">dataSourceNames);</td></tr></tbody></table>

[view raw](https://gist.github.com/samicheemagroupdocs/e39e429b95be8b91f06b1a7716d748e1/raw/1e652e78bc2a55725434465259c624458a68d9f7/emailSingleRow.java) [emailSingleRow.java](https://gist.github.com/samicheemagroupdocs/e39e429b95be8b91f06b1a7716d748e1#file-emailsinglerow-java) hosted with ❤ by [GitHub](https://github.com)
