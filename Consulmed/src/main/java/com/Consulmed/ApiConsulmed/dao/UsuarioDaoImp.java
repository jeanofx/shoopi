
package com.Consulmed.ApiConsulmed.dao;

import com.Consulmed.ApiConsulmed.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsuarioDaoImp implements UserDao {
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public List <User> getUsers(){
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(Long id) {
        User user= entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void register(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserbyCredentials(User user) {
        String query = "FROM User WHERE email =: email";
        List<User> list = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();
        if(list.isEmpty()){
            return null;
        }
        
        String passwordHashed = list.get(0).getPass();
        
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(passwordHashed,user.getPass())){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void update(Long Id) throws Exception{
        User user= entityManager.find(User.class, Id);
        entityManager.merge(user);
    }
    
    
    
    protected void mapUser (User user,User to){
        to.setName(user.getName());
        to.setLast_name(user.getLast_name());
        to.setEmail(user.getEmail());
        to.setPhone(user.getPhone());
        to.setUsertype(user.getUsertype());
    }

    @Override
    public User getUserById(Long id) throws Exception {
        return entityManager.find(User.class, id);
    }




}
