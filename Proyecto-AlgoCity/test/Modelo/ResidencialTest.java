package Modelo;
import static org.junit.Assert.*;
import org.junit.*;

public class ResidencialTest {
	
	@Test
	public void testResidenciaCreadaCon100DeEstado(){
		
		Tierra unaTierra = new Tierra();
		Residencial unaResidencia = new Residencial(unaTierra);
		
		assertTrue(unaResidencia.obtenerEstado() == 100.0);
	}
	@Test
	public void testResidenciaCreadaConReferenciaAUnaHectarea(){
		
		Tierra unaTierra = new Tierra();
		Residencial unaResidencia = new Residencial(unaTierra);
		
		assertEquals(unaResidencia.obtenerLugarDeConstruccion(),unaTierra);
	}
	
	@Test
	public void testResidenciaRecibe30deDanio(){
		Tierra unaTierra = new Tierra();
		Residencial unaResidencia = new Residencial(unaTierra);
		unaResidencia.daniarEnPorcentaje(30);
		assertTrue(unaResidencia.obtenerEstado() == 70);
	}
	
	@Test 
	public void testResidenciaReconstruidaPorBomberos(){
		Tierra unaTierra = new Tierra();
		EstacionDeBomberos bomberos = new EstacionDeBomberos();
		Residencial unaResidencia = new Residencial(unaTierra);
		unaResidencia.daniarEnPorcentaje(30);
		bomberos.aplicarReconstruccionA(unaResidencia);
		
		assertTrue(unaResidencia.obtenerEstado() == 80); 
			
	}
	/*
	@Test
	public void DeberiaDevolverLosServiciosNecesariosParaCrearUnaCasa(){
		ArrayList<Servicio>
	}
	*/
	
}

	