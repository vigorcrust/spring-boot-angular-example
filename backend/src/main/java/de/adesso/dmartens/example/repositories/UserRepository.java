package de.adesso.dmartens.example.repositories;

import de.adesso.dmartens.example.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findOneByUsername(String username);
}
