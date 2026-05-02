// FleetOfBicyclesApp.java
// Grant Dresser
// 5/1/2026

import java.util.Scanner;

public class FleetOfBicyclesApp {
    static Scanner userinput = new Scanner(System.in);

    public static void main(String[] args) {
        Bicycle[] bikes = new Bicycle[6];
        int[] rideMinutes = new int[6];

        int numberOfBikes = 0;

        System.out.println("Welcome to the Fleet of Bicycles Exercise Planner!");

        while (numberOfBikes < 1 || numberOfBikes > 6) {
            System.out.print("How many bicycles would you like to enter? Choose 1 through 6: ");
            numberOfBikes = userinput.nextInt();
            userinput.nextLine();

            if (numberOfBikes < 1 || numberOfBikes > 6) {
                System.out.println("Invalid number. Please enter a number from 1 to 6.");
            }
        }

        for (int i = 0; i < numberOfBikes; i++) {
            System.out.println();
            System.out.println("Enter information for bicycle #" + (i + 1));

            System.out.print("Enter the bike owner's name: ");
            String owner = userinput.nextLine();

            System.out.print("Enter the bicycle type or brand: ");
            String type = userinput.nextLine();

            System.out.print("Enter the starting cadence in RPM: ");
            int cadence = userinput.nextInt();

            System.out.print("Enter the current speed in MPH: ");
            int speed = userinput.nextInt();

            System.out.print("Enter the current gear: ");
            int gear = userinput.nextInt();

            System.out.print("How many minutes will this bike be ridden? ");
            int minutes = userinput.nextInt();
            userinput.nextLine();

            bikes[i] = new Bicycle(cadence, speed, gear, type, owner);
            rideMinutes[i] = minutes;
        }

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("         FLEET OF BICYCLES");
        System.out.println("--------------------------------");

        for (int i = 0; i < numberOfBikes; i++) {
            double hours = rideMinutes[i] / 60.0;
            double miles = bikes[i].speed * hours;
            int totalPedalTurns = bikes[i].cadence * rideMinutes[i];

            System.out.println();
            System.out.println("Bicycle #" + (i + 1));
            System.out.println("--------------------");
            System.out.println(bikes[i].getInfo());

            System.out.println();
            System.out.println("Exercise Plan Results:");
            System.out.println("Ride time: " + rideMinutes[i] + " minutes");
            System.out.println("Estimated distance: " + miles + " miles");
            System.out.println("Estimated pedal rotations: " + totalPedalTurns);

            if (rideMinutes[i] < 20) {
                System.out.println("Plan suggestion: Try a short beginner ride today.");
            } else if (rideMinutes[i] <= 45) {
                System.out.println("Plan suggestion: This is a solid moderate workout.");
            } else {
                System.out.println("Plan suggestion: This is a longer endurance ride.");
            }

            if (bikes[i].speed < 10) {
                System.out.println("Speed advice: Focus on steady pacing and comfort.");
            } else if (bikes[i].speed <= 18) {
                System.out.println("Speed advice: This bike is moving at a good exercise pace.");
            } else {
                System.out.println("Speed advice: This bike is moving fast, so remember to recover.");
            }

            if (bikes[i].cadence < 60) {
                System.out.println("Cadence advice: Try using an easier gear to pedal faster.");
            } else if (bikes[i].cadence <= 90) {
                System.out.println("Cadence advice: This cadence is in a good range.");
            } else {
                System.out.println("Cadence advice: This cadence is high, so stay controlled.");
            }
        }

        System.out.println();
        System.out.println("Thank you for using the Fleet of Bicycles Exercise Planner!");
    }
}