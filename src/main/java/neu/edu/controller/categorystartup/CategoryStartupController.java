package neu.edu.controller.categorystartup;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.controller.funding.FundingModel;
import neu.edu.service.CategoryStartupService;

@RestController
@RequestMapping("/categoryStartup")
public class CategoryStartupController {

	@Autowired
	private CategoryStartupService catStartup;
	
		
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createRelCate(@Valid @RequestBody CategoryStartupCreation cateCreation) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("User/Role Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;

		CategoryStartupModel Profile = null;
		if ((Profile = catStartup.createCatStart(cateCreation)) != null) {
			responseEntity = new ResponseEntity<>("Cate-Rela Created" + Profile, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	
	
	@RequestMapping(path = "/{StartupId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteServices(@PathVariable("StartupId") Integer startupId) {
		ResponseEntity<?> response = new ResponseEntity<>("Start Not Deleted", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = catStartup.deleteStartRel(startupId);
		if (deleteStatus) {
			response = new ResponseEntity<>(" Startup deleed"+deleteStatus, HttpStatus.OK);
		}
		return response;
	}
	
	
	
	// List
	@RequestMapping(method = RequestMethod.GET)
	public List<CategoryStartupModel> findAll() {
		return catStartup.findAll();
	}
	
	
	
	
	
	
	
	
}



