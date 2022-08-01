package com.example.demo;

import com.example.demo.Domain.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class DemoApplicationTests {

	@Autowired UserService userService;
	@Autowired UserRepository userRepository;
	@Test
	public void 회원가입() throws Exception{
		User user = new User();
		user.setName("hello1");

		Long saveId = userService.join(user);

		User findUser = userRepository.findById(saveId).get();
		assert(user.getName().equals(findUser.getName()));
	}


}
