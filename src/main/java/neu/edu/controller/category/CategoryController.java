package neu.edu.controller.category;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import neu.edu.controller.role.RoleModel;
import neu.edu.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	
	// Create
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createCategory(@RequestBody @Valid CategoryModel categoryModel) {
		ResponseEntity<String> response = new ResponseEntity<String>("Category Not Created",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (categoryService.createCategory(categoryModel) != null) {
			response = new ResponseEntity<String>("Category Created", HttpStatus.OK);
		}
		return response;
	}
	
	// List
	@RequestMapping(method = RequestMethod.GET)
	public List<CategoryModel> findAll() {
		return categoryService.findAll();
	}

	// Update
	@RequestMapping(path = "/{categoryId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCategory(@PathVariable("categoryId") Integer categoryId,
			@RequestBody @Valid CategoryModel newCategory) {
		ResponseEntity<?> response = new ResponseEntity<>("Category Not Updated", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = categoryService.updateCategory(categoryId, newCategory);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}
	

	
	

}






















