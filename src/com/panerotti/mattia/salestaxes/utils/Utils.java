package com.panerotti.mattia.salestaxes.utils;

import java.math.BigDecimal;

import com.panerotti.mattia.salestaxes.beans.Product;

public class Utils {

	public static Double getTaxFromProduct(Product p) {
		Double taxPercentage = 0.0;
		Double taxImport = 0.0;
		if(p!=null) {
			switch(p.getType()) {
			case GOODS:
				taxPercentage = Constants.TAX_GOODS;
				break;
			default: 
				break;
			}
			//if product imported add tax 5%
			if(p.isImported()) {
				taxPercentage = taxPercentage + Constants.TAX_IMPORT_GOODS;
			}
			if(taxPercentage != 0.0)
				taxImport = ((double) (long) ( new BigDecimal((p.getQuantity() * p.getPrice() * taxPercentage) / 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() * 20 + 0.5)) / 20;
			
		}else {
			//launch error?
		}
		
		return taxImport;
		
	}
}
