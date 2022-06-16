package workout;

import java.util.ArrayList;

public class AllWorkouts {
// tiers go from hardest to easiest with Black Opal Tier, Red Ruby Tier, Blue Diamond Tier
// bar types: low bar, middle bar, high bar, parallel bar, null

    public static ArrayList<WorkoutInfo> add() { //name, area, specificArea, colour, timeAdded
        ArrayList<WorkoutInfo> workout = new ArrayList<>();

        // --- arm workouts ---
        // - triceps
        workout.add(new WorkoutInfo("push up", "arm", "triceps", "Blue Diamond Tier", "12/25/2021" ,null));
        workout.add(new WorkoutInfo("diamond push up", "arm", "triceps","Red Ruby Tier", "12/25/2021", null));
        workout.add(new WorkoutInfo("tricep extension", "arm", "triceps","Blue Diamond Tier", "12/25/2021", null));
        workout.add(new WorkoutInfo("pseudo-planche push-up", "arm", "triceps","Red Ruby Tier", "12/25/2021", null));

        // - biceps
        workout.add(new WorkoutInfo("chin-up", "arm", "biceps", "Blue Diamond Tier","12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("reverse australian chin-up", "arm", "biceps", "Blue Diamond Tier" ,"12/25/2021", "middle bar"));
        workout.add(new WorkoutInfo("bench dip", "arm", "biceps", "Blue Diamond Tier" ,"12/25/2021", "middle bar"));
        workout.add(new WorkoutInfo("neutral grip pull-up", "arm", "biceps", "Blue Diamond Tier" ,"12/25/2021", "middle bar"));

        // - deltoids (shoulder)
        workout.add(new WorkoutInfo("declined pike push-up (knees)", "arm", "deltoids","Red Ruby Tier", "12/25/2021", null));


        // --- chest workouts ---
        // - pectoral muscle (whole chest)
        workout.add(new WorkoutInfo("muscle up dip", "chest", "pectoral","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("parallel bar dip", "chest", "pectoral","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("archer push-up", "chest", "pectoral","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("elevated push-up", "chest", "pectoral","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("type-writer push-up", "chest", "pectoral","Blue Diamond Tier", "12/25/2021", "high bar"));


        // --- back workouts ---
        // - traps
        workout.add(new WorkoutInfo("wide australian rows", "back", "traps","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("tucked front lever", "back", "traps","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("commando pull-up", "back", "traps","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("pull to belly", "back", "traps","Blue Diamond Tier", "12/25/2021", "high bar"));

        // - lats

        // - rhomboids


        // --- abs workouts ---
        // - abs
        workout.add(new WorkoutInfo("L-hang", "abs", "abs","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("hanging leg raise", "abs", "abs","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("L-sit", "abs", "abs","Blue Diamond Tier", "12/25/2021", "low bar"));
        workout.add(new WorkoutInfo("plank", "abs", "abs","Blue Diamond Tier", "12/25/2021", null));

        // - obliques
        workout.add(new WorkoutInfo("plank side-to-side", "abs", "obliques","Blue Diamond Tier", "12/25/2021", null));
        workout.add(new WorkoutInfo("corner raises", "abs", "obliques","Blue Diamond Tier", "12/25/2021", "high bar"));
        workout.add(new WorkoutInfo("side plank raise", "abs", "obliques","Blue Diamond Tier", "02/15/2022", null));

        return workout;
    }

    public static ArrayList<WorkoutInfo> progressionOfMove(String move) {
        ArrayList<WorkoutInfo> workout = new ArrayList<>();

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
