public class Polymorphism {
    public static void main(String [] args){

        Shape a = new Triangle();
        a.draw();
        Triangle t = (Triangle)a;
        System.out.println(t.sides);

        Shape b = new Rectangle();
        b.draw();

        Shape c = new Circle();
        c.draw();


    }
}
