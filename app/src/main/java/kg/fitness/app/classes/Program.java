package kg.fitness.app.classes;

import java.util.ArrayList;

public class Program {
    private ArrayList<Exercise> exercises = new ArrayList<>();
    private int currentExPosition = -1;

    public boolean hasMoreExercise() {
        return exercises.size() > currentExPosition + 1;
    }

    public Program(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }


    public Exercise getCurrentExercise() {
        return exercises.get(currentExPosition);
    }

    public int getExPosition() {
        return currentExPosition;
    }

    public void finishedExercise() {
        currentExPosition++;
    }


    public String getExercisesCount() {
        int count = 0;
        for (Exercise e : exercises) {
            if (e.type == Exercise.EX_TYPE.WORK) {
                count += e.count;
            }
        }
        return String.valueOf(count);
    }
}
