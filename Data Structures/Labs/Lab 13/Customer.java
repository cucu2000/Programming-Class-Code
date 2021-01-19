public class Customer {
    int arrivalTime;
    int transactionTime;
    int customerNumber;

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getTransactionTime() {
        return transactionTime;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    Customer(int arrival, int transaction, int customer){
        arrivalTime = arrival;
        transactionTime = transaction;
        customerNumber = customer;
    }
}
