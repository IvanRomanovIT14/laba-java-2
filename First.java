public class First {
    private String surname;
    private String name;
    private String patronymic;

    public First(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public First(String surname, String name) {
        this(surname, name, null);
    }

    public First(String surname) {
        this(surname, null, null);
    }

    public static boolean Correct(String nsp) {
        if (nsp == null || nsp.isEmpty()) {
            return true;
        }
        return nsp.matches("^[a-zA-Zа-яА-ЯёЁ\\s-]+$");
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        if (surname != null && !surname.isEmpty()) {
            res.append(surname);
        }
        if (name != null && !name.isEmpty()) {
            if (res.length() > 0)
                res.append(" ");
            res.append(name);
        }
        if (patronymic != null && !patronymic.isEmpty()) {
            if (res.length() > 0)
                res.append(" ");
            res.append(patronymic);
        }
        return res.toString();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
