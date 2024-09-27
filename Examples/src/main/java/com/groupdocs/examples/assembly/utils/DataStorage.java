package com.groupdocs.examples.assembly.utils;

import com.groupdocs.assembly.DocumentTable;
import com.groupdocs.assembly.DocumentTableOptions;
import com.groupdocs.examples.assembly.utils.businessentities.Client;
import com.groupdocs.examples.assembly.utils.businessentities.Contract;
import com.groupdocs.examples.assembly.utils.businessentities.Manager;
import com.groupdocs.examples.assembly.utils.businessentities.Service;

import java.nio.file.Path;
import java.util.*;

public class DataStorage {
    private final List<Manager> mManagers;

    //ExStart:DataStorage
    public DataStorage() {
        mManagers = createManagers();
    }

    private static List<Manager> createManagers() {
        return Arrays.asList(
                createManager("John Smith", 37, "red",
                        new String[]{"A Company", "B Ltd.", "C & D"}, new float[]{1200000, 750000, 350000},
                        new Date[]{getDate(2015, 1, 1), getDate(2015, 4, 1), getDate(2015, 7, 1)},
                        new String[]{"Regular Cleaning", "Oven Cleaning"}),

                createManager("Tony Anderson", 38, "green",
                        new String[]{"E Corp.", "F & Partners"}, new float[]{650000, 550000},
                        new Date[]{getDate(2015, 2, 1), getDate(2015, 8, 1)},
                        new String[]{"Regular Cleaning", "Oven Cleaning", "Carpet Cleaning"}),

                createManager("July James", 39, "blue",
                        new String[]{"G & Co.", "H Group", "I & Sons", "J Ent."}, new float[]{350000, 250000, 100000, 100000},
                        new Date[]{getDate(2016, 2, 2), getDate(2015, 5, 1), getDate(2017, 7, 3), getDate(2015, 8, 1)},
                        new String[]{"Regular Cleaning", "Carpet Cleaning"}));
    }

    private static Manager createManager(String name, int age, String color, String[] clientNames, float[] contractPrices, Date[] contractDates, String[] services) {
        List<Contract> contracts = new ArrayList<>();
        List<Service> mServices = new ArrayList<>();
        Manager manager = new Manager(name, age, color, contracts);

        for (String service : services) {
            mServices.add(new Service(service));
        }

        for (int i = 0; i < clientNames.length; i++) {
            contracts.add(new Contract(manager, new Client(clientNames[i]), contractPrices[i], contractDates[i], mServices));
        }

        return manager;
    }

    private static Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Month is 0-based
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    public static DocumentTable excelData() throws Exception {
        //ExStart:excelData
        Path dataFilePath = FilesUtils.makeFilesPath("DataSources/ExcelDataSource/Contracts_Data.xlsx");
        // Set extracting of column names from the first row.
        DocumentTableOptions options = new DocumentTableOptions();
        options.setFirstRowContainsColumnNames(true);

        // Use data of the _first_ worksheet.
        DocumentTable table = new DocumentTable(dataFilePath.toString(), 0, options);

        // Check column count, names, and types.
        assert table.getColumns().getCount() == 3;

        assert table.getColumns().get(0).getName().equals("Client");
        assert Objects.equals(table.getColumns().get(0).getType(), String.class);

        assert table.getColumns().get(1).getName().equals("Manager");
        assert Objects.equals(table.getColumns().get(1).getType(), String.class);

        // NOTE: A space is replaced with an underscore, because spaces are not allowed in column names.
        assert table.getColumns().get(2).getName().equals("Contract_Price");

        // NOTE: The type of the column is double, because all cells in the column contain numeric values.
        assert Objects.equals(table.getColumns().get(2).getType(), double.class);
        return table;
        //ExEnd:excelData
    }

    //Importing word processing table into presentation
    public static DocumentTable importingWordProcessingTableIntoPresentation() throws Exception {
        //ExStart:ImportingWordProcessingTableIntoPresentation
        Path dataFilePath = FilesUtils.makeFilesPath("DataSources/WordDataSource/Managers_Data.docx");

        // Do not extract column names from the first row, so that the first row to be treated as a data row.
        // Limit the largest row index, so that only the first four data rows to be loaded.
        DocumentTableOptions options = new DocumentTableOptions();
        options.setMaxRowIndex(3);

        // Use data of the _second_ table in the document.
        DocumentTable table = new DocumentTable(dataFilePath.toString(), 1, options);

        // Check column count and names.
        assert table.getColumns().getCount() == 2;

        // NOTE: Default column names are used, because we do not extract the names from the first row.
        assert table.getColumns().get(0).getName().equals("Column1");
        assert table.getColumns().get(1).getName().equals("Column2");
        return table;
        //ExEnd:ImportingWordProcessingTableIntoPresentation
    }

    //Generate report from presentation data source
    public static DocumentTable presentationData() throws Exception {
        //ExStart:presentationData
        Path dataFilePath = FilesUtils.makeFilesPath("DataSources/PresentationDataSource/ManagersData.pptx");

        // Do not extract column names from the first row, so that the first row to be treated as a data row.
        // Limit the largest row index, so that only the first four data rows to be loaded.
        DocumentTableOptions options = new DocumentTableOptions();
        options.setMaxRowIndex(3);

        // Use data of the _second_ table in the document.
        DocumentTable table = new DocumentTable(dataFilePath.toString(), 1, options);

        // Check column count and names.
        assert table.getColumns().getCount() == 2;

        // NOTE: Default column names are used, because we do not extract the names from the first row.
        assert table.getColumns().get(0).getName().equals("Column1");
        assert table.getColumns().get(1).getName().equals("Column2");
        return table;
        //ExEnd:presentationData
    }

    public static EmailDataSourcesObjects emailDataSourceObject(String srcDocument, String documentFormat) {
        EmailDataSourcesObjects dataSources = new EmailDataSourcesObjects();
        if (Objects.equals(documentFormat, ".eml") || Objects.equals(documentFormat, ".msg")) {
            ArrayList<String> recipients = new ArrayList<>();
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

    public static EmailDataSourcesObjects emailDataSourceObject(String srcDocument, String documentFormat, String title) {
        EmailDataSourcesObjects dataSources = new EmailDataSourcesObjects();
        if (Objects.equals(documentFormat, ".eml") || Objects.equals(documentFormat, ".msg")) {
            ArrayList<String> recipients = new ArrayList<>();
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

    public static EmailDataSourcesNames emailDataSourceName(String documentFormat) {
        EmailDataSourcesNames dataSourceNames = new EmailDataSourcesNames();
        if (Objects.equals(documentFormat, ".eml") || Objects.equals(documentFormat, ".msg")) {
            dataSourceNames.setDataSource(null);
            dataSourceNames.setSender("sender");
            dataSourceNames.setRecipients("recipients");
            dataSourceNames.setCC("cc");
            dataSourceNames.setSubject("subject");
            dataSourceNames.setManager("manager");
            return dataSourceNames;
        } else {
            return dataSourceNames;
        }
    }

    public static EmailDataSourcesNames emailDataSourceName(String documentFormat, String title) {
        EmailDataSourcesNames dataSourceNames = new EmailDataSourcesNames();
        if (Objects.equals(documentFormat, ".eml") || Objects.equals(documentFormat, ".msg")) {
            dataSourceNames.setDataSource(null);
            dataSourceNames.setSender("sender");
            dataSourceNames.setRecipients("recipients");
            dataSourceNames.setCC("cc");
            dataSourceNames.setSubject("subject");
            dataSourceNames.setManager("manager");
            dataSourceNames.setTitle(title);
            return dataSourceNames;
        } else {
            return dataSourceNames;
        }
    }

    public Iterable<Manager> getManagers() {
        return mManagers;
    }

    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();

        for (Manager manager : mManagers) {
            for (Contract contract : manager.getContracts()) {
                clients.add(contract.getClient());
            }
        }

        return clients;
    }

    public List<Contract> getContracts() {
        List<Contract> contracts = new ArrayList<>();

        for (Manager manager : mManagers) {
            for (Contract contract : manager.getContracts()) {
                contracts.add(contract);
            }
        }

        return contracts;
    }

    public static class EmailDataSourcesObjects {
        public DataStorage dataSource;
        public String sender;
        public ArrayList<String> recipients;
        public String CC;
        public String subject;
        public Manager manager;
        public String title;

        public EmailDataSourcesObjects() {
        }

        public DataStorage getDataSource() {
            return this.dataSource;
        }

        public void setDataSource(DataStorage dataSource) {
            this.dataSource = dataSource;
        }

        public String getSender() {
            return this.sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        public ArrayList<String> getRecipients() {
            return this.recipients;
        }

        public void setRecipients(ArrayList<String> recipients) {
            this.recipients = recipients;
        }

        public String getCC() {
            return this.CC;
        }

        public void setCC(String CC) {
            this.CC = CC;
        }

        public String getSubject() {
            return this.subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public Manager getManager() {
            return this.manager;
        }

        public void setManager(Manager manager) {
            this.manager = manager;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class EmailDataSourcesNames {
        public String dataSource;
        public String sender;
        public String recipients;
        public String CC;
        public String subject;
        public String manager;
        public String title;

        public EmailDataSourcesNames() {
        }

        public String getDataSource() {
            return this.dataSource;
        }

        public void setDataSource(String dataSource) {
            this.dataSource = dataSource;
        }

        public String getSender() {
            return this.sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        public String getRecipients() {
            return this.recipients;
        }

        public void setRecipients(String recipients) {
            this.recipients = recipients;
        }

        public String getCC() {
            return this.CC;
        }

        public void setCC(String CC) {
            this.CC = CC;
        }

        public String getSubject() {
            return this.subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getManager() {
            return this.manager;
        }

        public void setManager(String manager) {
            this.manager = manager;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }
    //ExEnd:DataStorage
}