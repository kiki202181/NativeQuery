package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value = "SELECT * FROM user_tb", nativeQuery = true)
	List<User> findAllUser();

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM user_tb WHERE id=?1", nativeQuery = true)
	int deleteUser(@Param("id") Long id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE user_tb SET name=?1 WHERE id=?2", nativeQuery = true)
	int saveUser(@Param("name") String name, @Param("id") Long id);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO user_tb (name) VALUES (?1)", nativeQuery = true)
	int addUser(@Param("name") String name);

	@Transactional
	@Modifying
	@Query(value = "SELECT * FROM user_tb WHERE name LIKE '% ?1 %'", nativeQuery = true)
	List<User> searchUser(@Param("name") String name);

}