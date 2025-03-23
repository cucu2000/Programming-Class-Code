import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Network {

    public static void main(String [] args){

//ex 1. InetAddress
        System.out.println("Ex 1. InetAddress");

        try{
            //localhost == Ipconfig

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);

            String hostName = "www.okcu.edu";
            InetAddress OKCU = InetAddress.getByName(hostName);
            System.out.println(OKCU);

            String hostName2 = "www.google.com";
            InetAddress google = InetAddress.getByName(hostName2);
            System.out.println(google);

        }catch (UnknownHostException err){
            System.out.println(err.getMessage());
        }

        System.out.println(" ");

        //ex 2. InetAddress by args passing
        System.out.println("Ex 2. InetAddress by args passing");

        //go into run settings and add a URL into arguments
        if(args.length != 1){
            System.out.println("Enter Host Name and IP: ");
            System.out.println(" ");
            return;
        }

        try{

            InetAddress hostAddress = InetAddress.getByName(args[0]);
            System.out.println("Host Name: " + hostAddress.getHostName());
            System.out.println("Host Address: " + hostAddress.getHostAddress());

            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("LocalHost Name: " + localAddress.getHostName());
            System.out.println("LocalHost Address: " + localAddress.getHostAddress());

        }catch (UnknownHostException err){
            System.out.println(err.getMessage());
        }

        System.out.println(" ");

        //Example 3 URL
        System.out.println("Ex 3. URL");

        try{

            URL httpu = new URL("http://www.okcu.edu/index.html");
            System.out.println(httpu);

            URL ftpu = new URL("ftp://ftp.okcu.edu/public");
            System.out.println(ftpu);

            URL mailu = new URL("mailto://webmmaster@mail.okcu.edu");
            System.out.println(mailu);

            URL telnetu = new URL("telnet://www.okcu.edu");
            System.out.println(telnetu);


        }catch (MalformedURLException err){
            System.out.println(err.getMessage());
        }

        System.out.println(" ");

        //Example 4 URL InputStream
        System.out.println("Ex 4. URL InputStream");

        String readLine = "";

        try{

            URL u = new URL("https://www.ebay.com/index.html");
            InputStream iStream = u.openStream();

            Reader isReader = new InputStreamReader(iStream);
            BufferedReader br = new BufferedReader(isReader);

            while((readLine = br.readLine()) != null){
                System.out.println(readLine);
            }

        } catch (IOException err){
            err.getMessage();

        }

    }//main
}//Network
