package com.panerotti.mattia.salestaxes.beans;

import com.panerotti.mattia.salestaxes.enumerations.ProductTypeEnum;

public class Product {

	private String name;
	private ProductTypeEnum type;
	private boolean isImported;
	private Double price;
	private long quantity;
	
	private Double taxOfProduct;
	private Double priceWithTax;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductTypeEnum getType() {
		return type;
	}
	public void setType(ProductTypeEnum type) {
		this.type = type;
	}
	public boolean isImported() {
		return isImported;
	}
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public Double getTaxOfProduct() {
		return taxOfProduct;
	}
	public void setTaxOfProduct(Double taxOfProduct) {
		this.taxOfProduct = taxOfProduct;
	}
		
	public Double getPriceWithTax() {
		return price + taxOfProduct;
	} 
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", type=" + type + ", isImported=" + isImported + ", price=" + price
				+ ", quantity=" + quantity + ", taxOfProduct=" + taxOfProduct + "]";
	}
	
	
			
}
