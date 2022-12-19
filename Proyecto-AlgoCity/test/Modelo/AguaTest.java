package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AguaTest {

	@Test
	public void DeberiaDibujarAguaSinTanqueCreadoEnEsaHectarea(){
		
		Agua porcionDeAgua = new Agua();
		assertEquals(porcionDeAgua.dibujar(),"A");
	}
	
	@Test
	public void DeberiaDibujarUnPozoDeAgua(){
		
		Agua porcionDeAgua = new Agua();
		PozoDeAgua unPozo = new PozoDeAgua(porcionDeAgua);
		porcionDeAgua.construir(unPozo);
		assertEquals(porcionDeAgua.dibujar(),"P");
	}

}
