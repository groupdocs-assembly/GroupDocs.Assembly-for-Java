---
id: working-with-csv-data-sources
url: assembly/java/working-with-csv-data-sources
title: Working with CSV Data Sources
weight: 1
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
<table class="sectionMacro" border="0" cellpadding="5" cellspacing="0" width="100%"><tbody><tr><td valign="top" width="50%"><div class="panel" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px;"><div class="panelHeader" style="border-bottom-width: 1px; background-color: rgb(176, 196, 222);"><b>Contents Summary</b></div><div class="panelContent"><style type="text/css">div.rbtoc1593026733542 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1593026733542 ul { list-style-type: none; list-style-image: none; margin-left: 0px; }div.rbtoc1593026733542 li { margin-left: 0px; padding-left: 0px; }</style><div class="toc rbtoc1593026733542"><ul class="toc-indentation"><li><span class="TOCOutline">1</span> <a href="#WorkingwithCSVDataSources-TreatingsimpleCSVdata"><span>Treating simple CSV data</span></a></li><li><span class="TOCOutline">2</span> <a href="#WorkingwithCSVDataSources-Configuredatasourcetoreadcolumnnames">Configure data source to read column names</a></li><li><span class="TOCOutline">3</span> <a href="#WorkingwithCSVDataSources-Download">&nbsp;Download</a><ul class="toc-indentation"><li><span class="TOCOutline">3.1</span> <a href="#WorkingwithCSVDataSources-DataSourceDocument">Data Source Document</a></li><li><span class="TOCOutline">3.2</span> <a href="#WorkingwithCSVDataSources-Template">Template</a></li></ul></li></ul></div></div></div></td><td valign="top" width="15%">&nbsp;</td></tr></tbody></table>

{{< alert style="info" >}}This feature is only compatible with GroupDocs.Assembly for .NET 19.10 or later releases.{{< /alert >}}

To access CSV data while building a report, you can pass a *CsvDataSource* instance to the assembler as a data source. Using of *CsvDataSource* enables you to work with typed values rather than just strings in template documents. Although CSV as a format does not define a way to store values of types other than strings, *CsvDataSource* is capable to recognize values of the following types by their string representations:

*   Int32?
*   Int64?
*   Double?
*   Boolean?
*   DateTime?

{{< alert style="warning" >}}For recognition of data types to work, string representations of corresponding values must be formed using invariant culture settings.{{< /alert >}}

### Treating simple CSV data

In template documents, a *CsvDataSource* instance should be treated in the same way as if it was a *DataTable* instance (see "[Working with *DataTable* and *DataView* Objects](https://docs.groupdocs.com/display/assemblyjava/Template+Syntax+-+Part+1+of+2#TemplateSyntax-Part1of2-DataTableObjects)" for more information) as shown in the following example.

Suppose we have CSV data like:

John Doe,30,1989-04-01 4:00:00 pm
Jane Doe,27,1992-01-31 07:00:00 am
John Smith,51,1968-03-08 1:00:00 pm

By using the template like following:

  

<<foreach \[in persons\]>>Name: <<\[Column1\]>>, Age: <<\[Column2\]>>, Date
of Birth: <<\[Column3\]:"dd.MM.yyyy">>
<</foreach>>
Average age: <<\[persons.average(p => p.Column2)\]>>

  

The results will be produced like:

Name: John Doe, Age: 30, Date of Birth: 01.04.1989
Name: Jane Doe, Age: 27, Date of Birth: 31.01.1992
Name: John Smith, Age: 51, Date of Birth: 08.03.1968
Average age: 36

{{< alert style="warning" >}}Using of the custom date-time format and the extension method involving arithmetic in the template document becomes possible, because text values of Column3 and Column2 are automatically converted to DateTime? and Int32? respectively.{{< /alert >}}

### Configure data source to read column names

By default, *CsvDataSource* uses column names such as "*Column1*", "*Column2*", and so on, as you can see from the previous example. However, *CsvDataSource* can be configured to read column names from the first line of CSV data as shown in the following example.

Suppose we have CSV data like:

Name,Age,Birth
John Doe,30,1989-04-01 4:00:00 pm
Jane Doe,27,1992-01-31 07:00:00 am
John Smith,51,1968-03-08 1:00:00 pm

By using the template like following:

<<foreach \[in persons\]>>Name: <<\[Name\]>>, Age: <<\[Age\]>>, Date of
Birth: <<\[Birth\]:"dd.MM.yyyy">>
<</foreach>>
Average age: <<\[persons.average(p => p.Age)\]>>

The code should be written like:

<table class="highlight tab-size js-file-line-container" data-tab-size="8" data-paste-markdown-skip=""><tbody><tr><td id="file-simplecsvds_demo_19-10-java-L1" class="blob-num js-line-number" data-line-number="1"></td><td id="file-simplecsvds_demo_19-10-java-LC1" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span> For complete examples and data files, please go to https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java</span></td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L2" class="blob-num js-line-number" data-line-number="2"></td><td id="file-simplecsvds_demo_19-10-java-LC2" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L3" class="blob-num js-line-number" data-line-number="3"></td><td id="file-simplecsvds_demo_19-10-java-LC3" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Setting up source document template</span></td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L4" class="blob-num js-line-number" data-line-number="4"></td><td id="file-simplecsvds_demo_19-10-java-LC4" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> strDocumentTemplate <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Text Templates/CsvDatasetDemo.txt<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L5" class="blob-num js-line-number" data-line-number="5"></td><td id="file-simplecsvds_demo_19-10-java-LC5" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L6" class="blob-num js-line-number" data-line-number="6"></td><td id="file-simplecsvds_demo_19-10-java-LC6" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Setting up destination report</span></td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L7" class="blob-num js-line-number" data-line-number="7"></td><td id="file-simplecsvds_demo_19-10-java-LC7" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> strDocumentReport <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span>/Word Reports/SimpleCsvDSDemo Out.docx<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L8" class="blob-num js-line-number" data-line-number="8"></td><td id="file-simplecsvds_demo_19-10-java-LC8" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L9" class="blob-num js-line-number" data-line-number="9"></td><td id="file-simplecsvds_demo_19-10-java-LC9" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Setting up data source file</span></td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L10" class="blob-num js-line-number" data-line-number="10"></td><td id="file-simplecsvds_demo_19-10-java-LC10" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">String</span> strDataSource <span class="pl-k">=</span> <span class="pl-s"><span class="pl-pds">"</span><span class="pl-cce">\\</span>Person.csv<span class="pl-pds">"</span></span>;</td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L11" class="blob-num js-line-number" data-line-number="11"></td><td id="file-simplecsvds_demo_19-10-java-LC11" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L12" class="blob-num js-line-number" data-line-number="12"></td><td id="file-simplecsvds_demo_19-10-java-LC12" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>set load csv by column name</span></td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L13" class="blob-num js-line-number" data-line-number="13"></td><td id="file-simplecsvds_demo_19-10-java-LC13" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CsvDataLoadOptions</span> options <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">CsvDataLoadOptions</span>(<span class="pl-c1">true</span>);</td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L14" class="blob-num js-line-number" data-line-number="14"></td><td id="file-simplecsvds_demo_19-10-java-LC14" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L15" class="blob-num js-line-number" data-line-number="15"></td><td id="file-simplecsvds_demo_19-10-java-LC15" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CsvDataSource</span> datasource<span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">CsvDataSource</span>(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>excelDataFile <span class="pl-k">+</span> strDataSource,options);</td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L16" class="blob-num js-line-number" data-line-number="16"></td><td id="file-simplecsvds_demo_19-10-java-LC16" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L17" class="blob-num js-line-number" data-line-number="17"></td><td id="file-simplecsvds_demo_19-10-java-LC17" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DataSourceInfo</span> dataSourceInfo <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DataSourceInfo</span>(datasource,<span class="pl-s"><span class="pl-pds">"</span>persons<span class="pl-pds">"</span></span>);</td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L18" class="blob-num js-line-number" data-line-number="18"></td><td id="file-simplecsvds_demo_19-10-java-LC18" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L19" class="blob-num js-line-number" data-line-number="19"></td><td id="file-simplecsvds_demo_19-10-java-LC19" class="blob-code blob-code-inner js-file-line"><span class="pl-c"><span class="pl-c">//</span>Instantiate DocumentAssembler class</span></td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L20" class="blob-num js-line-number" data-line-number="20"></td><td id="file-simplecsvds_demo_19-10-java-LC20" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">DocumentAssembler</span> assembler <span class="pl-k">=</span> <span class="pl-k">new</span> <span class="pl-smi">DocumentAssembler</span>();</td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L21" class="blob-num js-line-number" data-line-number="21"></td><td id="file-simplecsvds_demo_19-10-java-LC21" class="blob-code blob-code-inner js-file-line"></td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L22" class="blob-num js-line-number" data-line-number="22"></td><td id="file-simplecsvds_demo_19-10-java-LC22" class="blob-code blob-code-inner js-file-line">assembler<span class="pl-k">.</span>assembleDocument(<span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getDataPath(strDocumentTemplate),</td></tr><tr><td id="file-simplecsvds_demo_19-10-java-L23" class="blob-num js-line-number" data-line-number="23"></td><td id="file-simplecsvds_demo_19-10-java-LC23" class="blob-code blob-code-inner js-file-line"><span class="pl-smi">CommonUtilities</span><span class="pl-k">.</span>getOutPath(strDocumentReport),dataSourceInfo);</td></tr></tbody></table>

[view raw](https://gist.github.com/GroupDocsGists/ecbe5e7331f08a3f0bccd81a1ef57995/raw/0af1bfaf1c09cb31563f8f9d8d94eeb618f8a49b/SimpleCsvDS_Demo_19.10.java) [SimpleCsvDS\_Demo\_19.10.java](https://gist.github.com/GroupDocsGists/ecbe5e7331f08a3f0bccd81a1ef57995#file-simplecsvds_demo_19-10-java) hosted with ❤ by [GitHub](https://github.com)

The results will be produced like:

Name: John Doe, Age: 30, Date of Birth: 01.04.1989
Name: Jane Doe, Age: 27, Date of Birth: 31.01.1992
Name: John Smith, Age: 51, Date of Birth: 08.03.1968
Average age: 36

Also, you can use *CsvDataLoadOptions* to customize the following characters playing special roles while loading CSV data:

*   Value separator (the default is comma)
*   Single-line comment start (the default is sharp)
*   Quotation mark enabling to use other special characters within a value (the default is double quotes)

###  Download

#### Data Source Document

*   [Person.csv](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-.NET/blob/master/Examples/Data/Data%20Sources/XML%20DataSource/Managers.xml?raw=true)

#### Template

*   [Template Demo.txt](attachments/85819665/85917712.txt)
