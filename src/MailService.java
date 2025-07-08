public class MailService {
    public static void sendMail(int quantity,String email,String title) {
        System.out.println("Quantum book store: Sent an email with the book \"" + title + "\" (quantity: " + quantity + ") to: " + email);
    }
}
