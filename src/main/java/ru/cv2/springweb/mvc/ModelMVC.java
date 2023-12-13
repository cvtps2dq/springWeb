package ru.cv2.springweb.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.cv2.springweb.DTO.ModelDTO;
import ru.cv2.springweb.services.ModelService;

import java.util.UUID;

@Controller
@RequestMapping("/mvc/model")
public class ModelMVC {

    private ModelService modelService;

    public ModelMVC() {

    }
    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute(modelService.getAll());
        return "allModels";
    }

    @GetMapping("/name/{name}")
    public String getByName(@PathVariable String name, Model model){
        model.addAttribute(modelService.getModelByName(name));
        return "modelName";
    }

    @PostMapping("/edit")
    public String editModel(@RequestBody ModelDTO updatedModel, Model model){
        model.addAttribute(modelService.editModel(updatedModel, updatedModel.getId()));
        return "editModel";
    }

    @PostMapping("/delete/{uuid}")
    public String deleteModel(@PathVariable UUID uuid, Model model){
        modelService.deleteModel(uuid);
        model.addAttribute("deleted model.");
        return "deletedModel";
    }

    @PostMapping("/add")
    public String addModel(@RequestBody ModelDTO newModel, Model model){
        model.addAttribute(modelService.saveModel(newModel));
        return "addModel";
    }

}
