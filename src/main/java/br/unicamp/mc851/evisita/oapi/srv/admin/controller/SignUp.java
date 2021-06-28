package br.unicamp.mc851.evisita.oapi.srv.admin.controller;

import br.unicamp.mc851.evisita.oapi.srv.admin.config.security.util.AdminLogin;
import br.unicamp.mc851.evisita.oapi.srv.admin.domain.Admin;
import br.unicamp.mc851.evisita.oapi.srv.admin.usecase.SaveAdmin;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/v1")
@RequiredArgsConstructor
public class SignUp {

    private final SaveAdmin saveAdmin;

    @PostMapping("signup")
    @ApiOperation("Signs up an admin")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Admin signed up"),
            @ApiResponse(code = 400, message = "Nothing done")
    })
    public ResponseEntity<?> signUp(@ApiParam(hidden = true, required = true) @AdminLogin Admin admin) {

        if (saveAdmin.execute(admin)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
