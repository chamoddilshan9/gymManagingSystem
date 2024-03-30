public class PremiumMember extends Gymmember{
        private String dietPlan;

    public PremiumMember(String name, int date, char gender, float height, float weight, float fatPercentage, char membership, String dietPlan) {
        super(name, date, gender, height, weight, fatPercentage, membership);
        this.dietPlan = dietPlan;
    }

    public void setDietPlan(String dietPlan) {
        this.dietPlan = dietPlan;
    }

}
