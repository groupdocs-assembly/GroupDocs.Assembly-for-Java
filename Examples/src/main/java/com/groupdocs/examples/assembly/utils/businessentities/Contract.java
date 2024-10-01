package com.groupdocs.examples.assembly.utils.businessentities;

import java.util.Date;

public class Contract {
    private final Manager mManager;
    private final Client mClient;
    private final float mPrice;
    private final Date mDate;
    private final Iterable<Service> mServices;

    public Contract(Manager manager, Client client, float price, Date date) {
        mManager = manager;
        mClient = client;
        mPrice = price;
        mDate = date;
        mServices = null;
    }

    public Contract(Manager manager, Client client, float price, Date date, Iterable<Service> services) {
        mManager = manager;
        mClient = client;
        mPrice = price;
        mDate = date;
        mServices = services;
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

    public Iterable<Service> getServices() {
        return mServices;
    }
}
