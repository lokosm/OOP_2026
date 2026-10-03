public class Transaction {

    private int transactionID;
    private double amount;
    private String date;
    private String status;

    public Transaction(int transactionID, double amount, String date, String status) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public void execute() {
        status = "completed";
        System.out.println("transaction completed");
    }

    public void cancel() {
        status = "cancelled";
        System.out.println("transaction canceled");
    }

    public void printInfo() {
        System.out.println("Transaction ID:" + transactionID);
        System.out.println("sum:" + amount);
        System.out.println("date: " + date);
        System.out.println("status:" + status);
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
