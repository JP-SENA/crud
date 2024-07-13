/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jpadilla.app.crud.entities;

/**
 *
 * @author jhonatan
 */
public class User {

    
public enum Profile {
    super_admin,
    admin,
    coordinador,
    cajero,
    mesero,
    support
}

public enum TypeDoc{
    Cedula_ciudadania,
    Tarjeta_identidad,
    Registro_civil,
    Nit,
    Pasaporte,
    Otro
}
    
    private Integer id;
    private String username;
    private String fullname;
    private String tDoc;
    private String nDoc;
    private String email;
    private String password;
    private String profile;
    private Boolean isActive;

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", fullname=" + fullname + ", tDoc=" + tDoc + ", nDoc="
                + nDoc + ", email=" + email + ", password=" + password + ", profile=" + profile + ", isActive="
                + isActive + "]";
    }

    public User() {
    }

    public User(Integer id, String username, String fullname, String tDoc, String nDoc, String email, String password, String profile, Boolean isActive) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.tDoc = tDoc;
        this.nDoc = nDoc;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.isActive = isActive;
    }

    public User(String username, String fullname, String tDoc, String nDoc, String email, String password, String profile, Boolean isActive) {
        this.username = username;
        this.fullname = fullname;
        this.tDoc = tDoc;
        this.nDoc = nDoc;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getT_doc() {
        return tDoc;
    }

    public void setT_doc(String tDoc) {
        this.tDoc = tDoc;
    }

    public String getN_doc() {
        return nDoc;
    }

    public void setN_doc(String nDoc) {
        this.nDoc = nDoc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    
    
    
}
    

