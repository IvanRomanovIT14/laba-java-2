public class Father {
    private First name;
    private int height;
    private Father father;
    private String gender;

    public Father(First name, int height) {
        this(name, height, null, "male");
    }

    public Father(First name, int height, String gender) {
        this(name, height, null, gender);
    }

    public Father(First name, int height, Father father) {
        this(name, height, father, "male");
    }

    public Father(First name, int height, Father father, String gender) {
        this.name = name;
        this.height = height;
        this.father = father;
        if (gender != null) {
            this.gender = gender;
        } else {
            this.gender = "male";
        }
        FatherSNP();
    }

    private void FatherSNP() {
        if (father != null && father.name != null) {
            if ((name.getSurname() == null || name.getSurname().isEmpty()) &&
                    father.name.getSurname() != null &&
                    !father.name.getSurname().isEmpty()) {
                name.setSurname(father.name.getSurname());
            }
            if ((name.getPatronymic() == null || name.getPatronymic().isEmpty()) &&
                    father.name.getName() != null && !father.name.getName().isEmpty()) {
                String patronomic2 = Generatepatronomic2(father.name.getName());
                name.setPatronymic(patronomic2);
            }
        }
    }

    private String Generatepatronomic2(String fathersName) {
        if (fathersName == null || fathersName.isEmpty()) {
            return null;
        }

        String baseName = fathersName;
        String suffix;

        if (gender == "male") {
            suffix = getMaleSuffix(fathersName);
        } else {
            suffix = getFemaleSuffix(fathersName);
        }
        return baseName + suffix;
    }

    private String getMaleSuffix(String fathersName) {
        if (fathersName.endsWith("й") || fathersName.endsWith("ь")) {
            return "евич";
        } else if (fathersName.endsWith("а") || fathersName.endsWith("я")) {
            return "ич";
        } else {
            return "ович";
        }
    }

    private String getFemaleSuffix(String fathersName) {
        if (fathersName.endsWith("й") || fathersName.endsWith("ь")) {
            return "евна";
        } else if (fathersName.endsWith("а") || fathersName.endsWith("я")) {
            return "инична";
        } else {
            return "овна";
        }
    }

    public First getName() {
        return name;
    }

    public void setName(First name) {
        this.name = name;
        FatherSNP();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
        FatherSNP();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender != null) {
            this.gender = gender;
        } else {
            this.gender = "male";
        }
        if (father != null && father.name.getName() != null && name.getPatronymic() != null) {
            String newPatronomic = Generatepatronomic2(father.name.getName());
            name.setPatronymic(newPatronomic);
        }
    }

    @Override
    public String toString() {
        return "Человек с именем " + name.toString() + " и ростом " + height;
    }
}
