package pwc.com.au.assignment.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pwc.com.au.assignment.dto.addressbook.UniqueContactsRequest;
import pwc.com.au.assignment.dto.addressbook.AddressBookRequest;
import pwc.com.au.assignment.dto.addressbook.ContactDto;
import pwc.com.au.assignment.dto.addressbook.ObjectResponse;
import pwc.com.au.assignment.service.AddressBookService;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

	private static final Logger LOGGER = LogManager.getLogger(AddressBookController.class);

	@Autowired
	private AddressBookService addressBookService;

	@PostMapping(value = "/createnewcontact")
	public @ResponseBody ObjectResponse createNewContact(@RequestBody ContactDto request) {
		LOGGER.info("Call createNewContact function.");
		return addressBookService.createNewContact(request);
	}

	@PostMapping(value = "/findallcontacts")
	public @ResponseBody List<ContactDto> findAllContacts(@RequestBody AddressBookRequest request) {
		LOGGER.info("Call findAllContacts function.");
		return addressBookService.findAllContactsFromAddressBook(request.getAddressBookName());
	}

	@PostMapping(value = "/deletecontact")
	public @ResponseBody ObjectResponse deleteContact(@RequestBody ContactDto request) {
		LOGGER.info("Call deleteContact function.");
		return addressBookService.deleteContact(request);
	}

	@PostMapping(value = "/getuniquecontactsforgiventwoaddressbooks")
	public @ResponseBody List<ContactDto> getUniqueContactsForGivenTwoAddressBook(
			@RequestBody UniqueContactsRequest request) {
		LOGGER.info("Call getUniqueContactsForGivenTwoAddressBook function.");
		return addressBookService.getUniqueContactsForGivenTwoAddressBook(request);
	}
}
