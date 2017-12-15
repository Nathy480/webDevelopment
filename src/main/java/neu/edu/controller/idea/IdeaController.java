package neu.edu.controller.idea;

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
import neu.edu.service.Idea_Service;

@RestController
@RequestMapping("/idea")
public class IdeaController {

	@Autowired
	private Idea_Service idea_service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createIdea(@Valid @RequestBody IdeaCreation ideaCreation) {

		ResponseEntity<?> response = new ResponseEntity<String>("Idea Not Created", HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if ((idea_service.createIdea(ideaCreation)) != null) {
			response = new ResponseEntity<>("Idea creation success", HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<IdeaModel> ideaModel = idea_service.findAll();
		return new ResponseEntity<>(ideaModel, HttpStatus.OK);
	}

	@RequestMapping(path = "/{categoryId}", method = RequestMethod.GET)
	public List<IdeaModel> listIdeas(@PathVariable("categoryId") Integer categoryId) {
		return idea_service.listIdeas(categoryId);

	}

	
	@RequestMapping(path = "/{ideaId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteServices(@PathVariable("ideaId") Integer ideaId) {
		ResponseEntity<?> response = new ResponseEntity<>("idea  Not Deleted", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = idea_service.deleteIdea(ideaId);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
