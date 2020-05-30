public class Main {
    public static void main(String [] args){

        //initialize Ceaser Cipher Class
        CeaserCipher cc1 = new CeaserCipher();

        //prompt user for key
        //Get the String to Encrypt
        String plainText = cc1.inputString();
        int Key = cc1.inputKey();

        //encrypt
        String encryptedString = cc1.encryptString(Key, plainText);

        //take encrypted string and then decrypt it
        cc1.decryptString(Key, encryptedString);

        //print out
        cc1.printText();







    }
}
