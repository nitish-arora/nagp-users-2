package arora.nitish.users.services.impl;

import static arora.nitish.users.constant.ErrorMessages.NO_USER_FOUND;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import arora.nitish.users.dto.response.UserResponse;
import arora.nitish.users.entities.User;
import arora.nitish.users.exception.UserRuntimeException;
import arora.nitish.users.repositories.UserRepository;
import arora.nitish.users.services.UserService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	/**
	 * {@inheritDoc}
	 */
	public UserResponse getUserData(Integer userId) {
		log.info("fetching the user with userId: {}", userId);
		Optional<User> resultingUser = userRepository.findById(userId);
		if (resultingUser.isPresent()) {
			return new UserResponse(HttpStatus.OK, resultingUser.get());
		}
		log.error("No user found with userId: {}", userId);
		throw new UserRuntimeException(NO_USER_FOUND);
	}

}
