package com.motelmanager.service;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.motelmanager.domain.Producto;

public class SimpleProductManagerTest {

	private SimpleProductManager productManager;
	
	@Before
	public void setUp(){
		productManager = new SimpleProductManager();
		
		List<Producto> prods = new ArrayList<Producto>();
		
		Producto prod = null;
		
		prod = new Producto();
		prod.setIdProd(100);
		prod.setNmProd("Coca-Cola");
		prods.add(prod);
		
		prod = new Producto();
		prod.setIdProd(200);
		prod.setNmProd("Fanta");
		prods.add(prod);
		
		productManager.setProducts(prods);
		
	}
	
	@Test
	public void getProductTest(){
		Producto prod1 = productManager.getProduct(300);
		assertNull(prod1);
		
		Producto prod2 = productManager.getProduct(200);
		assertNotNull(prod2);
	}
}
