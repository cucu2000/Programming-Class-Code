public class Speaker {

    private int volume;
    private static Speaker speaker;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public static Speaker getInstance(){
        if(speaker == null){
            speaker = new Speaker();
        }
        return speaker;
    }

    Speaker(){
      volume = getVolume();
    }
}
