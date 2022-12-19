package Modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ServiciosRequeridosTest {
	
	
	@Test
	public void DeberiaTraducirElEnumeradoPedido(){
		
		ServiciosRequeridos servicio = ServiciosRequeridos.RUTA;
		
		assertEquals(servicio.toString(), "RUTA");
		
	}
	
	@Test
	public void DeberiaChequearSiLaListaDeServicioContieneLoPedido(){
		
		ArrayList<ServiciosRequeridos> lista = new ArrayList<ServiciosRequeridos>();
		lista.add(ServiciosRequeridos.AGUA);
		lista.add(ServiciosRequeridos.LUZ);
		
		assertTrue(lista.contains(ServiciosRequeridos.AGUA));
		assertTrue(lista.contains(ServiciosRequeridos.LUZ));
		assertFalse(lista.contains(ServiciosRequeridos.RUTA));
	}

}
