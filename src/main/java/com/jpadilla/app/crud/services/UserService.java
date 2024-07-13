/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jpadilla.app.crud.services;

import com.jpadilla.app.crud.entities.User;
import java.util.List;

/**
 *
 * @author jhonatan
 */
public interface UserService {
    
    User save(User user);
    
    Boolean update(Integer id, User user);

    void delete(Integer id);
    
    List<User> getAll();
    
    User getUserById(Integer id);
    
}
