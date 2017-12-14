package neu.edu.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import neu.edu.controller.role.RoleModel;
import neu.edu.dao.RoleDao;
import neu.edu.dao.UserDao;
import neu.edu.dao.UserRoleDao;
import neu.edu.entity.Role;
import neu.edu.entity.UserRole;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleDao userRoleDao;

	@Transactional
	public Integer createRole(RoleModel roleModel) {

		Role role = new Role();
		role.setRoleName(roleModel.getRoleName());
		role.setRoleDesc(roleModel.getRoleDesc());
		role.setCreatedOn(new Date());
		role.setCreatedBy(new Date());
		role = roleDao.save(role);
		System.out.println("ID Role Created " + role.getRoleId());
		return role.getRoleId();
	}

	@Transactional
	public List<RoleModel> findAll() {
		return roleDao.findAll().stream().map(x -> {
			RoleModel temp = new RoleModel(x.getRoleId());
			temp.setRoleName(x.getRoleName());
			temp.setRoleDesc(x.getRoleDesc());
			return temp;
		}).collect(Collectors.toList());
	}



	@Transactional
	public boolean deleteRole(Integer roleId) {
		List<UserRole> userRole = userRoleDao.findByRoleRoleId(roleId);
		if (userRole != null) {
			Role role = roleDao.findOne(roleId);
			userRoleDao.delete(userRole);
			roleDao.delete(role);

		} else {
			return false;
		}

		return true;
	}

	@Transactional
	public boolean updateRole(Integer roleId, RoleModel newRole) {
		Role toBeUpdated = roleDao.findOne(roleId);
		toBeUpdated.setRoleDesc(newRole.getRoleDesc());
		toBeUpdated.setRoleName(newRole.getRoleName());

		roleDao.save(toBeUpdated);
		return true;
	}
}
