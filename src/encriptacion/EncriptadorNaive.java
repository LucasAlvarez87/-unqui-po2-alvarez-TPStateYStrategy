package encriptacion;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EncriptadorNaive {
	
	private EstrategiaEncriptador estrategia;

	public EncriptadorNaive(EstrategiaEncriptador estrategia) {
		super();
		this.estrategia = estrategia;
	}

	public EstrategiaEncriptador getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(EstrategiaEncriptador estrategia) {
		this.estrategia = estrategia;
	}

	public String encriptar(String texto) {
		return this.getEstrategia().encriptar(texto);
	}
	
	public String desencriptar(String texto) {
		return this.getEstrategia().desencriptar(texto);
	}
	
}
