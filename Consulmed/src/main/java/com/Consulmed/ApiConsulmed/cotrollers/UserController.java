
package com.Consulmed.ApiConsulmed.cotrollers;

import com.Consulmed.ApiConsulmed.dao.UserDao;
import com.Consulmed.ApiConsulmed.models.User;
import com.Consulmed.ApiConsulmed.utils.JWTutil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private JWTutil jwtutil;
    
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List <User> getUsers  (){
       return userDao.getUsers();
     }
    
    private boolean tokenValidate(String token){
        String userId= jwtutil.getKey(token);
        return userId != null;
    } 
           
    
    @RequestMapping(value = "users/register", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPass());
        user.setPass(hash);
        
        userDao.register(user);
                
     }
    
//    @GetMapping("/users/edit/{id}")
//    public String getEditUser (Model model, @PathVariable(name ="id"),Long id)throws Exception{
//        User editUser = userDao.getUserById(id);
//        
//        model.addAttribute("userForm", jwtutil);
//        
//    }
    
    @RequestMapping(value = "users/update/{id}", method = RequestMethod.PATCH)
    public void updateUser(@RequestBody long id) throws Exception{
        
        
        userDao.update(id);
               
   }
    
    @RequestMapping (value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id){
    userDao.delete(id);
     }
    
}
