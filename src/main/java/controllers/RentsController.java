package controllers;

import forms.RentForm;
import forms.RenterForm;
import models.Rent;
import models.Renter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/rents")
public class RentsController {
    @Value("${rest-service.url}")
    private String restServicePath;

    @GetMapping
    public String getRentersPage(@RequestParam(name="active", required = false) Boolean active, ModelMap model){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("localhost").port(8082)
                .path("/rents").replaceQueryParam("active", active)
                .build();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Rent[]> objResponse = restTemplate.getForEntity(uriComponents.toString(), Rent[].class);
        List<Rent> rents = Arrays.asList(objResponse.getBody());

        model.addAttribute("rentsFromService", rents);
        return "rents";
    }

    @GetMapping("/{id}")
    public String getRentsByItem(@PathVariable Long id, ModelMap model){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Rent[]> objResponse =
                restTemplate.getForEntity(restServicePath + "/rentsByItem/" + id.toString(), Rent[].class);
        List<Rent> rents = Arrays.asList(objResponse.getBody());

        model.addAttribute("rentsFromService", rents);
        return "rents";
    }

    @PostMapping
    public String openRent(RentForm rentForm) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Rent> request = new HttpEntity<>(Rent.buildFromOpenForm(rentForm));
        Rent renter = restTemplate.postForObject(restServicePath + "/rents", request, Rent.class);

        return "redirect:/rents";
    }

    @PutMapping
    public String updateRent(RentForm rentForm) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Rent> request = new HttpEntity<>(Rent.buildFromUpdateForm(rentForm));
        try {
            restTemplate.put(restServicePath + "/rents", request, Rent.class);
        }catch (Exception e){
            // TODO Throw exceptions
            System.out.println(e.getMessage());
        }

        return "redirect:/rents";
    }
}