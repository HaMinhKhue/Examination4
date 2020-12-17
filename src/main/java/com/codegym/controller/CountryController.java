package com.codegym.controller;

import com.codegym.model.Country;
import com.codegym.service.CityService;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CountryController {
    @Autowired
    CityService cityService;
    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    public ModelAndView countryList() {
        Iterable<Country> countries = countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("country/index");
        modelAndView.addObject("countries", countries);
        return modelAndView;
    }

    @GetMapping("/create-country")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("country/create");
        modelAndView.addObject("country", new Country());
        return modelAndView;
    }

    @PostMapping("/create-country-post")
    public ModelAndView saveCountry(@Valid @ModelAttribute("country")Country country, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("country/index");
        if (!bindingResult.hasFieldErrors()){
            countryService.save(country);
            modelAndView.addObject("countries",countryService.findAll());
            modelAndView.addObject("message", "A new country created successfully");
            return modelAndView;
        }else {
            modelAndView.addObject("country",country);
            return modelAndView;
        }

    }
}