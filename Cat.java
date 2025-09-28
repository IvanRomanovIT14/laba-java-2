public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
    }

    public void meow(int n) {
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
