package com.addressbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.addressbook.entities.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, String>, JpaRepository<Person, String> {

}
