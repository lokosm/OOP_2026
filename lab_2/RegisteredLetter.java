package LabN2;

public class RegisteredLetter extends PostItem {
    private  String trackingNumber;
    private boolean signatureRequired; // нужна ли подпись
    private double registrationFee; // регистрационный сбор

    public RegisteredLetter(double weight, double distance, double baseFee, 
        double weightRate, double distanceRate, double distancePerDay,
        String trackingNumber, boolean signatureRequired, double registrationFee) {
            super(weight, distance, baseFee, weightRate, distanceRate, distancePerDay);
            this.trackingNumber = trackingNumber;
            this.signatureRequired = signatureRequired;
            this.registrationFee = registrationFee;
        }

        @Override 
        public boolean validate() {
            return super.validate() && trackingNumber != null &&
                        !trackingNumber.isEmpty() && Double.isFinite(registrationFee) &&
                        registrationFee >= 0;
        }

        public double calculateRegistrationCost() {
            if (!checkValid()) {
                return 0;
            }

            return registrationFee;
        }

        public boolean isTrackingAvailable() {
            return trackingNumber != null && !trackingNumber.isEmpty();
        }

        public double calculateRegistretedLetterCost() {
            if (!checkValid()) {
                return 0;
            }

            return getFinalCost() + calculateRegistrationCost() + (signatureRequired ? 25 : 0);
        }

        public String getTrackingNumber() {
            return trackingNumber;
        }

        public void setTrackingNumber(String trackingNumber) {
            this.trackingNumber = trackingNumber;
        }

        public boolean isSignatureRequired() {
            return signatureRequired;
        }

        public void setSignatureRequired(boolean signatureRequired) {
            this.signatureRequired = signatureRequired;
        }

        public double getRegistrationFee() {
            return registrationFee;
        }

        public void setRegistrationFee(double registrationFee) {
            this.registrationFee = registrationFee;
        }
}
