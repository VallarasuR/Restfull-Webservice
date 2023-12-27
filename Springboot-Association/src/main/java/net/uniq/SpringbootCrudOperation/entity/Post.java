package net.uniq.SpringbootCrudOperation.entity;



import jakarta.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return String.format("Post [id=%s, description=%s]", id, description);
	}
	
}

/*
 * Hibernate: select u1_0.id,u1_0.birth_date,u1_0.name from user u1_0 where u1_0.id=?
 * Hibernate: select next_val as id_val from post_seq for update
 * Hibernate: update post_seq set next_val= ? where next_val=?
 * Hibernate: insert into post (description,user_id,id) values (?,?,?)
*/
