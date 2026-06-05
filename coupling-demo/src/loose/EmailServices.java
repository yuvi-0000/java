package loose;

public class EmailServices implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("sent by email : "+message );
    }
}
