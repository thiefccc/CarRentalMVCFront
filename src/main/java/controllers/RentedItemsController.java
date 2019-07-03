package controllers;

import forms.RenterForm;
import models.RentedItem;
import models.Renter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/items")
public class RentedItemsController {
    @Value("${rest-service.url}")
    private String restServicePath;

    @GetMapping
    public String getRentedItemsPage(ModelMap model){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RentedItem[]> objResponse = restTemplate.getForEntity(restServicePath + "/items", RentedItem[].class);
        List<RentedItem> items = Arrays.asList(objResponse.getBody());

        model.addAttribute("itemsFromService", items);
        return "items";
    }

    @PostMapping
    public String addRentedItem(RentedItem rentedItem){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<RentedItem> request = new HttpEntity<>(rentedItem);// (Renter.from(renterForm));
        RentedItem item = restTemplate.postForObject(restServicePath + "items/", rentedItem, RentedItem.class);

        return "redirect:/items";
    }
}