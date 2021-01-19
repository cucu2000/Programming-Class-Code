public class StackTest{
  public static void main(String [] args){
    //instantiate empty StackTest
    StackInterface<String> StringStack = new ArrayStack<>();

    //add to the Stack
    StringStack.push("Mango");
    StringStack.push("Apple");

    // display the content
    while(!StringStack.isEmpty()){
      System.out.println(StringStack.peek());
      StringStack.pop();
    }
  }
}
