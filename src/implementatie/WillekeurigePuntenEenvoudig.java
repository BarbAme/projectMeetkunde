package implementatie;
import java.text.DecimalFormat;

//simpele manier om willekeurige coordinaten te krijgen voor M = 2
//output vanuit console kopiëren en opslaan als .txt
//comma's moeten nog door punten vervangen worden


public class WillekeurigePuntenEenvoudig {
	
	public static void main(String[] args) {
		int aantalPunten=50;
		int i=0;
		
			while (i<aantalPunten){
				i++;
				double pointX = Math.random();
				double pointY = Math.random();
				
				DecimalFormat numberFormat = new DecimalFormat("0.000000000000000");
				
				//output
				System.out.println(numberFormat.format(pointX) + " " + numberFormat.format(pointY));
			}
		


		}
	}

