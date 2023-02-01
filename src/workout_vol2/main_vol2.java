package workout_vol2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class main_vol2 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static ArrayList<workout_info_vol2> workoutList;

    public static int dayNum = 0;

    public static void main(String[] args) {
        workoutList = all_workouts_vol2.add();
        ArrayList<workout_info_vol2> newList  = workoutPlan(workoutList);
        print(newList);
    }

    public static ArrayList<workout_info_vol2> workoutPlan(ArrayList<workout_info_vol2> allWorkouts) {
        Random rnd = new Random();
        Date d = new Date();
        dayNum = d.getDay(); // 1:monday, 3:wednesday, 5:friday
        int random = 0;

        ArrayList<workout_info_vol2> answer = new ArrayList<>();
        ArrayList<workout_info_vol2> arm = new ArrayList<>();
        ArrayList<workout_info_vol2> chest = new ArrayList<>();
        ArrayList<workout_info_vol2> back = new ArrayList<>();
        ArrayList<workout_info_vol2> abs = new ArrayList<>();
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

        // First adding 4 progression exercises
        ArrayList<String> progressionList = all_workouts_vol2.getAllProgressionMoves();
        String tempString;
        for (int i=0; i < 4; i++) { // adding 4 progression exercises randomly
            tempString = progressionList.get(rnd.nextInt(progressionList.size()));
            answer.add(all_workouts_vol2.getProgressionOfMove(tempString));
            progressionList.remove(tempString);
        }


        // adding 2 or 1 exercise for each target area (2 + 2 + 1 = 5)
        int total = 0;
        int exerciseIndex;
        for (int i=0; i < 3; i++) {
            random = rnd.nextInt(2) + 1;
            if (total == 4) { // handling 2 + 2 + 2 -> 2 + 2 + 1
                random = 1;
            } else if (i == 1 && total == 1 && random == 1) { // 1 + 1 + ... -> 1 + 2 + ...
                random = 2;
            } else if (total == 3 && i == 2) { // 1 + 2 + 1 -> 1 + 2 + 2
                random = 2;
            }

            if (order.get(i) == "arm") {
                for (int j=0; j < random; j++) {
                    exerciseIndex = rnd.nextInt(arm.size());
                    answer.add(arm.get(exerciseIndex));
                    arm.remove(exerciseIndex);
                }
            }
            if (order.get(i) == "chest") {
                for (int j=0; j < random; j++) {
                    exerciseIndex = rnd.nextInt(chest.size());
                    answer.add(chest.get(exerciseIndex));
                    chest.remove(exerciseIndex);
                }
            }
            if (order.get(i) == "back") {
                for (int j=0; j < random; j++) {
                    exerciseIndex = rnd.nextInt(back.size());
                    answer.add(back.get(exerciseIndex));
                    back.remove(exerciseIndex);
                }
            }
            total += random;
        }

        for (int i=0; i < 1; i++) { // adding abs in the end
            random = rnd.nextInt(abs.size());
            answer.add(abs.get(random));
            abs.remove(random);
        }

        return answer;
    }

    public static void print(ArrayList<workout_info_vol2> theList) {
        String currentANSI = null;
        boolean printTitle = true;

        System.out.println(ANSI_GREEN + "                              New workout Generated" + ANSI_RESET );
        for (int i=0; i < theList.size(); i++) {
            if (theList.get(i).getArea() == "Progression") {
                currentANSI = ANSI_BLUE;

                if (printTitle) {
                    System.out.println(currentANSI + "Progression" + ANSI_RESET);
                    System.out.println(currentANSI +" | " + theList.get(i).getName() + " -> " + theList.get(i).getColour() + " | " + ANSI_RESET);
                    printTitle = false;
                } else {
                    System.out.println(currentANSI +" | " + theList.get(i).getName() + " -> " + theList.get(i).getColour() + " | " + ANSI_RESET);

                    if (i == 3) {
                        printTitle = true;
                    }
                }
            } else if (i==4) {
                System.out.println(ANSI_GREEN  + "------------------------------------------------------------------------------------" + ANSI_RESET);
                System.out.println("Bonus :)");
                if (dayNum == 1) {
                    System.out.println(" | Deadlift: 4 x 8-5 | ");
                    System.out.println(" | Lateral Raise: 16 - 12 - 8 - 12 - 16 | ");
                } else if (dayNum == 3) {
                    System.out.println(" | Bench Press: 4 x 10-8 | ");
                    System.out.println(" | db Shrugs: 16 - 12 - 8 - 12 - 16 | ");
                } else if (dayNum == 5) {
                    System.out.println(" | Squat: 4 x 10-8 | ");
                    System.out.println(" | Incline db bp: 4 x 12-8 | ");
                }
            }

            // --------------
            if (i >= 4) {
                if (printTitle) {
                    System.out.println(ANSI_GREEN + "------------------------------------------------------------------------------------" + ANSI_GREEN);
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
                    System.out.println(currentANSI + theList.get(i).getArea() + ANSI_RESET);
                    System.out.println(currentANSI + " | " + theList.get(i).getName() + " | " + ANSI_RESET);

                    if (i != theList.size()-1) { // to avoid giving error in the last loop
                        if (theList.get(i+1).getArea() == tempArea) {
                            printTitle = false;
                        }
                    }

                } else {
                    System.out.println(currentANSI + " | " + theList.get(i).getName() + " | " + ANSI_RESET);
                    printTitle = true;
                }
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
