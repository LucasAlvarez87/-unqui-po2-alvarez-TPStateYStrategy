package mp3;

public class SeleccionDeCanciones extends EstadoDeReproduccion {

	public SeleccionDeCanciones(SistemaMp3 mp3) {
		super(mp3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play(Song cancion) throws Exception {
		cancion.play();
		this.getMp3().setEstado(new Reproduciendo(mp3,cancion));
	}

	@Override
	public void pause() throws Exception {
		throw new Exception("Error no se esta reproduciendo una cancion");
		
	}

	@Override
	public void stop() {
		// No hace nada
		
	}

}
