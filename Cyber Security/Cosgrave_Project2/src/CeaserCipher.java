import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CeaserCipher {

    //initialize variables
        static Scanner scan = new Scanner(System.in);

        int Key;

        String plainText;

        String encryptedString;

        String decryptedString;

        //prompt user for key
        public int inputKey(){
            System.out.println("Enter your Key: ");

            while(!scan.hasNextInt()){
                System.out.println("Input must be a number");
                String trash = scan.nextLine();
            }

            int Key = scan.nextInt();
            this.Key = Key;
            return Key;
        }

        //Get the String to Encrypt
        public String inputString(){
            System.out.println("Enter your Message, result will be all lower case:");

            String inputtedString = scan.nextLine().toLowerCase();

            this.plainText = inputtedString;

            return inputtedString;

        }

        //Encrypt the String
        public String encryptString(int key, String input){

            String encryptedString = "";

            int length = input.length();

            for(int x = 0; x < length; x++){

                char c = (char)(input.charAt(x) + key);

                if(c > 'z') {
                    encryptedString += (char) (input.charAt(x) - (26 - key));

                }else{
                    encryptedString += (char) (input.charAt(x) + key);
                }
                this.encryptedString = encryptedString;

            }
            return encryptedString;
        }

        //decrypt String
    public void decryptString(int key, String encrypted){

        String decryptedString = "";

        int length = encrypted.length();

        for(int x = 0; x < length; x++){

            char c = (char)(encrypted.charAt(x) - key);

            if(c < 'a') {
                decryptedString += (char) (encrypted.charAt(x) + (26 - key));

            }else{
                decryptedString += (char) (encrypted.charAt(x) - key);
            }
            this.decryptedString = decryptedString.replace(':', ' ');
        }
    }

    //Print out
        public void printText(){
            System.out.println("Plain Text: " + plainText);
            System.out.println("Key: " + Key);
            System.out.println("Encrypted Text: " + this.encryptedString);
            System.out.println("Decrypted Text: " + this.decryptedString);
        }
    }

