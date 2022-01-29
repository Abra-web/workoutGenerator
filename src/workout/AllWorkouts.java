package workout;

import java.util.ArrayList;

public class AllWorkouts {
// tiers go from hardest to easiest with Black Opal Tier, Red Ruby Tier, Blue Diamond Tier
// bar types: low bar, middle bar, high bar, parallel bar, null

    public static ArrayList<WorkoutInfo> add() { //name, area, specificArea, colour, timeAdded
        ArrayList<WorkoutInfo> workout = new ArrayList<WorkoutInfo>();

        // --- arm workouts ---
        // - triceps
        workout.add(new WorkoutInfo("push up", "arm", "triceps", "Blue Diamond Tier", "12/25/2021" ,null));
        workout.add(new WorkoutInfo("diamond push up", "arm", "triceps","Blue Diamond Tier", "12/25/2021", null));
        workout.add(new WorkoutInfo("tricep extension", "arm", "triceps","Blue Diamond Tier", "12/25/2021", null));

        // - biceps
        workout.add(new WorkoutInfo("pull-up", "arm", "biceps", "floor" ,"Blue Diamond Tier", "12/25/2021"));
        workout.add(new WorkoutInfo("reverse australian chin-up", "arm", "biceps", "floor" ,"Blue Diamond Tier", "12/25/2021"));
        workout.add(new WorkoutInfo("bench dip", "arm", "triceps", "floor" ,"Blue Diamond Tier", "12/25/2021"));

        // - deltoids (shoulder)
        workout.add(new WorkoutInfo("tucked front lever", "arm", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("pike push-up", "arm", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));


        // --- chest workouts ---
        // - pectoral muscle (whole chest)
        workout.add(new WorkoutInfo("muscle up dip", "chest", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("parallel bar dip", "chest", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("archer push-up", "chest", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("elevated push-up", "chest", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));


        // --- back workouts ---
        // - traps
        workout.add(new WorkoutInfo("wide australian rows", "back", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("tucked front lever", "back", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("commando pull-up", "back", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));

        // - lats

        // - rhomboids


        // --- abs workouts ---
        // - abs
        workout.add(new WorkoutInfo("L-hang", "abs", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("hanging leg raise", "abs", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("L-sit", "abs", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("plank", "abs", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));

        // - obliques
        workout.add(new WorkoutInfo("plank side-to-side", "abs", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("commando pull-up", "abs", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("corner raises", "abs", "deltoids","Blue Diamond Tier", "12/25/2021", "high bar"));

        return workout;
    }

    public static ArrayList<WorkoutInfo> progressionOfMove(String move) {
        ArrayList<WorkoutInfo> workout = new ArrayList<WorkoutInfo>();

        if (move.equals("handstand push-up")) {
            workout.add(new WorkoutInfo("handstand", null, null,null, null, "high bar"));
            workout.add(new WorkoutInfo("handstand push-up", null, null,null, null, "high bar"));
            return workout;
        }
        else if (move.equals("front lever")) {
            workout.add(new WorkoutInfo("tucked front lever", null, null,null, null, "high bar"));
            workout.add(new WorkoutInfo("advanced front lever", null, null,null, null, "high bar"));
            workout.add(new WorkoutInfo("straddle front lever", null, null,null, null, "high bar"));
            workout.add(new WorkoutInfo("half-lay front lever", null, null,null, null, "high bar"));
            workout.add(new WorkoutInfo("front lever", null, null,null, null, "high bar"));
        }
        return null;
    }
//        public static ArrayList<String> addAbs() {
//
//            ArrayList<String> workout = new ArrayList<String>();
//            workout.add("laying leg flutters x10");
//            workout.add("seated in-out x10");
//            workout.add("russian twist x10");
//            return workout;
//        }
//        public static ArrayList<String> addLeg() { // not going to be used now
//
//            ArrayList<String> workout = new ArrayList<String>();
//            // enter leg workouts here
//            workout.add("Bulgarian split legs x10");
//            workout.add("Lunges x10");
//            workout.add("Jump squats x10");
//            workout.add("Jumping kicks x25");
//            workout.add("Side to side squats x10");
//            workout.add("Single-leg dead lifts with jump x5");
//            workout.add("full burpees x5");
//            workout.add("tuck jumps x5");
//            workout.add("explosive switching lunges x10");
//            workout.add("calf raise x10");
//            return workout;
//        }

}
