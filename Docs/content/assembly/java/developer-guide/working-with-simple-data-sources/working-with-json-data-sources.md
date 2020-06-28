---
id: working-with-json-data-sources
url: assembly/java/working-with-json-data-sources
title: Working with JSON Data Sources
weight: 2
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026733563 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026733563 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026733563 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026733563"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#WorkingwithJSONDataSources-SimplifiedworkingwithJSONdatasources">Simplified working with JSON data sources</a></li><li><span class="TOCOutline">2</span> <a href="#WorkingwithJSONDataSources-Treatingthetoplevelarraysorobjectshavingarray">Treating the top level arrays or objects having array</a></li><li><span class="TOCOutline">3</span> <a href="#WorkingwithJSONDataSources-Treatingtheobjectsattoplevel">Treating the objects at top level</a></li><li><span class="TOCOutline">4</span> <a href="#WorkingwithJSONDataSources-Thecompleteexample">The complete example</a><ul class="toc-indentation"><li><span class="TOCOutline">4.1</span> <a href="#WorkingwithJSONDataSources-JSON">JSON</a></li><li><span class="TOCOutline">4.2</span> <a href="#WorkingwithJSONDataSources-Templatedocument">Template document</a></li><li><span class="TOCOutline">4.3</span> <a href="#WorkingwithJSONDataSources-Sourcecode">Source code</a></li><li><span class="TOCOutline">4.4</span> <a href="#WorkingwithJSONDataSources-Resultdocument">Result document</a></li></ul></li><li><span class="TOCOutline">5</span> <a href="#WorkingwithJSONDataSources-Download">&nbsp;Download</a><ul class="toc-indentation"><li><span class="TOCOutline">5.1</span> <a href="#WorkingwithJSONDataSources-DataSourceDocument">Data Source Document</a></li><li><span class="TOCOutline">5.2</span> <a href="#WorkingwithJSONDataSources-Template">Template</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%">&nbsp;</td></tr></tbody></table>

{{< alert style="info" >}}This feature is only compatible with GroupDocs.Assembly for Java 19.11 or later releases.{{< /alert >}}

### Simplified working with JSON data sources

To access JSON data while building a report, you can pass a *JsonDataSource* instance to the engine as a data source.

Using of *JsonDataSource* enables you to work with typed values of JSON elements in template documents. For more convenience, the set of simple JSON types is extended as follows:

*   Integer
*   Long
*   Double
*   Boolean
*   Date
*   String

### Treating the top level arrays or objects having array

In template documents, if a top-level JSON element is an array or an object having only one property of an array type, a JsonDataSource instance should be treated in the same way as if it was a DataTable instance (see "[Working with DataTable and DataView Objects](https://docs.groupdocs.com/display/assemblyjava/Template+Syntax+-+Part+1+of+2#TemplateSyntax-Part1of2-DataTableObjects)" for more information) as shown in the following example.

Suppose we have Json data like:

\[ 
   { 
      Name:"John Doe",
      Age:30,
      Birth:"1989-04-01 4:00:00 pm"
   },
   { 
      Name:"Jane Doe",
      Age:27,
      Birth:"1992-01-31 07:00:00 am"
   },
   { 
      Name:"John Smith",
      Age:51,
      Birth:"1968-03-08 1:00:00 pm"
   }
\]

or alternative JSON like:

{ 
   Persons:\[ 
      { 
         Name:"John Doe",
         Age:30,
         Birth:"1989-04-01 4:00:00 pm"
      },
      { 
         Name:"Jane Doe",
         Age:27,
         Birth:"1992-01-31 07:00:00 am"
      },
      { 
         Name:"John Smith",
         Age:51,
         Birth:"1968-03-08 1:00:00 pm"
      }
   \]
}

If we use the template like following:

<<foreach \[in persons\]>>Name: <<\[Name\]>>, Age: <<\[Age\]>>, Date of Birth: <<\[Birth\]:"dd.MM.yyyy">>
<</foreach>>
Average age: <<\[persons.average(p => p.Age)\]>>

The results will be produced for both pieces of JSON data like:

Name: John Doe, Age: 30, Date of Birth: 01.04.1989
Name: Jane Doe, Age: 27, Date of Birth: 31.01.1992
Name: John Smith, Age: 51, Date of Birth: 08.03.1968
Average age: 36

{{< alert style="warning" >}}Using of the custom date-time format becomes possible, because text values of Birth properties are automatically converted to Date.{{< /alert >}}

### Treating the objects at top level

If a top-level JSON element represents an object, a *JsonDataSource* instance should be treated in template documents in the same way as if it was a *DataRow* instance (see "[Working with *DataRow* and *DataRowView* Objects](https://docs.groupdocs.com/display/assemblyjava/Template+Syntax+-+Part+1+of+2#TemplateSyntax-Part1of2-DataTableObjects)" for more information). If a top-level JSON object has a single property that is also an object, then this nested object is accessed by the assembler instead. To see how it works, consider the following example.

Suppose we have Json data like:

{ 
   Name:"John Doe",
   Age:30,
   Birth:"1989-04-01 4:00:00 pm",
   Child:\[ 
      "Ann Doe",
      "Charles Doe"
   \]
}

or alternatively like:

{ 
   Person:{ 
      Name:"John Doe",
      Age:30,
      Birth:"1989-04-01 4:00:00 pm",
      Child:\[ 
         "Ann Doe",
         "Charles Doe"
      \]
   }
}

If we use the template like following:

Name: <<\[Name\]>>, Age: <<\[Age\]>>, Date of Birth:
<<\[Birth\]:"dd.MM.yyyy">>
Children:
<<foreach \[in Child\]>><<\[Child\_Text\]>>
<</foreach>>

The results will be produced for both pieces of JSON data like:

Name: John Doe, Age: 30, Date of Birth: 01.04.1989
Children:
Ann Doe
Charles Doe

{{< alert style="warning" >}}To reference a JSON object property that is an array of simple-type values, the name of the property (for example, "Child") should be used in a template document, whereas the same name with the "_Text" suffix (for example, "Child_Text") should be used to reference the value of an item of this array.{{< /alert >}}

### The complete example

The following example sums up typical scenarios involving nested JSON objects and arrays.

#### JSON

\[ 
   { 
      Name:"John Smith",
      Contract:\[ 
         { 
            Client:{ 
               Name:"A Company"
            },
            Price:1200000
         },
         { 
            Client:{ 
               Name:"B Ltd."
            },
            Price:750000
         },
         { 
            Client:{ 
               Name:"C & D"
            },
            Price:350000
         }
      \]
   },
   { 
      Name:"Tony Anderson",
      Contract:\[ 
         { 
            Client:{ 
               Name:"E Corp."
            },
            Price:650000
         },
         { 
            Client:{ 
               Name:"F & Partners"
            },
            Price:550000
         }
      \]
   },
   { 
      Name:"July James",
      Contract:\[ 
         { 
            Client:{ 
               Name:"G & Co."
            },
            Price:350000
         },
         { 
            Client:{ 
               Name:"H Group"
            },
            Price:250000
         },
         { 
            Client:{ 
               Name:"I & Sons"
            },
            Price:100000
         },
         { 
            Client:{ 
               Name:"J Ent."
            },
            Price:100000
         }
      \]
   }
\]

#### Template document

<<foreach \[in managers\]>>Manager: <<\[Name\]>>
Contracts:
<<foreach \[in Contract\]>>- <<\[Client.Name\]>> ($<<\[Price\]>>)
<</foreach>>
<</foreach>>

#### Source code

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-simplejsonds_demo_19-11-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-simplejsonds_demo_19-11-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-simplejsonds_demo_19-11-java-LC2" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Setting up source document template</span></td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-simplejsonds_demo_19-11-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> strDocumentTemplate <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Word Templates/SimpleDatasetDemo.docx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-simplejsonds_demo_19-11-java-LC4" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-simplejsonds_demo_19-11-java-LC5" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Setting up destination report</span></td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-simplejsonds_demo_19-11-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> strDocumentReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Word Reports/SimpleJsonDSDemo Out.docx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-simplejsonds_demo_19-11-java-LC7" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-simplejsonds_demo_19-11-java-LC8" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Setting up data source file</span></td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-simplejsonds_demo_19-11-java-LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> strDataSource <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span><span class="pl-cce">\\</span>ManagerData.json<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-simplejsonds_demo_19-11-java-LC10" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L11" class="blob-num js-line-number" data-line-number="11"></td><td id="file-simplejsonds_demo_19-11-java-LC11" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Instantiate Json data source</span></td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L12" class="blob-num js-line-number" data-line-number="12"></td><td id="file-simplejsonds_demo_19-11-java-LC12" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">JsonDataSource</span> datasource<span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">JsonDataSource</span>(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span><span class="pl-smi">JsonDataFile</span> <span class="pl-k">+</span> strDataSource);</td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L13" class="blob-num js-line-number" data-line-number="13"></td><td id="file-simplejsonds_demo_19-11-java-LC13" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L14" class="blob-num js-line-number" data-line-number="14"></td><td id="file-simplejsonds_demo_19-11-java-LC14" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DataSourceInfo</span> dataSourceInfo <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DataSourceInfo</span>(datasource,<span class="pl-s"><span class="pl-pds">"</span>managers<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L15" class="blob-num js-line-number" data-line-number="15"></td><td id="file-simplejsonds_demo_19-11-java-LC15" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L16" class="blob-num js-line-number" data-line-number="16"></td><td id="file-simplejsonds_demo_19-11-java-LC16" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Instantiate DocumentAssembler class</span></td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L17" class="blob-num js-line-number" data-line-number="17"></td><td id="file-simplejsonds_demo_19-11-java-LC17" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L18" class="blob-num js-line-number" data-line-number="18"></td><td id="file-simplejsonds_demo_19-11-java-LC18" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L19" class="blob-num js-line-number" data-line-number="19"></td><td id="file-simplejsonds_demo_19-11-java-LC19" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getDataPath(strDocumentTemplate),</td></tr><tr><td id="file-simplejsonds_demo_19-11-java-L20" class="blob-num js-line-number" data-line-number="20"></td><td id="file-simplejsonds_demo_19-11-java-LC20" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOutPath(strDocumentReport),dataSourceInfo);</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/ecbe5e7331f08a3f0bccd81a1ef57995/raw/0af1bfaf1c09cb31563f8f9d8d94eeb618f8a49b/simpleJsonDS_Demo_19.11.java) [simpleJsonDS\_Demo\_19.11.java](https://gist.github.com/GroupDocsGists/ecbe5e7331f08a3f0bccd81a1ef57995#file-simplejsonds_demo_19-11-java) hosted with ❤ by [GitHub](https://github.com)

#### Result document

Manager: John Smith
Contracts:
- A Company ($1200000)
- B Ltd. ($750000)
- C & D ($350000)
Manager: Tony Anderson
Contracts:
- E Corp. ($650000)
- F & Partners ($550000)
Manager: July James
Contracts:
- G & Co. ($350000)
- H Group ($250000)
- I & Sons ($100000)
- J Ent. ($100000)

###  Download

#### Data Source Document

*   [ManagerData.json](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-.NET/blob/master/Examples/Data/Data%20Sources/JSON%20DataSource/ManagerData.json?raw=true)

#### Template

*   [Demo Template.docx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-.NET/blob/master/Examples/Data/Source/Word%20Templates/Using%20Spreadsheet%20as%20Table%20of%20Data.docx?raw=true)
