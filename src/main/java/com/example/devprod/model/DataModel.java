package com.example.devprod.model;

import java.util.List;

public class DataModel {
    private List<PullRequest> pullRequests;
    private List<Deployment> deployments;
    private List<Issue> issues;
    private List<Bug> bugs;

    public List<PullRequest> getPullRequests() { return pullRequests; }
    public List<Deployment> getDeployments() { return deployments; }
    public List<Issue> getIssues() { return issues; }
    public List<Bug> getBugs() { return bugs; }

    public void setPullRequests(List<PullRequest> pullRequests) { this.pullRequests = pullRequests; }
    public void setDeployments(List<Deployment> deployments) { this.deployments = deployments; }
    public void setIssues(List<Issue> issues) { this.issues = issues; }
    public void setBugs(List<Bug> bugs) { this.bugs = bugs; }
}