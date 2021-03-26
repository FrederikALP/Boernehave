package com.company;

import java.util.Scanner;

public class UserInput {
    static Scanner scan = new Scanner(System.in);

    //Checks if the input is an integer and if it is within the chosen min/max value
    public int inputInt(int min, int max, String msg) {
        int number;
        System.out.println(msg);
        do {

            while (!scan.hasNextInt()) {
                System.out.println("Fejl, du skal skrive et tal:");
                scan.next();
            }
            number = scan.nextInt();
            scan.nextLine();
            if (number < min || number > max) {
                System.out.println("Du skal skrive et tal mellem " + min + " og " + max + ":");
            }
        } while (number < min || number > max);

        return number;
    }

    //Asks user to input an integer if they didn't
    public int inputInt(String msgOutput) {
        int number;
        System.out.println(msgOutput);
        while (!scan.hasNextInt()) {
            System.out.println("Du skal skrive et hel-tal!");
            System.out.println(msgOutput);
            scan.next();
        }
        number = scan.nextInt();
        scan.nextLine();
        return number;
    }

    public int inputInt() {
        int number;
        while (!scan.hasNextInt()) {
            System.out.println("Du skal skrive et hel-tal!");
            scan.next();
        }
        number = scan.nextInt();
        scan.nextLine();
        return number;
    }

    public String inputString(String msg, Boolean checkForNumbers) {
        String word = "";
        if (!checkForNumbers) {
            System.out.println(msg);
            word = scan.nextLine();
        }
        while(checkForNumbers){
            System.out.println(msg);
            word = scan.nextLine();
            if (containsNumbers(word)){
                checkForNumbers = true;

            } else checkForNumbers = false;
        }
        return word;
    }

    //Scans the given String for numbers and returns TRUE if found.
    public boolean containsNumbers(String str){
        for(char ch : str.toCharArray()){
            if(Character.isDigit(ch)){
                return true;
            }
        }
        return false;
    }

    public boolean inputBoolean(String msg) {

        boolean word;
        System.out.println(msg);
        while(!scan.hasNextBoolean()){
            System.out.println(msg);
            scan.next();
        }
        word = scan.nextBoolean();
        return word;
    }
}