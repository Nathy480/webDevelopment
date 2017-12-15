package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.controller.idea.IdeaModel;
import neu.edu.entity.Idea;
import neu.edu.entity.User;


@Repository
public interface IdeaDao extends JpaRepository<Idea, Integer>{

	public Idea findByIdeaId(Integer ideaId);
	public List<IdeaModel> findByCategoryCategoryId(Integer categoryId);
	public List<Idea> findByideaName(String ideaName);
	
	
}
