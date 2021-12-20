package workout;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static AllWorkouts aid = new AllWorkouts();

    static ArrayList<String> workoutLeg = aid.addLeg();
    static ArrayList<String> workoutArmsShoulders = aid.addShoulderArm();
    static ArrayList<String> workoutsAbs = aid.addAbs();

    public static void main(String[] args) {

        workoutPlan(workoutLeg, 5);
        workoutPlan(workoutArmsShoulders, 3);
        workoutPlan(workoutsAbs, 3);
    }

    public static void workoutPlan(ArrayList<String> temp, int howMany) {
        Scanner in = new Scanner(System.in);
        String answer = "";
        Random r = new Random();
        howMany = temp.size()-howMany;

        System.out.println("Starting workout.");
        while (temp.size()>howMany) {
            int random = r.nextInt(temp.size());
            System.out.println("It's time to do "+temp.get(random)+"!");

            while (!answer.equalsIgnoreCase("yes")) {
                System.out.println("Type 'yes' to proceed.");
                answer = in.nextLine();
            }
            temp.remove(random);
            answer = "no";
        }
        System.out.println("Good job. Workout finished.");
        System.out.println();
    }
}
