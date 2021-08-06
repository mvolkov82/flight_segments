package com.gridnine.testing;

import java.util.NoSuchElementException;

import com.gridnine.testing.io.ConsoleIo;
import com.gridnine.testing.ui.menu.Menu;
import com.gridnine.testing.ui.menu.MenuItem;

public class Main {
    public static final String POINT_NOT_FOUND = "Point %s not found";
    public static final String EXIT_COMMAND = "x";

    private Menu menu = new Menu();
    private ConsoleIo consoleIo = new ConsoleIo();

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        String selectedPoint = null;
        while (!EXIT_COMMAND.equalsIgnoreCase(selectedPoint)) {
            menu.printMenu();
            selectedPoint = consoleIo.readLine();
            try {
                MenuItem selectedItem = menu.getItem(selectedPoint);
                selectedItem.run();

            } catch (NoSuchElementException e) {
                String message = String.format(POINT_NOT_FOUND, selectedPoint);
                consoleIo.print(message);
            }
        }
    }
}
