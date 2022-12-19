package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CentralNuclearTest {

	@Test
	public void DeberiaDevolverLaCapacidadDeAbastecimientoDeLaCentralCreada(){
			
		Tierra unaTierra = new Tierra();	
		CentralNuclear unaCentral = new CentralNuclear(unaTierra);
		
					
			assertEquals(unaCentral.obtenerCapacidadDeAbast(),1000);
		}
	@Test 
	public void testCentralNuclearReconstruidaPorBomberos(){
		Tierra unaTierra = new Tierra();
		EstacionDeBomberos bomberos = new EstacionDeBomberos();
		CentralNuclear unaCentralNuclear = new CentralNuclear(unaTierra);
		unaCentralNuclear.daniarEnPorcentaje(55);
		bomberos.aplicarReconstruccionA(unaCentralNuclear);
		
		assertTrue(unaCentralNuclear.obtenerEstado() == 48); 
			
	}
}
