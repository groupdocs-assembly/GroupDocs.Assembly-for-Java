package com.groupdocs.assembly.examples;

import java.io.File;
import java.util.ArrayList;

import com.groupdocs.assembly.DocumentAssembler;
import com.groupdocs.assembly.DocumentAssemblyOptions;
import com.groupdocs.assembly.DocumentTable;
import com.groupdocs.assembly.DocumentTableOptions;
import com.groupdocs.assembly.DocumentTableSet;
import com.groupdocs.assembly.examples.BusinessEntities.Manager;

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
				CommonUtilities.getOutPath("/Presentation Reports/out.pptx"), tableSet);
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
				CommonUtilities.getOutPath("/Word Reports/out.docx"), tableSet);
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
				CommonUtilities.getOutPath("/Presentation Reports/out.pptx"), table, "Managers");
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:bubblechartpresentation
		} else if (documentFormat == "email") {
			//ExStart:emailgenerateBubbleChart
			String srcDocument = "/Email Templates/Bubble Chart.eml";
			String docReport = "/Email Reports/Bubble Chart_report.eml";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("Bubble Chart.eml", ".eml");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:bulletedlisttxt
		}else if (documentFormat == "email") {
			//ExStart:emailgenerateBulletedList
			String srcDocument = "/Email Templates/Bulleted List.msg";
			String docReport = "/Email Reports/Bulleted List_report.msg";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("Bulleted List.msg", ".msg");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".msg");
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:chartwithfilteringgroupingandorderingpresentation
		}else if (documentFormat == "email") {
			//ExStart:emailchartwithfilteringgroupingordering
			String srcDocument = "/Email Templates/Chart with Filtering, Grouping, and Ordering.msg";
			String docReport = "/Email Reports/Chart with Filtering, Grouping, and Ordering_report.msg";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("Chart with Filtering, Grouping, and Ordering.msg", ".msg");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".msg");
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:commonlisttxt
		}else if (documentFormat == "email") {
			//ExStart:emailCommonList
			String srcDocument = "/Email Templates/Common List.eml";
			String docReport = "/Email Reports/Common List_report.eml";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("Common List.eml", ".eml");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:commonmasterdetailtxt
		}else if (documentFormat == "email") {
			//ExStart:emailCommonMasterDetail
			String srcDocument = "/Email Templates/Common Master-Detail.eml";
			String docReport = "/Email Reports/Common Master-Detail_report.eml";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("Common Master-Detail.eml", ".eml");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:inparagraphlisttxt
		}else if (documentFormat == "email") {
			//ExStart:emailInParagraphList
			String srcDocument = "/Email Templates/In-Paragraph List.eml";
			String docReport = "/Email Reports/In-Paragraph List_report.eml";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("In-Paragraph List.eml", ".eml");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithalternatecontenthtml
		}else if (documentFormat == "email") {
			//ExStart:emailInTableListWithAlternateContent
			String srcDocument = "/Email Templates/In-Table List with Alternate Content.eml";
			String docReport = "/Email Reports/In-Table List with Alternate Content_report.eml";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("In-Table List with Alternate Content.eml", ".eml");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithfilteringroupingandorderinghtml
		}else if (documentFormat == "email") {
			//ExStart:emailInTableListWithFilteringGroupingAndOrdering
			String srcDocument = "/Email Templates/In-Table List with Filtering, Grouping, and Ordering.eml";
			String docReport = "/Email Reports/In-Table List with Filtering, Grouping, and Ordering_report.eml";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("In-Table List with Filtering, Grouping, and Ordering.eml", ".eml");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelistwithhighllightedrowshtml
		}else if (documentFormat == "email") {
			//ExStart:emailInTableListWithHighlightedRows
			String srcDocument = "/Email Templates/In-Table List with Highlighted Rows.eml";
			String docReport = "/Email Reports/In-Table List with Highlighted Rows_report.eml";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("In-Table List with Highlighted Rows.eml", ".eml");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablelisthtml
		}else if (documentFormat == "email") {
			//ExStart:emailInTableList
			String srcDocument = "/Email Templates/In-Table List.eml";
			String docReport = "/Email Reports/In-Table List_report.eml";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("In-Table List.eml", ".eml");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:intablemasterdetailhtml
		}else if (documentFormat == "email") {
			//ExStart:emailInTableMasterDetail
			String srcDocument = "/Email Templates/In-Table Master-Detail.eml";
			String docReport = "/Email Reports/In-Table Master-Detail_report.eml";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("In-Table Master-Detail.eml", ".eml");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:multicolorednumberedlisthtml
		}else if (documentFormat == "email") {
			//ExStart:emailMulticoloredNumberedList
			String srcDocument = "/Email Templates/Multicolored Numbered List.eml";
			String docReport = "/Email Reports/Multicolored Numbered List_report.eml";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("Multicolored Numbered List.eml", ".eml");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:numberedlisttxt
		}else if (documentFormat == "email") {
			//ExStart:emailNumberedList
			String srcDocument = "/Email Templates/Numbered List.eml";
			String docReport = "/Email Reports/Numbered List_report.eml";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("Numbered List.eml", ".eml");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
			//ExEnd:emailNumberedList
		} 
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:piechartpresentation
		}else if (documentFormat == "email") {
			//ExStart:emailPieChart
			String srcDocument = "/Email Templates/Pie Chart.eml";
			String docReport = "/Email Reports/Pie Chart_report.eml";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("Pie Chart.eml", ".eml");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:scatterchartpresentation
		}else if (documentFormat == "email") {
			//ExStart:emailScatterChart
			String srcDocument = "/Email Templates/Scatter Chart.eml";
			String docReport = "/Email Reports/Scatter Chart_report.eml";
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("Scatter Chart.eml", ".eml");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
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
						CommonUtilities.getOutPath(docReport), manager, "manager");
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
						CommonUtilities.getOutPath(docReport), manager, "manager");
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
						CommonUtilities.getOutPath(docReport), manager, "manager");
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
						CommonUtilities.getOutPath(docReport), manager, "manager");
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
						CommonUtilities.getOutPath(docReport), manager, "manager");
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:singlerowtxt
		}else if (documentFormat == "email") {
			//ExStart:emailSingleRow
			String srcDocument = "/Email Templates/Single Row.eml";
			String docReport = "/Email Reports/Single Row_report.eml";
			Manager manager = new DataStorage().getManagers().iterator().next();
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("Single Row.eml", ".eml");
			String[] dataSourceNames = DataStorage.emailDataSourceName(".eml");
			DocumentAssembler assembler = new DocumentAssembler(); 
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
			//ExEnd:emailSingleRow
		} 
	}

	// Generate barcode
	public static void addBarCodes(String documentFormat) {
		if (documentFormat == "document") {
			// ExStart:barcodedocument
			String srcDocument = "/Word Templates/Barcode.docx";
			String docReport = "/Word Reports/Barcode_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), "854283", "value");
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:barcodedocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:barcodespreadsheet
			String srcDocument = "/Spreadsheet Templates/Barcode.xlsx";
			String docReport = "/Spreadsheet Reports/Barcode_report.xlsx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), "854283", "value");
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:barcodespreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:barcodepresentation
			String srcDocument = "/Presentation Templates/Barcode.pptx";
			String docReport = "/Presentation Reports/Barcode_report.pptx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), "854283", "value");
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
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.setOptions(DocumentAssemblyOptions.UPDATE_FIELDS_AND_FORMULAS);
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:UpdateWordDocFieldsindocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:UpdateWordDocFieldsinspreadsheet
			String srcDocument = "/Spreadsheet Templates/Update formula.xlsx";
			String docReport = "/Spreadsheet Reports/Update formula_report.xlsx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.setOptions(DocumentAssemblyOptions.UPDATE_FIELDS_AND_FORMULAS);
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), new DataStorage(), null);
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
			Manager manager = new DataStorage().getManagers().iterator().next();
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument), CommonUtilities.getOutPath(docReport),
					DataStorage.excelData(), "contracts");
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
			Manager manager = new DataStorage().getManagers().iterator().next();
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument), CommonUtilities.getOutPath(docReport),
					DataStorage.importingWordProcessingTableIntoPresentation(), "table");
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
					DataStorage.presentationData(), "table");
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
				// Create an array of data source objects
				Object[] dataSourceObj = new Object[] { new DataStorage(), DataStorage.excelData() };
				// Create an array of data source string
				String[] dataSourceString = new String[] { null, "contracts" };
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), dataSourceObj, dataSourceString);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:barcodedocument
		} else if (documentFormat == "spreadsheet") {
			// ExStart:barcodespreadsheet
			String srcDocument = "/Spreadsheet Templates/Multiple DS.xlsx";
			String docReport = "/Spreadsheet Reports/Multiple DS_report.xlsx";
			try {
				// Create an array of data source objects
				Object[] dataSourceObj = new Object[] { new DataStorage(), DataStorage.excelData() };
				// Create an array of data source string
				String[] dataSourceString = new String[] { null, "contracts" };
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), dataSourceObj, dataSourceString);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			// ExEnd:barcodespreadsheet
		} else if (documentFormat == "presentation") {
			// ExStart:barcodepresentation
			String srcDocument = "/Presentation Templates/Multiple DS.pptx";
			String docReport = "/Presentation Reports/Multiple DS_report.pptx";
			try {
				// Create an array of data source objects
				Object[] dataSourceObj = new Object[] { new DataStorage(), DataStorage.excelData() };
				// Create an array of data source string
				String[] dataSourceString = new String[] { null, "contracts" };
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
						CommonUtilities.getOutPath(docReport), dataSourceObj, dataSourceString);
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
				CommonUtilities.getOutPath("/Html Reports/out.html"), table, "table");
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
					CommonUtilities.getOutPath(docReport), new Object[]{new DataStorage(), mode}, new String[]{"orders", "mode"});
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
					CommonUtilities.getOutPath(docReport), new Object[]{new DataStorage(), title}, new String[]{"orders", "title"});
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
					CommonUtilities.getOutPath(docReport), new Object[]{new DataStorage(), color}, new String[]{"orders", "color"});
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
					CommonUtilities.getOutPath(docReport), new Object[]{new DataStorage(), title}, new String[]{"orders", "title"});
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
					CommonUtilities.getOutPath(docReport), new Object[]{new DataStorage(), title}, new String[]{"orders", "title"});
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
			Object[] getDataSourceDetails = DataStorage.emailDataSourceObject("Chart with Filtering, Grouping, and Ordering.msg", ".msg",title );
			String[] dataSourceNames = DataStorage.emailDataSourceName(".msg", title);
			DocumentAssembler assembler = new DocumentAssembler();
			assembler.assembleDocument(CommonUtilities.getDataPath(srcDocument),
					CommonUtilities.getOutPath(docReport), getDataSourceDetails,
					dataSourceNames);
		}catch ( Exception exp){
			System.out.println("Exception: " + exp.getMessage());
		}

		// ExEnd:dynamicChartAxisTitleEmail
	}
}
