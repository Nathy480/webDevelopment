package neu.edu.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.controller.category.CategoryModel;
import neu.edu.controller.categorystartup.CategoryStartupCreation;
import neu.edu.controller.categorystartup.CategoryStartupModel;
import neu.edu.controller.person.PersonModel;
import neu.edu.controller.services.ServicesModel;
import neu.edu.dao.CategoryDao;
import neu.edu.dao.CategoryStartupDao;
import neu.edu.dao.PersonDao;
import neu.edu.entity.Category;
import neu.edu.entity.CategoryStartup;
import neu.edu.entity.Person;
import neu.edu.entity.UserRole;

@Service
public class CategoryStartupService {

	@Autowired
	private CategoryStartupDao categoryStartupDao;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private CategoryDao categoryDao;

	// Create Relation
	@Transactional
	public CategoryStartupModel createCatStart(CategoryStartupCreation cateCreation) {

		Person person = personDao.findByPersonId(cateCreation.getPersonId());
		Category category = categoryDao.findByCategoryId(cateCreation.getCategoryId());

		CategoryStartupModel temp = null;

		if (( person.getConpanyName() != null & category != null)) {
			CategoryStartup catSt = new CategoryStartup();
			catSt.setPerson(person);
			catSt.setCategory(category);
			catSt = categoryStartupDao.save(catSt);

			temp = new CategoryStartupModel();
			temp.setCategoryStartupId(catSt.getCategoryStartupId());

			PersonModel personModel = new PersonModel(person.getConpanyName());
			CategoryModel catModel = new CategoryModel(category.getCategoryId());
			
			temp.setPersonModel(personModel);
			temp.setCatModel(catModel);

		} else {
			return temp;
		}
		return temp;

	}

	
	
	// Delete 
	@Transactional
	public boolean deleteStartRel( Integer staryupId) {
		CategoryStartup StartupRel = categoryStartupDao.findOne(staryupId);
		categoryStartupDao.delete(StartupRel);
		return true;
	}

	
	// List
	@Transactional
	public List<CategoryStartupModel> findAll() {
		// TODO Auto-generated method stub
		return categoryStartupDao.findAll().stream().map(x -> {
			
			CategoryStartupModel temp = new CategoryStartupModel(x.getCategoryStartupId());
			temp.setCategoryStartupId(x.getCategoryStartupId());
			
			Person person = x.getPerson();
			Category category = x.getCategory();
			
			PersonModel personModel = new PersonModel(person.getConpanyName());
			CategoryModel catModel = new CategoryModel(category.getCategoryId());
			personModel.setPersonId(person.getPersonId());
			catModel.setCategoryName(category.getCategoryName());
			
			temp.setPersonModel(personModel);
			temp.setCatModel(catModel);
			

			return temp;
		}).collect(Collectors.toList());
	}

	
	
	
	
	
}

