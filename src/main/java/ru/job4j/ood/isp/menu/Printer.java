package ru.job4j.ood.isp.menu;

import java.util.Iterator;

public class Printer implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        Iterator<Menu.MenuItemInfo> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Menu.MenuItemInfo menuItemInfo = iterator.next();
            String[] numberParts = menuItemInfo.getNumber() != null
                    ? menuItemInfo.getNumber().split("\\.")
                    : new String[0];
            for (int i = 1; i < numberParts.length; i++) {
                System.out.print("...");
            }
            System.out.println(menuItemInfo.getNumber() + menuItemInfo.getName());
        }
    }
}
