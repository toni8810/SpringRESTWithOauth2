package spring.rest.oauth.service.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.rest.oauth.service.domain.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	Optional<Account> findByUsername(String username);
}
