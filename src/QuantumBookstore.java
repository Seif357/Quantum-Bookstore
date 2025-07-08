import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuantumBookstore {
    private HashMap<String, Book> inventory;
    public QuantumBookstore() {
        inventory = new HashMap<>();
    }
    public void addBook(Book object) {
        if (inventory.containsKey(object.getISBN())) {
            throw new IllegalArgumentException("Book already exists");
        }
        else
        {
            inventory.put(object.getISBN(), object);
            System.out.println("Quantum book store: Book added successfully");
        }
    }
    public List<Book> removeBook(int yearPeriod) {
        List<Book> books = new ArrayList<>();
        if (inventory.isEmpty()){
            return books;
            }
        else {
            for (Book book : inventory.values()) {
                if(book.getPublishDate().isBefore(LocalDate.now().minusYears(yearPeriod)))
                {
                    books.add(book);
                }
            }
        }
        for (Book book : books) {
            inventory.remove(book.getISBN());
        }
        return books;
    }
    public double buyBook(String ISBN,int quantity, String email,String address) {
        Book book = inventory.get(ISBN);
        if(book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        else if(book instanceof Buyable) {
            return ((Buyable) book).buyBook(quantity,email,address);
        }
        else {
            throw new IllegalArgumentException("Book is not a Buyable");
        }
    }
}
