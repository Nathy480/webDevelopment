package neu.edu.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.category.CategoryModel;
import neu.edu.controller.categorystartup.CategoryStartupModel;
import neu.edu.dao.CategoryStartupDao;
import neu.edu.entity.Category;
import neu.edu.entity.CategoryStartup;

@Service
public class CategoryStartupService {
	
	@Autowired
	private CategoryStartupDao categoryStartupDao;
	
	@Transactional
	public Integer createCatStart(CategoryStartupModel categoryStartupModel) {

		CategoryStartup categoryStartup = new CategoryStartup();
		

		return categoryStartup.getCategoryStartupId();

	}
	
	
	
	
	
	

}
