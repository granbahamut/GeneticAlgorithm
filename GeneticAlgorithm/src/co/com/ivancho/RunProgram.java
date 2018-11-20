package co.com.ivancho;

import co.com.ivancho.objects.Chromosome;
import co.com.ivancho.objects.Constants;
import co.com.ivancho.objects.Population;
import co.com.ivancho.utils.StringUtils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RunProgram {

	private static Logger logger = null;
	
	static {
	    System.setProperty("java.util.logging.SimpleFormatter.format",
	        "[%1$tF %1$tT] [%4$-7s] %5$s %n");
	    logger = Logger.getLogger(RunProgram.class.getName());
	}
	
	public static void main(String[] args) {
		
		Constants.setChromosomeSize(6);
		Constants.setPopulationSize(20);
		Constants.setTargetChromosome(new Chromosome(new int[] {32, 32, 32, 32, 32, 32}));
		Population p = new Population();
		
		for (int i = 0; i < p.getIndividuals().length; i++) {
			String a = String.format("Chromosome %d : %s",i , StringUtils.printChromosome(p.getIndividuals()[i]));
			p.getIndividuals()[i].calculateFitness();
			String b = Double.toString(p.getIndividuals()[i].getFitness());
			String c = a + " /\t " + b;
			logger.log(Level.INFO, c);
		}
		
		p.getFittestIndividual();
		p.getSecondFittestIndividual();
		p.getLeastFittestIndividual();
		
		String a = String.format("Most fit chromosome: %s", StringUtils.printChromosome(p.mostFittest));
		logger.log(Level.INFO, a);
		
		a = String.format("Second most fit chromosome: %s", StringUtils.printChromosome(p.secondMostFittest));
		logger.log(Level.INFO, a);
		
		a = String.format("Least fit chromosome: %s", StringUtils.printChromosome(p.leastFittest));
		logger.log(Level.INFO, a);
	}
}
