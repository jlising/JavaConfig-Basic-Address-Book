package com.addressbook.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.addressbook.dto.PersonInfo;
import com.addressbook.entities.Person;
import com.addressbook.paging.PageInfo;

public interface PersonService {

    public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
    public Person getPersonById(String id);
    public void removePerson(String id);
    public String testMethod();
    
    public PageInfo<PersonInfo> getPersons(Pageable pageable);
    public PageInfo<PersonInfo> searchByName(String name, Pageable pageable);
}