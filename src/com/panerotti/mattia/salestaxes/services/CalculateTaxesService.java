package com.panerotti.mattia.salestaxes.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.panerotti.mattia.salestaxes.beans.Check;
import com.panerotti.mattia.salestaxes.beans.Product;
import com.panerotti.mattia.salestaxes.utils.Utils;

@Component
public class CalculateTaxesService {

	public Check getCheckFromProducts(List<Product> products) {
		Check check = new Check();
		
		//Check only if there are products,else null
		if(products !=null && products.size() > 0) {
			check.setProducts(new ArrayList<Product>());
			Double totalTax = 0.0;
			Double totalCheck = 0.0;
			for(Product p:products) {
				p.setTaxOfProduct(Utils.getTaxFromProduct(p)); 
				totalTax += Utils.round(new BigDecimal(p.getTaxOfProduct()),new BigDecimal(0.05), RoundingMode.UP).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				totalCheck +=   new BigDecimal(p.getPriceWithTax()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				check.getProducts().add(p);
			}
			check.setTotalCheck(new BigDecimal(totalCheck).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			check.setTotalTax(Utils.round(new BigDecimal(totalTax), new BigDecimal(0.05), RoundingMode.UP).doubleValue());
		}else
			check=null;
		
		return check;
		
	}
}
