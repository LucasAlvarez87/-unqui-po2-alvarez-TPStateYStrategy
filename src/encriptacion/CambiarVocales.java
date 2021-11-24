package encriptacion;

import java.util.Arrays;
import java.util.List;

public class CambiarVocales extends EstrategiaEncriptador {

	@Override
	public String encriptar(String texto) {
		char[] ch = texto.toCharArray();
		for (int i=0; i < ch.length - 1; i++) {
			if (this.esVocal(ch[i]) ) {
				ch[i] = this.proximaVocalEncriptar(ch[i]);
			}
		}
		String encriptado = new String(ch);
		return encriptado;
	}
	
	private char proximaVocalEncriptar(char c) {
		if (Character.isLowerCase(c)){
			List<Character> vocales = Arrays.asList('a','e','i','o','u');
			if (c == 'u') {
				return 'a';
			}
			else {
				return vocales.get(vocales.indexOf(c)+1);
			}
		}
		else {
			List<Character> vocales = Arrays.asList('A','E','I','O','U');
			if (c == 'U') {
				return 'A';
			}
			else {
				return vocales.get(vocales.indexOf(c)+1);
			}
		}
	}

	private boolean esVocal(char c) {
		List<Character> vocales = Arrays.asList('a','e','i','o','u');
		return vocales.contains(c);
	}
	
	@Override
	public String desencriptar(String texto) {
		char[] ch = texto.toCharArray();
		for (int i=0; i < ch.length - 1; i++) {
			if (this.esVocal(ch[i]) ) {
				ch[i] = this.anteriorVocal(ch[i]);
			}
		}
		String encriptado = new String(ch);
		return encriptado;
	}
 	
	private char anteriorVocal(char c) { 
	if (Character.isLowerCase(c)){
		List<Character> vocales = Arrays.asList('a','e','i','o','u');
		if (c == 'a') {
			return 'u';
		}
		else {
			return vocales.get(vocales.indexOf(c)-1);
		}
	}
	else {
		List<Character> vocales = Arrays.asList('A','E','I','O','U');
		if (c == 'A') {
			return 'u';
		}
		else {
			return vocales.get(vocales.indexOf(c)-1);
		}
	}
}

}
