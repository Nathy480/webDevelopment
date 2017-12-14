package neu.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neu.edu.entity.Bid;

@Repository
public interface BidDao extends JpaRepository<Bid, Integer>{
	
	public Bid findByBidId(Integer bidId);	
	public List<Bid> findByIdeaServiceIdeaServiceId(Integer ideaserviceId);
	

}
