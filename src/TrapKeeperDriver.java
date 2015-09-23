import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by Robert on 9/22/2015.
 */
public class TrapKeeperDriver {

    public static void main(String args[]){

        ArrayList<Shooter> shooterList = new ArrayList<Shooter>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Amount of shooters: ");
        int shooterAmount = scanner.nextInt();

        System.out.println("Please enter the names of the shooters: ");
        for(int i = 0; i < shooterAmount; i++) {
            String shooterName = scanner.next();
            shooterList.add(new Shooter(shooterName));
        }

        int count = 0;
        while(count < (25*shooterAmount)){
            Shooter currentShooter = shooterList.get(count%shooterAmount);
            System.out.println("Hit (h) or Miss (m): ");
            if(scanner.next().toLowerCase().equals("h")){
                currentShooter.appendShot('X');
            }
            else{
                currentShooter.appendShot('O');
            }
            currentShooter.countScoreTotal(currentShooter.getShooterShots());
            System.out.println(shooterListToString(shooterList));
            count++;
        }

        System.out.println(shooterListToString(shooterList));
    }

    public static String shooterListToString(ArrayList<Shooter> shooterList){
        String list = "";
        Object[] shootArray = shooterList.toArray();
        for (int i = 0; i < shootArray.length; i++) {
            list += shootArray[i].toString() + "\n";
        }
        return list;
    }

}