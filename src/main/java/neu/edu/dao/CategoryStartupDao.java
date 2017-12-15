package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.edu.entity.Category;
import neu.edu.entity.CategoryStartup;
import neu.edu.entity.Person;
import neu.edu.entity.UserRole;

public interface CategoryStartupDao extends JpaRepository<CategoryStartup, Integer>{

	public List <CategoryStartup>  findByCategoryCategoryId ( Integer categoryId);
	public List<CategoryStartup> findByPersonPersonId(Integer personId);
	
	public CategoryStartup findByCategoryStartupId(Integer startUpId);
}
