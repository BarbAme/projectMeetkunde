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
import java.util.ArrayList;


//import java.io.BufferedReader;
//import java.io.FileReader;

public class EenvoudigAlgoritme {
	public static void main(String[] args) {
	
		//punten inlezen
		ArrayList <Point2D.Double> punten = puntenInlezen();
		long tijdA = System.currentTimeMillis();
		//terug te geven
		double d = Double.POSITIVE_INFINITY;
		Point2D.Double dpp1 = new Point2D.Double();
		Point2D.Double dpp2 = new Point2D.Double();
		
		//voor berekeningen
		double afst;
		Point2D.Double a = new Point2D.Double();
		Point2D.Double b = new Point2D.Double();
		
		//aantal punten
		int aantalP = punten.size();
		
		int i=0;
		int j;
		
		while(i<aantalP){
			//alle punten overlopen
			j = i+1;
			while (j<aantalP){
				//alle resterende punten overlopen
				a = punten.get(i);
				b = punten.get(j);
				afst = Afstand(punten.get(i), punten.get(j));
				
				if (afst < d){
					dpp1 = a;
					dpp2 = b;
					d = afst;
				}
				j++;
			}
			i++;
		}
		long tijd = System.currentTimeMillis() - tijdA;
		//resultaat printen
		System.out.println("Aantal Punten " + aantalP + "\n" + "Punt1 " + dpp1 + "\n"+ "Punt2 " + dpp2 + "\n"+  "Afstand " + d + "\n" + "Tijd "+ tijd);
		
		//resultaat in file
		Output(dpp1,dpp2,d,tijd);

	}


	public static ArrayList<Point2D.Double> puntenInlezen(){
	//punten inlezen van textfile als Point2D.Double 
		
		//lijst om punten in op te slaan
		ArrayList <Point2D.Double> punten = new ArrayList <Point2D.Double>(0) ;
		try {
			
			//input file
	        File f = new File("OutFile10000.txt");				//TODO bij final, input.txt
	        BufferedReader b = new BufferedReader(new FileReader(f));
	
	        //lijn per lijn inlezen
	        String readLine = "";
	
	        //zolang einde niet bereikt
	        while ((readLine = b.readLine()) != null) {
	        	
	        	//lijn splitsen om coordinaten te krijgen
	        	String[] splitted = readLine.split(" ");
	        	
	        	//coordinaten van string naar double
	        	double valueX = Double.parseDouble(splitted[0]);
	        	double valueY = Double.parseDouble(splitted[1]);
	        	
	        	//point aanmaken
	        	Point2D.Double temp = new Point2D.Double(valueX,valueY);
	        	
	        	//point in lijst zetten
	        	punten.add(temp);
	
	            
	        }
	        b.close();
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
//		System.out.println(punten);
		return punten;
	}

	public static double Afstand(Point2D.Double a, Point2D.Double b){
		//afstand tussen 2 punten berekenen		
		double tempX = Math.pow((a.getX()-b.getX()),2);
		double tempY = Math.pow((a.getY()-b.getY()),2);
		
		double afstand = Math.sqrt(tempX+tempY);
		
		return afstand;
	}

	public static void Output(Point2D.Double a, Point2D.Double b, double afstand, long duur){
		try {
	        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
	        
	        DecimalFormat f = new DecimalFormat("0.000000000000000");
		    DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
		    sym.setDecimalSeparator('.');
		   f.setDecimalFormatSymbols(sym);	
		    
	        out.println(f.format(a.getX()) + " " + f.format(b.getX()));
	        out.println(f.format(a.getY()) + " " + f.format(b.getY()));
	        out.println(f.format(afstand));
	        out.println(duur);
			        
	        out.close();

	      } catch (FileNotFoundException e) {
	        e.printStackTrace();
	      }
	}
}

