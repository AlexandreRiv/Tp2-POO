public class PushNotificationSender implements Sender {
    @Override
    public void send(String message) {
        System.out.println("Notification push envoyée : " + message);
    }
}
