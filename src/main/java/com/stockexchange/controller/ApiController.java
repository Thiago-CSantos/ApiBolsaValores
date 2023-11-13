package com.stockexchange.controller;

import com.stockexchange.service.AlphaVantageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/finance")
@Tag(name = "ApiController", description = "Endpoints para gerenciamento da API Alpha Vantage")
public class ApiController {

    @Autowired
    private AlphaVantageService service;

    @Operation(summary = "Buscar ação pela 'Date' e 'Symbol'", description = " ", tags = {"getAll"},
            responses = {
                    @ApiResponse(description = "Sucesso", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = String.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content}),
                    @ApiResponse(description = "No content", responseCode = "204", content = {@Content}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content}),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
            })
    @GetMapping("/price/{date}")
    public ResponseEntity<String> getAll(@PathVariable(value = "date") String date, @RequestParam String symbol) throws IOException, InterruptedException {
        return ResponseEntity.ok(service.getPrice(date, symbol));
    }

    @Operation(summary = "Buscar ação pela 'Date' e 'Symbol'", description = "Buscar o preço de fechamento da ação",
            tags = {"getByPriceClose"},
            responses = {
                    @ApiResponse(description = "Sucesso", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = String.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content}),
                    @ApiResponse(description = "No content", responseCode = "204", content = {@Content}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content}),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
            })
    @GetMapping("/price/close/{date}")
    public ResponseEntity<String> getByPriceClose(@PathVariable(value = "date") String date, @RequestParam String symbol) {
        return ResponseEntity.ok(service.getByPriceClose(date, symbol));
    }
}
