package co.com.ivancho.utils;

import java.util.Arrays;

import co.com.ivancho.objects.Chromosome;

public class StringUtils {
	
	private StringUtils() {
		throw new IllegalStateException("Esta clase no puede ser instanciada, es un utilitario.");
	}
	
	public static String printChromosome(Chromosome c) {
		
		if(null == c) {
			throw new NullPointerException("Cromosoma vacío.");
		}
		
		String t = "";
		t = Arrays.toString(c.getGenes());
		return t;
	}
}
