package Modelo;
import java.util.*;
import java.io.*;

import Modelo.Excepciones.ExcepcionCoordenadasFueraDelMapa;

public class Mapa {
	
	private ArrayList<ArrayList<Hectarea>> hectareas;
	private int ancho;//Remover
	private int alto;//Remover
	private ArrayList<Hectarea> hectaresConCentralElectrica;
	private ArrayList<Hectarea> hectareasConEstacionesDeBomberos;
	
	/*Deprecated - Remover*/
	public Mapa(int ancho, int alto){
		
		this.ancho = ancho;
		this.alto  = alto;		
		hectareas = new ArrayList<ArrayList<Hectarea>>();
		
		/*Crea la estructura*/
		for(int i=0;i<this.alto;i++){
			ArrayList<Hectarea> arrayFila = new ArrayList<Hectarea>();
			this.hectareas.add(i,arrayFila);			
		}
		
		/*Rellena con hectareas*/
		for (int i=0;i<this.alto;i++){
			
			ArrayList<Hectarea> fila = this.hectareas.get(i);			
			for (int j=0;j<this.ancho;j++){
				Hectarea hectarea = new Hectarea(i,j);
				Superficie superficie = new Tierra();
				hectarea.asignarSuperficie(superficie);
				fila.add(j,hectarea);
			}
		}
		
	}
	
	public Mapa(){
		this.hectareas = new ArrayList<ArrayList<Hectarea>>();
		this.hectaresConCentralElectrica = new ArrayList<Hectarea>();
		this.hectareasConEstacionesDeBomberos = new ArrayList<Hectarea>();
	}
	
	public void cargarMapa(){
		//abrir el archivo
		String nombreDeArchivo = "Mapas//MapaFacil.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(nombreDeArchivo));
			if(verificarUniformidadDeDimensionesDeMapaEnArchivoDeMapa(nombreDeArchivo)){
				//leer una linea
				String linea = br.readLine();
				int i = 0;
				//LOOP (mientras no sea fin del archivo)
				while (linea != null) {
					//crear un ArrayList de Hectareas "fila"
					ArrayList<Hectarea> fila = new ArrayList<Hectarea>();
					//LOOP
					for (int j=0;j < linea.length();j++){
						Hectarea hectarea = new Hectarea(j,i);
						//leer caracter x del string
						//crear una hectarea de tierra o agua segun el caracter
						if (linea.charAt(j) == 'T'){
							Tierra tierra = new Tierra();
							hectarea.asignarSuperficie(tierra);
						};
						if (linea.charAt(j) == 'A'){
							Agua agua = new Agua();
							hectarea.asignarSuperficie(agua);
							//System.out.println("Fila ->"+i);
							//System.out.println(linea.charAt(j));
							//System.out.println(j);
						};				
						//agregar la hectarea a la posicion j de la columna
						fila.add(j, hectarea);			
					}
					//agregar "columna" al ArrayList "hectareas" en la posicion i
					this.hectareas.add(i,fila);	
					//leer una linea
					linea = br.readLine();
					//actualizar contador
					i ++;
				}
			}
			br.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		this.ancho = hectareas.get(0).size();
		this.alto  = hectareas.size();
		
	}
	
	public Hectarea obtenerHectareaEnPosicion(int x, int y){
		
		if (!coordenadaExisteDentroDelMapa(x,y) ){
			throw new ExcepcionCoordenadasFueraDelMapa("Coordenadas fuera de mapa");
		}
		ArrayList<Hectarea> fila = this.hectareas.get(y);
		Hectarea hectarea = fila.get(x);		
		return hectarea;
	}
	
	public ArrayList<Hectarea> obtenerHectareasAledanias(Hectarea hectarea){
		int x = hectarea.getCoordenadaX();
		int y = hectarea.getCoordenadaY();
		ArrayList<Hectarea> hectareasAledanias= new ArrayList<Hectarea>();
		
		//Recopila todas las hectareas en un area de 3x3 con centro en la hectarea actual
		for (int i= y-1;i <= y+1; i++){
			for (int j= x-1;j <= x+1; j++){
				if(this.coordenadaExisteDentroDelMapa(j, i)){
					hectareasAledanias.add(this.obtenerHectareaEnPosicion(j,i));
				}
			}		
		}
		//Se remueve la hectarea actual para dejar solo las aledanias
		hectareasAledanias.remove(hectarea);
		return hectareasAledanias;
	}
	
	public ArrayList<Hectarea> obtenerHectareasAledanias(Hectarea hectarea, int radio){
		int x = hectarea.getCoordenadaX();
		int y = hectarea.getCoordenadaY();
		ArrayList<Hectarea> hectareasAledanias= new ArrayList<Hectarea>();
		
		//Recopila todas las hectareas en un area de radioXradio con centro en la hectarea actual
		for (int i= y-radio;i <= y+radio; i++){
			for (int j= x-radio;j <= x+radio; j++){
				if(this.coordenadaExisteDentroDelMapa(j, i)){
					hectareasAledanias.add(this.obtenerHectareaEnPosicion(j,i));
				}
			}		
		}
		//Se remueve la hectarea actual para dejar solo las aledanias
		hectareasAledanias.remove(hectarea);
		return hectareasAledanias;
	}
	
	public void aplicarTerremoto( int x , int y ){
		
		Hectarea epicentro = this.obtenerHectareaEnPosicion(x, y);
		Terremoto terremoto = new Terremoto( epicentro );
		ArrayList<Hectarea> fila;
		for (int j=0;j<this.alto;j++){
			fila = this.hectareas.get(j);			
			for (int i=0;i<this.ancho;i++){
				terremoto.aplicarDanio(fila.get(i));
			}
		}
	}
	
	public boolean coordenadaExisteDentroDelMapa(int x, int y){
		int alto= this.hectareas.size();
		int ancho= this.hectareas.get(0).size();
		
		return((x>=0)&(y>=0)&(x<ancho)&(y<alto));
	}
	
	protected boolean verificarUniformidadDeDimensionesDeMapaEnArchivoDeMapa(String nombreDeArchivo){
		boolean dimensionesUniformes = true;
		try{
			BufferedReader br = new BufferedReader(new FileReader(nombreDeArchivo));
			String linea = br.readLine();
			//Toma el tamanio de la primera linea
			int tamanioDeLinea = linea.length();
			//Si alguna es distinta, las dimensiones no son uniformes
			while(linea != null){
				if (! (tamanioDeLinea == linea.length()) ){
					dimensionesUniformes = false;
				}
				linea = br.readLine();
			}			
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dimensionesUniformes;
	}

	public boolean puedoConstruirResidencia(int x,int y) {
		
		Hectarea unaHectarea = this.obtenerHectareaEnPosicion(x, y);
		boolean superficieApta = unaHectarea.obtenerSuperficie().puedoConstruirResidencia();
		boolean tieneAccesoAServicios = this.tieneAccesoAServicios(unaHectarea,Residencial.serviciosRequeridos());
		return (superficieApta && tieneAccesoAServicios);
		}
	
	private boolean tieneAccesoAServicios(Hectarea unaHectarea,
			ArrayList<ServiciosRequeridos> serviciosRequeridos) {
		boolean tieneLuz = true;
		boolean tieneAgua = true;
		boolean tieneAccesoARuta = true;

		if(serviciosRequeridos.contains(ServiciosRequeridos.LUZ)){
			tieneLuz = this.tieneAccesoALuzLaHectarea(unaHectarea);
		}
		
		if(serviciosRequeridos.contains(ServiciosRequeridos.RUTA)){
			tieneAccesoARuta = this.tieneAccesoARutaLaHectarea(unaHectarea);
		}
		
		if(serviciosRequeridos.contains(ServiciosRequeridos.AGUA)){
			tieneAgua = this.tieneAccesoAAgua(unaHectarea);
		}
		
		return (tieneLuz && tieneAgua && tieneAccesoARuta);
	}
	
	private boolean tieneAccesoAAgua(Hectarea unaHectarea) {
		
		return true;
	}
	
	public boolean puedoConstruirComercio(int x,int y) {
		
		Hectarea unaHectarea = this.obtenerHectareaEnPosicion(x, y);
		boolean superficieApta = unaHectarea.obtenerSuperficie().puedoConstruirComercio();
		boolean tieneAccesoAServicios = this.tieneAccesoAServicios(unaHectarea,Comercial.serviciosRequeridos());
		return (superficieApta && tieneAccesoAServicios);
	}
	
	public boolean puedoConstruirIndustria(int x,int y) {
		
		Hectarea unaHectarea = this.obtenerHectareaEnPosicion(x, y);
		boolean superficieApta = unaHectarea.obtenerSuperficie().puedoConstruirIndustria();
		boolean tieneAccesoAServicios = this.tieneAccesoAServicios(unaHectarea,Industrial.serviciosRequeridos());
		return (superficieApta && tieneAccesoAServicios);
	}
	
	/*
	 * Chequea si se puede construir en esas coordenadas, una construccion terrestre
	 * que no necesita servicios (ruta, centrales electricas, bomberos, etc.) 
	 */
	public boolean puedoConstruirEdificioTerrestreSinServicios(int x,int y) {
		
		Hectarea unaHectarea = this.obtenerHectareaEnPosicion(x, y);
		return unaHectarea.obtenerSuperficie().puedoConstruirEdificioTerrestre();
	}
	
	public boolean puedoConstruirPozoDeAgua(int x,int y) {
		
		Hectarea unaHectarea = this.obtenerHectareaEnPosicion(x, y);
		return unaHectarea.obtenerSuperficie().puedoConstruirPozoDeAgua();
	}

	

	private boolean tieneAccesoALuzLaHectarea(Hectarea unaHectarea) {
		
		
		ArrayList<Hectarea> hectareasAledanias = this.obtenerHectareasAledanias(unaHectarea);
		boolean vecinoConLuz = false;
		int i = 0;
		
		while( i < hectareasAledanias.size() && (!vecinoConLuz)){
				if(hectareasAledanias.get(i).obtenerSuperficie().tieneLuz())
					vecinoConLuz = true;
			i++;
		}
		if(vecinoConLuz)
			return true;
		else
			return this.tieneCentralElectricaCercana(unaHectarea);
		
	}

	private boolean tieneCentralElectricaCercana(Hectarea unaHectarea) {
		
		boolean alimentadaPorCentral = false;
		int i = 0;
		
		while ((i < this.hectaresConCentralElectrica.size())&&(!alimentadaPorCentral)){
			Hectarea hectareaConCentral = this.hectaresConCentralElectrica.get(i);
			CentralElectrica unaCentral = (CentralElectrica)hectareaConCentral.obtenerSuperficie().obtenerConstruccion();
			int distanciaEntreHectareas = unaHectarea.calcularDistancia(hectareaConCentral);
			int radioDeLaCentral = unaCentral.obtenerRadio();
			
			if(distanciaEntreHectareas <= radioDeLaCentral){
				alimentadaPorCentral = true;
			}
			i++;
		}
		
		return alimentadaPorCentral;
	}

	private boolean tieneAccesoARutaLaHectarea(Hectarea unaHectarea) {
		
		ArrayList<Hectarea> hectareasAledanias = this.obtenerHectareasAledanias(unaHectarea);
		boolean accesoARuta = false;
		int i = 0;
		
		while( i < hectareasAledanias.size() && (!accesoARuta)){
			if(hectareasAledanias.get(i).obtenerSuperficie().tieneConstruccion())
				if(hectareasAledanias.get(i).obtenerSuperficie().obtenerConstruccion().esRuta())
					accesoARuta = true;
			i++;
		}
		return accesoARuta;
	}
	
	/*Deprecated - Remover*/
	public int getAncho(){
		return this.ancho;
	}
	
	/*Deprecated - Remover*/
	public int getAlto(){
		return this.alto;
	}
	
	public void construirResidencial(int x, int y){
		if (this.puedoConstruirResidencia(x, y)){
			Hectarea unaHectarea = this.obtenerHectareaEnPosicion(x, y);
			unaHectarea.construirResidencial();
		}
	}
	
	public void construirIndustrial(int x, int y){
		if (this.puedoConstruirIndustria(x, y)){
			Hectarea unaHectarea = this.obtenerHectareaEnPosicion(x, y);
			unaHectarea.construirIndustrial();
		}
	}
	
	public void construirComercial(int x, int y){
		if (this.puedoConstruirComercio(x, y)){
			Hectarea unaHectarea = this.obtenerHectareaEnPosicion(x, y);
			unaHectarea.construirComercial();
		}
	}
	
	public void construirCentralEolica(int x, int y){
		if (this.puedoConstruirEdificioTerrestreSinServicios(x, y)){
			Hectarea unaHectarea = this.obtenerHectareaEnPosicion(x, y);
			unaHectarea.construirCentralEolica();
			this.hectaresConCentralElectrica.add(unaHectarea);
		}
	}
	
	public void construirCentralNuclear(int x, int y){
		if (this.puedoConstruirEdificioTerrestreSinServicios(x, y)){
			Hectarea unaHectarea = this.obtenerHectareaEnPosicion(x, y);
			unaHectarea.construirCentralNuclear();
			this.hectaresConCentralElectrica.add(unaHectarea);
		}
	}
	
	public void construirCentralMineral(int x, int y){
		if (this.puedoConstruirEdificioTerrestreSinServicios(x, y)){
			Hectarea unaHectarea = this.obtenerHectareaEnPosicion(x, y);
			unaHectarea.construirCentralMineral();
			this.hectaresConCentralElectrica.add(unaHectarea);
		}
	}
	
	public void construirRutaPavimentada(int x, int y){
		if (this.puedoConstruirEdificioTerrestreSinServicios(x, y)){
			Hectarea unaHectarea = this.obtenerHectareaEnPosicion(x, y);
			unaHectarea.construirRutaPavimentada();
		}
	}
	
	
	public void construirPozoDeAgua(int x, int y){
		if (this.puedoConstruirPozoDeAgua(x, y)){
			Hectarea unaHectarea = this.obtenerHectareaEnPosicion(x, y);
			unaHectarea.construirPozoDeAgua();
		}
	}
	public void construirEstacionDeBomberos(int x, int y){
		if (this.puedoConstruirEdificioTerrestreSinServicios(x, y)){
			Hectarea unaHectarea = this.obtenerHectareaEnPosicion(x, y);
			unaHectarea.construirEstacionDeBomberos();
			this.hectareasConEstacionesDeBomberos.add(unaHectarea);
		}
	}
	
	public boolean puedoConstruirRutaEnVariasHectares(Hectarea origen,Hectarea destino) {
		
		boolean puedoConstruir = true;
		int i;
		int distanciaEntreHectareas = origen.calcularDistancia(destino);
		if(origen.getCoordenadaX() == destino.getCoordenadaX()){
			int coordenadaFija = origen.getCoordenadaX();
			if(origen.getCoordenadaY() < destino.getCoordenadaY()){
				i = origen.getCoordenadaY();
			}
			else{
				i = destino.getCoordenadaY();
			}
			for(int j = i; j < distanciaEntreHectareas;j++){
				puedoConstruir = this.puedoConstruirEdificioTerrestreSinServicios(coordenadaFija, j);
			}
		}
		else{
			int coordenadaFija = origen.getCoordenadaY();
			if(origen.getCoordenadaX() < destino.getCoordenadaX()){
				i = origen.getCoordenadaX();
			}
			else{
				i = destino.getCoordenadaX();
			}
			for(int j = i; j < distanciaEntreHectareas;j++){
				puedoConstruir = this.puedoConstruirEdificioTerrestreSinServicios(j,coordenadaFija);
			}
		}
		return puedoConstruir;
	} 
	
	//Construye rutas solo en linea recta
		public void construirRutaPavimentada(Hectarea origen, Hectarea destino) {
			
			if(origen.getCoordenadaX() == destino.getCoordenadaX()){
				if(origen.getCoordenadaY() <= destino.getCoordenadaY())
					this.construirRutaEnDireccionY(origen,destino);
				else
					this.construirRutaEnDireccionY(destino,origen);
			}
			else{
				if(origen.getCoordenadaX() <= destino.getCoordenadaX())
					this.construirRutaEnDireccionX(origen,destino);
				else
					this.construirRutaEnDireccionX(destino,origen);
				
			}
			
			

		}
	
	private void construirRutaEnDireccionX(Hectarea inicio, Hectarea fin) {
		
		int coordenadaY = inicio.getCoordenadaY();
		int colInicial = inicio.getCoordenadaX();
		int colFinal = fin.getCoordenadaX();
		Hectarea unaHectarea;
		for (int i = colInicial; i <= colFinal;i++ ){
			unaHectarea = this.obtenerHectareaEnPosicion(i, coordenadaY );
			unaHectarea.construirRutaPavimentada();
		}
		
	}

	private void construirRutaEnDireccionY(Hectarea inicio, Hectarea fin) {
		
		int coordenadaX = inicio.getCoordenadaX();
		int filInicial = inicio.getCoordenadaY();
		int filFinal = fin.getCoordenadaY();
		Hectarea unaHectarea;
		for (int i = filInicial; i <= filFinal;i++ ){
			unaHectarea = this.obtenerHectareaEnPosicion( coordenadaX, i );
			unaHectarea.construirRutaPavimentada();
		}
	}
	
	public boolean puedoConstruirLineasDeTension(Hectarea origen) {
	
		if(origen.obtenerSuperficie().tieneConstruccion()){	
			boolean elOrigenEsCentralElectrica = origen.obtenerSuperficie().obtenerConstruccion().esCentralElectrica();
			boolean elOrigenTieneLineaConectada = origen.obtenerSuperficie().tieneLuz();
			return (elOrigenEsCentralElectrica || elOrigenTieneLineaConectada);
		}
		else
		{
			return (origen.obtenerSuperficie().tieneLuz());
		}
	}

	//Construye lineas de tension solo en linea recta
	public void construirLineasDeTension(Hectarea origen, Hectarea destino) {
		
		if(origen.getCoordenadaX() == destino.getCoordenadaX()){
			if(origen.getCoordenadaY() <= destino.getCoordenadaY())
				this.crearTensionEnDireccionY(origen,destino);
			else
				this.crearTensionEnDireccionY(destino,origen);
		}
		else{
			if(origen.getCoordenadaX() <= destino.getCoordenadaX())
				this.crearTensionEnDireccionX(origen,destino);
			else
				this.crearTensionEnDireccionX(destino,origen);
			
		}
		
		

	}

	private void crearTensionEnDireccionX(Hectarea inicio, Hectarea fin) {
		
		int coordenadaY = inicio.getCoordenadaY();
		int colInicial = inicio.getCoordenadaX();
		int colFinal = fin.getCoordenadaX();
		Hectarea unaHectarea;
		for (int i = colInicial; i <= colFinal;i++ ){
			unaHectarea = this.obtenerHectareaEnPosicion(i, coordenadaY );
			unaHectarea.crearLineaDeTension();
		}
		
	}

	private void crearTensionEnDireccionY(Hectarea inicio, Hectarea fin) {
		
		int coordenadaX = inicio.getCoordenadaX();
		int filInicial = inicio.getCoordenadaY();
		int filFinal = fin.getCoordenadaY();
		Hectarea unaHectarea;
		for (int i = filInicial; i <= filFinal;i++ ){
			unaHectarea = this.obtenerHectareaEnPosicion( coordenadaX, i );
			unaHectarea.crearLineaDeTension();
		}
	}
	
	
	//Construye tuberias solo en linea recta
		
	public void construirTuberiaDeAgua(Hectarea origen, Hectarea destino) {
			
		if(origen.getCoordenadaX() == destino.getCoordenadaX()){
			if(origen.getCoordenadaY() <= destino.getCoordenadaY())
				this.crearTuberiaDeAguaEnDireccionY(origen,destino);
			else
				this.crearTuberiaDeAguaEnDireccionY(destino,origen);
		}
		else{
			if(origen.getCoordenadaX() <= destino.getCoordenadaX())
				this.crearTuberiaDeAguaEnDireccionX(origen,destino);
			else
				this.crearTuberiaDeAguaEnDireccionX(destino,origen);
				
			}
	}

	private void crearTuberiaDeAguaEnDireccionX(Hectarea inicio, Hectarea fin) {
			
		int coordenadaY = inicio.getCoordenadaY();
		int colInicial = inicio.getCoordenadaX();
		int colFinal = fin.getCoordenadaX();
		Hectarea unaHectarea;
		for (int i = colInicial; i <= colFinal;i++ ){
			unaHectarea = this.obtenerHectareaEnPosicion(i, coordenadaY );
			unaHectarea.crearTuberiaDeAgua();
		}
		
	}

	private void crearTuberiaDeAguaEnDireccionY(Hectarea inicio, Hectarea fin) {
			
		int coordenadaX = inicio.getCoordenadaX();
		int filInicial = inicio.getCoordenadaY();
		int filFinal = fin.getCoordenadaY();
		Hectarea unaHectarea;
		for (int i = filInicial; i <= filFinal;i++ ){
			unaHectarea = this.obtenerHectareaEnPosicion( coordenadaX, i );
			unaHectarea.crearTuberiaDeAgua();
		}
	}
		
	public void guardarMapaEnArchivoDeTexto()
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("Mapas//mapaResultado.txt");
            pw = new PrintWriter(fichero);
            String linea = "";
            for (int i = 0; i < this.alto; i++){
            	linea = "";
            	for (int j = 0;j<this.ancho;j++){
            		linea = linea + this.obtenerHectareaEnPosicion(j, i).dibujarSuperficie();
            	}
                pw.println(linea);
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
	
	public int obtenerAncho(){
		return this.hectareas.get(0).size();
	}
	
	public int obtenerAlto(){
		return this.hectareas.size();
	}
	
	public boolean tieneAlMenosUnaEstacionDeBomberos(){
		return (this.hectareasConEstacionesDeBomberos.size() > 0);
	}
	
	public ArrayList<Hectarea> obtenerHectareasConEstacionesDeBomberos(){
						
		return this.hectareasConEstacionesDeBomberos;
	}
}
