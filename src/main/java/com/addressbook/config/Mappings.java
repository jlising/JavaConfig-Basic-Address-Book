package com.addressbook.config;

import javax.annotation.PostConstruct;

import ma.glasnost.orika.MapperFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.addressbook.dto.PersonInfo;
import com.addressbook.entities.Person;
import com.addressbook.mapper.DataMapper;

@Configuration
public class Mappings {
	@Autowired
    private DataMapper dataMapper;

    @PostConstruct
    public void init() {

        MapperFactory mapperFactory = dataMapper.getMapperFactory();

        mapperFactory.classMap(Person.class, PersonInfo.class)
                     //.exclude("product")
        			 .field("contacts", "contact")
                     .byDefault()
                     .register();
    }

}
