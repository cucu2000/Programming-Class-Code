public class control {

    //if and else if
    public void getIf() {
        int score = 95;

        if (score > 90) {
            System.out.println("Grade is A");
        } else if (score > 80) {
            System.out.println("Grade is B");
        } else if (score > 70) {
            System.out.println("Grade is C");
        } else if (score > 60) {
            System.out.println("Grade is D");
        } else {
            System.out.println("Grade is F");
        }
    }

    //switch case
    public void getSwitch() {
        int sw = 3;
        switch (sw) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            default:
                System.out.println("Friday");
                break;
        }
    }

    //for and extended for
    public void getForBreak() {
        out:
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (y == 1) {
                    break out;
                }
                System.out.println("X: " + x + "  Y: " + y);
            }
        }
    }

    public void getForContinue() {
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                if (y == 1) {
                    continue;
                }
                System.out.println("X: " + x + "  Y: " + y);
            }
        }
    }

    public void extendedFor(){
        int A [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int total = 0;

        for(int x: A){
            total += x;
            System.out.println(total);
        }
    }
}
