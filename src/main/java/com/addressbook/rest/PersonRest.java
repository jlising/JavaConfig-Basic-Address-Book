package com.addressbook.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.addressbook.dto.PersonInfo;
import com.addressbook.entities.Person;
import com.addressbook.paging.PageInfo;
import com.addressbook.service.PersonService;

@RestController
@RequestMapping(value = "/persons", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class PersonRest {
	
	@Autowired(required=true)
	private PersonService personService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public PageInfo<PersonInfo> getPersons(Pageable pageable) {
        
		return personService.getPersons(pageable);
    }
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public PageInfo<PersonInfo> searchByName(@RequestParam(value="name", required = true) String name, Pageable pageable) {
        
		return personService.searchByName(name, pageable);
    }
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Person test() {
		return new Person();
	}
}