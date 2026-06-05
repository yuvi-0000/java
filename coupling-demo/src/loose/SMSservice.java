package loose;

public class SMSservice implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("this is SMS :"+message);
    }
}
