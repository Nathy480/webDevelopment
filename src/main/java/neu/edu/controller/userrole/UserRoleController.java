package neu.edu.controller.userrole;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.controller.user.UserCreation;
import neu.edu.controller.user.UserModel;
import neu.edu.service.UserRoleService;

@RestController
@RequestMapping("/userrole")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createRelationUser(@Valid @RequestBody UserRoleCreation userRoleCreation) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("User/Role Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;

		UserRoleModel userRoleProfile = null;
		if ((userRoleProfile = userRoleService.createUserRole(userRoleCreation)) != null) {
			responseEntity = new ResponseEntity<>("User-Role Created" + userRoleProfile, HttpStatus.OK);
		}
		return responseEntity;
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public List<UserRoleModel> findAll() {
		return userRoleService.findAll();
	}
	
	
}
