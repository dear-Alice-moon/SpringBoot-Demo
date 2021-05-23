package com.moon.jpa;

import com.moon.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query(value = "SELECT id, name, age, create_date FROM user u WHERE u.name = ?", nativeQuery = true)
    User findUser(@Param("name") String name);

}
