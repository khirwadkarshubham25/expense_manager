package org.expenseManager.repositories;

import org.expenseManager.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findUsersByEmail(String email);

    boolean existsByEmail(String email);

    Users findUsersById(Long id);
}
