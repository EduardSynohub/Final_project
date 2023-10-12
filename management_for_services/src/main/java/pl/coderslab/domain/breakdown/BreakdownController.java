package pl.coderslab.domain.breakdown;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.equipment.Equipment;
import pl.coderslab.domain.equipment.JpaEquipmentService;
import pl.coderslab.domain.repair_service.JpaRepairService;
import pl.coderslab.domain.repair_service.RepairService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/problem")
public class BreakdownController {

    private final JpaBreakdownService jpaBreakdownService;
    private final JpaEquipmentService jpaEquipmentService;
    private final JpaRepairService jpaRepairService;

    public BreakdownController(JpaBreakdownService jpaBreakdownService, JpaEquipmentService jpaEquipmentService, JpaRepairService jpaRepairService) {
        this.jpaBreakdownService = jpaBreakdownService;
        this.jpaEquipmentService = jpaEquipmentService;
        this.jpaRepairService = jpaRepairService;
    }

    @ModelAttribute("list_of_equipments")
    public List<Equipment> equipmentList() {
        return jpaEquipmentService.getAll();
    }

    @ModelAttribute("list_of_repair_services")
    public List<RepairService> repairServiceList() {
        return jpaRepairService.getAll();
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

    @GetMapping("/create")
    public String showAddingForm(Model model) {
        model.addAttribute("breakdown", new Breakdown());
        return "breakdown/create";
    }

    @Transactional
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveBreakdown(@Valid Breakdown breakdown, BindingResult result) {
        if (result.hasErrors()) {
            return "breakdown/create";
        }
        jpaBreakdownService.create(breakdown);
        return "redirect:/problem/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("breakdown", jpaBreakdownService.get(id));
        return "breakdown/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editBreakdown(@Valid Breakdown breakdown, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "breakdown/edit";
        }
        jpaBreakdownService.create(breakdown);
        return "redirect:/problem/all";
    }

    @GetMapping("/get/{id}")
    public String showBreakdown(Model model, @PathVariable Long id){
        model.addAttribute("breakdown", jpaBreakdownService.get(id));
        return "breakdown/breakdown";
    }

    @GetMapping ("/delete/{id}")
    public String deleteBreakdown(@PathVariable Long id) {
        jpaBreakdownService.delete(id);
        return "redirect:/problem/all";
    }
}
