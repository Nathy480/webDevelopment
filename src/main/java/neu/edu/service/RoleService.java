package neu.edu.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.role.RoleModel;
import neu.edu.controller.user.UserCreation;
import neu.edu.controller.user.UserModel;
import neu.edu.dao.RoleDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Person;
import neu.edu.entity.Role;
import neu.edu.entity.User;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserDao userDao;
	
	



	@Transactional
	public Integer createRole(RoleModel roleModel) {

		Role role = new Role();
		role.setRoleName(roleModel.getRoleName());
		role.setRoleDesc(roleModel.getRoleDesc());
		role = roleDao.save(role);
		System.out.println("ID Created " + role.getIdrole());
		return role.getIdrole();
	}

	@Transactional
	public List<RoleModel> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll().stream().map(x -> {
			RoleModel temp = new RoleModel(x.getIdrole());
			temp.setRoleName(x.getRoleName());
			temp.setRoleDesc(x.getRoleDesc());
			return temp;
		}).collect(Collectors.toList());
	}
	
	// CHECK THIS OUT
//
//	@Transactional
//	public boolean deleteRole(Integer roleId) {
//		Role toBeDeleted = roleDao.findOne(roleId);
//		if (toBeDeleted.getUsers().size() > 0) {
//			return false;
//		} else {
//			roleDao.delete(toBeDeleted);
//		}
//		return true;
//	}

	@Transactional
	public boolean updateRole(Integer roleId, RoleModel newRole) {

		Role toBeUpdated = roleDao.findOne(roleId);
		toBeUpdated.setRoleDesc(newRole.getRoleDesc());
		toBeUpdated.setRoleName(newRole.getRoleName());

		roleDao.save(toBeUpdated);
		return true;
	}
}
