package mp3;

public class SistemaMp3 {
	
	EstadoDeReproduccion estado;
	
	public SistemaMp3() {
		super();
		this.estado = new SeleccionDeCanciones(this);
	}
	
	public EstadoDeReproduccion getEstado() {
		return estado;
	}

	public void setEstado(EstadoDeReproduccion estado) {
		this.estado = estado;
	}

	public void play(Song cancion) throws Exception{
		this.getEstado().play(cancion);
	}
	

	public void pause()throws Exception {
		this.getEstado().pause();
	}
	
	public void stop() {
		this.getEstado().stop();
	}
	
}
