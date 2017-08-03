/*
 * Created by Tome Lourenco for TWU 101
 * v.1.0
 */

package com.twu.user;

/**
 * Created by tlourenzo on 30-07-2017.
 */
public class User {

    private String username;
    private String password;
    private String name;
    private String email;
    private String phonenumber;

    /**
     *
     * This class is meant to be the entity representation of the User (consumer)
     * @param username
     * @param password
     * @param name
     * @param email
     * @param phonenumber
     */
    public User(String username, String password, String name, String email, String phonenumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return username != null ? username.equals(user.username) : user.username == null;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}
