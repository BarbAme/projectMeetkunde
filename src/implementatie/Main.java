package implementatie;

import java.awt.geom.Point2D;
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

public class Main {
	//static int algoritme = 0;
	//static int M = 0;
	//static int aantal = 0;
	//static double[][] punten = null;

	
	public static void main(String[] args) {
		int algoritme = 0;
		int M = 0;
		int aantal = 0;
		double[][] punten = null;
		punten = puntenInlezen(algoritme, M, aantal, punten);
		System.out.println("algoritme: " + algoritme + " " + "dimensie: "+  M);
		Arrays.sort(punten, (a, b) -> Double.compare(a[0], b[0]));
		//print2D(punten);
		
		switch(algoritme){
		case 1: EenvoudigAlgoritme(aantal, M,punten);
		case 2: EersteVarAlgoritme(aantal, M,punten);
		case 3: TweedeVarAlgoritme(aantal, M,punten);
		}
		
	}
	public static long uitvoeren(String invoer, int alg, int dim, int ant){
		int algoritme = alg;
		int M = dim;
		int aantal = ant;
		double[][] punten = null;
		long tijd = 999;;
		punten = puntenInlezen(invoer, algoritme, M, aantal, punten);
		System.out.println("algoritme: " + algoritme + " " + "dimensie: "+  M);
		Arrays.sort(punten, (a, b) -> Double.compare(a[0], b[0]));
		switch(algoritme){
		case 1: tijd =EenvoudigAlgoritme(aantal, M,punten);
		break;
		case 2: tijd =EersteVarAlgoritme(aantal, M,punten);
		break;
		case 3: tijd =TweedeVarAlgoritme(aantal, M,punten);
		break;
		}
		return tijd;
	}
	public static double[][] puntenInlezen(int algoritme, int M, int aantal,double[][] punten){
		//punten inlezen van textfile als array
		
			
			try {
				
				//input file
		        File f = new File("OutFile1000p2d.txt");				//TODO bij final, input.txt
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
	public static double[][] puntenInlezen(String invoer,int algoritme, int M, int aantal,double[][] punten){
	//punten inlezen van textfile als array
	
		
		try {
			
			//input file
	        File f = new File(invoer);				//TODO bij final, input.txt
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
	

	
	public static long EenvoudigAlgoritme(int aantal, int M,double[][] punten){
		long tijd1 = System.currentTimeMillis();
		double d = Double.POSITIVE_INFINITY;
		double afst = 0;
		int dpp1 = 0;
		int dpp2 = 0;
		for(int i=0;i<aantal;i++){
			for(int j=i+1;j<aantal;j++){
			
				afst = Afstand(i,j,M,punten);
				
				if ( afst < d){
					d = afst;
					dpp1 = i;
					dpp2 = j;
				}
			}
		}
		long duur = System.currentTimeMillis() - tijd1;
		Output(dpp1,dpp2,d,duur, punten, M);
		return duur;
		
	}
	public static long EersteVarAlgoritme(int aantal, int M,double[][] punten){
		long tijd1 = System.currentTimeMillis();
		double d = Double.POSITIVE_INFINITY;
		double afst = 0;
		int dpp1 = 0;
		int dpp2 = 0;
		int j = 0;
		for(int i=0;i<aantal;i++){
			j = i+1;
			while ((j<aantal)&&(Math.abs(punten[i][0]-punten[j][0])<d)){
				afst = Afstand(i,j,M,punten);
				if ( afst < d){
					d = afst;
					dpp1 = i;
					dpp2 = j;
				}
				j++;
			}
		}
		long duur = System.currentTimeMillis() - tijd1;
		Output(dpp1,dpp2,d,duur, punten, M);
		return duur;
	}
	public static long TweedeVarAlgoritme(int aantal, int M,double[][] punten){
		//TODO
		return 999;
	}
	
	public static double Afstand(int a, int b, int M,double[][] punten){
		double som = 0;
		for (int i=0; i<M;i++){
			//som kwadraten verschil coordinaten
	
			som = som + Math.pow((punten[a][i]-punten[b][i]), 2);	
		}
		return Math.sqrt(som);
	}

    public static void print2D(double mat[][])
    {
        // Loop through all rows
        for (double[] row : mat)
 
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }
	public static void Output(int a, int b, double d, long duur, double[][] punten, int M){
		try {
	        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
	        
	        DecimalFormat f = new DecimalFormat("0.000000000000000");
		    DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
		    sym.setDecimalSeparator('.');
		   f.setDecimalFormatSymbols(sym);	
	        
	        for (int m=0; m<M;m++){
	        	//print 1e punt
				out.print(punten[a][m] + " " );
			}
			out.println();
		 for (int m=0; m<M;m++){
	        	//print 2e punt
				out.print(punten[b][m] + " " );
			}
			out.println();

			//afstand
	        out.println(f.format(d));
	        //uitvoeringstijd
	        out.println(duur);
			        
	        out.close();

	      } catch (FileNotFoundException e) {
	        e.printStackTrace();
	      }
		System.out.println("Done");
	}



}

