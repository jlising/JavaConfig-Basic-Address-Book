package com.addressbook.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addressbook.components.MappableService;
import com.addressbook.components.TestComponent;
import com.addressbook.entities.Person;
import com.addressbook.paging.PageInfo;
import com.addressbook.repositories.PersonRepository;
import com.addressbook.service.PersonService;
import com.mysema.query.jpa.impl.JPAQuery;
import com.addressbook.dto.PersonInfo;

import static com.addressbook.entities.QPerson.person;
  
@Service
public class PersonServiceImpl extends MappableService<PersonInfo, Person> 
	implements PersonService{
     
    private PersonRepository personRepository;
	private TestComponent testComponent;
    
	@Autowired
    private EntityManager entityManager;
	
	@Autowired
	public void setTestComponent(TestComponent testComponent) {
		this.testComponent = testComponent;
	}
	
    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

    @Transactional
    public void addPerson(Person p) {
       this.personRepository.save(p);
    }
 
    @Transactional
    public void updatePerson(Person p) {
       this.personRepository.save(p);
    }
  
	@Transactional
    public Person getPersonById(String id) {
        return this.personRepository.findOne(id);
    }
 
    @Transactional
    public void removePerson(String id) {
        this.personRepository.delete(id);
    }
    
    @Transactional
    public String testMethod(){
    	return testComponent.toString();
    }
    
    @Transactional
	public List<Person> listPersons() {
		return (List<Person>) this.personRepository.findAll();
	}
    
    @Transactional
    public PageInfo<PersonInfo> getPersons(Pageable pageable) {
    	
    	Page<Person> page = this.personRepository.findAll(pageable);
    	
        return toPageInfo(page);
    }
    
	public PageInfo<PersonInfo> searchByName(String name, Pageable pageable) {
		 	JPAQuery jpaQuery = new JPAQuery(entityManager);
		 	
		 	JPAQuery countQuery = new JPAQuery(entityManager).from(person)
	                .where(person.lastname.contains(name).or(person.firstname.contains(name).or(person.middlename.contains(name))));
		 	
		 	Long total = countQuery.count();
	                
	        List<Person> persons = jpaQuery.from(person)
	                .where(person.lastname.contains(name).or(person.firstname.contains(name).or(person.middlename.contains(name))))
	                .offset(pageable.getOffset())
	                .limit(pageable.getPageSize())
	                //.distinct()
	                .createQuery(person)
	                .getResultList();

	        return toPageInfo(new PageImpl<Person>(persons, new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort()), total));
	}
}