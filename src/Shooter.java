import java.util.ArrayList;

/**
 * Created by Robert on 9/22/2015.
 */
public class Shooter {

    private String shooterName;
    private ArrayList<Character> shooterShots = new ArrayList<Character>();
    private int shooterScore;

    public Shooter(String shooterName) {
        this.shooterName = shooterName;
    }

    public void appendShot(char shot) {
        if(shot == 'X' || shot == 'O') {
            this.shooterShots.add(shot);
        }
    }

    public void countScoreTotal(ArrayList<Character> shooterScore) {
        int count = 0;
        Object[] shootArray = shooterScore.toArray();
        for (int i = 0; i < shootArray.length; i++) {
            if (shootArray[i] == 'X') count++;
        }
        setShooterScore(count);
    }

    public String getShooterName() {
        return shooterName;
    }

    public void setShooterName(String shooterName) {
        this.shooterName = shooterName;
    }

    public ArrayList<Character> getShooterShots() {
        return shooterShots;
    }

    public void setShooterShots(ArrayList<Character> shooterShots) {
        this.shooterShots = shooterShots;
    }

    public int getShooterScore() {
        return shooterScore;
    }

    public void setShooterScore(int shooterScore) {
        this.shooterScore = shooterScore;
    }

    public String toString() {
        return (getShooterName() + ": " + getShooterShots() + " Total: " + getShooterScore());
    }
}
