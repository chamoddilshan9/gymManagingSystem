import java.util.Arrays;

public class gymSchedule {


    private int noOfExercises = 0;

    Excersice[] excersices = new Excersice[5];

    public gymSchedule(Excersice[] excersices) {

        this.excersices = excersices;
    }




    @Override
    public String toString() {

        String variable = " " ;
        for (int i = 0 ; i <  noOfExercises ;i++){
            variable = variable+excersices[i].toString();
        }

        return variable;
    }



    public void setNoOfExercises(int noOfExercises) {
        this.noOfExercises = noOfExercises;
    }
}
