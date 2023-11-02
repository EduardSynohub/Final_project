package pl.coderslab.domain.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.CurrentUser;
import pl.coderslab.domain.restaurant.JpaRestaurantService;
import pl.coderslab.domain.restaurant.Restaurant;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final JpaUserService jpaUserService;
    private final JpaRestaurantService jpaRestaurantService;

    public UserController(JpaUserService jpaUserService, JpaRestaurantService jpaRestaurantService) {
        this.jpaUserService = jpaUserService;
        this.jpaRestaurantService = jpaRestaurantService;
    }

    @GetMapping("/dashboard")
    public String showStartPage() {
        return "dashboard";
    }

    @GetMapping("/all")
    public String showAllUsers(Model model) {
        List<User> users = jpaUserService.getAll();
        model.addAttribute("users", users);
        return "user/all";
    }

    @ModelAttribute("list_of_restaurant")
    public List<Restaurant> restaurantList() {
        return jpaRestaurantService.getAll();
    }

    @ModelAttribute("restaurant_id")
    public Long restaurantId(@AuthenticationPrincipal CurrentUser customUser) {
        return customUser.getUser().getRestaurant().getId();
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", jpaUserService.get(id));
        return "user/edit";
    }

    @Transactional
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@Valid User user, BindingResult bindingResult, @AuthenticationPrincipal @Valid CurrentUser customUser, Model model) {
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }
        Long id = customUser.getUser().getId();
        user.setId(id);
        if(user.getUsername().equals(jpaUserService.findByUserName(user.getUsername()))) {
            user.setUsername(jpaUserService.findByUserName(user.getUsername()).getUsername());
        } else if (user.getPassword() == null || user.getPassword().isEmpty()) {
            User existingUser = jpaUserService.get(user.getId()).get();
            user.setPassword(existingUser.getPassword());
            model.addAttribute("user", jpaUserService.get(id));
            jpaUserService.updateUser(user);
        } else {
            jpaUserService.saveUser(user);
        }
        return "redirect:/logout";
    }

    @GetMapping("/get/{id}")
    public String showUser(Model model, @PathVariable Long id){
        model.addAttribute("user", jpaUserService.get(id));
        return "user/user";
    }

    @GetMapping ("/delete/{id}")
    public String deleteUser(@PathVariable Long id, HttpSession session, @AuthenticationPrincipal CurrentUser currentUser) {
        jpaUserService.delete(id);
        if (currentUser.getUser().getId().equals(id)) {
            session.invalidate();
        }
        return "redirect:/user/all";
    }
}
