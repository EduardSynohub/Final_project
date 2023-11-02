package pl.coderslab.domain.breakdown;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.CurrentUser;
import pl.coderslab.domain.equipment.Equipment;
import pl.coderslab.domain.equipment.JpaEquipmentService;
import pl.coderslab.domain.repair_service.JpaRepairService;
import pl.coderslab.domain.repair_service.RepairService;
import pl.coderslab.domain.restaurant.Restaurant;
import pl.coderslab.domain.user.JpaUserService;
import pl.coderslab.domain.user.User;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/problem")
public class BreakdownController {

    private final JpaBreakdownService jpaBreakdownService;
    private final JpaEquipmentService jpaEquipmentService;
    private final JpaRepairService jpaRepairService;
    private final JpaUserService jpaUserService;

    public BreakdownController(JpaBreakdownService jpaBreakdownService, JpaEquipmentService jpaEquipmentService, JpaRepairService jpaRepairService, JpaUserService jpaUserService) {
        this.jpaBreakdownService = jpaBreakdownService;
        this.jpaEquipmentService = jpaEquipmentService;
        this.jpaRepairService = jpaRepairService;
        this.jpaUserService = jpaUserService;
    }

    @ModelAttribute("list_of_equipments")
    public Set<Equipment> equipmentList(@AuthenticationPrincipal CurrentUser customUser) {
        Long id = customUser.getUser().getId();
        Optional<User> userOptional = jpaUserService.get(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getRestaurant().getEquipments();
        } else {
            throw new NoSuchElementException("Nie odnaleziono żadnego użytkownika, żeby przejść dalej");
        }
    }

    @ModelAttribute("list_of_repair_services")
    public Set<RepairService> repairServiceList(@AuthenticationPrincipal CurrentUser customUser) {
        Long id = customUser.getUser().getId();
        return jpaUserService.get(id).get().getRestaurant().getRepairServices();
    }

    @GetMapping("/all")
    public String showAllBreakdowns(Model model) {
        List<Breakdown> breakdowns = jpaBreakdownService.getAll();
        for (Breakdown breakdown : breakdowns) {
            breakdown.getEquipment().getName();
        }
        model.addAttribute("breakdowns", breakdowns);
        return "breakdown/all";
    }

    @ModelAttribute("restaurant_id_for_breakdown")
    public Long restaurantId(@AuthenticationPrincipal CurrentUser customUser) {
        return customUser.getUser().getRestaurant().getId();
    }

    @GetMapping("/create")
    public String showAddingForm(Model model) {
        model.addAttribute("breakdown", new Breakdown());
        return "breakdown/create";
    }

    @Transactional
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveBreakdown(@Valid Breakdown breakdown, BindingResult result, Model model, @AuthenticationPrincipal CurrentUser customUser) {
        if (result.hasErrors()) {
            model.addAttribute("breakdown", breakdown);
            model.addAttribute("org.springframework.validation.BindingResult.repair_service", result);
            return "breakdown/create";
        }
        Long userId = customUser.getUser().getId();
        Restaurant restaurant = jpaUserService.get(userId).get().getRestaurant();
        breakdown.setRestaurant(restaurant);
        jpaBreakdownService.create(breakdown);
        return "redirect:/problem/all";
    }

//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//    public String showEditForm(@PathVariable long id, Model model) {
//        model.addAttribute("breakdown", jpaBreakdownService.get(id));
//        return "breakdown/edit";
//    }
//
//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public String editBreakdown(@Valid Breakdown breakdown, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "breakdown/edit";
//        }
//        jpaBreakdownService.create(breakdown);
//        return "redirect:/problem/all";
//    }

//    @GetMapping("/get/{id}")
//    public String showBreakdown(Model model, @PathVariable Long id){
//        model.addAttribute("breakdown", jpaBreakdownService.get(id));
//        return "breakdown/breakdown";
//    }

    @GetMapping ("/delete/{id}")
    public String deleteBreakdown(@PathVariable Long id) {
        jpaBreakdownService.delete(id);
        return "redirect:/problem/all";
    }
}
