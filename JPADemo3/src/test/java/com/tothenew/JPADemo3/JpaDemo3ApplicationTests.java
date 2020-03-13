package com.tothenew.JPADemo3;

import com.tothenew.JPADemo3.Entities.*;
import com.tothenew.JPADemo3.Repositories.CustomerRepository;
import com.tothenew.JPADemo3.Repositories.LicenseRepository;
import com.tothenew.JPADemo3.Repositories.ProgrammerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class JpaDemo3ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ProgrammerRepository programmerRepository;

	@Autowired
	LicenseRepository licenseRepository;


	@Test
	public void testCreateCustomer(){
		Customer customer = new Customer();
		customer.setName("Kandy");
		HashSet<PhoneNumber> numbers = new HashSet<PhoneNumber>();

		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("1234567890");
		ph1.setType("cell");
		//Update
		numbers.forEach(phoneNumber -> phoneNumber.setType("cell"));
		customerRepository.save(customer);
		ph1.setCustomer(customer);//Saving Foreign key
		numbers.add(ph1);

		PhoneNumber ph2 = new PhoneNumber();
		ph1.setNumber("9992100045");
		ph1.setType("home");
		ph2.setCustomer(customer);//Saving Foreign key
		numbers.add(ph2);

		//Better way of Handling Foreign Key
		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);

		customer.setNumbers(numbers);

		customerRepository.save(customer);
	}

	//Read
	@Test
	public void testLoadCustomer(){
		Customer customer = customerRepository.findOne(4L);
		System.out.println(customer.getName());

		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(phoneNumber -> System.out.println(phoneNumber.getNumber()));
	}

	//Update
	@Test
//	@Transactional
	public void testUpdateCustomer(){
		Customer customer = customerRepository.findOne(4L);
		customer.setName("Kandy Arora");

		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(phoneNumber -> phoneNumber.setType("cell"));
		customerRepository.save(customer);
	}

	@Test
	public void testDelete(){
		customerRepository.delete(4L);
	}


//Many to many mapping

	@Test
	public void testCreateProgrammer(){
		Programmer programmer = new Programmer();
		programmer.setName("Kandy");
		programmer.setSal(10000);

		HashSet<Project> projects = new HashSet<Project>();
		Project project = new Project();
		project.setName("Hibernate project");
		projects.add(project);

		programmer.setProjects(projects);

		programmerRepository.save(programmer);
	}

	@Test
	@Transactional
	public void testFindProgrammer(){
	Programmer programmer = programmerRepository.findOne(1);
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}

//One to one mapping

	@Test
	@Transactional
	public void testOneToOne(){

		License license = new License();
		license.setType("Car");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());

		Person person = new Person();
		person.setFirstName("Kandy");
		person.setLastName("Arora");
		person.setAge(20);

		license.setPerson(person);

		licenseRepository.save(new License());
}
}
