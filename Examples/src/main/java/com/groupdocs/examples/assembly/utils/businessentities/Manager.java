package com.groupdocs.examples.assembly.utils.businessentities;

import com.groupdocs.examples.assembly.SampleFiles;

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
        return SampleFiles.NO_PHOTO_JPG.toString();
    }

    public String getOuterDoc() {
        return SampleFiles.OUTER_DOC_DOCX.toString();
    }

    public String getNestedOuterDoc() {
        return SampleFiles.NESTED_OUTER_DOCUMENT_DOCX.toString();
    }

    public Iterable<Contract> getContracts() {
        return mContracts;
    }
}
