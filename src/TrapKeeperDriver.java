import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Robert on 9/22/2015.
 *
 *  Trap shooting involves a team consisting of 1-5 shooters.
 *  Each of these shooters will shoot 25 targets for a round.
 *  Each round has 5 positions where the shooter will shoot 5 targets
 *  and then switch positions after 5 shots.
 *
 *  Generally after the 5 shots, the score keeper will call out the number
 *  of targets hit while the shooters are changing positions.
 *
 * Copyright Robert Gonser 2015
 */
public class TrapKeeperDriver {

    public static void main(String args[]){

        ArrayList<Shooter> shooterList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Amount of shooters: ");
        int shooterAmount = scanner.nextInt();

        System.out.println("Please enter the names of the shooters: ");
        for(int i = 0; i < shooterAmount; i++) {
            String shooterName = scanner.next();
            shooterList.add(new Shooter(shooterName));
        }

        //This loop will run for the amount of targets that need to be hit
        //The amount this loop will run is the (amount of shooters) * 25
        int count = 0;
        while(count < (25*shooterAmount)){
            Shooter currentShooter = shooterList.get(count % shooterAmount);
            System.out.println("Hit (h) or Miss (m): ");
            if(scanner.next().toLowerCase().equals("h")){
                currentShooter.appendShot('X');
                currentShooter.getTempShooterShots().push('X');
            }
            else {
                currentShooter.appendShot('O');
                currentShooter.getTempShooterShots().push('O');
            }

            //Checks to see if the shooter has 5 shots
            //If so, counts the amount of hits ('x') and places the count in to the
            //shooter's list of shots.
            if(currentShooter.getTempShooterShots().size() == 5){
                Integer counter = 0;
                char tempChar;
                while(!currentShooter.getTempShooterShots().isEmpty()){
                    tempChar = currentShooter.getTempShooterShots().pop();
                    if(tempChar == 'X'){
                        counter++;
                    }
                }
                currentShooter.appendShot(counter.toString().charAt(0));
            }

            currentShooter.countScoreTotal(currentShooter.getShooterShots());
            System.out.println(shooterListToString(shooterList));
            count++;
        }

        System.out.println(shooterListToString(shooterList));
    }

    public static String shooterListToString(ArrayList<Shooter> shooterList){
        String list = "";
        for(Shooter shooter : shooterList) list += shooter.toString() + "\n";
        return list;
    }

}