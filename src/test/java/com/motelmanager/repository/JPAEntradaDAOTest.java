package com.motelmanager.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.motelmanager.domain.Entrada;
import com.motelmanager.domain.Factura;
import com.motelmanager.domain.Producto;

public class JPAEntradaDAOTest {

	private ApplicationContext appCtx;
	private EntradaDAO entradaDAO;
	private ProductoDAO prodDAO;
	private FacturaDAO facturaDAO;
	
	@Before
	public void setUp(){
		appCtx = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		entradaDAO = (EntradaDAO) appCtx.getBean("entradaDAO");
		prodDAO = (ProductoDAO) appCtx.getBean("productoDAO");
		facturaDAO = (FacturaDAO) appCtx.getBean("facturaDAO");
	}
	
	@Test
	public void testObtenerIDEntrada(){
		System.out.println(entradaDAO.obtenerUltimaIDEntrada());
	}
	
	@Test
	public void testIngresoProductos(){
		int idEntrada = 6;
		
		Entrada entrada1 = new Entrada();
		
		Producto prod1 = this.prodDAO.obtenerProducto(100);
//		Producto prod1 = new Producto();
//		prod1.setIdProd(100);
//		prod1.setNmProd("Prueba");
//		prod1.setCantProd(200);
		
		Assert.assertNotNull(prod1);
		
		System.out.println(prod1.getIdProd());
		
		Factura factura1 = null; 
		
		entrada1.setIdEntrada(idEntrada);
		entrada1.setFactura(null);
		entrada1.setProducto(prod1);
		entrada1.setCantIngreso(10);
		entrada1.setCantExtAnt(prod1.getCantProd());
		int nuevaCant = prod1.getCantProd()+entrada1.getCantIngreso();
		entrada1.setCantExtDesp(nuevaCant);
				
		prod1.setCantProd(nuevaCant);
		
		this.prodDAO.modificarProducto(prod1);
		this.entradaDAO.ingresoProductos(entrada1);
	}
	
}
