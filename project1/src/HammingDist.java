import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HammingDist {

	String[] vehicleID = new String [20];
	private String output;
	
	public HammingDist(String string, String string2) {
		//create counter for hammingDist
		int hammingDist1 = 0; // counter for strings of hammingDist 1
		int hammingDist2 = 0; // counter for strings of hammingDist 2
		int hammingDist4 = 0; // counter for strings of hammingDist 4
		
		if(string == string2)	{
			String toReverse = "";
			for (int a = toReverse.length(); a >= 0; a--)	{
				toReverse = toReverse + toReverse.charAt(a);
				//using char indexes within a loop to read through each char and reverse the order
				//Stack overflow use to figure out how to reverse an array
			}
		}
		
		for(int b3 = 0; b3 <= vehicleID.length; ++b3) {
			for(int a3 = 0; a3 <= vehicleID.length; ++a3) {
				if(vehicleID[a3].charAt(3) != vehicleID[b3].charAt(3) && (vehicleID[a3].charAt(4) != vehicleID[b3].charAt(4)) && (vehicleID[a3].charAt(0) == vehicleID[b3].charAt(0)))	{
					hammingDist2++;
					//potential error because if string was reversed this would also increment
				}
			}
		}
		for(int b = 0; b <= vehicleID.length; ++b) {
			for(int a = 0; a <= vehicleID.length; ++a) {
				if(vehicleID[a].charAt(3) == vehicleID[b].charAt(3) || (vehicleID[a].charAt(4) == vehicleID[b].charAt(4)))	{
					hammingDist1++;
				}
			}
		}
		for(int b2 = 0; b2 <= vehicleID.length; ++b2) {
			for(int a2 = 0; a2 <= vehicleID.length; ++a2) {
				if(vehicleID[a2].charAt(3) == vehicleID[b2].charAt(3) && (vehicleID[a2].charAt(4) == vehicleID[b2].charAt(4)) && (vehicleID[a2].charAt(0) != vehicleID[b2].charAt(0)))	{
					hammingDist4++;
				}
			}
		}
		
		String a = "" + hammingDist1;
		output = a;
	}
	
	
	public HammingDist(String string) {
		//count input with instance variable
		//for if walk through and say if there is missing value
		output = "The second vehicle is missing.";
	}
	
	public int getCountZero()	{
		//if char = 0 at index 5 counter += 1
		int counter = 0;
		for(int a = 0; a < vehicleID.length; ++a) {
			if(vehicleID[a].charAt(4) == '0')	{
				counter++;
			}
		}
		output = "Number of vehicles ended with zero: " + counter;
	}

	public int getArraySize()	{
		return vehicleID.length;
	}
	
	public void fileReader() {

		File vanet = new File("vanetp1data.txt");
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(vanet);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputFile.nextLine();
		int i = 0;
		
		while(inputFile.hasNextLine())	{
			
			if(i == getArraySize()) {
				vehicleID = Arrays.copyOf(vehicleID, getArraySize() + 1);
			}
			inputFile.next();
			inputFile.next();
			vehicleID[i] = inputFile.next().toUpperCase();
			++i;
			inputFile.nextLine();		
		}
		inputFile.close();
	}
	
	public HammingDist()	{
		output = "The inputs are empty.";
	}
	
	// need a loop and figure out how to compare 00 to all other arrays in the system 
	// create a for loop and then iterate and have counter to see if it is different values and count the hamming
	
	@Override
	public String toString()	{
		return output;
	}
		
	
	//("The Hamming distance between " + string + "and " + string2 + "is " + hammingDist + "between " string + "and " + string2 "is "hammingDist + ".");
	
	
	/*
	 * 
	 * individually can compare vehicle1 to vehicle2 with separate copied arrays and then increment amount of vehicles with hamming 0,1,2,3
	 * assign newVehicle2 as the reversed string in the array
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
}
