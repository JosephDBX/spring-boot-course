package com.josephdbx.springbootcourse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringBootCourseApplicationTests {

	@Test
	void contextLoads() {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.err.println(pe.encode("qwerty"));
	}

}
