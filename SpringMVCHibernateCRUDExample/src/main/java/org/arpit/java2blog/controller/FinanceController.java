package org.arpit.java2blog.controller;

import java.util.List;

import org.arpit.java2blog.dao.FinanceDAO;
import org.arpit.java2blog.model.Country;
import org.arpit.java2blog.model.Finance;
import org.arpit.java2blog.service.CountryService;
import org.arpit.java2blog.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FinanceController {
	

	@Autowired
	FinanceService financeService;
	
	@RequestMapping(value = "/getAllFinance", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getFinance(Model model) {
		
		List<Finance> listOfFinance = financeService.getAllFinance();
		model.addAttribute("finance", new Finance());
		model.addAttribute("listOfFinance", listOfFinance);
		return "financeDetails";
	}
	
	@RequestMapping(value = "/getFinance/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Finance getFinanceById(@PathVariable int id) {
		return financeService.getFinance(id);
	}

}
