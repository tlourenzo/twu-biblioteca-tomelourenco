/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.database;

import com.twu.user.User;

import java.util.*;

/**
 * Created by tlourenzo on 30-07-2017.
 */
public class UsersDB {

    private HashMap<String, User> users;

    /**
     * This class is intended to be the current users database for the project, it allows to create and make crud operations.
     */
    public UsersDB() {
        this.createUserdatabase();
    }

    /**
     * method design to create a user database
     */
    private void createUserdatabase() {
        users = new HashMap<String, User>();
        users.put("111-1111",new User("111-1111", "1234", "Awesome User 1", "user1@email.com", "99999999"));
        users.put("222-2222",new User("222-2222", "1234", "Awesome User 2", "user2@email.com", "99999999"));
        users.put("333-3333",new User("333-3333", "1234", "Awesome User 3", "user3@email.com", "99999999"));
        users.put("444-4444",new User("444-4444", "1234", "Awesome User 4", "user4@email.com", "99999999"));
        users.put("000-0000",new User("000-0000", "1234", "Librarian", "librarian@email.com", "99999999"));
    }

    /**
     * Receiving an ID as a parameter,this method allows to get the corresponded user from the map
     * @param ID
     * @return
     */
    public User getUserByID(String ID){
        if(!users.isEmpty() && ID.matches("\\d{3}-\\d{4}") ){
            User userToReturn = users.get(ID);
            return userToReturn;
        }
        return null;
    }

    /**
     * Given in a new user, it adds it to the database
     * @param user
     * @return
     */
    public boolean addUsertoDB(User user){
            if(!users.containsKey(user.getUsername())){
                users.put(user.getUsername(),user);
                return true;
            }
            else{
                return false;
            }
    }

    /**
     * method done to remove a given user form db
     * @param user
     * @return
     */
    public boolean removeUserFromDB(User user){
        if(users.containsKey(user.getUsername())){
            users.remove(user.getUsername());
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * Method to get a list of all users in the current db
     * @return
     */
    public List<User> getUsersList(){
        List<User> usersInDb = new ArrayList<User>();
        for (User user: users.values()) {
            usersInDb.add(user);
        }
        return usersInDb;
    }
}
