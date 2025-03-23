public class innerClassEx {

    int old_nt = 5;
    private int num = 4;
    static int number = 6;

    public void ntPrint(){
        System.out.println("old_nt = " + old_nt);
    }

    class InnerMember{

        int new_nt = 10;

        public void printInner(){
            System.out.println("num = " + num);
        }

        public void tapNt(){
            int total = old_nt + new_nt;
            System.out.println("Total: " + total);
        }
    }

    static class StaticClass {

        public void printInner(){
            System.out.println("number = " + number);
        }
    }

    abstractClass aClass = new abstractClass() {
        @Override
        void prnt() {
            System.out.println("Tnum = " + tnum);
        }
    };
}
