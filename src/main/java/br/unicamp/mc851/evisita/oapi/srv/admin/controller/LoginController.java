package br.unicamp.mc851.evisita.oapi.srv.admin.controller;

import br.unicamp.mc851.evisita.oapi.srv.admin.config.security.util.AdminLogin;
import br.unicamp.mc851.evisita.oapi.srv.admin.domain.Admin;
import br.unicamp.mc851.evisita.oapi.srv.admin.usecase.Authenticate;
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
public class LoginController {
    private final Authenticate authenticate;

    @PostMapping("/login")
    @ApiOperation("Check if authentication is valid")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Login validated"),
            @ApiResponse(code = 400, message = "Login not validated")
    })
    public ResponseEntity<Object> authenticate(@ApiParam(hidden = true, required = true) @AdminLogin Admin admin) {
        if (authenticate.execute(admin)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
