package pwc.com.au.assignment.dto.addressbook;

import java.io.Serializable;

public class UniqueContactsRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5920427804785200617L;
	private String addressBookOne;
	private String addressBookTwo;
	
	
	public UniqueContactsRequest() {
		super();
	}
	
	public UniqueContactsRequest(String addressBookOne, String addressBookTwo) {
		super();
		this.addressBookOne = addressBookOne;
		this.addressBookTwo = addressBookTwo;
	}
	/**
	 * @return the addressBookOne
	 */
	public String getAddressBookOne() {
		return addressBookOne;
	}
	/**
	 * @param addressBookOne the addressBookOne to set
	 */
	public void setAddressBookOne(String addressBookOne) {
		this.addressBookOne = addressBookOne;
	}
	/**
	 * @return the addressBookTwo
	 */
	public String getAddressBookTwo() {
		return addressBookTwo;
	}
	/**
	 * @param addressBookTwo the addressBookTwo to set
	 */
	public void setAddressBookTwo(String addressBookTwo) {
		this.addressBookTwo = addressBookTwo;
	}
	@Override
	public String toString() {
		return "CompairAddressBooks [addressBookOne=" + addressBookOne + ", addressBookTwo=" + addressBookTwo + "]";
	}
	
	
}
