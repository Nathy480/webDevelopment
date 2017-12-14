package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.controller.user.UserCreation;
import neu.edu.entity.Person;
import neu.edu.entity.Role;
import neu.edu.entity.User;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {
	
		
	public List<Person> findByPersonId(Integer personId);
	

}
