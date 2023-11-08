package ru.cv2.springweb.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.cv2.springweb.DTO.*;
import ru.cv2.springweb.models.enums.Category;
import ru.cv2.springweb.models.enums.Engine;
import ru.cv2.springweb.models.enums.Role;
import ru.cv2.springweb.models.enums.Transmission;
import ru.cv2.springweb.services.impl.*;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandServiceImpl brandServiceImpl;
    private final ModelServiceImpl modelServiceImpl;
    private final OfferServiceImpl offerServiceImpl;
    private final UserServiceImpl userServiceImpl;
    private final UserRoleServiceImpl userRoleServiceImpl;

    @Autowired
    public DataInitializer(BrandServiceImpl brandServiceImpl, ModelServiceImpl modelServiceImpl,
                           OfferServiceImpl offerServiceImpl, UserServiceImpl userServiceImpl,
                           UserRoleServiceImpl userRoleServiceImpl) {
        this.brandServiceImpl = brandServiceImpl;
        this.modelServiceImpl = modelServiceImpl;
        this.offerServiceImpl = offerServiceImpl;
        this.userServiceImpl = userServiceImpl;
        this.userRoleServiceImpl = userRoleServiceImpl;
    }

    @Override
    public void run(String... args) {
        BrandDTO brand1 = new BrandDTO();
        brand1.setName("Kia");
        brandServiceImpl.saveBrand(brand1);

        BrandDTO brand2 = new BrandDTO();
        brand1.setName("Hyundai");
        brandServiceImpl.saveBrand(brand2);

        UserRoleDTO userRole1 = new UserRoleDTO();
        userRole1.setRole(Role.User);
        userRoleServiceImpl.saveRole(userRole1);

        UserRoleDTO userRole2 = new UserRoleDTO();
        userRole2.setRole(Role.Admin);
        userRoleServiceImpl.saveRole(userRole2);

        UserDTO user1 = new UserDTO();
        user1.setUsername("cv2");
        user1.setPassword("password");
        user1.setFirstName("alex");
        user1.setLastName("cv2t");
        user1.setActive(true);
        user1.setRole(userRole1);
        user1.setImageUrl("http://example.com/avatar1.jpg");
        //userServiceImpl.saveUser(user1);

        UserDTO user2 = new UserDTO();
        user2.setUsername("test");
        user2.setPassword("password");
        user2.setFirstName("test");
        user2.setLastName("test");
        user2.setActive(true);
        user2.setRole(userRole1);
        user2.setImageUrl("http://example.com/avatar2.jpg");
        //userServiceImpl.saveUser(user2);

        ModelDTO model1 = new ModelDTO();
        model1.setName("Small SUV");
        model1.setCategory(Category.Car);
        model1.setImageUrl("http://example.com/image1.jpg");
        model1.setStartYear(2010);
        model1.setEndYear(2022);
        model1.setBrand(brand1);
        modelServiceImpl.saveModel(model1);

        ModelDTO model2 = new ModelDTO();
        model2.setName("Big Truck");
        model2.setCategory(Category.Truck);
        model2.setImageUrl("http://example.com/image2.jpg");
        model2.setStartYear(2009);
        model2.setEndYear(2070);
        model2.setBrand(brand2);
        modelServiceImpl.saveModel(model2);

        // Создание начальных данных для Offer
        OfferDTO offer1 = new OfferDTO();
        offer1.setDescription("NEW TRUCK AVALIABLE!!!11!!!1");
        offer1.setEngine(Engine.Gasoline);
        offer1.setImageUrl("http://example.com/offer1.jpg");
        offer1.setMileage(25000);
        offer1.setPrice(100000f);
        offer1.setTransmission(Transmission.Automatic);
        offer1.setYear(2020);
        offer1.setModel(model1);
        offer1.setSeller(user1);
        offerServiceImpl.saveOffer(offer1);

        OfferDTO offer2 = new OfferDTO();
        offer2.setDescription("NEW CAR AVALIABLE!!!11!!!1");
        offer2.setEngine(Engine.Gasoline);
        offer2.setImageUrl("http://example.com/offer2.jpg");
        offer2.setMileage(1000);
        offer2.setPrice(150000f);
        offer2.setTransmission(Transmission.Manual);
        offer2.setYear(2020);
        offer2.setModel(model2);
        offer2.setSeller(user2);
        offerServiceImpl.saveOffer(offer2);

    }
}


