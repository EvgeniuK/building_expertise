package com.example.tms.building_expertise.repo;

import com.example.tms.building_expertise.domain_db.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
