import java.time.LocalDate;
import java.util.List;

public class Test {
    private static QuantumBookstore bookstore;

    public Test() {
        this.bookstore = new QuantumBookstore();
    }

    // Test adding valid books
    public static void testAddValidBooks() {
        System.out.println("=== Testing Add Valid Books ===");

        try {
            PaperBook paperBook = new PaperBook("PB001", "Java Programming",
                    LocalDate.of(2020, 1, 15), 29.99, 50);
            bookstore.addBook(paperBook);

            EBook eBook = new EBook("EB001", "Python for Beginners",
                    LocalDate.of(2021, 5, 10), 19.99, "PDF");
            bookstore.addBook(eBook);

            ShowcaseBook showcaseBook = new ShowcaseBook("SB001", "Advanced Algorithms",
                    LocalDate.of(2022, 3, 20), 45.00);
            bookstore.addBook(showcaseBook);

            System.out.println(" All valid books added successfully");
        } catch (Exception e) {
            System.out.println(" Error adding valid books: " + e.getMessage());
        }
    }

    // Test adding duplicate ISBN
    public static void testAddDuplicateISBN() {
        System.out.println("\n=== Testing Add Duplicate ISBN ===");

        try {
            PaperBook duplicate = new PaperBook("PB001", "Duplicate Book",
                    LocalDate.of(2023, 1, 1), 25.00, 10);
            bookstore.addBook(duplicate);
            System.out.println("Should have thrown exception for duplicate ISBN");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught duplicate ISBN: " + e.getMessage());
        }
    }

    // Test buying paper book with valid quantity
    public static void testBuyPaperBookValid() {
        System.out.println("\n=== Testing Buy Paper Book (Valid) ===");

        try {
            double cost = bookstore.buyBook("PB001", 2, "customer@example.com", "123 Main St");
            System.out.println("Paper book purchase successful. Cost: $" + cost);
        } catch (Exception e) {
            System.out.println("Error buying paper book: " + e.getMessage());
        }
    }

    // Test buying paper book with insufficient quantity
    public static void testBuyPaperBookInsufficientStock() {
        System.out.println("\n=== Testing Buy Paper Book (Insufficient Stock) ===");

        try {
            double cost = bookstore.buyBook("PB001", 100, "customer@example.com", "123 Main St");
            System.out.println("Should have thrown exception for insufficient stock");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught insufficient stock: " + e.getMessage());
        }
    }

    // Test buying EBook
    public static void testBuyEBook() {
        System.out.println("\n=== Testing Buy EBook ===");

        try {
            double cost = bookstore.buyBook("EB001", 3, "customer@example.com", "123 Main St");
            System.out.println("EBook purchase successful. Cost: $" + cost);
        } catch (Exception e) {
            System.out.println("Error buying EBook: " + e.getMessage());
        }
    }

    // Test buying showcase book (should fail)
    public static void testBuyShowcaseBook() {
        System.out.println("\n=== Testing Buy Showcase Book ===");

        try {
            double cost = bookstore.buyBook("SB001", 1, "customer@example.com", "123 Main St");
            System.out.println("Should have thrown exception for showcase book");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly prevented showcase book purchase: " + e.getMessage());
        }
    }

    // Test buying non-existent book
    public static void testBuyNonExistentBook() {
        System.out.println("\n=== Testing Buy Non-Existent Book ===");

        try {
            double cost = bookstore.buyBook("INVALID", 1, "customer@example.com", "123 Main St");
            System.out.println("Should have thrown exception for non-existent book");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught non-existent book: " + e.getMessage());
        }
    }

    // Test removing outdated books
    public static void testRemoveOutdatedBooks() {
        System.out.println("\n=== Testing Remove Outdated Books ===");

        // Add old books for testing
        try {
            PaperBook oldBook1 = new PaperBook("OLD001", "Ancient Programming",
                    LocalDate.of(2015, 1, 1), 15.00, 5);
            bookstore.addBook(oldBook1);

            EBook oldBook2 = new EBook("OLD002", "Vintage Web Design",
                    LocalDate.of(2010, 6, 15), 12.00, "HTML");
            bookstore.addBook(oldBook2);

            ShowcaseBook oldShowcase = new ShowcaseBook("OLD003", "Historical Computing",
                    LocalDate.of(2005, 12, 1), 30.00);
            bookstore.addBook(oldShowcase);

            System.out.println("Added old books for testing");
        } catch (Exception e) {
            System.out.println("Error adding old books: " + e.getMessage());
        }

        // Remove books older than 5 years
        List<Book> removedBooks = bookstore.removeBook(5);
        System.out.println(" Removed " + removedBooks.size() + " outdated books:");
        for (Book book : removedBooks) {
            System.out.println("  - " + book.getTitle() + " (Published: " + book.getPublishDate() + ")");
        }
    }

    // Test removing books with no outdated inventory
    public static void testRemoveNoOutdatedBooks() {
        System.out.println("\n=== Testing Remove Books (No Outdated) ===");

        List<Book> noRemovedBooks = bookstore.removeBook(2);
        System.out.println(" Removed " + noRemovedBooks.size() + " books (should be 0 for recent books)");
    }

    // Test removing books from empty inventory
    public static void testRemoveFromEmptyInventory() {
        System.out.println("\n=== Testing Remove From Empty Inventory ===");

        QuantumBookstore emptyBookstore = new QuantumBookstore();
        List<Book> removedBooks = emptyBookstore.removeBook(10);
        System.out.println(" Removed " + removedBooks.size() + " books from empty inventory (should be 0)");
    }

    // Test edge cases with zero quantity
    public static void testBuyZeroQuantity() {
        System.out.println("\n=== Testing Buy Zero Quantity ===");

        try {
            double cost = bookstore.buyBook("PB001", 0, "customer@example.com", "123 Main St");
            System.out.println(" Zero quantity purchase cost: $" + cost);
        } catch (Exception e) {
            System.out.println(" Error with zero quantity: " + e.getMessage());
        }
    }

    // Test with null/empty parameters
    public static void testBuyWithNullParameters() {
        System.out.println("\n=== Testing Buy With Null Parameters ===");

        try {
            double cost = bookstore.buyBook("PB001", 1, null, "123 Main St");
            System.out.println(" Purchase with null email successful: $" + cost);
        } catch (Exception e) {
            System.out.println("Note: Purchase with null email caused: " + e.getMessage());
        }

        try {
            double cost = bookstore.buyBook("PB001", 1, "customer@example.com", null);
            System.out.println(" Purchase with null address successful: $" + cost);
        } catch (Exception e) {
            System.out.println("Note: Purchase with null address caused: " + e.getMessage());
        }
    }

    // Test book getters
    public static void testBookGetters() {
        System.out.println("\n=== Testing Book Getters ===");

        PaperBook testBook = new PaperBook("TEST001", "Test Book",
                LocalDate.of(2023, 6, 1), 25.99, 10);

        System.out.println(" ISBN: " + testBook.getISBN());
        System.out.println(" Title: " + testBook.getTitle());
        System.out.println(" Publish Date: " + testBook.getPublishDate());
        System.out.println(" Price: $" + testBook.getPrice());
        System.out.println(" Quantity: " + testBook.getQuantity());
    }

    // Test multiple purchases reducing stock
    public static void testMultiplePurchasesReduceStock() {
        System.out.println("\n=== Testing Multiple Purchases Reduce Stock ===");

        try {
            // Add a book with limited stock
            PaperBook limitedStock = new PaperBook("LIMITED001", "Limited Edition",
                    LocalDate.of(2023, 1, 1), 99.99, 5);
            bookstore.addBook(limitedStock);

            // First purchase
            double cost1 = bookstore.buyBook("LIMITED001", 2, "customer1@example.com", "123 Main St");
            System.out.println(" First purchase successful. Cost: $" + cost1);

            // Second purchase
            double cost2 = bookstore.buyBook("LIMITED001", 2, "customer2@example.com", "456 Oak Ave");
            System.out.println(" Second purchase successful. Cost: $" + cost2);

            // Third purchase (should exceed remaining stock)
            try {
                double cost3 = bookstore.buyBook("LIMITED001", 2, "customer3@example.com", "789 Pine Rd");
                System.out.println(" Should have failed due to insufficient stock");
            } catch (IllegalArgumentException e) {
                System.out.println(" Correctly prevented overselling: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(" Error in multiple purchases test: " + e.getMessage());
        }
    }
}
