package co.com.ivancho.utils;

import java.util.Arrays;

import co.com.ivancho.exceptions.CustomException;
import co.com.ivancho.objects.Chromosome;
import co.com.ivancho.objects.Constants;

public class StringUtils {

	private StringUtils() {
		throw new IllegalStateException(Constants.UTILITARY_CLASS);
	}

	public static String printChromosome(Chromosome c) {

		if (null == c) {
			throw new CustomException(Constants.CHROMOSOME_EMPTY);
		}

		String t = "";
		t = Arrays.toString(c.getGenes());
		return t;
	}
}
