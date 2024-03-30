public class Excersice {
    private String excersiceName;

    private String intensity;

    private int reps;

    private int sets;

    static int exerciseCount;

    public Excersice(String excersiceName, String intensity, int reps, int sets) {
        this.excersiceName = excersiceName;
        this.intensity = intensity;
        this.reps = reps;
        this.sets = sets;
        exerciseCount++;
    }


    @Override
    public String toString() {
        return
                "\nExercise Name=  " + excersiceName +
                "\nintensity=      " + intensity +
                "\nreps=           " + reps +
                "\nsets=           " + sets + " \n";
    }
}
