package spring.rest.oauth.service.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.rest.oauth.service.domain.Account;
import spring.rest.oauth.service.repository.AccountRepository;

@RestController
@EnableResourceServer
public class AppController extends ResourceServerConfigurerAdapter {
	
	@Autowired
	private AccountRepository ar;
	
	@RequestMapping(value="/account", method=RequestMethod.POST)
	public ResponseEntity<Void> signUp(Account a) {
		ar.save(a);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@RequestMapping(value="/account", method=RequestMethod.GET)
	public List<Account> getAllAccounts() {
		List<Account> returnList = new ArrayList<>();
		ar.findAll().forEach(account -> returnList.add(account));
		return returnList;
	}
	@RequestMapping(value="/account/{username}", method=RequestMethod.GET)
	public Account getByUsername(@PathVariable String username) {
		return ar.findByUsername(username).map(account -> new Account(account.getId(), account.getUsername(), account.getPassword(), account.isActive()))
				.orElse(null);
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/account").hasRole("USER");
	}
	
	
}
