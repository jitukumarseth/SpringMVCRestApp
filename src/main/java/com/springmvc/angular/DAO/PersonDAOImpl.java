package com.springmvc.angular.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.angular.model.Person;

@Repository
@Transactional
public class PersonDAOImpl implements PersonDAO{

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Person> list=(List<Person>) hibernateTemplate.find("from Person p");
		return list;
	}
	
	
	@Override
	public Person addPerson(Person person) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(person);
		return person;
	}

	@Override
	public void deletePerson(int pid) {
		// TODO Auto-generated method stub
		
		Person p=hibernateTemplate.get(Person.class, pid);
		hibernateTemplate.delete(p);
	}

	@Override
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(person);
		
	}

}
