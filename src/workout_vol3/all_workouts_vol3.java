package workout_vol3;

import java.util.ArrayList;
import java.util.Random;

public class all_workouts_vol3 {
// tiers go from hardest to easiest with Black Opal Tier, Red Ruby Tier, Blue Diamond Tier
// bar types: low bar, middle bar, high bar, parallel bar, null
// Monday - deadlift: 4x8-5, Wednesday - bench press: 4x10-6, Friday - squat: 4x10-6
/**
 * name:
 * area:
 * specificArea:
 * colour:
 * barType: bar needed for the move. Options: "lowBar", "middleBar", ...
 */
    public static ArrayList<workout_info_vol3> add() { //name, area, specificArea, colour, timeAdded
        ArrayList<workout_info_vol3> workout = new ArrayList<>();

        // --- arm workouts ---
        // - triceps
        workout.add(new workout_info_vol3("tricep extension", "arm", "triceps","Blue Diamond Tier",  null));

        // - biceps
        workout.add(new workout_info_vol3("chin-up", "arm", "biceps", "Blue Diamond Tier", "high bar"));
        workout.add(new workout_info_vol3("reverse australian chin-up", "arm", "biceps", "Blue Diamond Tier" , "middle bar"));
        // - deltoids (shoulder)

        // --- chest workouts ---
        // - pectoral muscle (whole chest)
        workout.add(new workout_info_vol3("muscle up dip", "chest", "pectoral","Blue Diamond Tier", "high bar"));
        workout.add(new workout_info_vol3("parallel bar dip + 10kg", "chest", "pectoral","Blue Diamond Tier", "high bar"));
        workout.add(new workout_info_vol3("archer push-up", "chest", "pectoral","Blue Diamond Tier", "high bar"));

        // --- back workouts ---
        // - traps

        // - lats
        // - rhomboids


        // --- abs workouts ---
        // - abs
        workout.add(new workout_info_vol3("L-hang", "abs", "abs","Blue Diamond Tier", "high bar"));
        workout.add(new workout_info_vol3("hanging leg raise", "abs", "abs","Blue Diamond Tier", "high bar"));
        workout.add(new workout_info_vol3("L-sit", "abs", "abs","Blue Diamond Tier", "low bar"));
        workout.add(new workout_info_vol3("plank", "abs", "abs","Blue Diamond Tier", null));

        // - obliques
        workout.add(new workout_info_vol3("corner raises", "abs", "obliques","Blue Diamond Tier", "high bar"));
        workout.add(new workout_info_vol3("side plank raise", "abs", "obliques","Blue Diamond Tier", null));

        return workout;
    }

    public static ArrayList<String> getAllProgressionMoves() {
        ArrayList<String> listOfNames = new ArrayList<>();
        listOfNames.add("Handstand Push-up");
        listOfNames.add("Front Lever");
        listOfNames.add("Planche");
        listOfNames.add("Muscle-Up");
        listOfNames.add("90-degree Hold");

        return listOfNames;
    }

    public static workout_info_vol3 getProgressionOfMove(String move) {
        Random rnd = new Random();
        int randomNumber;
        ArrayList<workout_info_vol3> chosenMoves = new ArrayList<>();

        int CURRENTLEVEL = 0;

        if (move.equals("Handstand Push-up")) {
            // progression: Pike push up -> Decline pike push up -> Wall assisted HeSPU -> Handstand press -> L-sit to Handstand -> Negative Handstand -> HeSPU
            CURRENTLEVEL = 1;
            chosenMoves.add(new workout_info_vol3("Pike push-up", "Progression", null,"level 1", null));
            chosenMoves.add(new workout_info_vol3("Decline Pike Push-up", "Progression", null,"level 2", null));
            chosenMoves.add(new workout_info_vol3("Wall Assisted HeSPU", "Progression", null,"level 3", null));
            chosenMoves.add(new workout_info_vol3("Handstand Press", "Progression", null,"level 4", null));
            chosenMoves.add(new workout_info_vol3("L-sit to Handstand", "Progression", null,"level 5", null));
            chosenMoves.add(new workout_info_vol3("Negative Handstand", "Progression", null,"level 6", null));
            chosenMoves.add(new workout_info_vol3("HeSPU", "Progression", null,"level 7", null));

            return chosenMoves.get(CURRENTLEVEL);
        } else if (move.equals("Front Lever")) {
            // progression: Toes to bar -> Tuck front lever hold -> Advanced Tuck -> Upside down deadlift -> Front lever drops -> Front lever raises
            CURRENTLEVEL = 1;
            chosenMoves.add(new workout_info_vol3("tucked front lever", "Progression", null,"level 1", "high bar"));
            chosenMoves.add(new workout_info_vol3("advanced front lever", "Progression", null,"level 2", "high bar"));
            chosenMoves.add(new workout_info_vol3("straddle front lever", "Progression", null,"level 3", "high bar"));
            chosenMoves.add(new workout_info_vol3("half-lay front lever", "Progression", null,"level 4", "high bar"));
            chosenMoves.add(new workout_info_vol3("front lever", "Progression", null,"level 5", "high bar"));

            return chosenMoves.get(CURRENTLEVEL);
        } else if (move.equals("Planche")) {
            // progression: tucked planche -> advanced tucked planche -> frog planche -> piked straddle planche -> straddle planche -> one-leg planche -> Half-lay planche -> full planche
            CURRENTLEVEL = 0;
            chosenMoves.add(new workout_info_vol3("tucked planche", "Progression", null,"level 1", "high bar"));
            chosenMoves.add(new workout_info_vol3("advanced tucked planche", "Progression", null,"level 2", "high bar"));
            chosenMoves.add(new workout_info_vol3("frog planche", "Progression", null,"level 3", "high bar")); // similar to advanced tuck planche but legs apart
            chosenMoves.add(new workout_info_vol3("piked straddle planche", "Progression", null,"level 4", "high bar"));
            chosenMoves.add(new workout_info_vol3("straddle planche", "Progression", null,"level 5", "high bar"));
            chosenMoves.add(new workout_info_vol3("one-leg planche", "Progression", null,"level 6", "high bar"));
            chosenMoves.add(new workout_info_vol3("Half-lay planche", "Progression", null,"level 7", "high bar"));
            chosenMoves.add(new workout_info_vol3("full planche", "Progression", null,"level 8", "high bar"));

            return chosenMoves.get(CURRENTLEVEL);
        } else if (move.equals("Muscle-Up")) {
            CURRENTLEVEL = 1;
            chosenMoves.add(new workout_info_vol3("Muscle-up Thick Band", "Progression", null,"level 1", "high bar"));
            chosenMoves.add(new workout_info_vol3("Muscle-up Medium Band", "Progression", null,"level 2", "high bar"));
            chosenMoves.add(new workout_info_vol3("Muscle-up Thin Band", "Progression", null,"level 3", "high bar"));
            chosenMoves.add(new workout_info_vol3("Muscle-up", "Progression", null,"level 4", "high bar"));

            return chosenMoves.get(CURRENTLEVEL);
        } else if (move.equals("90-degree Hold")) {
            CURRENTLEVEL = 0;
            chosenMoves.add(new workout_info_vol3("Pseudo-planche Push-up", "Progression", null,"level 1", "high bar"));
            chosenMoves.add(new workout_info_vol3("90-degree Hold Toe Taps", "Progression", null,"level 2", "high bar"));
            chosenMoves.add(new workout_info_vol3("90-degree Lean + Raise", "Progression", null,"level 3", "high bar"));
            chosenMoves.add(new workout_info_vol3("90-degree Hold", "Progression", null,"level 4", "high bar"));

            return chosenMoves.get(CURRENTLEVEL);
        }

        // black-lever
        // 90-Degree Handstand Push-up
        // Human Flag

        return null;
    }

    public static ArrayList<String> getExercisesOfMove(String move) {
        ArrayList<String> chosenMoves = new ArrayList<>();

        if (move.equals("Front Lever")) {
            chosenMoves.add("Upside-down Deadlift");
            chosenMoves.add("FL drops");
            chosenMoves.add("FL raises");
            chosenMoves.add("FL Pull-up");
            chosenMoves.add("Dragon Fly");
            // chosenMoves.add("Banded FL");
            return chosenMoves;
        }
        return null;
    }

    public static workout_info_vol3 anyMove(String givenMoveName) {
        return new workout_info_vol3(givenMoveName, null, null, null, null);
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
