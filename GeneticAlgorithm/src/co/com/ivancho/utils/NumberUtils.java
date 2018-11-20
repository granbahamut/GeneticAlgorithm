package co.com.ivancho.utils;

import java.util.Random;

import co.com.ivancho.exceptions.CustomException;
import co.com.ivancho.objects.Constants;

public class NumberUtils {

	private NumberUtils() {
		throw new IllegalStateException(Constants.UTILITARY_CLASS);
	}

	public static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new CustomException("max must be greater than min");
		}

		return new Random().nextInt((max - min) + 1) + min;
	}
}
