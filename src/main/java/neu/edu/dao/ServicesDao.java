package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Services;

@Repository
public interface ServicesDao extends JpaRepository<Services, Integer> {

	public List<Services> findByServicesName(String servicesName);
	public Services findByServicesId(Integer servicesId);

}
