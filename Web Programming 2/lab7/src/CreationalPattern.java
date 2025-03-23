public class CreationalPattern {

    public static void main(String [] args){
        optimizedUser user = new optimizedUser();
        user.Print();

//        Speaker speaker1 = new Speaker();
//        Speaker speaker2 = new Speaker();

//        speaker1.setVolume(10);
//        System.out.println("Speaker1: " + speaker1.getVolume());
//        System.out.println("Speaker2: " + speaker2.getVolume());

        Speaker speaker1 = Speaker.getInstance();
        Speaker speaker2 = Speaker.getInstance();

        speaker1.setVolume(15);
        //speaker2.setVolume(20);
        System.out.println("Speaker1: " + speaker1.getVolume());
        System.out.println("Speaker2: " + speaker2.getVolume());

    }
}
