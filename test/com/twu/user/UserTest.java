package com.twu.user;

import com.twu.database.UsersDB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.assertEquals;

public class UserTest {


    private final static User USER_1 = new User("111-1111", "1234", "Awesome User 1", "user1@email.com", "99999999");
    private final static User USER_2 = new User("222-2222", "1234", "Awesome User 2", "user2@email.com", "99999999");

    private UsersDB usersDB;

    @Before
    public void startUp(){
        usersDB = new UsersDB();
    }

    @Test
    public void testUserName(){
        assertEquals("111-1111", USER_1.getUsername());
        assertEquals("222-2222", USER_2.getUsername());
    }

    @Test
    public void areTwoUsersEquals(){
        Assert.assertFalse(USER_1.equals(USER_2));
    }

    @Test
    public void userListCreation(){
        assertEquals(USER_1, usersDB.getUserByID(USER_1.getUsername()));
    }


}
