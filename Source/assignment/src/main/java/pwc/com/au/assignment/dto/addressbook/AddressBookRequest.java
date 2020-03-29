package pwc.com.au.assignment.dto.addressbook;

import java.io.Serializable;

public class AddressBookRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5127165580884975096L;
	private String addressBookName;
	
	

	public AddressBookRequest() {
		super();
	}

	public AddressBookRequest(String addressBookName) {
		super();
		this.addressBookName = addressBookName;
	}

	/**
	 * @return the addressBookName
	 */
	public String getAddressBookName() {
		return addressBookName;
	}

	/**
	 * @param addressBookName the addressBookName to set
	 */
	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}
	
	
}
