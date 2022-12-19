package Modelo;
import java.util.*;

public class Juego {
	private Jugador jugador;
	private Mapa mapa;
	private boolean juegoEnCurso;
	private boolean turnoDelJugador;
	
	public Juego(){
		this.mapa = new Mapa();	
	}
	
	public void nuevoJugador(Jugador jugador){
		this.jugador = jugador;
	}
	
	public void iniciar(){
		//Mientras no se finalize el juego
		while (this.juegoEnCurso){
			//Si es turno del jugador
			if(this.turnoDelJugador){
				this.jugador.jugar();
				this.turnoDelJugador = false;
			}//Si es el turno del juego
			else{
				this.jugar();
				this.turnoDelJugador = true;
			}
		}
	}
	
	public void jugar(){
		//Genera un numero random
		
		int minimo = -10;
		int maximo = 10;

		Random random = new Random();
		int numeroRandom = random.nextInt(maximo - minimo + 1) + minimo;
		
		//Utiliza random para deicidir si aplica un terremoto
		if(numeroRandom < -5){
			this.iniciarCatastrofe();
		}
		//Si hay al menos una estacion de bomberos creada ejecuta reparaciones
		if(this.mapa.tieneAlMenosUnaEstacionDeBomberos()){
			
			ArrayList<Hectarea> hectareas = this.mapa.obtenerHectareasConEstacionesDeBomberos();
			ArrayList<EstacionDeBomberos> estaciones= this.obtenerEstacionesDeBomberos(hectareas);
			
			
			for(int i=0;i< this.mapa.obtenerHectareasConEstacionesDeBomberos().size();i++){
				//Se aplica reconstruccion
				Hectarea hectareaConBomberosActual = hectareas.get(i);
				ArrayList<Hectarea> hectareasAledaniasEnRadioTres = this.mapa.obtenerHectareasAledanias(hectareaConBomberosActual,3);
				
				for(int j=0;j<hectareasAledaniasEnRadioTres.size();j++){
					Hectarea hectareaActual  = hectareasAledaniasEnRadioTres.get(j);
					EstacionDeBomberos estacion = estaciones.get(j);
					Construccion construccion = hectareaActual.obtenerSuperficie().obtenerConstruccion();
							
					estacion.aplicarReconstruccionA(construccion);
				}
			}
		}
		
	}	
	
	public void finalizar(){
		this.juegoEnCurso = false;
	}
	
	public void turnoDelJugador(){
		this.turnoDelJugador = true;
	}
	
	public void turnoDelJuego(){
		this.turnoDelJugador = false;
	}
	
	public void iniciarCatastrofe(){
		int anchoMinimo = 1;
		int anchoMaximo = this.mapa.obtenerAncho();
		int altoMinimo = 1;
		int altoMaximo = this.mapa.obtenerAlto();

		Random catastrofeRandom = new Random();
		int xRandom = catastrofeRandom.nextInt(anchoMaximo - anchoMinimo + 1) + anchoMinimo;
		int yRandom = catastrofeRandom.nextInt(altoMaximo - altoMinimo + 1) + altoMinimo;
		
		this.mapa.aplicarTerremoto(xRandom, yRandom);
	}
	
	protected ArrayList<EstacionDeBomberos> obtenerEstacionesDeBomberos(ArrayList<Hectarea> hectareasConEstacionesDeBomberos){
		
		ArrayList<EstacionDeBomberos> estacionesDeBomberos= new ArrayList<EstacionDeBomberos>();
		
		for(int i=0;i> hectareasConEstacionesDeBomberos.size();i++){
			estacionesDeBomberos.add((EstacionDeBomberos)hectareasConEstacionesDeBomberos.get(i).obtenerSuperficie().obtenerConstruccion());
		}
		return estacionesDeBomberos;
	}
}
