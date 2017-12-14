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
 * Person generated by hbm2java
 */
@Entity
@Table(name = "person", catalog = "webdevelopment")
public class Person implements java.io.Serializable {

	private Integer personId;
	private String firstName;
	private String lastName;
	private String email;
	private Date dob;
	private String conpanyName;
	private Set<User> users = new HashSet<User>(0);
	private Set<CategoryStartup> categoryStartups = new HashSet<CategoryStartup>(0);

	public Person() {
	}

	public Person(String firstName, String lastName, String email, Date dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
	}

	public Person(String firstName, String lastName, String email, Date dob, String conpanyName, Set<User> users,
			Set<CategoryStartup> categoryStartups) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.conpanyName = conpanyName;
		this.users = users;
		this.categoryStartups = categoryStartups;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "person_id", unique = true, nullable = false)
	public Integer getPersonId() {
		return this.personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	@Column(name = "first_name", nullable = false, length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false, length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dob", nullable = false, length = 10)
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "conpany_name", length = 45)
	public String getConpanyName() {
		return this.conpanyName;
	}

	public void setConpanyName(String conpanyName) {
		this.conpanyName = conpanyName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
	public Set<CategoryStartup> getCategoryStartups() {
		return this.categoryStartups;
	}

	public void setCategoryStartups(Set<CategoryStartup> categoryStartups) {
		this.categoryStartups = categoryStartups;
	}

}
