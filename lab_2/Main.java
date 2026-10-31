package LabN2;

public class Main {
    private PostOfficeFactory factory;
    private Letter letter;
    private Parcel parcel;
    private RegisteredLetter registeredLetter;

    public static void main(String[] args) {
        Main program = new Main();
        program.run(args); // зпуск 
    }

    private void run(String[] args) { // порядок выполнения программы
        if (!createFactory(args)) {
            return;
        }

        letter = factory.createLetter();
        parcel = factory.createParcel();
        registeredLetter = factory.createRegisteredLetter();

        if (letter == null || parcel == null || registeredLetter == null) {
            System.out.println("ошибка создания почтовых отправлений");
            return;
        }

        if (letter == null || !letter.validate()) {
            System.out.println("ошибка. некорректные данные письма");
            return;
        }

        if (parcel == null || !parcel.validate()) {
            System.out.println("ошибка. некорректные данные посылки");
            return;
        }

        if (registeredLetter == null || !registeredLetter.validate()) {
            System.out.println("ошибка. некорректные данные заказного письма");
            return;
        }

        System.out.println("почтовое отделение: " + factory.getOfficeName());
        System.out.println("страна: " + factory.getCountry());

        printLetterInfo();
        printParcelInfo();
        printRegisteredLetterInfo();
    }

    private boolean createFactory(String[] args) {
        if (args.length > 1) {
            return false;
        }

        if (args.length == 0 || args[0].equalsIgnoreCase("state")) {
            factory = new StatePostFactory(
                    "Государственная почта", "Россия", 0);
        } else if (args[0].equalsIgnoreCase("private")) {
            factory = new PrivatePostFactory(
                    "Частная почта", "Россия", 0);
        } else {
            System.out.println("Ошибка: укажите state или private.");
            return false;
        }

        if (!factory.validateFactory()) {
            System.out.println("Ошибка: некорректные данные почтового отделения.");
            return false;
        }

        return true;
    }

    private void printLetterInfo() {
        System.out.println("\nПисьмо:");
        letter.printInfo();
        System.out.println("Тип конверта: " + letter.getEnvelopeType());
        System.out.println("Количество страниц: " + letter.getPages());
        System.out.println("Итоговая стоимость: "
                + letter.calculateLetterCost());
    }

    private void printParcelInfo() {
        System.out.println("\nПосылка:");
        parcel.printInfo();
        System.out.println("Упаковка: " + parcel.getPackagingType());
        System.out.println("Хрупкая: " + parcel.isFragile());
        System.out.println("Итоговая стоимость: " + parcel.calculateParceCost());
    }

    private void printRegisteredLetterInfo() {
        System.out.println("\nЗаказное письмо:");
        registeredLetter.printInfo();
        System.out.println("Номер отслеживания: "
                + registeredLetter.getTrackingNumber());
        System.out.println("Итоговая стоимость: "
                + registeredLetter.calculateRegistretedLetterCost());
    }

    public PostOfficeFactory getFactory() {
        return factory;
    }

    public void setFactory(PostOfficeFactory factory) {
        this.factory = factory;
    }

    public Letter getLetter() {
        return letter;
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public RegisteredLetter getRegisteredLetter() {
        return registeredLetter;
    }

    public void setRegisteredLetter(RegisteredLetter registeredLetter) {
        this.registeredLetter = registeredLetter;
    }
}
 