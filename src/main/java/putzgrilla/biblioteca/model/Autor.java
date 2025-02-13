package putzgrilla.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Data
@Entity
@ToString(exclude = "livros")
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome")
    private  String nome;

    @Column(name ="data_nascimento" )
    private LocalDate data_nascimento;

    @Column(name = "nacionalidade")
    private String nacionalidade;

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)

    private List<Livro> livros;
}
