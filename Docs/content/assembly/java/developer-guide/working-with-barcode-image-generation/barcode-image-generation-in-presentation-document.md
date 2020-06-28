---
id: barcode-image-generation-in-presentation-document
url: assembly/java/barcode-image-generation-in-presentation-document
title: Barcode Image Generation in Presentation Document
weight: 4
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026733131 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026733131 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026733131 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026733131"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#BarcodeImageGenerationinPresentationDocument-BarcodeGenerationinMicrosoftPowerPoint">Barcode Generation in Microsoft PowerPoint</a><ul class="toc-indentation"><li><span class="TOCOutline">1.1</span> <a href="#BarcodeImageGenerationinPresentationDocument-TemplateSyntax">Template Syntax</a></li><li><span class="TOCOutline">1.2</span> <a href="#BarcodeImageGenerationinPresentationDocument-DownloadTemplate">Download Template</a></li><li><span class="TOCOutline">1.3</span> <a href="#BarcodeImageGenerationinPresentationDocument-TheCode">The Code</a></li></ul></li></ul></div></div></div></td><td valign="top">&nbsp;</td></tr></tbody></table>

{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Barcode Generation in Microsoft PowerPoint

### Template Syntax

*   Add a textbox to your template at the place where you want a barcode image to be inserted.
*   Add the following syntax:

```csharp
<<barcode [value] -itf6>>

```

### Download Template

Get the template from here.

*   [Barcode.pptx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Presentation%20Templates/Barcode.pptx?raw=true)

### The Code

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-barcodepresentation-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-barcodepresentation-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-barcodepresentation-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-barcodepresentation-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> srcDocument <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Presentation Templates/Barcode.pptx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-barcodepresentation-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-barcodepresentation-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> docReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Presentation Reports/Barcode_report.pptx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-barcodepresentation-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-barcodepresentation-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-k">try</span> {</td></tr><tr><td id="file-barcodepresentation-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-barcodepresentation-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">Manager</span> manager <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DataStorage</span>()<span class="pl-k">.</span>getManagers()<span class="pl-k">.</span>iterator()<span class="pl-k">.</span>next();</td></tr><tr><td id="file-barcodepresentation-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-barcodepresentation-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-barcodepresentation-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-barcodepresentation-java-LC7" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestDataPath(srcDocument),</td></tr><tr><td id="file-barcodepresentation-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-barcodepresentation-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getTestOutPath(docReport), <span class="pl-k">new</span> <span class="pl-smi">DataSourceInfo</span>(<span class="pl-s"><span class="pl-pds">"</span>854283<span class="pl-pds">"</span></span>, <span class="pl-s"><span class="pl-pds">"</span>value<span class="pl-pds">"</span></span>));</td></tr><tr><td id="file-barcodepresentation-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-barcodepresentation-java-LC9" class="blob-code blob-code-inner js-file-line">} <span class="pl-k">catch</span> (<span class="pl-smi">Exception</span> exp) {</td></tr><tr><td id="file-barcodepresentation-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-barcodepresentation-java-LC10" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">System</span><span class="pl-k">.</span>out<span class="pl-k">.</span>println(<span class="pl-s"><span class="pl-pds">"</span>Exception: <span class="pl-pds">"</span></span> <span class="pl-k">+</span> exp<span class="pl-k">.</span>getMessage());</td></tr><tr><td id="file-barcodepresentation-java-L11" class="blob-num js-line-number" data-line-number="11"></td><td id="file-barcodepresentation-java-LC11" class="blob-code blob-code-inner js-file-line">}</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/e6892938d4cad17c877cafb4b6ce2997/raw/b56a148613dc7441938c8a34e60d460ff574ad04/barcodepresentation.java) [barcodepresentation.java](https://gist.github.com/GroupDocsGists/e6892938d4cad17c877cafb4b6ce2997#file-barcodepresentation-java) hosted with ❤ by [GitHub](https://github.com)
