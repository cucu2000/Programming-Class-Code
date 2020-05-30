public class testOpr {

    // 1. assignment ( = )

    int as = 5;

    // 2. arithmetic ( +, -, /, *, %)

    int mo = 5  % 2;

    // 3. bitwise ( &, |, ^, ~, >>, <<) = turns decimal t binary

    int bt1 = 2 & 3; // 10 and 11 --> = 10 = 2

    int bt2 = ~3; // +3 (decimal) --> 011 (2's compliment) -> ~ -> 100 (2's compliment) == -4 (decimal)

    int bt3 = 8 >> 2; // 1000 >> 2 --> 0010 == 2

    // 4. Comparative (==, >, <, >=, <=)

    // 5. Conditional ( &&, ||, ?: (ternary ( ? true : false)))

    int con = (3 < 2) ? 1 : 0;

    // 6. Increment and Decrement ( ++ , --)

    int inc1 = 7;
    int inc2 = ++ inc1;

}
