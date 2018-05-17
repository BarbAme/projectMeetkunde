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
	            "result_algoritme:"+algoritme+".txt"));
		for (int d = 2; d < 4; d++)
		{
			for(int aantal = 1000; aantal < 5000; aantal = aantal + 1000)
			{
				PuntenNaarFile.puntenMaken(d, aantal, algoritme);
				invoer = ("OutFile"+aantal+"p"+d+"d"+".txt");
				tijd = Main.uitvoeren(invoer);
				
				out.println("algoritme: "+algoritme);
				out.println("dimensie" +d);
				out.println("aantal" +aantal);
				out.println("tijd: "+tijd);
				out.close();
			}
		}
		System.out.println("Einde Testen");
	}

}
