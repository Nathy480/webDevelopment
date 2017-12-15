package neu.edu.controller.funding;

import neu.edu.controller.idea.IdeaModel;
import neu.edu.controller.user.UserModel;
import neu.edu.entity.Idea;
import neu.edu.entity.User;

public class FundingModel {

	
	
	private Integer fundingId;
	private IdeaModel idea;
	private UserModel user;
	private Integer fundingValue;
	
	
	public Integer getFundingValue() {
		return fundingValue;
	}
	public void setFundingValue(Integer fundingValue) {
		this.fundingValue = fundingValue;
	}
	public Integer getFundingId() {
		return fundingId;
	}
	public void setFundingId(Integer fundingId) {
		this.fundingId = fundingId;
	}
	public IdeaModel getIdea() {
		return idea;
	}
	public void setIdea(IdeaModel idea) {
		this.idea = idea;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}

	
	
	
}
