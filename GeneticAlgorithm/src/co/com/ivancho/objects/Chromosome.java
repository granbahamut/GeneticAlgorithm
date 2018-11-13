package co.com.ivancho.objects;

import co.com.ivancho.utils.NumberUtils;

public class Chromosome {
	
	private int size = 1;
	private int[] genes;
	private int fitness = 0;
	
	public Chromosome(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		if(size < 1) {
			throw new UnsupportedOperationException("Debe haber al menos un gen en el cromosoma-");
		}
		this.size = size;
	}
	
	public int[] getGenes() {
		return genes;
	}

	public void setRandomGenes() {
		if(null == genes) {
			throw new NullPointerException("Los cromosomas aún no están instanciados.");
		} else {
			for (int i = 0; i < genes.length; i++) {
				genes[i] = NumberUtils.getRandomNumberInRange(Constants.geneRange.GENE_MIN_VALUE.getValue(), Constants.geneRange.GENE_MAX_VALUE.getValue());
			}
			fitness = 0;
		}
	}

	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
	
	public void calculateFitness() {
		
		for (int i = 0; i < genes.length; i++) {
			
		}
	}
}
