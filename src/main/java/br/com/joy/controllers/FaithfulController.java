package br.com.joy.controllers;

import br.com.joy.entities.dtos.FaithfulDTO;
import br.com.joy.entities.formsobjects.FaithfulForm;
import br.com.joy.services.FaithfulService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("/faithful")
@AllArgsConstructor
public class FaithfulController {

    private final FaithfulService faithfulService;
    private final MessageSource messageSource;


    @GetMapping
    public String createFaithfulForm(Model model) {
        model.addAttribute("faithful", new FaithfulForm());
        return "index";
    }

    @PostMapping
    public String createFiel(@ModelAttribute("faithful") FaithfulForm faithfulForm, BindingResult bindingResult, Model model, Locale locale) {
        if (bindingResult.hasErrors()) {
//            return "redirect:/faithful";
            return "index";
        }

        FaithfulDTO faithfulDTO = convertToDTO(faithfulForm);
        faithfulService.saveFaithful(faithfulDTO);
        model.addAttribute("successMessage", messageSource.getMessage("registration.success",null, locale));
//        String successMessage = messageSource.getMessage("registration.success", null, locale);
//        redirectAttributes.addFlashAttribute("successMessage", successMessage);
//        return "redirect:/faithful";
        return "index";
    }

    private FaithfulDTO convertToDTO(FaithfulForm faithfulForm) {
        return new FaithfulDTO(
                faithfulForm.getId(),
                faithfulForm.getFullName(),
                faithfulForm.getPhoneNumber(),
                faithfulForm.getBirthday(),
                faithfulForm.getOriginCity(),
                faithfulForm.getCountry(),
                faithfulForm.getOriginNetwork(),
                faithfulForm.getCreatedDate()
        );
    }
}

