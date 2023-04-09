package cigma.mini.project.ecommerce.doa;

import cigma.mini.project.ecommerce.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findClientByUsername(String username);

}
