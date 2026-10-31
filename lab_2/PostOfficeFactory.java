package LabN2;

public interface PostOfficeFactory { // методы, которые реализующие его классы должны предоставить
    Letter createLetter();

    Parcel createParcel();

    RegisteredLetter createRegisteredLetter(); // заказное письмо

    String getOfficeName();

    String getCountry();

    boolean validateFactory();
    
}
