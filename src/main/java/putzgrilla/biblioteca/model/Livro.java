package putzgrilla.biblioteca.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

import java.util.UUID;

@Data
@ToString(exclude = "autor")
@Entity
@Table(name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String titulo;
    private String isbn;
    private LocalDate data_publicacao;

    @Enumerated(EnumType.STRING)
    private generos genero;
    private double preco;
    @JoinColumn(name = "id_autor")
    @ManyToOne(fetch = FetchType.LAZY)
    private Autor autor;
}
