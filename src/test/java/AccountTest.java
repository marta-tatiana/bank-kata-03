import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void
    test_empty_print_statement() {
        Account account = new Account();
        assertThat(account.printStatement(), equalTo(expectedStatement()));
    }

    @Test
    public void
    should_reflect_deposit_in_the_statement() {
        Account account = new Account();
        account.deposit(new BigDecimal(1000));
        assertThat(account.printStatement(), equalTo(expectedOneTransactionStatement()));
    }

    @Test
    public void
    should_reflect_two_deposits_in_the_statement() {
        Account account = new Account();
        account.deposit(new BigDecimal(1000));
        account.deposit(new BigDecimal(-100));
        String expectedStatement = "DATE       | AMOUNT  | BALANCE\n" +
                "01/04/2014 | 1000.00 | 1000.00\n" +
                "01/04/2014 | 1000.00 | 1000.00";
        assertThat(account.printStatement(), equalTo(expectedStatement));
    }

    private String expectedStatement() {
        return "DATE       | AMOUNT  | BALANCE\n" +
               "01/04/2014 | 0.00    | 0.00";
    }

    private String expectedOneTransactionStatement() {
        return "DATE       | AMOUNT  | BALANCE\n" +
               "01/04/2014 | 1000.00 | 1000.00";
    }
    
}
