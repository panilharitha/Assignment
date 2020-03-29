package pwc.com.au.assignment.addressbook;

import java.net.URI;
import java.net.URISyntaxException;

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
public class DeleteContact {

	private static final String API_ROOT = "http://localhost:8080/api/addressbook";

	private static final Logger LOGGER = LogManager.getLogger(FindAllContacts.class);

	@Test
	public void deleteContact() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = API_ROOT + "/deletecontact";
		URI uri = new URI(baseUrl);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");

		ContactDto contactDto = new ContactDto();
		contactDto.setAddressBookName("Book1");
		contactDto.setName("Bob");

		HttpEntity<ContactDto> request = new HttpEntity<>(contactDto, headers);

		try {
			ResponseEntity<ObjectResponse> result = restTemplate.postForEntity(uri, request, ObjectResponse.class);
			Assert.assertEquals(200, result.getStatusCodeValue());
			LOGGER.info("result : " + result.getBody());
		} catch (HttpClientErrorException ex) {
			// Verify bad request and missing header
			LOGGER.error(ex);
			Assert.assertEquals(400, ex.getRawStatusCode());
			Assert.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
		}
	}
}
