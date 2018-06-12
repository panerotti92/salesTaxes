package com.panerotti.mattia.salestaxes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panerotti.mattia.salestaxes.beans.Check;
import com.panerotti.mattia.salestaxes.beans.Product;
import com.panerotti.mattia.salestaxes.services.CalculateTaxesService;

@Controller   
public class CalculateTaxesController {
	
	@Autowired
	CalculateTaxesService service;
	
	@RequestMapping(value="{products}", method = RequestMethod.GET)
	public @ResponseBody Check getProductsPrices(@PathVariable List<Product> products) {
		
		Check check = service.getCheckFromProducts(products);
		
		 		
		//Only for output test 
		System.out.println(check);
		
		return check;

	}
}   
