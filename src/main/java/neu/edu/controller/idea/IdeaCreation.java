package neu.edu.controller.idea;

import java.util.Date;

import neu.edu.entity.Bid;
import neu.edu.entity.Category;

public class IdeaCreation {
	
	private String ideaName;
	private String ideaDesc;
	private String goalFunding;
	private String duration;
	private String status;
	private String reason;
	private Integer compilationPercentage;
	private Date startDate;
	private String createdBy;
	private Date createdOn;
	private String endDate;
	private Integer categoryId;
	private Integer bidId;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getBidId() {
		return bidId;
	}

	public void setBidId(Integer bidId) {
		this.bidId = bidId;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getCompilationPercentage() {
		return compilationPercentage;
	}

	public void setCompilationPercentage(Integer compilationPercentage) {
		this.compilationPercentage = compilationPercentage;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
