package com.motelmanager.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.motelmanager.domain.DetalleEntrada;
import com.motelmanager.domain.Entrada;
import com.motelmanager.domain.Producto;
import com.motelmanager.util.DateTool;

public class JPAEntradaDAOTest {

	private ApplicationContext appCtx;
	private EntradaDAO entradaDAO;
	private ProductoDAO prodDAO;
	private FacturaDAO facturaDAO;
	private DetalleEntradaDAO detalleEntradaDAO;
	
	@Before
	public void setUp(){
		appCtx = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		entradaDAO = (EntradaDAO) appCtx.getBean("entradaDAO");
		prodDAO = (ProductoDAO) appCtx.getBean("productoDAO");
		facturaDAO = (FacturaDAO) appCtx.getBean("facturaDAO");
		detalleEntradaDAO = (DetalleEntradaDAO) appCtx.getBean("detalleEntradaDAO");
		
		ingresarTestProductos();
	}
	
	private void ingresarTestProductos(){
		Producto prod1 = new Producto();
		prod1.setIdProd(1);
		prod1.setNmProd("Producto 1");
		prod1.setTipoProd("Tipo producto 1");
		prod1.setMarca("Marca Producto 1");
		prod1.setCantProd(10);
		prod1.setDetalle("Detalle producto 1");
		prod1.setImagen("imagen producto 1");
		
		prodDAO.saveProducto(prod1);
		
		Producto prod2 = new Producto();
		prod2.setIdProd(2);
		prod2.setNmProd("Producto 2");
		prod2.setTipoProd("Tipo producto 2");
		prod2.setMarca("Marca Producto 2");
		prod2.setCantProd(10);
		prod2.setDetalle("Detalle producto 2");
		prod2.setImagen("imagen producto 2");
		
		prodDAO.saveProducto(prod2);
	}
	
	@Test
	public void testIngresoProductos(){
		
		// Traemos los productos que estan en la base de datos
		Producto prod1 = prodDAO.obtenerProducto(1);
		Producto prod2 = prodDAO.obtenerProducto(2);
		
		// Primero creamos una entrada
		Entrada entrada = new Entrada();
		
		// Seteamos los datos de la entrada 
		entrada.setIdEntrada(1);
		entrada.setPersona(null);
		entrada.setFactura(null);
		entrada.setFechaIngreso(new Date());
		entrada.setCantProdIng(2); // La entrada será de dos productos
		
		// Creamos el detalle correspondiente a la entrada
		DetalleEntrada detalleEntrada1 = new DetalleEntrada();
		detalleEntrada1.setCantExtAnt(prod1.getCantProd());
		detalleEntrada1.setCantExtDesp(prod1.getCantProd() + 10);
		detalleEntrada1.setCantIngreso(10);
		prod1.setCantProd(10);
		detalleEntrada1.setProducto(prod1);
		
		// Modificamos la cantidad de productos en el stock
		prodDAO.modificarProducto(prod1);
		
		// Creamos el detalle correspondiente a la entrada
		DetalleEntrada detalleEntrada2 = new DetalleEntrada();
		detalleEntrada2.setCantExtAnt(prod2.getCantProd());
		detalleEntrada2.setCantExtDesp(prod2.getCantProd() + 10);
		detalleEntrada2.setCantIngreso(10);
		prod2.setCantProd(10);
		detalleEntrada2.setProducto(prod2);
		
		// Modificamos la cantidad de productos en el stock
		prodDAO.modificarProducto(prod2);
		
		List<DetalleEntrada> listaDetalle = new ArrayList<DetalleEntrada>();
		listaDetalle.add(detalleEntrada1);
		listaDetalle.add(detalleEntrada2);
		
		// Enlazamos los detalles con la entrada
		entrada.setDetalleEntradas(listaDetalle);
		
		// Enlazamos la entrada a cada uno de los detalles
		detalleEntrada1.setEntrada(entrada);
		detalleEntrada2.setEntrada(entrada);
		
		// Persistimos la entrdad
		entradaDAO.ingresoProductos(entrada);		
		
		// Persistimos los detalles
		detalleEntradaDAO.ingresarDetalleEntrada(detalleEntrada1);
		detalleEntradaDAO.ingresarDetalleEntrada(detalleEntrada2);
		
		Entrada entradaTest = new Entrada();
		
		entradaTest = entradaDAO.obtenerEntrada(1);
		
		// Verificamos que la entrada exista
		Assert.assertNotNull(entradaTest);
		// Verifcamos que el id sea 1
		Assert.assertEquals(1, entradaTest.getIdEntrada());
		// Verificamos que la cantidad de productos ingresados sea 2
		Assert.assertEquals(2, entradaTest.getCantProdIng());
		// Verificamos que la fecha es la de hoy
		Assert.assertEquals(DateTool.dateToStringWithFormat(new Date(), "yyyy-MM-dd"), DateTool.dateToStringWithFormat(entradaTest.getFechaIngreso(), "yyyy-MM-dd"));
		
		// Al final eliminamos los datos de prueba que se ingresaron a la base de datos
		detalleEntradaDAO.eliminarDetalleEntrada(detalleEntrada1);
		detalleEntradaDAO.eliminarDetalleEntrada(detalleEntrada2);
		
		entradaDAO.eliminarEntrada(entradaTest);
		
		prodDAO.removerProducto(prod1);
		prodDAO.removerProducto(prod2);
	}
	
}
