package ru.cv2.springweb.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.cv2.springweb.DTO.OfferDTO;
import ru.cv2.springweb.services.OfferService;

import java.util.UUID;

@Controller
@RequestMapping("/mvc/offer")
public class OfferMVC {
    private final OfferService offerService;

    private OfferMVC(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute(offerService.getAll());
        return "allOffers";
    }

    @GetMapping("/id/{id}")
    public String getById(@PathVariable UUID id, Model model){
        model.addAttribute(offerService.getOfferById(id));
        return "offerId";
    }

    @PostMapping("/edit")
    public String editOffer(@RequestBody OfferDTO updatedOffer, Model model){
        model.addAttribute(offerService.editOffer(updatedOffer, updatedOffer.getId()));
        return "editOffer";
    }

    @PostMapping("/delete/{uuid}")
    public String deleteOffer(@PathVariable UUID uuid, Model model){
        offerService.deleteOffer(uuid);
        model.addAttribute("deleted offer.");
        return "deletedOffer";
    }

    @PostMapping("/add")
    public String addOffer(@RequestBody OfferDTO offer, Model model){
        model.addAttribute(offerService.saveOffer(offer));
        return "addOffer";
    }
}
