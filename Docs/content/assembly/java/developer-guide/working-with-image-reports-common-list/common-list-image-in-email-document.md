---
id: common-list-image-in-email-document
url: assembly/java/common-list-image-in-email-document
title: Common List Image in Email Document
weight: 6
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Common List report in Email Document format.{{< /alert >}}

<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026732313 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026732313 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026732313 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026732313"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#CommonListImageinEmailDocument-CommonListinEmailDocument">Common List in Email Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#CommonListImageinEmailDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.2</span> <a href="#CommonListImageinEmailDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a></li><li><span class="TOCOutline">1.3</span> <a href="#CommonListImageinEmailDocument-DownloadCommonListTemplate">Download Common List Template</a></li><li><span class="TOCOutline">1.4</span> <a href="#CommonListImageinEmailDocument-GeneratingTheReport">Generating The Report</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%"></td><td valign="top" width="35%"></td></tr></tbody></table>

## Common List in Email Document

### Reporting Requirement

As a report developer, you are required to share the following key requirements:

*   Report must be in .eml or .msg format.
*   It must add email recipient, css and subject of the email.
*   Report must show multiple managers' picture and name.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

{{< alert style="warning" >}}Inserting Images Dynamically is not Supported yet{{< /alert >}}

```csharp
<<foreach [in getManagers()]>><<[getName()]>>
<</foreach>>

```

### Download Common List Template

Please download the sample Common List document we created in this article:

*   [Common List.eml](https://raw.githubusercontent.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Email%20Templates/Bulleted%20List.eml?raw=true)

### Generating The Report

{{< alert style="info" >}}The code uses some of the objects defined in: The Business Layer{{< /alert >}}

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-emailcommonlist-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-emailcommonlist-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-emailcommonlist-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-emailcommonlist-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Email Templates/Common List.eml<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-emailcommonlist-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-emailcommonlist-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Email Reports/Common List_report.eml<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-emailcommonlist-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-emailcommonlist-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">Object</span>[] getDataSourceDetails <span class="pl-k">=</span> <span class="pl-smi">DataStorage</span><span class="pl-k">.</span>emailDataSourceObject(<span class="pl-s"><span class="pl-pds">"</span>Common List.eml<span class="pl-pds">"</span></span>, <span class="pl-s"><span class="pl-pds">"</span>.eml<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-emailcommonlist-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-emailcommonlist-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-k">String</span>[] dataSourceNames <span class="pl-k">=</span> <span class="pl-smi">DataStorage</span><span class="pl-k">.</span>emailDataSourceName(<span class="pl-s"><span class="pl-pds">"</span>.eml<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-emailcommonlist-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-emailcommonlist-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-emailcommonlist-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-emailcommonlist-java-LC7" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getDataPath(srcDocument),</td></tr><tr><td id="file-emailcommonlist-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-emailcommonlist-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOutPath(docReport), getDataSourceDetails,</td></tr><tr><td id="file-emailcommonlist-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-emailcommonlist-java-LC9" class="blob-code blob-code-inner js-file-line">dataSourceNames);</td></tr></tbody></table>

[view raw](https://gist.github.com/samicheemagroupdocs/f35458abe16581d077174c00c505ff1d/raw/33f1e1632d3080817e41b2a0d0458b87b6c85363/emailCommonList.java) [emailCommonList.java](https://gist.github.com/samicheemagroupdocs/f35458abe16581d077174c00c505ff1d#file-emailcommonlist-java) hosted with ❤ by [GitHub](https://github.com)
