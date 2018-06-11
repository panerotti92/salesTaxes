package com.panerotti.mattia.salestaxes.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.panerotti.mattia.salestaxes.beans.Check;
import com.panerotti.mattia.salestaxes.beans.Product;
import com.panerotti.mattia.salestaxes.utils.Utils;

@Controller   
public class CalculateTaxesController {
	  
	@RequestMapping(value="{products}", method = RequestMethod.GET)
	public @ResponseBody Check getProductsPrices(@PathVariable List<Product> products) {
		Check check= new Check();
		
		//access only with products input, else productsOut empty
		if(products !=null && products.size() > 0) {
			check.setProducts(new ArrayList<Product>());
			Double totalTax = 0.0;
			Double totalCheck = 0.0;
			for(Product p:products) {
				p.setTaxOfProduct(Utils.getTaxFromProduct(p)); 
				totalTax += ((double) (long) (new BigDecimal(p.getTaxOfProduct()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() * 20 + 0.5)) / 20;
				totalCheck +=   new BigDecimal(p.getPriceWithTax()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				check.getProducts().add(p);
			}
			check.setTotalCheck(totalCheck);
			check.setTotalTax(((double) (long) (totalTax * 20 + 0.5)) / 20);
		}
		
		//Only for test 
		System.out.println(check);
		
		return check;

	}
}   
