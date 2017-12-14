package neu.edu.controller.userrole;

import neu.edu.controller.role.RoleModel;
import neu.edu.controller.user.UserModel;

public class UserRoleModel {

	private Integer userRoleId;
	private RoleModel role;
	private UserModel user;

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

}
