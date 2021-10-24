package pl.sdacademy.author;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sdacademy.author.Author;
import pl.sdacademy.author.AuthorRepository;

import java.util.List;

@Service
@Slf4j
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void save(Author author){
        if(author.getId()!=null){

            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Nowa autor nie powinna mieć zadanego identyfikatora");
            log.error("Błąd zapisywania autora: ", illegalArgumentException);
            throw illegalArgumentException;
        }
        authorRepository.save(author);
    }

    public List<Author> getAll(){
        return authorRepository.findAll();
    }
}
