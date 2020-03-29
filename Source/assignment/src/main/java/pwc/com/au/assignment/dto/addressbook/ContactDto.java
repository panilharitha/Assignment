package pwc.com.au.assignment.dto.addressbook;

import java.io.Serializable;

public class ContactDto implements Serializable {

	private static final long serialVersionUID = -4029793076420469899L;


	private String addressBookName;

	private String name;

	private String number;


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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "ContactDto [addressBookName=" + addressBookName + ", name=" + name + ", number=" + number
				+ "]";
	}

	/**
	 * 
	 */

}
