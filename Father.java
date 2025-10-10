public class Father {
    private First name;
    private int height;
    private Father father;
    private String gender;

    //Конструктор создаёт отца с именем, ростом и мужской пол
    public Father(First name, int height) {
        this(name, height, null, "male");
    }

    //Конструктор создаёт отца с именем, ростом и указанным полом
    public Father(First name, int height, String gender) {
        this(name, height, null, gender);
    }

    //Конструктор создает отца с именем, ростом и ссылкой на отца
    public Father(First name, int height, Father father) {
        this(name, height, father, "male");
    }

    //Конструктор создает отца с именем, ростом, ссылкой на отца и полом
    public Father(First name, int height, Father father, String gender) {
        this.name = name;
        this.height = height;
        this.father = father;
        if (gender != null && (gender.equals("male") || gender.equals("female"))) {
            this.gender = gender;
        } else {
            this.gender = "male";
        }
        fatherSNP();
    }

    //Метод для автоматического заполнения фамилии и отчества на основе данных отца
    private void fatherSNP() {
        //Если у текущего человека нет фамилии, а у отца есть, берём фамилию отца
        if (father != null && father.name != null) {
            if ((name.getSurname() == null || name.getSurname().isEmpty()) &&
                    father.name.getSurname() != null &&
                    !father.name.getSurname().isEmpty()) {
                name.setSurname(father.name.getSurname());
            }
            //Если у текущего человека нет отчества, а у отца есть, берём отчество у отца
            if ((name.getPatronymic() == null || name.getPatronymic().isEmpty()) &&
                    father.name.getName() != null && !father.name.getName().isEmpty()) {
                String patronomic2 = generatepatronomic2(father.name.getName());
                name.setPatronymic(patronomic2);
            }
        }
    }

    //Генерирует отчество на основе имени отца с учетом пола текущего человека
    private String generatepatronomic2(String fathersName) {
        if (fathersName == null || fathersName.isEmpty()) {
            return null;
        }

        String baseName = fathersName; //Основа отчества = имя отца
        String suffix;

        if (gender == "male") {
            suffix = getMaleSuffix(fathersName);
        } else {
            suffix = getFemaleSuffix(fathersName);
        }
        return baseName + suffix;
    }

    //Возвращает мужской суффикс для отчества в зависимости от окончания имени отца
    private String getMaleSuffix(String fathersName) {
        if (fathersName.endsWith("й") || fathersName.endsWith("ь")) {
            return "евич";
        } else if (fathersName.endsWith("а") || fathersName.endsWith("я")) {
            return "ич";
        } else {
            return "ович";
        }
    }

    //Возвращает женский суффикс для отчества в зависимости от окончания имени отца
    private String getFemaleSuffix(String fathersName) {
        if (fathersName.endsWith("й") || fathersName.endsWith("ь")) {
            return "евна";
        } else if (fathersName.endsWith("а") || fathersName.endsWith("я")) {
            return "инична";
        } else {
            return "овна";
        }
    }

    public First getName() { //Геттер для имени
        return name;
    }

    public void setName(First name) { //Сеттер для имени
        this.name = name;
        fatherSNP();
    }

    public int getHeight() { //Геттер для роста
        return height;
    }

    public void setHeight(int height) { //Сеттер для роста
        this.height = height;
    }

    public Father getFather() { //Геттер для ссылки на отца
        return father;
    }

    public void setFather(Father father) { //Сеттер для ссылки на отца
        this.father = father;
        fatherSNP();
    }

    public String getGender() { //Геттер для пола
        return gender;
    }

    public void setGender(String gender) { //Сеттер для пола
        if (gender != null) {
            this.gender = gender;
        } else {
            this.gender = "male";
        }
        //Если есть отец и уже установлено отчество, то перегенерируем его
        if (father != null && father.name.getName() != null && name.getPatronymic() != null) {
            //Генерируем новое отчество
            String newPatronomic = generatepatronomic2(father.name.getName());
            name.setPatronymic(newPatronomic);
        }
    }

    @Override
    public String toString() { //Метод для создания строки
        return "Человек с именем " + name.toString() + " и ростом " + height;
    }
}
