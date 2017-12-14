package neu.edu.entity;
// Generated Dec 12, 2017 2:06:43 PM by Hibernate Tools 5.2.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "webdevelopment")
public class Category implements java.io.Serializable {

	private Integer categoryId;
	private String categoryName;
	private String categoryDesc;
	private Date createdOn;
	private Date createdBy;
	private Set<CategoryStartup> categoryStartups = new HashSet<CategoryStartup>(0);
	private Set<Idea> ideas = new HashSet<Idea>(0);

	public Category() {
	}

	public Category(String categoryName, String categoryDesc) {
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
	}

	public Category(String categoryName, String categoryDesc, Date createdOn, Date createdBy,
			Set<CategoryStartup> categoryStartups, Set<Idea> ideas) {
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.categoryStartups = categoryStartups;
		this.ideas = ideas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "category_id", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "category_name", nullable = false, length = 45)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "category_desc", nullable = false, length = 45)
	public String getCategoryDesc() {
		return this.categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", length = 19)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_by", length = 19)
	public Date getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<CategoryStartup> getCategoryStartups() {
		return this.categoryStartups;
	}

	public void setCategoryStartups(Set<CategoryStartup> categoryStartups) {
		this.categoryStartups = categoryStartups;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Idea> getIdeas() {
		return this.ideas;
	}

	public void setIdeas(Set<Idea> ideas) {
		this.ideas = ideas;
	}

}
