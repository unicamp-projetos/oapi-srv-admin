package br.unicamp.mc851.evisita.oapi.srv.admin.database.impl;

import br.unicamp.mc851.evisita.oapi.srv.admin.adapter.AdminAdapter;
import br.unicamp.mc851.evisita.oapi.srv.admin.database.InsertIntoDatabase;
import br.unicamp.mc851.evisita.oapi.srv.admin.database.dto.AdminModel;
import br.unicamp.mc851.evisita.oapi.srv.admin.database.repository.AdminRepository;
import br.unicamp.mc851.evisita.oapi.srv.admin.domain.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsertIntoDatabaseImpl implements InsertIntoDatabase {

    private final AdminRepository repository;

    @Override
    public AdminModel execute(Admin admin) {
        return repository.save(AdminAdapter.convert(admin));
    }
}
