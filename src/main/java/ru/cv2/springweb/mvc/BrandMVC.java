package ru.cv2.springweb.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.cv2.springweb.DTO.BrandDTO;
import ru.cv2.springweb.services.BrandService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/mvc/brand")
public class BrandMVC {

    private final BrandService brandService;

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute(brandService.getAll());
        return "allBrands";
    }

    @GetMapping("/name/{name}")
    public String getByName(@PathVariable String name, Model model){
        model.addAttribute(brandService.getBrandByName(name));
        return "brandName";
    }

    @PostMapping("/edit")
    public String editBrand(@RequestBody BrandDTO updatedBrand, Model model){
        model.addAttribute(brandService.editBrand(updatedBrand, updatedBrand.getUuid()));
        return "editBrand";
    }

    @PostMapping("/delete/{uuid}")
    public String deleteBrand(@PathVariable UUID uuid, Model model){
        brandService.deleteBrand(uuid);
        model.addAttribute("deleted brand.");
        return "deletedBrand";
    }

    @PostMapping("/add")
    public String addBrand(@RequestBody BrandDTO brand, Model model){
        model.addAttribute(brandService.saveBrand(brand));
        return "addBrand";
    }

    private BrandMVC(BrandService brandService) {
        this.brandService = brandService;
    }
}
