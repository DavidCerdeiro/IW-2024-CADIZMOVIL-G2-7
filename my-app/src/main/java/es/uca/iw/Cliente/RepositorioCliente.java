package es.uca.iw.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RepositorioCliente extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByEmail(String email);

    List<Cliente> findByIsActiveTrue();

    @Query("SELECT c FROM Cliente c WHERE c.nombre = ?1")
    Optional<Cliente> findByUsername(String username);
}
