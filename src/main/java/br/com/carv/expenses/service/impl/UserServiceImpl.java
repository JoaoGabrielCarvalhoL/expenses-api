package br.com.carv.expenses.service.impl;

import br.com.carv.expenses.controller.impl.UserControllerImpl;
import br.com.carv.expenses.exception.UserNotFoundException;
import br.com.carv.expenses.mapper.UserMapper;
import br.com.carv.expenses.model.User;
import br.com.carv.expenses.model.dto.request.UserPostRequest;
import br.com.carv.expenses.model.dto.request.UserPutRequest;
import br.com.carv.expenses.model.dto.response.UserGetResponse;
import br.com.carv.expenses.model.dto.response.UserSimpleResponse;
import br.com.carv.expenses.repository.UserRepository;
import br.com.carv.expenses.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;
    private final Logger logger = Logger.getLogger(UserServiceImpl.class.getCanonicalName());

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserSimpleResponse> findAll() {
        logger.info("Getting all users.");
        return this.userRepository.findAll().stream()
                .map(userMapper::toUserSimpleResponse).collect(Collectors.toList());
    }

    @Override
    public Page<UserSimpleResponse> findAllPaginated(Pageable pageable) {
        logger.info("Getting all users paginated.");
        List<UserSimpleResponse> collect = this.userRepository.findAll()
                .stream().map(userMapper::toUserSimpleResponse)
                .toList();
        return new PageImpl<UserSimpleResponse>(collect, pageable, collect.size());
    }

    @Override
    public UserGetResponse save(UserPostRequest userPostRequest) {
        logger.info("Saving user into database.");
        User user = userMapper.toUser(userPostRequest);
        user.setPassword(passwordEncoder.encode(userPostRequest.password()));
        User saved = this.userRepository.save(user);
        UserGetResponse userGetResponse = userMapper.toUserGetResponse(saved);
        return userGetResponse.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserControllerImpl.class)
                .findById(saved.getId())).withSelfRel());

    }

    @Override
    public UserGetResponse update(UserPutRequest userPutRequest) {
        logger.info("Updating user into database.");
        User user = userMapper.toUser(userPutRequest);
        User saved = this.userRepository.saveAndFlush(user);
        UserGetResponse userGetResponse = userMapper.toUserGetResponse(saved);
        return userGetResponse.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserControllerImpl.class)
                .findById(saved.getId())).withSelfRel());
    }

    @Override
    public void delete(UUID uuid) {
        logger.info("Deleting user with id: " + uuid);
        this.userRepository.delete(findEntity(uuid));
    }

    @Override
    public UserGetResponse findById(UUID uuid) {
        UserGetResponse userGetResponse = this.userRepository.findById(uuid).stream().map(userMapper::toUserGetResponse)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found into database. Id: " + uuid));
        return userGetResponse.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserControllerImpl.class)
                .findById(userGetResponse.getId())).withSelfRel());
    }

    @Override
    public UserSimpleResponse findUserByUsername(String username) {
        logger.info("Finding user by username: " + username);
        return userRepository.findByUsername(username).map(userMapper::toUserSimpleResponse)
                .orElseThrow(() -> new UserNotFoundException("User not found into database with username: " + username));

    }

    private User findEntity(UUID uuid) {
        return this.userRepository.findById(uuid)
                .orElseThrow(() -> new UserNotFoundException("User not found into database."));
    }
}
