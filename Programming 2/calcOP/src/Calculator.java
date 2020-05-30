public class Calculator {
    private int op1;

    private int op2;

    private char operator;

    public int calculate(){
        int total = 0;

        switch(operator){
            case '+':
                total = op1 + op2;
                break;
            case '-':
                total = op1 - op2;
                break;
            case '*':
                total = op1 * op2;
                break;
            case '/':
                total = op1 / op2;
                break;
            default:
                System.out.println("NA");
                break;
        }

        return total;
    }

    Calculator(int op1, int op2, char operator){
        this.op1 = op1;
        this.op2 = op2;
        this.operator = operator;
    }
}
