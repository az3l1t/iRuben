package net.az3l1t.LanguageProject.Consumer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
    @GetMapping("/login")
    public String redirectToLoginPage() {
        return "login.html";
    }

    @GetMapping("/registerPage")
    public String redirectToRegisterPage(){
        return "registration.html";
    }

    @GetMapping("/alphabetPage")
    public String redirectToAlphabetPage() {return "alphabet.html";}

    @GetMapping("/gamePage")
    public String redirectToGamePage() {return "game.html";}

    @GetMapping("/historyPage")
    public String redirectToHistoryPage() {return "history.html";}
}
