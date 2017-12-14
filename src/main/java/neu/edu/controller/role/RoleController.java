package neu.edu.controller.role;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import neu.edu.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	// Comment it put 12/13
//	@RequestMapping(method = RequestMethod.GET)
//	public List<RoleModel> findAll() {
//		return roleService.findAll();
//	}

	
	@RequestMapping(method = RequestMethod.GET)
//	@PreAuthorize("hasAuthority('Admin') or hasAuthority('Individual')")
	public List<RoleModel> findAll() {
		return roleService.findAll();
	}
	

	@RequestMapping(method = RequestMethod.POST)
//	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<String> createRole(@RequestBody @Valid RoleModel roleModel) {
		ResponseEntity<String> response = new ResponseEntity<String>("Role Not Created",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (roleService.createRole(roleModel) != null) {
			response = new ResponseEntity<String>("Role Created", HttpStatus.OK);
		}
		return response;
	}


	@RequestMapping(path = "/{roleId}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('Individual')")
	public ResponseEntity<?> deleteRole(@PathVariable("roleId") Integer roleId) {
		ResponseEntity<?> response = new ResponseEntity<>("Role Not Deleted", 
				HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = roleService.deleteRole(roleId);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = "/{roleId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateRole(@PathVariable("roleId") Integer roleId,
			@RequestBody @Valid RoleModel newRole) {
		ResponseEntity<?> response = new ResponseEntity<>("Role Not Updated", 
				HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = roleService.updateRole(roleId, newRole);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}
}
