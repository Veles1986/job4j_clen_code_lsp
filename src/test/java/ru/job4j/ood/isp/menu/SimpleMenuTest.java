package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        assertThat(new Menu.MenuItemInfo("Сходить в магазин",
                List.of("Купить продукты"), STUB_ACTION, "1."))
                .isEqualTo(menu.select("Сходить в магазин").get());
        assertThat(new Menu.MenuItemInfo(
                "Купить продукты",
                List.of("Купить хлеб", "Купить молоко"), STUB_ACTION, "1.1."))
                .isEqualTo(menu.select("Купить продукты").get());
        assertThat(new Menu.MenuItemInfo(
                "Покормить собаку", List.of(), STUB_ACTION, "2."))
                .isEqualTo(menu.select("Покормить собаку").get());
    }

    @Test
    public void whenSelectAndPrintThenTrue() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Корзинка", STUB_ACTION);
        menu.add(Menu.ROOT, "Хавас", STUB_ACTION);
        menu.add(Menu.ROOT, "Базар", STUB_ACTION);
        menu.add("Корзинка", "Мясо", STUB_ACTION);
        menu.add("Корзинка", "Курица", STUB_ACTION);
        menu.add("Корзинка", "Яйца", STUB_ACTION);
        menu.add("Хавас", "Йогурт", STUB_ACTION);
        menu.add("Хавас", "Вода", STUB_ACTION);
        menu.add("Хавас", "Кока-кола", STUB_ACTION);
        menu.add("Хавас", "Бананы", STUB_ACTION);
        menu.add("Базар", "Фрукты", STUB_ACTION);
        menu.add("Базар", "Овощи", STUB_ACTION);
        menu.add("Базар", "Кукуруза", STUB_ACTION);
        menu.add("Мясо", "Фарш", STUB_ACTION);
        menu.add("Мясо", "Филе", STUB_ACTION);
        menu.add("Курица", "Голень", STUB_ACTION);
        menu.add("Курица", "Крылышки", STUB_ACTION);
        menu.add("Йогурт", "Essi", STUB_ACTION);
        menu.add("Йогурт", "Нежный", STUB_ACTION);
        menu.add("Фрукты", "Яблоки", STUB_ACTION);
        menu.add("Фрукты", "Груша", STUB_ACTION);
        menu.add("Фрукты", "Персик", STUB_ACTION);
        menu.add("Овощи", "Помидоры", STUB_ACTION);
        menu.add("Овощи", "Огурцы", STUB_ACTION);
        menu.add("Овощи", "Картошка", STUB_ACTION);
        assertThat(new Menu.MenuItemInfo("Хавас",
                List.of("Йогурт", "Вода", "Кока-кола", "Бананы"), STUB_ACTION, "2."))
                .isEqualTo(menu.select("Хавас").get());
        assertThat(new Menu.MenuItemInfo(
                "Овощи",
                List.of("Помидоры", "Огурцы", "Картошка"), STUB_ACTION, "3.2."))
                .isEqualTo(menu.select("Овощи").get());
        assertThat(new StringBuilder()
                .append("1.Корзинка").append(System.lineSeparator())
                .append("...1.1.Мясо").append(System.lineSeparator())
                .append("......1.1.1.Фарш").append(System.lineSeparator())
                .append("......1.1.2.Филе").append(System.lineSeparator())
                .append("...1.2.Курица").append(System.lineSeparator())
                .append("......1.2.1.Голень").append(System.lineSeparator())
                .append("......1.2.2.Крылышки").append(System.lineSeparator())
                .append("...1.3.Яйца").append(System.lineSeparator())
                .append("2.Хавас").append(System.lineSeparator())
                .append("...2.1.Йогурт").append(System.lineSeparator())
                .append("......2.1.1.Essi").append(System.lineSeparator())
                .append("......2.1.2.Нежный").append(System.lineSeparator())
                .append("...2.2.Вода").append(System.lineSeparator())
                .append("...2.3.Кока-кола").append(System.lineSeparator())
                .append("...2.4.Бананы").append(System.lineSeparator())
                .append("3.Базар").append(System.lineSeparator())
                .append("...3.1.Фрукты").append(System.lineSeparator())
                .append("......3.1.1.Яблоки").append(System.lineSeparator())
                .append("......3.1.2.Груша").append(System.lineSeparator())
                .append("......3.1.3.Персик").append(System.lineSeparator())
                .append("...3.2.Овощи").append(System.lineSeparator())
                .append("......3.2.1.Помидоры").append(System.lineSeparator())
                .append("......3.2.2.Огурцы").append(System.lineSeparator())
                .append("......3.2.3.Картошка").append(System.lineSeparator())
                .append("...3.3.Кукуруза").append(System.lineSeparator())
                .toString())
                .isEqualTo(new Printer().print(menu));
        System.out.println(new Printer().print(menu));
    }
}