package LabN2;

public class Letter extends PostItem {
    private String envelopeType; // тип конверта
    private int pages;
    private boolean urgent; // насколько срочно

    public Letter(double weight, double distance, double baseFee, 
            double weightRate, double distanceRate, double distancePerDay,
            String envelopeType, int pages, boolean urgent) {
        super(weight, distance, baseFee, weightRate, distanceRate, distancePerDay);
        this.envelopeType = envelopeType;
        this.pages = pages;
        this.urgent = urgent;
    }

    public boolean validatePages() {
        return envelopeType != null && !envelopeType.isEmpty() && pages > 0;
    }

    @Override // переопределяем метод
    public boolean validate() {
        return super.validate() && validatePages(); // общие данные родителя и поля письма
    }

    public double calculatePaperCost() {
        if (!checkValid()) {
            return 0;
        }

        return pages * 2.0;
    }

    public double calculateLetterCost() {
        if (!checkValid()) {
            return 0;
        }

        return getFinalCost() + calculatePaperCost() + (urgent ? 50 : 0);
    }

    public String getEnvelopeType() {
        return envelopeType;
    }

    public void setEnvelopeType(String envelopeType) {
        this.envelopeType = envelopeType;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }
}
