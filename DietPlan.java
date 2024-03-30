public class DietPlan {

    private int noOfMeals = 0;
    //meals array
    Meal[] meals = new Meal[5];

    public DietPlan(Meal[] meals) {
        this.meals = meals;
    }



    @Override
    public String toString() {

        String displayItems = " " ;
        for (int i = 0 ; i <  noOfMeals ;i++){
            displayItems = displayItems+meals[i].toString();
        }

        return displayItems;
    }

    public void setNoOfMeals(int noOfMeals) {
        this.noOfMeals = noOfMeals;
    }

}
