package books;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 * TODO : Add your import here
 */

public class BookShopTest {

    /**
     * TODO : Put your test here
     * 
     */
	private BookShop bookStore;
	private final int bookStorePrice = 8;
	private final double scaleFactor = Math.pow(10, 2);

	@BeforeEach
	public void setUp() throws Exception{ 
		  this.bookStore = new BookShop("Harry Poter Book Store", this.bookStorePrice);
	}
	
    @Test
    @DisplayName("1 Unique Book")
    public void uniqueBook(){
    	int [] uniqueBookSet1 = {1,0,0,0,0};
    	int [] uniqueBookSet2 = {0,1,0,0,0};
    	int [] uniqueBookSet3 = {0,0,1,0,0};
    	int [] uniqueBookSet4 = {0,0,0,1,0};
    	int [] uniqueBookSet5  = {0,0,0,0,1};
        assertEquals(8.0,this.bookStore.cost(uniqueBookSet1));
        assertEquals(8.0,this.bookStore.cost(uniqueBookSet2));
        assertEquals(8.0,this.bookStore.cost(uniqueBookSet3));
        assertEquals(8.0,this.bookStore.cost(uniqueBookSet4));
        assertEquals(8.0,this.bookStore.cost(uniqueBookSet5));
    }
    
    
    @Test
    @DisplayName("2 Different Books")
    public void differentBooks1() {
    	double price = 2 * 8 * (1 - 0.07);
    	int [] booksDifferent1 = {1,0,1,0,0};
    	int [] booksDifferent2 = {0,1,0,1,0};
    	int [] booksDifferent3 = {1,1,0,0,0};
    	assertEquals(price,this.bookStore.cost(booksDifferent1));
    	assertEquals(price,this.bookStore.cost(booksDifferent2));
    	assertEquals(price,this.bookStore.cost(booksDifferent3));
    }
    
    @Test
    @DisplayName("3 Different Books")
    public void differentBooks2() {
    	double price = 3 * 8 * (1 - 0.14);
    	int [] booksDifferent1 = {1,1,1,0,0};
    	int [] booksDifferent2 = {0,1,1,1,0};
    	int [] booksDifferent3 = {0,0,1,1,1};
    	int [] booksDifferent4 = {1,0,1,0,1};
    	int [] booksDifferent5 = {0,1,0,1,1};
    	assertEquals(price,this.bookStore.cost(booksDifferent1));
    	assertEquals(price,this.bookStore.cost(booksDifferent2));
    	assertEquals(price,this.bookStore.cost(booksDifferent3));
    	assertEquals(price,this.bookStore.cost(booksDifferent4));
    	assertEquals(price,this.bookStore.cost(booksDifferent5));
    } 
    
    
    @Test
    @DisplayName("4 Different books")
    public void differentBooks3() { 
    	double price = 4 * 8 * (1 - 0.28);
    	int [] booksDifferent1 = {1,1,1,1,0};
    	int [] booksDifferent2 = {0,1,1,1,1};
    	int [] booksDifferent3 = {1,1,0,1,1};
    	assertEquals(price,this.bookStore.cost(booksDifferent1));
    	assertEquals(price,this.bookStore.cost(booksDifferent2));
    	assertEquals(price,this.bookStore.cost(booksDifferent3));
    }
    
    @Test
    @DisplayName("5 Different books")
    public void differentBooks4() { 
    	double price = 5 * 8 * (1 - 0.35);
    	int [] booksDifferent1 = {1,1,1,1,1};
    	assertEquals(price,this.bookStore.cost(booksDifferent1));
    }
    
    @Test
    @DisplayName("3 different books and 2 duplicates")
    public void differentAndDuplicate1() { 
    	double price = 3 * 8 * (1 - 0.14) + 2 * 8;
    	int [] bookSet1 = {1,1,3,0,0};
    	assertEquals(price,this.bookStore.cost(bookSet1));
    }
    
    @Test
    @DisplayName("5 different books and 4 duplicates")
    public void differentAndDuplicate2() { 
    	double price = 5 * 8 * (1 - 0.35) + 4 * 8;
    	int [] bookSet1 = {2,2,2,2,1};
    	assertEquals(price,this.bookStore.cost(bookSet1));
    }
    
    @Test
    @DisplayName("4 different books and 5 duplicates")
    public void differentAndDuplicate3() { 
    	double price = 4 * 8 * (1 - 0.28) + 5 * 8;
    	int [] bookSet1 = {1,5,2,1,0};
    	assertEquals(price,this.bookStore.cost(bookSet1));
    }
    
    @Test
    @DisplayName("Empty book array")
    public void emptyBookArray() { 
    	double price = 0 - 1.0;
    	int [] bookSet1 = {};
    	assertEquals(price,this.bookStore.cost(bookSet1));
    }
    
}