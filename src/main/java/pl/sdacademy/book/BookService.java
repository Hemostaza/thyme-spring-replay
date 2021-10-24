package pl.sdacademy.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book book){
        if(book.getId()!=null){

            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Nowa książka nie powinna mieć zadanego identyfikatora");
            log.error("Błąd zapisywania książki: ", illegalArgumentException);
            throw illegalArgumentException;
        }
        bookRepository.save(book);
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }
}
