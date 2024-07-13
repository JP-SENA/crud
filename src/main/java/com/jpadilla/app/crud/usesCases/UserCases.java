package com.jpadilla.app.crud.usesCases;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.jpadilla.app.crud.controllers.UserController;
import com.jpadilla.app.crud.entities.User;
import com.jpadilla.app.crud.entities.User.Profile;
import com.jpadilla.app.crud.entities.User.TypeDoc;

public class UserCases {

    public static void createUser(UserController uc) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Crear un nuevo usuario");
            System.out.println("*************************************************************");
            System.out.print("Nombre Completo : ");
            String fullname = sc.next();
            System.out.print("Email : ");
            String email = sc.next();
            System.out.print("Tipo Doc : ");
            System.out.println("************ Opciones ***********");
            for (TypeDoc doc : User.TypeDoc.values()) {
                System.out.println(doc);
            }
            String tDoc = sc.next();
            System.out.print("N Doc : ");
            String nDoc = sc.next();
            System.out.println("************ Opciones ***********");
            for (Profile profile : User.Profile.values()) {
                System.out.println(profile);
            }
            System.out.print("Perfil : ");
            String profile = sc.next();
            System.out.print("Password : ");
            String password = sc.next();
            System.out.print("Usuario : ");
            String username = sc.next();
            System.out.print("Activo : ");
            Boolean isActive = sc.nextBoolean();

            User user = new User();
            user.setFullname(fullname);
            user.setEmail(email);
            user.setT_doc(tDoc);
            user.setN_doc(nDoc);
            user.setProfile(profile);
            user.setPassword(password);
            user.setUsername(username);
            user.setIsActive(isActive);
            User us =uc .save(user);
            if (us.getId() > 0) {
                System.out.println("User created successfully");
            }else{
                System.out.println("ERROR : No se pudo crear el usuario");
            }
        }
    }

    public static void getAllUsers(UserController uc){
        for (User user : uc.getAll()) {
            System.out.println(user);
        }
    }

    public static void getOneUser(UserController uc){

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el id del usuario : ");
            int id = scanner.nextInt();

            if(id > 0){
                User user = uc.getUserById(id);

                if(user.getId() != 0){
                    System.out.println(user);
                }else{
                    System.out.println("User not found");
                }

            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        
    }

    public static void deleteOneUser(UserController uc){

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Ingrese el id del usuario que desea borrar : ");
            int id = scanner.nextInt();

            if(id > 0){

                User user = uc.getUserById(id);

                if(user.getId() > 0){
                    uc.delete(user.getId());
                    System.out.println("USer delete successfully");
                }else{
                    System.out.println("No se encontró usuario con ese id");
                }

            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        
    }

    public static void updateUser(UserController uc) {
        try (Scanner sc = new Scanner(System.in)) {

            
            System.out.println("Modificar usuario");
            System.out.println("*************************************************************");
            System.out.print("Buscar por id : ");
            int id = sc.nextInt();

            User user = uc.getUserById(id);

            if(user.getId() <= 0){
                System.out.println("USer not found");
                return;
            }

            String fullname = JOptionPane.showInputDialog("Nombre completo",user.getFullname());
            String email = JOptionPane.showInputDialog("Email",user.getEmail());
            String tDoc = JOptionPane.showInputDialog("Tipo Doc -> " +User.TypeDoc.values() ,user.getT_doc());
            String nDoc = JOptionPane.showInputDialog("Nro Doc",user.getN_doc());
            String profile = JOptionPane.showInputDialog("Perfil -> " +User.Profile.values() ,user.getProfile());
            String password = JOptionPane.showInputDialog("Password",user.getPassword());
            String username = JOptionPane.showInputDialog("Password",user.getUsername());
            Boolean isActive =Boolean.parseBoolean(JOptionPane.showInputDialog("Esta activo ",user.getIsActive()));

            User us = new User();
            us.setFullname(fullname);
            us.setEmail(email);
            us.setT_doc(tDoc);
            us.setN_doc(nDoc);
            us.setProfile(profile);
            us.setPassword(password);
            us.setUsername(username);
            us.setIsActive(isActive);
            
            if (uc .update(id,user)) {
                JOptionPane.showMessageDialog(null,"User updated successfully");
            }else{
                JOptionPane.showMessageDialog(null,"ERROR : No se pudo crear el usuario");
            }
        }
    }

}
