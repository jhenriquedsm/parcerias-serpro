package com.jhenriquedsm.parcerias_serpro.repositories;

import com.jhenriquedsm.parcerias_serpro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
}
