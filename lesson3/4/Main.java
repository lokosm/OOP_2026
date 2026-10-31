// Интерфейс компонента
interface Notification {
    String getDescription();
    double getCost();
}

// Конкретный компонент (базовое уведомление по почте)
public class EmailNotification implements Notification {
    @Override
    public String getDescription() {
        return "Email-уведомление";
    }

    @Override
    public double getCost() {
        return 0.05;
    }
}

// Абстрактный декоратор
public abstract class NotificationDecorator implements Notification {
    protected final Notification notification;

    public NotificationDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public String getDescription() {
        return notification.getDescription();
    }
}

//Конкретный декоратор 1 (добавление уведомления по телефону)
public class PhoneNotification extends NotificationDecorator {
    public PhoneNotification(Notification notification) {
        super(notification);
    }

    @Override
    public String getDescription() {
        return notification.getDescription() + ", по телефону";
    }

    @Override
    public double getCost() {
        return notification.getCost() + 0.20;
    }
}

// Конкретный декоратор 2 (добавление уведомления в мессенджер)
public class MessengerNotification extends NotificationDecorator {
    public MessengerNotification(Notification notification) {
        super(notification);
    }

    @Override
    public String getDescription() {
        return notification.getDescription() + ", в мессенджер";
    }

    @Override
    public double getCost() {
        return notification.getCost() + 0.10;
    }
}

public class Main {
    public static void main(String[] args) {
        Notification email = new EmailNotification();
        System.out.println(email.getDescription() + " стоит " + 
            email.getCost());

        Notification emailWithPhone = new PhoneNotification(email);
        System.out.println(emailWithPhone.getDescription() + " стоит " + 
            emailWithPhone.getCost());

        Notification fullNotification = new PhoneNotification(new MessengerNotification(email));
        System.out.println(fullNotification.getDescription() + " стоит " + 
            fullNotification.getCost());
    }
}
