public class PersonNew {
    private First name;
    private int height;
    private PersonNew father;

    public PersonNew(String firstName, int height) { //Конструктор - строка и рост
        this(new First(firstName), height, null);
    }

    //Конструктор - строка, рост и отец
    public PersonNew(String firstName, int height, PersonNew father) {
        this(new First(firstName), height, father);
    }

    public PersonNew(First name, int height) { //Конструктор с First и ростом
        this(name, height, null);
    }

    //Конструктор - имя, рост и ссылка на отца
    public PersonNew(First name, int height, PersonNew father) {
        this.name = name;
        this.height = height;
        this.father = father;
        fatherSNP();
    }

    //Метод для наследования фамилии и генерации отчества от отца
    private void fatherSNP() {
        if (father != null && father.name != null) {
            if (name.getSurname() == null || name.getName() == null) {
                if (father.name.getSurname() != null) {
                    name.setSurname(father.name.getSurname()); //Наследуем фамилию от отца
                }
            }
            if (name.getPatronymic() == null) {
                String fatherName = father.name.getName(); //Берём имя отца как отчество
                if (fatherName == null) { //Если у отца нет имени, берем его фамилию
                    fatherName = father.name.getSurname();
                }
                if (fatherName != null && !fatherName.isEmpty()) {
                    //Генерируем отчество на основе имени отца
                    String patronymic = generatePatronymic(fatherName);
                    name.setPatronymic(patronymic);
                }
            }
        }
    }

    //Генерирует отчество на основе имени отца
    private String generatePatronymic(String fathersName) {
        if (fathersName == null || fathersName.isEmpty()) {
            return null;
        }

        String baseName = fathersName; //Основа отчества = имя отца
        String suffix;

        if (fathersName.endsWith("й") || fathersName.endsWith("ь")) {
            suffix = "евич";
        } else if (fathersName.endsWith("а") || fathersName.endsWith("я")) {
            suffix = "ич";
        } else {
            suffix = "ович";
        }

        return baseName + suffix;
    }

    //Геттер возвращает First с именем человека
    public First getName() {
        return name;
    }

    //Сеттер для роста
    public int getHeight() {
        return height;
    }

    //Геттер возвращает ссылку на отца
    public PersonNew getFather() {
        return father;
    }

    //Устанавливает новое имя для человека с обновлением фамилии и отчества
    public void setName(First name) {
        this.name = name;
        fatherSNP();
    }

    //Сеттер для роста
    public void setHeight(int height) {
        this.height = height;
    }

    //Сеттер устанавливает нового отца для человека с обновлением фамилии и отчества
    public void setFather(PersonNew father) {
        this.father = father;
        fatherSNP();
    }

    @Override
    public String toString() { //Метод для создания строки
        return "Человек с именем " + name.toString() + " и ростом " + height;
    }
}
