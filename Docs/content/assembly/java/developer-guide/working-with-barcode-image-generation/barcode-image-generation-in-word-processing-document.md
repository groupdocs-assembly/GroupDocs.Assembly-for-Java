---
id: barcode-image-generation-in-word-processing-document
url: assembly/java/barcode-image-generation-in-word-processing-document
title: Barcode Image Generation in Word Processing Document
weight: 2
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026733117 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026733117 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026733117 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026733117"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#BarcodeImageGenerationinWordProcessingDocument-BarcodeGenerationinMicrosoftWord">Barcode Generation in Microsoft Word</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#BarcodeImageGenerationinWordProcessingDocument-TemplateSyntax">Template Syntax</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1.1</span> <a href="#BarcodeImageGenerationinWordProcessingDocument-DownloadTemplate">Download Template</a></li></ul></li><li><span class="TOCOutline">1.2</span> <a href="#BarcodeImageGenerationinWordProcessingDocument-TheCode">The Code</a></li></ul></li></ul></div></div></div></td><td valign="top">&nbsp;</td></tr></tbody></table>

{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Barcode Generation in Microsoft Word

### Template Syntax

*   Add a textbox to your template at the place where you want a barcode image to be inserted.
*   Add the following syntax:

```csharp
<<barcode [value] -itf6>>

```

#### Download Template

Get the template from here.

*   [Barcode.docx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Word%20Templates/Barcode.docx?raw=true)

### The Code

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-barcodedocuemnt-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-barcodedocuemnt-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-barcodedocuemnt-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-barcodedocuemnt-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Word Templates/Barcode.docx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-barcodedocuemnt-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-barcodedocuemnt-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Word Reports/Barcode_report.docx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-barcodedocuemnt-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-barcodedocuemnt-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">try</span> {</td></tr><tr><td id="file-barcodedocuemnt-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-barcodedocuemnt-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">Manager</span> manager <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>()<span class="pl-k">.</span>getManagers()<span class="pl-k">.</span>iterator()<span class="pl-k">.</span>next();</td></tr><tr><td id="file-barcodedocuemnt-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-barcodedocuemnt-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-barcodedocuemnt-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-barcodedocuemnt-java-LC7" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestDataPath(srcDocument),</td></tr><tr><td id="file-barcodedocuemnt-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-barcodedocuemnt-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestOutPath(docReport), <span class="pl-k">new</span> <span class="pl-smi">DataSourceInfo</span>(<span class="pl-s"><span class="pl-pds">"</span>854283<span class="pl-pds">"</span></span>, <span class="pl-s"><span class="pl-pds">"</span>value<span class="pl-pds">"</span></span>));</td></tr><tr><td id="file-barcodedocuemnt-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-barcodedocuemnt-java-LC9" class="blob-code blob-code-inner js-file-line">} <span class="pl-k">catch</span> (<span class="pl-smi">Exception</span> exp) {</td></tr><tr><td id="file-barcodedocuemnt-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-barcodedocuemnt-java-LC10" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">System</span><span class="pl-k">.</span>out<span class="pl-k">.</span>println(<span class="pl-s"><span class="pl-pds">"</span>Exception: <span class="pl-pds">"</span></span> <span class="pl-k">+</span> exp<span class="pl-k">.</span>getMessage());</td></tr><tr><td id="file-barcodedocuemnt-java-L11" class="blob-num js-line-number" data-line-number="11"></td><td id="file-barcodedocuemnt-java-LC11" class="blob-code blob-code-inner js-file-line">}</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/5a251b4914b8781cff6502c51e3ceb36/raw/f3a25dc4a7f621ae5a1fb5d97bf5ecab6d81bd18/barcodedocuemnt.java) [barcodedocuemnt.java](https://gist.github.com/GroupDocsGists/5a251b4914b8781cff6502c51e3ceb36#file-barcodedocuemnt-java) hosted with ❤ by [GitHub](https://github.com)
