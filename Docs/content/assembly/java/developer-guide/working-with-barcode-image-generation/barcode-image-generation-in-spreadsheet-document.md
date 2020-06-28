---
id: barcode-image-generation-in-spreadsheet-document
url: assembly/java/barcode-image-generation-in-spreadsheet-document
title: Barcode Image Generation in Spreadsheet Document
weight: 3
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026733124 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026733124 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026733124 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026733124"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#BarcodeImageGenerationinSpreadsheetDocument-BarcodeGenerationinMicrosoftSpreadsheet">Barcode Generation in Microsoft Spreadsheet</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#BarcodeImageGenerationinSpreadsheetDocument-TemplateSyntax">Template Syntax</a></li><li><span class="TOCOutline">1.2</span> <a href="#BarcodeImageGenerationinSpreadsheetDocument-DownloadTemplate">Download Template</a></li><li><span class="TOCOutline">1.3</span> <a href="#BarcodeImageGenerationinSpreadsheetDocument-TheCode">The Code</a></li></ul></li></ul></div></div></div></td><td valign="top">&nbsp;</td></tr></tbody></table>

{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Barcode Generation in Microsoft Spreadsheet

### Template Syntax

*   Add a textbox to your template at the place where you want a barcode image to be inserted.
*   Add the following syntax:

```csharp
<<barcode [value] -itf6>>

```

### Download Template

Get the template from here.

*   [Barcode.xlsx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Spreadsheet%20Templates/Barcode.xlsx?raw=true)

### The Code

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-barcodespreadseet-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-barcodespreadseet-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-barcodespreadseet-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-barcodespreadseet-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Spreadsheet Templates/Barcode.xlsx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-barcodespreadseet-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-barcodespreadseet-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Spreadsheet Reports/Barcode_report.xlsx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-barcodespreadseet-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-barcodespreadseet-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">try</span> {</td></tr><tr><td id="file-barcodespreadseet-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-barcodespreadseet-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">Manager</span> manager <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>()<span class="pl-k">.</span>getManagers()<span class="pl-k">.</span>iterator()<span class="pl-k">.</span>next();</td></tr><tr><td id="file-barcodespreadseet-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-barcodespreadseet-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-barcodespreadseet-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-barcodespreadseet-java-LC7" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestDataPath(srcDocument),</td></tr><tr><td id="file-barcodespreadseet-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-barcodespreadseet-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestOutPath(docReport), <span class="pl-k">new</span> <span class="pl-smi">DataSourceInfo</span>(<span class="pl-s"><span class="pl-pds">"</span>854283<span class="pl-pds">"</span></span>, <span class="pl-s"><span class="pl-pds">"</span>value<span class="pl-pds">"</span></span>));</td></tr><tr><td id="file-barcodespreadseet-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-barcodespreadseet-java-LC9" class="blob-code blob-code-inner js-file-line">} <span class="pl-k">catch</span> (<span class="pl-smi">Exception</span> exp) {</td></tr><tr><td id="file-barcodespreadseet-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-barcodespreadseet-java-LC10" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">System</span><span class="pl-k">.</span>out<span class="pl-k">.</span>println(<span class="pl-s"><span class="pl-pds">"</span>Exception: <span class="pl-pds">"</span></span> <span class="pl-k">+</span> exp<span class="pl-k">.</span>getMessage());</td></tr><tr><td id="file-barcodespreadseet-java-L11" class="blob-num js-line-number" data-line-number="11"></td><td id="file-barcodespreadseet-java-LC11" class="blob-code blob-code-inner js-file-line">}</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/6cbbbc4a26730834f9d428617028a33e/raw/dae5f9875cea49f67e23353059bb2ea4347e7bf9/barcodespreadseet.java) [barcodespreadseet.java](https://gist.github.com/GroupDocsGists/6cbbbc4a26730834f9d428617028a33e#file-barcodespreadseet-java) hosted with ❤ by [GitHub](https://github.com)
