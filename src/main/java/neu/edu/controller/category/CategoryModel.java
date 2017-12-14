package neu.edu.controller.category;

public class CategoryModel {
	
	private Integer categoryId;
	
	private String categoryName;
	private String categoryDesc;
	
	public CategoryModel() {
		
	}

	public CategoryModel(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

//	public void setCategoryId(Integer categoryId) {
//		this.categoryId = categoryId;
//	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	
	

}
