package mp3;

public class Reproduciendo extends EstadoDeReproduccion {
	
	private Song cancion;
	
	public Reproduciendo(SistemaMp3 mp3, Song cancion) {
		super(mp3);
		this.cancion = cancion;
	}

	@Override
	public void play(Song cancion) throws Exception {
		throw new Exception("Error ya se esta reproduciendo una cancion");

	}

	@Override
	public void pause() throws Exception {
		this.cancion.pause();
		this.getMp3().setEstado(new Pausado(this.getMp3(),this.cancion));
	}

	@Override
	public void stop() {
		this.cancion.stop();
		this.getMp3().setEstado(new SeleccionDeCanciones(mp3));

	}
	
}
