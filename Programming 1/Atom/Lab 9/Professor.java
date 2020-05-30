public class Professor extends Person{
  private String Degree;

  private String University;

  private int yearGraduated;

  public void setDegree(String Degree){
    this.Degree = Degree;
  }
  public void setUniversity(String University){
    this.University = University;
  }
  public void setYearGraduated(int yearGraduated){
    boolean outcome = true;
    do{
    if(yearGraduated < 1900){
      System.out.println("Must be greater than the year 1900");
      outcome = false;
     }
    }while(outcome = false);
    this.yearGraduated = yearGraduated;
  }
  public String getDegree(){
    return this.Degree;
  }
  public String getUniversity(){
    return this.University;
  }
  public int getYearGraduated(){
    return this.yearGraduated;
  }
  public void printInfo(){
    super.printInfo();
    System.out.println("Degree: " + this.Degree);
    System.out.println("University: " + this.University);
    System.out.println("Year Graduated: " + this.yearGraduated);
  }
  public Professor(){
    super.getName();
    super.getEmail();
    getDegree();
    getUniversity();
    getYearGraduated();
  }
  public Professor(String Name, String Email, String Degree, String University, int yearGraduated){
    super.setName(Name);
    super.setEmail(Email);
    setDegree(Degree);
    setUniversity(University);
    setYearGraduated(yearGraduated);
  }
}
