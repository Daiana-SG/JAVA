package Modelo;

public class Jugador {
	
	private String nombre;
	private Mapa mapaDeJuego;
	private float dinero;
	private int energiaDisponible;
	
	
	public Jugador(String nombre, float dineroInicial){
		
		this.nombre = nombre;
		this.mapaDeJuego = null;
		this.dinero = dineroInicial;
		this.energiaDisponible = 0;
		
	}
	
	public void asignarMapa (Mapa unMapa){
		this.mapaDeJuego = unMapa;
	}
	
	public void construirResidencia(int x , int y ){
		if(  this.tengoEnergiaPara(Residencial.energiaNecesaria())&& this.tengoDineroPara(Residencial.costoDeConstruir())){
			if(mapaDeJuego.puedoConstruirResidencia(x,y)){
				mapaDeJuego.construirResidencial(x, y);
				this.restarDinero(Residencial.costoDeConstruir());
				this.restarEnergia(Residencial.energiaNecesaria());
			}
		}
	}
	

	private boolean tengoEnergiaPara(int energiaNecesaria) {
		
		return (energiaNecesaria <= this.energiaDisponible);
	}
	
	private void restarEnergia(int energiaUtilizada){
		this.energiaDisponible = this.energiaDisponible - energiaUtilizada;
	}
	
	private void agregarEnergia(int energiaAAgregar){
		this.energiaDisponible = this.energiaDisponible + energiaAAgregar;
	}
	
	public void construirComercio(int x , int y ){
		if(  this.tengoEnergiaPara(Comercial.energiaNecesaria())&& this.tengoDineroPara(Comercial.costoDeConstruir())){
			if(mapaDeJuego.puedoConstruirComercio(x,y)){
				mapaDeJuego.construirComercial(x, y);
				this.restarDinero(Comercial.costoDeConstruir());
				this.restarEnergia(Comercial.energiaNecesaria());
			}
		}
	}
	
	public void construirIndustria(int x , int y ){
		if(  this.tengoEnergiaPara(Industrial.energiaNecesaria())&& this.tengoDineroPara(Industrial.costoDeConstruir())){
			if(mapaDeJuego.puedoConstruirIndustria(x,y)){
				mapaDeJuego.construirIndustrial(x, y);
				this.restarDinero(Industrial.costoDeConstruir());
				this.restarEnergia(Industrial.energiaNecesaria());
			}
		}
	}
	public void construirRuta(int x , int y ){
		if( mapaDeJuego.puedoConstruirEdificioTerrestreSinServicios(x, y) && this.tengoDineroPara(RutaPavimentada.costoDeConstruir())){
			mapaDeJuego.construirRutaPavimentada(x,y);
			this.restarDinero(RutaPavimentada.costoDeConstruir());
		}
	}
	
	public void construirRuta(Hectarea origen , Hectarea destino ){
		int cantidadAConstruir = origen.calcularDistancia(destino)+1;
		if (mapaDeJuego.puedoConstruirRutaEnVariasHectares(origen, destino)&& this.tengoDineroPara(RutaPavimentada.costoDeConstruir()*cantidadAConstruir)){
			mapaDeJuego.construirRutaPavimentada(origen,destino);
			this.restarDinero(RutaPavimentada.costoDeConstruir()*cantidadAConstruir);
			}
	}
		
	public void construirPozoDeAgua(int x, int y){
		if (mapaDeJuego.puedoConstruirPozoDeAgua(x,y)&& this.tengoDineroPara(PozoDeAgua.costoDeConstruir())){
			mapaDeJuego.construirPozoDeAgua(x,y);
			this.restarDinero(PozoDeAgua.costoDeConstruir());
			}
		}

	public void construirCentralEolica (int x, int y){
		if (mapaDeJuego.puedoConstruirEdificioTerrestreSinServicios(x, y) && this.tengoDineroPara(CentralEolica.costoDeConstruir())){
			mapaDeJuego.construirCentralEolica(x, y);
			this.restarDinero(CentralEolica.costoDeConstruir());
			CentralElectrica unaCentral = (CentralElectrica)mapaDeJuego.obtenerHectareaEnPosicion(x, y).obtenerSuperficie().obtenerConstruccion();
			this.agregarEnergia(unaCentral.obtenerCapacidadDeAbast());
		}
	}
	
	public void construirCentralMineral (int x, int y){
		if (mapaDeJuego.puedoConstruirEdificioTerrestreSinServicios(x, y) && this.tengoDineroPara(CentralMineral.costoDeConstruir())){
			mapaDeJuego.construirCentralMineral(x, y);
			this.restarDinero(CentralMineral.costoDeConstruir());
			CentralElectrica unaCentral = (CentralElectrica)mapaDeJuego.obtenerHectareaEnPosicion(x, y).obtenerSuperficie().obtenerConstruccion();
			this.agregarEnergia(unaCentral.obtenerCapacidadDeAbast());
		}
	}
	
	public void construirCentralNuclear (int x, int y){
		if (mapaDeJuego.puedoConstruirEdificioTerrestreSinServicios(x, y) && this.tengoDineroPara(CentralNuclear.costoDeConstruir())){
			mapaDeJuego.construirCentralNuclear(x, y);
			this.restarDinero(CentralNuclear.costoDeConstruir());
			CentralElectrica unaCentral = (CentralElectrica)mapaDeJuego.obtenerHectareaEnPosicion(x, y).obtenerSuperficie().obtenerConstruccion();
			this.agregarEnergia(unaCentral.obtenerCapacidadDeAbast());
		}
	}

	public void construirEstacionDeBomberos(int x, int y) {
		if (mapaDeJuego.puedoConstruirEdificioTerrestreSinServicios(x,y)&& this.tengoDineroPara(EstacionDeBomberos.costoDeConstruir())){
			mapaDeJuego.construirEstacionDeBomberos(x, y);
			this.restarDinero(EstacionDeBomberos.costoDeConstruir());
			}
	}
	
	public void construirLineasDeTension(Hectarea origen, Hectarea destino) {
		int cantidadAConstruir = origen.calcularDistancia(destino);
		if (mapaDeJuego.puedoConstruirLineasDeTension( origen ) && this.tengoDineroPara(LineaDeTension.costoDeConstruir()*cantidadAConstruir)){
			mapaDeJuego.construirLineasDeTension(origen,destino);
			this.restarDinero(LineaDeTension.costoDeConstruir()*cantidadAConstruir);
			}
	}

	private boolean tengoDineroPara(int costo) {
		
		return ( costo <= this.dinero );
	}
	private boolean tengoDineroPara(float costoDeConstruir) {
		return (costoDeConstruir <= this.dinero);
	}

	private void restarDinero(float cantidadARestar) {
		
		this.dinero = this.dinero - cantidadARestar;
	}
	
	public float obtenerDineroDisponible(){
		return this.dinero; 
	}
	public String obtenerNombre() {

		return this.nombre;
	}

	public float obtenerDinero() {
	
		return this.dinero;
	}

	public Mapa obtenerMapa() {
	
		return this.mapaDeJuego;
	}

	public void jugar(){
		//TODO
	}
	
	
	
	
	

}
