package pwc.com.au.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pwc.com.au.assignment.dto.addressbook.UniqueContactsRequest;
import pwc.com.au.assignment.service.AddressBookService;

@Controller
public class HomeController {

	@Autowired
	private AddressBookService addressBookService;
 
	@RequestMapping("/welcome")
	public ModelAndView createUser(ModelMap model) {

		ModelMap modelMap = new ModelMap();
		modelMap.put("bookOneAllContacts", addressBookService.findAllContactsFromAddressBook("Book1"));
		modelMap.put("bookTwoAllContacts", addressBookService.findAllContactsFromAddressBook("Book2"));
		modelMap.put("uniqueContacts", addressBookService.getUniqueContactsForGivenTwoAddressBook(new UniqueContactsRequest("Book1", "Book2")));

		return new ModelAndView("welcome", modelMap);
	}
}
