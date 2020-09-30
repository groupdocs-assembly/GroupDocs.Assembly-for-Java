---
id: working-with-email-messages
url: assembly/java/working-with-email-messages
title: Working with Email Messages
weight: 4
description: ""
keywords: 
productName: GroupDocs.Assembly for Java
hideChildren: False
---
{{< alert style="info" >}}This feature is supported by version 18.2 or greater.{{< /alert >}}{{< alert style="info" >}}The code uses some of the objects defined in The Business Layer.{{< /alert >}}

## Working with Email Messages

GroupDocs.Assembly allows you to use data bands in table rows in** Email Messages **with HTML and RTF bodies. A table-row data band is a data band whose body occupies single or multiple rows of a single document table. The body of such a band starts at the beginning of the first occupied row and ends at the end of the last occupied row as follows. The syntax for using data bands in email messages is as follows:

<table class="confluenceTable"><tbody><tr><td class="confluenceTd"><p><strong>Client</strong></p></td><td class="confluenceTd"><p><strong>Manager</strong></p></td><td class="confluenceTd"><p><strong>Contract Price</strong></p></td></tr><tr><td class="confluenceTd"><p><strong>&lt;&lt;foreach [</strong></p><p><strong>&nbsp;&nbsp;&nbsp; c in ds</strong></p><p><strong>]&gt;&gt;&lt;&lt;[c.Client]&gt;&gt;</strong></p></td><td class="confluenceTd"><p><strong>&lt;&lt;[c.Manager]&gt;&gt;</strong></p></td><td class="confluenceTd"><p><strong>&lt;&lt;[c.Contract_Price]&gt;&gt;&lt;&lt;/</strong></p><p><strong>foreach&gt;&gt;</strong></p></td></tr></tbody></table>

### Working with Table-Row Conditional Blocks

You can also use a table-row conditional block whose body occupies single or multiple rows of a single document table. The body of such a block (as well as the body of its every template option) starts at the beginning of the first occupied row and ends at the end of the last occupied row as follows:

<table class="confluenceTable"><tbody><tr><td class="confluenceTd"><p><strong>&nbsp;</strong></p></td><td class="confluenceTd"><p><strong>&nbsp;</strong></p></td><td class="confluenceTd"><p><strong>&nbsp;</strong></p></td></tr><tr><td class="confluenceTd"><p><strong>&lt;&lt;if ...&gt;&gt; ...</strong></p></td><td class="confluenceTd"><p><strong>...</strong></p></td><td class="confluenceTd"><p><strong>...</strong></p></td></tr><tr><td class="confluenceTd"><p><strong>...</strong></p></td><td class="confluenceTd"><p><strong>...</strong></p></td><td class="confluenceTd"><p><strong>...</strong></p></td></tr><tr><td class="confluenceTd"><p><strong>&lt;&lt;elseif ...&gt;&gt; ...</strong></p></td><td class="confluenceTd"><p><strong>...</strong></p></td><td class="confluenceTd"><p><strong>...</strong></p></td></tr><tr><td class="confluenceTd"><p><strong>...</strong></p></td><td class="confluenceTd"><p><strong>...</strong></p></td><td class="confluenceTd"><p><strong>...</strong></p></td></tr><tr><td class="confluenceTd"><p><strong>&lt;&lt;else&gt;&gt; ...</strong></p></td><td class="confluenceTd"><p><strong>...</strong></p></td><td class="confluenceTd"><p><strong>...</strong></p></td></tr><tr><td class="confluenceTd"><p><strong>...</strong></p></td><td class="confluenceTd"><p><strong>...</strong></p></td><td class="confluenceTd"><p><strong>...</strong></p></td></tr><tr><td class="confluenceTd"><p><strong>...</strong></p></td><td class="confluenceTd"><p><strong>...</strong></p></td><td class="confluenceTd"><p><strong>... &lt;&lt;/if&gt;&gt;</strong></p></td></tr><tr><td class="confluenceTd"><p><strong>&nbsp;</strong></p></td><td class="confluenceTd"><p><strong>&nbsp;</strong></p></td><td class="confluenceTd"><p><strong>&nbsp;</strong></p><div><strong><br></strong></div></td></tr></tbody></table>

### Download

#### Data Source Document

*   [Managers Data.xlsx](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Data%20Sources/Excel%20DataSource/Contracts%20Data.xlsx)

#### Template

*   [Working with Table Row Data Bands.msg](https://github.com/groupdocs-assembly/GroupDocs.Assembly-for-Java/blob/master/Examples/GroupDocs.Assembly.Examples.Java/Data/Storage/Email%20Templates/Working%20With%20Table%20Row%20Data%20Bands.msg)

### The Code

{{< gist GroupDocsGists 532bfbe19af4f2bb74f2ef236bc3a822 >}}

