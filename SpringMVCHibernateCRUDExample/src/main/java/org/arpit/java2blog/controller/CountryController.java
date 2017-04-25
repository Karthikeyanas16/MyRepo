package org.arpit.java2blog.controller;


import java.util.List;

import org.arpit.java2blog.model.Country;
import org.arpit.java2blog.model.Finance;
import org.arpit.java2blog.service.CountryService;
import org.arpit.java2blog.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@RequestMapping(value = "/getAllCountries", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getCountries(Model model) {
		
		List<Country> listOfCountries = countryService.getAllCountries();
		model.addAttribute("country", new Country());
		model.addAttribute("listOfCountries", listOfCountries);
		return "countryDetails";
	}
	
//	@Autowired
//	FinanceService financeService;
//	
//	@RequestMapping(value = "/getAllFinance", method = RequestMethod.GET, headers = "Accept=application/json")
//	public String getFinance(Model model) {
//		
//		List<Finance> listOfFinance = financeService.getAllFinance();
//		model.addAttribute("finance", new Finance());
//		model.addAttribute("listOfFinance", listOfFinance);
//		return "countryDetails";
//	}

	
	
//	
//	String message = "Welcome to Spring MVC!";
//
//	@RequestMapping("/hello1")
//	public ModelAndView showMessage(
//			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
//		System.out.println("in controller");
//
//		ModelAndView mv = new ModelAndView("countryDetails");
//		mv.addObject("message", message);
//		mv.addObject("name", name);
//		return mv;
//	}
	

	@RequestMapping(value = "/getCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryById(@PathVariable int id) {
		return countryService.getCountry(id);
	}

	@RequestMapping(value = "/addCountry", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCountry(@ModelAttribute("country") Country country) {	
		if(country.getId()==0)
		{
			countryService.addCountry(country);
		}
		else
		{	
			countryService.updateCountry(country);
		}
		
		return "redirect:/getAllCountries";
	}

	@RequestMapping(value = "/updateCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCountry(@PathVariable("id") int id,Model model) {
		 model.addAttribute("country", this.countryService.getCountry(id));
	        model.addAttribute("listOfCountries", this.countryService.getAllCountries());
	        return "countryDetails";
	}

	@RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCountry(@PathVariable("id") int id) {
		countryService.deleteCountry(id);
		 return "redirect:/getAllCountries";

	}	
}
