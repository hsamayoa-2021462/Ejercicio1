package com.hugosamayoa.Ejemplo.repository;


import com.hugosamayoa.Ejemplo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {




}
