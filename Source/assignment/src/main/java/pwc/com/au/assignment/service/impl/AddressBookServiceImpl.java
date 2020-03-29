package pwc.com.au.assignment.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import pwc.com.au.assignment.common.CacheUtil;
import pwc.com.au.assignment.dto.addressbook.UniqueContactsRequest;
import pwc.com.au.assignment.dto.addressbook.ContactDto;
import pwc.com.au.assignment.dto.addressbook.ObjectResponse;
import pwc.com.au.assignment.service.AddressBookService;

@Service
public class AddressBookServiceImpl implements AddressBookService {

	private static final Logger LOGGER = LogManager.getLogger(AddressBookServiceImpl.class);

	@Override
	public List<ContactDto> findAllContactsFromAddressBook(String addressBookName) {

		List<ContactDto> response = new ArrayList<ContactDto>();

		Map<String, String> addressBook = CacheUtil.cache.get(addressBookName.trim());
		if (!Objects.isNull(addressBook)) {
			addressBook.forEach((name, number) -> {
				ContactDto dto = new ContactDto();

				dto.setName(name);
				dto.setNumber(number);

				response.add(dto);
			});
		}

		Comparator<ContactDto> comparator = Comparator.comparing(ContactDto::getName);

		Collections.sort(response, comparator);

		return response;
	}

	@Override
	public ObjectResponse createNewContact(ContactDto request) {

		ObjectResponse response = new ObjectResponse();
		// Validate request
		if (Objects.isNull(request)) {
			response.setMessage("Invaild request");
			response.setStatus(HttpStatus.NO_CONTENT);

			LOGGER.info("Invaild request");

			return response;
		}

		// Check existing address book.
		Map<String, String> addressBook = CacheUtil.cache.get(request.getAddressBookName().trim());
		if (Objects.isNull(addressBook)) {
			Map<String, String> contact = new HashMap<String, String>();
			contact.put(request.getName(), request.getNumber());
			CacheUtil.cache.put(request.getAddressBookName(), contact);

			response.setMessage("Successfull");
			response.setStatus(HttpStatus.ACCEPTED);
		} else {
			CacheUtil.cache.get(request.getAddressBookName()).put(request.getName(), request.getNumber());
			response.setMessage("Successfull");
			response.setStatus(HttpStatus.ACCEPTED);
		}

		return response;
	}

	@Override
	public ObjectResponse deleteContact(ContactDto request) {
		ObjectResponse response = new ObjectResponse();
		if (Objects.isNull(request)) {
			response.setMessage("Invaild request");
			response.setStatus(HttpStatus.NO_CONTENT);

			LOGGER.info("Invaild request");

			return response;
		}

		// Check existing address book.
		Map<String, String> addressBook = CacheUtil.cache.get(request.getAddressBookName().trim());
		if (Objects.isNull(addressBook)) {
			Map<String, String> contact = new HashMap<String, String>();
			contact.put(request.getName(), request.getNumber());
			CacheUtil.cache.put(request.getAddressBookName(), contact);

			response.setMessage("This address book is empty");
			response.setStatus(HttpStatus.NOT_FOUND);
		} else {
			if (Objects.isNull(addressBook.get(request.getName()))) {
				CacheUtil.cache.get(request.getAddressBookName()).put(request.getName(), request.getNumber());
				response.setMessage("Not found contact for delete.");
				response.setStatus(HttpStatus.NOT_FOUND);
			} else {
				CacheUtil.cache.get(request.getAddressBookName()).remove(request.getName());
				response.setMessage("Delete successfull");
				response.setStatus(HttpStatus.ACCEPTED);
			}
		}

		return response;
	}

	@Override
	public List<ContactDto> getUniqueContactsForGivenTwoAddressBook(UniqueContactsRequest request) {

//		Map<String, String> values = new HashMap<String, String>();
//
//		Common.cache.get(request.getAddressBookOne()).entrySet().stream()
//				.filter(e -> !Common.cache.get(request.getAddressBookTwo()).containsKey(e.getKey()))
//				.peek(e -> values.put(e.getKey(), e.getValue()));
//
//		Common.cache.get(request.getAddressBookOne()).entrySet().stream()
//				.filter(e -> !Common.cache.get(request.getAddressBookTwo()).containsKey(e.getKey()))
//				.filter(e -> !values.containsKey(e.getKey())).peek(e -> values.put(e.getKey(), e.getValue()));
//		
//		Common.cache.get(request.getAddressBookOne()).entrySet().stream()
//	      .collect(Collectors.toMap(e -> e.getKey(), 
//	        e -> !Common.cache.get(request.getAddressBookTwo()).containsKey(e.getKey())));

		List<ContactDto> response = new ArrayList<ContactDto>();
		Map<String, String> uniqueDataset = new HashMap<>();
		
		if (!Objects.isNull(CacheUtil.cache.get(request.getAddressBookOne())))
			uniqueDataset.putAll(CacheUtil.cache.get(request.getAddressBookOne()));

		if (!Objects.isNull(CacheUtil.cache.get(request.getAddressBookTwo())))
			uniqueDataset.putAll(CacheUtil.cache.get(request.getAddressBookTwo()));

		if (!Objects.isNull(CacheUtil.cache.get(request.getAddressBookOne()))
				&& !Objects.isNull(CacheUtil.cache.get(request.getAddressBookTwo())))
			for (String a : CacheUtil.cache.get(request.getAddressBookOne()).keySet()) {
				if (CacheUtil.cache.get(request.getAddressBookTwo()).containsKey(a)) {
					uniqueDataset.remove(a);
				}
			}
		
		uniqueDataset.forEach((name, number) -> {
			ContactDto dto = new ContactDto();

			dto.setName(name);
			dto.setNumber(number);

			response.add(dto);
		});

		return response;

	}

}
