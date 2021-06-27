package br.unicamp.mc851.evisita.oapi.srv.admin.database.repository;

import br.unicamp.mc851.evisita.oapi.srv.admin.database.dto.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminModel, Long> {
}
