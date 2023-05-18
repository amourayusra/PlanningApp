package com.example.tp_v_final.classes;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;
import java.io.EOFException;

public class Account_user implements Serializable{
    private String user_name;
    private User user;
    private static final String FILENAME = "user.ser";

    public Account_user(String user_name, User user) {
        this.user_name = user_name;
        this.user = user;
    }

    public String getUser_name() {
        return user_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public boolean Authentification() {
        boolean isFound = false;

        try (FileInputStream fileIn = new FileInputStream(FILENAME);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
      /*      Account_user account = (Account_user) objectIn.readObject();

            if (account.getUser_name().equals(user_name)) {
                isFound = true;
            }*/
            List<Account_user> userList = new ArrayList<>();

            while (true) {
                try {
                    Account_user account = (Account_user) objectIn.readObject();
                    userList.add(account);
                } catch (EOFException e) {
                    // Fin de fichier atteinte
                    break;
                }
            }

            for (Account_user account : userList) {
                if (account.getUser_name().equals(user_name)) {
                    setUser(account.getUser());
                    isFound = true;
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return isFound;
    }


}
