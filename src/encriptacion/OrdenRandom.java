package encriptacion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdenRandom extends EstrategiaEncriptador {

	@Override
	public String encriptar(String texto) {
		List<String> words = Arrays.asList(texto.split(" "));
		Collections.shuffle(words);
		String encriptado = new String();
		return words.toString().replace(",","").replace("[", "").replace("]","");
	}
	
	@Override
	public String desencriptar(String texto) {
		return null;
	}

	
}
