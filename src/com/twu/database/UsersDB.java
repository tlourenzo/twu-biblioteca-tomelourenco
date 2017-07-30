/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.database;

import com.twu.user.User;
import com.twu.utilities.DisplayMessages;

import java.util.*;

/**
 * Created by tlourenzo on 30-07-2017.
 */
public class UsersDB {

    private HashMap<String, User> users;

    public UsersDB() {
        this.createUserdatabase();
    }

    private void createUserdatabase() {
        users = new HashMap<String, User>();
        users.put("111-1111",new User("111-1111", "123456", "Awesome User 1", "user1@email.com", "99999999"));
        users.put("222-2222",new User("222-2222", "123456", "Awesome User 2", "user2@email.com", "99999999"));
        users.put("333-3333",new User("333-3333", "123456", "Awesome User 3", "user3@email.com", "99999999"));
        users.put("444-4444",new User("444-4444", "123456", "Awesome User 4", "user4@email.com", "99999999"));

    }

    public User getUserByID(String ID){
        if(!users.isEmpty() && ID.matches("\\d{3}-\\d{4}") ){
            User userToReturn = users.get(ID);
            return userToReturn;
        }
        return null;
    }

    public boolean addUsertoDB(User user){
            if(!users.containsKey(user.getUsername())){
                users.put(user.getUsername(),user);
                return true;
            }
            else{
                return false;
            }
    }

    public boolean removeUserFromDB(User user){
        if(users.containsKey(user.getUsername())){
            users.remove(user.getUsername());
            return true;
        }
        else{
            return false;
        }
    }

    public List<User> getUsersList(){
        List<User> usersInDb = new ArrayList<User>();
        for (User user: users.values()) {
            usersInDb.add(user);
        }
        return usersInDb;
    }
}
