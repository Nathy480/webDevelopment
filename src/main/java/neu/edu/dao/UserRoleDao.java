package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.edu.entity.User;
import neu.edu.entity.UserRole;

public interface UserRoleDao  extends JpaRepository<UserRole, Integer>{
	
	
	public UserRole findByRole( UserRole userRole);
	public List<UserRole>  findByUserRoleId(Integer userroleId);
	public List <UserRole> findByRoleRoleId(Integer roleRoleId);
	public List <UserRole> findByUserUserId(Integer userUserId);

	
	
}
