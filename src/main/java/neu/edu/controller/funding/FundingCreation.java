package neu.edu.controller.funding;

import neu.edu.entity.Idea;
import neu.edu.entity.User;

public class FundingCreation {

	
	private Integer fundingId;
	private Integer ideaId;
	private Integer userId;
	private Integer fundingValue;
	private Byte fundedRecieved;
	
	
	public Integer getFundingId() {
		return fundingId;
	}
	public void setFundingId(Integer fundingId) {
		this.fundingId = fundingId;
	}
	public Integer getIdeaId() {
		return ideaId;
	}
	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getFundingValue() {
		return fundingValue;
	}
	public void setFundingValue(Integer fundingValue) {
		this.fundingValue = fundingValue;
	}
	public Byte getFundedRecieved() {
		return fundedRecieved;
	}
	public void setFundedRecieved(Byte fundedRecieved) {
		this.fundedRecieved = fundedRecieved;
	}

	
	
}
