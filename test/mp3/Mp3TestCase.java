package mp3;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Mp3TestCase {
	private SistemaMp3 mp3;
	private Song cancion;
	
	@BeforeEach
	public void setUP() {
		mp3 = new SistemaMp3();
		cancion = mock(Song.class);
	}
	
	@Test
	public void alIniciarSuEstadoEsSeleccionDeCanciones() {
		assert(mp3.getEstado() instanceof SeleccionDeCanciones);
	}
	
	@Test
	public void alPonerPlayCambiaSuEstado() throws Exception {
		mp3.play(cancion);
		verify(cancion).play();
		assert (mp3.getEstado() instanceof Reproduciendo);
	}
	
	@Test
	public void ponerPausaEnModoSeleccion() {
		assertThrows(Exception.class, () -> mp3.pause(), "Error no se esta reproduciendo una cancion" );
	}
	
	@Test
	public void alPonerStopEnSeleccionNoHaceNada() {
		EstadoDeReproduccion estadoEsperado = mp3.getEstado();
		mp3.stop();
		assertEquals(estadoEsperado, mp3.getEstado());;
		 
	}
	
	@Test
	public void alPonerPlayReproduciendoTiraError() throws Exception {
		mp3.play(cancion);
		assertThrows(Exception.class, () -> mp3.play(cancion), "Error ya se esta reproduciendo una cancion" );
	}
	
	@Test
	public void pausarUnaReproduccion() throws Exception {
		mp3.play(cancion);
		mp3.pause();
		Mockito.verify(cancion).pause();
		assert(mp3.getEstado() instanceof Pausado);
	}
	
	@Test
	public void stopAlReproducir() throws Exception {
		mp3.play(cancion);
		mp3.stop();
		Mockito.verify(cancion).stop();
		assert(mp3.getEstado() instanceof SeleccionDeCanciones);
	}
	
	@Test
	public void apretarPlayAlEstarPausado() throws Exception {
		mp3.play(cancion);
		mp3.pause();
		assertThrows(Exception.class, () -> mp3.play(cancion), "Error ya se esta reproduciendo una cancion" );
	}
	
	@Test
	public void apretarPauseAlEstarPausado() throws Exception {
		mp3.play(cancion);
		mp3.pause();
		mp3.pause();
		Mockito.verify(cancion, times(2)).play();
		assert (mp3.getEstado() instanceof Reproduciendo);
	}
	
	@Test
	public void apretarStopAlPausar() throws Exception {
		mp3.play(cancion);
		mp3.pause();
		mp3.stop();
		assert (mp3.getEstado() instanceof SeleccionDeCanciones );
	}
}
