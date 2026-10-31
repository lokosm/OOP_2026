package LabN2;

public class PrivatePostFactory implements PostOfficeFactory {
    private String officeName;
    private String country;
    private double additionalFee;

    public PrivatePostFactory(String officeName, String country, double additionalFee) {
        this.officeName = officeName;
        this.country = country;
        this.additionalFee = additionalFee;
    }

    @Override 
    public Letter createLetter() {
        if (!validateFactory()) {
            System.out.println("ошибка. данные частной почты некорректны");
            return null;
        }

        return new Letter(0.2, 400, 100 + additionalFee, 50, 3, 400, "plastic", 3, true);
    }

    @Override 
    public Parcel createParcel() {
        if (!validateFactory()) {
            System.out.println("ошибка. данные частной почты некорректны");
            return null;
        }

        return new Parcel(5, 1200, 100 + additionalFee, 50, 3, 400, "box", 1000, true);
    }
    
    @Override 
    public RegisteredLetter createRegisteredLetter() {
        if (!validateFactory()) {
            System.out.println("ошибка. данные частной почты некорректны");
            return null;
        }

        return new RegisteredLetter(0.3, 400, 100 + additionalFee, 50, 3, 400, "pr2000", true, 60);
    }

    @Override
    public boolean validateFactory() {
        return officeName != null && !officeName.trim().isEmpty() &&
                country != null && !country.trim().isEmpty() && Double.isFinite(additionalFee) && additionalFee >= 0 ;
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
