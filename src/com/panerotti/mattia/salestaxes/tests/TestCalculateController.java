package com.panerotti.mattia.salestaxes.tests;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.panerotti.mattia.salestaxes.beans.Product;
import com.panerotti.mattia.salestaxes.configurations.AppConfig;
import com.panerotti.mattia.salestaxes.controllers.CalculateTaxesController;
import com.panerotti.mattia.salestaxes.enumerations.ProductTypeEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class TestCalculateController  {

	@Autowired
	private CalculateTaxesController controller;


	@Test
	public void test1() {
		Product p1 = new Product();
		p1.setImported(false);
		p1.setQuantity(1);
		p1.setPrice(12.49);
		p1.setName("Book");
		p1.setType(ProductTypeEnum.BOOK);
		Product p2 = new Product();
		p2.setImported(false);
		p2.setQuantity(1);
		p2.setPrice(14.99);
		p2.setName("Musical CD");
		p2.setType(ProductTypeEnum.GOODS);
		Product p3 = new Product();
		p3.setImported(false);
		p3.setQuantity(1);
		p3.setPrice(0.85);
		p3.setName("Chocolate Bar");
		p3.setType(ProductTypeEnum.FOOD);
		
		List<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		
		 
		
		assertNotEquals(null, controller.getProductsPrices(products));
   
	}

	@Test
	public void test2() {
		Product p1 = new Product();
		p1.setImported(true);
		p1.setQuantity(1);
		p1.setPrice(10.00);
		p1.setName("Box of chocolate");
		p1.setType(ProductTypeEnum.FOOD);
		
		Product p2 = new Product();
		p2.setImported(true);
		p2.setQuantity(1);
		p2.setPrice(47.50);
		p2.setName("Bottle of perfume");
		p2.setType(ProductTypeEnum.GOODS); 
		
		List<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(p2); 
		
		 
		
		assertNotEquals(null, controller.getProductsPrices(products));
   
	}
	
	@Test
	public void test3() {
		Product p1 = new Product();
		p1.setImported(true);
		p1.setQuantity(1);
		p1.setPrice(27.99);
		p1.setName("Bottle of perfume");
		p1.setType(ProductTypeEnum.GOODS);
		Product p2 = new Product();
		p2.setImported(false);
		p2.setQuantity(1);
		p2.setPrice(18.99);
		p2.setName("Musical CD");
		p2.setType(ProductTypeEnum.GOODS);
		Product p3 = new Product();
		p3.setImported(false);
		p3.setQuantity(1);
		p3.setPrice(9.75);
		p3.setName("packet of headache pills");
		p3.setType(ProductTypeEnum.MEDICAL);
		Product p4 = new Product();
		p4.setImported(true);
		p4.setQuantity(1);
		p4.setPrice(11.25);
		p4.setName("box of imported chocolates");
		p4.setType(ProductTypeEnum.FOOD);
		
		List<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		
		 
		
		assertNotEquals(null, controller.getProductsPrices(products));
   
	}
	
}
