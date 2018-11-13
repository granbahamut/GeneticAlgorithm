package co.com.ivancho.objects;

public class Constants {
	
	public enum geneRange{
		GENE_MIN_VALUE(1),
		GENE_MAX_VALUE(32);
		
		private final int value;
		
		geneRange(final int newValue){
			value = newValue;
		}
		
		public int getValue() {return value;}
	}
}
