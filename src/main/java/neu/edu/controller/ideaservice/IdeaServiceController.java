package neu.edu.controller.ideaservice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.controller.category.CategoryModel;
import neu.edu.service.IdeaServiceService;

@RestController
@RequestMapping("/ideaService")
public class IdeaServiceController {

	
	@Autowired
	private IdeaServiceService ideaserviceService;
	
	// List
	@RequestMapping(method = RequestMethod.GET)
	public List<IdeaServiceModel> findAll() {
		return ideaserviceService.findAll();
	}

	
	
	// Create
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createIdeaService(@RequestBody @Valid IdeaServiceModel ideaServiceModel) {
		ResponseEntity<String> response = new ResponseEntity<String>("Category Not Created",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (ideaserviceService.createideaService(ideaServiceModel) != null) {
			response = new ResponseEntity<String>("Category Created", HttpStatus.OK);
		}
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
