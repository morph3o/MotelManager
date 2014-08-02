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
import com.motelmanager.domain.DetalleSalida;
import com.motelmanager.domain.Entrada;
import com.motelmanager.domain.Factura;
import com.motelmanager.domain.Producto;
import com.motelmanager.domain.Salida;
import com.motelmanager.util.DateTool;

public class JPASalidaDAOTest {
	private ApplicationContext appCtx;
	private SalidaDAO salidaDAO;
	private ProductoDAO prodDAO;
	private FacturaDAO facturaDAO;
	private DetalleSalidaDAO detalleSalidaDAO;
	
	@Before
	public void setUp(){
		appCtx = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		salidaDAO = (SalidaDAO) appCtx.getBean("salidaDAO");
		prodDAO = (ProductoDAO) appCtx.getBean("productoDAO");
		facturaDAO = (FacturaDAO) appCtx.getBean("facturaDAO");
		detalleSalidaDAO = (DetalleSalidaDAO) appCtx.getBean("detalleSalidaDAO");
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
	public void testSalidaProductos(){
		// Traemos los productos que estan en la base de datos
		Producto prod1 = prodDAO.obtenerProducto(1);
		Producto prod2 = prodDAO.obtenerProducto(2);
		
		// Primero creamos una entrada
		Salida salida = new Salida();
		
		// Seteamos los datos de la entrada 
		salida.setIdSalida(1);
		salida.setPersona(null);
		salida.setFechaEgreso(new Date());
		salida.setCantProdSac(2); // La entrada será de dos productos
		
		// Creamos el detalle correspondiente a la salida
		DetalleSalida detalleSalida1 = new DetalleSalida();
		detalleSalida1.setCantExtAnt(prod1.getCantProd());
		detalleSalida1.setCantExtDesp(prod1.getCantProd() - 10);
		detalleSalida1.setCantSalida(10);
		prod1.setCantProd(0);
		detalleSalida1.setProducto(prod1);
		
		// Modificamos la cantidad de productos en el stock
		prodDAO.modificarProducto(prod1);
		
		// Creamos el detalle correspondiente a la salida
		DetalleSalida detalleSalida2 = new DetalleSalida();
		detalleSalida2.setCantExtAnt(prod2.getCantProd());
		detalleSalida2.setCantExtDesp(prod2.getCantProd() - 10);
		detalleSalida2.setCantSalida(10);
		prod1.setCantProd(0);
		detalleSalida2.setProducto(prod2);
		
		// Modificamos la cantidad de productos en el stock
		prodDAO.modificarProducto(prod2);
		
		List<DetalleSalida> listaDetalle = new ArrayList<DetalleSalida>();
		listaDetalle.add(detalleSalida1);
		listaDetalle.add(detalleSalida2);
		
		// Enlazamos los detalles con la salida
		salida.setDetalleSalidas(listaDetalle);
		
		// Enlazamos la salida a cada uno de los detalles
		detalleSalida1.setSalida(salida);
		detalleSalida2.setSalida(salida);
		
		// Persistimos la salida
		salidaDAO.ingresarSalida(salida);		
		
		// Persistimos los detalles
		detalleSalidaDAO.ingresarDetalleSalida(detalleSalida1);
		detalleSalidaDAO.ingresarDetalleSalida(detalleSalida2);
		
		Salida salidaTest = new Salida();
		
		salidaTest = salidaDAO.obtenerSalida(1);
		
		// Verificamos que la salida exista
		Assert.assertNotNull(salidaTest);
		// Verifcamos que el id sea 1
		Assert.assertEquals(1, salidaTest.getIdSalida());
		// Verificamos que la cantidad de productos ingresados sea 2
		Assert.assertEquals(2, salidaTest.getCantProdSac());
		// Verificamos que la fecha es la de hoy
		Assert.assertEquals(DateTool.dateToStringWithFormat(new Date(), "yyyy-MM-dd"), DateTool.dateToStringWithFormat(salidaTest.getFechaEgreso(), "yyyy-MM-dd"));
		
		// Al final eliminamos los datos de prueba que se ingresaron a la base de datos
		detalleSalidaDAO.eliminarDetalleSalida(detalleSalida1);
		detalleSalidaDAO.eliminarDetalleSalida(detalleSalida2);
		
		salidaDAO.eliminarSalida(salidaTest);
		
		prodDAO.removerProducto(prod1);
		prodDAO.removerProducto(prod2);
	}
}
