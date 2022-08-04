
public class InheritVANET extends AbstractVANET {

	private int vehiclePrice;

	/**
	 * This constructor sets vehicle price because the parent class does not
	 * 
	 * @param vehicleName    the manufacturer of the car
	 * @param vehicleNumber  the ID given to the car
	 * @param vehicleAddress where the vehicle should be from
	 * @param i              the variable that price will be set to
	 */
	public InheritVANET(String vehicleName, int vehicleNumber, String vehicleAddress, int i) {
		super(vehicleName, vehicleNumber, vehicleAddress);
		this.vehiclePrice = i;
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method prints out where checks are sent to and from and how much they
	 * were according to how the output wants it.
	 */
	@Override
	public void mailPriceCheck() {
		// overrides parent method
		System.out.println("Sending check from InheritVANET.");
		System.out.println("Mailing check to " + getName() + " company for price " + this.vehiclePrice + ".");
	}

}
