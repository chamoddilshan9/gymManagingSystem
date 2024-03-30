public abstract class Person {
    private String name ;
    private int date ;
    private char gender ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(int date) {
        this.date = date;
    }



    @Override
    public String toString() {
        return
                        "  \nName            = " + name  +
                        ", \nDate of Birth   = " + date +
                        ", \nGender          = " + gender
                ;
    }

    //Constructor



    public Person(String name, int date, char gender) {
        this.name = name;
        this.date = date;
        this.gender = gender;
    }
}


