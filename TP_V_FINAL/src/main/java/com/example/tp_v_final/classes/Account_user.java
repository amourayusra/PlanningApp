package com.example.tp_v_final.classes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

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

        try (
                BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\n"); // Séparation des données par le saut de ligne
                String filePseudo = data[0];
                if (user_name.equals(filePseudo)) {
                    isFound = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isFound;
    }


}
