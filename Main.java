import java.util.*; // scanner import
import java.text.DecimalFormat; // decimal format import found on Stack Overflow
// (https://stackoverflow.com/questions/14204905/java-how-to-remove-trailing-zeros-from-a-double)

public class Main {

    public static void main (String args[]){

        Scanner scnr = new Scanner(System.in);

        String hexInput; // user input hex number
        String numHex;
        double numDecimal = 0; // output number in decimal
        int loopLength; // value for how many times program should loop
        double currentRead; // ASCII value
        double powerOf16; // value of the current power of 16
        double currentPower = 0; // current value for what power to raise the 16 to
        double newValue; // value added to our decimal number

        System.out.println("Enter a hexadecimal number: ");

       hexInput = scnr.nextLine(); // gets user input

       numHex = hexInput.toLowerCase(); // converts input to lowercase

       loopLength = numHex.length(); // takes the length of the string to know how many times to loop

       while (loopLength != 0){

           currentRead = numHex.charAt(loopLength - 1); // gets ASCII value of current character in the string

           if (currentRead >= 48 && currentRead <= 57){ // if the ASCII value matches a number 0-9

               currentRead = currentRead - 48; // adjusts ASCII value to number desired for calculation

               powerOf16 = Math.pow(16,currentPower); // sets the power of 16 for calculation

               newValue = currentRead * powerOf16; // the currently read character value multiplied by our power of 16

               numDecimal = numDecimal + newValue; // adds our new value to our previously calculated ones


           }else if (currentRead >= 97 && currentRead <= 102){
               currentRead = currentRead - 87;
               powerOf16 = Math.pow(16,currentPower);
               newValue = currentRead * powerOf16;
               numDecimal = numDecimal + newValue;
           }


           loopLength = loopLength - 1; // adjusts number of loops left
           currentPower = currentPower + 1; // increments power that 16 is raised to
       }

       DecimalFormat format = new DecimalFormat("0.#");
       // take .0 off of the double. Found on stack overflow. Link at top

       System.out.println("Your number is " + format.format(numDecimal) + " in decimal");
    }
}
