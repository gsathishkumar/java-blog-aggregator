package com.sathish.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathish.jba.entity.Blog;
import com.sathish.jba.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByUser(User user);
}
