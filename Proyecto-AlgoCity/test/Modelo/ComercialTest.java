package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComercialTest {

	@Test
	public void testComercioCreadoCon100DeEstado(){
		
		Tierra unaTierra = new Tierra();
		Comercial unComercio = new Comercial(unaTierra);
		
		assertTrue(unComercio.obtenerEstado() == 100.0);
	}
	@Test
	public void testComercioCreadoConReferenciaAUnaHectarea(){
		
		Tierra unaTierra = new Tierra();
		Comercial unComercio = new Comercial(unaTierra);
		
		assertEquals(unComercio.obtenerLugarDeConstruccion(),unaTierra);
	}
	
	@Test
	public void testComercioRecibe50deDanio(){
		Tierra unaTierra = new Tierra();
		Comercial unComercio = new Comercial(unaTierra);
		unComercio.daniarEnPorcentaje(50);
		assertTrue(unComercio.obtenerEstado() == 50);
	}
	
	@Test 
	public void testComercioReconstruidoPorBomberos(){
		Tierra unaTierra = new Tierra();
		EstacionDeBomberos bomberos = new EstacionDeBomberos();
		Comercial unComercio = new Comercial(unaTierra);
		unComercio.daniarEnPorcentaje(30);
		bomberos.aplicarReconstruccionA(unComercio);
		
		assertTrue(unComercio.obtenerEstado() == 77); 
			
	}
	
	


}
