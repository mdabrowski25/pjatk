package pl.pjwstk.app.models;


public class Player implements Comparable<Player> {
    private static int counter = 6;
    private int id;
    private int position;
    private String name;
    private Integer time;

    public Player(int position, String name, Integer time) {
        this.id = counter++;
        this.position = position;
        this.name = name;
        this.time = time;
    }

    public Player(int id, int position, String name, Integer time) {
        this.id = id;
        this.position = position;
        this.name = name;
        this.time = time;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Player.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public int compareTo(Player o) {
        if (time < o.time) {
            return -1;
        } else if (time.equals(o.time)) {
            return 0;
        } else {
            return 1;
        }
    }


}
