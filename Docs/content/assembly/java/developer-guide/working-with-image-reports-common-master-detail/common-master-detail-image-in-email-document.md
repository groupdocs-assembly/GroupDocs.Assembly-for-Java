---
id: common-master-detail-image-in-email-document
url: assembly/java/common-master-detail-image-in-email-document
title: Common Master-Detail Image in Email Document
weight: 6
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}In this article, we will use GroupDocs.Assembly to generate a Common Master-Detail report in Email Document format.{{< /alert >}}

<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026733027 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026733027 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026733027 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026733027"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#CommonMaster-DetailImageinEmailDocument-CommonMaster-DetailinEmailDocument">Common Master-Detail in Email Document</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#CommonMaster-DetailImageinEmailDocument-CreatingaCommonMaster-Detail">Creating a Common Master-Detail</a></li><li><span class="TOCOutline">1.2</span> <a href="#CommonMaster-DetailImageinEmailDocument-ReportingRequirement">Reporting Requirement</a></li><li><span class="TOCOutline">1.3</span> <a href="#CommonMaster-DetailImageinEmailDocument-AddingSyntaxtobeevaluatedbyGroupDocs.AssemblyEngine">Adding Syntax to be evaluated by GroupDocs.Assembly Engine</a></li><li><span class="TOCOutline">1.4</span> <a href="#CommonMaster-DetailImageinEmailDocument-DownloadCommonMaster-DetailTemplate">Download Common Master-Detail Template</a></li><li><span class="TOCOutline">1.5</span> <a href="#CommonMaster-DetailImageinEmailDocument-GeneratingTheReport">Generating The Report</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%"></td><td valign="top" width="35%"></td></tr></tbody></table>

## Common Master-Detail in Email Document

### Creating a Common Master-Detail

Please follow below steps to create Common Master-Detail Template in MS Outlook 2013:

1.  Create a new Email.
2.  Insert two shapes, one for holding image and other for holding other details.
3.  Save the Email.

### Reporting Requirement

As a report developer, you are required to represent the information of the managers and clients with the following key requirements:

*   Report must be in .eml or .msg format.
*   It must add email recipient, css and subject of the email.
*   Report must show manager's picture and name.
*   It must associate the managers with their clients.

### Adding Syntax to be evaluated by GroupDocs.Assembly Engine

{{< alert style="warning" >}}NOTE: Dynamic inserting of images is not supported yet.{{< /alert >}}

```csharp
<<foreach [in getManagers()]>>Manager: <<[getName()]>>
Clients: <<foreach [in getContracts()]>><<[indexOf() != 0 ? ", " : ""]>>
<<[getClient().getName()]>><</foreach>>
<</foreach>>

```

### Download Common Master-Detail Template

Please download the sample Common Master-Detail document we created in this article:

*   [Common Master-Detail.eml](https://raw.githubusercontent.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Email%20Templates/Bulleted%20List.eml?raw=true)

### Generating The Report

{{< alert style="info" >}}The code uses some of the objects defined in: The Business Layer{{< /alert >}}

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-emailcommonmasterdetail-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-emailcommonmasterdetail-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-emailcommonmasterdetail-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-emailcommonmasterdetail-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Email Templates/Common Master-Detail.eml<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-emailcommonmasterdetail-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-emailcommonmasterdetail-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Email Reports/Common Master-Detail_report.eml<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-emailcommonmasterdetail-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-emailcommonmasterdetail-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">Object</span>[] getDataSourceDetails <span class="pl-k">=</span> <span class="pl-smi">DataStorage</span><span class="pl-k">.</span>emailDataSourceObject(<span class="pl-s"><span class="pl-pds">"</span>Common Master-Detail.eml<span class="pl-pds">"</span></span>, <span class="pl-s"><span class="pl-pds">"</span>.eml<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-emailcommonmasterdetail-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-emailcommonmasterdetail-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-k">String</span>[] dataSourceNames <span class="pl-k">=</span> <span class="pl-smi">DataStorage</span><span class="pl-k">.</span>emailDataSourceName(<span class="pl-s"><span class="pl-pds">"</span>.eml<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-emailcommonmasterdetail-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-emailcommonmasterdetail-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-emailcommonmasterdetail-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-emailcommonmasterdetail-java-LC7" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getDataPath(srcDocument),</td></tr><tr><td id="file-emailcommonmasterdetail-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-emailcommonmasterdetail-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOutPath(docReport), getDataSourceDetails,</td></tr><tr><td id="file-emailcommonmasterdetail-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-emailcommonmasterdetail-java-LC9" class="blob-code blob-code-inner js-file-line">dataSourceNames);</td></tr></tbody></table>

[view raw](https://gist.github.com/samicheemagroupdocs/c55506d4b7d27cd6d0d29db308fe9d54/raw/3685f306d69505411b1a49b773b7aabfc410e091/emailCommonMasterDetail.java) [emailCommonMasterDetail.java](https://gist.github.com/samicheemagroupdocs/c55506d4b7d27cd6d0d29db308fe9d54#file-emailcommonmasterdetail-java) hosted with ❤ by [GitHub](https://github.com)
