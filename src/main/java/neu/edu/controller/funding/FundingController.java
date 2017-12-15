package neu.edu.controller.funding;

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

import neu.edu.controller.services.ServicesModel;
import neu.edu.service.FundingService;

@RestController
@RequestMapping("/funding")
public class FundingController {

	@Autowired
	private  FundingService fundingservice;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createFunding(@Valid @RequestBody FundingCreation fundCreation) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("Funding Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;

		FundingModel funding = null;
		if ((funding = fundingservice.createFunding(fundCreation)) != null) {
			responseEntity = new ResponseEntity<>("Funding Created", HttpStatus.OK);
		}
		return responseEntity;
	}
	

	
	@RequestMapping(path = "/{FundingId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteServices(@PathVariable("FundingId") Integer fundingId) {
		ResponseEntity<?> response = new ResponseEntity<>("Not Deleted", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = fundingservice.deletefunding(fundingId);
		if (deleteStatus) {
			response = new ResponseEntity<>(" Funding  deleted" + deleteStatus, HttpStatus.OK);
		}
		return response;
	}
	
	
	
	// List
	@RequestMapping(method = RequestMethod.GET)
	public List<FundingModel> findAll() {
		return fundingservice.findAll();
	}
	
	
	
}
