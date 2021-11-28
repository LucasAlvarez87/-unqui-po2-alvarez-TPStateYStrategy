package arcade;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ArcadeTestCase {
	private Arcade arcade;
	private Pantalla pantalla;
	private Ranura ranura;
	
	@BeforeEach
	public void setUp() {
		pantalla = mock(Pantalla.class);
		ranura = mock(Ranura.class);
		arcade = new Arcade(pantalla, ranura);
	}
	
	@Test
	public void arcadeConstruir(){
		assertEquals(ranura, arcade.getRanura());
		assertEquals(pantalla, arcade.getPantalla());
		assert(arcade.getEstado() instanceof Inicial );
	}
	
	@Test
	public void testElArcadeDelegaAlEstado(){
		arcade.encender(1);
		verify(pantalla).mostrar("Ingresar fichas");
		verify(ranura).abrir();
		verify(ranura).cerrar();
	}
	
	@Test
	public void testEstadoSeEncargaAlEncender() {
		EstadoDeMaquina spy = Mockito.spy(arcade.getEstado());
		arcade.setEstado(spy);
		arcade.encender(1);
		Mockito.verify(spy).ingresarFichas(1);
	}
	
	@Test
	public void testAlIngresarUnaFichaSuEstadoCambia() {
		arcade.encender(1);
		assert(arcade.getEstado() instanceof PartidaParaUno);
	}
	
	@Test
	public void testAlIngresarDosFichasSuEstadoCambia() {
		arcade.encender(2);
		assert(arcade.getEstado() instanceof PartidaParaDos);
	}
	
}
