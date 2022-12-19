package Modelo;
import static org.junit.Assert.*;

import org.junit.*;

public class CentralEolicaTest {
	
	@Test
	public void testCentralEolicaRecibe30deDanio(){
		Tierra unaTierra = new Tierra();
		CentralEolica unaCentralEolica = new CentralEolica(unaTierra);
		unaCentralEolica.daniarEnPorcentaje(30);
		assertTrue(unaCentralEolica.obtenerEstado() == 70);
	}
	@Test
	public void testCentralEolicaRecuperadaPorBomberosRetornaEstadoEn100(){
		Tierra unaTierra =new Tierra();
		CentralEolica unaCentralEolica = new CentralEolica(unaTierra);
		unaCentralEolica.recuperarEstructura(100);
		
		assertTrue(unaCentralEolica.obtenerEstado()== 100);
		}
	@Test 
	public void testCentralEolicaReconstruidaPorBomberos(){
		Tierra unaTierra = new Tierra();
		EstacionDeBomberos bomberos = new EstacionDeBomberos();
		CentralEolica unaCentralEolica = new CentralEolica(unaTierra);
		unaCentralEolica.daniarEnPorcentaje(30);
		bomberos.aplicarReconstruccionA(unaCentralEolica);
		
		assertTrue(unaCentralEolica.obtenerEstado() == 85); 
		
	}
}
