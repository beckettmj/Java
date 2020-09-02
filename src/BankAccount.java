import java.text.DecimalFormat;

public class BankAccount {
    private String customerName;
    private Double accountBalance;
    private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");

    public BankAccount(String customerName, Double accountBalance) {
        this.customerName = customerName;
        this.accountBalance = accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String printFormattedBalance() {
        return DECIMAL_FORMAT.format(accountBalance);
    }

    public String makeDeposit(String depositAmount) {
        try {
            double depositDouble = Double.parseDouble(depositAmount);
            this.accountBalance = Double.valueOf(this.accountBalance + depositAmount);
            if (depositDouble < 0.0) {
                return "Deposit amount cannot be negative.";
            }
            this.accountBalance += depositDouble;
        } catch (NumberFormatException e) {
            accountBalance += 0.0;
        }
        return null;
    }

    public String makeWithdrawal(String withdrawalAmount) {
        try {
            double withdrawalDouble = Double.parseDouble(withdrawalAmount);
            if (withdrawalDouble > accountBalance) {
                return "Withdrawal amount cannot be greater than balance.";
            }
            this.accountBalance -= withdrawalDouble;
        } catch (NumberFormatException e) {
            accountBalance -= 0.0;
        }
        return null;
    }
}
