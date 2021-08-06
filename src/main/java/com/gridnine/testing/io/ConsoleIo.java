package com.gridnine.testing.io;

import java.util.Scanner;

public class ConsoleIo {
    public void print(String message) {
        System.out.println(message);
    }

    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
