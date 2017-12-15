package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.edu.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

	//	public List<Category> findByCategoryId(Integer CategoryId);
		public Category findByCategoryId(Integer CategoryId);		
		public Category findByCategoryName(String categoryName);
}
