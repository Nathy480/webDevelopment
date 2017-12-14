package neu.edu.controller.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import neu.edu.service.ServicesService;

@RestController
@RequestMapping("/services")
public class ServicesController {
	
	@Autowired
	private ServicesService servicesService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createServices(@RequestBody @Valid ServicesModel servicesModel) {
		ResponseEntity<String> response = new ResponseEntity<String>("Services Not Created",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (servicesService.createServices(servicesModel) != null) {
			response = new ResponseEntity<String>("Services Created", HttpStatus.OK);
		}
		return response;
	}

	
	@RequestMapping(path = "/{servicesId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteServices(@PathVariable("servicesId") Integer servicesId) {
		ResponseEntity<?> response = new ResponseEntity<>("Service Not Deleted", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = servicesService.deleteServices(servicesId);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}
	
	
	
	
	
	
	
	

}
