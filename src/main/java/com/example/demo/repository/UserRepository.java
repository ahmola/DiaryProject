package com.example.demo.repository;

import com.example.demo.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// DAO
// 자동으로 bean 등록, @Repository 생략가능
public interface UserRepository extends JpaRepository<user, Integer> {  // user테이블을 관리하고 primary키는 integer임
    @Query("SELECT u FROM user u WHERE u.password = :password")
    List<user> findByPassword(@Param("password") String password);

    @Query("SELECT u FROM user u WHERE u.username = :username")
    List<user> findByUsername(@Param("username") String username);
}