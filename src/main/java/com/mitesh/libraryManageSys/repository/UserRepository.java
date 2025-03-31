package com.mitesh.libraryManageSys.repository;

import com.mitesh.libraryManageSys.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
