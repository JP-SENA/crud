/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.jpadilla.app.crud;

import com.jpadilla.app.crud.controllers.UserController;
import com.jpadilla.app.crud.db.MysqlConnect;
import com.jpadilla.app.crud.entities.User;
import com.jpadilla.app.crud.entities.User.Profile;
import com.jpadilla.app.crud.entities.User.TypeDoc;
import com.jpadilla.app.crud.usesCases.UserCases;

import java.util.Scanner;

/**
 *
 * @author jhonatan
 */
public class Crud {

    public static void main(String[] args) {
       UserController uc = new UserController(); 


        int option = 0;
        do {
            Menu.showMenu();
            try (Scanner sc = new Scanner(System.in)) {
              
                System.out.print("Elija una opcion : ");
                option =  sc.nextInt();
              
                System.out.println(option);
              
                switch(option){
                    case 1:
                        UserCases.getAllUsers(uc);
                    break;
                    case 2:
                        UserCases.createUser(uc);
                    break;
                    case 3:
                        UserCases.updateUser(uc);
                    break;
                    case 4:
                        UserCases.deleteOneUser(uc);
                    break;
                    case 5:
                        UserCases.getOneUser(uc);
                    break;
                    default:
                    System.out.println("Opcion no encontrada");
                }


            }
        } while (option == 6);

    }
}
