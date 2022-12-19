package Modelo;

import static org.junit.Assert.*;
import org.junit.Test;

public class PozoDeAguaTest {

	@Test
	public void AlCrearUnaTuberiaDevuelveElObjetoTuberia(){
		
		Hectarea unaHectarea = new Hectarea(1,5);
		PozoDeAgua unPozo = new PozoDeAgua(unaHectarea);				
				
		assertEquals(unPozo.ubicacion(),unaHectarea);
	}


}
