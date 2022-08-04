import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class LetterAvg {

	String[] vehicleID = new String[20];
	public String output;
	private char input;
	String[] newArray = new String[getArraySize()];

	/**
	 * This is a method to construct a value for the length of the array without
	 * specifcially saying array.length
	 * 
	 * @return the length of the array so its value can be used andcannot be changed
	 *         in another class
	 */
	public int getArraySize() {
		return vehicleID.length;
		// creates a method for the length of the array but is private so can ensure it
		// stays constant throughout the code
	}

	/**
	 * This reads the file skipping lines and info not needed and fills the array
	 * according and extending th earray as needed
	 * 
	 * @throws FileNotFoundException in case the file name does not exist
	 */
	public void fileReader() throws FileNotFoundException {

		File vanet = new File("VANETdata.txt");
		Scanner inputFile = new Scanner(vanet);
		inputFile.nextLine();
		inputFile.nextLine();
		inputFile.nextLine();
		int i = 0;

		while (inputFile.hasNextLine()) {

			if (i == getArraySize()) {
				vehicleID = Arrays.copyOf(vehicleID, getArraySize() + 1);
			}

			inputFile.next(); // skips dataS1 by not assigning anything
			vehicleID[i] = inputFile.next(); // takes the VehicleID and reads it and assigns it to a spot in the array
			++i; // increments the array to make sure the array isn't overridden at that index
			inputFile.nextLine(); // goes to next line and the loop starts over
		}
		inputFile.close(); // closes scanner
	}

	/**
	 * Constructor for casting the char given in the consturctor
	 * 
	 * @param letterAverage cast as char fo rpurpose of seeing what string we are
	 *                      pulling from the file
	 */
	public LetterAvg(Object letterAverage) {
		// Auto-generated constructor stub
		input = (char) letterAverage;
	}

	/**
	 * This counts the number of vehicles which
	 * 
	 * @return counter which counts how many times the letterAvg is found
	 * @throws FileNotFoundException in case file name cannot be found
	 */
	public int numberOfVehicleWithLetterAvg() throws FileNotFoundException {
		// Auto-generated method stub
		fileReader();

		int counter = 0;
		for (int i = 0; i < getArraySize(); i++) {
			if (vehicleID[i].charAt(0) == input)
				counter++;

		}
		return counter;
	}

	/**
	 * This calculates the number of strings that start with the average letter of
	 * the strings in the file
	 * 
	 * @throws FileNotFoundException in case file name cannot be found
	 */
	public void letterAvg() throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		fileReader();
		int j = 0;
		for (int i = 0; i < getArraySize(); i++) {
			if (vehicleID[i].charAt(0) == input) {
				newArray[j] = vehicleID[i];
				j++;
			}
		}
	}

	/**
	 * this allows me to print out anything as a string by assigning output the
	 * value of the string I want to output
	 * 
	 * @return output output is a string created in the class and is used to
	 *         override toString to print whatever message I want
	 */
	@Override
	public String toString() {
		try {
			letterAvg();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg = "These vehicles are: ";
		StringJoiner join = new StringJoiner(" ", "", "");
		for (int i = 0; i < newArray.length; i++) {
			if (newArray[i] != null) {
				join.add((newArray[i]));
			}
		}
		output = msg + join.toString();

		return output;

	}
}