package com.springmvc.angular.DAO;



import java.util.List;

import com.springmvc.angular.model.Person;

public interface PersonDAO {
	
	public List<Person> getAllPerson();
	public Person addPerson(Person person);
	public void deletePerson(int pid);
	public void updatePerson(Person person);
	

}
