package neu.edu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import neu.edu.controller.person.PersonModel;
import neu.edu.controller.role.RoleModel;
import neu.edu.controller.user.UserCreation;
import neu.edu.controller.user.UserModel;
import neu.edu.controller.userrole.UserRoleCreation;
import neu.edu.controller.userrole.UserRoleModel;
import neu.edu.dao.PersonDao;
import neu.edu.dao.RoleDao;
import neu.edu.dao.UserDao;
import neu.edu.dao.UserRoleDao;
import neu.edu.entity.Person;
import neu.edu.entity.Role;
import neu.edu.entity.User;
import neu.edu.entity.UserRole;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserRoleService userRoleService;

	@Transactional
	public UserModel createUser(UserCreation userCreation) {
		
		UserModel userProfile = null;
		
		
		User user = new User();
		user.setUsername(userCreation.getUsername());
		user.setPassword(getHashedPassword(userCreation.getPassword()));
		user.setCreatedOn(new Date());
	
		Integer personId = personService.createPerson(userCreation);
		Person person = personDao.findOne(personId);
		user.setPerson(person);
		user = userDao.save(user);
		
		// Add the user id in the user_role Id table
		
		UserRoleCreation userRolecreation = new UserRoleCreation();
		userRolecreation.setRoleId(userCreation.getRoleId());
		userRolecreation.setUserId(user.getUserId());
		UserRoleModel userRoleModel = userRoleService.createUserRole(userRolecreation);
		
		userProfile = new UserModel();
		userProfile.setUserId(user.getUserId());
		userProfile.setUsername(user.getUsername());

		System.out.println("ID created for User" + user.getUserId());

		return userProfile;
	}

	private String getHashedPassword(String password) {
		ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
		String hashed = encoder.encodePassword(password, null);
		return hashed;
	}

	@Transactional
	public List<UserModel> findAll() {

		return userDao.findAll().stream().map(user -> {

			UserModel userProfile = new UserModel();
			userProfile.setUserId(user.getUserId());
			userProfile.setUsername(user.getUsername());

			// Role role = user.getRole();
			// RoleModel roleModel = new RoleModel(role.getRoleId());
			// roleModel.setRoleName(role.getRoleName());
			// roleModel.setRoleDesc(role.getRoleDesc());
			// userProfile.setRole(roleModel);

			Person person = user.getPerson();
			PersonModel personModel = new PersonModel();
			personModel.setPersonId(person.getPersonId());
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
		List<UserRole> userRole = userRoleDao.findByUserUserId(userId);

		if (userRole != null) {
			User user = userDao.findOne(userId);
			userRoleDao.delete(userRole);
			userDao.delete(user);

		} else {
			return false;
		}
		return true;
	}

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

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 User user = userDao.findByUsername(username);
		 
		 // Get  userId from user with username
		 Integer userId = user.getUserId();

		 // Get roleId from userRole with userId
		 List<UserRole> userRole = userRoleDao.findByUserUserId(userId);
		 
	     // Get RoleName from role with roleId		 
		 Role role = new Role();
		  System.out.println("User" + user.getUserId());
		  System.out.println(userRoleDao.findByUserUserId(userId));
		  
		  if(user == null) {
	            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
	        }
		  		  
		  
		  List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getUsername()));
		
	    UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);

		return userDetails;
	}

}
