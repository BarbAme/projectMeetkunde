package implementatie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
public class Sort {
	static int algoritme = 0;
	static int M = 0;
	static int aantal = 0;
	static double[][] punten = null;


	public static void main(String[] args) {
		punten = puntenInlezen();
		System.out.println("algoritme: " + algoritme + " " + "dimensie: "+  M);
		puntenSorteren();
		print2D(punten);
		
		
		
	}
    public static void print2D(double mat[][])
    {
        // Loop through all rows
        for (double[] row : mat)
 
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }

public static double[][] puntenInlezen(){
	//punten inlezen van textfile als array
	
		
		try {
			
			//input file
	        File f = new File("OutFile100.txt");				//TODO bij final, input.txt
	        BufferedReader b = new BufferedReader(new FileReader(f));
	
	        //lijn per lijn inlezen
	        String readLine = "";
	        
	        algoritme = Integer.parseInt(b.readLine());
	        M = Integer.parseInt(b.readLine());
	        aantal = Integer.parseInt(b.readLine());
	        
	        //lijst met punten in dimensie M
	        punten = new double[aantal][M];
	        
	        int i = 0;
	        
	        //zolang einde niet bereikt
	        while ((readLine = b.readLine()) != null) {
	        	
	        	//lijn splitsen om coordinaten te krijgen
	        	String[] splitted = readLine.split(" ");
	        	
	        	//coordinaten van string naar double in lijst zetten
	        	for (int m=0;m<M;m++){
	        		punten[i][m] =  Double.parseDouble(splitted[m]);

	        	}
	        	i++;

	        }
	        b.close();
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

		return punten;
	}


	public static void puntenSorteren()
	{
		Arrays.sort(punten, (a, b) -> Double.compare(a[0], b[0]));

	}



}
