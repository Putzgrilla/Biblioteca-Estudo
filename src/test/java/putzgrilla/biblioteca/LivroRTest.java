package putzgrilla.biblioteca;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import putzgrilla.biblioteca.Repository.AutorRepository;
import putzgrilla.biblioteca.Repository.LivroRepository;
import putzgrilla.biblioteca.model.Autor;
import putzgrilla.biblioteca.model.Livro;
import putzgrilla.biblioteca.model.generos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LivroRTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    public void salvar() {
        Livro livro = new Livro();
        Autor autor = autorRepository.findById(UUID.fromString("d72af720-5281-41a6-a40c-d9d02f5546d6")).orElse(null);

        livro.setAutor(autor);
        livro.setIsbn("9890ujiko");
        livro.setPreco(3.50);
        livro.setData_publicacao(LocalDate.of(2023, 10, 30));
        livro.setGenero(generos.ROMANCE);
        livro.setTitulo("como eu salvei um gato");
        repository.save(livro);

    }
    @Test
    public  void pesquisaR(){
      Livro livro =repository.findById(UUID.fromString("b0cfde1e-9a25-4647-960c-d3661403dea8")).orElse(null);
        System.out.println("titulo:"+livro.getTitulo()+" Autor:"+livro.getAutor().getNome());

    }
    @Test
    public  void pesquisarpornomeautor(){

        List<Livro> livros = repository.buscaPorAutor("juliana");
        livros.forEach(System.out::println);

    }
}