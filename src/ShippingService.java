public class ShippingService {
    public static void ship(int quantity, String address,String title,double price)
    {
        System.out.println("Quantum book store: Shipped the book \"" + title + "\" (quantity: " + quantity + ") to address: " + address+" with the price of "+ price + ".");
    }
}
