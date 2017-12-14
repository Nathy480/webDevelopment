package neu.edu.controller.bid;

public class BidModel {
	
	
	private Integer bidId;	
	private int bidValue;
	private String descriptionWork;
	private Integer userId;
	private Integer ideaServicesId;
	
	
	
	public BidModel() {
		
	}
	
	public Integer getBidId() {
		return bidId;
	}
	
	public void setBidId(Integer bidId) {
		this.bidId = bidId;
	}
	
	public int getBidValue() {
		return bidValue;
	}
	
	public void setBidValue(int bidValue) {
		this.bidValue = bidValue;
	}
	
	public String getDescriptionWork() {
		return descriptionWork;
	}

	public void setDescriptionWork(String descriptionWork) {
		this.descriptionWork = descriptionWork;
	}


}
