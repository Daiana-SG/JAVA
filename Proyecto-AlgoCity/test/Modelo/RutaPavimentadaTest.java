package Modelo;

import static org.junit.Assert.*;
import org.junit.Test;

public class RutaPavimentadaTest {

	@Test
	public void DeberiaConstruirRutaYDibujarla(){
		
		Hectarea unaHectarea = Hectarea.hectareaConTierra(1, 2);
		unaHectarea.construirRutaPavimentada();
		
		assertEquals(unaHectarea.dibujarSuperficie(),"Rt");
		
	}

}
