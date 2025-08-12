/*
Authored on 8/12/25
 */

public class Main {

    // Need static variable to be accessed in main method
    static int hippoCount = 0;

    public static void main(String[] args) {
        // Loop through 1 to 10 and count hippos
        for (int i = 0; i <= 10; ++i) {
            hippoCount++;
            System.out.print(hippoCount + " Hippopotamus\n");
        }

        // Common Data Types as Variables
        int height;
        height = 170;
        double weight = 175.5;
        char oneLetter = 'X';
        String eyeColor = "Blue";
        System.out.println(eyeColor.substring(1, 3));

//        boolean canDrive = (age >= 21);
//        System.out.println(canDrive);

        int heightInches = (int) Math.round(height * 0.3937);
        System.out.println(heightInches);

        long bigNumber = 1_234_567_890_123_456L;
        byte smallNumber = 0b01000100;

        short smallerInt = 32767;

        float pi = 3.1415926f;
        System.out.println(pi);

        Integer age = 51;
        System.out.println(age);



    }

}