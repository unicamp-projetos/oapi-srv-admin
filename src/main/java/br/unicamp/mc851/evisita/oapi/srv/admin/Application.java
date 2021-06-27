package br.unicamp.mc851.evisita.oapi.srv.admin;

import br.unicamp.mc851.evisita.oapi.srv.admin.domain.Admin;
import br.unicamp.mc851.evisita.oapi.srv.admin.usecase.SaveAdmin;
import br.unicamp.mc851.evisita.oapi.srv.admin.usecase.impl.SaveAdminImpl;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.crypto.generators.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
