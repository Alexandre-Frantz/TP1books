package books;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class BookShop {

	private final String bookShopName;
	private int bookPrice;

	/**
	 * Constructor of the class Book shop
	 * @param bookShopName name of the book shop
	 * @param bookPrice price of a book
	 */
	public BookShop(String bookShopName, int bookPrice){
		this.bookShopName = bookShopName;
		this.bookPrice = bookPrice;
	}
	
	/**
	 * method to compute the cost of a basket
	 * <p> Example basket = {1,2,3,0,0} </p> 
	 * @param books array corresponding to the number of each harry potter book the client desire to buy (books.length should return 5)
	 * @return the cost in euro with the discount
	 * 
	 */
	public double cost(int [] books){
		
		int bookLength = books.length; // length of array containing purchased books
		
		double discount = 0.0; // discount applied to purchase
		double scale = Math.pow(10, 2); // used to round 2 decimals after the .
		
		int uniqueBooks = 0; // number of different books
		
		int totalBooks = IntStream.of(books).sum(); // total amount of books to be bought
		
		if(bookLength == 5) {
			for(int i = 0; i < bookLength; i++) {
				if(books[i] > 0) {
					++uniqueBooks;
				}
			}
			
			switch(uniqueBooks) { 
			case 2:
				discount = (uniqueBooks * this.bookPrice * 0.07 ); 
				System.out.println("Discount: " + discount);
				break;
			case 3:
				discount = (uniqueBooks * this.bookPrice * 0.14 );
				System.out.println("Discount: " + discount);
				break;
			case 4:
				discount = (uniqueBooks * this.bookPrice * 0.28 );
				System.out.println("Discount: " + discount);
				break;
			case 5:
				discount = (uniqueBooks * this.bookPrice * 0.35 );
				System.out.println("Discount: " + discount);
				break;

			}

		}else {
			System.out.println("Book array is contains more or less entries than the supposed 5");
			return - 1.0;
		}
		return this.bookPrice * totalBooks - discount;
	}
}
