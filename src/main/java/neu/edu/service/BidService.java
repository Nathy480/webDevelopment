package neu.edu.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.bid.BidModel;
import neu.edu.dao.BidDao;
import neu.edu.dao.IdeaServiceDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Bid;


@Service
public class BidService {
	
	@Autowired
	private BidDao bidDao;
	
	@Autowired
	private UserDao userDao;
	
	
	@Transactional
	public Integer createBid(BidModel bidModel) {

	//	Region region = regionDao.findOne(locationCreation.getRegionId());
		
		// userId
		// ideaServicesID	
		
		
		Bid bid = new Bid();
		bid.setBidValue(bidModel.getBidValue());
		bid.setDescriptionWork(bidModel.getDescriptionWork());

		return null;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
