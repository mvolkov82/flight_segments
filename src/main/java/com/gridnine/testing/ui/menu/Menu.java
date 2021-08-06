package com.gridnine.testing.ui.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.gridnine.testing.io.ConsoleIo;
import com.gridnine.testing.ui.menu.impl.PointA;
import com.gridnine.testing.ui.menu.impl.PointB;
import com.gridnine.testing.ui.menu.impl.PointC;

public class Menu {
    public static final String MENU_HEADER = "┌────────────────────────────FLIGHT VIEWER──────────────────────────┐\n";
    public static final String MENU_FOOTER = "└───────────────────────────────────────────────────────────────────┘\n"
            + "☟ Choose a point (x - for exit)";
    public static final String LINE_MASK = "│  %-3s| %-60s│\n";

    private ConsoleIo consoleIo = new ConsoleIo();
    private final Map<String, MenuItem> menuItems = new HashMap<>();

    public Menu() {
        menuItems.put("a", new PointA("a", "Search flights before now"));
        menuItems.put("b", new PointB("b", "Search flights where a segment has arrival before departure"));
        menuItems.put("c", new PointC("c", "Search flights where ground time more than 2 hours"));
    }

    public MenuItem getItem(String label) {
        return menuItems.computeIfAbsent(label, e -> {
            throw new NoSuchElementException(e);
        });
    }

    public void printMenu() {
        consoleIo.print(getFormattedMenu());
    }

    private String getFormattedMenu() {
        StringBuilder sb = new StringBuilder();
        menuItems.forEach((key, value) -> sb.append(String.format(LINE_MASK, key, value.getDescription())));
        return MENU_HEADER + sb.toString() + MENU_FOOTER;
    }
}
