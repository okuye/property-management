package com.klxsolutions.propertymanagement.controller;

import com.klxsolutions.propertymanagement.dto.PropertyDTO;
import com.klxsolutions.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    private  PropertyService propertyService;


    @GetMapping("/hello")
    public  String sayHello(){
        return "Hello World!";
    }

    @PostMapping("/properties")
    public PropertyDTO saveProperty(@RequestBody PropertyDTO propertyDTO){
        propertyService.saveProperty(propertyDTO);
        System.out.println(propertyDTO);
        return propertyDTO;
    }
}
