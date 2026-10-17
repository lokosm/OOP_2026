// доставка (авто, авиа и жд)

interface IDelivery {
    void deliver(String box);
}

abstract class DeliveryService {
    protected abstract IDelivery createDelivery();

    public void deliver(String box) {
        IDelivery deliver = createDelivery();
        deliver.deliver(box);
    }
}

final class CarDelivery extends DeliveryService {
    @Override 
    protected IDelivery createDelivery() {
        return b -> System.out.println("Car delivery: " + b);
    }
}
final class TrainDelivery extends DeliveryService {
    @Override 
    protected IDelivery createDelivery() {
        return b -> System.out.println("Train delivery: " + b);
    }
}
final class AirDelivery extends DeliveryService {
    @Override 
    protected IDelivery createDelivery() {
        return b -> System.out.println("Air delivery: " + b);
    }
}
public class main1 {
    public static void main(String[] args) {
        DeliveryService service;
        if (args.length == 0) {
            System.out.println(" Choice delivery: ");
            return;
        }
        

        if (args[0].equals("train")) {
            service = new TrainDelivery();
        } else if (args[0].equals("air")) {
            service = new AirDelivery();
        } else if (args[0].equals("car")) {
            service = new CarDelivery();
        } else {
            System.out.println("Unknown delivery type");
            return;
        }

        service.deliver("box №1");
    }
}
