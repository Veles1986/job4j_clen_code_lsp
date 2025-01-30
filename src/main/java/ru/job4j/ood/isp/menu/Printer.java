package ru.job4j.ood.isp.menu;

import java.util.Iterator;

public class Printer implements MenuPrinter {
    @Override
    public String print(Menu menu) {
        Iterator<Menu.MenuItemInfo> iterator = menu.iterator();
        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()) {
            Menu.MenuItemInfo menuItemInfo = iterator.next();
            String[] numberParts = menuItemInfo.getNumber() != null
                    ? menuItemInfo.getNumber().split("\\.")
                    : new String[0];
            for (int i = 1; i < numberParts.length; i++) {
                result.append("...");
            }
            result.append(menuItemInfo.getNumber()).append(menuItemInfo.getName()).append(System.lineSeparator());
        }
        return result.toString();
    }
}
