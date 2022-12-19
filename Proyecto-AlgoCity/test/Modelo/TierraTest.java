package Modelo;

import static org.junit.Assert.*;
import org.junit.*;

public class TierraTest {
	
	@Test
	public void DeberiaDibujarTierraSinNingunaConstruccion(){
		
		Tierra unaTierra = new Tierra();
		assertEquals(unaTierra.dibujar(),"T");
	}
	
	@Test
	public void DeberiaDibujarUnaResidencia(){
		
		Tierra unaTierra = new Tierra();
		Residencial unaResidencia = new Residencial(unaTierra);
		unaTierra.construir(unaResidencia);
		assertEquals(unaTierra.dibujar(),"R");
	}

}
