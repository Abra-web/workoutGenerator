package workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Date;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static ArrayList<WorkoutInfo> workoutList = AllWorkouts.add();

    public static int dayNum = 0;

    public static void main(String[] args) {
        workoutList = AllWorkouts.add();
        ArrayList<WorkoutInfo> newList  = workoutPlan(workoutList);
        print(newList);
    }

    public static ArrayList<WorkoutInfo> workoutPlan(ArrayList<WorkoutInfo> allWorkouts) {
        Random rnd = new Random();
        Date d = new Date();
        dayNum = d.getDay();
        int random = 0;

        ArrayList<WorkoutInfo> answer = new ArrayList<>();
        ArrayList<WorkoutInfo> arm = new ArrayList<>();
        ArrayList<WorkoutInfo> chest = new ArrayList<>();
        ArrayList<WorkoutInfo> back = new ArrayList<>();
        ArrayList<WorkoutInfo> abs = new ArrayList<>();
        ArrayList<String> order = new ArrayList<>();

        order.add("arm");
        order.add("arm");
        order.add("chest");
        order.add("back");

        boolean result = true;
        while(result) {
            Collections.shuffle(order);
            if (dayNum == 1) {// Monday - so Deadlift
                if (order.get(0) != "back" && order.get(1) != "back") {
                    if (!(order.get(0) == order.get(1) || order.get(1) == order.get(2) || order.get(2) == order.get(3))) {
                        result = false;
                    }
                }
            } else if (dayNum == 3) { // Wednesday - Bench Press
                if (order.get(0) != "chest" && order.get(1) != "chest") {
                    if (!(order.get(0) == order.get(1) || order.get(1) == order.get(2) || order.get(2) == order.get(3))) {
                        result = false;
                    }
                }
            } else { // Any other day (including Friday because squats doesn't affect)
                    if (!(order.get(0) == order.get(1) || order.get(1) == order.get(2) || order.get(2) == order.get(3))) {
                        result = false;
                }
            }
        }

        System.out.println(order);
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

        for (int i=0; i < 4; i++) {
            if (order.get(i) == "arm") {
                for (int j=0; j < 2; j++) {
                    random = rnd.nextInt(arm.size());
                    answer.add(arm.get(random));
                    arm.remove(random);
                }
            }
            if (order.get(i) == "chest") {
                for (int j=0; j < 2; j++) {
                    random = rnd.nextInt(chest.size());
                    answer.add(chest.get(random));
                    chest.remove(random);
                }
            }
            if (order.get(i) == "back") {
                for (int j=0; j < 2; j++) {
                    random = rnd.nextInt(back.size());
                    answer.add(back.get(random));
                    back.remove(random);
                }
            }
        }

        for (int i=0; i < 2; i++) {
            random = rnd.nextInt(abs.size());
            answer.add(abs.get(random));
            abs.remove(random);
        }

        return answer;
    }

    public static void print(ArrayList<WorkoutInfo> theList) {
        String currentANSI = null;
        System.out.println(ANSI_GREEN + "                              New workout Generated" + ANSI_RESET );
        for (int i=0; i < theList.size(); i++) {
            if (i%2 == 0 && i != 10) {
                System.out.println(ANSI_GREEN  + "------------------------------------------------------------------------------------" + ANSI_GREEN);
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
                System.out.println(currentANSI   + theList.get(i).getArea() + ANSI_RESET);
                System.out.println(currentANSI  + " | " + theList.get(i).getName() + " | " + ANSI_RESET);
            } else if (i == 11) {
                System.out.println("------------------------------------------------------------------------------------");
            } else {
                System.out.println(currentANSI +" | " + theList.get(i).getName() + " | " + ANSI_RESET);
                if (i == 3) {
                    System.out.println(ANSI_GREEN  + "------------------------------------------------------------------------------------" + ANSI_RESET);
                    System.out.println("Bonus :)");
                    if (dayNum == 1) {
                        System.out.println(" | Deadlift: 4 x 8-5 | ");
                    } else if (dayNum == 3) {
                        System.out.println(" | Bench Press: 4 x 10-8 | ");
                    } else if (dayNum == 5) {
                        System.out.println(" | Squat: 4 x 10-8 | ");
                    }
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
