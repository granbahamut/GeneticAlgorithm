package co.com.ivancho;

import co.com.ivancho.objects.Chromosome;
import co.com.ivancho.utils.StringUtils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RunProgram {

	private static Logger logger = Logger.getLogger(RunProgram.class.getName());
	
	public static void main(String[] args) {
		Chromosome c = new Chromosome(6);
		c.setCustomChromosome(new int[] {32, 32, 32, 32, 32, 32});
		c.calculateFitness();
		logger.log(Level.INFO, "Fitness: " + c.getFitness());
		logger.log(Level.INFO, "Cromosome: {0}", StringUtils.printChromosome(c));
	}
}
