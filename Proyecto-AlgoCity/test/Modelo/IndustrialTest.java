package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class IndustrialTest {

	@Test
	public void testIndustriaCreadaCon100DeEstado(){
		
		Tierra unaTierra = new Tierra();
		Industrial unaIndustria = new Industrial(unaTierra);
		
		assertTrue(unaIndustria.obtenerEstado() == 100.0);
	}
	@Test
	public void testIndustriaCreadaConReferenciaAUnaHectarea(){
		
		Tierra unaTierra = new Tierra();
		Industrial unaIndustria = new Industrial(unaTierra);
		
		assertEquals(unaIndustria.obtenerLugarDeConstruccion(),unaTierra);
	}
	
	@Test
	public void testIndustriaRecibe40deDanio(){
		Tierra unaTierra = new Tierra();
		Industrial unaIndustria = new Industrial(unaTierra);
		unaIndustria.daniarEnPorcentaje(40);
		assertTrue(unaIndustria.obtenerEstado() == 60);
	}
	
	@Test 
	public void testIndustriaReconstruidaPorBomberos(){
		Tierra unaTierra = new Tierra();
		EstacionDeBomberos bomberos = new EstacionDeBomberos();
		Industrial unaIndustria = new Industrial(unaTierra);
		unaIndustria.daniarEnPorcentaje(30);
		bomberos.aplicarReconstruccionA(unaIndustria);
		
		assertTrue(unaIndustria.obtenerEstado() == 73);
			
	}

}
