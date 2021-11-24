package encriptacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasarANumeros extends EstrategiaEncriptador {

	@Override
	public String encriptar(String texto) {
		String abecedario = " abcdefghijklmnñopqrstuvwxyz";
		String enMinuscula = texto.toLowerCase();
		List<Integer> encriptado = new ArrayList<Integer>();
		for (int i=0; i < enMinuscula.length(); i++) {
			Character letraActual = enMinuscula.charAt(i);
			int numeroDeLetra = abecedario.indexOf(letraActual);
			encriptado.add( numeroDeLetra);
		}
		return encriptado.toString().replace("[", "").replace("]","").replace(" ", "");
	}

	@Override
	public String desencriptar(String texto) {
		String abecedario = " abcdefghijklmnñopqrstuvwxyz";
		List<String> numeros = Arrays.asList(texto.split(","));
		List<Character> encriptado = new ArrayList<Character>();
		for (int i=0; i < numeros.size(); i ++) {
			String x =  numeros.get(i);
			int y = Integer.valueOf(x);
			char letra = abecedario.charAt(y);
			encriptado.add(letra);
		}
		return encriptado.toString().replace(",","").replace("[", "").replace("]","").replace("0", " ");
	}

}
