public class BankTransaction extends Transaction {
    
    private String accountNumber;
    private String bankName;
    private double commission;

    public BankTransaction(int transactionID,
                            double amount,
                            String date,
                            String status,
                            String accountNumber,
                            String bankName,
                            double commission) {
                                super(transactionID, amount, date, status);
                                this.accountNumber = accountNumber;
                                this.bankName = bankName;
                                this.commission = commission;
    }

    public double calculateCommission() {
        return getAmount() * commission / 100;
    }

    public void checkBalane() {
        System.out.println("account balance check: " + accountNumber);
    }

    public void printBankDetails() {
        System.out.println("Bank: " + bankName);
        System.out.println("account: " + accountNumber);
        System.out.println("commission: " + commission + "%");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
    
}
