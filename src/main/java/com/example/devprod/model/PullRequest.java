package com.example.devprod.model;

import java.util.Date;

public class PullRequest {
    private String id;
    private String status;
    private Date openedAt;

    public PullRequest(String id, String status, Date openedAt) {
        this.id = id;
        this.status = status;
        this.openedAt = openedAt;
    }

    public String getId() { return id; }
    public String getStatus() { return status; }
    public Date getOpenedAt() { return openedAt; }
}
