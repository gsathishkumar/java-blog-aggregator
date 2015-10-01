package com.sathish.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathish.jba.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
