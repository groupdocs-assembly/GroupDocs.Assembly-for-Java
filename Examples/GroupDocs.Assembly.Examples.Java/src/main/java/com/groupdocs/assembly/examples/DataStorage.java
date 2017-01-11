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
				createManager("John Smith", 37, new String[] { "A Company", "B Ltd.", "C & D" },
						new float[] { 1200000, 750000, 350000 },
						new Date[] { getDate(2015, 1, 1), getDate(2015, 4, 1), getDate(2015, 7, 1) }),
				createManager("Tony Anderson", 37, new String[] { "E Corp.", "F & Partners" },
						new float[] { 650000, 550000 }, new Date[] { getDate(2015, 2, 1), getDate(2015, 8, 1) }),
				createManager("July James", 37, new String[] { "G & Co.", "H Group", "I & Sons", "J Ent." },
						new float[] { 350000, 250000, 100000, 100000 }, new Date[] { getDate(2015, 2, 1),
								getDate(2015, 5, 1), getDate(2015, 7, 1), getDate(2015, 8, 1) }));
	}

	private static Manager createManager(String name, int age, String[] clientNames, float[] contractPrices,
			Date[] contractDates) {
		List<Contract> contracts = new ArrayList();
		Manager manager = new Manager(name, age, contracts);

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
	//ExEnd:DataStorage
}