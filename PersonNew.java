public class PersonNew {
    private First name;
    private int height;
    private PersonNew father;

    public PersonNew(String firstName, int height) { //Строка и рост
        this(new First(firstName), height, null);
    }

    public PersonNew(String firstName, int height, PersonNew father) { //Строка, рост и отец
        this(new First(firstName), height, father);
    }

    public PersonNew(First name, int height) { //First и рост
        this(name, height, null);
    }

    public PersonNew(First name, int height, PersonNew father) { //основной конструктор
        this.name = name;
        this.height = height;
        this.father = father;
        FatherSNP();
    }

    private void FatherSNP() {
        if (father != null && father.name != null) {
            if (name.getSurname() == null || name.getName() == null) {
                if (father.name.getSurname() != null) {
                    name.setSurname(father.name.getSurname());
                }
            }
            if (name.getPatronymic() == null) {
                String fatherName = father.name.getName();
                if (fatherName == null) {
                    fatherName = father.name.getSurname();
                }
                if (fatherName != null && !fatherName.isEmpty()) {
                    String patronymic = generatePatronymic(fatherName);
                    name.setPatronymic(patronymic);
                }
            }
        }
    }

    private String generatePatronymic(String fathersFirstName) {
        if (fathersFirstName == null || fathersFirstName.isEmpty()) {
            return null;
        }

        String baseName = fathersFirstName;
        String suffix;

        if (fathersFirstName.endsWith("й") || fathersFirstName.endsWith("ь")) {
            suffix = "евич";
        } else if (fathersFirstName.endsWith("а") || fathersFirstName.endsWith("я")) {
            suffix = "ич";
        } else {
            suffix = "ович";
        }

        return baseName + suffix;
    }

    public First getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public PersonNew getFather() {
        return father;
    }

    public void setName(First name) {
        this.name = name;
        FatherSNP();
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setFather(PersonNew father) {
        this.father = father;
        FatherSNP();
    }

    @Override
    public String toString() {
        return "Человек с именем " + name.toString() + " и ростом " + height;
    }
}