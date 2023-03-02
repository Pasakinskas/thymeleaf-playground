package lt.pasakinskas.homeworkexample.cookies;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CookieController {

  @PostMapping("/cookie-consent")
  public String saveCookieConsent(HttpSession session) {
    session.setAttribute("cookiebanner", true);
    return "redirect:/";
  }
}
