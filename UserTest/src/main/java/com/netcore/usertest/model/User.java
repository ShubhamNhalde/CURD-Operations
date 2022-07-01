package com.netcore.usertest.model;

import com.netcore.usertest.dto.UserDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "UserDetails")
public class User {

    @Id
    @GeneratedValue
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;

    public User(UserDTO dto) {
        super();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.email = dto.getEmail();
    }

    public User() {

    }

    public User(Integer userId, UserDTO dto) {
        this.userId = userId;
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.email = dto.getEmail();
    }

    public User(Integer userId) {
        this.userId = userId;
    }
}
