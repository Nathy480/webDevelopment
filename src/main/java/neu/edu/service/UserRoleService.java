package neu.edu.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import neu.edu.controller.role.RoleModel;
import neu.edu.controller.user.UserModel;
import neu.edu.controller.userrole.UserRoleCreation;
import neu.edu.controller.userrole.UserRoleModel;
import neu.edu.dao.RoleDao;
import neu.edu.dao.UserDao;
import neu.edu.dao.UserRoleDao;

import neu.edu.entity.Role;
import neu.edu.entity.User;
import neu.edu.entity.UserRole;

@Service
public class UserRoleService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserRoleDao userRoleDao;

	@Transactional
	public UserRoleModel createUserRole(UserRoleCreation userRoleCreation) {

		Role role = roleDao.findByRoleId(userRoleCreation.getRoleId());
		User user = userDao.findByUserId(userRoleCreation.getUserId());

		UserRoleModel userRoleProfile = null;

		if (role != null & user != null) {
			UserRole userRole = new UserRole();
			userRole.setUser(user);
			userRole.setRole(role);
			userRole.setStatus(userRoleCreation.getStatus());
			userRole.setCreatedOn(new Date());
			userRole = userRoleDao.save(userRole);

			userRoleProfile = new UserRoleModel();
			userRoleProfile.setUserRoleId(userRole.getUserRoleId());

			UserModel userModel = new UserModel(user.getUserId());
			userRoleProfile.setUser(userModel);

			RoleModel roleModel = new RoleModel(role.getRoleId());
			userRoleProfile.setRole(roleModel);

			System.out.println("Relationship Role/User Created " + userRole.getUserRoleId());

		} else {
			return userRoleProfile;
		}
		return userRoleProfile;

	}


	@Transactional
	public List<UserRoleModel> findAll() {

		return userRoleDao.findAll().stream().map(userRole -> {

			UserRoleModel userRoleRelation = new UserRoleModel();
			userRoleRelation.setUserRoleId(userRole.getUserRoleId());
			
			User user = userRole.getUser();
			Role role = userRole.getRole();
			UserModel userModel = new UserModel(user.getUserId());
			RoleModel roleModel = new RoleModel(role.getRoleId());
	//		userModel.setUsername(user.getUsername());
	//		roleModel.setRoleName(role.getRoleName());
		
		//	userRoleRelation.setRole(roleModel);
		//	userRoleRelation.setUser(userModel);
			
			return userRoleRelation;
		}).collect(Collectors.toList());

	}


	// Delete User from a specific Role
	@Transactional
	public boolean deleteUserRole( Integer roleId, Integer userId) {
		
		boolean updated = false;
		UserRole userRole = userRoleDao.findByRole(new UserRole());		
		return true;
	}

}


