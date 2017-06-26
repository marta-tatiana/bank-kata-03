import java.math.BigDecimal;

public class Account {
    private final String headerRow = "DATE       | AMOUNT  | BALANCE";
    private BigDecimal balance = new BigDecimal(0);

    public String printStatement() {
        String formatted = formatAmount(balance);
        return headerRow + "\n" +
                "01/04/2014 | " + formatted + "| " + formatted.trim();
    }

    private String formatAmount(BigDecimal amount) {
        String roundedAmount = amount.setScale(2).toPlainString();
        return String.format("%1$-8s", roundedAmount);
    }

    public void deposit(BigDecimal amount) {
        balance = amount;
    }
}
