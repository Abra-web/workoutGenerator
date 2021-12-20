package workout;

import java.util.ArrayList;

public class AllWorkouts {
        public static ArrayList<String> addLeg() {

            ArrayList<String> workout = new ArrayList<String>();
            // enter leg workouts here
            workout.add("Bulgarian split legs x10");
            workout.add("Lunges x10");
            workout.add("Jump squats x10");
            workout.add("Jumping kicks x25");
            workout.add("Side to side squats x10");
            workout.add("Single-leg dead lifts with jump x5");
            workout.add("full burpees x5");
            workout.add("tuck jumps x5");
            workout.add("explosive switching lunges x10");
            workout.add("calf raise x10");
            return workout;
        }
        public static ArrayList<String> addShoulderArm() {
            // enter shoulder or arm workouts here
            ArrayList<String> workout = new ArrayList<String>();
            workout.add("pike pushup x5");
            workout.add("pushup x5");
            workout.add("diamond pushup x5");
            workout.add("tricep extension x5");

            return workout;
        }
        public static ArrayList<String> addAbs() {

            ArrayList<String> workout = new ArrayList<String>();
            workout.add("laying leg flutters x10");
            workout.add("seated in-out x10");
            workout.add("russian twist x10");
            return workout;
        }
}
