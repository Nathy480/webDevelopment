package neu.edu.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.category.CategoryModel;
import neu.edu.controller.role.RoleModel;
import neu.edu.dao.CategoryDao;
import neu.edu.entity.Category;
import neu.edu.entity.Role;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Transactional
	public Integer createCategory(CategoryModel categoryModel) {

		Category category = new Category();
		category.setCategoryName(categoryModel.getCategoryName());
		category.setCategoryDesc(categoryModel.getCategoryDesc());
		category.setCreatedOn(new Date());
		category.setCreatedBy(new Date());
		category = categoryDao.save(category);

		System.out.println("Category Created" + category.getCategoryId());

		return category.getCategoryId();

	}

	@Transactional
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll().stream().map(x -> {
			CategoryModel temp = new CategoryModel(x.getCategoryId());
			temp.setCategoryName(x.getCategoryName());
			temp.setCategoryDesc(x.getCategoryDesc());
			return temp;
		}).collect(Collectors.toList());
	}

	@Transactional
	public boolean updateCategory(Integer categoryId, CategoryModel newCategory) {

		Category tobeUpdated = categoryDao.findOne(categoryId);
		tobeUpdated.setCategoryName(newCategory.getCategoryName());
		tobeUpdated.setCategoryDesc(newCategory.getCategoryDesc());
		categoryDao.save(tobeUpdated);
		return true;		
	}
//	
//	
//	@Transactional
//	public CategoryModel CategoryDetails (String categoryName) {
//		
//		Category category = categoryDao.findByCategoryName(categoryName);		
//		
//		if (category == null ) {
//			return null;
//		}
//		return null;
//	}
//	
//	
//	
	
	

}
