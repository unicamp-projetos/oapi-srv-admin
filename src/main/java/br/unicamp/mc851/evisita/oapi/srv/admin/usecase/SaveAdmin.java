package br.unicamp.mc851.evisita.oapi.srv.admin.usecase;

import br.unicamp.mc851.evisita.oapi.srv.admin.domain.Admin;

public interface SaveAdmin {
    Admin execute(Admin admin);
}
