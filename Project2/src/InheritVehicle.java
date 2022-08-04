import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class InheritVehicle extends AbstractVehicle {

	String[] vehicleID = new String[20];
	String stringVehicleID;
	char avg;

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
			vehicleID[i] = inputFile.next(); // takes the VehicleId and reads it and assigns it to a spot in the array
			++i; // increments the array to make sure the array isn't overridden at that index
			inputFile.nextLine(); // goes to next line and the loop starts over
		}
		inputFile.close(); // closes scanner
	}

	/**
	 * Constructor used to assign the string the required info needed to use in
	 * calAverage
	 * 
	 * @param vanet used to get the vehicle ID from the text and assign a value to
	 *              output in calAverage
	 */
	public InheritVehicle(Vanet vanet) {
		// Auto-generated constructor stub
		stringVehicleID = vanet.getVehicleID();

	}

	/**
	 * This calls the average method and returns the corresponding letter on the
	 * ascii table equivelant to integer
	 * 
	 * @return the averages char that matches i.e. for avd = 68 returns 'D'
	 */
	public char letterAverage() {
		// Auto-generated method stub
		calAverage();
		return avg;
	}

	/**
	 * This computes the average, floor, and ceiling values according to the double
	 * average found
	 *
	 * @return calAverage which is an array of ceiling floor and average which will
	 *         be printed out by index in driver
	 */
	public int[] calAverage() {
		// Auto-generated method stub

		int sum = 0;
		double average = 0;

		for (int i = 0; i < stringVehicleID.length(); i++) {
			int asciiValue = stringVehicleID.charAt(i);
			sum += asciiValue;
		}
		average = (double) sum / stringVehicleID.length();
		int floor = (int) Math.floor(average);
		int ceiling = (int) Math.ceil(average);
		int roundAverage = (int) Math.round(average);

		avg = (char) roundAverage;

		int[] calAverage = { ceiling, floor, roundAverage };
		return calAverage;
	}
}
