package putzgrilla.biblioteca;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import putzgrilla.biblioteca.Repository.AutorRepository;
import putzgrilla.biblioteca.model.Autor;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class AutorTest {

    @Autowired
    AutorRepository autorRepository;

    @Test
    public void salvar() {
        Autor autor = new Autor();
        autor.setNome("juana");
        autor.setNacionalidade("Brasileiro");
        autor.setData_nascimento(LocalDate.of(2000, 7, 5));
        autorRepository.save(autor);
    }

    @Test
    public void pesquisaNome() {

        List<Autor> autores = autorRepository.findByNomeContaining("ju");
        autores.forEach(p-> System.out.println(p));

    }
}