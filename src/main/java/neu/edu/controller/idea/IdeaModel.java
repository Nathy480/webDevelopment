package neu.edu.controller.idea;

import java.util.Date;

import neu.edu.controller.bid.BidModel;
import neu.edu.controller.category.CategoryModel;



public class IdeaModel {

	private Integer ideaId;
	private CategoryModel category;
	private BidModel bid;
	private String ideaName;
	private String ideaDesc;
	private String goalFunding;
	private String duration;
	private String status;
	private String createdBy;
	private Date startDate;
	

	
	public IdeaModel(Integer ideaId2) {
		// TODO Auto-generated constructor stub
	}
	public IdeaModel() {
		// TODO Auto-generated constructor stub
	}
	public String getGoalFunding() {
		return goalFunding;
	}
	public void setGoalFunding(String goalFunding) {
		this.goalFunding = goalFunding;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getIdeaName() {
		return ideaName;
	}
	public void setIdeaName(String ideaName) {
		this.ideaName = ideaName;
	}
	public String getIdeaDesc() {
		return ideaDesc;
	}
	public void setIdeaDesc(String ideaDesc) {
		this.ideaDesc = ideaDesc;
	}
	public Integer getIdeaId() {
		return ideaId;
	}
	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
	}
	public CategoryModel getCategory() {
		return category;
	}
	public void setCategory(CategoryModel category) {
		this.category = category;
	}
	public BidModel getBid() {
		return bid;
	}
	public void setBid(BidModel bid) {
		this.bid = bid;
	}

	
}
