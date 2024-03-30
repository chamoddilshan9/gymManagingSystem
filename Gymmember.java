public class Gymmember extends Person{
    private float height ;
    private float weight ;
    private  float fatPercentage ;
    private int gymMemberID;

    private char membership;
    static int count = 0 ;

    private gymSchedule schedule;

    private DietPlan dietPlan;

    private String paymentStatus;

    // Gym member constructor

    public Gymmember(String name, int date, char gender, float height, float weight, float fatPercentage, char membership) {
        super(name , date , gender);
        this.height = height;
        this.weight = weight;
        this.fatPercentage = fatPercentage;
        this.membership = membership;

        count++;
        gymMemberID = count;

    }

    public int getGymMemberID() {
        return gymMemberID;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setFatPercentage(float fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public void setMembership(char membership) {
        this.membership = membership;
    }

    public void setSchedule(gymSchedule schedule) {
        this.schedule = schedule;
    }

    public void setDietPlan(DietPlan dietPlan) {
        this.dietPlan = dietPlan;
    }

    public gymSchedule getSchedule() {
        return schedule;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public char getMembership() {
        return membership;
    }

    @Override
    public String toString() {
        return
                        "Gym Member ID   = " + gymMemberID + " " +
                         super.toString() +
                                "  \nHeight          =" + height +
                                "  \nWeight          =" + weight +
                                "  \nFat Percentage  =" + fatPercentage +
                                "  \nMembership      =" + membership + " \n" +
                                "  \nGym schedule    =" + schedule + " \n" +
                                "  \nDiet Plan       =" + dietPlan
                ;
    }

    public void setNoOfExercises(int count){
        schedule.setNoOfExercises(count);
    }

    public void setNoOfMeals(int count){
        dietPlan.setNoOfMeals(count);
    }

}


