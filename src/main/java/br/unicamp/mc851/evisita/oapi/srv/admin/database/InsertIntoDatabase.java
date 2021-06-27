package br.unicamp.mc851.evisita.oapi.srv.admin.database;

import br.unicamp.mc851.evisita.oapi.srv.admin.database.dto.AdminModel;
import br.unicamp.mc851.evisita.oapi.srv.admin.domain.Admin;

public interface InsertIntoDatabase {
    AdminModel execute(Admin admin);
}
