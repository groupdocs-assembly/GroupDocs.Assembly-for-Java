package com.groupdocs.assembly.examples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.xml.crypto.Data;

import com.groupdocs.assembly.DataSourceInfo;
import com.groupdocs.assembly.DocumentAssembler;
import com.groupdocs.assembly.DocumentAssemblyOptions;
import com.groupdocs.assembly.DocumentTable;
import com.groupdocs.assembly.DocumentTableOptions;
import com.groupdocs.assembly.DocumentTableSet;
import com.groupdocs.assembly.FileFormat;
import com.groupdocs.assembly.LoadSaveOptions;
import com.groupdocs.assembly.examples.BusinessEntities.Manager;
import com.groupdocs.assembly.examples.DataStorage.EmailDataSourcesNames;
import com.groupdocs.assembly.examples.DataStorage.EmailDataSourcesObjects;

public class GenerateReport {

	public static void loadDocTableSet(String dataSource) throws Exception {
		// ExStart:loadDocTableSet
		// Load all document tables using default options.
		DocumentTableSet tableSet = new DocumentTableSet(CommonUtilities.wordDataFile + dataSource);

		// Check loading.
		assert tableSet.getTables().getCount() == 3;
		assert tableSet.getTables().get(0).getName().equals("Table1");
		assert tableSet.getTables().get(1).getName().equals("Table2");
		assert tableSet.getTables().get(2).getName().equals("Table3");
		// ExEnd:loadDocTableSet
	}

	public static void loadDocTableSetWithCustomOptions(String dataSource) throws Throwable {
		// ExStart:loadDocTableSetWithCustomOptions
		// Load document tables using custom options.
		DocumentTableSet tableSet = new DocumentTableSet((CommonUtilities.wordDataFile + dataSource),
				new CustomDocumentTableLoadHandler());

		// Ensure that the second table is not loaded.
		assert tableSet.getTables().getCount() == 2;
		assert tableSet.getTables().get(0).getName().equals("Table1");
		assert tableSet.getTables().get(1).getName().equals("Table3");

		// Ensure that default options are used to load the first table (that
		// is, default column names are used).
		assert tableSet.getTables().get(0).getColumns().getCount() == 2;
		assert tableSet.getTables().get(0).getColumns().get(0).getName().equals("Column1");
		assert tableSet.getTables().get(0).getColumns().get(1).getName().equals("Column2");

		// Ensure that custom options are used to load the third table (that is,
		// column names are extracted).
		assert tableSet.getTables().get(1).getColumns().getCount() == 2;
		assert tableSet.getTables().get(1).getColumns().get(0).getName().equals("Name");
		assert tableSet.getTables().get(1).getColumns().get(1).getName().equals("Address");
		// ExEnd:loadDocTableSetWithCustomOptions
	}

	public static void useDocumentTableSetAsDataSource(String dataSource, String slideDoc) throws Throwable {
		// ExStart:useDocumentTableSetAsDataSource
		// Set table column names to be extracted from the document.
		DocumentTableSet tableSet = new DocumentTableSet((CommonUtilities.wordDataFile + dataSource),
				new ColumnNameExtractingDocumentTableLoadHandler());

		// Set table names for conveniency.
		tableSet.getTables().get(0).setName("Planets");
		tableSet.getTables().get(1).setName("Persons");
		tableSet.getTables().get(2).setName("Companies");

		// Pass DocumentTableSet as a data source.
		DocumentAssembler assembler = new DocumentAssembler();
		assembler.assembleDocument(CommonUtilities.getDataPath(slideDoc),
				CommonUtilities.getOutPath("/Presentation Reports/out.pptx"), new DataSourceInfo( tableSet));
		// ExEnd:useDocumentTableSetAsDataSource
	}

	public static void definingDocumentTableRelations(String relatedTables, String docTableRelations) throws Exception {
		// ExStart:definingDocumentTableRelations
		// Set table column names to be extracted from the document.
		DocumentTableSet tableSet = new DocumentTableSet(CommonUtilities.excelDataFile + relatedTables,
				new ColumnNameExtractingDocumentTableLoadHandler());

		// Define relations between tables.
		// NOTE: For Spreadsheet documents, table names are extracted from sheet
		// names.
		tableSet.getRelations().add(tableSet.getTables().get("CLIENT").getColumns().get("ID"),
				tableSet.getTables().get("CONTRACT").getColumns().get("CLIENT_ID"));

		tableSet.getRelations().add(tableSet.getTables().get("MANAGER").getColumns().get("ID"),
				tableSet.getTables().get("CONTRACT").getColumns().get("MANAGER_ID"));

		// Pass DocumentTableSet as a data source.
		DocumentAssembler assembler = new DocumentAssembler();
		assembler.assembleDocument(CommonUtilities.getDataPath(docTableRelations),
				CommonUtilities.getOutPath("/Word Reports/out.docx"),new DataSourceInfo( tableSet));
		// ExEnd:definingDocumentTableRelations
	}

	public static void changingDocumentTableColumnType(String doc) throws Throwable {
		// ExStart:changingDocumentTableColumnType
		// Set table column names to be extracted from the document.
		DocumentTableOptions options = new DocumentTableOptions();
		options.setFirstRowContainsColumnNames(true);

		DocumentTable table = new DocumentTable(CommonUtilities.wordDataFile + "/Managers Data.docx", 1, options);

		// NOTE: For non-Spreadsheet documents, the type of a document table
		// column is always string by default.
		assert table.getColumns().get("Total_Contract_Price").getType() == String.class;

		// Change the column's type to double thus enabling to use arithmetic
		// operations on values of the column
		// such as summing in templates.
		table.getColumns().get("Total_Contract_Price").setType(double.class);

		// Pass DocumentTable as a data source.
		DocumentAssembler assembler = new DocumentAssembler();
		assembler.assembleDocument(CommonUtilities.getDataPath(doc),
				CommonUtilities.getOutPath("/Presentation Reports/out.pptx"), new DataSourceInfo( table, "Managers"));
		// ExEnd:changingDocumentTableColumnType
	}

	// Generate bubble chart report
	public static void generateBubbleChart(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:bubblechartdocument
			String srcDocument = "/Word Templates/Bubble Chart.docx";
			String docReport = "/Word Reports/Bubble Chart_report.docx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:bubblechartdocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:bubblechartspreadsheet
			String srcDocument = "/Spreadsheet Templates/Bubble Chart.xlsx";
			String docReport = "/Spreadsheet Reports/Bubble Chart_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:bubblechartspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:bubblechartpresentation
			String srcDocument = "/Presentation Templates/Bubble Chart.pptx";
			String docReport = "/Presentation Reports/Bubble Chart_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:bubblechartpresentation
		} else if (documentFormat == "email") {
			//ExStart:emailgenerateBubbleChart
			String srcDocument = "/Email Templates/Bubble Chart.eml";
			String docReport = "/Email Reports/Bubble Chart_report.eml";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("Bubble Chart.eml", ".eml");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),
					new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
					new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
					new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
					new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
					new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
					new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailgenerateBubbleChart
		}
	}
	// Generate bulleted list report
	public static void generateBulletedList(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:bulletedlistdocument
			String srcDocument = "/Word Templates/Bulleted List.docx";
			String docReport = "/Word Reports/Bulleted List_report.docx";
			try {
				
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:bulletedlistdocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:bulletedlistspreadsheet
			String srcDocument = "/Spreadsheet Templates/Bulleted List.xlsx";
			String docReport = "/Spreadsheet Reports/Bulleted List_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:bulletedlistspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:bulletedlistpresentation
			String srcDocument = "/Presentation Templates/Bulleted List.pptx";
			String docReport = "/Presentation Reports/Bulleted List_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo(new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:bulletedlistpresentation
		} else if (documentFormat == "html") {
			// ExStart:bulletedlisthtml
			String srcDocument = "/Html Templates/Bulleted List.html";
			String docReport = "/Html Reports/Bulleted List_report.html";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:bulletedlisthtml
		} else if (documentFormat == "txt") {
			// ExStart:bulletedlisttxt
			String srcDocument = "/Text Templates/Bulleted List.txt";
			String docReport = "/Text Reports/Bulleted List_report.txt";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:bulletedlisttxt
		}else if (documentFormat == "email") {
			//ExStart:emailgenerateBulletedList
			String srcDocument = "/Email Templates/Bulleted List.msg";
			String docReport = "/Email Reports/Bulleted List_report.msg";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("Bulleted List.msg", ".msg");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".msg");
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
									CommonUtilities.getOutPath(docReport),
									new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
									new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
									new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
									new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
									new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
									new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailgenerateBulletedList
		} 
	}

	// Generate Chart With Filtering Grouping And Ordering
	public static void generateChartWithFilteringGroupingAndOrdering(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:chartwithfilteringgroupingandorderingdocument
			String srcDocument = "/Word Templates/Chart with Filtering, Grouping, and Ordering.docx";
			String docReport = "/Word Reports/Chart with Filtering, Grouping, and Ordering_report.docx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:chartwithfilteringgroupingandorderingdocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:chartwithfilteringgroupingandorderingspreadsheet
			String srcDocument = "/Spreadsheet Templates/Chart with Filtering, Grouping, and Ordering.xlsx";
			String docReport = "/Spreadsheet Reports/Chart with Filtering, Grouping, and Ordering_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:chartwithfilteringgroupingandorderingspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:chartwithfilteringgroupingandorderingpresentation
			String srcDocument = "/Presentation Templates/Chart with Filtering, Grouping, and Ordering.pptx";
			String docReport = "/Presentation Reports/Chart with Filtering, Grouping, and Ordering_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:chartwithfilteringgroupingandorderingpresentation
		}else if (documentFormat == "email") {
			//ExStart:emailchartwithfilteringgroupingordering
			String srcDocument = "/Email Templates/Chart with Filtering, Grouping, and Ordering.msg";
			String docReport = "/Email Reports/Chart with Filtering, Grouping, and Ordering_report.msg";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("Chart with Filtering, Grouping, and Ordering.msg", ".msg");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".msg");
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailchartwithfilteringgroupingordering
		} 
	}

	// Generate Common List
	public static void generateCommonList(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:commonlistdocument
			String srcDocument = "/Word Templates/Common List.docx";
			String docReport = "/Word Reports/Common List_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:commonlistdocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:commonlistspreadsheet
			String srcDocument = "/Spreadsheet Templates/Common List.xlsx";
			String docReport = "/Spreadsheet Reports/Common List_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:commonlistspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:commonlistpresentation
			String srcDocument = "/Presentation Templates/Common List.pptx";
			String docReport = "/Presentation Reports/Common List_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), new DataSourceInfo(new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:commonlistpresentation
		} else if (documentFormat == "html") {
			// ExStart:commonlisthtml
			String srcDocument = "/Html Templates/Common List.html";
			String docReport = "/Html Reports/Common List_report.html";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				// This is needed solely for images in HTML documents.
				assembler.getKnownTypes().add(FileUtil.class);
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:commonlisthtml
		} else if (documentFormat == "txt") {
			// ExStart:commonlisttxt
			String srcDocument = "/Text Templates/Common List.txt";
			String docReport = "/Text Reports/Common List_report.txt";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo(new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:commonlisttxt
		}else if (documentFormat == "email") {
			//ExStart:emailCommonList
			String srcDocument = "/Email Templates/Common List.eml";
			String docReport = "/Email Reports/Common List_report.eml";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("Common List.eml", ".eml");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailCommonList
		} 
	}

	// Generate Common Master Detail
	public static void generateCommonMasterDetail(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:commonmasterdetaildocument
			String srcDocument = "/Word Templates/Common Master-Detail.docx";
			String docReport = "/Word Reports/Common Master-Detail_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:commonmasterdetaildocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:commonmasterdetailspreadsheet
			String srcDocument = "/Spreadsheet Templates/Common Master-Detail.xlsx";
			String docReport = "/Spreadsheet Reports/Common Master-Detail_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:commonmasterdetailspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:commonmasterdetailpresentation
			String srcDocument = "/Presentation Templates/Common Master-Detail.pptx";
			String docReport = "/Presentation Reports/Common Master-Detail_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:commonmasterdetailpresentation
		} else if (documentFormat == "html") {
			// ExStart:commonmasterdetailhtml
			String srcDocument = "/Html Templates/Common Master-Detail.html";
			String docReport = "/Html Reports/Common Master-Detail_report.html";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				// This is needed solely for images in HTML documents.
				assembler.getKnownTypes().add(FileUtil.class);
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:commonmasterdetailhtml
		} else if (documentFormat == "txt") {
			// ExStart:commonmasterdetailtxt
			String srcDocument = "/Text Templates/Common Master-Detail.txt";
			String docReport = "/Text Reports/Common Master-Detail_report.txt";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:commonmasterdetailtxt
		}else if (documentFormat == "email") {
			//ExStart:emailCommonMasterDetail
			String srcDocument = "/Email Templates/Common Master-Detail.eml";
			String docReport = "/Email Reports/Common Master-Detail_report.eml";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("Common Master-Detail.eml", ".eml");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailCommonMasterDetail
		} 
	}

	// Generate In-Paragraph list report
	public static void generateInParagraphList(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:inparagraphlistdocument
			String srcDocument = "/Word Templates/In-Paragraph List.docx";
			String docReport = "/Word Reports/In-Paragraph List_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:inparagraphlistdocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:inparagraphlistspreadsheet
			String srcDocument = "/Spreadsheet Templates/In-Paragraph List.xlsx";
			String docReport = "/Spreadsheet Reports/In-Paragraph List_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo(new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:inparagraphlistspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:inparagraphlistpresentation
			String srcDocument = "/Presentation Templates/In-Paragraph List.pptx";
			String docReport = "/Presentation Reports/In-Paragraph List_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:inparagraphlistpresentation
		} else if (documentFormat == "html") {
			// ExStart:inparagraphlisthtml
			String srcDocument = "/Html Templates/In-Paragraph List.html";
			String docReport = "/Html Reports/In-Paragraph List_report.html";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:inparagraphlisthtml
		} else if (documentFormat == "txt") {
			// ExStart:inparagraphlisttxt
			String srcDocument = "/Text Templates/In-Paragraph List.txt";
			String docReport = "/Text Reports/In-Paragraph List_report.txt";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:inparagraphlisttxt
		}else if (documentFormat == "email") {
			//ExStart:emailInParagraphList
			String srcDocument = "/Email Templates/In-Paragraph List.eml";
			String docReport = "/Email Reports/In-Paragraph List_report.eml";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("In-Paragraph List.eml", ".eml");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailInParagraphList
		} 
	}

	// Generate Generate In Table List With Alternate Content
	public static void generateInTableListWithAlternateContent(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:intablelistwithalternatecontentdocument
			String srcDocument = "/Word Templates/In-Table List with Alternate Content.docx";
			String docReport = "/Word Reports/In-Table List with Alternate Content_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithalternatecontentdocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:intablelistwithalternatecontentspreadsheet
			String srcDocument = "/Spreadsheet Templates/In-Table List with Alternate Content.xlsx";
			String docReport = "/Spreadsheet Reports/In-Table List with Alternate Content_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithalternatecontentspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:intablelistwithalternatecontentpresentation
			String srcDocument = "/Presentation Templates/In-Table List with Alternate Content.pptx";
			String docReport = "/Presentation Reports/In-Table List with Alternate Content_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithalternatecontentpresentation
		} else if (documentFormat == "html") {
			// ExStart:intablelistwithalternatecontenthtml
			String srcDocument = "/Html Templates/In-Table List with Alternate Content.html";
			String docReport = "/Html Reports/In-Table List with Alternate Content_report.html";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithalternatecontenthtml
		}else if (documentFormat == "email") {
			//ExStart:emailInTableListWithAlternateContent
			String srcDocument = "/Email Templates/In-Table List with Alternate Content.eml";
			String docReport = "/Email Reports/In-Table List with Alternate Content_report.eml";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("In-Table List with Alternate Content.eml", ".eml");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailInTableListWithAlternateContent
		} 
	}

	// Generate In Table List With Filtering Grouping And Ordering
	public static void generateInTableListWithFilteringGroupingAndOrdering(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:intablelistwithfilteringroupingandorderingdocument
			String srcDocument = "/Word Templates/In-Table List with Filtering, Grouping, and Ordering.docx";
			String docReport = "/Word Reports/In-Table List with Filtering, Grouping, and Ordering_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithfilteringroupingandorderingdocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:intablelistwithfilteringroupingandorderingspreadsheet
			String srcDocument = "/Spreadsheet Templates/In-Table List with Filtering, Grouping, and Ordering.xlsx";
			String docReport = "/Spreadsheet Reports/In-Table List with Filtering, Grouping, and Ordering_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithfilteringroupingandorderingspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:intablelistwithfilteringroupingandorderingpresentation
			String srcDocument = "/Presentation Templates/In-Table List with Filtering, Grouping, and Ordering.pptx";
			String docReport = "/Presentation Reports/In-Table List with Filtering, Grouping, and Ordering_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithfilteringroupingandorderingpresentation
		} else if (documentFormat == "html") {
			// ExStart:intablelistwithfilteringroupingandorderinghtml
			String srcDocument = "/Html Templates/In-Table List with Filtering, Grouping, and Ordering.html";
			String docReport = "/Html Reports/In-Table List with Filtering, Grouping, and Ordering_report.html";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo(new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithfilteringroupingandorderinghtml
		}else if (documentFormat == "email") {
			//ExStart:emailInTableListWithFilteringGroupingAndOrdering
			String srcDocument = "/Email Templates/In-Table List with Filtering, Grouping, and Ordering.eml";
			String docReport = "/Email Reports/In-Table List with Filtering, Grouping, and Ordering_report.eml";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("In-Table List with Filtering, Grouping, and Ordering.eml", ".eml");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailInTableListWithFilteringGroupingAndOrdering
		} 
	}

	// Generate in table list with highlighted rows
	public static void generateInTableListWithHighlightedRows(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:intablelistwithhighllightedrowsdocument
			String srcDocument = "/Word Templates/In-Table List with Highlighted Rows.docx";
			String docReport = "/Word Reports/In-Table List with Highlighted Rows_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo(new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithhighllightedrowsdocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:intablelistwithhighllightedrowsspreadsheet
			String srcDocument = "/Spreadsheet Templates/In-Table List with Highlighted Rows.xlsx";
			String docReport = "/Spreadsheet Reports/In-Table List with Highlighted Rows_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithhighllightedrowsspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:intablelistwithhighllightedrowspresentation
			String srcDocument = "/Presentation Templates/In-Table List with Highlighted Rows.pptx";
			String docReport = "/Presentation Reports/In-Table List with Highlighted Rows_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithhighllightedrowspresentation
		} else if (documentFormat == "html") {
			// ExStart:intablelistwithhighllightedrowshtml
			String srcDocument = "/Html Templates/In-Table List with Highlighted Rows.html";
			String docReport = "/Html Reports/In-Table List with Highlighted Rows_report.html";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithhighllightedrowshtml
		}else if (documentFormat == "email") {
			//ExStart:emailInTableListWithHighlightedRows
			String srcDocument = "/Email Templates/In-Table List with Highlighted Rows.eml";
			String docReport = "/Email Reports/In-Table List with Highlighted Rows_report.eml";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("In-Table List with Highlighted Rows.eml", ".eml");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailInTableListWithHighlightedRows
		} 
	}

	// Generate in table list
	public static void generateInTableList(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:intablelistdocument
			String srcDocument = "/Word Templates/In-Table List.docx";
			String docReport = "/Word Reports/In-Table List_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistdocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:intablelistspreadsheet
			String srcDocument = "/Spreadsheet Templates/In-Table List.xlsx";
			String docReport = "/Spreadsheet Reports/In-Table List_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:intablelistpresentation
			String srcDocument = "/Presentation Templates/In-Table List.pptx";
			String docReport = "/Presentation Reports/In-Table List_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistpresentation
		} else if (documentFormat == "html") {
			// ExStart:intablelisthtml
			String srcDocument = "/Html Templates/In-Table List.html";
			String docReport = "/Html Reports/In-Table List_report.html";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelisthtml
		}else if (documentFormat == "email") {
			//ExStart:emailInTableList
			String srcDocument = "/Email Templates/In-Table List.eml";
			String docReport = "/Email Reports/In-Table List_report.eml";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("In-Table List.eml", ".eml");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailInTableList
		}  
	}

	// Generate in table master detail
	public static void generateInTableMasterDetail(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:intablemasterdetaildocument
			String srcDocument = "/Word Templates/In-Table Master-Detail.docx";
			String docReport = "/Word Reports/In-Table Master-Detail_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablemasterdetaildocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:intablemasterdetailspreadsheet
			String srcDocument = "/Spreadsheet Templates/In-Table Master-Detail.xlsx";
			String docReport = "/Spreadsheet Reports/In-Table Master-Detail_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablemasterdetailspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:intablemasterdetailpresentation
			String srcDocument = "/Presentation Templates/In-Table Master-Detail.pptx";
			String docReport = "/Presentation Reports/In-Table Master-Detail_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo(new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablemasterdetailpresentation
		} else if (documentFormat == "html") {
			// ExStart:intablemasterdetailhtml
			String srcDocument = "/Html Templates/In-Table Master-Detail.html";
			String docReport = "/Html Reports/In-Table Master-Detail_report.html";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablemasterdetailhtml
		}else if (documentFormat == "email") {
			//ExStart:emailInTableMasterDetail
			String srcDocument = "/Email Templates/In-Table Master-Detail.eml";
			String docReport = "/Email Reports/In-Table Master-Detail_report.eml";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("In-Table Master-Detail.eml", ".eml");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailInTableMasterDetail
		} 
	}

	// Generate multicolored numbered list
	public static void generateMulticoloredNumberedList(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:multicolorednumberedlistdocument
			String srcDocument = "/Word Templates/Multicolored Numbered List.docx";
			String docReport = "/Word Reports/Multicolored Numbered List_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:multicolorednumberedlistdocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:multicolorednumberedlistspreadsheet
			String srcDocument = "/Spreadsheet Templates/Multicolored Numbered List.xlsx";
			String docReport = "/Spreadsheet Reports/Multicolored Numbered List_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:multicolorednumberedlistspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:multicolorednumberedlistpresentation
			String srcDocument = "/Presentation Templates/Multicolored Numbered List.pptx";
			String docReport = "/Presentation Reports/Multicolored Numbered List_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:multicolorednumberedlistpresentation
		} else if (documentFormat == "html") {
			// ExStart:multicolorednumberedlisthtml
			String srcDocument = "/Html Templates/Multicolored Numbered List.html";
			String docReport = "/Html Reports/Multicolored Numbered List_report.html";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:multicolorednumberedlisthtml
		}else if (documentFormat == "email") {
			//ExStart:emailMulticoloredNumberedList
			String srcDocument = "/Email Templates/Multicolored Numbered List.eml";
			String docReport = "/Email Reports/Multicolored Numbered List_report.eml";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("Multicolored Numbered List.eml", ".eml");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailMulticoloredNumberedList
		} 
	}

	// Generate Numbered list report
	public static void generateNumberedList(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:numberedlistdocument
			String srcDocument = "/Word Templates/Numbered List.docx";
			String docReport = "/Word Reports/Numbered List_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:numberedlistdocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:numberedlistspreadsheet
			String srcDocument = "/Spreadsheet Templates/Numbered List.xlsx";
			String docReport = "/Spreadsheet Reports/Numbered List_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:numberedlistspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:numberedlistpresentation
			String srcDocument = "/Presentation Templates/Numbered List.pptx";
			String docReport = "/Presentation Reports/Numbered List_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:numberedlistpresentation
		} else if (documentFormat == "html") {
			// ExStart:numberedlisthtml
			String srcDocument = "/Html Templates/Numbered List.html";
			String docReport = "/Html Reports/Numbered List_report.html";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:numberedlisthtml
		} else if (documentFormat == "txt") {
			// ExStart:numberedlisttxt
			String srcDocument = "/Text Templates/Numbered List.txt";
			String docReport = "/Text Reports/Numbered List_report.txt";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:numberedlisttxt
		}else if (documentFormat == "email") {
			//ExStart:emailNumberedList
			String srcDocument = "/Email Templates/Numbered List.eml";
			String docReport = "/Email Reports/Numbered List_report.eml";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("Numbered List.eml", ".eml");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailNumberedList
		} 
	}

	//Generate a Nested Numbered List Report with restartNum in Emails
	public static void generateNumberedListWithRestart_Emails(){
		// ExStart:numberedListWithRestart_Documents
		String srcDocument = "/Email Templates/Numbered List_RestartNum.msg";
		String docReport = "/Email Reports/Numbered List_RestartNum.msg";
		try {
			//Manager manager = new DataStorage().getManagers().iterator().next();
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(),null));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
		// ExEnd:numberedListWithRestart_Documents
	}
	public static void generateNumberedListWithRestart_Documents(){
		// ExStart:numberedListWithRestart_Documents
		String srcDocument = "/Word Templates/Numbered List_RestartNum.docx";
		String docReport = "/Word Reports/Numbered List_RestartNum.docx";
		try {
			//Manager manager = new DataStorage().getManagers().iterator().next();
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(),null));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
		// ExEnd:numberedListWithRestart_Documents
	}
	// Generate pie chart
	public static void generatePieChart(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:piechartdocument
			String srcDocument = "/Word Templates/Pie Chart.docx";
			String docReport = "/Word Reports/Pie Chart_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:piechartdocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:piechartspreadsheet
			String srcDocument = "/Spreadsheet Templates/Pie Chart.xlsx";
			String docReport = "/Spreadsheet Reports/Pie Chart_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:piechartspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:piechartpresentation
			String srcDocument = "/Presentation Templates/Pie Chart.pptx";
			String docReport = "/Presentation Reports/Pie Chart_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:piechartpresentation
		}else if (documentFormat == "email") {
			//ExStart:emailPieChart
			String srcDocument = "/Email Templates/Pie Chart.eml";
			String docReport = "/Email Reports/Pie Chart_report.eml";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("Pie Chart.eml", ".eml");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailPieChart
		} 
	}

	// Generate scatter chart
	public static void generateScatterChart(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:scatterchartdocument
			String srcDocument = "/Word Templates/Scatter Chart.docx";
			String docReport = "/Word Reports/Scatter Chart_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:scatterchartdocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:scatterchartspreadsheet
			String srcDocument = "/Spreadsheet Templates/Scatter Chart.xlsx";
			String docReport = "/Spreadsheet Reports/Scatter Chart_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo(new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:scatterchartspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:scatterchartpresentation
			String srcDocument = "/Presentation Templates/Scatter Chart.pptx";
			String docReport = "/Presentation Reports/Scatter Chart_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:scatterchartpresentation
		}else if (documentFormat == "email") {
			//ExStart:emailScatterChart
			String srcDocument = "/Email Templates/Scatter Chart.eml";
			String docReport = "/Email Reports/Scatter Chart_report.eml";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("Scatter Chart.eml", ".eml");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailScatterChart
		} 
	}

	// Generate single row
	public static void generateSingleRow(String documentFormat) throws Throwable {
		if (documentFormat == "document") {
			// ExStart:singlerowdocument
			String srcDocument = "/Word Templates/Single Row.docx";
			String docReport = "/Word Reports/Single Row_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( manager, "manager"));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:singlerowdocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:singlerowspreadsheet
			String srcDocument = "/Spreadsheet Templates/Single Row.xlsx";
			String docReport = "/Spreadsheet Reports/Single Row_report.xlsx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( manager, "manager"));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:singlerowspreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:singlerowpresentation
			String srcDocument = "/Presentation Templates/Single Row.pptx";
			String docReport = "/Presentation Reports/Single Row_report.pptx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( manager, "manager"));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:singlerowpresentation
		} else if (documentFormat == "html") {
			// ExStart:singlerowhtml
			String srcDocument = "/Html Templates/Single Row.html";
			String docReport = "/Html Reports/Single Row_report.html";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				// This is needed solely for images in HTML documents.
				assembler.getKnownTypes().add(FileUtil.class);
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( manager, "manager"));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:singlerowhtml
		} else if (documentFormat == "txt") {
			// ExStart:singlerowtxt
			String srcDocument = "/Text Templates/Single Row.txt";
			String docReport = "/Text Reports/Single Row_report.txt";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( manager, "manager"));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:singlerowtxt
		}else if (documentFormat == "email") {
			//ExStart:emailSingleRow
			String srcDocument = "/Email Templates/Single Row.eml";
			String docReport = "/Email Reports/Single Row_report.eml";
			Manager manager = new DataStorage().getManagers().iterator().next();
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("Single Row.eml", ".eml");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
			//ExEnd:emailSingleRow
		} 
	}

	// Generate barcode
	public static void addBarCodes(String documentFormat) throws Exception {
		if (documentFormat == "document") {
			// ExStart:barcodedocument
			try {
				//Setting up data set, Method DataStorage().getManagers().iterator().next()  is defined here : https://docs.groupdocs.com/display/assemblyjava/The+Business+Layer#TheBusinessLayer-DataStorageClass
				//Instantiate DocumentAssembler class
				DocumentAssembler assembler = new DocumentAssembler();
				//Call AssembleDocument to generate   Report in open document format
				assembler.assembleDocument("D:\\Word Templates\\Barcode.docx", "D:\\Word Reports\\Barcode_report.docx",  
				new DataSourceInfo( new DataStorage().getManagers().iterator().next(), "value"));

			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:barcodedocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:barcodespreadsheet
			String srcDocument = "/Spreadsheet Templates/Barcode.xlsx";
			String docReport = "/Spreadsheet Reports/Barcode_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( "854283", "value"));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:barcodespreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:barcodepresentation
			String srcDocument = "/Presentation Templates/Barcode.pptx";
			String docReport = "/Presentation Reports/Barcode_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( "854283", "value"));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:barcodepresentation
		}
	}

	// Generate report with upper and numeric properties
	public static void templateSyntaxFormatting(String documentFormat) {
		if (documentFormat == "document") {
			// ExStart:TemplateSyntaxFormatting
			String srcDocument = "/Word Templates/Numeric Upper.docx";
			String docReport = "/Word Reports/Numeric Upper_report.docx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:TemplateSyntaxFormatting
		}
	}

	// Generate report with outer doc insertion
	public static void outerDocumentInsertion(String documentFormat) {
		if (documentFormat == "document") {
			// ExStart:OuterDocumentInsertion
			String srcDocument = "/Word Templates/OuterDocInsertion.docx";
			String docReport = "/Word Reports/OuterDocInsertion_report.docx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:OuterDocumentInsertion
		}
	}

	// Generate report and update field
	public static void updateWordDocFields(String documentFormat) {
		if (documentFormat == "document") {
			// ExStart:UpdateWordDocFieldsindocument
			String srcDocument = "/Word Templates/Update field.docx";
			String docReport = "/Word Reports/Update field_report.docx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.setOptions(DocumentAssemblyOptions.UPDATE_FIELDS_AND_FORMULAS);
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:UpdateWordDocFieldsindocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:UpdateWordDocFieldsinspreadsheet
			String srcDocument = "/Spreadsheet Templates/Update formula.xlsx";
			String docReport = "/Spreadsheet Reports/Update formula_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.setOptions(DocumentAssemblyOptions.UPDATE_FIELDS_AND_FORMULAS);
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:UpdateWordDocFieldsinspreadsheet
		}
	}

	// Generate report using next keyword
	public static void usingNext(String documentFormat) {
		if (documentFormat == "document") {
			// ExStart:usingNext
			String srcDocument = "/Word Templates/Using next.docx";
			String docReport = "/Word Reports/Using next_report.docx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:usingNext
		}
	}

	// Generate report from excel data source
	public static void useSpreadsheetAsDataSource() throws Throwable {
		// ExStart:useSpreadsheetAsDataSource
		String srcDocument = "/Word Templates/Using Spreadsheet as Table of Data.docx";
		String docReport = "/Word Reports/Using Spreadsheet as Table of Data_report.docx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument), CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(	DataStorage.excelData(), "contracts"));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
		// ExEnd:useSpreadsheetAsDataSource
	}

	// Generate report from word table data source
	public static void importingWordProcessingTableIntoPresentation() throws Throwable {
		// ExStart:ImportingWordProcessingTableIntoPresentation
		String srcDocument = "/Presentation Templates/Importing Word Processing Table into Presentation.pptx";
		String docReport = "/Presentation Reports/Importing Word Processing Table into Presentation_report.pptx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument), CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(	DataStorage.importingWordProcessingTableIntoPresentation(), "table"));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
		// ExEnd:ImportingWordProcessingTableIntoPresentation
	}

	// Generate report from presentation data source
	public static void usePresentationTableAsDataSource() throws Throwable {
		// ExStart:UsePresentationTableAsDataSource
		String srcDocument = "/Presentation Templates/Using Presentation as Table of Data.pptx";
		String docReport = "/Presentation Reports/Using Presentation as Table of Data_report.pptx";
		try {
			Manager manager = new DataStorage().getManagers().iterator().next();
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument), CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(	DataStorage.presentationData(), "table"));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
		// ExEnd:UsePresentationTableAsDataSource
	}

	// Multiple data sources
	public static void generateReportUsingMultipleDS(String documentFormat) throws Throwable {
		// ExStart:generateReportUsingMultipleDS
		if (documentFormat == "document") {
			// ExStart:barcodedocument
			String srcDocument = "/Word Templates/Multiple DS.docx";
			String docReport = "/Word Reports/Multiple DS_report.docx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo(new DataStorage(), null), new DataSourceInfo(DataStorage.excelData(),"contracts"));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:barcodedocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:barcodespreadsheet
			String srcDocument = "/Spreadsheet Templates/Multiple DS.xlsx";
			String docReport = "/Spreadsheet Reports/Multiple DS_report.xlsx";
			try {
				
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), new DataSourceInfo(new DataStorage(), null), new DataSourceInfo(DataStorage.excelData(),"contracts"));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:barcodespreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:barcodepresentation
			String srcDocument = "/Presentation Templates/Multiple DS.pptx";
			String docReport = "/Presentation Reports/Multiple DS_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport),new DataSourceInfo(new DataStorage(), null), new DataSourceInfo(DataStorage.excelData(),"contracts"));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:barcodepresentation
		}
		// ExEnd:generateReportUsingMultipleDS
	}

	public static void importingSpreadsheetIntoHtml(String dataSource, String sourceTemplate) throws Throwable {
		// ExStart:generateHtmlReport
		// Use data of the _first_ worksheet.
		// Do not extract column names from the first row, so the names to be
		// imported as well.
		DocumentTable table = new DocumentTable(CommonUtilities.excelDataFile + dataSource, 0);
		// Check column count, names, and types.
		assert table.getColumns().getCount() == 3;
		assert table.getColumns().get(0).getName().equals("A");
		assert table.getColumns().get(0).getType() == String.class;
		assert table.getColumns().get(1).getName().equals("B");
		assert table.getColumns().get(1).getType() == String.class;
		assert table.getColumns().get(2).getName().equals("C");
		assert table.getColumns().get(2).getType() == String.class;
		// testCore(sourceTemplate, table, "table");
		DocumentAssembler assembler = new DocumentAssembler();
		// This is needed solely for images in HTML documents.
		assembler.getKnownTypes().add(FileUtil.class);
		assembler.assembleDocument(CommonUtilities.getDataPath(sourceTemplate),
				CommonUtilities.getOutPath("/Html Reports/out.html"),new DataSourceInfo( table, "table"));
		// DocumentAssembler assembler = new DocumentAssembler();
		// ExEnd:generateHtmlReport
	}

    public static void removeSelectiveChartSeries() {
		// ExStart:removeSelectiveChartSeries
		String srcDocument = "/Word Templates/Chart with Filtering, Grouping, and Ordering_RemoveIf.docx";
		String docReport = "/Word Reports/Chart with Filtering, Grouping, and Ordering_report_RemoveIf.docx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			//Set mode 1 or 2 to remove 1st or 2nd Quarter data
			int mode = 1;
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),new DataSourceInfo(new DataStorage(),"orders"), 
					new DataSourceInfo(mode,"mode"));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
		// ExEnd:removeSelectiveChartSeries
    }

	public static void dynamicChartAxisTitle() {
		// ExStart:dynamicChartAxisTitle
		String srcDocument = "/Word Templates/Chart with Filtering, Grouping, and Ordering_dynamic_title.docx";
		String docReport = "/Word Reports/Chart with Filtering, Grouping, and Ordering_dynamic_title.docx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			String title = "Total Order Quantity by Quarters";
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), 
					new DataSourceInfo(new DataStorage(),"orders" ),
					new DataSourceInfo(title,"title"));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
		// ExEnd:dynamicChartAxisTitle
	}

	public static void dynamicColor() {
		// ExStart:dynamicChartAxisTitle
		String srcDocument = "/Word Templates/In-Table List_BackgroundColor.docx";
		String docReport = "/Word Reports/In-Table List_BackgroundColor.docx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			String color = "red";
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),
					new DataSourceInfo(new DataStorage(), "orders"),
					new DataSourceInfo(color,"color" ));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
		// ExEnd:dynamicChartAxisTitle
	}

	public static void dynamicChartAxisTitlePPt() {
		// ExStart:dynamicChartAxisTitlePPt
		String srcDocument = "\\Presentation Templates\\Chart with Filtering, Grouping, and Ordering_Dynamic_Title.pptx";
		String docReport = "\\Presentation Reports\\Chart with Filtering, Grouping, and Ordering_Dynamic_Title.pptx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			String title = "Total Order Quantity by Quarters";
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),
					new DataSourceInfo(new DataStorage(),"orders"),
					new DataSourceInfo(title,"title"));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
		// ExEnd:dynamicChartAxisTitlePPt
	}

	public static void dynamicChartAxisTitleSpreadSheet() {
		// ExStart:dynamicChartAxisTitleSpreadSheet
		String srcDocument = "\\Spreadsheet Templates\\Chart with Filtering, Grouping, and Ordering_Dynamic_Title.xlsx";
		String docReport = "\\Spreadsheet Reports\\Chart with Filtering, Grouping, and Ordering_Dynamic_Title.xlsx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			String title = "Total Order Quantity by Quarters";
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),
					new DataSourceInfo(new DataStorage(),"orders"),
					new DataSourceInfo(title,"title"));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
		// ExEnd:dynamicChartAxisTitleSpreadSheet
	}

	public static void dynamicChartAxisTitleEmail() {
		// ExStart:dynamicChartAxisTitleEmail
		String srcDocument = "\\Email Templates\\Chart with Filtering, Grouping, and Ordering.msg";
		String docReport = "\\Email Reports\\Chart with Filtering, Grouping, and Ordering_report.msg";
		try{
			String title = "Total Order Quantity by Quarters";
			EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("Chart with Filtering, Grouping, and Ordering.msg", ".msg",title );
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".msg", title);
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
				CommonUtilities.getOutPath(docReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()),
				new DataSourceInfo(getDataSourceDetails.getTitle(), dataSourceNames.getTitle()));
		}catch ( Exception exp){
			System.out.println("Exception: " + exp.getMessage());
		}

		// ExEnd:dynamicChartAxisTitleEmail
	}

	public static void workingWithTableRowDataBandsWord() throws Throwable {
        String srcDocument = "/Word Templates/Working With Table Row Data Bands.docx";
        String docReport = "/Word Reports/Working With Table Row Data Bands.docx";
        try {
            DocumentAssembler assembler = new DocumentAssembler();
            assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),
					new DataSourceInfo(new DataStorage(), null),
					new DataSourceInfo(DataStorage.excelData(),"ds"));
        } catch (Exception exp) {
            System.out.println("Exception: " + exp.getMessage());
        }
	}
	public static void workingWithTableRowDataBandsSpreadSheet() throws Throwable {
		String srcDocument = "/Spreadsheet Templates/Working With Table Row Data Bands.xlsx";
		String docReport = "/Spreadsheet Reports/Working With Table Row Data Bands.xlsx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), 
					new DataSourceInfo(new DataStorage(), null),
					new DataSourceInfo(DataStorage.excelData(),"ds"));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
	}

	public static void workingWithTableRowDataBandsPresentation() throws Throwable {
		String srcDocument = "/Presentation Templates/Working With Table Row Data Bands.pptx";
		String docReport = "/Presentation Reports/Working With Table Row Data Bands.pptx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), 
					new DataSourceInfo(new DataStorage(), null),
					new DataSourceInfo(DataStorage.excelData(),"ds"));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
	}

	public static void workingWithTableRowDataBandsEmail() throws Throwable {
		String srcDocument = "/Email Templates/Working With Table Row Data Bands.msg";
		String docReport = "/Email Reports/Working With Table Row Data Bands.msg";
		try {
			DocumentAssembler assembler = new DocumentAssembler();

			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),
					new DataSourceInfo(new DataStorage(), null),
					new DataSourceInfo(DataStorage.excelData(),"ds"));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
	}

	public static void usingStringTemplate() {
		try{
			DocumentAssembler assembler = new DocumentAssembler();
			String sourceString = "<<[yourValue]>>";
			byte[] sourceBytes = sourceString.getBytes();
			byte[] targetBytes;
			ByteArrayInputStream sourceStream = new ByteArrayInputStream(sourceBytes);
			ByteArrayOutputStream targetStream = new ByteArrayOutputStream();
			assembler.assembleDocument(sourceStream, targetStream, new DataSourceInfo("Hello, World!", "yourValue"));
			targetBytes = targetStream.toByteArray();
			String targetString = new String(targetBytes, StandardCharsets.UTF_8);
			System.out.println(targetString);

		}
		catch (Exception exp){
			System.out.println("Exception: " + exp.getMessage());
		}
	}

	public static void dynamicChartSeriesColor() {
		try {
			String srcDocument = "/Word Templates/Dynamic Chart Series Color.docx";
			String outDocument = "/Word Reports/Dynamic Chart Series Color.docx";
			//Define series color
			String color1 = "blue";
			String color2 = "red";
			// Set table column names to be extracted from the document.
			DocumentTableOptions options = new DocumentTableOptions();
			options.setFirstRowContainsColumnNames(true);

			DocumentTable table = new DocumentTable(CommonUtilities.wordDataFile + "/Managers Data.docx", 1, options);

			// NOTE: For non-Spreadsheet documents, the type of a document table
			// column is always string by default.
			assert table.getColumns().get("Total_Contract_Price").getType() == String.class;

			// Change the column's type to double thus enabling to use arithmetic
			// operations on values of the column
			// such as summing in templates.
			table.getColumns().get("Total_Contract_Price").setType(double.class);

			// Pass DocumentTable as a data source.
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(outDocument),
					new DataSourceInfo(table,"managers"),
					new DataSourceInfo(color1,"color1"),
					new DataSourceInfo(color2,"color2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dynamicChartSeriesColorSpreadsheet() {
		try {
			String srcDocument = "/Spreadsheet Templates/Dynamic Chart Series Color.xlsx";
			String outDocument = "/Spreadsheet Reports/Dynamic Chart Series Color.xlsx";
			//Define series color
			String color1 = "blue";
			String color2 = "red";
			// Set table column names to be extracted from the document.
			DocumentTableOptions options = new DocumentTableOptions();
			options.setFirstRowContainsColumnNames(true);

			DocumentTable table = new DocumentTable(CommonUtilities.wordDataFile + "/Managers Data.docx", 1, options);

			// NOTE: For non-Spreadsheet documents, the type of a document table
			// column is always string by default.
			assert table.getColumns().get("Total_Contract_Price").getType() == String.class;

			// Change the column's type to double thus enabling to use arithmetic
			// operations on values of the column
			// such as summing in templates.
			table.getColumns().get("Total_Contract_Price").setType(double.class);

			// Pass DocumentTable as a data source.
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(outDocument), 
					new DataSourceInfo(table,"managers"),
					new DataSourceInfo(color1,"color1"),
					new DataSourceInfo(color2,"color2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dynamicChartSeriesColorPresentation() {
		try {
			String srcDocument = "/Presentation Templates/Dynamic Chart Series Color.pptx";
			String outDocument = "/Presentation Reports/Dynamic Chart Series Color.pptx";
			//Define series color
			String color1 = "blue";
			String color2 = "red";
			// Set table column names to be extracted from the document.
			DocumentTableOptions options = new DocumentTableOptions();
			options.setFirstRowContainsColumnNames(true);

			DocumentTable table = new DocumentTable(CommonUtilities.wordDataFile + "/Managers Data.docx", 1, options);

			// NOTE: For non-Spreadsheet documents, the type of a document table
			// column is always string by default.
			assert table.getColumns().get("Total_Contract_Price").getType() == String.class;

			// Change the column's type to double thus enabling to use arithmetic
			// operations on values of the column
			// such as summing in templates.
			table.getColumns().get("Total_Contract_Price").setType(double.class);

			// Pass DocumentTable as a data source.
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(outDocument), 
					new DataSourceInfo(table,"managers"),
					new DataSourceInfo(color1,"color1"),
					new DataSourceInfo(color2,"color2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void dynamicChartSeriesColorEmail() {
		try {
			String srcDocument = "/Email Templates/Dynamic Chart Series Color.msg";
			String outDocument = "/Email Reports/Dynamic Chart Series Color.msg";
			//Define series color
			String color = "blue";
			// Set table column names to be extracted from the document.
			DocumentTableOptions options = new DocumentTableOptions();
			options.setFirstRowContainsColumnNames(true);

			DocumentTable table = new DocumentTable(CommonUtilities.wordDataFile + "/Managers Data.docx", 1, options);

			// NOTE: For non-Spreadsheet documents, the type of a document table
			// column is always string by default.
			assert table.getColumns().get("Total_Contract_Price").getType() == String.class;

			// Change the column's type to double thus enabling to use arithmetic
			// operations on values of the column
			// such as summing in templates.
			table.getColumns().get("Total_Contract_Price").setType(double.class);

			// Pass DocumentTable as a data source.
			DocumentAssembler assembler = new DocumentAssembler();
			DocumentAssembler.setUseReflectionOptimization(false);
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(outDocument), 
					new DataSourceInfo(table,"managers"),
					new DataSourceInfo(color,"color"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dynamicChartSeriesPointColor() {
		String srcDocument = "/Word Templates/Dynamic Chart Point Series Color.docx";
		String docReport = "/Word Reports/Dynamic Chart Point Series Color.docx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),new DataSourceInfo(new DataStorage(), null));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
	}

	public static void dynamicChartSeriesPointColorSpreadsheet() {
		String srcDocument = "/Spreadsheet Templates/Dynamic Chart Point Series Color.xlsx";
		String docReport = "/Spreadsheet Reports/Dynamic Chart Point Series Color.xlsx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),new DataSourceInfo(new DataStorage(), null));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
	}

	public static void dynamicChartSeriesPointColorPresentation() {
		String srcDocument = "/Presentation Templates/Dynamic Chart Point Series Color.pptx";
		String docReport = "/Presentation Reports/Dynamic Chart Point Series Color.pptx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
	}
	public static void dynamicChartSeriesPointColorEmail() {
		String srcDocument = "/Email Templates/Dynamic Chart Point Series Color.msg";
		String docReport = "/Email Reports/Dynamic Chart Point Series Color.msg";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),new DataSourceInfo(new DataStorage(), null));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
	}


		// Insert Hyperlink Dynamically in Word Document
		// Feature is supported by version 18.7 or greater
		public static void dynamicHyperlinkInsertionWord()
		{
			//setting up source 
			String strDocumentTemplate = "/Word Templates/Dynamic Hyperlink.docx";
			//Setting up destination 
			String strDocumentReport = "/Word Reports/Dynamic Hyperlink.docx";
			//Setting up Uri Expression
			String uriExpression = "https://www.groupdocs.com/";
			//Setting up Display Text Expression
			String displayTextExpression = "GroupDocs";
			try
			{	
				//Instantiate DocumentAssembler class
				DocumentAssembler assembler = new DocumentAssembler();
				//Call AssembleDocument to assemble document 
				assembler.assembleDocument(CommonUtilities.getDataPath(strDocumentTemplate), CommonUtilities.getOutPath(strDocumentReport), 
				new DataSourceInfo(uriExpression,"uriExpression"),
				new DataSourceInfo(displayTextExpression,"displayTextExpression"));
			}
			catch (Exception exp)
			{
				System.out.println("Exception: " + exp.getMessage());
			}
		}
		// Insert Hyperlink Dynamically in Email Document
		// Feature is supported by version 18.7 or greater
		public static void dynamicHyperlinkInsertionEmail()
		{
			//setting up source 
			String strDocumentTemplate = "/Email Templates/Dynamic Hyperlink.msg";
			//Setting up destination 
			String strDocumentReport = "/Email Reports/Dynamic Hyperlink.msg";
			//Setting up Uri Expression
			String uriExpression = "https://www.groupdocs.com/";
			//Setting up Display Text Expression
			String displayTextExpression = "GroupDocs";
			try
			{
				//Instantiate DocumentAssembler class
				DocumentAssembler assembler = new DocumentAssembler();
				//Call AssembleDocument to assemble document 
				assembler.assembleDocument(CommonUtilities.getDataPath(strDocumentTemplate), CommonUtilities.getOutPath(strDocumentReport), 
				new DataSourceInfo(uriExpression,"uriExpression"),
				new DataSourceInfo(displayTextExpression,"displayTextExpression"));
			}
			catch (Exception exp)
			{
				System.out.println("Exception: " + exp.getMessage());
			}
		}
		// Insert Hyperlink Dynamically in Spreadsheet Document
		// Feature is supported by version 18.7 or greater
		public static void dynamicHyperlinkInsertionSpreadsheet()
		{
			//setting up source 
			String strDocumentTemplate = "/Spreadsheet Templates/Dynamic Hyperlink.xlsx";
			//Setting up destination 
			String strDocumentReport = "/Spreadsheet Reports/Dynamic Hyperlink.xlsx";
			//Setting up Uri Expression
			String uriExpression = "https://www.groupdocs.com/";
			//Setting up Display Text Expression
			String displayTextExpression = "GroupDocs";
			try
			{
				//Instantiate DocumentAssembler class
				DocumentAssembler assembler = new DocumentAssembler();
				//Call AssembleDocument to assemble document 
				assembler.assembleDocument(CommonUtilities.getDataPath(strDocumentTemplate), CommonUtilities.getOutPath(strDocumentReport), 
				new DataSourceInfo(uriExpression,"uriExpression"),
				new DataSourceInfo(displayTextExpression,"displayTextExpression"));
			}
			catch (Exception exp)
			{
				System.out.println("Exception: " + exp.getMessage());
			}
		}
		/// Insert Hyperlink Dynamically in Presentaion Document
		/// Feature is supported by version 18.7 or greater
		public static void dynamicHyperlinkInsertionPresentation()
		{
			//setting up source 
			String strDocumentTemplate = "/Presentation Templates/Dynamic Hyperlink.pptx";
			//Setting up destination 
			String strDocumentReport = "/Presentation Reports/Dynamic Hyperlink.pptx";
			//Setting up Uri Expression
			String uriExpression = "https://www.groupdocs.com/";
			//Setting up Display Text Expression
			String displayTextExpression = "GroupDocs";
			try
			{
				//Instantiate DocumentAssembler class
				DocumentAssembler assembler = new DocumentAssembler();
				//Call AssembleDocument to assemble document 
				assembler.assembleDocument(CommonUtilities.getDataPath(strDocumentTemplate), CommonUtilities.getOutPath(strDocumentReport), 
				new DataSourceInfo(uriExpression,"uriExpression"),
				new DataSourceInfo(displayTextExpression,"displayTextExpression"));
			}
			catch (Exception exp)
			{
				System.out.println("Exception: " + exp.getMessage());
			}
		}

		public static void changeTargetFileFormat() {
			String srcDocument = "/Word Templates/Bubble Chart.docx";
			String docReport = "/PDF Reports/Bubble Chart_report.pdf";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
		}

		public static void changeTargetFileFormatUsingExplicitSpecifying() {
			String srcDocument = "/Word Templates/Bubble Chart.docx";
			String docReport = "/PDF Reports/Bubble Chart_report.pdf";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),new LoadSaveOptions(FileFormat.PDF),new DataSourceInfo( new DataStorage(), null));
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
		}

	/**
	 * Supports removal of paragraphs becoming empty after template syntax tags are removed or replaced with empty values for Word Processing documents
	 * This feature is supported by version 18.10 or higher
	 */
    public static void emptyParagraphInWordProcessing() {
		String srcDocument = "/Word Templates/Empty Paragraph.docx";
		String docReport = "/Word Reports/Empty Paragraph.docx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.setOptions(DocumentAssemblyOptions.REMOVE_EMPTY_PARAGRAPHS);
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
										CommonUtilities.getOutPath(docReport),
										new DataSourceInfo("dummy", "dummy"));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
    }
	/**
	 * Supports removal of paragraphs becoming empty after template syntax tags are removed or replaced with empty values for Presentation documents
	 * This feature is supported by version 18.10 or higher
	 */
	public static void emptyParagraphInPresentation() {
		String srcDocument = "/Presentation Templates/Empty Paragraph.pptx";
		String docReport = "/Presentation Reports/Empty Paragraph.pptx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.setOptions(DocumentAssemblyOptions.REMOVE_EMPTY_PARAGRAPHS);
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),
					new DataSourceInfo("dummy", "dummy"));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
	}

	/**
	 * Supports removal of paragraphs becoming empty after template syntax tags are removed or replaced with empty values for Email documents
	 * This feature is supported by version 18.10 or higher
	 */
	public static void emptyParagraphInEmail() {
		String srcDocument = "/Email Templates/Empty Paragraph.msg";
		String docReport = "/Email Reports/Empty Paragraph.msg";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.setOptions(DocumentAssemblyOptions.REMOVE_EMPTY_PARAGRAPHS);
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),
					new DataSourceInfo("dummy", "dummy"));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
	}

	/**
	 * This method inserts nested external documents in word document
	 */
    public static void insertNestedExternalDocumentsInWord() {

		String srcDocument = "/Word Templates/Nested External Document.docx";
		String docReport = "/Word Reports/Nested External Document.docx";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
    }
	/**
	 * This method inserts nested external documents in email document
	 */
	public static void insertNestedExternalDocumentsInEmail() {

		String srcDocument = "/Email Templates/Nested External Document.msg";
		String docReport = "/Email Reports/Nested External Document.msg";
		try {
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport),new DataSourceInfo( new DataStorage(), null));
		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
		}
	}
	/**
	 * Table Cell Merging in Word Processing Documents
	 * Features is supported by version 19.1 or greater
	 */
	public static void tableCellsMergingInWordProcessing()
    {
		//ExStart:tableCellsMergingInWordProcessing
        //Setting up source document template
         String strDocumentTemplate = "/Word Templates/Merging Cells Dynamically.docx";
        //Setting up destination PDF report 
         String strDocumentReport = "/PDF Reports/Merging Cells Dynamically Report.pdf";
        try
        {
            //Instantiate DocumentAssembler class
            DocumentAssembler assembler = new DocumentAssembler();
            //Create sample data source object
            Manager manager = new DataStorage().getManagers().iterator().next();
            //Call AssembleDocument to Merging Cells Dynamically Report in PDF format
            assembler.assembleDocument(CommonUtilities.getDataPath(strDocumentTemplate),
            		CommonUtilities.getOutPath(strDocumentReport), new LoadSaveOptions(FileFormat.PDF), new DataSourceInfo( manager, "manager"));
        }
        catch (Exception exp)
        {
        	System.out.println("Exception: " + exp.getMessage());
        }
        //ExEnd:tableCellsMergingInWordProcessing
    }
	/**
	 * Table Cell Merging in Presentations
	 * Features is supported by version 19.1 or greater
	 */
	public static void tableCellsMergingInPresentations()
    {
		//ExStart:tableCellsMergingInPresentations
        //Setting up source document template
         String strDocumentTemplate = "/Presentation Templates/Merging Cells Dynamically.pptx";
        //Setting up destination PDF report 
         String strDocumentReport = "/PDF Reports/Merging Cells Dynamically Report.pdf";
        try
        {
            //Instantiate DocumentAssembler class
            DocumentAssembler assembler = new DocumentAssembler();
            //Create sample data source object
            Manager manager = new DataStorage().getManagers().iterator().next();
            //Call AssembleDocument to Merging Cells Dynamically Report in PDF format
            assembler.assembleDocument(CommonUtilities.getDataPath(strDocumentTemplate),
            		CommonUtilities.getOutPath(strDocumentReport), new LoadSaveOptions(FileFormat.PDF), new DataSourceInfo( manager, "manager"));
        }
        catch (Exception exp)
        {
        	System.out.println("Exception: " + exp.getMessage());
        }
        //ExEnd:tableCellsMergingInPresentations
    }
	/**
	 * Table Cell Merging in Spreadsheets
	 * Features is supported by version 19.1 or greater
	 */
	public static void tableCellsMergingInSpreadsheets()
    {
		//ExStart:tableCellsMergingInSpreadsheets
        //Setting up source document template
         String strDocumentTemplate = "/Spreadsheet Templates/Merging Cells Dynamically.xlsx";
        //Setting up destination PDF report 
         String strDocumentReport = "/PDF Reports/Merging Cells Dynamically Report.pdf";
        try
        {
            //Instantiate DocumentAssembler class
            DocumentAssembler assembler = new DocumentAssembler();
            //Create sample data source object
            Manager manager = new DataStorage().getManagers().iterator().next();
            //Call AssembleDocument to Merging Cells Dynamically Report in PDF format
            assembler.assembleDocument(CommonUtilities.getDataPath(strDocumentTemplate),
            		CommonUtilities.getOutPath(strDocumentReport), new LoadSaveOptions(FileFormat.PDF), new DataSourceInfo( manager, "manager"));
        }
        catch (Exception exp)
        {
        	System.out.println("Exception: " + exp.getMessage());
        }
        //ExEnd:tableCellsMergingInSpreadsheets
    }
	/**
	 * Table Cell Merging in Emails
	 * Features is supported by version 19.1 or greater
	 */
	public static void tableCellsMergingInEmails()
    {
		//ExStart:tableCellsMergingInSpreadsheets
        //Setting up source document template
         String strDocumentTemplate = "/Email Templates/Merging Cells Dynamically.msg";
        //Setting up destination PDF report 
         String strDocumentReport = "/Email Reports/Merging Cells Dynamically Report.msg";
        try
        {
            //Instantiate DocumentAssembler class
            DocumentAssembler assembler = new DocumentAssembler();
            //Call AssembleDocument to Merging Cells Dynamically Report in PDF format
           			
            EmailDataSourcesObjects getDataSourceDetails = DataStorage.emailDataSourceObject("Merging Cells Dynamically.msg", ".msg");
			EmailDataSourcesNames dataSourceNames = DataStorage.emailDataSourceName(".msg");
			assembler.assembleDocument(CommonUtilities.getDataPath(strDocumentTemplate),
				CommonUtilities.getOutPath(strDocumentReport),
				new DataSourceInfo(getDataSourceDetails.getDataSource(), dataSourceNames.getDataSource()),
				new DataSourceInfo(getDataSourceDetails.getSender(), dataSourceNames.getSender()),
				new DataSourceInfo(getDataSourceDetails.getRecipients(), dataSourceNames.getRecipients()),
				new DataSourceInfo(getDataSourceDetails.getCC(), dataSourceNames.getCC()),
				new DataSourceInfo(getDataSourceDetails.getSubject(), dataSourceNames.getSubject()),
				new DataSourceInfo(getDataSourceDetails.getManager(), dataSourceNames.getManager()));
        }
        catch (Exception exp)
        {
        	System.out.println("Exception: " + exp.getMessage());
        }
        //ExEnd:tableCellsMergingInSpreadsheets
    }
	/**
	 * In-lining syntax error messages into templates
	 * Features is supported by version 19.3 or greater
	 */
	public static void demoInLineSyntaxError()
    {
		try
		{
			//ExStart:DemoInLineSyntaxError_19.3
			//Setting up source document template
			String strDocumentTemplate = "/Word Templates/Inline Error Demo.docx";
			//Setting up destination PDF report 
			String strDocumentReport = "/PDF Reports/Inline Error Demo.pdf.pdf";

			//Instantiate DocumentAssembler class
			DocumentAssembler assembler = new DocumentAssembler();
			//Enable the In-line error messaging
			assembler.setOptions(DocumentAssemblyOptions.INLINE_ERROR_MESSAGES);
			//Create sample data source object
			Manager manager = new DataStorage().getManagers().iterator().next();

			//Call AssembleDocument to show the demo Report and save the report in PDF format
			//The AssembleDocument will return a boolean value to indicate the success or failed with inline error.
			if(assembler.assembleDocument(CommonUtilities.getDataPath(strDocumentTemplate),
					CommonUtilities.getOutPath(strDocumentReport), new LoadSaveOptions(FileFormat.PDF), new DataSourceInfo( manager, "manager")))
			{
				System.out.println("No error found in the template.");
			}
			else
			{
				System.out.println("Do something with a report containing a template syntax error.");
			}
			//ExEnd:DemoInLineSyntaxError_19.3

		}
		catch (Exception exp)
		{
			System.out.println("Exception: " + exp.getMessage());
		}
        
    }
	/**
	 * Loading of template documents from HTML with resources
	 * Features is supported by version 19.5 or greater
	 */
	public static void loadDocFromHTMLWithResource()
    {
		try
		{
			//ExStart:LoadDocFromHTMLWithResource_19.5
			//Setting up resource directory for input template and output
            String strDirectoryPath = CommonUtilities.getSourceFolder("\\ResourceLoad\\");
			

			//Instantiate DocumentAssembler class
			DocumentAssembler assembler = new DocumentAssembler();
					  
			assembler.assembleDocument(strDirectoryPath + "TestWordsResourceLoad.htm", 
					strDirectoryPath + "TestWordsResourceLoad Out.docx", 
					new DataSourceInfo("It should be a jeep image.", "value"));
			//ExEnd:LoadDocFromHTMLWithResource_19.5

		}
		catch (Exception exp)
		{
			System.out.println("Exception: " + exp.getMessage());
		}
        
    }
	/**
	 * Loading of template documents from HTML with resources from an explicitly specified folder
	 * Features is supported by version 19.5 or greater
	 */
	public static void  loadDocFromHTMLWithResource_ExplicitFolder()
    {
		try
		{
			//ExStart:LoadDocFromHTMLWithResource_ExplicitFolder_19.5
			//Setting up resource directory for input template and output
            String strDirectoryPath = CommonUtilities.getSourceFolder("\\ResourceLoad\\");
			
			//Instantiate DocumentAssembler class
			DocumentAssembler assembler = new DocumentAssembler();
			
			LoadSaveOptions loadSaveOptions = new LoadSaveOptions();
			loadSaveOptions.setResourceLoadBaseUri(strDirectoryPath + "Alternative");
			  
			assembler.assembleDocument(strDirectoryPath + "TestWordsResourceLoad.htm", strDirectoryPath + 
					"TestWordsResourceLoad Out.docx", 
					loadSaveOptions, new DataSourceInfo("It should be a sport car image.", "value"));
			//ExEnd:LoadDocFromHTMLWithResource_ExplicitFolder_19.5

		}
		catch (Exception exp)
		{
			System.out.println("Exception: " + exp.getMessage());
		}
        
    }
	/**
	 *  Saving of external resource files at relative path while an assembled document loaded from a non-HTML format is being saved to HTML
	 * Features is supported by version 19.5 or greater
	 */
	public static void saveDocToHTMLWithResource()
    {
		try
		{
			//ExStart:SaveDocToHTMLWithResource_19.5
			//Setting up resource directory for input template and output
            String strDirectoryPath = CommonUtilities.getSourceFolder("\\ResourceSave\\");
			

			//Instantiate DocumentAssembler class
			DocumentAssembler assembler = new DocumentAssembler();
					  
			assembler.assembleDocument(strDirectoryPath + "TestWordsResourceSave.docx", 
					strDirectoryPath + "TestWordsResourceSave Out.htm", new DataSourceInfo("Hello!", "value"));
			//ExEnd:SaveDocToHTMLWithResource_19.5

		}
		catch (Exception exp)
		{
			System.out.println("Exception: " + exp.getMessage());
		}
        
    }
	/**
	 * Loading of template documents from HTML with resources from an explicitly specified folder
	 * Feature is supported by version 19.5 or greater
	 */
	public static void  saveDocToHTMLWithResource_ExplicitFolder()
    {
		try
		{
			//ExStart:SaveDocToHTMLWithResource_ExplicitFolder_19.5
			//Setting up resource directory for input template and output
            String strDirectoryPath = CommonUtilities.getSourceFolder("\\ResourceSave\\");
			
			//Instantiate DocumentAssembler class
			DocumentAssembler assembler = new DocumentAssembler();
			
			LoadSaveOptions loadSaveOptions = new LoadSaveOptions();
			loadSaveOptions.setResourceSaveFolder(strDirectoryPath + "Alternative");
			  
			assembler.assembleDocument(strDirectoryPath + "TestWordsResourceSave.docx",
					strDirectoryPath + "TestWordsResourceSave Out.htm", loadSaveOptions,
					new DataSourceInfo("Hello!", "value"));
			//ExEnd:SaveDocToHTMLWithResource_ExplicitFolder_19.5

		}
		catch (Exception exp)
		{
			System.out.println("Exception: " + exp.getMessage());
		}
        
    }
	/**
	 * Saving an assembled Markdown document to a Word Processing format using file extension.
	 * Feature is supported by version 19.8 or greater
	 */
	public static void saveMdtoWord_UsingExtension()
    {
		try
		{
			//ExStart:saveMdtoWord_UsingExtension_19.8
			//Setting up source document template
			String strDocumentTemplate = "/Markdown Templates/ReadMe.md";
			//Setting up destination PDF report 
			String strDocumentReport = "/Word Reports/ReadMe Out.docx";
			
			String description = "GroupDocs.Assembly for Java is a class library that enables you to generate documents in popular " +
				    "office and email file formats based upon template documents and data obtained from various sources " +
				    "including databases, XML, JSON, OData, objects of custom Java types, external documents, and more.";

			//Instantiate DocumentAssembler class
			DocumentAssembler assembler = new DocumentAssembler();
			
					  
			assembler.assembleDocument(
					CommonUtilities.getDataPath(strDocumentTemplate),
					CommonUtilities.getOutPath(strDocumentReport),
			    new DataSourceInfo("GroupDocs.Assembly for Java", "product"),
			    new DataSourceInfo(description, "description"));
			//ExEnd:saveMdtoWord_UsingExtension_19.8

		}
		catch (Exception exp)
		{
			System.out.println("Exception: " + exp.getMessage());
		}
        
    }
	/**
	 * Saving an assembled Word Processing document or email to Markdown using file extension.
	 * Feature is supported by version 19.8 or greater
	 */
	public static void saveWordOrEmailtoMD_UsingExtension()
    {
		try
		{
			//ExStart:saveWordOrEmailtoMD_UsingExtension_19.8
			//Setting up source document template
			String strDocumentTemplate = "/Word Templates/ReadMe.docx";
			//Setting up destination PDF report 
			String strDocumentReport = "/Markdown Reports/ReadMe Out.md";
			
			String description = "GroupDocs.Assembly for Java is a class library that enables you to generate documents in popular " +
				    "office and email file formats based upon template documents and data obtained from various sources " +
				    "including databases, XML, JSON, OData, objects of custom Java types, external documents, and more.";

			//Instantiate DocumentAssembler class
			DocumentAssembler assembler = new DocumentAssembler();
								  
			assembler.assembleDocument(
					CommonUtilities.getDataPath(strDocumentTemplate),
					CommonUtilities.getOutPath(strDocumentReport),
			    new DataSourceInfo("GroupDocs.Assembly for Java", "product"),
			    new DataSourceInfo(description, "description"));
			//ExEnd:saveWordOrEmailtoMD_UsingExtension_19.8

		}
		catch (Exception exp)
		{
			System.out.println("Exception: " + exp.getMessage());
		}
        
    }
	/**
	 * Saving an assembled Word Processing document or email to Markdown using explicit specifying.
	 * Feature is supported by version 19.8 or greater
	 */
	public static void saveWordOrEmailtoMD_Explicit()
    {
		try
		{
			//ExStart:saveWordOrEmailtoMD_Explicit_19.8
			//Setting up source document template
			InputStream sourceStream = new FileInputStream(CommonUtilities.getDataPath("/Word Templates/ReadMe.docx"));
			//Setting up destination PDF report 
			File outFile = new File(CommonUtilities.getOutPath("/Markdown Reports/ReadMe Out.md"));
			outFile.createNewFile();
			OutputStream  targetStream = new FileOutputStream(outFile, false);
			
			String description = "GroupDocs.Assembly for Java is a class library that enables you to generate documents in popular " +
				    "office and email file formats based upon template documents and data obtained from various sources " +
				    "including databases, XML, JSON, OData, objects of custom Java types, external documents, and more.";

			//Instantiate DocumentAssembler class
			DocumentAssembler assembler = new DocumentAssembler();
			
					  
			DataSourceInfo dataSourceInfo1 = new DataSourceInfo("The GroupDocs.Assembly for Java","product");
			DataSourceInfo dataSourceInfo2 = new DataSourceInfo(description,"description");
			
			  
			assembler.assembleDocument(sourceStream, targetStream, new LoadSaveOptions(FileFormat.MARKDOWN), dataSourceInfo1,dataSourceInfo2);
			//ExEnd:saveWordOrEmailtoMD_Explicit_19.8

		}
		catch (Exception exp)
		{
			System.out.println("Exception: " + exp.getMessage());
		}
        
    }
}
