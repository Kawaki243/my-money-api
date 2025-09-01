package com.project.moneymanagerbackend.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PingService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String pingUrl = "https://my-money-api-quao.onrender.com/api/v1.0/status";
    // or another endpoint in your app

    // Run every 15 minutes (fixedRate = 15 * 60 * 1000 ms)
    @Scheduled(fixedRate = 15 * 60 * 1000)
    public void pingSelf() {
        try {
            String response = restTemplate.getForObject(pingUrl, String.class);
            System.out.println("✅ Keep-alive ping successful: " + response);
        } catch (Exception e) {
            System.err.println("❌ Keep-alive ping failed: " + e.getMessage());
        }
    }
}