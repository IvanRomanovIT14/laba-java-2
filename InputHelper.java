import java.util.Scanner;

public class InputHelper { //Проверка на ввод
    public static String input(Scanner scanner, String s) {
        while (true) {
            System.out.println("Введите " + s + ":");
            String m = scanner.nextLine();
            if (m.isEmpty()) {
                return "";
            }
            if (correct(m)) {
                return m;
            } else {
                System.out.println("Можно вводить только буквы, - и пробелы !");
            }
        }
    }

    public static boolean correct(String nsp) { //Вспомогательная проверка на ввод
        if (nsp == null || nsp.isEmpty()) {
            return true;
        }
        return nsp.matches("^[a-zA-Zа-яА-ЯёЁ\\s-]+$");
    }
}
