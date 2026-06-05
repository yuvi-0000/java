import loose.EmailServices;
import loose.NotificationService;
import loose.SMSservice;
import tight.UserService;

public class AppMain {
    public static void main(String[] args) {
        //tight
        UserService userService = new UserService();
        userService.notifyUser("order placed!");
        //loose
        NotificationService emailService = new EmailServices();
        NotificationService smsService = new SMSservice();
        loose.UserService userServiceLoose = new loose.UserService(smsService);
        userServiceLoose.NotifyUser("ordered!!!");
    }
}
