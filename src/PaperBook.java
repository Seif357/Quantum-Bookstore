import java.time.LocalDate;

public class PaperBook extends Book implements Buyable {
    private int quantity;
    public PaperBook(String ISBN, String title, LocalDate publishDate, Double price,int quantity) {
        super(ISBN, title, publishDate, price);
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    @Override
    public double buyBook(int quantity,String address, String Address) {
        if(this.quantity >= quantity) {
            this.quantity -= quantity;
        }
        else {
            throw new IllegalArgumentException("Not enough books in stock. Available: " + this.quantity);
        }
        ShippingService.ship(quantity,address,this.getTitle(),this.getPrice()*quantity);
        return this.getPrice()*quantity;
    }
}
