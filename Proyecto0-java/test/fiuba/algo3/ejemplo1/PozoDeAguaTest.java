package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class PozoDeAguaTest {

	@Test
	public void AlCrearUnaTuberiaDevuelveElObjetoTuberia(){
		
		Hectarea unaHectarea = new Hectarea(1,5);
		PozoDeAgua unPozo = new PozoDeAgua(unaHectarea);				
				
		Assert.assertEquals(unPozo.ubicacion(),unaHectarea);
	}

}
