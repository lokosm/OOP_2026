class main {
    public static void main(String[] args) {
        CardTransaction transaction= new CardTransaction(1, 
            2000.0, 
            "01.10.2026", 
            "new", 
            "000000000000001", 
            "bank A", 
            2.5, 
            "123456789", 
            "visa", 
            "Apple");
        
        System.out.println("transaction information ");
        transaction.printInfo();

        System.out.println();

        System.out.println("banking information ");
        transaction.printBankDetails();

        System.out.println();

        System.out.println("commission calculation ");
        double commission = transaction.calculateCommission();
        System.out.println("commission amount: " + commission);

        System.out.println();

        System.out.println("card transactions ");
        transaction.authorizeCard();
        transaction.pay();


        System.out.println();

        System.out.println("refund");
        transaction.refund();


        System.out.println();

        System.out.println("transaction cancellation");
        transaction.cancel();

        System.out.println();

        System.out.println("final information");
        transaction.printInfo();
    }
    
}
