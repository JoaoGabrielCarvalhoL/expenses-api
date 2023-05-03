package br.com.carv.expenses.controller;

import br.com.carv.expenses.model.enumerated.Category;
import br.com.carv.expenses.model.dto.response.ExpenseSimpleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Tag(name = "Expense Controller Info", description = "Endpoint for expenses information.")
public interface ExpenseControllerInfo {

    @Operation(summary = "Find Expense By Name", description = "Endpoint to find expense by name ignore case.")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(schema = @Schema(implementation = ExpenseSimpleResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "403", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, value = "/name")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ExpenseSimpleResponse>> findExpenseByNameIgnoreCase(@RequestParam(required = true, name = "name")
                                                                      String name, Pageable pageable);

    @Operation(summary = "Find Expense By Name", description = "Endpoint to find expense by name containing.")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(schema = @Schema(implementation = ExpenseSimpleResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "403", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, value = "/name-containing")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ExpenseSimpleResponse>> findExpenseByNameContaining(@RequestParam(required = true, name = "name")
                                                                      String name, Pageable pageable);

    @Operation(summary = "Find Expense By Category", description = "Endpoint to find expense by category.")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(schema = @Schema(implementation = ExpenseSimpleResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "403", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, value = "/category")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ExpenseSimpleResponse>> findExpenseByCategory(@RequestParam(required = true, name = "category")
                                                                      Category category, Pageable pageable);

    @Operation(summary = "Find Expense By Description", description = "Endpoint to find expense by description containing.")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(schema = @Schema(implementation = ExpenseSimpleResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "403", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, value = "/description-containing")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ExpenseSimpleResponse>> findExpenseByDescriptionContaining(@RequestParam(required = true, name = "description")
                                                                      String description, Pageable pageable);


    @Operation(summary = "Find Expense By Period", description = "Endpoint to find expense by period date.")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(schema = @Schema(implementation = ExpenseSimpleResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "403", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, value = "/date")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ExpenseSimpleResponse>> findExpenseByDateBetween(@RequestParam(required = true, name = "start")
                                                                   LocalDate start,
                                                                   @RequestParam(required = true, name = "end") LocalDate end,
                                                                   Pageable pageable);

    @Operation(summary = "Get total value spent in period", description = "Endpoint to calculate total value spent in period.")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(schema = @Schema(implementation = ExpenseSimpleResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "403", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @GetMapping(value = "/amount-period")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<BigDecimal> totalAmountExpensesInPeriod(@RequestParam(required = true, name = "start")
                                                           LocalDate start,
                                                           @RequestParam(required = true, name = "end") LocalDate end);

    @Operation(summary = "Get total value spent in period by category", description = "Endpoint to calculate total value spent in period by category.")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(schema = @Schema(implementation = ExpenseSimpleResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "403", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @GetMapping(value = "/amount-period-category")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<BigDecimal> totalAmountExpensesInPeriodByCategory(@RequestParam(required = true, name = "start") LocalDate start,
                                                           @RequestParam(required = true, name = "end") LocalDate end,
                                                                     @RequestParam(required = true, name = "category") Category category);

    @Operation(summary = "Find All Bill Expense By Period", description = "Endpoint to find all bill expense by period date.")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(schema = @Schema(implementation = ExpenseSimpleResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "403", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, value = "/allBills-period")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ExpenseSimpleResponse>> findAllBillExpenseInPeriod(@RequestParam(required = true, name = "start")
                                                                   LocalDate start,
                                                                         @RequestParam(required = true, name = "end") LocalDate end);


    @Operation(summary = "Get total value spent in bill by period", description = "Endpoint to calculate total value spent in bill by in period.")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(schema = @Schema(implementation = ExpenseSimpleResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request."),
            @ApiResponse(responseCode = "403", description = "Unauthorized."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.")})
    @GetMapping(value = "/amount-bill-period")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<BigDecimal> totalAmountBillExpensesInPeriod(@RequestParam(required = true, name = "start") LocalDate start,
                                                                     @RequestParam(required = true, name = "end") LocalDate end);



}
