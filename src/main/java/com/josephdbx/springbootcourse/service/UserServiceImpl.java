package com.josephdbx.springbootcourse.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.josephdbx.springbootcourse.dao.UserRepository;
import com.josephdbx.springbootcourse.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> oUser = userRepository.findByUsername(username);

		if (!oUser.isPresent()) {
			throw new UsernameNotFoundException("User name: '" + username + "' not found!");
		}

//		List<GrantedAuthority> roles = new ArrayList<>();
//
//		if (!oUser.get().getRoles().isEmpty()) {
//			oUser.get().getRoles().forEach(role -> {
//				roles.add(new SimpleGrantedAuthority(role.getRolename()));
//			});
//		}

		return new org.springframework.security.core.userdetails.User(oUser.get().getUsername(),
				oUser.get().getPassword(), new ArrayList<>());
	}
}
