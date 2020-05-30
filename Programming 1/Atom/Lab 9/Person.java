public class Person{
  private String Name;

  private String Email;

  public void setName(String Name){
    this.Name = Name;
  }
  public void setEmail(String Email){
    this.Email = Email;

  }
  public void printInfo(){
    System.out.println("Name: " + this.Name);
    System.out.println("Email: " + this.Email);
  }
  public  String getName(){
    String Name = this.Name;
    return Name;
  }
  public String getEmail(){
    String Email = this.Email;
    return Email;
  }
  public Person(){
    getName();
    getEmail();

  }
  public Person(String Name, String Email){
    setName(Name);
    setEmail(Email);

  }
}
