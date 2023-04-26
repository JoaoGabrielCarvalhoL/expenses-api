package br.com.carv.expenses.controller;

import br.com.carv.expenses.model.dto.request.ExpensePostRequest;
import br.com.carv.expenses.model.dto.request.ExpensePutRequest;
import br.com.carv.expenses.model.dto.response.ExpenseGetResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Expense Controller", description = "Endpoint for managing expenses.")
public interface ExpenseController {

    @Operation(summary = "Create Expense.", description = "Request to create a new expense.")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Created.", content =
            { @Content(schema = @Schema(implementation = ExpenseGetResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "401", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
    consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ExpenseGetResponse> save(@RequestBody ExpensePostRequest expensePostRequest);

    @Operation(summary = "Update Expense.", description = "Request to update a expense.")
    @ApiResponses(value = { @ApiResponse(responseCode = "204", description = "No Content.", content =
            { @Content(schema = @Schema(implementation = ExpenseGetResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "401", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> update(@RequestBody ExpensePutRequest expensePutRequest);

    @Operation(summary = "Find Expense By Id.", description = "Request to find a expense by id.")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK.", content =
            { @Content(schema = @Schema(implementation = ExpenseGetResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "401", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @GetMapping(value = "/{id}",  produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ExpenseGetResponse> findById(@PathVariable("id") UUID id);

    @Operation(summary = "List all Expenses.", description = "Request to list all expenses.")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK.", content =
            { @Content(schema = @Schema(implementation = ExpenseGetResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "401", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ExpenseGetResponse>> findAll();

    @Operation(summary = "List all Expenses Paginated.", description = "Request to list all expenses paginated.")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK.", content =
            { @Content(schema = @Schema(implementation = ExpenseGetResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "401", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @GetMapping(value = "paginated", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Page<ExpenseGetResponse>> findAllPaginated(Pageable pageable);

    @Operation(summary = "Delete Expense.", description = "Request to delete expense by id.")
    @ApiResponses(value = { @ApiResponse(responseCode = "204", description = "No Content.", content =
            { @Content(schema = @Schema(implementation = ExpenseGetResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "401", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> delete(@PathVariable("id") UUID id);
}
