package com.netcore.usertest.controller;

import com.netcore.usertest.dto.ResponseDTO;
import com.netcore.usertest.dto.UserDTO;
import com.netcore.usertest.model.User;
import com.netcore.usertest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService service;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody UserDTO dto) {
        User user = service.registerUser(dto);
        ResponseDTO response = new ResponseDTO("User Registered", user);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<String>retrieveUsers(){
        List<User> user = service.retrieveUsers();
        ResponseDTO response = new ResponseDTO("Users :", user);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<ResponseDTO> updateById(@PathVariable Integer userId, @RequestBody UserDTO dto){
        User user = service.updateById(dto, userId);
        ResponseDTO response = new ResponseDTO("User updated : ", user);
        return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable Integer userId){
        User user = service.deleteById(userId);
        ResponseDTO response = new ResponseDTO("User deleted successfully", user);
        return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
    }
}
