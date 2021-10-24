package pl.sdacademy.book;

import lombok.Getter;
import lombok.Setter;
import pl.sdacademy.author.Author;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    //jedna książka -> jeden autor // perspektywa książki
    //jeden autor -> wiele książek //perspektywa autora
    @ManyToOne
    private Author author;

}
