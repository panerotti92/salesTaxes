package com.panerotti.mattia.salestaxes.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
				taxImport =  round(new BigDecimal((p.getQuantity() * p.getPrice() * taxPercentage) / 100),new BigDecimal(0.05),RoundingMode.UP).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			
		}else {
			//launch error?
		}
		
		return taxImport;
		
	}
	
	public static BigDecimal round(BigDecimal value, BigDecimal increment,  RoundingMode roundingMode) {
		if (increment.signum() == 0) {
			// 0 increment does not make much sense, but prevent division by 0
			return value;
		} else {
			BigDecimal divided = value.divide(increment, 0, roundingMode);
			BigDecimal result = divided.multiply(increment);
			return result;
		}
	}
}
