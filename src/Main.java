public class Main {
    public static void main(String[] args) {

        Test.testAddValidBooks();
        Test.testAddDuplicateISBN();
        Test.testBuyPaperBookValid();
        Test.testBuyPaperBookInsufficientStock();
        Test.testBuyEBook();
        Test.testBuyShowcaseBook();
        Test.testBuyNonExistentBook();
        Test.testRemoveOutdatedBooks();
        Test.testRemoveNoOutdatedBooks();
        Test.testRemoveFromEmptyInventory();
        Test.testBuyZeroQuantity();
        Test.testBuyWithNullParameters();
        Test.testBookGetters();
        Test.testMultiplePurchasesReduceStock();
    }
}