package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TodoApp {
    private static final ActionDelegate DEFAULT_ACTION = () -> System.out.println("Some action");
    private SimpleMenu menu = new SimpleMenu();

    public void run() {
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printer.print(menu);
            System.out.println("-----------------------");
            System.out.println("A - Add item to root");
            System.out.println("D - aDd item to parent");
            System.out.println("E - quit the program");
            System.out.println("or choose number of items to run actions");
            String input = scanner.next();
            if (input.equals("A")) {
                System.out.println("Enter the name of item:");
                if (addToRoot(scanner.next())) {
                    System.out.println("Item added!!");
                } else {
                    System.out.println("Item cant be added!!");
                }
            } else if (input.equals("D")) {
                System.out.println("Enter the name of parentItem:");
                String parentName = scanner.next();
                System.out.println("Enter the name of item:");
                String itemName = scanner.next();
                if (addItem(parentName, itemName)) {
                    System.out.println("Item added!!");
                } else {
                    System.out.println("Item cant be added!!");
                }
            } else if (input.equals("E")) {
                return;
            } else {
                action(input);
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TodoApp app = new TodoApp();
        app.run();
    }

    private boolean addToRoot(String menuItem) {
        return menu.add(null, menuItem, DEFAULT_ACTION);
    }

    private boolean addItem(String parent, String menuItem) {
        return menu.add(parent, menuItem, DEFAULT_ACTION);
    }

    private void action(String action) {
        menu.select(action).ifPresent(a -> a.getActionDelegate().delegate());
    }
}
