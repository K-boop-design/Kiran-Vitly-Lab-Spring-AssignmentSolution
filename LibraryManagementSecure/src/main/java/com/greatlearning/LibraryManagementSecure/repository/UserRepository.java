package com.greatlearning.LibraryManagementSecure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.LibraryManagementSecure.entity.User;

public interface UserRepository extends JpaRepository<com.greatlearning.LibraryManagementSecure.entity.User,Long> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public com.greatlearning.LibraryManagementSecure.entity.User getUserByUsername(String username);
}