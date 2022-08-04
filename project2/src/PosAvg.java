import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lakir
 *
 */
public class PosAvg {

	private String output;
	String[] vehicleID = new String[20];
	private String vehicleID1;

	/**
	 * This is a method to construct a value for the length of the array without
	 * specifcially saying array.length
	 * 
	 * @return the length of the array so its value can be used andcannot be changed
	 *         in another class
	 */
	private int getArraySize() {
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
			vehicleID[i] = inputFile.next(); // takes the VehicleId and reads it and assigns it to a spot in the array
			++i; // increments the array to make sure the array isn't overridden at that index
			inputFile.nextLine(); // goes to next line and the loop starts over
		}
		inputFile.close(); // closes scanner
	}

	/**
	 * This construtor calls getAverage and prints out line 18 identifying the
	 * vehicle names around the given index that would average it Ex: the average of
	 * index 20 would be index 19 and 21, 18 and 22 etc.
	 * 
	 * @param vehicleID the String given that will pass its value to vehicleID1 so
	 *                  it has an assigned value
	 * @throws FileNotFoundException in case the file cannot be found
	 */
	public PosAvg(String vehicleID) throws FileNotFoundException {
		// Auto-generated constructor stub
		vehicleID1 = vehicleID;
		getAverage();
	}

	/**
	 * the goal of this is to return the index where the strings are equal
	 * 
	 * @return index which counts through the array and gives the index where the
	 *         string we want is equal to that value in array
	 */
	public int indexOfVehicle() {
		// Auto-generated method stub
		int index = 0;

		for (int i = 0; i < getArraySize(); i++) {
			index += 1;

			if (vehicleID1.equals(vehicleID[i])) {
				break;
			}
		}
		return index;
	}

	/**
	 * getAverage takes the strings at the indexes surrounding the index sought and
	 * prints them out
	 * 
	 * @return the toString override's "output" which is the string wanted for
	 *         Sample output
	 * @throws FileNotFoundException in case the file readers file being scanned for
	 *                               cannot be found
	 */
	public String getAverage() throws FileNotFoundException {
		fileReader();

		int i = indexOfVehicle() - 1;
		String oneOver = null;
		String twoOver = null;
		String oneUnder = null;
		String twoUnder = null;

		if (i > 0) {
			oneUnder = vehicleID[i - 1];
			twoUnder = vehicleID[i - 2];
		}

		if (i != getArraySize() && i != getArraySize() - 1) {
			oneOver = vehicleID[i + 1];
			twoOver = vehicleID[i + 2];
		}

		output = "This index is average of " + oneUnder + " and " + oneOver + ", " + twoUnder + " and " + twoOver
				+ ", and so on.";
		return output;
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
		return output;
	}

}
