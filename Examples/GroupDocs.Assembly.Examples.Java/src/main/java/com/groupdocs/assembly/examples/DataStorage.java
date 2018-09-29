package com.groupdocs.assembly.examples;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.groupdocs.assembly.DocumentTable;
import com.groupdocs.assembly.DocumentTableOptions;
import com.groupdocs.assembly.examples.BusinessEntities.Client;
import com.groupdocs.assembly.examples.BusinessEntities.Contract;
import com.groupdocs.assembly.examples.BusinessEntities.Manager;

public class DataStorage {
	//ExStart:DataStorage
	public DataStorage() {
		mManagers = createManagers();
	}

	private static List<Manager> createManagers() {
		return Arrays.asList(
				createManager("John Smith", 37,"red", new String[] { "A Company", "B Ltd.", "C & D" },
						new float[] { 1200000, 750000, 350000 },
						new Date[] { getDate(2015, 1, 1), getDate(2015, 4, 1), getDate(2015, 7, 1) }),
				createManager("Tony Anderson", 37,"green", new String[] { "E Corp.", "F & Partners" },
						new float[] { 650000, 550000 }, new Date[] { getDate(2015, 2, 1), getDate(2015, 8, 1) }),
				createManager("July James", 37,"blue", new String[] { "G & Co.", "H Group", "I & Sons", "J Ent." },
						new float[] { 350000, 250000, 100000, 100000 }, new Date[] { getDate(2015, 2, 1),
								getDate(2015, 5, 1), getDate(2015, 7, 1), getDate(2015, 8, 1) }));
	}

	private static Manager createManager(String name, int age,String color, String[] clientNames, float[] contractPrices,
			Date[] contractDates) {
		List<Contract> contracts = new ArrayList();
		Manager manager = new Manager(name, age,color, contracts);

		for (int i = 0; i < clientNames.length; i++)
			contracts.add(new Contract(manager, new Client(clientNames[i]), contractPrices[i], contractDates[i]));

		return manager;
	}

	private static Date getDate(int year, int month, int day) {
		return new Date(year - 1900, month - 1, day);
	}

	public Iterable<Manager> getManagers() {
		return mManagers;
	}

	public List<Client> getClients() {
		List<Client> clients = new ArrayList();

		for (Manager manager : mManagers) {
			for (Contract contract : manager.getContracts())
				clients.add(contract.getClient());
		}

		return clients;
	}

	public List<Contract> getContracts() {
		List<Contract> contracts = new ArrayList();

		for (Manager manager : mManagers) {
			for (Contract contract : manager.getContracts())
				contracts.add(contract);
		}

		return contracts;
	}

	private final List<Manager> mManagers;
	
	public static DocumentTable excelData() throws Throwable{
		//ExStart:excelData
		String dataFilePath = CommonUtilities.excelDataFile+"/Contracts Data.xlsx";
		// Set extracting of column names from the first row.
		DocumentTableOptions options = new DocumentTableOptions();
		options.setFirstRowContainsColumnNames(true);
		 
		// Use data of the _first_ worksheet.
		DocumentTable table = new DocumentTable(dataFilePath, 0, options);
		 
		// Check column count, names, and types.
		assert table.getColumns().getCount() == 3;
		 
		assert table.getColumns().get(0).getName().equals("Client");
		assert table.getColumns().get(0).getType() == String.class;
		 
		assert table.getColumns().get(1).getName().equals("Manager");
		assert table.getColumns().get(1).getType() == String.class;
		 
		// NOTE: A space is replaced with an underscore, because spaces are not allowed in column names.
		assert table.getColumns().get(2).getName().equals("Contract_Price");
		 
		// NOTE: The type of the column is double, because all cells in the column contain numeric values.
		assert table.getColumns().get(2).getType() == double.class;
		return table;
		//ExEnd:excelData
	}
	//Importing word processing table into presentation
	public static DocumentTable importingWordProcessingTableIntoPresentation() throws Throwable{
		//ExStart:ImportingWordProcessingTableIntoPresentation
		String dataFilePath = CommonUtilities.wordDataFile+"/Managers Data.docx";
		 
		// Do not extract column names from the first row, so that the first row to be treated as a data row.
		// Limit the largest row index, so that only the first four data rows to be loaded.
		DocumentTableOptions options = new DocumentTableOptions();
		options.setMaxRowIndex(3);
		 
		// Use data of the _second_ table in the document.
		DocumentTable table = new DocumentTable(dataFilePath, 1, options);
		 
		// Check column count and names.
		assert table.getColumns().getCount() == 2;
		 
		// NOTE: Default column names are used, because we do not extract the names from the first row.
		assert table.getColumns().get(0).getName().equals("Column1");
		assert table.getColumns().get(1).getName().equals("Column2");
		 return table;
		 //ExEnd:ImportingWordProcessingTableIntoPresentation
	}
	//Generate report from presentation data source
	public static DocumentTable presentationData() throws Throwable{
		//ExStart:presentationData
		String dataFilePath = CommonUtilities.presentationDataFile+"/Managers Data.pptx";
		 
		// Do not extract column names from the first row, so that the first row to be treated as a data row.
		// Limit the largest row index, so that only the first four data rows to be loaded.
		DocumentTableOptions options = new DocumentTableOptions();
		options.setMaxRowIndex(3);
		 
		// Use data of the _second_ table in the document.
		DocumentTable table = new DocumentTable(dataFilePath, 1, options);
		 
		// Check column count and names.
		assert table.getColumns().getCount() == 2;
		 
		// NOTE: Default column names are used, because we do not extract the names from the first row.
		assert table.getColumns().get(0).getName().equals("Column1");
		assert table.getColumns().get(1).getName().equals("Column2");
		 return table;
		//ExEnd:presentationData
	}
	
	public static EmailDataSourcesObjects emailDataSourceObject(String srcDocument, String documentFormat){
		EmailDataSourcesObjects dataSources = new EmailDataSourcesObjects();
		if (documentFormat == ".eml" || documentFormat == ".msg") {
			ArrayList<String> recipients = new ArrayList();
			recipients.add("Named Recipient <named@example.com>");
			recipients.add("unnamed@example.com");
			
			final int extensionLength = 4;
			String subject = srcDocument.substring(0, srcDocument.length() - extensionLength);
			Manager manager = new DataStorage().getManagers().iterator().next();
			dataSources.setDataSource(new DataStorage());
			dataSources.setSender("Example Sender <sender@example.com>");
			dataSources.setRecipients(recipients);
			dataSources.setCC("cc@example.com");
			dataSources.setSubject(subject);
			dataSources.setManager(manager);	
			return dataSources;
		} else {
			dataSources.setDataSource(new DataStorage());
			return dataSources;
		}
	}
	public static EmailDataSourcesObjects emailDataSourceObject(String srcDocument, String documentFormat, String title){
		EmailDataSourcesObjects dataSources = new EmailDataSourcesObjects();
		if (documentFormat == ".eml" || documentFormat == ".msg") {
			ArrayList<String> recipients = new ArrayList();
			recipients.add("Named Recipient <named@example.com>");
			recipients.add("unnamed@example.com");
			
			final int extensionLength = 4;
			String subject = srcDocument.substring(0, srcDocument.length() - extensionLength);
			Manager manager = new DataStorage().getManagers().iterator().next();
			dataSources.setDataSource(new DataStorage());
			dataSources.setSender("Example Sender <sender@example.com>");
			dataSources.setRecipients(recipients);
			dataSources.setCC("cc@example.com");
			dataSources.setSubject(subject);
			dataSources.setManager(manager);
			dataSources.setTitle(title);		
			return dataSources;
		} else {
			dataSources.setDataSource(new DataStorage());
			return dataSources;
		}
	}
	public static EmailDataSourcesNames emailDataSourceName(String documentFormat){
		EmailDataSourcesNames dataSourceNames = new EmailDataSourcesNames();
		if (documentFormat == ".eml" || documentFormat == ".msg") {
			dataSourceNames.setDataSource(null);
			dataSourceNames.setSender("sender");
			dataSourceNames.setRecipients("recipients");
			dataSourceNames.setCC("cc");
			dataSourceNames.setSubject("subject");
			dataSourceNames.setManager("manager");
			return dataSourceNames;
		}else {
			return dataSourceNames;
		}
	}
	public static EmailDataSourcesNames emailDataSourceName(String documentFormat, String title){
		EmailDataSourcesNames dataSourceNames = new EmailDataSourcesNames();
		if (documentFormat == ".eml" || documentFormat == ".msg") {
			dataSourceNames.setDataSource(null);
			dataSourceNames.setSender("sender");
			dataSourceNames.setRecipients("recipients");
			dataSourceNames.setCC("cc");
			dataSourceNames.setSubject("subject");
			dataSourceNames.setManager("manager");
			dataSourceNames.setTitle(title);
			return dataSourceNames;
		}else {
			return dataSourceNames;
		}
	}
	public static class EmailDataSourcesObjects
	{
		public DataStorage dataSource; 
		public String sender; 
		public ArrayList<String> recipients;
		public String CC;
		public String subject;
		public Manager manager;
		public String title;
	
		public EmailDataSourcesObjects() {
		}
		

		public void setDataSource(DataStorage dataSource) {
			this.dataSource = dataSource;
		}
		public void setSender(String sender){
			this.sender = sender;
		}
		public void setRecipients(ArrayList<String> recipients){
			this.recipients = recipients;
		}
		public void setCC(String CC){
			this.CC = CC;
		}
		public void setSubject(String subject){
			this.subject = subject;
		}
		public void setManager(Manager manager){
			this.manager = manager;
		}
		public void setTitle(String title){
			this.title = title;
		}

		public DataStorage getDataSource() {
			return this.dataSource;
		}
		public String getSender(){
			return this.sender;
		}
		public ArrayList<String> getRecipients(){
			return this.recipients;
		}
		public String getCC(){
			return this.CC;
		}
		public String getSubject(){
			return this.subject;
		}
		public Manager getManager(){
			return this.manager;
		}
		public String getTitle(){
			return this.title;
		}
	}
	public static class EmailDataSourcesNames
	{
		public String dataSource; 
		public String sender; 
		public String recipients;
		public String CC;
		public String subject;
		public String manager;
		public String title;
		public EmailDataSourcesNames() {
		}
		public void setDataSource(String dataSource ) {
			this.dataSource = dataSource;
		}
		public void setSender(String sender){
			this.sender = sender;
		}
		public void setRecipients(String recipients){
			this.recipients = recipients;
		}
		public void setCC(String CC){
			this.CC = CC;
		}
		public void setSubject(String subject){
			this.subject = subject;
		}
		public void setManager(String manager){
			this.manager = manager;
		}
		public void setTitle(String title){
			this.title = title;
		}
		public String getDataSource(){
			return this.dataSource;
		}
		public String getSender(){
			return this.sender;
		}
		public String getRecipients(){
			return this.recipients;
		}
		public String getCC(){
			return this.CC;
		}
		public String getSubject(){
			return this.subject;
		}
		public String getManager(){
			return this.manager;
		}
		public String getTitle(){
			return this.title;
		}

	} 
	//ExEnd:DataStorage
}