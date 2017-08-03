/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.database;

import com.twu.user.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by tlourenzo on 01-08-2017.
 */
public class UsersDBTest {

    private UsersDB mockUserDB;
    private User user;

    @Before
    public void setUp(){
        mockUserDB = new MockUserDB();
        user = new User("123-1234", "1234", "Test User", "test@email.com", "0000000");
    }



    @Test
    public void testUserByID(){
        User userToTest = mockUserDB.getUserByID("123-1234");
        assertEquals(user, userToTest);
    }



    @Test
    public void testIfSameUsers(){
        assertEquals(user, mockUserDB.getUserByID(user.getUsername()));
    }


    private class MockUserDB extends UsersDB {

        @Override
        public User getUserByID(String ID){
            return new User("123-1234", "1234", "Test User", "test@email.com", "0000000");
        }

        @Override
        public List<User> getUsersList(){
            return Collections.singletonList(new User("123-1234", "1234", "Test User", "test@email.com", "0000000"));
        }
    }
}
