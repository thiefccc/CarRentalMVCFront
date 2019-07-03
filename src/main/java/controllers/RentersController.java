package controllers;

import forms.RenterForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import models.Renter;

@Controller
public class RentersController {
    @Value("${rest-service.url}")
    private String restServicePath;

    @GetMapping("/renters")
    public String getRentersPage(ModelMap model){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Renter[]> objResponse = restTemplate.getForEntity(restServicePath + "/renters", Renter[].class);
        List<Renter> renters = Arrays.asList(objResponse.getBody());

        model.addAttribute("rentersFromService", renters);
        return "renters";
    }

    @PostMapping("/addRenter")
    public String addRenter(RenterForm renterForm){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Renter> request = new HttpEntity<>(Renter.from(renterForm));
        Renter renter = restTemplate.postForObject(restServicePath + "/renters", request, Renter.class);

        return "redirect:/renters";
    }
}