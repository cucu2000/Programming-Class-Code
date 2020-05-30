import java.io.*;


public class Main {
    public static void main(String [] args){

        try{
            //write
/*
            String emp1 = "03 Three 03/03/2000" + "\n";

            BufferedWriter bw = new BufferedWriter(new FileWriter("File test", true));
            bw.write(emp1);
            bw.flush();
            bw.close();
*/
            //read
            BufferedReader br = new BufferedReader(new FileReader("File test"));
            String emp2;
            while ((emp2 = br.readLine()) != null) {
                System.out.println(emp2);
            }
        }catch(IOException ioe){
            System.err.println("");
        }
    }
}
