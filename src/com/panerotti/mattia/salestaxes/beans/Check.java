package com.panerotti.mattia.salestaxes.beans;

import java.util.List;

public class Check {

	private List<Product> products;
	private Double totalTax;
	private Double totalCheck;
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Double getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(Double totalTax) {
		this.totalTax = totalTax;
	}
	public Double getTotalCheck() {
		return totalCheck;
	}
	public void setTotalCheck(Double totalCheck) {
		this.totalCheck = totalCheck;
	}
	@Override
	public String toString() {
		return "Check [products=" + products + ", totalTax=" + totalTax + ", totalCheck=" + totalCheck + "]";
	}
	
	
	
}
