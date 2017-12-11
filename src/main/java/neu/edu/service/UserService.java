package neu.edu.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.person.PersonModel;
import neu.edu.controller.role.RoleModel;
import neu.edu.controller.user.UserCreation;
import neu.edu.controller.user.UserModel;
import neu.edu.dao.PersonDao;
import neu.edu.dao.RoleDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Person;
import neu.edu.entity.Role;
import neu.edu.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonDao personDao;



	@Transactional
	public UserModel createUser(UserCreation userCreation) {

		Role role = roleDao.findOne(userCreation.getRoleId());

		// If personId exists create a new user else do everything else.

		UserModel userProfile = null;
		if (role != null ) {
			User user = new User();
//			user.setUsername(userCreation.getUsername());
//			user.setPassword(userCreation.getPassword());
//			user.setCreatedOn(new Date());
//			user.setRole(role);
		
			Integer personId = personService.createPerson(userCreation);
			Person person = personDao.findOne(personId);
			user.setPerson(person);
			user = userDao.save(user);

			userProfile = new UserModel();
			userProfile.setUserId(user.getIduser());
			userProfile.setUsername(user.getUsername());

			RoleModel roleModel = new RoleModel(role.getIdrole());
			roleModel.setRoleName(role.getRoleName());
			roleModel.setRoleDesc(role.getRoleDesc());
			userProfile.setRole(roleModel);


		} else {
			return userProfile;
		}

		return userProfile;
	}

	@Transactional
	public List<UserModel> findAll() {

		return userDao.findAll().stream().map(user -> {

			UserModel userProfile = new UserModel();
			userProfile.setUserId(user.getIduser());
			userProfile.setUsername(user.getUsername());

//			Role role = user.getRole();
//			RoleModel roleModel = new RoleModel(role.getIdrole());
//			roleModel.setRoleName(role.getRoleName());
//			roleModel.setRoleDesc(role.getRoleDesc());
//			userProfile.setRole(roleModel);

			Person person = user.getPerson();
			PersonModel personModel = new PersonModel();
			personModel.setPersonId(person.getIdperson());
			personModel.setFirstName(person.getFirstName());
			personModel.setLastName(person.getLastName());
			personModel.setEmail(person.getEmail());
			personModel.setDob(person.getDob());
			userProfile.setPerson(personModel);

			return userProfile;
		}).collect(Collectors.toList());

	}

	@Transactional
	public boolean deletedUser(Integer userId) {
		userDao.delete(userId);
		return true;
	}

//	@Transactional
//	public boolean updateUserRole(Integer userId, Integer roleId) {
//		User user = userDao.findOne(userId);
//		Role newRole = roleDao.findOne(roleId);
//		if (newRole != null) {
//			user.setRole(newRole);
//			userDao.save(user);
//			return true;
//		} else {
//			return false;
//		}
//	}

	// Create Method for UpdateUserName
	@Transactional
	public boolean updateUsername(Integer userId, UserModel userModel) {

		User user = userDao.findOne(userId);
		if (user != null) {
			user.setUsername(userModel.getUsername());
			userDao.save(user);
			return true;

		} else {
			return false;
		}
	}

	@Transactional
	public boolean validateUser(String username) {
		User user = userDao.findByUsername(username);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}


	@Transactional
	public UserModel fetchUserDetails(Integer userId) {
		User user = userDao.findOne(userId);
		if (user == null) {
			return null;
		}

		UserModel userModel = new UserModel();
		userModel.setUsername(user.getUsername());
		return userModel;
	}

}
