package tight;

public class UserService {
    NotificationService notificationService = new NotificationService();
    public void notifyUser(String meassge){
        System.out.println("Notification Hello!");
    }
}
