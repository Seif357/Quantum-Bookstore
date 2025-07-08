import java.time.LocalDate;

public class EBook extends Book implements Buyable {
    private final String fileType;

    public EBook(String ISBN, String title, LocalDate publishDate, Double price, String fileType) {
        super(ISBN, title, publishDate, price);
        this.fileType = fileType;
    }
    @Override
    public double buyBook(int quantity,String email, String address) {
        MailService.sendMail(quantity,email,this.getTitle());
        return this.getPrice()*quantity;
    }
}
