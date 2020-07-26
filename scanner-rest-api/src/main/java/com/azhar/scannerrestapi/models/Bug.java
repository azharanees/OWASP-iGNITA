package com.azhar.scannerrestapi.models;

public class Bug {
    private String message;
    private String lineOfCode;
    private String bugType;

    public Bug(String message, String lineOfCode, String bugType) {
        this.message = message;
        this.lineOfCode = lineOfCode;
        this.bugType = bugType;
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
}
