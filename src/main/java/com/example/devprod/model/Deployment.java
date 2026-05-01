package com.example.devprod.model;

import java.util.Date;

public class Deployment {
    private String prId;
    private Date deployedAt;

    public Deployment(String prId, Date deployedAt) {
        this.prId = prId;
        this.deployedAt = deployedAt;
    }

    public String getPrId() { return prId; }
    public Date getDeployedAt() { return deployedAt; }
}
