
package com.Consulmed.ApiConsulmed.models;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table (name = "users")
public class User implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @Column (name = "name")
    private String name;
    @Column (name = "last_name")
    private String last_name;
    @Column (name = "email")
    private String email;
    @Column (name = "pass")
    private String pass;
    @Column (name = "phone")
    private String phone;
    @Column (name = "usertype")
    private String usertype;
}
