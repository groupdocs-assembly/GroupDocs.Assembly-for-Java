package com.groupdocs.assembly.examples;

import java.io.File;

import com.groupdocs.assembly.DocumentAssembler;

import com.groupdocs.assembly.examples.BusinessEntities.Manager;

public class GenerateReport {
	// Generate bubble chart report
	public static void generateBubbleChart(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:bubblechartdocument
			String srcDocument = "/Word Templates/Bubble Chart.docx";
			String docReport = "/Word Reports/Bubble Chart_report.docx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:bubblechartdocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:bubblechartspreadsheet
			String srcDocument = "/Spreadsheet Templates/Bubble Chart.xlsx";
			String docReport = "/Spreadsheet Reports/Bubble Chart_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:bubblechartspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:bubblechartpresentation
			String srcDocument = "/Presentation Templates/Bubble Chart.pptx";
			String docReport = "/Presentation Reports/Bubble Chart_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:bubblechartpresentation
		}
	}

	// Generate bulleted list report
	public static void generateBulletedList(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:bulletedlistdocument
			String srcDocument = "/Word Templates/Bulleted List.docx";
			String docReport = "/Word Reports/Bulleted List_report.docx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:bulletedlistdocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:bulletedlistspreadsheet
			String srcDocument = "/Spreadsheet Templates/Bulleted List.xlsx";
			String docReport = "/Spreadsheet Reports/Bulleted List_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:bulletedlistspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:bulletedlistpresentation
			String srcDocument = "/Presentation Templates/Bulleted List.pptx";
			String docReport = "/Presentation Reports/Bulleted List_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:bulletedlistpresentation
		}
	}

	// Generate Chart With Filtering Grouping And Ordering
	public static void GenerateChartWithFilteringGroupingAndOrdering(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:chartwithfilteringgroupingandorderingdocument
			String srcDocument = "/Word Templates/Chart with Filtering, Grouping, and Ordering.docx";
			String docReport = "/Word Reports/Chart with Filtering, Grouping, and Ordering_report.docx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:chartwithfilteringgroupingandorderingdocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:chartwithfilteringgroupingandorderingspreadsheet
			String srcDocument = "/Spreadsheet Templates/Chart with Filtering, Grouping, and Ordering.xlsx";
			String docReport = "/Spreadsheet Reports/Chart with Filtering, Grouping, and Ordering_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:chartwithfilteringgroupingandorderingspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:chartwithfilteringgroupingandorderingpresentation
			String srcDocument = "/Presentation Templates/Chart with Filtering, Grouping, and Ordering.pptx";
			String docReport = "/Presentation Reports/Chart with Filtering, Grouping, and Ordering_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:chartwithfilteringgroupingandorderingpresentation
		}
	}

	// Generate Common List
	public static void GenerateCommonList(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:commonlistdocument
			String srcDocument = "/Word Templates/Common List.docx";
			String docReport = "/Word Reports/Common List_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:commonlistdocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:commonlistspreadsheet
			String srcDocument = "/Spreadsheet Templates/Common List.xlsx";
			String docReport = "/Spreadsheet Reports/Common List_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:commonlistspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:commonlistpresentation
			String srcDocument = "/Presentation Templates/Common List.pptx";
			String docReport = "/Presentation Reports/Common List_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:commonlistpresentation
		}
	}

	// Generate Common Master Detail
	public static void GenerateCommonMasterDetail(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:commonmasterdetaildocument
			String srcDocument = "/Word Templates/Common Master-Detail.docx";
			String docReport = "/Word Reports/Common Master-Detail_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:commonmasterdetaildocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:commonmasterdetailspreadsheet
			String srcDocument = "/Spreadsheet Templates/Common Master-Detail.xlsx";
			String docReport = "/Spreadsheet Reports/Common Master-Detail_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:commonmasterdetailspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:commonmasterdetailpresentation
			String srcDocument = "/Presentation Templates/Common Master-Detail.pptx";
			String docReport = "/Presentation Reports/Common Master-Detail_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:commonmasterdetailpresentation
		}
	}

	// Generate In-Paragraph list report
	public static void GenerateInParagraphList(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:inparagraphlistdocument
			String srcDocument = "/Word Templates/In-Paragraph List.docx";
			String docReport = "/Word Reports/In-Paragraph List_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:inparagraphlistdocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:inparagraphlistspreadsheet
			String srcDocument = "/Spreadsheet Templates/In-Paragraph List.xlsx";
			String docReport = "/Spreadsheet Reports/In-Paragraph List_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:inparagraphlistspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:inparagraphlistpresentation
			String srcDocument = "/Presentation Templates/In-Paragraph List.pptx";
			String docReport = "/Presentation Reports/In-Paragraph List_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:inparagraphlistpresentation
		}
	}

	// Generate Generate In Table List With Alternate Content
	public static void GenerateInTableListWithAlternateContent(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:intablelistwithalternatecontentdocument
			String srcDocument = "/Word Templates/In-Table List with Alternate Content.docx";
			String docReport = "/Word Reports/In-Table List with Alternate Content_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:intablelistwithalternatecontentdocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:intablelistwithalternatecontentspreadsheet
			String srcDocument = "/Spreadsheet Templates/In-Table List with Alternate Content.xlsx";
			String docReport = "/Spreadsheet Reports/In-Table List with Alternate Content_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:intablelistwithalternatecontentspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:intablelistwithalternatecontentpresentation
			String srcDocument = "/Presentation Templates/In-Table List with Alternate Content.pptx";
			String docReport = "/Presentation Reports/In-Table List with Alternate Content_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:intablelistwithalternatecontentpresentation
		}
	}

	// Generate In Table List With Filtering Grouping And Ordering
	public static void GenerateInTableListWithFilteringGroupingAndOrdering(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:intablelistwithfilteringroupingandorderingdocument
			String srcDocument = "/Word Templates/In-Table List with Filtering, Grouping, and Ordering.docx";
			String docReport = "/Word Reports/In-Table List with Filtering, Grouping, and Ordering_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:intablelistwithfilteringroupingandorderingdocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:intablelistwithfilteringroupingandorderingspreadsheet
			String srcDocument = "/Spreadsheet Templates/In-Table List with Filtering, Grouping, and Ordering.xlsx";
			String docReport = "/Spreadsheet Reports/In-Table List with Filtering, Grouping, and Ordering_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:intablelistwithfilteringroupingandorderingspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:intablelistwithfilteringroupingandorderingpresentation
			String srcDocument = "/Presentation Templates/In-Table List with Filtering, Grouping, and Ordering.pptx";
			String docReport = "/Presentation Reports/In-Table List with Filtering, Grouping, and Ordering_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:intablelistwithfilteringroupingandorderingpresentation
		}
	}

	// Generate in table list with highlighted rows
	public static void GenerateInTableListWithHighlightedRows(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:intablelistwithhighllightedrowsdocument
			String srcDocument = "/Word Templates/In-Table List with Highlighted Rows.docx";
			String docReport = "/Word Reports/In-Table List with Highlighted Rows_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:intablelistwithhighllightedrowsdocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:intablelistwithhighllightedrowsspreadsheet
			String srcDocument = "/Spreadsheet Templates/In-Table List with Highlighted Rows.xlsx";
			String docReport = "/Spreadsheet Reports/In-Table List with Highlighted Rows_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:intablelistwithhighllightedrowsspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:intablelistwithhighllightedrowspresentation
			String srcDocument = "/Presentation Templates/In-Table List with Highlighted Rows.pptx";
			String docReport = "/Presentation Reports/In-Table List with Highlighted Rows_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:intablelistwithhighllightedrowspresentation
		}
	}

	// Generate in table list
	public static void GenerateInTableList(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:intablelistdocument
			String srcDocument = "/Word Templates/In-Table List.docx";
			String docReport = "/Word Reports/In-Table List_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:intablelistdocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:intablelistspreadsheet
			String srcDocument = "/Spreadsheet Templates/In-Table List.xlsx";
			String docReport = "/Spreadsheet Reports/In-Table List_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:intablelistspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:intablelistpresentation
			String srcDocument = "/Presentation Templates/In-Table List.pptx";
			String docReport = "/Presentation Reports/In-Table List_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
		}
		//ExEnd:intablelistpresentation
	}

	// Generate in table master detail
	public static void GenerateInTableMasterDetail(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:intablemasterdetaildocument
			String srcDocument = "/Word Templates/In-Table Master-Detail.docx";
			String docReport = "/Word Reports/In-Table Master-Detail_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:intablemasterdetaildocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:intablemasterdetailspreadsheet
			String srcDocument = "/Spreadsheet Templates/In-Table Master-Detail.xlsx";
			String docReport = "/Spreadsheet Reports/In-Table Master-Detail_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:intablemasterdetailspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:intablemasterdetailpresentation
			String srcDocument = "/Presentation Templates/In-Table Master-Detail.pptx";
			String docReport = "/Presentation Reports/In-Table Master-Detail_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:intablemasterdetailpresentation
		}
	}

	// Generate multicolored numbered list
	public static void GenerateMulticoloredNumberedList(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:multicolorednumberedlistdocument
			String srcDocument = "/Word Templates/Multicolored Numbered List.docx";
			String docReport = "/Word Reports/Multicolored Numbered List_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:multicolorednumberedlistdocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:multicolorednumberedlistspreadsheet
			String srcDocument = "/Spreadsheet Templates/Multicolored Numbered List.xlsx";
			String docReport = "/Spreadsheet Reports/Multicolored Numbered List_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:multicolorednumberedlistspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:multicolorednumberedlistpresentation
			String srcDocument = "/Presentation Templates/Multicolored Numbered List.pptx";
			String docReport = "/Presentation Reports/Multicolored Numbered List_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:multicolorednumberedlistpresentation
		}
	}

	// Generate Numbered list report
	public static void GenerateNumberedList(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:numberedlistdocument
			String srcDocument = "/Word Templates/Numbered List.docx";
			String docReport = "/Word Reports/Numbered List_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:numberedlistdocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:numberedlistspreadsheet
			String srcDocument = "/Spreadsheet Templates/Numbered List.xlsx";
			String docReport = "/Spreadsheet Reports/Numbered List_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:numberedlistspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:numberedlistpresentation
			String srcDocument = "/Presentation Templates/Numbered List.pptx";
			String docReport = "/Presentation Reports/Numbered List_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:numberedlistpresentation
		}
	}

	// Generate pie chart
	public static void GeneratePieChart(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:piechartdocument
			String srcDocument = "/Word Templates/Pie Chart.docx";
			String docReport = "/Word Reports/Pie Chart_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:piechartdocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:piechartspreadsheet
			String srcDocument = "/Spreadsheet Templates/Pie Chart.xlsx";
			String docReport = "/Spreadsheet Reports/Pie Chart_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:piechartspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:piechartpresentation
			String srcDocument = "/Presentation Templates/Pie Chart.pptx";
			String docReport = "/Presentation Reports/Pie Chart_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:piechartpresentation
		}
	}

	// Generate scatter chart
	public static void GenerateScatterChart(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:scatterchartdocument
			String srcDocument = "/Word Templates/Scatter Chart.docx";
			String docReport = "/Word Reports/Scatter Chart_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:scatterchartdocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:scatterchartspreadsheet
			String srcDocument = "/Spreadsheet Templates/Scatter Chart.xlsx";
			String docReport = "/Spreadsheet Reports/Scatter Chart_report.xlsx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:scatterchartspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:scatterchartpresentation
			String srcDocument = "/Presentation Templates/Scatter Chart.pptx";
			String docReport = "/Presentation Reports/Scatter Chart_report.pptx";
			try {
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), new DataStorage(), null);
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:scatterchartpresentation
		}
	}

	// Generate single row
	public static void GenerateSingleRow(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:singlerowdocument
			String srcDocument = "/Word Templates/Single Row.docx";
			String docReport = "/Word Reports/Single Row_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), manager, "manager");
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:singlerowdocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:singlerowspreadsheet
			String srcDocument = "/Spreadsheet Templates/Single Row.xlsx";
			String docReport = "/Spreadsheet Reports/Single Row_report.xlsx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), manager, "manager");
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:singlerowspreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:singlerowpresentation
			String srcDocument = "/Presentation Templates/Single Row.pptx";
			String docReport = "/Presentation Reports/Single Row_report.pptx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), manager, "manager");
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:singlerowpresentation
		}
	}

	// Generate barcode
	public static void AddBarCodes(String documentFormat) {
		if (documentFormat == "document") {
			//ExStart:barcodedocument
			String srcDocument = "/Word Templates/Barcode.docx";
			String docReport = "/Word Reports/Barcode_report.docx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), "854283", "value");
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:barcodedocument
		} else if (documentFormat == "spreadsheet") {
			//ExStart:barcodespreadsheet
			String srcDocument = "/Spreadsheet Templates/Barcode.xlsx";
			String docReport = "/Spreadsheet Reports/Barcode.xlsx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), "854283", "value");
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:barcodespreadsheet
		} else if (documentFormat == "presentation") {
			//ExStart:barcodepresentation
			String srcDocument = "/Presentation Templates/Barcode.pptx";
			String docReport = "/Presentation Reports/Barcode_report.pptx";
			try {
				Manager manager = new DataStorage().getManagers().iterator().next();
				DocumentAssembler assembler = new DocumentAssembler();
				assembler.assembleDocument(CommonUtilities.getTestDataPath(srcDocument),
						CommonUtilities.getTestOutPath(docReport), "854283", "value");
			} catch (Exception exp) {
				System.out.println("Exception: " + exp.getMessage());
			}
			//ExEnd:barcodepresentation
		}
	}
}
