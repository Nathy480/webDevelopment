package neu.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.person.PersonModel;
import neu.edu.controller.user.UserCreation;
import neu.edu.dao.PersonDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Person;
import neu.edu.entity.User;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	@Autowired
	private UserDao userDao;

	@Transactional
	public Integer createPerson(UserCreation userCreation) {

		Person person = new Person();
		person.setFirstName(userCreation.getFirstname());
		person.setLastName(userCreation.getLastname());
		person.setEmail(userCreation.getEmail());
		person.setDob(userCreation.setDob());

		person = personDao.save(person);
		return person.getIdperson();

	}

	@Transactional
	public List<PersonModel> findAll() {
		return personDao.findAll().stream().map(person -> {
			PersonModel personModel = new PersonModel();
			personModel.setPersonId(person.getIdperson());
			personModel.setFirstName(person.getFirstName());
			personModel.setLastName(person.getLastName());
			personModel.setEmail(person.getEmail());
			personModel.setDob(person.getDob());
			return personModel;
		}).collect(Collectors.toList());
	}

	@Transactional
	public boolean updatePerson(Integer personId, PersonModel personModel) {

		Person person = personDao.findOne(personId);
		if (person != null) {
			person.setFirstName(personModel.getFirstName());
			person.setLastName(personModel.getLastName());
			person.setEmail(personModel.getEmail());
			person.setDob(personModel.getDob());
			personDao.save(person);
			return true;

		} else {
			return false;
		}

	}

	
	
	// CHECK THIS OUT
//	@Transactional
//	public boolean deletePerson(Integer personId) {
//		List<User> users = userDao.findByPersonPersonId(personId);
//
//		if (users != null && users.isEmpty()) {
//			Person person = personDao.findOne(personId);
//			personDao.delete(person);
//		} else {
//			return false;
//		}
//
//		return true;
//	}

	@Transactional
	public PersonModel fetchPersonDetails(Integer personId) {
		Person person = personDao.findOne(personId);
		if (person == null) {
			return null;
		}

		PersonModel personModel = new PersonModel();
		personModel.setPersonId(person.getIdperson());
		personModel.setFirstName(person.getFirstName());
		personModel.setLastName(person.getLastName());
		personModel.setEmail(person.getEmail());
		personModel.setDob(person.getDob());


		return personModel;
	}

}
