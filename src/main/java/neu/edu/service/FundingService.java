package neu.edu.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.funding.FundingCreation;
import neu.edu.controller.funding.FundingModel;
import neu.edu.controller.idea.IdeaModel;
import neu.edu.controller.role.RoleModel;
import neu.edu.controller.services.ServicesModel;
import neu.edu.controller.user.UserModel;
import neu.edu.controller.userrole.UserRoleCreation;
import neu.edu.controller.userrole.UserRoleModel;
import neu.edu.dao.FundingDao;
import neu.edu.dao.IdeaDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.CategoryStartup;
import neu.edu.entity.Funding;
import neu.edu.entity.Idea;
import neu.edu.entity.Role;
import neu.edu.entity.User;
import neu.edu.entity.UserRole;

@Service
public class FundingService {
	
	
	@Autowired
	private FundingDao fundingDao;
	
	@Autowired
	private IdeaDao ideaDao;
	
	@Autowired
	private UserDao userDao;
	
	// Create Funding
	@Transactional
	public FundingModel createFunding(FundingCreation fundingCreation) {

		User user = userDao.findByUserId(fundingCreation.getUserId());
		Idea idea = ideaDao.findByIdeaId(fundingCreation.getIdeaId());
		
		FundingModel funding = null;

		if (user != null & idea != null) {
			Funding fund = new Funding();
			fund.setFundingValue(fundingCreation.getFundingValue());
			fund.setFundedRecieved(fundingCreation.getFundedRecieved());
			fund.setIdea(idea);
			fund.setUser(user);
			fund = fundingDao.save(fund);
			
			funding = new FundingModel();
			funding.setFundingId(fund.getFundingId());
			
			UserModel userModel = new UserModel(user.getUserId());
			IdeaModel ideaModel = new IdeaModel(idea.getIdeaId());
			funding.setIdea(ideaModel);
			funding.setUser(userModel);
					
			System.out.println("Funnding Idea/User Created " + fund.getFundingId());
		} else {
			return funding;
		}
		return funding;

	}
	
	
	// Delete 
	@Transactional
	public boolean deletefunding( Integer fundingId) {
		Funding funding = fundingDao.findOne(fundingId);
		fundingDao.delete(fundingId);
		return true;
	}

	
	// List
	@Transactional
	public List<FundingModel> findAll() {
		// TODO Auto-generated method stub
		return fundingDao.findAll().stream().map(x -> {
			
			FundingModel temp = new FundingModel();
			temp.setFundingId(x.getFundingId());
			temp.setFundingValue(x.getFundingValue());

			
			return temp;
		}).collect(Collectors.toList());
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
