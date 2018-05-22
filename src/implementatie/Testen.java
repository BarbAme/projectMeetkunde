package implementatie;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Testen {
	public static void main(String[] args) throws FileNotFoundException {
		String invoer;
		long tijd = 999;
		int algoritmeMin = 3;
		int algoritmeMax = 3;
		ArrayList<Integer> aantalPunten = new ArrayList<Integer>();
		ArrayList<Long> tijdNodig = new ArrayList<Long>();
		PrintStream out = new PrintStream(new FileOutputStream(
	            "result_algoritme_"+algoritmeMin + " - " + algoritmeMax +".txt"));
		out.println("test");
		for (int d = 2; d <3; d++)
		{
			for(int alg = algoritmeMin; alg <= algoritmeMax; alg ++){
				
				for(int aantal = 5000; aantal < 100001; aantal = aantal + 5000)
				{
					
					PuntenNaarFile.puntenMaken(d, aantal, alg);
					invoer = ("OutFile"+aantal+"p"+d+"d"+".txt");
					tijd = Main.uitvoeren(invoer, alg, d, aantal);
					
					aantalPunten.add(aantal);
					tijdNodig.add(tijd);
					
					out.println("algoritme: "+alg);
					out.println("dimensie: " +d);
					out.println("aantal: " +aantal);
					out.println("tijd: "+tijd);
					out.println();
				}
				System.out.println("Algoritme "+alg);
			}
		}
		out.close();
		System.out.println("Einde Testen");
		
		System.out.println();
		for (int i = 0; i < aantalPunten.size(); i++){
			System.out.print(aantalPunten.get(i) + " " );	
		}
		System.out.println();
		for (int i = 0; i < tijdNodig.size(); i++){
			System.out.print(tijdNodig.get(i) + " " );	
		}
	}

}
