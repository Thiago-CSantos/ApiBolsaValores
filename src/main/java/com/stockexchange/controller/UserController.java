package com.stockexchange.controller;

import com.stockexchange.dto.UserDto;
import com.stockexchange.model.usuario.Usuario;
import com.stockexchange.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user/")
public class UserController {

    @Autowired
    private UserService service;

    @Operation(summary = "Criar usuario para salvar as ações pesquisadas", description = " ", tags = {"createUser"},
            responses = {
                    @ApiResponse(description = "Sucesso", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = Usuario.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content}),
                    @ApiResponse(description = "No content", responseCode = "204", content = {@Content}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content}),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
            })
    @PostMapping("/create")
    public ResponseEntity<Usuario> createUser(@RequestBody UserDto userDto) {
        var usuario = new Usuario(userDto);

        return ResponseEntity.ok().body(service.createUsuario(usuario));

    }

    @Operation(summary = "Mostar as ações relacionadas á cada usuario", description = " ", tags = {"getByUser"},
            responses = {
                    @ApiResponse(description = "Sucesso", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = List.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content}),
                    @ApiResponse(description = "No content", responseCode = "204", content = {@Content}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content}),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
            })
    @GetMapping("/get")
    public ResponseEntity<List<Object[]>> getByUser() {
        return ResponseEntity.ok().body(service.getUserStock());
    }
}
