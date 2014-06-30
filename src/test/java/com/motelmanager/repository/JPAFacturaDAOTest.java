package com.motelmanager.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.motelmanager.domain.Factura;

public class JPAFacturaDAOTest {

	private ApplicationContext appCtx;
	private FacturaDAO facturaDAO;
	
	@Before
	public void setUp(){
		this.appCtx = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		this.facturaDAO = (FacturaDAO) appCtx.getBean("facturaDAO");
	}
	
	@Test
	public void testIngresarFactura(){
		
		Factura factura1 = new Factura();
		
		factura1.setIdFactura(1);
		factura1.setPrecioNeto(100);
		factura1.setPrecioTotal(119);
		
		this.facturaDAO.ingresarFactura(factura1);
		
	}
	
	@Test
	public void testObtenerFactura(){
		int idFactura = 1;
		Factura factura = this.facturaDAO.obtenerFactura(idFactura);
		Assert.assertNotNull(factura);
		Assert.assertEquals(100, factura.getPrecioNeto());
		Assert.assertEquals(119, factura.getPrecioTotal());
	}
	
}
