package kg.fitness.app.utils;

import java.util.ArrayList;

import kg.fitness.app.classes.Exercise;

public class HF {
    private static int REST_SECONDS = 3;

    public static String getFTime(int timeInSeconds) {
        int minutes = timeInSeconds / 60;
        int seconds = timeInSeconds % 60;
        String mins = minutes < 10 ? "0" + String.valueOf(minutes) : String.valueOf(minutes);
        String secondsS = seconds < 10 ? "0" + String.valueOf(seconds) : String.valueOf(seconds);

        return String.format("%s:%s", mins, secondsS);
    }


    public static ArrayList<Exercise> getInitExercises() {
        ArrayList<Exercise> exercises = new ArrayList<>();
        exercises.add(
                new Exercise(
                        1,
                        "Жим штанги лёжа",
                        Exercise.EX_TYPE.WORK
                )
        );
        exercises.add(
                new Exercise(
                        REST_SECONDS,
                        "Отдых",
                        Exercise.EX_TYPE.REST
                )
        );
        exercises.add(
                new Exercise(
                        2,
                        "Жим штанги лёжа",
                        Exercise.EX_TYPE.WORK
                )
        );
        exercises.add(
                new Exercise(
                        REST_SECONDS,
                        "Отдых",
                        Exercise.EX_TYPE.REST
                )
        );
        exercises.add(
                new Exercise(
                        3,
                        "Жим штанги лёжа",
                        Exercise.EX_TYPE.WORK
                )
        );
        exercises.add(
                new Exercise(
                        REST_SECONDS,
                        "Отдых",
                        Exercise.EX_TYPE.REST
                )
        );
        exercises.add(
                new Exercise(
                        4,
                        "Жим штанги лёжа",
                        Exercise.EX_TYPE.WORK
                )
        );
        exercises.add(
                new Exercise(
                        REST_SECONDS,
                        "Отдых",
                        Exercise.EX_TYPE.REST
                )
        );
        exercises.add(
                new Exercise(
                        5,
                        "Жим штанги лёжа",
                        Exercise.EX_TYPE.WORK
                )
        );
        return exercises;
    }
}
