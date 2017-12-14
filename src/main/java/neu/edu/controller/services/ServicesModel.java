package neu.edu.controller.services;

import javax.validation.constraints.NotNull;

public class ServicesModel {

	private Integer serviceId;
	
	@NotNull
	private String servicesName;
	private String servicesDesc;

	public ServicesModel() {
		
	}
	
	public Integer getServiceId() {
		return serviceId;
	}


	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}


	public String getServicesName() {
		return servicesName;
	}


	public void setServicesName(String servicesName) {
		this.servicesName = servicesName;
	}


	public String getServicesDesc() {
		return servicesDesc;
	}


	public void setServicesDesc(String servicesDesc) {
		this.servicesDesc = servicesDesc;
	}


}
