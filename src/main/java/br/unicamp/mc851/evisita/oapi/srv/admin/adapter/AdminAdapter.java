package br.unicamp.mc851.evisita.oapi.srv.admin.adapter;

import br.unicamp.mc851.evisita.oapi.srv.admin.database.dto.AdminModel;
import br.unicamp.mc851.evisita.oapi.srv.admin.domain.Admin;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AdminAdapter {

    public static AdminModel convert(Admin admin) {
        return AdminModel.builder()
                .name(admin.getName())
                .password(admin.getPassword())
                .build();
    }

    public static Admin convert(AdminModel adminModel) {
        return Admin.builder()
                .name(adminModel.getName())
                .password(adminModel.getPassword())
                .build();
    }
}
