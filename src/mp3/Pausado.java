package mp3;

public class Pausado extends EstadoDeReproduccion {
	
	private Song cancion;
	
	public Pausado(SistemaMp3 mp3, Song cancion) {
		super(mp3);
		this.cancion = cancion;
	}

	@Override
	public void play(Song cancion) throws Exception {
		throw new Exception("Error ya se esta reproduciendo una cancion");

	}

	@Override
	public void pause() throws Exception {
		cancion.play();
		this.getMp3().setEstado(new Reproduciendo(mp3, cancion));
	}

	@Override
	public void stop() {
		this.getMp3().setEstado(new SeleccionDeCanciones(mp3));
	}

}
