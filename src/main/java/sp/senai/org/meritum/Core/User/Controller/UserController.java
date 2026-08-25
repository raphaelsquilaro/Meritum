package sp.senai.org.meritum.Core.User.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sp.senai.org.meritum.Core.User.Domain.Entity.User;
import sp.senai.org.meritum.Core.User.Repository.UserRepository;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @GetMapping("/user/listagem")
    public String listarUser(Model model) {

        model.addAttribute(
                "users",
                repository.findAll()
        );

        return "user/listagem";
    }

    @GetMapping("/user/cadastro")
    public String cadastroUser(Model model) {

        model.addAttribute(
                "user",
                new User()
        );

        return "user/cadastro";
    }

    @GetMapping("/user/editar/{id}")
    public String editarUser(
            @PathVariable Long id,
            Model model
    ) {

        User user =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Conquista não encontrada"
                                )
                        );

        model.addAttribute(
                "user",
                user
        );

        return "user/cadastro";
    }

    @PostMapping("/user/salvar")
    public String salvarUser(
            @Valid @ModelAttribute User user,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            return "user/cadastro";
        }

        repository.save(user);

        return "redirect:/user/listagem";
    }

    @GetMapping("/user/excluir/{id}")
    public String excluirUser(
            @PathVariable Long id
    ) {
        repository.deleteById(id);

        return "redirect:/user/listagem";
    }
}
