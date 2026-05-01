package com.example.devprod.controller;

import com.example.devprod.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/metrics")
@CrossOrigin(origins = "*")
public class MetricsController {
    @Autowired
    private MetricsService metricsService;

    @GetMapping
    public Map<String, Object> getMetrics() {
        return metricsService.getMetricsWithInsights();

    }
}
