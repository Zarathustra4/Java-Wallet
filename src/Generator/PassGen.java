package Generator;

import java.util.Random;

public class PassGen {

    public static void main(String[] args){
        //a - 97
        //A - 65
        String chars = "";
        int lower = 97;
        int upper = 65;
        for(int i = 0; i < 22; i++){
            chars += (char) (lower + i);
            chars += (char) (upper + i);
        }
        for(int i = 0; i < 10; i++){
            chars+=i;
        }
        chars+="!@#$%^&*()[]";

        Random rand = new Random();
        int lenght = 10 + rand.nextInt(10);

        String pass = "";
        for(int i = 0; i < lenght; i++){
            pass += chars.charAt(rand.nextInt(chars.length()));
        }
        System.out.println("Your pass - " + pass);
    }
}
