import java.net.*;

public class Network{

    public static void main(String [] args){

        //exl. InetAddress
        System.out.println("Exl InetAddress");

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
            System.out.println("Can't find host ip. " + err.getMessage());
        }

    }//main
}//Network
