import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Robert on 9/22/2015.
 *
 * Copyright Robert Gonser 2015
 */
public class Shooter {

    private String shooterName;
    private ArrayList<Character> shooterShots = new ArrayList<>();

    private Stack<Character> tempShooterShots = new Stack<>();
    private int shooterScore;

    public Shooter(String shooterName) {
        this.shooterName = shooterName;
    }

    public void appendShot(char shot) {
        this.shooterShots.add(shot);
    }

    public void countScoreTotal(ArrayList<Character> shooterScore) {
        int count = 0;
        for(Character tempChar : shooterScore) if(tempChar == 'X') count++;
        setShooterScore(count);
    }

    public String getShooterName() {
        return shooterName;
    }

    public ArrayList<Character> getShooterShots() {
        return shooterShots;
    }

    public int getShooterScore() {
        return shooterScore;
    }

    public void setShooterScore(int shooterScore) {
        this.shooterScore = shooterScore;
    }

    public Stack<Character> getTempShooterShots() {
        return tempShooterShots;
    }

    public String toString() {
        return (getShooterName() + ": " + getShooterShots() + " Total: " + getShooterScore());
    }
}
