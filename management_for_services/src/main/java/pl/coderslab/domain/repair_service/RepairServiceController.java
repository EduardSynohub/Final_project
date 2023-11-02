package pl.coderslab.domain.repair_service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.domain.CurrentUser;
import pl.coderslab.domain.breakdown.Breakdown;
import pl.coderslab.domain.breakdown.JpaBreakdownService;
import pl.coderslab.domain.equipment.Equipment;
import pl.coderslab.domain.equipment.JpaEquipmentService;
import pl.coderslab.domain.restaurant.JpaRestaurantService;
import pl.coderslab.domain.restaurant.Restaurant;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/repair")
public class RepairServiceController {

    private final JpaRepairService jpaRepairService;
    private final JpaRestaurantService jpaRestaurantService;
    private final JpaBreakdownService jpaBreakdownService;
    private final JpaEquipmentService jpaEquipmentService;

    public RepairServiceController(JpaRepairService jpaRepairService, JpaRestaurantService jpaRestaurantService, JpaBreakdownService jpaBreakdownService, JpaEquipmentService jpaEquipmentService) {
        this.jpaRepairService = jpaRepairService;
        this.jpaRestaurantService = jpaRestaurantService;
        this.jpaBreakdownService = jpaBreakdownService;
        this.jpaEquipmentService = jpaEquipmentService;
    }

    @GetMapping("/all")
    public String showAllRepairServices(Model model) {
        List<RepairService> repairServices = jpaRepairService.getAll();
        model.addAttribute("repair_services", repairServices);
        return "repair_service/all";
    }

    @GetMapping("/create")
    public String showAddingForm(Model model) {
        model.addAttribute("repair_service", new RepairService());
        return "repair_service/create";
    }

    @Transactional
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveRepairService(@Valid RepairService repairService, BindingResult result, Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        if (result.hasErrors()) {
            model.addAttribute("repair_service", repairService);
            model.addAttribute("org.springframework.validation.BindingResult.repair_service", result);
            return "repair_service/create";
        }
        Long id = currentUser.getUser().getId();

        jpaRepairService.create(repairService);
        return "redirect:/repair/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("repair_service", jpaRepairService.get(id));
        return "repair_service/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editRepairService(@Valid RepairService repairService, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "repair_service/edit";
        }
        if(repairService.getPhoneNumber().equals(jpaRepairService.get(repairService.getId()).get().getPhoneNumber())){
            repairService.setPhoneNumber(jpaRepairService.get(repairService.getId()).get().getPhoneNumber());
        }
        jpaRepairService.create(repairService);
        return "redirect:/repair/all";
    }

    @GetMapping("/get/{id}")
    public String showRepairService(Model model, @PathVariable Long id){
        model.addAttribute("repair_service", jpaRepairService.get(id));
        return "repair_service/repair_service";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping ("/delete/{id}")
    public String deleteRepairService(@PathVariable Long id) {
        List<Restaurant> restaurants = jpaRestaurantService.getAll();
        for (Restaurant r : restaurants) {
            jpaRestaurantService.deleteRepairServiceFromRestaurant(id, r.getId());
        }
        List<Breakdown> breakdowns = jpaBreakdownService.getAll();
        for (Breakdown b : breakdowns) {
            if (b.getRepairService().getId().equals((jpaRepairService.get(id)).get().getId())) {
                jpaBreakdownService.delete(b.getId());
            }
        }
        jpaRepairService.delete(id);
        return "redirect:/repair/all";
    }
}
