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

//simpele manier om willekeurige coordinaten te krijgen voor M = 2
//zet output meteen in txt file
//, moeten nog wel . worden


public class PuntenNaarFile {
	
	public static void main(String[] args) {
		int aantalPunten=100000;
		int i=0;
		DecimalFormat numberFormat = new DecimalFormat("0.000000000000000");
			
				
				
			    try {
			        PrintStream out = new PrintStream(new FileOutputStream(
			            "OutFile100000.txt"));
			        while (i<aantalPunten){
						i++;
						double pointX = Math.random();
						double pointY = Math.random();
			          out.println(numberFormat.format(pointX) + " " + numberFormat.format(pointY));
			        }
			        out.close();

			      } catch (FileNotFoundException e) {
			        e.printStackTrace();
			      }

		


	}
}

