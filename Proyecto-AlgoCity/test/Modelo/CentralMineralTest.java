package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CentralMineralTest {

	@Test
	public void DeberiaDevolverLaCapacidadDeAbastecimientoDeLaCentralCreada(){
			
		Tierra unaTierra = new Tierra();	
		CentralMineral unaCentral = new CentralMineral(unaTierra);
		
					
			assertEquals(unaCentral.obtenerCapacidadDeAbast(),400);
		}
	@Test 
	public void testCentralMineralReconstruidaPorBomberos(){
		Tierra unaTierra = new Tierra();
		EstacionDeBomberos bomberos = new EstacionDeBomberos();
		CentralMineral unaCentralMineral = new CentralMineral(unaTierra);
		unaCentralMineral.daniarEnPorcentaje(40);
		bomberos.aplicarReconstruccionA(unaCentralMineral);
		
		assertTrue(unaCentralMineral.obtenerEstado() == 70); 
			
	}
}
