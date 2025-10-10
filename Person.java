public class Person {
    private String name;
    private int height;

    public Person(String name, int height) { //Конструктор с 2 параметрами
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() { //Метод для создания строки
        return name + height;
    }

    public String getName() { //Геттер для имени
        return name;
    }

    public void setName(String name) { //Сеттер для имени
        this.name = name;
    }

    public int getHeight() { //Геттер для роста
        return height;
    }

    public void setHeight(int height) { //Сеттер для роста
        this.height = height;
    }
}
