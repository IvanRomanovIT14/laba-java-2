public class Cat {
    private String name;

    public Cat(String name) { //Конструктор создаёт кота с именем
        this.name = name;
    }

    public String getName() { //Геттер для имени кота
        return name;
    }

    public void setName(String name) { //Сеттер для имени кота
        this.name = name;
    }

    @Override
    public String toString() { //Метод для создания строки
        return "кот: " + name;
    }

    public void meow() { //Метод для 1 мяу!
        System.out.println(name + ": мяу!");
    }

    public void meow(int n) { //Метод для нескольких мяуканий
        if (n <= 0) {
            System.out.println(name + ": тишина");
            return;
        }
        StringBuilder res = new StringBuilder(name + ": ");
        for (int i = 0; i < n; i++) {
            res.append("мяу");
            if (i < n - 1) {
                res.append("-");
            }
        }
        res.append("!");
        System.out.println(res.toString());
    }
}
