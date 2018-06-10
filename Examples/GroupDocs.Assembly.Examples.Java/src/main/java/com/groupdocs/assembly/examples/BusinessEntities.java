package com.groupdocs.assembly.examples;

import java.util.Date;

public class BusinessEntities {
	//ExStart:BusinessEntities
	public static class Manager {
		public Manager(String name, int age, String color,Iterable<Contract> contracts) {
			mName = name;
			mAge = age;
			mColor = color;
			mContracts = contracts;

		}

		public String getName() {
			return mName;
		}

		public int getAge() {
			return mAge;
		}

		public String getColor() {
			return mColor;
		}

		public String getPhoto() throws Exception {
			return CommonUtilities.image + "/no-photo.jpg";
		}
		public String getOuterDoc() throws Exception{
			return CommonUtilities.outerDoc + "/OuterDoc.docx";
		}

		public Iterable<Contract> getContracts() {
			return mContracts;
		}

		private final String mName;
		private final int mAge;
		private final Iterable<Contract> mContracts;
		private final String mColor;
	}

	public static class Contract {
		public Contract(Manager manager, Client client, float price, Date date) {
			mManager = manager;
			mClient = client;
			mPrice = price;
			mDate = date;
		}

		public Manager getManager() {
			return mManager;
		}

		public Client getClient() {
			return mClient;
		}

		public float getPrice() {
			return mPrice;
		}

		public Date getDate() {
			return mDate;
		}

		private final Manager mManager;
		private final Client mClient;
		private final float mPrice;
		private final Date mDate;
	}

	public static class Client {
		public Client(String name) {
			mName = name;
		}

		public String getName() {
			return mName;
		}

		private final String mName;
	}
	//ExEnd:BusinessEntities
}
