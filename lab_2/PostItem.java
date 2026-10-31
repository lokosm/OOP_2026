package LabN2;

public abstract class PostItem { // непосредственно создать объект PostalItem нельзя
    protected double weight;
    protected double distance;
    protected double baseFee; // базовый тариф
    protected double weightRate;
    protected double distanceRate;
    protected double distancePerDay; // условное расстояние за день

    public PostItem(double weight, double distance, double baseFee,
                    double weightRate, double distanceRate, double distancePerDay) {
                        this.weight = weight;
                        this.distance = distance;
                        this.baseFee = baseFee;
                        this.weightRate = weightRate;
                        this.distanceRate = distanceRate;
                        this.distancePerDay = distancePerDay; 
    }

    public boolean validate() {
        return Double.isFinite(weight) && weight > 0 &&
        Double.isFinite(distance) && distance > 0 &&
        Double.isFinite(baseFee) && baseFee > 0 &&
        Double.isFinite(weightRate) && weightRate > 0 &&
        Double.isFinite(distanceRate) && distanceRate > 0 &&
        Double.isFinite(distancePerDay) && distancePerDay > 0;
    }

    protected boolean checkValid() { // позволяет использовать поля и методы в дочерних классах
        if (!validate()) {
            System.out.println("ошибка. недопустимые данные отправления");
            return false;
        }

        return true;
    }
    
    public double calculateDeliveryCost() {
        if (!checkValid()) {
            return 0;
        }

        return baseFee + weight * weightRate + distance * distanceRate;
    }

    public int calculateDeliveryDays() {
        if (!checkValid()) {
            return 0;
        }

        if (distance == 0) {
            return 0;
        }

        return (int) Math.ceil(distance / distancePerDay);
    }

    public double calculateDiscount() { 
        if (!checkValid()) {
            return 0;
        }

        return distance > 1000 ? 0.10 : 0.0; // больше 1000 км - скидка
    }

    public boolean isExpressDeliveryAvailable() {
        return validate() && distance <= 500 && weight <= 10;
    }

    public double getFinalCost() {
        if (!checkValid()) {
            return 0;
        }

        double cost = baseFee + weight * weightRate + distance * distanceRate;
        double discount = distance > 1000 ? 0.10 : 0.0;

        return cost * (1 - discount);
    }

    public void printInfo() {
        if (!checkValid()) {
            return;
        }

        System.out.println("вес (кг): " + weight);
        System.out.println("расстояние (км) : " + distance);
        System.out.println("стоимость: " + getFinalCost());
        System.out.println("срок доставки (дни): " + calculateDeliveryDays());
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(double baseFee) {
        this.baseFee = baseFee;
    }

    public double getWeightRate() {
        return weightRate;
    }

    public void setWeightRate(double weightRate) {
        this.weightRate = weightRate;
    }

    public double getDistanceRate() {
        return distanceRate;
    }

    public void setDistanceRate(double distanceRate) {
        this.distanceRate = distanceRate;
    }

    public double getDistancePerDay() {
        return distancePerDay;
    }

    public void setDistancePerDay(double distancePerDay) {
        this.distancePerDay = distancePerDay;
    } 
}
