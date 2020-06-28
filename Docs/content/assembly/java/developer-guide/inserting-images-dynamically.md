---
id: inserting-images-dynamically
url: assembly/java/inserting-images-dynamically
title: Inserting Images Dynamically
weight: 42
description: "How to dynamically inserted image within your template"
keywords: assembly, java, inserting
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}This feature is supported by version 20.3 or greater.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

You can insert images to your reports dynamically using image tags. To declare a dynamically inserted image within your template, do the following steps:

1.  Add a textbox to your template at the place where you want an image to be inserted.
2.  Set common image attributes such as frame, size, and others for the textbox, making the textbox look like a blank inserted image.
3.  Specify an image tag within the textbox using the following syntax.

```csharp
<<image [image_expression]>>
```

And simply call the assembler method to generate report like following code snippets:

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-insertimagedynamicallyinword_20-3-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-insertimagedynamicallyinword_20-3-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-insertimagedynamicallyinword_20-3-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-insertimagedynamicallyinword_20-3-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Setting up source document template (Email or Word Document)</span></td></tr><tr><td id="file-insertimagedynamicallyinword_20-3-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-insertimagedynamicallyinword_20-3-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> strDocumentTemplate <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Word Templates/DynamicImageDemo.docx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-insertimagedynamicallyinword_20-3-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-insertimagedynamicallyinword_20-3-java-LC4" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-insertimagedynamicallyinword_20-3-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-insertimagedynamicallyinword_20-3-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Setting up destination for reports</span></td></tr><tr><td id="file-insertimagedynamicallyinword_20-3-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-insertimagedynamicallyinword_20-3-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> strDocumentReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Word Reports/DynamicImageDemo Out.docx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-insertimagedynamicallyinword_20-3-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-insertimagedynamicallyinword_20-3-java-LC7" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-insertimagedynamicallyinword_20-3-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-insertimagedynamicallyinword_20-3-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Instantiate DocumentAssembler class</span></td></tr><tr><td id="file-insertimagedynamicallyinword_20-3-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-insertimagedynamicallyinword_20-3-java-LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-insertimagedynamicallyinword_20-3-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-insertimagedynamicallyinword_20-3-java-LC10" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-insertimagedynamicallyinword_20-3-java-L11" class="blob-num js-line-number" data-line-number="11"></td><td id="file-insertimagedynamicallyinword_20-3-java-LC11" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getDataPath(strDocumentTemplate),</td></tr><tr><td id="file-insertimagedynamicallyinword_20-3-java-L12" class="blob-num js-line-number" data-line-number="12"></td><td id="file-insertimagedynamicallyinword_20-3-java-LC12" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOutPath(strDocumentReport),</td></tr><tr><td id="file-insertimagedynamicallyinword_20-3-java-L13" class="blob-num js-line-number" data-line-number="13"></td><td id="file-insertimagedynamicallyinword_20-3-java-LC13" class="blob-code blob-code-inner js-file-line"><span class="pl-k">new</span> <span class="pl-smi">DataSourceInfo</span>(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getImagePath(<span class="pl-s"><span class="pl-pds">"</span>no-photo.jpg<span class="pl-pds">"</span></span>),<span class="pl-s"><span class="pl-pds">"</span>image_expression<span class="pl-pds">"</span></span>));</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/ecbe5e7331f08a3f0bccd81a1ef57995/raw/0af1bfaf1c09cb31563f8f9d8d94eeb618f8a49b/insertImageDynamicallyInWord_20.3.java) [insertImageDynamicallyInWord\_20.3.java](https://gist.github.com/GroupDocsGists/ecbe5e7331f08a3f0bccd81a1ef57995#file-insertimagedynamicallyinword_20-3-java) hosted with ❤ by [GitHub](https://github.com)

The expression declared within an image tag is used by the assembler to build an image to be inserted. The expression must return a value of one of the following types:

*   A byte array containing an image data
*   A InputStream instance able to read an image data
*   An BufferredImage object
*   A string containing an image URI, path, or Base64-encoded image data

While building a report, the following procedure is applied to an image tag:

1.  The expression declared within the tag is evaluated and its result is used to form an image.
2.  The corresponding textbox is filled with this image.
3.  The tag is removed from the textbox.

{{< alert style="warning" >}}If the expression declared within an image tag returns a stream object, then it is closed by the assembler as soon as the corresponding image is built. {{< /alert >}}

By default, the assembler stretches an image filling a textbox to the size of the textbox. However, you can change this behavior in the following ways:

*   To keep the size of the textbox and stretch the image within bounds of the textbox preserving the ratio of the image, use the *keepRatio* switch as follows:
    
    ```csharp
    <<image [image_expression] -keepRatio>>
    ```
    
*   To keep the width of the textbox and change its height preserving the ratio of the image, use the fitHeight switch as follows.
    
    ```csharp
    <<image [image_expression] -fitHeight>>
    ```
    
*   To keep the height of the textbox and change its width preserving the ratio of the image, use the fitWidth switch as follows.
    
    ```csharp
    <<image [image_expression] -fitWidth>>
    ```
    
*   To change the size of the textbox according to the size of the image, use the fitSize switch as follows.
    
    ```csharp
    <<image [image_expression] -fitSize>>
    ```
    
*   To change the size of the textbox according to the size of the image without increasing the size of the textbox, use the fitSizeLim switch as follows.
    
    ```csharp
    <<image [image_expression] -fitSizeLim>>
    ```
    
      
    {{< alert style="warning" >}}If the size of the image is greater than the size of the textbox, then the fitSizeLim switch acts like fitHeight or fitWidth. Otherwise, the fitSizeLim switch acts like fitSize.{{< /alert >}}
    

{{< alert style="warning" >}}Dynamic insertion of images from Base64-encoded bytes is available for file formats where dynamic image insertion is available for almost all supported file formats.{{< /alert >}}
