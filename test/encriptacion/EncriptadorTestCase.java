package encriptacion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EncriptadorTestCase {
	public static void main(String[] args) {
		 PasarANumeros pasarANumeros = new PasarANumeros();
		 EncriptadorNaive encriptador = new EncriptadorNaive(pasarANumeros);
		 System.out.print(encriptador.encriptar("Casa de papel"));
	}
	
	private EncriptadorNaive encriptador;
	private CambiarVocales cambiarVocales;
	private PasarANumeros pasarANumeros;
	private String texto;
	
	@BeforeEach
	public void setUp() {
		texto = "Casa de papel";
		cambiarVocales = new CambiarVocales();
		pasarANumeros = new PasarANumeros();
	}
		
	@Test
	public void testEncriptarConVocales() {
		encriptador = new EncriptadorNaive(cambiarVocales);
		assertEquals("Cese di pepil", encriptador.encriptar(texto));
	}
	
	@Test 
	public void testDesencriptarConVocales() {
		encriptador = new EncriptadorNaive(cambiarVocales);
		String textoEncriptado = encriptador.encriptar(texto);
		assertEquals("Casa de papel", encriptador.desencriptar(textoEncriptado));
	}
	
	@Test
	public void testEncriptarConNumeros() {
		encriptador = new EncriptadorNaive(pasarANumeros);
		assertEquals("3,1,20,1,0,4,5,0,17,1,17,5,12", encriptador.encriptar(texto));
	}
	
	@Test
	public void testDesencriptarConNumeros() {
		encriptador = new EncriptadorNaive(pasarANumeros);
		String encriptado = encriptador.encriptar(texto);
		assertEquals("casa de papel", encriptador.desencriptar(encriptado));
	}
}
