public class Meal {
    private String mealName;

    private String portionSize;

    private String mealTime;

    public Meal(String mealName, String portionSize, String mealTime) {
        this.mealName = mealName;
        this.portionSize = portionSize;
        this.mealTime = mealTime;
    }

    @Override
    public String toString() {
        return
                "\nmealName=    " + mealName +
                "\nportionSize= " + portionSize +
                "\nmealTime=    " + mealTime + " \n"
                ;
    }

    public void setSchedule(DietPlan meal) {
    }

    public void setMeal(DietPlan meal) {
    }
}
