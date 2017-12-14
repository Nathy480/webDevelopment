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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "webdevelopment")
public class User implements java.io.Serializable {

	private Integer userId;
	private Person person;
	private String username;
	private String password;
	private Integer status;
	private String reason;
	private Date createdOn;
	private Date updateOn;
	private Set<Bid> bids = new HashSet<Bid>(0);
	private Set<Funding> fundings = new HashSet<Funding>(0);
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	public User() {
	}

	public User(Person person, String username, String password) {
		this.person = person;
		this.username = username;
		this.password = password;
	}

	public User(Person person, String username, String password, Integer status, String reason, Date createdOn,
			Date updateOn, Set<Bid> bids, Set<Funding> fundings, Set<UserRole> userRoles) {
		this.person = person;
		this.username = username;
		this.password = password;
		this.status = status;
		this.reason = reason;
		this.createdOn = createdOn;
		this.updateOn = updateOn;
		this.bids = bids;
		this.fundings = fundings;
		this.userRoles = userRoles;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", nullable = false)
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Column(name = "username", nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 256)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "reason", length = 200)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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
	@Column(name = "update_on", length = 19)
	public Date getUpdateOn() {
		return this.updateOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Bid> getBids() {
		return this.bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Funding> getFundings() {
		return this.fundings;
	}

	public void setFundings(Set<Funding> fundings) {
		this.fundings = fundings;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}
