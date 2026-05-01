package com.example.devprod.service;

import com.example.devprod.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.util.*;

@Service
public class MetricsService {

    public Map<String, Object> getMetricsWithInsights() {
        try {
            //  Load JSON
            ObjectMapper mapper = new ObjectMapper();
            mapper.findAndRegisterModules();

            InputStream input = getClass().getClassLoader()
                    .getResourceAsStream("sample.json");

            DataModel data = mapper.readValue(input, DataModel.class);

            List<PullRequest> prs = data.getPullRequests();
            List<Deployment> deployments = data.getDeployments();
            List<Issue> issues = data.getIssues();
            List<Bug> bugs = data.getBugs();

            //  Calculate Metrics
            double leadTime = calculateLeadTime(prs, deployments);
            double cycleTime = calculateCycleTime(issues);
            double bugRate = calculateBugRate(bugs, issues);

            int deploymentFrequency = deployments.size();
            int prThroughput = (int) prs.stream()
                    .filter(p -> p.getStatus().equals("merged"))
                    .count();

            //  Insights + Suggestions
            List<String> insights = new ArrayList<>();
            List<String> suggestions = new ArrayList<>();

//  Lead Time Insights
            if (leadTime > 4) {
                insights.add("High lead time indicates delays in getting code to production");
                suggestions.add("Break PRs into smaller chunks and improve review turnaround time");
            } else if (leadTime < 2) {
                insights.add("Lead time is very fast, indicating efficient delivery");
            }

//  Cycle Time Insights
            if (cycleTime > 3) {
                insights.add("Cycle time is high, suggesting tasks are taking longer in development");
                suggestions.add("Limit work-in-progress and reduce task complexity");
            } else if (cycleTime < 2) {
                insights.add("Cycle time is low, indicating efficient development flow");
            }

//  Bug Rate Insights
            if (bugRate > 0.3) {
                insights.add("Very high bug rate indicates serious quality issues in production");
                suggestions.add("Introduce stricter QA and automated testing before deployment");
            } else if (bugRate > 0.1) {
                insights.add("Moderate bug rate suggests some gaps in testing");
                suggestions.add("Improve test coverage and code reviews");
            } else {
                insights.add("Bug rate is low, indicating good code quality");
            }

//  Deployment Frequency Insights
            if (deploymentFrequency < 2) {
                insights.add("Low deployment frequency suggests slow release cycles");
                suggestions.add("Increase CI/CD automation and release frequency");
            } else if (deploymentFrequency > 5) {
                insights.add("High deployment frequency indicates active delivery pipeline");
            }

//  PR Throughput Insights
            if (prThroughput < 3) {
                insights.add("Low PR throughput indicates reduced development activity");
                suggestions.add("Encourage smaller and more frequent pull requests");
            } else if (prThroughput > 10) {
                insights.add("High PR throughput suggests strong development velocity");
            }

            // 🔹 Response
            Map<String, Object> response = new HashMap<>();
            response.put("leadTime", round(leadTime));
            response.put("cycleTime", round(cycleTime));
            response.put("bugRate", round(bugRate));
            response.put("deploymentFrequency", deploymentFrequency);
            response.put("prThroughput", prThroughput);
            response.put("insights", insights);
            response.put("suggestions", suggestions);

            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return Map.of("error", "Failed to load data");
        }
    }

    private double calculateLeadTime(List<PullRequest> prs, List<Deployment> deps) {
        double total = 0;
        int count = 0;

        for (PullRequest pr : prs) {
            if ("merged".equals(pr.getStatus())) {
                for (Deployment d : deps) {
                    if (d.getPrId().equals(pr.getId())) {
                        total += (d.getDeployedAt().getTime() - pr.getOpenedAt().getTime());
                        count++;
                    }
                }
            }
        }

        return count == 0 ? 0 : total / count / (1000 * 60 * 60 * 24);
    }

    private double calculateCycleTime(List<Issue> issues) {
        double total = 0;
        int count = 0;

        for (Issue i : issues) {
            if ("done".equals(i.getStatus())) {
                total += (i.getDoneAt().getTime() - i.getInProgressAt().getTime());
                count++;
            }
        }

        return count == 0 ? 0 : total / count / (1000 * 60 * 60 * 24);
    }

    private double calculateBugRate(List<Bug> bugs, List<Issue> issues) {
        long completed = issues.stream()
                .filter(i -> "done".equals(i.getStatus()))
                .count();

        return completed == 0 ? 0 : (double) bugs.size() / completed;
    }

    private double round(double val) {
        return Math.round(val * 100.0) / 100.0;
    }
}