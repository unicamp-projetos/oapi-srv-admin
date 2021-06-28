package br.unicamp.mc851.evisita.oapi.srv.admin.usecase.impl;

import br.unicamp.mc851.evisita.oapi.srv.admin.database.dto.AdminModel;
import br.unicamp.mc851.evisita.oapi.srv.admin.database.repository.AdminRepository;
import br.unicamp.mc851.evisita.oapi.srv.admin.domain.Admin;
import br.unicamp.mc851.evisita.oapi.srv.admin.usecase.Authenticate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateImpl implements Authenticate {

    private final AdminRepository repository;

    @Override
    public Boolean execute(Admin admin) {
        return repository.findByNameAndPassword(admin.getName(), admin.getPassword()).isPresent();
    }
}
