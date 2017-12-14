package neu.edu.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import neu.edu.controller.services.ServicesModel;
import neu.edu.dao.ServicesDao;
import neu.edu.entity.Role;
import neu.edu.entity.Services;
import neu.edu.entity.UserRole;

@Service
public class ServicesService {

	@Autowired
	private ServicesDao servicesDao;

	@Transactional
	public Integer createServices(ServicesModel serviceModel) {

		Services services = new Services();
		services.setServicesName(serviceModel.getServicesName());
		services.setServicesDesc(serviceModel.getServicesDesc());
		services.setCreatedOn(new Date());
		services = servicesDao.save(services);

		System.out.println("Services created " + services.getServicesId());
		return services.getServicesId();

	}

	@Transactional
	public boolean deleteServices(Integer serviceId) {

		Services services = servicesDao.findOne(serviceId);
		servicesDao.delete(services);

		return true;
	}

}
