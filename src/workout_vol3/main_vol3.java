package workout_vol3;

import workout_vol3.all_workouts_vol3;
import workout_vol3.workout_info_vol3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class main_vol3 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static ArrayList<workout_info_vol3> workoutList;

    public static int dayNum = 0;

    public static void main(String[] args) {
        workoutList = all_workouts_vol3.add();
        ArrayList<workout_info_vol3> newList  = workoutPlan(workoutList);
        print(newList);
    }

    public static ArrayList<workout_info_vol3> workoutPlan(ArrayList<workout_info_vol3> allWorkouts) {
        Random rnd = new Random();
        Date d = new Date();
        dayNum = d.getDay(); // 1:monday, 3:wednesday, 5:friday
        int random = 0;

        ArrayList<workout_info_vol3> answer = new ArrayList<>();
        ArrayList<workout_info_vol3> arm = new ArrayList<>();
        ArrayList<workout_info_vol3> chest = new ArrayList<>();
        ArrayList<workout_info_vol3> back = new ArrayList<>();
        ArrayList<workout_info_vol3> abs = new ArrayList<>();
        ArrayList<String> order = new ArrayList<>();

        order.add("arm");
        order.add("chest");
        order.add("back");

        Collections.shuffle(order);

        System.out.println(order);
        // adding exercises related to their target areas to the new arraylist
        for (int i=0; i < allWorkouts.size(); i++) {
            if (allWorkouts.get(i).area == "arm") {
                arm.add(allWorkouts.get(i));
            }
            else if (allWorkouts.get(i).area == "chest") {
                chest.add(allWorkouts.get(i));
            }
            else if (allWorkouts.get(i).area == "back") {
                back.add(allWorkouts.get(i));
            }
            else if (allWorkouts.get(i).area == "abs") {
                abs.add(allWorkouts.get(i));
            }
        }


        /*
        ADDING EXERCISES
         */

        ArrayList<String> progressionList = all_workouts_vol3.getAllProgressionMoves();
        progressionList.remove("Front Lever");
        String tempString;

        // FIRST, ADDING FIXED EXERCISE (CURRENT GOAL) -> FRONT LEVER
        answer.add(all_workouts_vol3.getProgressionOfMove("Front Lever"));
        answer.add(all_workouts_vol3.anyMove("Front Lever -> With Bands"));

        // SECOND, ADDING EXERCISES THAT SUPPORTS THE GOAL
        ArrayList<String> exerciseList = all_workouts_vol3.getExercisesOfMove("Front Lever");
        for (int i=0; i < 3; i++) { // adding 3 exercises
            int currentIndex = rnd.nextInt(exerciseList.size());
            String currentExercise = exerciseList.get(currentIndex);
            answer.add(all_workouts_vol3.anyMove(currentExercise));
            exerciseList.remove(currentExercise);
        }

        // THIRD, ADDING 1 OTHER GOAL
        for (int i=0; i < 1; i++) { // adding 1 another goal
            tempString = progressionList.get(rnd.nextInt(progressionList.size()));
            answer.add(all_workouts_vol3.getProgressionOfMove(tempString));
            progressionList.remove(tempString);
        }

        // FOURTH, ADDING 2+1 WEIGHT EXERCISES
        /*
        Currently:
            Monday:
                - Deadlift
                - Lateral Raise
                - Full Amplitude Rises
            Wednesday:
                - Bench Press
                - db Shrugs
                - Bicep Curl
            Friday:
                - Squat
                - Incline db bp
                - Inclıne db fly
         */

        // FIFTH, ADDING 2 BODY-WEIGHT EXERCISES (1 CHEST, 1 ARM)
        int exerciseIndex;
        for (String s : order) { // skipping back
            if (s == "arm") {
                exerciseIndex = rnd.nextInt(arm.size());
                answer.add(arm.get(exerciseIndex));
                arm.remove(exerciseIndex);
            }
            if (s == "chest") {
                exerciseIndex = rnd.nextInt(chest.size());
                answer.add(chest.get(exerciseIndex));
                chest.remove(exerciseIndex);
            }
        }

        // SIXTH, ADDING 1 ABS EXERCISE
        for (int i=0; i < 1; i++) {
            random = rnd.nextInt(abs.size());
            answer.add(abs.get(random));
            abs.remove(random);
        }

        return answer;
    }

    public static void print(ArrayList<workout_info_vol3> theList) {
        String currentANSI = null;
        boolean printTitle = true;

        System.out.println(ANSI_GREEN + "                              New workout Generated");
        for (int i=0; i < theList.size(); i++) {
            if (i < 5) { // 0 -> 5
                if (i == 0) {
                    currentANSI = ANSI_BLUE;
                    System.out.println(currentANSI + "Progression + Exercises");
                    System.out.println(" | " + theList.get(i).getName() + " -> " + theList.get(i).getColour() + " | ");
                } else {
                    System.out.println(currentANSI + " | " + theList.get(i).getName() + " | ");
                }
            } else if (i == 5) {
                System.out.println(ANSI_GREEN  + "------------------------------------------------------------------------------------");
                System.out.println(ANSI_RESET + "Weights");

                if (dayNum == 1) {
                    System.out.println(" | Deadlift: 4 x 8-5 | ");
                    System.out.println(" | Lateral Raise: 16 - 12 - 8 - 12 - 16 | ");
                    System.out.println(" | Full Amplitude Rises: 3 x 12-8 | "); // put your chest on the box, and then raise your arms through back
                } else if (dayNum == 3) {
                    System.out.println(" | Bench Press: 4 x 10-8 | ");
                    System.out.println(" | db Shrugs: 16 - 12 - 8 - 12 - 16 | ");
                    System.out.println(" | Bicep Curl: 4 x 10-8 | ");
                } else if (dayNum == 5) {
                    System.out.println(" | Squat: 4 x 10-8 | ");
                    System.out.println(" | Incline db bp: 4 x 12-8 | ");
                    System.out.println(" | Incline db fly: 4 x 12-8 | ");
                }
            } else {
                System.out.println(ANSI_GREEN + "------------------------------------------------------------------------------------");

                String tempArea = theList.get(i).area;

                if (tempArea.equals("arm")) {
                    currentANSI = ANSI_RED;
                } else if (tempArea.equals("chest")) {
                    currentANSI = ANSI_CYAN;
                } else if (tempArea.equals("back")) {
                    currentANSI = ANSI_PURPLE;
                } else if (tempArea.equals("abs")) {
                    currentANSI = ANSI_GREEN;
                }
                System.out.println(currentANSI + theList.get(i).getArea());
                System.out.println(" | " + theList.get(i).getName() + " | " + ANSI_RESET);
                }
            }
        }

    public int level (String colour) {
        if (colour == "Black Opal Tier") return 3;
        if (colour == "Red Ruby Tier") return 2;
        if (colour == "Blue Diamond Tier") return 1;
        else return 0;
    }
}
