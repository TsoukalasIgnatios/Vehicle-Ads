package com.bikeAdvert.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bikeAdvert.demo.entity.BikeAdvert;
import com.bikeAdvert.demo.service.BikeAdvertService;

@Controller
@RequestMapping("/BikeAdverts")
public class BikeAdvertController {
	//inject BikeAdvertDAO
	@Autowired
	private BikeAdvertService bikeAdvertService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		//get bikeAdverts from the service
		List<BikeAdvert> theBikeAdverts=bikeAdvertService.getBikeAdverts();
		//add the customers to the model
		theModel.addAttribute("bikeAdverts",theBikeAdverts);
		return "list-bikeAdverts";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		BikeAdvert bikeAdvert = new BikeAdvert();
		
		theModel.addAttribute("BikeAdvert",bikeAdvert);
		
		return "bikeAdverts-form";
	}
	
	@PostMapping("/saveBikeAd")
	public String saveBikeAd(@ModelAttribute("BikeAdvert")BikeAdvert theBikeAdvert) {
		
		bikeAdvertService.saveBikeAd(theBikeAdvert);
		
		return "redirect:/BikeAdverts/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("BikeAdvertId")int theId,Model theModel) {
		//get BikeAd from our service
		BikeAdvert theBikeAdvert = bikeAdvertService.getBikeAdvert(theId);
		
		//set BikeAdvert as a model attribute to pre-populate the form
		theModel.addAttribute("BikeAdvert", theBikeAdvert);
		//send over to our form
		
		return "bikeAdverts-form";
	}
	@GetMapping("/delete")
	public String deleteBikeAd(@RequestParam("BikeAdvertId")int theId) {
		//delete the BikeAdvert
		bikeAdvertService.deleteBikeAd(theId);
		return "redirect:/BikeAdverts/list";
	}
	@GetMapping("/search")
	public String searchBikeAd(@RequestParam("theCompanyName")String theCompanyName,Model theModel) {
		
		List<BikeAdvert> theBikeAdverts = bikeAdvertService.searchBikeAd(theCompanyName);
		theModel.addAttribute("BikeAdverts",theBikeAdverts);
		return "list-bikeAdverts";
	}
}
