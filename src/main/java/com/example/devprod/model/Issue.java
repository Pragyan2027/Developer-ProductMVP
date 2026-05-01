package com.example.devprod.model;

import java.util.Date;

public class Issue {
    private String status;
    private Date inProgressAt;
    private Date doneAt;

    public Issue(String status, Date inProgressAt, Date doneAt) {
        this.status = status;
        this.inProgressAt = inProgressAt;
        this.doneAt = doneAt;
    }

    public String getStatus() { return status; }
    public Date getInProgressAt() { return inProgressAt; }
    public Date getDoneAt() { return doneAt; }
}
