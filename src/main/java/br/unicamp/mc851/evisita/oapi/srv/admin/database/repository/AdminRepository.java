package br.unicamp.mc851.evisita.oapi.srv.admin.database.repository;

import br.unicamp.mc851.evisita.oapi.srv.admin.database.dto.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminModel, Long> {
    Optional<AdminModel> findByNameAndPassword(String name, String password);
}
