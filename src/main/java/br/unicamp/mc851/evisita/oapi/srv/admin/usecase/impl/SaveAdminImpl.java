package br.unicamp.mc851.evisita.oapi.srv.admin.usecase.impl;

import br.unicamp.mc851.evisita.oapi.srv.admin.adapter.AdminAdapter;
import br.unicamp.mc851.evisita.oapi.srv.admin.database.InsertIntoDatabase;
import br.unicamp.mc851.evisita.oapi.srv.admin.domain.Admin;
import br.unicamp.mc851.evisita.oapi.srv.admin.usecase.SaveAdmin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveAdminImpl implements SaveAdmin {

    private final InsertIntoDatabase insertIntoDatabase;

    @Override
    public Admin execute(Admin admin) {
        return AdminAdapter.convert(insertIntoDatabase.execute(admin));
    }
}
