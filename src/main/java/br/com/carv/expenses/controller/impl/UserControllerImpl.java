package br.com.carv.expenses.controller.impl;

import br.com.carv.expenses.controller.UserController;
import br.com.carv.expenses.model.dto.request.UserPostRequest;
import br.com.carv.expenses.model.dto.request.UserPutRequest;
import br.com.carv.expenses.model.dto.response.UserGetResponse;
import br.com.carv.expenses.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserGetResponse> save(UserPostRequest userPostRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.save(userPostRequest));
    }

    @Override
    public ResponseEntity<Void> update(UserPutRequest userPutRequest) {
        this.userService.update(userPutRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<UserGetResponse> findById(UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.findById(id));
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        this.userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
