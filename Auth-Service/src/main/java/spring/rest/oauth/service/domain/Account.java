package spring.rest.oauth.service.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	@GeneratedValue
	private Long id;
	private String username, password;
	private boolean active;
	
	public Account(String username, String password, boolean active) {
		this.username = username;
		this.password = password;
		this.active = active;
	}
	
	public Account(Long id, String username, String password, boolean active) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.active = active;
	}
	public Account(){}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
	
}
