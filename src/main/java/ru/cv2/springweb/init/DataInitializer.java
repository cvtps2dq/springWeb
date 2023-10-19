package ru.cv2.springweb.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.cv2.springweb.DTO.*;
import ru.cv2.springweb.models.enums.Category;
import ru.cv2.springweb.models.enums.Engine;
import ru.cv2.springweb.models.enums.Role;
import ru.cv2.springweb.models.enums.Transmission;
import ru.cv2.springweb.services.*;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final OfferService offerService;
    private final UserService userService;
    private final UserRoleService userRoleService;

    @Autowired
    public DataInitializer(BrandService brandService, ModelService modelService,
                           OfferService offerService, UserService userService,
                           UserRoleService userRoleService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @Override
    public void run(String... args) {
        BrandDTO brand1 = new BrandDTO();
        brand1.setName("Kia");
        brand1.setCreated(LocalDateTime.now());
        brand1.setModified(LocalDateTime.now());
        brandService.saveBrand(brand1);

        BrandDTO brand2 = new BrandDTO();
        brand1.setName("Hyundai");
        brand1.setCreated(LocalDateTime.now());
        brand1.setModified(LocalDateTime.now());
        brandService.saveBrand(brand2);

        UserRoleDTO userRole1 = new UserRoleDTO();
        userRole1.setRole(Role.User);
        userRoleService.saveRole(userRole1);

        UserRoleDTO userRole2 = new UserRoleDTO();
        userRole2.setRole(Role.Admin);
        userRoleService.saveRole(userRole2);

        UserDTO user1 = new UserDTO();
        user1.setUsername("cv2");
        user1.setPassword("password");
        user1.setFirstName("alex");
        user1.setLastName("cv2t");
        user1.setActive(true);
        user1.setRole(userRole1);
        user1.setImageUrl("http://example.com/avatar1.jpg");
        user1.setCreated(LocalDateTime.now());
        user1.setModified(LocalDateTime.now());
        userService.saveUser(user1);

        UserDTO user2 = new UserDTO();
        user2.setUsername("test");
        user2.setPassword("password");
        user2.setFirstName("test");
        user2.setLastName("test");
        user2.setActive(true);
        user2.setRole(userRole1);
        user2.setImageUrl("http://example.com/avatar2.jpg");
        user2.setCreated(LocalDateTime.now());
        user2.setModified(LocalDateTime.now());
        userService.saveUser(user2);

        ModelDTO model1 = new ModelDTO();
        model1.setName("Small SUV");
        model1.setCategory(Category.Car);
        model1.setImageUrl("http://example.com/image1.jpg");
        model1.setStartYear(2010);
        model1.setEndYear(2022);
        model1.setCreated(LocalDateTime.now());
        model1.setModified(LocalDateTime.now());
        model1.setBrand(brand1);
        modelService.saveModel(model1);

        ModelDTO model2 = new ModelDTO();
        model2.setName("Big Truck");
        model2.setCategory(Category.Truck);
        model2.setImageUrl("http://example.com/image2.jpg");
        model2.setStartYear(2009);
        model2.setEndYear(2070);
        model2.setCreated(LocalDateTime.now());
        model2.setModified(LocalDateTime.now());
        model2.setBrand(brand2);
        modelService.saveModel(model2);

        // Создание начальных данных для Offer
        OfferDTO offer1 = new OfferDTO();
        offer1.setDescription("NEW TRUCK AVALIABLE!!!11!!!1");
        offer1.setEngine(Engine.Gasoline);
        offer1.setImageUrl("http://example.com/offer1.jpg");
        offer1.setMileage(25000);
        offer1.setPrice(100000f);
        offer1.setTransmission(Transmission.Automatic);
        offer1.setYear(2020);
        offer1.setCreated(LocalDateTime.now());
        offer1.setModified(LocalDateTime.now());
        offer1.setModel(model1);
        offer1.setSeller(user1);
        offerService.saveOffer(offer1);

        OfferDTO offer2 = new OfferDTO();
        offer2.setDescription("NEW CAR AVALIABLE!!!11!!!1");
        offer2.setEngine(Engine.Gasoline);
        offer2.setImageUrl("http://example.com/offer2.jpg");
        offer2.setMileage(1000);
        offer2.setPrice(150000f);
        offer2.setTransmission(Transmission.Manual);
        offer2.setYear(2020);
        offer2.setCreated(LocalDateTime.now());
        offer2.setModified(LocalDateTime.now());
        offer2.setModel(model2);
        offer2.setSeller(user2);
        offerService.saveOffer(offer2);

    }
}


