package com.azhar.scannerrestapi;

import com.azhar.scannerrestapi.models.Bug;

import java.util.ArrayList;

public class Report {

    private final long id;
    private final String content;
    private String message;
    private ArrayList<Bug> bugList;
    private String lineOfCode;
    private String bugType;


    public Report(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public ArrayList<Bug> getBugList() {
        return bugList;
    }

    public void setBugList(ArrayList<Bug> bugList) {
        this.bugList = bugList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLineOfCode() {
        return lineOfCode;
    }

    public void setLineOfCode(String lineOfCode) {
        this.lineOfCode = lineOfCode;
    }

    public String getBugType() {
        return bugType;
    }

    public void setBugType(String bugType) {
        this.bugType = bugType;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
