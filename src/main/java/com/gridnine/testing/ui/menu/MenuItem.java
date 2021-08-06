package com.gridnine.testing.ui.menu;

public abstract class MenuItem implements RunnableMenuItem{
    private final String label;
    private final String description;

    public MenuItem(String label, String description) {
        this.label = label;
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }
}
