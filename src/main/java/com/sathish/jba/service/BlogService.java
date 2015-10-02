package com.sathish.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathish.jba.entity.Blog;
import com.sathish.jba.entity.User;
import com.sathish.jba.repository.BlogRepository;
import com.sathish.jba.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BlogRepository blogRepository;

	public void save(Blog blog, String userName) {
		User user = userRepository.findByName(userName);
		blog.setUser(user);
		blogRepository.save(blog);
	}

}
