package com.springmvc.angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.angular.DAO.PersonDAO;
import com.springmvc.angular.model.Person;

@RestController
public class PersonController {

	@Autowired
	public PersonDAO personDao;
	
	@RequestMapping(value = "/getperson", method = RequestMethod.GET, produces = "application/json")
	public List<Person> getAllPerson() {

		List<Person> list = (List<Person>) personDao.getAllPerson();
		return list;
	}

	@RequestMapping(value = "/addperson", method = RequestMethod.POST, produces = "application/json")
	public Person addPerson(@RequestBody Person person) {
		// TODO Auto-generated method stub
		return personDao.addPerson(person);
	}

}