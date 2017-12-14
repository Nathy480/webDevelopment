package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.edu.entity.Idea;

public interface IdeaDao extends JpaRepository<Idea, Integer>{

}
