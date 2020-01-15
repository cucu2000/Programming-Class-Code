public class Student extends Person{
  private String Major;

  private int yearInSchool;

  public void setMajor(String Major){
    this.Major = Major;
  }
  public void setYearInSchool(int yearInSchool){
    boolean outcome = true;
   do{
     if((this.yearInSchool < 1) && (this.yearInSchool > 4)){
       System.out.println("Must be a number 1 - 4");
       outcome = false;
      }
     }while(outcome = false);
    this.yearInSchool = yearInSchool;
  }
  public String getMajor(){
    String Major = this.Major;
    return Major;
  }
  public int getYearInSchool(){
    int yearInSchool = this.yearInSchool;
    return yearInSchool;
  }
  public void printInfo(){
    super.printInfo();
    getMajor();
    getYearInSchool();
    System.out.println("Major: " + Major);
    System.out.println("Year In School: " + yearInSchool);
  }
  public Student(){
    super.getName();
    super.getEmail();
    getMajor();
    getYearInSchool();
  }
  public Student(String Name, String Email, String Major, int yearInSchool){
    super.setName(Name);
    super.setEmail(Email);
    setMajor(Major);
    setYearInSchool(yearInSchool);
  }
}
