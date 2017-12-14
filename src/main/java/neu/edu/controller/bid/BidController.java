package neu.edu.controller.bid;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.controller.services.ServicesModel;
import neu.edu.service.BidService;

@RestController
@RequestMapping("/bid")
public class BidController {

	@Autowired
	private BidService bidService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createBid(@RequestBody @Valid BidModel bidModel) {
		ResponseEntity<String> response = new ResponseEntity<String>("Bid Not Created",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (bidService.createBid(bidModel) != null) {
			response = new ResponseEntity<String>("Bid Created", HttpStatus.OK);
		}
		return response;
	}
	
	
	
	
}



