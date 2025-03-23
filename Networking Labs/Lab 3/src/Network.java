import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Network {
    public static void main(String [] args){

        //file write
        try{

//            String str = "Hello Network";
//            BufferedWriter bW = new BufferedWriter(new FileWriter("File.txt", true));
//
//            bW.write(str);
//            bW.flush();
//            bW.close();

            String [] readStr = new String[10];
            int count = 0;

            BufferedReader bR = new BufferedReader(new FileReader("File.txt"));

            while (true) {
                String readString = bR.readLine();
                if(readString == null){
                    break;
                }

                readStr[count] = readString;
                System.out.println(readStr[count]);
                count++;
            }


        }catch (IOException err){
            System.out.println("e5");
        }

        try{

            URL url = new URL("");

            BufferedReader bR = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;

            while((inputLine = bR.readLine()) != null){
                System.out.println(inputLine);
                bR.close();
            }

        }catch (IOException err){
            System.out.println("e6");
        }

        try{

            URL url = new URL("https://www.nbcnews.com/news/us-news/ahmaud-arbery-murder-suspects-seek-ban-confederate-flag-license-plate-n1280926");
            URLConnection urlC = url.openConnection();

            BufferedReader bR = new BufferedReader(new InputStreamReader(urlC.getInputStream()));
            String inputLine;

            while((inputLine = bR.readLine()) != null) {
                System.out.println(inputLine);
            }

            bR.close();


        }catch (IOException err){
            System.out.println(err.getMessage());
            System.out.println("e7");
        }

    }
}
