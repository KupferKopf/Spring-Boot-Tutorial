package com.KupferKopf.Springboot.tutorial.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //and after creating and devining those variables you can call them in every file farly easy
    @Value("${welcome.message}")
    private String welcomeMessage;

    //@RequestMapping(value = "/", method = RequestMethod.GET) //if you open 8080/ you get this return-statement back
    @GetMapping("/")// is alternative and cleaner way compared to requestmapping as it already specifies the method needed/used in its name
    public String helloWord(){
        return welcomeMessage; // Devtools didn't work for me as shown in the video
    }

}

