package LabN2;

public class Parcel extends PostItem {
    private String packagingType;
    private double insuredValue; // страховка
    private boolean fragile; // хрупкость

    public Parcel(double weight, double distance, double baseFee,
                double weightRate, double distanceRate, double distancePerDay, 
                String packagingType, double insuredValue, boolean fragile) {
        super(weight, distance, baseFee, weightRate, distanceRate, distancePerDay);
        this.packagingType = packagingType;
        this.insuredValue = insuredValue;
        this.fragile = fragile;
    }

    @Override // переопределяем метод 
    public boolean validate() {
        return super.validate() && packagingType != null &&
                !packagingType.isEmpty() &&
                Double.isFinite(insuredValue) && insuredValue >= 0;
    }

    public double calculatePackagingCost() {
        if (!checkValid()) {
            return 0;
        }

        if (packagingType.equals("box")) { // сравнивает текст без учёта регистра
            return 100;
        }

        if (packagingType.equals("envelope")) {
            return 20;
        }

        return 50;
    }

    public double calculateInsuranceCost() {
        if (!checkValid()) {
            return 0;
        }

        return insuredValue * 0.02;
    }

    public double calculateParceCost() {
        if (!checkValid()) {
            return 0;
        }

        return getFinalCost() + calculatePackagingCost() + calculateInsuranceCost() + (fragile ? 30 : 0);
    }

    public String getPackagingType() {
        return packagingType;
    }

    public void setPackagingType(String packagingType) {
        this.packagingType = packagingType;
    }

    public double getInsuredValue() {
        return insuredValue;
    }

    public void setInsuredValue(double insuredValue) {
        this.insuredValue = insuredValue;
    }

    public boolean isFragile() {
        return fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }   
}
