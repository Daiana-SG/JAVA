package Modelo.Excepciones;


	public class ExcepcionCrearConstruccionSinServiciosRequeridos extends RuntimeException{
	
		public ExcepcionCrearConstruccionSinServiciosRequeridos(String mensaje){
			super ("La construccion no se puede crear por falta se servicios requeridos");
			}
}
