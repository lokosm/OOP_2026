public class CardTransaction extends BankTransaction {
    
    private String cardNumber;
    private String cardType;
    private String merchant;

    public CardTransaction(int transactionID,
                            double amount,
                            String date,
                            String status,
                            String accountNumber,
                            String bankName,
                            double commission,
                            String cardNumber,
                            String cardType,
                            String merchant) {
                                super(transactionID,
                                    amount,
                                    date,
                                    status,
                                    accountNumber,
                                    bankName,
                                    commission
                                );
                                this.cardNumber = cardNumber;
                                this.cardType = cardType;
                                this.merchant = merchant;
                            }
        public void authorizeCard() {
            System.out.println("The card is authorized.");
        }

        public void pay() {
            System.out.println("Payment at the " + merchant + " store has been completed.");
        }

        public void refund() {
            System.out.println("The refund for the" +  merchant + "store purchase has been processed");
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public String getMerchant() {
            return merchant;
        }

        public void setMerchant(String merchant) {
            this.merchant = merchant;
        }

}
