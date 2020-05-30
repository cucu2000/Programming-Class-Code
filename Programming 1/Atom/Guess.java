import java.util.*;
public class Guess{

  public static int score = 0;

  public int scoreF;

  public int randomNumber;

  public int generateRandomNumber(){
    Random rand = new Random();
    int randomNumber = rand.nextInt(100) + 1;
    this.randomNumber = randomNumber;
    return randomNumber;
  }

  public int getFinal(){
    return scoreF;
  }
  public int compare(int offNumber){
    score = 0;
    if (offNumber == 0){
      score = (score + 100);
    }else if(offNumber < 25){
      score = (score + 25);
    }else if (offNumber > 25){
      score = (score + 10);
    }
     scoreF = score + scoreF;
     return scoreF;
  }
}
