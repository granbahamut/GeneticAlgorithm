package co.com.ivancho.objects;

import java.util.logging.Level;
import java.util.logging.Logger;

import co.com.ivancho.utils.NumberUtils;

/**
 * @author ASUS
 * 
 * Defines de type Chromosome, a basic genetic structure that contains n genes, acording to the <code>size</code> variable.
 * 
 */
public class Chromosome {
	
	private static Logger logger = Logger.getLogger(Chromosome.class.getName());
	
	private int size = 1;
	private int[] genes;
	private double fitness = 0;
	
	public Chromosome(int size) {
		this.size = size;
		genes = new int[this.size];
		setRandomGenes();
	}
	
	public void setCustomChromosome(int[] customValues) {
		if(customValues.length != genes.length) {
			throw new UnsupportedOperationException("Los cromosomas deben ser de igual tamaño.");
		}
		for (int i = 0; i < customValues.length; i++) {
			genes[i] = customValues[i];
		}
		logger.log(Level.INFO, "Se inyectó el gen ");
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		if(size < 1) {
			throw new UnsupportedOperationException("Debe haber al menos un gen en el cromosoma.");
		}
		this.size = size;
	}
	
	public int[] getGenes() {
		return genes;
	}

	public void setRandomGenes() {
		for (int i = 0; i < genes.length; i++) {
			genes[i] = NumberUtils.getRandomNumberInRange(Constants.geneRange.GENE_MIN_VALUE.getValue(), Constants.geneRange.GENE_MAX_VALUE.getValue());
		}
		fitness = 0;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public void calculateFitness() {
		double tempFitness = 0;
		for (int i = 0; i < genes.length; i++) {
			tempFitness += (double)genes[i] / Constants.geneRange.GENE_MAX_VALUE.getValue();
		}
		fitness = tempFitness / genes.length;
	}
}
