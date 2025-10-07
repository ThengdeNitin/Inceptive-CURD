package com.curd.MySQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curd.MySQL.entity.User;

public interface MyRepository extends JpaRepository<User, Long> {

}
