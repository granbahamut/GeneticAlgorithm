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
	private int mostFittest;
	private int secondMostFittest;
	private int leastFittest;
	private Random rand = new Random();
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
	
	public void selection() {
		getFittestIndividual();
		getSecondFittestIndividual();
		getLeastFittestIndividual();
	}
	
	public int getFittestIndividual() {
		double maxFit = Integer.MIN_VALUE;
		int maxFittestIndex = 0;
		
		for (int i = 0; i < individuals.length; i++) {
			if(maxFit <= individuals[i].getFitness()) {
				maxFit = individuals[i].getFitness();
				maxFittestIndex = i;
			}
		}
		mostFittest = maxFittestIndex;
		return mostFittest;
	}
	
	public int getSecondFittestIndividual() {
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
		secondMostFittest = maxFitIndex2;
		return maxFitIndex2;
	}
	
	public int getLeastFittestIndividual() {
		double minFit = Integer.MAX_VALUE;
		int minFittestIndex = 0;
		
		for (int i = 0; i < individuals.length; i++) {
			if(minFit >= individuals[i].getFitness()) {
				minFit = individuals[i].getFitness();
				minFittestIndex = i;
			}
		}
		leastFittest = minFittestIndex;
		return leastFittest;
	}
	

	public void crossover() {
		
		int crossoverPoint = rand.nextInt(Constants.getChromosomeSize());
		
		for (int i = 0; i < crossoverPoint; i++) {
			int tempGene = individuals[mostFittest].getGenes()[i];
			individuals[mostFittest].getGenes()[i] = individuals[secondMostFittest].getGenes()[i];
			individuals[secondMostFittest].getGenes()[i] = tempGene;
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

	/**
	 * @return the mostFittest
	 */
	public int getMostFittest() {
		return mostFittest;
	}

	/**
	 * @param mostFittest the mostFittest to set
	 */
	public void setMostFittest(int mostFittest) {
		this.mostFittest = mostFittest;
	}

	/**
	 * @return the secondMostFittest
	 */
	public int getSecondMostFittest() {
		return secondMostFittest;
	}

	/**
	 * @param secondMostFittest the secondMostFittest to set
	 */
	public void setSecondMostFittest(int secondMostFittest) {
		this.secondMostFittest = secondMostFittest;
	}

	/**
	 * @return the leastFittest
	 */
	public int getLeastFittest() {
		return leastFittest;
	}

	/**
	 * @param leastFittest the leastFittest to set
	 */
	public void setLeastFittest(int leastFittest) {
		this.leastFittest = leastFittest;
	}

}
