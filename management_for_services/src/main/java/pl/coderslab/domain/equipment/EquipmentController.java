package pl.coderslab.domain.equipment;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.domain.breakdown.Breakdown;
import pl.coderslab.domain.breakdown.JpaBreakdownService;
import pl.coderslab.domain.restaurant.JpaRestaurantService;
import pl.coderslab.domain.restaurant.Restaurant;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/equip")
public class EquipmentController {

    private final JpaEquipmentService jpaEquipmentService;
    private final JpaRestaurantService jpaRestaurantService;
    private final JpaBreakdownService jpaBreakdownService;

    public EquipmentController(JpaEquipmentService jpaEquipmentService, JpaRestaurantService jpaRestaurantService, JpaBreakdownService jpaBreakdownService) {
        this.jpaEquipmentService = jpaEquipmentService;
        this.jpaRestaurantService = jpaRestaurantService;
        this.jpaBreakdownService = jpaBreakdownService;
    }

    @GetMapping("/all")
    public String showAllEquipment(Model model) {
        List<Equipment> equipments = jpaEquipmentService.getAll();
        model.addAttribute("equipments", equipments);
        return "equipment/all";
    }

    @GetMapping("/create")
    public String showAddingForm(Model model) {
        model.addAttribute("equipment", new Equipment());
        return "equipment/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveEquipment(@Valid Equipment equipment , BindingResult result) {
        if (result.hasErrors()) {
            return "equipment/create";
        }
        jpaEquipmentService.create(equipment);
        return "redirect:/equip/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("equipment", jpaEquipmentService.get(id));
        return "equipment/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editEquipment(@Valid Equipment equipment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "equipment/edit";
        }
        jpaEquipmentService.create(equipment);
        return "redirect:/equip/all";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping ("/delete/{id}")
    public String deleteEquipment(@PathVariable Long id) {
        List<Restaurant> restaurants = jpaRestaurantService.getAll();
        for(Restaurant r : restaurants) {
            jpaRestaurantService.deleteEquipmentFromRestaurant(id, r.getId());
        }
        List<Breakdown> breakdowns = jpaBreakdownService.getAll();
        for (Breakdown b : breakdowns) {
            if (b.getEquipment().getId().equals((jpaEquipmentService.get(id)).get().getId())) {
                jpaBreakdownService.delete(b.getId());
            }
        }
        jpaEquipmentService.delete(id);
        return "redirect:/equip/all";
    }
}
