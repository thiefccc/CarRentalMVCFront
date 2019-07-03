package controllers;

import models.analytics.AverageReport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/analytics")
public class AnalyticsController {
    @Value("${rest-service.url}")
    private String restServicePath;

    @GetMapping
    public String getAverageReport(ModelMap model){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AverageReport[]> objResponse = restTemplate.getForEntity( restServicePath + "/analytics/average", AverageReport[].class);
        List<AverageReport> reportRows = Arrays.asList(objResponse.getBody());

        model.addAttribute("reportRows", reportRows);
        return "analytics";
    }
}
