package putzgrilla.biblioteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import putzgrilla.biblioteca.model.Autor;
import putzgrilla.biblioteca.model.Livro;

import java.util.List;
import java.util.UUID;

public interface LivroRepository  extends JpaRepository<Livro, UUID> {
    @Query("""
          SELECT l FROM Livro l WHERE l.autor.nome = :nomeAutor""")
     List<Livro> buscaPorAutor(@Param( "nomeAutor") String nome);
}

