package workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    static ArrayList<WorkoutInfo> workoutList = AllWorkouts.add();

    public static void main(String[] args) {
        workoutList = AllWorkouts.add();
        ArrayList<WorkoutInfo> newList  = workoutPlan(workoutList);
        print(newList);
    }

    public static ArrayList<WorkoutInfo> workoutPlan(ArrayList<WorkoutInfo> allWorkouts) {
        Random rnd = new Random();
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
        Collections.shuffle(order);

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

        for (int i=0; i < 3; i++) {
            random = rnd.nextInt(abs.size());
            answer.add(abs.get(random));
        }

        return answer;
    }

    public static void print(ArrayList<WorkoutInfo> theList) {
        for (int i=0; i < theList.size(); i++) {
            System.out.println(theList.get(i).toString());
        }
    }

    public int level (String colour) {
        if (colour == "Black Opal Tier") return 3;
        if (colour == "Red Ruby Tier") return 2;
        if (colour == "Blue Diamond Tier") return 1;
        else return 0;
    }
}
