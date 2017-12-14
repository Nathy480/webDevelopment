package neu.edu.entity;
// Generated Dec 12, 2017 2:06:43 PM by Hibernate Tools 5.2.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Bid generated by hbm2java
 */
@Entity
@Table(name = "bid", catalog = "webdevelopment")
public class Bid implements java.io.Serializable {

	private Integer bidId;
	private IdeaService ideaService;
	private User user;
	private int bidValue;
	private String descriptionWork;
	private Set<Idea> ideas = new HashSet<Idea>(0);

	public Bid() {
	}

	public Bid(IdeaService ideaService, User user, int bidValue, String descriptionWork) {
		this.ideaService = ideaService;
		this.user = user;
		this.bidValue = bidValue;
		this.descriptionWork = descriptionWork;
	}

	public Bid(IdeaService ideaService, User user, int bidValue, String descriptionWork, Set<Idea> ideas) {
		this.ideaService = ideaService;
		this.user = user;
		this.bidValue = bidValue;
		this.descriptionWork = descriptionWork;
		this.ideas = ideas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "bid_id", unique = true, nullable = false)
	public Integer getBidId() {
		return this.bidId;
	}

	public void setBidId(Integer bidId) {
		this.bidId = bidId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idea_services_id", nullable = false)
	public IdeaService getIdeaService() {
		return this.ideaService;
	}

	public void setIdeaService(IdeaService ideaService) {
		this.ideaService = ideaService;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "bid_value", nullable = false)
	public int getBidValue() {
		return this.bidValue;
	}

	public void setBidValue(int bidValue) {
		this.bidValue = bidValue;
	}

	@Column(name = "description_work", nullable = false, length = 45)
	public String getDescriptionWork() {
		return this.descriptionWork;
	}

	public void setDescriptionWork(String descriptionWork) {
		this.descriptionWork = descriptionWork;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bid")
	public Set<Idea> getIdeas() {
		return this.ideas;
	}

	public void setIdeas(Set<Idea> ideas) {
		this.ideas = ideas;
	}

}
