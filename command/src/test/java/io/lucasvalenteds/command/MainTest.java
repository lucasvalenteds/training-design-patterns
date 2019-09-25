package io.lucasvalenteds.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testDrawSubtracts() {
        CashOperation operation = new Draw(25.00);

        assertEquals(5.00, operation.execute(30.00), 0.01);
        assertEquals(0.00, operation.execute(25.00), 0.01);
        assertEquals(-5.00, operation.execute(20.00), 0.01);
    }

    @Test
    void testDepositAdds() {
        Deposit deposit = new Deposit(15.00);

        assertEquals(15.00, deposit.execute(0.00), 0.01);
        assertEquals(25.00, deposit.execute(10.00), 0.01);
        assertEquals(5.00, deposit.execute(-10.00), 0.01);
    }

    @Test
    void testAnAccountHasBalance() {
        double initialBalance = 100.00;

        Account account = new Account(initialBalance);

        assertEquals(100.00, account.getBalance(), 0.01);
    }

    @Test
    void testAccountBalanceDraw() {
        Account account = new Account(100.00);

        account.executeOperation(new Draw(25.00));
        account.executeOperation(new Draw(5.00));

        assertEquals(70.00, account.getBalance(), 0.01);
    }

    @Test
    void testAccountBalanceDeposit() {
        Account account = new Account(0.00);

        account.executeOperation(new Deposit(4.75));
        account.executeOperation(new Deposit(7.25));

        assertEquals(12.00, account.getBalance(), 0.01);
    }

    @Test
    void testAccountBalance() {
        Account account = new Account(0.00);

        account.executeOperation(new Draw(10.00));
        account.executeOperation(new Draw(2.50));
        account.executeOperation(new Deposit(8.50));
        account.executeOperation(new Draw(1.25));
        account.executeOperation(new Deposit(50.00));

        assertEquals(44.75, account.getBalance(), 0.01);
    }

    @Test
    void testLambdaWorksToo() {
        Account account = new Account(0.00);

        account.executeOperation(balance -> balance - 2.50);
        account.executeOperation(balance -> balance + 5.00);

        assertEquals(2.50, account.getBalance(), 0.01);
    }

    @Test
    void testWhatMattersIsTheContract() {
        FunctionalAccount account = new FunctionalAccount(0.00);

        account.executeOperation(balance -> balance - 2.50);
        account.executeOperation(balance -> balance + 5.00);

        assertEquals(2.50, account.getBalance(), 0.01);
    }
}
