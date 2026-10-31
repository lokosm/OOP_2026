package LabN2;

public class StatePostFactory implements PostOfficeFactory {
    private String officeName;
    private String country;
    private double additionalFee; // надбавка доп

    public StatePostFactory(String officeName, String country, double additionalFee) {
        this.officeName = officeName;
        this.country = country;
        this.additionalFee = additionalFee;
    }

    @Override 
    public Letter createLetter() {
        if (!validateFactory()) {
            System.out.println("ошибка. данные гос почты некорректны");
            return null;
        }

        return new Letter(0.2, 400, 50 + additionalFee, 30, 2, 2000, "standard", 3, false);
    }

    @Override 
    public Parcel createParcel() {
        if (!validateFactory()) {
            System.out.println("ошибка. данные гос почты некорректны");
            return null;
        }

        return new Parcel(5, 1200, 50 + additionalFee, 30, 2, 2000, "box", 1000, true);
    }

    @Override 
    public RegisteredLetter createRegisteredLetter() {
        if (!validateFactory()) {
            System.out.println("ошибка. данные гос почты некорректны");
            return null;
        }

        return new RegisteredLetter(0.3, 400, 50 + additionalFee, 30, 2, 200, "st2000", true, 40);
    }

    @Override 
    public boolean validateFactory() {
        return officeName != null && !officeName.trim().isEmpty() && country != null && !country.trim().isEmpty() && Double.isFinite(additionalFee) && additionalFee >= 0;
    }

    @Override 
    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    @Override 
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getAdditionalFee() {
        return additionalFee;
    }

    public void setAdditionalFee(double additionalFee) {
        this.additionalFee = additionalFee;
    }
    

}
