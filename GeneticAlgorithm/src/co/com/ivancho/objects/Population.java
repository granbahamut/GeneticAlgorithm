/**
 * 
 */
package co.com.ivancho.objects;

import java.util.Random;

import co.com.ivancho.exceptions.CustomException;

/**
 * Creates a population of chromosomes given the size required.
 * @author ipinilla
 *
 */
public class Population {
	
	private Chromosome[] individuals;
	private int generation = 1;
	public Chromosome mostFittest;
	public Chromosome secondMostFittest;
	public Chromosome leastFittest;
	/**
	 * Constructor to create a custom population
	 */
	public Population() {
		if(Constants.getPopulationSize() < 1) {
			throw new CustomException(Constants.POPULATION_NO_SIZE);
		} else {
			individuals = new Chromosome[Constants.getPopulationSize()];
		}
		
		for (int i = 0; i < individuals.length; i++) {
			individuals[i] = new Chromosome();
		}
	}
	
	public Chromosome getFittestIndividual() {
		double maxFit = Integer.MIN_VALUE;
		int maxFittestIndex = 0;
		
		for (int i = 0; i < individuals.length; i++) {
			if(maxFit <= individuals[i].getFitness()) {
				maxFit = individuals[i].getFitness();
				maxFittestIndex = i;
			}
		}
		mostFittest = individuals[maxFittestIndex];
		return mostFittest;
	}
	
	public Chromosome getSecondFittestIndividual() {
		int maxFitIndex1 = 0;
		int maxFitIndex2 = 0;
		
		for (int i = 0; i < individuals.length; i++) {
			if(individuals[i].getFitness() > individuals[maxFitIndex1].getFitness()) {
				maxFitIndex2 = maxFitIndex1;
				maxFitIndex1 = i;
			} else if (individuals[i].getFitness() > individuals[maxFitIndex2].getFitness()) {
				maxFitIndex2 = i;
			}
		}
		secondMostFittest = individuals[maxFitIndex2];
		return individuals[maxFitIndex2];
	}
	
	public Chromosome getLeastFittestIndividual() {
		double minFit = Integer.MAX_VALUE;
		int minFittestIndex = 0;
		
		for (int i = 0; i < individuals.length; i++) {
			if(minFit >= individuals[i].getFitness()) {
				minFit = individuals[i].getFitness();
				minFittestIndex = i;
			}
		}
		leastFittest = individuals[minFittestIndex];
		return leastFittest;
	}
	

	public void crossover() {
		Random rn = new Random();
		int crossoverPoint = rn.nextInt(Constants.getChromosomeSize());
		
		for (int i = 0; i < crossoverPoint; i++) {
			int tempGene = mostFittest.getGenes()[i];
			mostFittest.getGenes()[i] = secondMostFittest.getGenes()[i];
			secondMostFittest.getGenes()[i] = tempGene;
		}
	}
	
	public Chromosome[] getIndividuals() {
		return individuals;
	}
	
	public void setIndividuals(Chromosome[] individuals) {
		this.individuals = individuals;
	}

	/**
	 * @return the generation
	 */
	public int getGeneration() {
		return generation;
	}

	/**
	 * @param generation the generation to set
	 */
	public void setGeneration(int generation) {
		this.generation = generation;
	}

}
