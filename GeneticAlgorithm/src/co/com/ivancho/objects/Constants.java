package co.com.ivancho.objects;

import co.com.ivancho.exceptions.CustomException;

public class Constants {

	public enum geneRange {
		GENE_MIN_VALUE(1), GENE_MAX_VALUE(32);

		private final int value;

		geneRange(final int newValue) {
			value = newValue;
		}

		public int getValue() {
			return value;
		}
	}
	// Main values:
	private static int populationSize;
	private static int chromosomeSize;
	private static Chromosome targetChromosome;

	// Error messages:
	public static final String CHROMOSOME_SIZE_NOT_EQUAL = "Los cromosomas deben ser de igual tamaño.";
	public static final String CHROMOSOME_EMPTY = "Debe haber al menos un gen en el cromosoma.";
	public static final String UTILITARY_CLASS = "Esta clase no puede ser instanciada, es un utilitario.";
	public static final String POPULATION_NO_SIZE = "La población no puede ser menor a 1";
	public static final String CHROMOSOME_NOT_IN_RANGE = "El cromosoma tiene un alelo por fuera de los rangos permitidos";
	public static int getPopulationSize() {
		return populationSize;
	}
	
	public static void setPopulationSize(int populationSize) {
		if(populationSize < 1) {
			throw new CustomException(POPULATION_NO_SIZE);
		}
		Constants.populationSize = populationSize;
	}
	
	public static int getChromosomeSize() {
		return chromosomeSize;
	}
	
	public static void setChromosomeSize(int chromosomeSize) {
		if(chromosomeSize < 1) {
			throw new CustomException(CHROMOSOME_EMPTY);
		}
		Constants.chromosomeSize = chromosomeSize;
	}

	/**
	 * @return the targetChromosome
	 */
	public static Chromosome getTargetChromosome() {
		return targetChromosome;
	}

	/**
	 * @param targetChromosome the targetChromosome to set
	 */
	public static void setTargetChromosome(Chromosome targetChromosome) {
		if(targetChromosome.getGenes().length != chromosomeSize) {
			throw new CustomException(CHROMOSOME_SIZE_NOT_EQUAL);
		}
		Constants.targetChromosome = targetChromosome;
	}

}
