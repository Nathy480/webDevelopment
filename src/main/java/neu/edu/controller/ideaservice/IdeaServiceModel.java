package neu.edu.controller.ideaservice;

import neu.edu.entity.Idea;
import neu.edu.entity.Services;

public class IdeaServiceModel {

	
	private Integer ideaServiceId;
	private Integer ideaId;
	private Integer serviceId;
	
	private Idea idea;
	private Services services;
	
	
	public Idea getIdea() {
		return idea;
	}
	public void setIdea(Idea idea) {
		this.idea = idea;
	}
	public Services getServices() {
		return services;
	}
	public void setServices(Services services) {
		this.services = services;
	}
	public IdeaServiceModel(Integer ideaServiceId2) {
		// TODO Auto-generated constructor stub
	}
	public Integer getIdeaServiceId() {
		return ideaServiceId;
	}
	public void setIdeaServiceId(Integer ideaServiceId) {
		this.ideaServiceId = ideaServiceId;
	}
	public Integer getIdeaId() {
		return ideaId;
	}
	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
