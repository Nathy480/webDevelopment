package neu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import neu.edu.entity.Funding;

public interface FundingDao extends JpaRepository<Funding, Integer>{

}
