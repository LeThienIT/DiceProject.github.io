package data;

public class Player {
    private String name;
    private int score;
    private boolean isWin;

    public boolean getIsWin() {
        return isWin;
    }

    public void setIsWin(boolean isWin) {
        this.isWin = isWin;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Player(String name){
        setName(name);
        setScore(0);
        setIsWin(false);
    }
}
