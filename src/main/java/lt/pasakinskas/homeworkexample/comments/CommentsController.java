package lt.pasakinskas.homeworkexample.comments;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class CommentsController {

  private CommentsRepository repository;

  public CommentsController(@Autowired CommentsRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/")
  public String getComments(Model model) {
    var comments = repository.findAll();
    model.addAttribute("comments", comments);
    model.addAttribute("comment", new Comment());
    return "/pages/index";
  }

  @PostMapping("/comments")
  public String createComment(@Valid Comment comment, BindingResult errors) {
    if (errors.hasErrors()) {
      return "/pages/index";
    }
    repository.save(comment);
    return "redirect:/";
  }

  @DeleteMapping("/comments/{id}")
  public String createComment(@PathVariable Long id) {
    System.out.println(id);
    repository.deleteById(id);
    return "redirect:/";
  }
}
