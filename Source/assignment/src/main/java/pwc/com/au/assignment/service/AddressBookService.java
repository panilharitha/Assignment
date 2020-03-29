package pwc.com.au.assignment.service;

import java.util.List;

import pwc.com.au.assignment.dto.addressbook.UniqueContactsRequest;
import pwc.com.au.assignment.dto.addressbook.ContactDto;
import pwc.com.au.assignment.dto.addressbook.ObjectResponse;

public interface AddressBookService {
	List<ContactDto> findAllContactsFromAddressBook(String addressBookName);
	ObjectResponse createNewContact(ContactDto request);
	ObjectResponse deleteContact(ContactDto request);
	List<ContactDto> getUniqueContactsForGivenTwoAddressBook(UniqueContactsRequest request);
}
