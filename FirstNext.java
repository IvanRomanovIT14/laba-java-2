public class FirstNext {
    private String name;
    private String surname;
    private String patronymic;

    public FirstNext(String name) { //Конструктор только с именем
        this.name = name;
        this.surname = null;
        this.patronymic = null;
    }

    public FirstNext(String name, String surname) { //Конструктор с именем и фамилией
        this.name = name;
        this.surname = surname;
        this.patronymic = null;
    }

    //Конструктор с именем, фамилией и отчеством
    public FirstNext(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getName() { //Геттер для имени
        return name;
    }

    public String getSurname() { //Геттер для фамилии
        return surname;
    }

    public String getPatronymic() { //Геттер для отчества
        return patronymic;
    }

    public void setName(String name) { //Сеттер для имени
        this.name = name;
    }

    public void setSurname(String surname) { //Сеттер для фамилии
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) { //Сеттер для отчества
        this.patronymic = patronymic;
    }

    @Override
    public String toString() { //Метод для создания строки
        if (surname != null && patronymic != null) {
            return name + " " + patronymic + " " + surname;
        } else if (surname != null) {
            return name + " " + surname;
        } else {
            return name;
        }
    }
}
