import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HammingDist {

	String[] vehicleID = new String [20];
	
	public HammingDist(String string, String string2) {
		//create counter for hammingDist
		int hammingDist1 = 0; // counter for strings of hammingDist 1
		
		if(string == string2)	{
			reverse(string2);
		}
	}
	
	public void HammingDist(String string) {
		System.out.println("The second vehicle is missing");
	}
	
	public void getCountZero()	{
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			 
			
	}
	public void fileReader()	{

		File vanet = new File("vanetp1data.txt");
		Scanner inputFile = new Scanner(vanet);
		inputFile.nextLine();
		int i = 0;
		
		while(inputFile.hasNextLine())	{
			inputFile.next();
			inputFile.next();
			vehicleID[i] = inputFile.next().toUpperCase();
			++i;
			inputFile.nextLine();
			if ((vehicleID.length < vanet.length()) && inputFile.hasNextLine())	{
				String[] copyOfArray = Arrays.copyOf(vehicleID, i + 1);
			}
					
		}
		 inputFile.close();
		}
	public int HammingDist()	{
		int hammingDist = 0;
		
		return hammingDist;
	}
	
	
	
	
}
