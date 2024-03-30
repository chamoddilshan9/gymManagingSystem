import java.util.Scanner;

public class Main {

    static Scanner myObj = new Scanner(System.in);
    static Gymmember[] gymMembers = new Gymmember[1000000];

    public static void main(String[] args) {
        //default gym member
        gymMembers[0] = new Gymmember("Chamod", 20020311, 'M', 160 , 49, 10, 'p');
        //calling main menu
        mainMenu();
    }



    //main menu method
    static void mainMenu() {
        System.out.println("             XYZ Sports Club");
        System.out.println("        Main Menu:");
        System.out.println("1. Register a new member");
        System.out.println("2. Search for a member");
        System.out.println("3. Edit member details");
        System.out.println("4. Unregister a member");
        System.out.println("5. Add a schedule (gym routine) plan");
        System.out.println("6. Add a diet plan");
        System.out.println("7. Update payments");
        System.out.println("8. BMI Calculator");
        System.out.println("9. Exit");

        //Getting option selection from the user
        System.out.println("Select Option:");
        int optionSelection = myObj.nextInt();
        checkMainMenuInput(optionSelection);
    }

    //main menu input checker method
    static void checkMainMenuInput(int userOption) {
        switch (userOption) {
            case 1:
                //calling new member registering method
                registerMember();
                break;

            case 2:
                //calling new member searching  method
                searchMember();
                mainMenu();
                break;

            case 3:
                //calling member detail editing method
                editMemberDetails();
                mainMenu();
                break;

            case 4:
                //calling member unregistering method
                unregisterMember();
                mainMenu();
                break;

            case 5:
                //calling gym schedule method
                addGymSchedule();
                mainMenu();
                break;
            case 6:
                //calling add diet plan method
                addDietPlan();
                mainMenu();
                break;
            case 7:
                //calling the update payments method
                updatePayments();
                mainMenu();
                break;

            case 8:
                //BMI calculator
                calculateBMI();
                mainMenu();
                break;

            case 9:
                //exit method
                System.out.println("Thank you");
                break;

            default:
                System.out.println("Invalid Input or Data Type. Try Again ");
                mainMenu();
        }
    }

    //gym member registration method
    static void registerMember() {
        String gymMemberName;
        int dateOfBirth;
        char gender = 'n';
        float height = -1;
        float weight = -1;
        float fatPercentage = -1;
        char memberShip = 'n';

        System.out.println("Welcome to XYZ Gym Registration");
        System.out.println("Enter your name:");
        gymMemberName = myObj.nextLine();
        gymMemberName = myObj.nextLine();

        System.out.println("Enter your birthday( Format - 20230311 ) :");
        dateOfBirth = myObj.nextInt();

        //converting birthday to a string
        String birthdayInString = String.valueOf(dateOfBirth);

        if (birthdayInString.length() == 8) {
            System.out.println("Enter your gender ( F,f / M,m ) :");
            gender = myObj.next().charAt(0);

            if (gender == 'f' || gender == 'm' || gender == 'F' || gender == 'M') {
                System.out.println("Enter your height in cm :");
                height = myObj.nextFloat();

                System.out.println("Enter your weight in kg :");
                weight = myObj.nextFloat();

                System.out.println("Enter your fat Percentage:");
                fatPercentage = myObj.nextFloat();

                System.out.println("Preferred Membership  ( Premium (P) or Ordinary (O) :   ");
                memberShip = myObj.next().charAt(0);

                gymMembers[Gymmember.count] = new Gymmember(gymMemberName, dateOfBirth, gender, height, weight, fatPercentage, memberShip);
                System.out.println("Gym Member Details :   " + gymMembers[Gymmember.count - 1].toString());
                System.out.println("Successfully Registered.");
                mainMenu();
            } else {
                System.out.println("Invalid Gender Input");
            }
        } else {
            System.out.println("Invalid Birthday Input");
        }
    }

    // Member Searching method
    public static void searchMember() {
        System.out.println("Search for a member");
        System.out.println("Enter the name or ID of the member:");

        String input;
        input = myObj.nextLine();
        input = myObj.nextLine();

        boolean found = false;
        for (Gymmember member : gymMembers) {
            if (member != null && (!input.isEmpty() && (member.getName().equalsIgnoreCase(input) || String.valueOf(member.getGymMemberID()).equals(input)))) {
                System.out.println("Member found:");
                System.out.println(member);
                System.out.println("Payment Status " + member.getPaymentStatus());
                // schedule details
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Member not found.");
        }
    }

    //edit member detail method
    public static void editMemberDetails() {
        System.out.println("Enter the ID of the member whose details you want to edit:");
        int memberId = myObj.nextInt();

        // Search for the member with the given ID
        Gymmember memberToEdit = null;
        for (Gymmember member : gymMembers) {
            if (member != null && member.getGymMemberID() == memberId) {
                memberToEdit = member;
                break;
            }
        }

        // If member with the given ID is found, proceed to edit details
        if (memberToEdit != null) {
            System.out.println("Member found. Enter the new details:");
            //getting new details from the user
            System.out.println("Enter your new height in cm :");
            float newHeight = myObj.nextFloat();
            memberToEdit.setHeight(newHeight);

            System.out.println("Enter your new weight in kg :");
            float newWeight = myObj.nextFloat();
            memberToEdit.setWeight(newWeight);

            System.out.println("Enter your new fat Percentage:");
            float newFatPercentage = myObj.nextFloat();
            memberToEdit.setFatPercentage(newFatPercentage);

            System.out.println("New Preferred Membership  ( Premium (P) or Ordinary (O) :   ");
            char newMemberShip = myObj.next().charAt(0);
            memberToEdit.setMembership(newMemberShip);

            System.out.println("Member details updated successfully.");
            System.out.println("Updated Member Details:");
            System.out.println(memberToEdit);
        } else {
            System.out.println("Member with the given ID not found.");
        }
    }

    //member unregistering method
    public static void unregisterMember() {
        System.out.println("Enter the ID of the member you want to unregister:");
        int memberId = myObj.nextInt();

        // Search for the member with the given ID
        Gymmember memberToUnregister = null;
        for (int i = 0; i < gymMembers.length; i++) {
            if (gymMembers[i] != null && gymMembers[i].getGymMemberID() == memberId) {
                memberToUnregister = gymMembers[i];
                gymMembers[i] = null; // Marking the member as null to unregister
                break;
            }
        }

        // If member with the given ID is found, display success message
        if (memberToUnregister != null) {
            System.out.println("Member with ID " + memberId + " successfully unregistered.");
        } else {
            System.out.println("Member with the given ID not found.");
        }
    }

    //gym schedule method
    public static void addGymSchedule(){

        // verification
        System.out.println("Add gym schedule ");
        System.out.println("Enter the name or ID of the member.  You can select exercises  up-to 5.");

        String input;
        input = myObj.nextLine();
        input = myObj.nextLine();

        boolean found = false;

        int membersCount = -1;


        for (Gymmember member : gymMembers) {
            if (member != null && (!input.isEmpty() && (member.getName().equalsIgnoreCase(input) || String.valueOf(member.getGymMemberID()).equals(input)))) {
                System.out.println("Member found:");
                membersCount =  member.getGymMemberID()-1;
                found = true;


                //attributes of a exercise

                String exerciseName;
                String intensity;
                int reps;
                int sets;
                int noOfExercises = 0 ;

                Excersice[] excersices = new Excersice[5];
                for (int i = 0 ; i < 5 ; i++ ) {

                    System.out.println("Enter exercise name for exercise No" + (i+1));
                    exerciseName = myObj.nextLine();


                    System.out.println("Enter intensity : ");
                    intensity= myObj.nextLine();


                    System.out.println("Enter number of repetitions : ");
                    reps = myObj.nextInt();

                    System.out.println("Enter number of cycles of reps : ");
                    sets = myObj.nextInt();




                    excersices[i] = new Excersice(exerciseName, intensity ,reps , sets );
                    noOfExercises++;





                    if ( i != 4 ){
                        System.out.println("Do you want to add another exercise ? : ( 1 / 0 ) ");
                        int addExerciseChoice = myObj.nextInt();
                        myObj.nextLine();
                        if (addExerciseChoice == 0 )
                            break;
                        else if (addExerciseChoice == 1) {
                            continue;
                        }else  {
                            throw new ArithmeticException("Invalid Input. ");
                        }
                    }



                    myObj.nextLine();

                }
                if(membersCount >=0){
                    gymSchedule schedule = new gymSchedule(excersices);
                    gymMembers[membersCount].setSchedule(schedule);
                    gymMembers[membersCount].setNoOfExercises(noOfExercises);
                }

                break;
            }
        }

        if (!found) {
            System.out.println("Member not found.");
        }


    }

    //diet plan method
    public static void addDietPlan(){


        // verification
        System.out.println("Add Diet Plan ");
        System.out.println("Enter the name or ID of the member");

        String input;
        input = myObj.nextLine();
        input = myObj.nextLine();

        boolean found = false;

        int membersCount = -1;


        for (Gymmember member : gymMembers) {
            if (member != null && (!input.isEmpty() && (member.getName().equalsIgnoreCase(input) || String.valueOf(member.getGymMemberID()).equals(input)))) {

                membersCount = member.getGymMemberID() - 1;
                found = true;

                char membership = member.getMembership();
                if (membership == 'p' || membership == 'P')
                {
                    System.out.println("Premium ");

                    System.out.println("Meals - Enter Breakfast , Lunch , Dinner , Before Lunch , Evening Snack ");

                    Meal[] meals = new Meal[5];

                    int noOfMeals = 0 ;

                    for (int i = 0 ; i < 5 ; i++ ) {


                        String mealName;
                        String potionSize;
                        String mealTime;


                        System.out.println("Enter Meal Name : ");
                        mealName = myObj.nextLine();

                        System.out.println("Enter Meal Potion Size : ");
                        potionSize = myObj.nextLine();

                        System.out.println("Enter Meal Time : ");
                        mealTime = myObj.nextLine();

                        meals[i] = new Meal(mealName, potionSize ,mealTime);
                        noOfMeals++;



                    }




                    if(membersCount >=0){
                        DietPlan dietPlan = new DietPlan(meals);
                        gymMembers[membersCount].setDietPlan(dietPlan);
                        gymMembers[membersCount].setNoOfMeals(noOfMeals);
                    }

                }
                else {
                    System.out.println("Only premium members can add a diet plan.");
                }


            }
        }




    }





    public static void updatePayments(){

        System.out.println("Update Member Payment");
        System.out.println("Enter the name or ID of the member:");

        String input;
        input = myObj.nextLine();
        input = myObj.nextLine();

        boolean found = false;
        for (Gymmember member : gymMembers) {
            if (member != null && (!input.isEmpty() && (member.getName().equalsIgnoreCase(input) || String.valueOf(member.getGymMemberID()).equals(input)))) {

                System.out.println("Update " + member.getName() + "'s Payment Status (Paid - 1 , Not Paid - 0 ) ");

                System.out.println("Member Found");
                found = true;

                int  paymentStatusInput = myObj.nextInt();
                if ( paymentStatusInput == 1 )
                    member.setPaymentStatus("Paid");
                else if (paymentStatusInput == 0 ) {
                    member.setPaymentStatus("Not Paid");
                }
                System.out.println("Payment Status Updated ");
                break;
            }
        }

        if (!found) {
            System.out.println("Member not found.");
        }


    }




    // BMI calculation method
    public static void calculateBMI() {
        int MenuSelector;
        System.out.println("\tBMI Calculator ");
        System.out.println("1. Check the BMI of existing gym member  ");
        System.out.println("2. Calculate BMI   ");
        System.out.println("Enter your choice :");
        MenuSelector = myObj.nextInt();
        switch (MenuSelector) {
            case 1:
                //calling the method to get the BMI of existing member
                calculateExistingMemberBMI();
                break;
            case 2:
                //calling the guest BMI calculator
                calculateBMIOfGuest();
        }
    }

    //method to calculate BMI of existing member
    public static void calculateExistingMemberBMI() {
        System.out.println("Enter the ID of the member you want to get the BMI:");
        String input;
        input = myObj.nextLine();
        input = myObj.nextLine();
        boolean found = false;
        for (Gymmember member : gymMembers) {
            if (member != null && (!input.isEmpty() && (member.getName().equalsIgnoreCase(input) || String.valueOf(member.getGymMemberID()).equals(input)))) {
                float height = member.getHeight();
                float weight = member.getWeight();
                float heightInMeter = height / 100;
                float BMI = weight / (heightInMeter * heightInMeter);
                System.out.println(member.getName() + "'s BMI Value is " + " " + BMI);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Member not found.");
        }
    }

    //method to calculate the BMI of a guest
    public static void calculateBMIOfGuest() {
        float height;
        float weight;
        float guestBMI;
        System.out.println("Enter height in Meter : ");
        height = myObj.nextFloat();
        System.out.println("Enter weight in Kilo Gram : ");
        weight = myObj.nextFloat();
        guestBMI = weight / (height * height);
        System.out.println("Your BMI value is" + " " + guestBMI);
    }
}
