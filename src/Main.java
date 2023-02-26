import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        LinkedList<String> list = new LinkedList();
        Main product = new Main();
        while (true) {
            System.out.println("Выберите операцию: ");
            System.out.println("1. Добавить");
            System.out.println("2. Показать ");
            System.out.println("3. Удалить ");
            System.out.println("4. Поиск ");
            System.out.println("end для выхода ");
            String num = scanner.nextLine();
            if (num.equals("1")) {
                product.addProduct(scanner, count, list);
            }
            if (num.equals("2")) {
                product.productList(list);
            }
            if (num.equals("3")) {
                product.removeProduct(scanner, count, list);
            }
            if (num.equals("4")) {
                product.searchProduct(scanner, list);
            }
            if (num.equals("end")) {
                break;
            }
        }
    }

    public void searchProduct(Scanner scanner, LinkedList<String> list) {
        System.out.println("Введите текст для поиска: ");
        String text = scanner.nextLine();
        System.out.println("Найдено: ");
        for (String s : list) {
            if (s.toLowerCase().contains(text.toLowerCase())) {
                System.out.println((list.indexOf(s) + 1) + ". " + s);
            }
        }
    }

    public int removeProduct(Scanner scanner, int count, LinkedList<String> list) {
        System.out.println("Список покупок: ");
        for (String s : list) {
            System.out.println(list.indexOf(s) + 1 + s);
        }
        System.out.println("Какую хотите удалить? Введите номер или название ");
        String text = scanner.nextLine();
        if (list.contains(text)) {
            list.remove(text);
            count -= 1;
        } else {
            list.remove(Integer.parseInt(text) - 1);
            count -= 1;
        }
        return count;
    }

    public void productList(LinkedList<String> list) {
        System.out.println("Список покупок: ");
        for (String s : list) {
            System.out.println(list.indexOf(s) + 1 + ". " + s);
        }
    }

    public int addProduct(Scanner scanner, int count, LinkedList<String> list) {
        System.out.println("Какую покупку хотите добавить: ");
        list.add(scanner.nextLine());
        count += 1;
        System.out.println("Итого в корзине: " + count);
        return count;
    }
}