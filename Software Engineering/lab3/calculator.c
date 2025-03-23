#include <stdio.h>

int add(int x, int y);
int multiply(int x, int y);
int division(int x, int y);
int subtraction(int x, int y);
int maximum(int x, int y);
int power(int x, int y);

void main() {
		 int number1, number2;
    printf("Welcome to my Calculator\n");
    printf("Enter 2 numbers\n");
    scanf("%d", &number1);
    scanf("%d", &number2);

    int sum = 0, product = 0, quotient = 0, substract = 0, max = 0;
    long long int pow = 0;

    sum = add(number1, number2);
    product = multiply(number1, number2);
    quotient = division(number1, number2);
    substract = subtraction(number1, number2);
    max = maximum(number1, number2);
    pow = power(number1, number2);

    printf("The sum of the 2 numbers is: %d \n", sum);
    printf("The product of the 2 numbers is: %d \n", product);
    printf("The quotient of the 2 numbers is: %d \n", quotient);
    printf("Number 1 - Number 2 is: %d \n", substract);
     printf("The maximum of the 2 numbers is: %d \n", max);
     printf("Number 1 to the power of Number 2 is: %d \n", pow);
}
