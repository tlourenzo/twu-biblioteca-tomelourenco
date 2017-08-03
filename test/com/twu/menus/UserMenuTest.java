package com.twu.menus;

import com.twu.database.Inventory;
import com.twu.user.User;
import com.twu.utilities.DisplayMessages;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class UserMenuTest {

    private User loggedUser;
    private UserMenu userMenu;
    private Inventory inventory;
    private DisplayMessages display;

    @Before
    public void setUp(){
        loggedUser = new User("123-1234", "1234","Test User","Test@Email", "0000000");
        inventory = new Inventory();
        display = DisplayMessages.getInstance();
        userMenu = new UserMenu();
    }

    @Test
    public void testCheckoutMenuInit() {
        String input = "0\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        userMenu.run(inventory, new Scanner(inputStream), printStream, display, loggedUser);
        String output = baos.toString();

        assertEquals("\n" +
                "User details List\n" +
                "\n" +
                "\n" +
                "UserName: 123-1234\n" +
                "Password: 1234\n" +
                "Name: Test User\n" +
                "Email: Test@Email\n" +
                "PhoneNumber: 0000000\n" +
                "\n" +
                "Current checked out items: \n" +
                "\n" +
                "Type            Title           Author/Director Current Holder \n" +
                "\n" +
                "Please press 0 to exit.\n", output);

    }

}
