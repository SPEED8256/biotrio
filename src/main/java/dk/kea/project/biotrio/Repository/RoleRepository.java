package dk.kea.project.biotrio.Repository;


import dk.kea.project.biotrio.Domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;

public interface RoleRepository extends JpaRepository<Role, Long> {
    HashSet<Role> findAllByName(String name);
}
