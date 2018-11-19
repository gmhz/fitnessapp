package kg.fitness.app.classes;

import kg.fitness.app.R;

public class Exercise {
    public int count = 0;
    public String title = "";
    public int picture = R.mipmap.ic_launcher;
    public enum EX_TYPE {REST, WORK}
    public EX_TYPE type = EX_TYPE.WORK;

    public Exercise(int count, String title) {
        this.count = count;
        this.title = title;
    }

    public Exercise(int count, String title, int picture) {
        this.count = count;
        this.title = title;
        this.picture = picture;
    }

    public Exercise(int count, String title, EX_TYPE type) {
        this.count = count;
        this.title = title;
        this.type = type;
    }

    public Exercise(int count, String title, int picture, EX_TYPE type) {
        this.count = count;
        this.title = title;
        this.picture = picture;
        this.type = type;
    }
}
