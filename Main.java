import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите номер задания 1-7: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    First cleopatra1 = new First("Клеопатра");
                    First pushkin1 = new First("Пушкин", "Александр",
                            "Сергеевич");
                    First mayakovskiy1 = new First("Маяковский", "Владимир");
                    System.out.println(cleopatra1.toString());
                    System.out.println(pushkin1.toString());
                    System.out.println(mayakovskiy1.toString());
                    String surname1 = InputHelper.input(scanner, "Фамилию");
                    String name1 = InputHelper.input(scanner, "Имя");
                    String patronymic1 = InputHelper.input(scanner, "Отчество");
                    First human = new First(surname1, name1, patronymic1);
                    System.out.println("Итоговое имя: " + human);
                    break;
                case 2:
                    First cleopatra21 = new First("Клеопатра ");
                    Person cleopatra22 = new Person("", 152);
                    System.out.println("Человек с именем " + cleopatra21.toString() + "и ростом " +
                            cleopatra22);
                    First pushkin21 = new First("Пушкин Александр Сергеевич ");
                    Person pushkin22 = new Person("", 167);
                    System.out.println("Человек с именем " + pushkin21.toString() + "и ростом " +
                            pushkin22);
                    First mayakovsky21 = new First("Маяковский Владимир ");
                    Person mayakovsky22 = new Person("", 189);
                    System.out.println("Человек с именем " + mayakovsky21.toString() + "и ростом "
                            + mayakovsky22);
                    String surname2 = InputHelper.input(scanner, "Фамилию");
                    String name2 = InputHelper.input(scanner, "Имя");
                    String patronymic2 = InputHelper.input(scanner, "Отчество");
                    System.out.print("Введите рост: ");
                    int height = scanner.nextInt();
                    First human2 = new First(surname2, name2, patronymic2);
                    Person height2 = new Person("", height);
                    System.out.println("Человек с именем " + human2 + " и ростом " + height2);
                    break;
                case 3:
                    Father ivan3 = new Father(new First("Чудов", "Иван"), 175);
                    Father peter3 = new Father(new First("Чудов", "Петр"), 180);
                    Father boris3 = new Father(new First("Борис"), 170);
                    System.out.println(ivan3);
                    System.out.println(peter3);
                    System.out.println(boris3);
                    System.out.println("После установки отцов:");
                    peter3.setFather(ivan3);
                    boris3.setFather(peter3);
                    System.out.println(ivan3);
                    System.out.println(peter3);
                    System.out.println(boris3);
                    break;
                case 4:
                    City A = new City("A");
                    City B = new City("B");
                    City C = new City("C");
                    City D = new City("D");
                    City E = new City("E");
                    City F = new City("F");
                    A.addRoute(B, 5);
                    A.addRoute(F, 1);
                    A.addRoute(D, 6);
                    B.addRoute(A, 5);
                    B.addRoute(C, 3);
                    C.addRoute(D, 4);
                    D.addRoute(C, 4);
                    D.addRoute(E, 2);
                    D.addRoute(A, 6);
                    E.addRoute(F, 2);
                    F.addRoute(B, 1);
                    F.addRoute(E, 2);
                    City[] cities = {A, B, C, D, E, F};
                    for (City city : cities) {
                        System.out.println(city);
                    }
                    break;
                case 5:
                    First cleopatra5 = new First("Клеопатра");
                    First pushkin5 = new First("Пушкин", "Александр", "Сергеевич");
                    First mayakovskiy5 = new First("Маяковский", "Владимир");
                    First bonifatievich5 = new First("Христофор", "Бонифатьевич");
                    System.out.println(cleopatra5.toString());
                    System.out.println(pushkin5.toString());
                    System.out.println(mayakovskiy5.toString());
                    System.out.println(bonifatievich5.toString());
                    break;
                case 6:
                    PersonNew lev6 = new PersonNew("Лев", 170);
                    First sergeyName = new First("Пушкин", "Сергей");
                    PersonNew sergey6 = new PersonNew(sergeyName, 168, lev6);
                    PersonNew alexander6 = new PersonNew(new First(null, "Александр"), 167,
                            sergey6);
                    System.out.println(lev6);
                    System.out.println(sergey6);
                    System.out.println(alexander6);
                    if (sergey6.getFather() != null) {
                        System.out.println("Отец Сергея: " + sergey6.getFather().getName().
                                toString());
                    }
                    if (alexander6.getFather() != null) {
                        System.out.println("Отец Александра: " + alexander6.getFather().getName().
                                toString());
                    }
                    break;
                case 7:
                    Cat barsik7 = new Cat("Барсик");
                    System.out.println(barsik7.toString());
                    barsik7.meow();
                    barsik7.meow(3);
                    break;
                default:
                    System.out.println("Вводить можно только число 1-7!");
            }
        } else {
            System.out.println("Вводить можно только число 1-7!");
        }
    }
}
