package neu.edu.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import neu.edu.controller.category.CategoryModel;
import neu.edu.controller.idea.IdeaCreation;
import neu.edu.controller.idea.IdeaModel;
import neu.edu.controller.user.UserModel;
import neu.edu.dao.BidDao;
import neu.edu.dao.CategoryDao;
import neu.edu.dao.IdeaDao;
import neu.edu.dao.UserDao;
import neu.edu.entity.Category;
import neu.edu.entity.Idea;
import neu.edu.entity.Services;
import neu.edu.entity.User;
import neu.edu.entity.UserRole;

@Service
public class Idea_Service {

	@Autowired
	private IdeaDao ideaDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private BidDao bidDao;

	// Create an idea
	@Transactional
	public IdeaModel createIdea(IdeaCreation ideaCreation) {

		Category category = categoryDao.findOne(ideaCreation.getCategoryId());
		// Bid bid = bidDao.findOne(ideaCreation.getBidId());

		IdeaModel ideaModel = null;

		if (category != null) {

			Idea idea = new Idea();
			idea.setIdeaName(ideaCreation.getIdeaName());
			idea.setIdeaDesc(ideaCreation.getIdeaDesc());
			idea.setGoalFunding(ideaCreation.getGoalFunding());
			idea.setDuration(ideaCreation.getDuration());
			idea.setStatus(ideaCreation.getStatus());
			idea.setStartDate(ideaCreation.getStartDate());
			idea.setCreatedBy(ideaCreation.getCreatedBy());
			idea.setCreatedOn(new Date());
			// idea.setBid(bid);
			idea.setCategory(category);
			idea = ideaDao.save(idea);

			// ---- //

			ideaModel = new IdeaModel();
			ideaModel.setIdeaId(idea.getIdeaId());
			ideaModel.setIdeaName(ideaModel.getIdeaName());
			ideaModel.setIdeaDesc(ideaModel.getIdeaDesc());
			ideaModel.setGoalFunding(ideaModel.getGoalFunding());
			ideaModel.setDuration(ideaModel.getDuration());

			ideaModel.setStatus(ideaModel.getStatus());
			ideaModel.setCreatedBy(ideaModel.getCreatedBy());
			ideaModel.setStartDate(ideaModel.getStartDate());

			CategoryModel categoryModel = new CategoryModel(category.getCategoryId());
			categoryModel.setCategoryName(category.getCategoryName());
			ideaModel.setCategory(categoryModel);

		} else {
			return ideaModel;
		}

		return ideaModel;

	}

	
	// Find All Ideas
	@Transactional
	public List<IdeaModel> findAll() {
		return ideaDao.findAll().stream().map(idea -> {

			IdeaModel temp = new IdeaModel();
			temp.setIdeaId(idea.getIdeaId());
			temp.setIdeaName(idea.getIdeaName());
			temp.setIdeaDesc(idea.getIdeaDesc());

			return temp;
		}).collect(Collectors.toList());
	}
	

	// List By category
	@Transactional
	public List<IdeaModel> listIdeas(Integer categoryId) {
		// TODO Auto-generated method stub
		return ideaDao.findByCategoryCategoryId(categoryId)
					 	 .stream()
					 	 .map(idea->{
								IdeaModel temp = new IdeaModel();
								temp.setIdeaId(idea.getIdeaId());
								temp.setIdeaName(idea.getIdeaName());
								temp.setIdeaDesc(idea.getIdeaDesc());
					 		return temp;
					 	 })
					 	 .collect(Collectors.toList());
	}

	
	// Delete
	@Transactional
	public boolean deleteIdea(Integer ideaId) {
		Idea idea = ideaDao.findOne(ideaId);
		ideaDao.delete(idea);

		return true;
	}
	
	
	
	
	
	
	
}
