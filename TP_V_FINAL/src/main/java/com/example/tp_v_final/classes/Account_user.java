package com.example.tp_v_final.classes;
import java.io.*;
import java.util.*;

public class Account_user implements Serializable {
    private HashMap<String, User> userMap;
    private static final String FILENAME = "users.ser";

    public Account_user() {
        userMap = new HashMap<>();
        try (FileInputStream fileIn = new FileInputStream(FILENAME);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            userMap = (HashMap<String, User>) objectIn.readObject();
            System.out.println("Les objets ont été chargés depuis le fichier " + FILENAME);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String user_name, User user) {
        userMap.put(user_name, user);
    }

    public User getUser(String user_name) {
        return userMap.get(user_name);
    }

    public boolean Authentification(String user_name) {
        return userMap.containsKey(user_name);
    }

    public void save(User user, String pseudo) {
        userMap.put(pseudo, user);

        try (FileOutputStream fileOut = new FileOutputStream(FILENAME);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(userMap);
            System.out.println("Les objets ont été sauvegardés dans le fichier " + FILENAME);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

