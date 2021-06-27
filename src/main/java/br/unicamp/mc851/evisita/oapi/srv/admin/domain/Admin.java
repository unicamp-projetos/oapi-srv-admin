package br.unicamp.mc851.evisita.oapi.srv.admin.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @NonNull
    private String name;
    @NonNull
    private String password;
}
