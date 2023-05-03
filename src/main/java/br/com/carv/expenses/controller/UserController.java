package br.com.carv.expenses.controller;

import br.com.carv.expenses.model.dto.request.UserPostRequest;
import br.com.carv.expenses.model.dto.request.UserPutRequest;
import br.com.carv.expenses.model.dto.response.UserGetResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "User Controller", description = "Endpoint for managing users.")
public interface UserController {

    @Operation(summary = "Create User.", description = "Request to create a new user.")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Created.", content =
            { @Content(schema = @Schema(implementation = UserGetResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "401", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<UserGetResponse> save(@RequestBody @Valid UserPostRequest userPostRequest);

    @Operation(summary = "Update User.", description = "Request to update a user.")
    @ApiResponses(value = { @ApiResponse(responseCode = "204", description = "No Content.", content =
            { @Content(schema = @Schema(implementation = UserGetResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "401", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> update(@RequestBody @Valid UserPutRequest userPutRequest);

    @Operation(summary = "Find User By Id.", description = "Request to find a user by id.")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK.", content =
            { @Content(schema = @Schema(implementation = UserGetResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "401", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @GetMapping(value = "/{id}",  produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<UserGetResponse> findById(@PathVariable("id") UUID id);

    @Operation(summary = "Delete User.", description = "Request to delete user by id.")
    @ApiResponses(value = { @ApiResponse(responseCode = "204", description = "No Content.", content =
            { @Content(schema = @Schema(implementation = UserGetResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "401", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> delete(@PathVariable("id") UUID id);
}
