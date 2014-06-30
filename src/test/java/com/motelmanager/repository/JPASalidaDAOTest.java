package com.motelmanager.repository;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.motelmanager.domain.Entrada;
import com.motelmanager.domain.Factura;
import com.motelmanager.domain.Producto;
import com.motelmanager.domain.Salida;

public class JPASalidaDAOTest {
	private ApplicationContext appCtx;
	private SalidaDAO salidaDAO;
	private ProductoDAO prodDAO;
	private FacturaDAO facturaDAO;
	
	@Before
	public void setUp(){
		appCtx = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		salidaDAO = (SalidaDAO) appCtx.getBean("salidaDAO");
		prodDAO = (ProductoDAO) appCtx.getBean("productoDAO");
		facturaDAO = (FacturaDAO) appCtx.getBean("facturaDAO");
	}
	
	@Test
	public void testIngresoProductos(){
		int idEntrada = 6;
		
		Salida salida1 = new Salida();
		
		Producto prod1 = this.prodDAO.obtenerProducto(100);
//		Producto prod1 = new Producto();
//		prod1.setIdProd(100);
//		prod1.setNmProd("Prueba");
//		prod1.setCantProd(200);
		
		Assert.assertNotNull(prod1);
		
		System.out.println(prod1.getIdProd());
		
		Factura factura1 = null; 
		
		salida1.setIdSalida(idEntrada);
		salida1.setFechaEgreso(new Date());
		salida1.setProducto(prod1);
		salida1.setCantEgreso(10);
		salida1.setCantExtAnt(prod1.getCantProd());
		int nuevaCant = prod1.getCantProd()-salida1.getCantEgreso();
		salida1.setCantExtDesp(nuevaCant);
				
		prod1.setCantProd(nuevaCant);
		
		this.prodDAO.modificarProducto(prod1);
		this.salidaDAO.ingresarSalida(salida1);
	}
}
