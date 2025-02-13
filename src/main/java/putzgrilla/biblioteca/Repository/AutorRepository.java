package putzgrilla.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import putzgrilla.biblioteca.model.Autor;

import java.util.List;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {


    List<Autor>findByNomeContaining(String nome);
}
