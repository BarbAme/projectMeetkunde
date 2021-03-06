package implementatie;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Testen {
	public static void main(String[] args) throws FileNotFoundException {
		try {
	        PrintStream out = new PrintStream(new FileOutputStream(
	            "outputTijd.txt"));
	        out.println("tijd");

	      } catch (FileNotFoundException e) {
	        e.printStackTrace();
	      }
		try
		{
		   
		String filename= "outputK_gem.txt";
		FileWriter writer = new FileWriter(filename);
		writer.write("");
		writer.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		try
		{
		   
		String filename4= "outputK_max.txt";
		FileWriter writer = new FileWriter(filename4);
		writer.write("");
		writer.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		
		String invoer;
		long tijd = 999;
		
		//algoritme(s) hier ingeven
		int algoritmeMin = 3;
		int algoritmeMax = 3;
		
		//aantal iteraties hier ingeven
		int aantalIteraties = 1;
		ArrayList<Integer> aantalPunten = new ArrayList<Integer>();
		ArrayList<Long> tijdNodig = new ArrayList<Long>();
		PrintStream out = new PrintStream(new FileOutputStream(
	            "result_algoritme_"+algoritmeMin + " - " + algoritmeMax +".txt"));
		out.println("test");
		for (int runs = 0; runs < aantalIteraties; runs ++){
		for (int d = 2; d <3; d++)
		{
			for(int alg = algoritmeMin; alg <= algoritmeMax; alg ++){
				
				//aantal punten hier ingeven
				for(int aantal = 100; aantal < 10001; aantal = aantal *2)
				{
					
					PuntenNaarFile.puntenMaken(d, aantal, alg);
					invoer = ("invoerpunten.txt");
					tijd = Main.uitvoeren(invoer, alg, d, aantal);
					
					aantalPunten.add(aantal);
					tijdNodig.add(tijd);
					try
					{
					    String filename5= "outputTijd.txt";
					    FileWriter fw = new FileWriter(filename5,true); //the true will append the new data
					    fw.write(tijd + " ");//appends the string to the file
					    fw.close();
					}
					catch(IOException ioe)
					{
					    System.err.println("IOException: " + ioe.getMessage());
					}
					
					out.println("algoritme: "+alg);
					out.println("dimensie: " +d);
					out.println("aantal: " +aantal);
					out.println("tijd: "+tijd);
					out.println();
				}
				//System.out.println("Algoritme "+alg);
			}
		}
		try
		{
		    String filename2= "outputK_gem.txt";
		    FileWriter fw = new FileWriter(filename2,true); //the true will append the new data
		    fw.write("\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		try
		{
		    String filename3= "outputK_max.txt";
		    FileWriter fw = new FileWriter(filename3,true); //the true will append the new data
		    fw.write("\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		try
		{
		    String filename5= "outputTijd.txt";
		    FileWriter fw = new FileWriter(filename5,true); //the true will append the new data
		    fw.write("\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		
	
		System.out.println(runs);
		}
		
	
		
		out.close();
		System.out.println("Einde Testen");
		
//		System.out.println();
//		for (int i = 0; i < aantalPunten.size(); i++){
//			System.out.print(aantalPunten.get(i) + " " );	
//		}
		System.out.println();
		for (int i = 0; i < tijdNodig.size(); i++){
			System.out.print(tijdNodig.get(i) + " " );	
		}
		
	}

}
