package neu.edu.controller.categorystartup;

import neu.edu.controller.category.CategoryModel;
import neu.edu.controller.person.PersonModel;
import neu.edu.entity.Category;
import neu.edu.entity.Person;

public class CategoryStartupModel {
	
	private Integer categoryStartupId;
	private PersonModel personModel;
	private CategoryModel catModel;
	
	
	
	public CategoryStartupModel(Integer categoryStartupId2) {
		// TODO Auto-generated constructor stub
	}
	public CategoryStartupModel() {
		// TODO Auto-generated constructor stub
	}
	public Integer getCategoryStartupId() {
		return categoryStartupId;
	}
	public void setCategoryStartupId(Integer categoryStartupId) {
		this.categoryStartupId = categoryStartupId;
	}
	public PersonModel getPersonModel() {
		return personModel;
	}
	public void setPersonModel(PersonModel personModel) {
		this.personModel = personModel;
	}
	public CategoryModel getCatModel() {
		return catModel;
	}
	public void setCatModel(CategoryModel catModel) {
		this.catModel = catModel;
	}
	
	




}
