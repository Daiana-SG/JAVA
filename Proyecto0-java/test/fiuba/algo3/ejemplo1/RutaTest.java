package fiuba.algo3.ejemplo1;


import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class RutaTest {

	@Test
	public void AlCrearUnaRutaDevuelveElObjetoRuta(){
		//hace falta posicionar en el mapa? hacer Mapa new?
		Hectarea unaHectarea = new Hectarea(1,3);
		Ruta unaRuta = new Ruta(unaHectarea);
		
		Assert.assertEquals(unaRuta.ubicacion(),unaHectarea);
		
	}

}
