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
		logger.log(Level.INFO, "**********************************************Setup Phase**********************************************");
		Constants.setChromosomeSize(6);
		Constants.setPopulationSize(20);
		Constants.setTargetChromosome(new Chromosome(new int[] {32, 32, 32, 32, 32, 32}));
		Constants.setMutationRate(0.5);
		Population p = new Population();
		
		logger.log(Level.INFO, String.format("The values will be: \nChromosome size: %d \nPopulation size: %d \nTarget: %s \nMutation rate: %4$,.2f \n", Constants.getChromosomeSize(), Constants.getPopulationSize(), Constants.getTargetChromosome().getGenes().toString(), Constants.getMutationRate()));
		
		for (int i = 0; i < p.getIndividuals().length; i++) {
			String a = String.format("Chromosome %d : %s",i , StringUtils.printChromosome(p.getIndividuals()[i]));
			p.getIndividuals()[i].calculateFitness();
			String b = Double.toString(p.getIndividuals()[i].getFitness());
			String c = a + " /\t " + b;
			logger.log(Level.INFO, c);
		}
		logger.log(Level.INFO, "**********************************************Selection Phase**********************************************");
		p.selection();
		
		String a = String.format("Most fit chromosome: %s", StringUtils.printChromosome(p.getIndividuals()[p.getMostFittest()]));
		logger.log(Level.INFO, a);
		
		a = String.format("Second most fit chromosome: %s", StringUtils.printChromosome(p.getIndividuals()[p.getSecondMostFittest()]));
		logger.log(Level.INFO, a);
		
		a = String.format("Least fit chromosome: %s", StringUtils.printChromosome(p.getIndividuals()[p.getLeastFittest()]));
		logger.log(Level.INFO, a);
		logger.log(Level.INFO, "**********************************************Crossover Phase**********************************************");
		p.crossover();
		
		a = String.format("Most fit chromosome crossed: %s", StringUtils.printChromosome(p.getIndividuals()[p.getMostFittest()]));
		logger.log(Level.INFO, a);
		
		a = String.format("Second most fit chromosome crossed: %s", StringUtils.printChromosome(p.getIndividuals()[p.getSecondMostFittest()]));
		logger.log(Level.INFO, a);
		
		logger.log(Level.INFO, "**********************************************Mutation Phase**********************************************");
		p.getIndividuals()[p.getMostFittest()].mutate();
		
		a = String.format("Most fit chromosome was mutated: %s", StringUtils.printChromosome(p.getIndividuals()[p.getMostFittest()]));
		logger.log(Level.INFO, a);
		
	}
}
