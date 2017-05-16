package spring.rest.oauth.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.rest.oauth.service.repository.AccountRepository;

@Service
public class AccountUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AccountRepository ar;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		return ar.findByUsername(arg0).map(account -> new User(account.getUsername(), account.getPassword(), account.isActive(),account.isActive(),account.isActive(),account.isActive(),AuthorityUtils.createAuthorityList("ROLE_ADMIN","ROLE_USER")))
		.orElseThrow(() -> new UsernameNotFoundException("Could not find username "+arg0));
	}

}
