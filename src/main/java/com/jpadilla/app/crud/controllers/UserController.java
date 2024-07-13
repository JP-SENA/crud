/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jpadilla.app.crud.controllers;

import com.jpadilla.app.crud.db.MysqlConnect;
import com.jpadilla.app.crud.entities.User;
import com.jpadilla.app.crud.services.UserService;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhonatan
 */
public class UserController implements UserService {

    @Override
    public User save(User user) {
        String sql = "INSERT INTO users(fullname,email,t_doc,n_doc,profile,password,username,is_active)"
                + " VALUES(?,?,?,?,?,?,?,?)";
        int id = 0;
        try (var db = MysqlConnect.getConnection();
                var stm = db.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stm.setString(1, user.getFullname());
            stm.setString(2, user.getEmail());
            stm.setString(3, user.getT_doc());
            stm.setString(4, user.getN_doc());
            stm.setString(5, user.getProfile());
            stm.setString(6, user.getPassword());
            stm.setString(7, user.getUsername());
            stm.setBoolean(8, user.getIsActive());

            int affectedRows = stm.executeUpdate();

            if (affectedRows != 0) {

                ResultSet rs = stm.getGeneratedKeys();

                if (rs.next()) {
                    id = rs.getInt(1);

                    user = getUserById(id);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public Boolean update(Integer id, User user) {
        Boolean status = false;
        String sql = "UPDATE users SET fullname=?,email=?,t_doc=?,n_doc=?,profile=?,password=?,username=?,is_active=? "
                + " WHERE id=?";
        try (var db = MysqlConnect.getConnection();
                var stm = db.prepareStatement(sql)) {

            stm.setString(1, user.getFullname());
            stm.setString(2, user.getEmail());
            stm.setString(3, user.getT_doc());
            stm.setString(4, user.getN_doc());
            stm.setString(5, user.getProfile());
            stm.setString(6, user.getPassword());
            stm.setString(7, user.getUsername());
            stm.setBoolean(8, user.getIsActive());
            stm.setInt(9, id);

            if (stm.executeUpdate() != 0) {
                status = true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;

    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM users WHERE id=" + id.toString();
        try (var db = MysqlConnect.getConnection();
                var stm = db.prepareStatement(sql)) {
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAll() {
        List<User> user = new ArrayList<User>();

        String sql = "SELECT * FROM users";

        try (var db = MysqlConnect.getConnection();
                var stmt = db.createStatement();
                var rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                user.add(new User(
                        rs.getInt("id"),
                        rs.getString("fullname"),
                        rs.getString("email"),
                        rs.getString("t_doc"),
                        rs.getString("n_doc"),
                        rs.getString("profile"),
                        rs.getString("password"),
                        rs.getString("username"),
                        rs.getBoolean("is_active")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public User getUserById(Integer id) {

        User user = new User();

        String sql = "SELECT * FROM users WHERE id=" + id.toString();

        try (var db = MysqlConnect.getConnection();
                var stmt = db.createStatement();
                var rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                user.setId(id);
                user.setFullname(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setT_doc(rs.getString("t_doc"));
                user.setN_doc(rs.getString("n_doc"));
                user.setProfile(rs.getString("profile"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setIsActive(rs.getBoolean("is_active"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

}
