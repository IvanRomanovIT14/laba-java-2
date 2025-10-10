public class First {
    private String surname;
    private String name;
    private String patronymic;

    //Конструктор с 3 параметрами
    public First(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }


    public First(String surname, String name) { //Конструктор с 2 параметрами
        this(surname, name, null);
    }

    public First(String surname) { //Конструктор с 1 параметром
        this(surname, null, null);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        if (surname != null && !surname.isEmpty()) {
            res.append(surname);
        }
        if (name != null && !name.isEmpty()) {
            if (res.length() > 0) {
                res.append(" ");
            }
            res.append(name);
        }
        if (patronymic != null && !patronymic.isEmpty()) {
            if (res.length() > 0) {
                res.append(" ");
            }
            res.append(patronymic);
        }
        return res.toString();
    }

    public String getSurname() { //Геттер для фамилии
        return surname;
    }

    public void setSurname(String surname) { //Сеттер для фамилии
        this.surname = surname;
    }

    public String getName() { //Геттер для имени
        return name;
    }

    public void setName(String name) { //Сеттер для имени
        this.name = name;
    }

    public String getPatronymic() { //Геттер для отчества
        return patronymic;
    }

    public void setPatronymic(String patronymic) { //Сеттер для фамилии
        this.patronymic = patronymic;
    }
}
