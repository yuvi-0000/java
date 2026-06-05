package loose;

public class UserService {
    NotificationService notificationService;

    public UserService(NotificationService notificationService){
        this.notificationService = notificationService;
    }
    public void NotifyUser(String message){
        notificationService.send("notification hello!");
    }
}
