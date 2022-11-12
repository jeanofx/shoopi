
package com.Consulmed.ApiConsulmed.dao;

import com.Consulmed.ApiConsulmed.models.User;
import java.util.List;

public interface UserDao {
    List<User> getUsers();

    public void delete(Long id);

    public void register(User user);
    
    public User getUserById(Long id) throws Exception;
    
    public void update(Long id) throws Exception;
    
    User getUserbyCredentials (User user);
}
