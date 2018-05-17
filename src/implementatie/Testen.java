package implementatie;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Testen {
	public static void main(String[] args) throws FileNotFoundException {
		String invoer;
		long tijd = 999;
		int algoritme = 1;
		PrintStream out = new PrintStream(new FileOutputStream(
	            "result_algoritme_"+algoritme+".txt"));
		out.println("test");
		for (int d = 2; d < 10; d++)
		{
			for(int alg = 1; alg < 3; alg ++){
				algoritme = alg;
			
				for(int aantal = 5000; aantal < 5001; aantal = aantal + 1000)
				{
					PuntenNaarFile.puntenMaken(d, aantal, algoritme);
					invoer = ("OutFile"+aantal+"p"+d+"d"+".txt");
					tijd = Main.uitvoeren(invoer, algoritme, d, aantal);
					
					out.println("algoritme: "+algoritme);
					out.println("dimensie: " +d);
					out.println("aantal: " +aantal);
					out.println("tijd: "+tijd);
					out.println();
				}
			}
		}
		out.close();
		System.out.println("Einde Testen");
	}

}
