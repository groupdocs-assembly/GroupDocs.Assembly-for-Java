package com.groupdocs.examples.assembly.utils.businessentities;

import com.groupdocs.examples.assembly.utils.FilesUtils;

//ExStart:BusinessEntities
public class Manager {
    private final String mName;
    private final int mAge;
    private final Iterable<Contract> mContracts;
    private final String mColor;

    public Manager(String name, int age, String color, Iterable<Contract> contracts) {
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

    public String getPhoto() {
        return FilesUtils.makeFilesPath("BusinessEntities/no-photo.jpg").toString();
    }

    public String getOuterDoc() {
        return FilesUtils.makeFilesPath("BusinessEntities/OuterDoc.docx").toString();
    }

    public String getNestedOuterDoc() {
        return FilesUtils.makeFilesPath("BusinessEntities/NestedOuterDocument.docx").toString();
    }

    public Iterable<Contract> getContracts() {
        return mContracts;
    }
}
