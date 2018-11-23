package co.com.ivancho.objects;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.com.ivancho.exceptions.CustomException;
import co.com.ivancho.utils.NumberUtils;

/**
 * Defines de type Chromosome, a basic genetic structure that contains n
 * genes, acording to the <code>size</code> variable.
 *         
 * @author ASUS      
 * 
 */
public class Chromosome {

	/**
	 * Logger for the class
	 */
	private static Logger logger = Logger.getLogger(Chromosome.class.getName());

	/**
	 * The gene array that contains the info for the chromosome object.
	 */
	private int[] genes;
	/**
	 * Indicates the average fitness acording to the goal of the program.
	 */
	private double fitness = 0;
	
	/**
	 * Constructor that uses the <code>size</code> parameter to set the amount of
	 * genes the chromosome will contain.
	 * 
	 * @param size
	 */
	public Chromosome() {
		genes = new int[Constants.getChromosomeSize()];
		setRandomGenes();
	}
	
	public Chromosome(int[] genes) {
		setCustomChromosome(genes);
	}

	/**
	 * Sets an array of custom values to initialize a chromosome object. If the
	 * input has more or less genes than the base chromosome, the custom chromosome
	 * cannot be created.
	 * 
	 * @param customValues
	 */
	public void setCustomChromosome(int[] customValues) {
		if (customValues.length != Constants.getChromosomeSize()) {
			throw new CustomException(Constants.CHROMOSOME_SIZE_NOT_EQUAL);
		}
		for (int i = 0; i < customValues.length; i++) {
			if(customValues[i] < Constants.geneRange.GENE_MIN_VALUE.getValue()
					|| customValues[i] > Constants.geneRange.GENE_MAX_VALUE.getValue()) {
				throw new CustomException(Constants.CHROMOSOME_NOT_IN_RANGE);
			}
		}
		genes = customValues;
		this.calculateFitness();
		logger.log(Level.INFO, "Se inyectó el gen ");
	}

	/**
	 * Returns the genes on a chromosome.
	 * 
	 * @return an array of genes.
	 */
	public int[] getGenes() {
		return genes;
	}

	/**
	 * Creates a random generated chromosome using the basic rules:<br>
	 * <ol type="1">
	 * <li>The method takes the minimum an maximum values needed to create a new
	 * gene.</li>
	 * <li>Any value between those max/min values can ve used.</li>
	 * <li>The newly generated chromosome will have the same size as parametrized
	 * the first time the Chromosome was created.</li>
	 * </ol>
	 */
	public void setRandomGenes() {
		for (int i = 0; i < genes.length; i++) {
			genes[i] = NumberUtils.getRandomNumberInRange(Constants.geneRange.GENE_MIN_VALUE.getValue(),
					Constants.geneRange.GENE_MAX_VALUE.getValue());
		}
		calculateFitness();
	}

	/**
	 * Returns the fitness of the choromosome.
	 * 
	 * @return the fitness of the choromosome.
	 */
	public double getFitness() {
		return fitness;
	}

	/**
	 * Calculates how close is a chromosome to reach the final goal. To calculate
	 * the fitness, all the gene values are summed and and the average is obtained,
	 * based on the size of the chromosome. The fitness values is taken from 1 to 0,
	 * beign 1 the chromosome that fits the most the goal, and 0 the opposite.
	 */
	public void calculateFitness() {
		double tempFitness = 0;
		for (int i = 0; i < genes.length; i++) {
			tempFitness += (double) genes[i] / Constants.geneRange.GENE_MAX_VALUE.getValue();
		}
		fitness = tempFitness / genes.length;
	}
	
	/**
	 * <p>
	 * Mutates a single gene of the chromosome, giving a customized value to it, calculated with the mutation rate:</br>
	 * <code>+/- R = M * P</code></br>
	 * where P = the mutation rate wich range is from 0 to 1, being 0 = no mutation and 1 = full random mutation;
	 * M = Max value a gene can take (see Constants.geneRange.GENE_MAX_VALUE).
	 * </p>
	 * <p>
	 * The value returned by this formula gives us a range wich will be used to add or substract to the gene that will be mutated, for example:</br>
	 * Given M = 32; P = 0.5; then R = +/- 16</br>
	 * R will be added/substracted to the value of the gene that will be selected to be mutated so, 
	 * if we have a gene with the values: [10, 13, 31, 1, 12, 23] and the algorithm chooses the 3rd 
	 * position to be mutated, the result will be [10, 13, <b>31+16</b>, 1, 12, 23] = [10, 13, <b>47</b>, 1, 12, 23]. But the max value for a gene 
	 * is M = 32, so the final value will be [10, 13, <b>32</b>, 1, 12, 23]
	 * </p>
	 * */
	public void mutate() {
		double range = Math.floor(Constants.geneRange.GENE_MAX_VALUE.getValue() * Constants.getMutationRate());
		int m = 0;
		if(range != 0) {
			m = (int) Math.floor(NumberUtils.getRandomNumberInRange(-range, range));
		}
		int g = this.genes[new Random().nextInt(this.genes.length)];
		g = g + m;
		//Rounds to 1 if its less than 1
		if(g < 1) {
			g = 1;
		//Rounds to GENE_MAX_VALUE if its greater than GENE_MAX_VALUE 
		} else if(g > Constants.geneRange.GENE_MAX_VALUE.getValue()) {
			g = Constants.geneRange.GENE_MAX_VALUE.getValue();
		}
		this.genes[new Random().nextInt(this.genes.length)] = g;
	}
}
