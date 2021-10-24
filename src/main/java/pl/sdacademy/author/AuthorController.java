package pl.sdacademy.author;

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
@RequestMapping("/author")
//lombok
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/list")
    public String getList(ModelMap modelMap) {
        List<Author> authors = authorService.getAll();
        modelMap.addAttribute("authors",authors);
        return "author/authorlist";
    }
    @GetMapping("/add")
    public String authorForm(@ModelAttribute("author") Author author){
        return "author/form";
    }
    @PostMapping("/add")
    public String saveAuthor(Author author){
        authorService.save(author);
        return "redirect:/author/list";
    }
}
