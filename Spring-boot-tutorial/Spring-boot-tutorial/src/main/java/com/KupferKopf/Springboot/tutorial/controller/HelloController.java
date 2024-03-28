package com.KupferKopf.Springboot.tutorial.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //@RequestMapping(value = "/", method = RequestMethod.GET) //if you open 8080/ you get this return-statement back
    @GetMapping("/")// is alternative and cleaner way compared to requestmapping as it already specifies the method needed/used in its name
    public String helloWord(){
        return "Welcome to my Spring Project"; // Devtools didn't work for me as shown in the video
    }

}

