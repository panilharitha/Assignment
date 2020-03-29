package pwc.com.au.assignment.addressbook;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import pwc.com.au.assignment.dto.addressbook.ContactDto;
import pwc.com.au.assignment.dto.addressbook.ObjectResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateNewContact {

	private static final String API_ROOT = "http://localhost:8080/api/addressbook";

	private static final Logger LOGGER = LogManager.getLogger(CreateNewContact.class);

	Map<String, String> bookOne = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("Bob", "0411213324");
			put("Mary", "0410234532");
			put("Jane", "0412343231");
		}
	};

	Map<String, String> bookTwo = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("Mary", "0411213324");
			put("Jone", "0410234532");
			put("Jane", "0412343231");
		}
	};

	// Add new contacts to address book 1 using Hashmap.
	@Test
	public void createNewContact() throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = API_ROOT + "/createnewcontact";
		URI uri = new URI(baseUrl);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");

		bookOne.forEach((name, number) -> {

			ContactDto contact = newContact("Book1", name, number);

			HttpEntity<ContactDto> request = new HttpEntity<>(contact, headers);

			try {
				ResponseEntity<ObjectResponse> result = restTemplate.postForEntity(uri, request, ObjectResponse.class);
				Assert.assertEquals(200, result.getStatusCodeValue());
				LOGGER.info("result : " + result.getBody());
			} catch (HttpClientErrorException ex) {
				// Verify bad request and missing header
				Assert.assertEquals(400, ex.getRawStatusCode());
				Assert.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
			}
		});

		// Add new contacts to address book 2 using Hashmap.
		bookTwo.forEach((name, number) -> {

			ContactDto contact = newContact("Book2", name, number);

			HttpEntity<ContactDto> request = new HttpEntity<>(contact, headers);

			try {
				ResponseEntity<ObjectResponse> result = restTemplate.postForEntity(uri, request, ObjectResponse.class);
				Assert.assertEquals(200, result.getStatusCodeValue());
				LOGGER.info("result : " + result.getBody());
			} catch (HttpClientErrorException ex) {
				// Verify bad request and missing header
				Assert.assertEquals(400, ex.getRawStatusCode());
				Assert.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
			}
		});
	}

	// Create Contact object for given data.
	private ContactDto newContact(String addressBookName, String name, String number) {
		ContactDto contact = new ContactDto();
		contact.setAddressBookName(addressBookName);
		contact.setName(name);
		contact.setNumber(number);
		return contact;
	}

}
