
package com.Consulmed.ApiConsulmed.cotrollers;

import com.Consulmed.ApiConsulmed.dao.UserDao;
import com.Consulmed.ApiConsulmed.models.User;
import com.Consulmed.ApiConsulmed.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private JWTutil jwtutil;
    
    @RequestMapping(value = "log", method = RequestMethod.POST)
    public String log(@RequestBody User user){
        User loginUser = userDao.getUserbyCredentials(user);
        if(loginUser != null){
            String tokenJwt =jwtutil.create(String.valueOf(loginUser.getId()), loginUser.getEmail());
            return tokenJwt;
        }
        return "FAIL";
    }
    
}
