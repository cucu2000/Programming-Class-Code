public class testNode {
    private String Name;
    private testNode Next;

    //methods
    public String getName(){
        return Name;
    }

    public testNode getNext(){
        return Next;
    }

    //Constructor
    testNode(){
        Name = "";
        Next = null;
    }

    @Override
    public String toString() {
        return Name +  " --->" + Next;
    }

    testNode(String nName, testNode nNext){
        Name = nName;
        Next = nNext;
    }

    public static void main(String [] args){
        testNode student12 = new testNode("Vivian", null);
        testNode student11 = new testNode("Xander", student12);
        testNode student10 = new testNode("Jenny", student11);
        testNode student9 = new testNode("Boris", student10);
        testNode student8 = new testNode("Gabe", student9);
        testNode student7 = new testNode("Rachel", student8);
        testNode student6 = new testNode("Kyle", student7);
        testNode student5 = new testNode("Chase", student6);
        testNode student4 = new testNode("Elie", student5);
        testNode student3 = new testNode("Tyler", student4);
        testNode student2 = new testNode("Alex", student3);
        testNode student1 = new testNode("Kaleb", student2);

        System.out.println(student1.toString());
    }//main
}//testNode
