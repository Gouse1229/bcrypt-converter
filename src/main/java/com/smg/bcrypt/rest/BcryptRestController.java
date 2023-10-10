package com.smg.bcrypt.rest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.mindrot.jbcrypt.BCrypt;

@Controller
@RequestMapping()
public class BcryptRestController {
    @RequestMapping("/")
    public String getHomePage(){
        return "home-page";
    }

    @RequestMapping(method = RequestMethod.GET, value = "getEncryptedPassword")
    public @ResponseBody String getEncryptedPassword(@RequestParam("password") String password){
        if(password.isEmpty()){
            return "";
        }
        String salt = BCrypt.gensalt(10);
        return BCrypt.hashpw(password,salt);
    }
}
