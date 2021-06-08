package ca.est.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Estevam Meneses
 * May 25, 2021
 */
@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "user_id")
	private Long user_id;

	@Column(name = "title")
	private String title;

	@Column(name = "views")
	private Integer views;

	@Column(name = "body")
	private String body;

	@Column(name = "published")
	private Integer published;

	@Column(name = "created_at")
	private String created_at;

	@Column(name = "updated_at")
	private String updated_at;

	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	@JsonManagedReference
	private User user = new User();

	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(Long id, Long user_id, String title, Integer views, String body, Integer published,
			String created_at, String updated_at, User user) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.title = title;
		this.views = views;
		this.body = body;
		this.published = published;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getPublished() {
		return published;
	}

	public void setPublished(Integer published) {
		this.published = published;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public User getUsers() {
		return user;
	}

	public void setUsers(User user) {
		this.user = user;
	}
}
