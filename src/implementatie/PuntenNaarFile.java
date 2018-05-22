package implementatie;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

//simpele manier om willekeurige coordinaten te krijgen
//zet output meteen in txt file


public class PuntenNaarFile {
	
	
	public static void main(String[] args ) {
		int dim = 3;		//Waarde voor M, dimensie
		int aantalPunten=10000; //aantal punten
		int algoritme = 1;		//algoritme
		puntenMaken(dim,aantalPunten,algoritme);


	}
	public static void puntenMaken (int dimensie, int aantal, int alg){
		int dim = dimensie;		//Waarde voor M, dimensie
		int aantalPunten=aantal; //aantal punten
		int algoritme = alg;		//algoritme
		
		int i=0;
		DecimalFormat numberFormat = new DecimalFormat("0.000000000000000");
	    DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
	    sym.setDecimalSeparator('.');
	    numberFormat.setDecimalFormatSymbols(sym);	
				
				
			    try {
			        PrintStream out = new PrintStream(new FileOutputStream(
			            "OutFile"+aantalPunten+"p"+dim+"d1"+".txt"));
			        out.println(algoritme);
			        out.println(dim);
			        out.println(aantalPunten);
			        while (i<aantalPunten){
						i++;
						for (int m=0; m<dim;m++){
							double coord = Math.random();
							out.print(numberFormat.format(coord) + " " );
						}
						out.println();
			        }
			        out.close();

			      } catch (FileNotFoundException e) {
			        e.printStackTrace();
			      }

			    System.out.println("Done");
	}
}

