// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.LinkedHashMap;
// import java.util.Map;
// import java.util.Scanner;
// import java.util.Set;

import java.util.*;

/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
1. Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет выборку: имя ноутбука и выбранный критерий . Критерии фильтрации можно хранить в Map.
Сделать выборку.
Например:
Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Пользователь ввел 1. Вывести в виде.
|Имя| ОЗУ|
|--------|-----------|
| Asus | 2ГБ |
| HP | 4ГБ |
| MSI | 6ГБ |
2. Отфильтровать ноутбуки первоначального множества. По возрастанию имени ноутбука в алфавитном порядке, по цене по убыванию
Например, по алфавиту
|Имя| ОЗУ| Цена
|--------|-----------|-----------|
| Asus | 2ГБ | 4666|
| MSI | 4ГБ |6600|
| HP | 6ГБ| 5555|
*/


public class main {
    public static Integer FilterChoice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                Введите число для поиска:\n
                1 -> по модели\n
                2 -> по процессору\n
                3 -> по оперативной памяти\n
                4 -> по жесткому диску\n
                5 -> по цвету\n
                6 -> посмотреть все модели\n""");
        System.out.print("Ввод -> ");
        return scan.nextInt();
    }

    public static String FirstUpperCase(String word) {
        if (word == null || word.isEmpty()) {
            return " ";
        } else {
            return word.substring(0, 1).toUpperCase() + word.substring(1);
        }
    }

    public static void FindByFilter(HashSet<Notebooks> products, String filter, String input) {
        int count = 1;
        Map<String, Notebooks> result = new LinkedHashMap<>();
        for (Notebooks PC : products) {
            if (PC.GetInfo(filter).contains(input)) {
                result.put(String.format("Notebook", count), PC);
                count++;
            }
        }
        if (result.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            System.out.println("Результат поиска: " + result);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Notebooks PC1 = new Notebooks("1", "Dell", "Intel Core i5", "4GB", "2T", "black");
        Notebooks PC2 = new Notebooks("2", "Asus", "Intel Core i4", "3GB", "2T", "yellow");
        Notebooks PC3 = new Notebooks("3", "Lenovo", "Intel Core i3", "2GB", "2T", "red");
        Notebooks PC4 = new Notebooks("4", "Apple", "Intel Core i2", "6GB", "6T", "green");
        Notebooks PC5 = new Notebooks("5", "HP", "Intel Core i1", "8GB", "2T", "blue");
        Notebooks PC6 = new Notebooks("6", "Apple pro", "Intel i5", "4GB", "4T", "white");

        HashSet<Notebooks> products = new HashSet<>(Arrays.asList(PC1, PC2, PC3, PC4, PC5, PC6));
        Map<Integer, String> filter = new HashMap<>();
        filter.put(1, "Model");
        filter.put(2, "Processor");
        filter.put(3, "Ram");
        filter.put(4, "HDD");
        filter.put(5, "Color");
        filter.put(6, "All products");
        int choice = FilterChoice();

        Scanner scan = new Scanner(System.in);
        Map<String, Notebooks> filters;
        if (filters.containsKey(choice)) {
            switch (choice) {
                case 1:
                    System.out.println("Введите наименование модели");
                    System.out.print("Ввод -> ");
                    String input = FirstUpperCase(scan.next());
                    FindByFilter(products, filters.get(1), input);
                case 2:
                    System.out.println("Введите наименование процессора");
                    System.out.print("Ввод -> ");
                    String input = FirstUpperCase(scan.next());
                    FindByFilter(products, filters.get(2), input);
                case 3:
                    System.out.println("Введите объём оперативной памяти");
                    System.out.print("Ввод -> ");
                    String input = FirstUpperCase(scan.next());
                    FindByFilter(products, filters.get(3), input);
                case 4:
                    System.out.println("Введите объём жёсткого диска");
                    System.out.print("Ввод -> ");
                    String input = FirstUpperCase(scan.next());
                    FindByFilter(products, filters.get(4), input);
                case 5:
                    System.out.println("Введите цвет");
                    System.out.print("Ввод -> ");
                    String input = FirstUpperCase(scan.next());
                    FindByFilter(products, filters.get(5), input);
                case 6:
                    int count = 1;
                    System.out.println("\nНаш ассортимент:");
                    for (Notebooks PC : products) {
                        System.out.println("\nНоутбук №" + count + PC);
                        count++;
                    }
            }

        }
    }

}