package mp3;

public abstract class EstadoDeReproduccion {
	
	SistemaMp3 mp3;
	
	public SistemaMp3 getMp3() {
		return mp3;
	}

	public EstadoDeReproduccion(SistemaMp3 mp3) {
		super();
		this.mp3 = mp3;
	}
	
	public abstract void play(Song cancion) throws Exception;

	public abstract void pause() throws Exception ;
	
	public abstract void stop();

}	
