package com.motelmanager.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.motelmanager.domain.Producto;

public class JPAProductoDAOTest {

	private ApplicationContext appCtx;
	private ProductoDAO prodDAO;
	private static final int ID_PRODUCTO = 666;
	private static final String NOMBRE_PRODUCTO = "Pap"; 
	
	@Before
	public void setUp(){
		appCtx = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        prodDAO = (ProductoDAO) appCtx.getBean("productoDAO");
	}
	
	@Test
    public void testGetProductList() {
        List<Producto> products = prodDAO.getProductos();
        assertEquals(products.size(), 5);	   
    }

    @Test
    public void testSaveProduct() {
        Producto p = null;
        
        p = new Producto();
        p.setIdProd(ID_PRODUCTO);
        p.setNmProd(NOMBRE_PRODUCTO);
        p.setCantProd(500);
        p.setDetalle("Prueba Detalle");
        prodDAO.saveProducto(p);

        Producto p2 = prodDAO.obtenerProducto(ID_PRODUCTO); 
        assertEquals("TEST",NOMBRE_PRODUCTO,p2.getNmProd());
    }
    
    @Test
    public void modificarProductoTest(){
    	Producto p = null;    	
    	p = prodDAO.obtenerProducto(ID_PRODUCTO);
    	p.setCantProd(200);
    	prodDAO.modificarProducto(p);
    	assertEquals(200, prodDAO.obtenerProducto(ID_PRODUCTO).getCantProd());
    }
    
    @Test
    public void removerProductoTest(){
    	Producto p = prodDAO.obtenerProducto(ID_PRODUCTO);
    	prodDAO.removerProducto(p);
    	assertNull(prodDAO.obtenerProducto(ID_PRODUCTO));
    }
}
