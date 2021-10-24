package pl.sdacademy.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sdacademy.author.Author;
import pl.sdacademy.author.AuthorService;

import java.util.List;

@Controller
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;


    @GetMapping("/list")
    public String getList(ModelMap modelMap) {
        List<Book> books = bookService.getAll();
        modelMap.addAttribute("books",books);
        return "book/booklist";
    }
    @GetMapping("/add")
    public String bookForm(ModelMap modelMap, @ModelAttribute("book") Book book){
        List<Author> authors = authorService.getAll();
        modelMap.addAttribute("authors",authors);
        return "book/form";
    }
    @PostMapping("/add")
    public String saveBook(Book book){
        bookService.save(book);
        return "redirect:/book/list";
    }
}
