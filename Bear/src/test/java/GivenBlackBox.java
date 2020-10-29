import main.java.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import main.java.BearWorkshop;
import static org.junit.Assert.*;

/***
 * This class provides a framework to implement black box tests for various
 * implementations of the BearWorkshop Class. The BearWorkshop is having a
 * blowout sale and is offering the following savings.
 *
 * Bears are Buy 2 bears, get 1 free. It is 10% off the cost of a bear when a
 * single bear has 10 or more accessories (Note that embroidery, stuffing, and
 * the material used for the bear casing is not considered an accessory).
 * Additionally, clothes are buy 2, get one free on each bear.
 */
@RunWith(Parameterized.class)
public class GivenBlackBox {
    private Class<BearWorkshop> classUnderTest;

    @SuppressWarnings("unchecked")
    public GivenBlackBox(Object classUnderTest) {
        this.classUnderTest = (Class<BearWorkshop>) classUnderTest;
    }

    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = {
                {BearWorkshop.class},
                {BearWorkshop.class},
                {BearWorkshop.class},
                {BearWorkshop.class},
                {BearWorkshop.class}

        };
        return Arrays.asList(classes);
    }

    private BearWorkshop createBearWorkshop(String name) throws Exception {
        Constructor<BearWorkshop> constructor = classUnderTest.getConstructor(String.class);
        return constructor.newInstance(name);
    }

    BearWorkshop oneBear;
    Double oneBearExpected;

    BearWorkshop threeBears;
    Double threeBearsExpected;

    BearWorkshop twoBears;
    Double twoBearsExpected;
    
    BearWorkshop twoBearsSamePrice;
    Double twoBearsSamePriceExpected;
    
    BearWorkshop threeBearsSamePrice;
    Double threeBearsSamePriceExpected;
    
    BearWorkshop fourBears;
    Double fourBearsExpected;
    
    BearWorkshop fourBearsSamePrice;
    Double fourBearsSamePriceExpected;
    
    BearWorkshop fiveBears;
    Double fiveBearsExpected;
    
    BearWorkshop fiveBearsSamePrice;
    Double fiveBearsSamePriceExpected;
    
    BearWorkshop sixBears;
    Double sixBearsExpected;
    
    BearWorkshop sevenBears;
    Double sevenBearsExpected;
   

    @Before
    public void setUp() throws Exception {

        // One Bear base stuffing, no saving expected
        oneBear = createBearWorkshop("NY");
        oneBear.addBear(new Bear(Stuffing.stuffing.BASE));
        oneBearExpected = 0.00; 
        
        // Three Bears expected to not pay for cheapest one
        threeBears = createBearWorkshop("AZ");
        threeBears.addBear(new Bear(Stuffing.stuffing.BASE));
        threeBears.addBear(new Bear(Stuffing.stuffing.DOWN));
        threeBears.addBear(new Bear(Stuffing.stuffing.FOAM));
        threeBearsExpected = 30.00;
        
        // Three bears of the same price, third should be free
        threeBearsSamePrice = createBearWorkshop("AZ");
        threeBearsSamePrice.addBear(new Bear(Stuffing.stuffing.FOAM));
        threeBearsSamePrice.addBear(new Bear(Stuffing.stuffing.FOAM));
        threeBearsSamePrice.addBear(new Bear(Stuffing.stuffing.FOAM));
        threeBearsSamePriceExpected = 50.00;
        
        // Two bears of different prices, no savings expected.  
        // Boundary case before savings should kick in
        twoBears = createBearWorkshop("AZ");
        twoBears.addBear(new Bear(Stuffing.stuffing.BASE));
        twoBears.addBear(new Bear(Stuffing.stuffing.DOWN));
        twoBearsExpected = 0.0;
        
        // Two bears of the same price, no savings expected.  
        // Boundary case before savings should kick in 
        twoBearsSamePrice = createBearWorkshop("AZ");
        twoBearsSamePrice.addBear(new Bear(Stuffing.stuffing.BASE));
        twoBearsSamePrice.addBear(new Bear(Stuffing.stuffing.BASE));
        twoBearsSamePriceExpected = 0.0;
        
        // Four bears of varying prices, savings of cheapest single bear expected - $30.00.  
        // Boundary case after savings should have kicked in
        fourBears = createBearWorkshop("AZ");
        fourBears.addBear(new Bear(Stuffing.stuffing.BASE));
        fourBears.addBear(new Bear(Stuffing.stuffing.FOAM));
        fourBears.addBear(new Bear(Stuffing.stuffing.DOWN));
        fourBears.addBear(new Bear(Stuffing.stuffing.DOWN));
        fourBearsExpected = 30.00;
        
        // Four bears of the same price, savings of cheapest single bear expected - $30.00.  
        // Boundary case after savings should have kicked in
        fourBearsSamePrice = createBearWorkshop("AZ");
        fourBearsSamePrice.addBear(new Bear(Stuffing.stuffing.BASE));
        fourBearsSamePrice.addBear(new Bear(Stuffing.stuffing.BASE));
        fourBearsSamePrice.addBear(new Bear(Stuffing.stuffing.BASE));
        fourBearsSamePrice.addBear(new Bear(Stuffing.stuffing.BASE));
        fourBearsSamePriceExpected = 30.00;
        
        // Five bears of varying prices, savings of cheapest single bear expected - $30.00.  
        // Boundary case before second savings should kick in
        fiveBears = createBearWorkshop("AZ");
        fiveBears.addBear(new Bear(Stuffing.stuffing.BASE));
        fiveBears.addBear(new Bear(Stuffing.stuffing.FOAM));
        fiveBears.addBear(new Bear(Stuffing.stuffing.DOWN));
        fiveBears.addBear(new Bear(Stuffing.stuffing.BASE));
        fiveBears.addBear(new Bear(Stuffing.stuffing.DOWN));
        fiveBearsExpected = 30.00;
        
        // Five bears of the same price, savings of cheapest single bear expected - $30.00.  
        // Boundary case before second savings should kick in
        fiveBearsSamePrice = createBearWorkshop("AZ");
        fiveBearsSamePrice.addBear(new Bear(Stuffing.stuffing.BASE));
        fiveBearsSamePrice.addBear(new Bear(Stuffing.stuffing.BASE));
        fiveBearsSamePrice.addBear(new Bear(Stuffing.stuffing.BASE));
        fiveBearsSamePrice.addBear(new Bear(Stuffing.stuffing.BASE));
        fiveBearsSamePrice.addBear(new Bear(Stuffing.stuffing.BASE));
        fiveBearsSamePriceExpected = 30.00;

        
        // Six bears of varying prices, savings of cheapest TWO bears expected - $60.00.  
        // Boundary case exactly when second savings should kick in
        sixBears = createBearWorkshop("AZ");
        sixBears.addBear(new Bear(Stuffing.stuffing.BASE));
        sixBears.addBear(new Bear(Stuffing.stuffing.FOAM));
        sixBears.addBear(new Bear(Stuffing.stuffing.DOWN));
        sixBears.addBear(new Bear(Stuffing.stuffing.BASE));
        sixBears.addBear(new Bear(Stuffing.stuffing.DOWN));
        sixBears.addBear(new Bear(Stuffing.stuffing.FOAM));
        sixBearsExpected = 60.00;

        // Seven bears of varying prices, savings of cheapest TWO bears expected - $60.00.  
        // Boundary case after second savings should have kicked in
        sevenBears = createBearWorkshop("AZ");
        sevenBears.addBear(new Bear(Stuffing.stuffing.BASE));
        sevenBears.addBear(new Bear(Stuffing.stuffing.BASE));
        sevenBears.addBear(new Bear(Stuffing.stuffing.FOAM));
        sevenBears.addBear(new Bear(Stuffing.stuffing.DOWN));
        sevenBears.addBear(new Bear(Stuffing.stuffing.BASE));
        sevenBears.addBear(new Bear(Stuffing.stuffing.DOWN));
        sevenBears.addBear(new Bear(Stuffing.stuffing.FOAM));
        sevenBearsExpected = 60.00;
                
        
    }

    @After
    public void tearDown() throws Exception {
    }


    /**
     * Test examines a BearFactory with 1 simple bear in it. The bear costs $30
     * and there are no savings.
     */
    @Test
    public void oneBearNoSavings() {
        Double ans = oneBear.calculateSavings();
        assertEquals(oneBearExpected, ans);
    }

    /**
     * Test examines a BearFactory with 3 simple bears in it. The bears vary in costs and $30 in savings is expected.
     */
    @Test
    public void threeBearsSaveOnCheapest() {
        Double ans = threeBears.calculateSavings();
        assertEquals(threeBearsExpected, ans);
    }

    
    /**
     * Test examines a BearFactory with 2 simple bears in it. The bears vary in costs and $0 in savings is expected.
     */
    @Test
    public void twoBearsNoSavings() {
        Double ans = twoBears.calculateSavings();
        assertEquals(twoBearsExpected, ans);
    }
    
    /**
     * Test examines a BearFactory with 2 simple bears in it. The bears all cost the same and $0 in savings is expected.
     */
    @Test
    public void twoBearsSamePriceNoSavings() {
        Double ans = twoBearsSamePrice.calculateSavings();
        assertEquals(twoBearsSamePriceExpected, ans);
    }
    
    /**
     * Test examines a BearFactory with 4 simple bears in it. The bears vary in costs and $30 in savings is expected.
     */
    @Test
    public void fourBearsSaveOnCheapest() {
        Double ans = fourBears.calculateSavings();
        assertEquals(fourBearsExpected, ans);
    }
    
    /**
     * Test examines a BearFactory with 4 simple bears in it. The bears all cost the same and $30 in savings is expected.
     */
    @Test
    public void fourBearsSamePriceSaveOnCheapest() {
        Double ans = fourBearsSamePrice.calculateSavings();
        assertEquals(fourBearsSamePriceExpected, ans);
    }
    
    /**
     * Test examines a BearFactory with 5 simple bears in it. The bears vary in costs and $30 in savings is expected.
     */
    @Test
    public void fiveBearsSaveOnCheapest() {
        Double ans = fiveBears.calculateSavings();
        assertEquals(fiveBearsExpected, ans);
    }
    
    /**
     * Test examines a BearFactory with 5 simple bears in it. The bears all cost the same and $30 in savings is expected.
     */
    @Test
    public void fiveBearsSamePriceSaveOnCheapest() {
        Double ans = fiveBearsSamePrice.calculateSavings();
        assertEquals(fiveBearsSamePriceExpected, ans);
    }
    
    /**
     * Test examines a BearFactory with 6 simple bears in it. The bears vary in costs and $60 in savings is expected.
     */
    @Test
    public void sixBearsSaveOnCheapestTwo() {
        Double ans = sixBears.calculateSavings();
        assertEquals(sixBearsExpected, ans);
    }
    
    /**
     * Test examines a BearFactory with 7 simple bears in it. The bears vary in costs and $60 in savings is expected.
     */
    @Test
    public void sevenBearsSaveOnCheapestTwo() {
        Double ans = sevenBears.calculateSavings();
        assertEquals(sevenBearsExpected, ans);
    }
   
    /**
     * Test examines a BearFactory with 1 bear in it. This bear has three pieces of clothing.  
     * Savings of $4 are expected.  
     */
    @Test
    public void oneBearTest3clothingsExpectSaving() {
        BearWorkshop bears = null;
        try {
            bears = createBearWorkshop("DC");
        } catch (Exception e) {
        }
        Bear customBear = new Bear(Stuffing.stuffing.BASE);
        bears.addBear(customBear);

	    customBear.clothing.add(new Clothing(4, "Hat"));
	    customBear.clothing.add(new Clothing(4, "Sunglasses"));
	    customBear.clothing.add(new Clothing(4, "Shoes"));
	    
        Double bearsExpected = 4.0;
        Double ans = bears.calculateSavings();
        assertEquals(bearsExpected, ans, 0.005);
    }
    
    /**
     * Test examines a BearFactory with 3 bears in it. Each bear has one piece of clothing.  
     * Savings of $34 are expected.  
     */
    @Test
    public void threeBearsWithClothingExpectSaving() {
        BearWorkshop bears = null;
        try {
            bears = createBearWorkshop("AZ");
        } catch (Exception e) {
        }
        Bear bear1 = new Bear(Stuffing.stuffing.BASE);
        Bear bear2 = new Bear(Stuffing.stuffing.FOAM);
        Bear bear3 = new Bear(Stuffing.stuffing.DOWN);
        bears.addBear(bear1);
        bears.addBear(bear2);
        bears.addBear(bear3);
	    bear1.clothing.add(new Clothing(4, "Hat"));
	    bear2.clothing.add(new Clothing(4, "Hat"));
	    bear3.clothing.add(new Clothing(4, "Hat"));
	    
        Double expectedSaving = 34.0;
        Double ans = bears.calculateSavings();
        assertEquals(expectedSaving, ans, 0.005);
    }
    
    /**
     * Test examines a BearFactory with 1 bear which has 9 pieces of clothing on.
     * Savings of $12 are expected.  
     */
    @Test
    public void oneBearTest9clothingsExpectSaving() {
        BearWorkshop bears = null;
        try {
            bears = createBearWorkshop("AZ");
        } catch (Exception e) {
        }
        Bear bear1 = new Bear(Stuffing.stuffing.BASE);
        bears.addBear(bear1);

        bear1.clothing.add(new Clothing(4, "Hat"));
        bear1.clothing.add(new Clothing(4, "Sunglasses"));
        bear1.clothing.add(new Clothing(4, "Shoes"));
        bear1.clothing.add(new Clothing(4, "Jordans"));
        bear1.clothing.add(new Clothing(4, "Hoodie"));
        bear1.clothing.add(new Clothing(4, "Socks"));
        bear1.clothing.add(new Clothing(4, "Boxers"));
        bear1.clothing.add(new Clothing(4, "Tshirt"));
        bear1.clothing.add(new Clothing(4, "Pants"));

	    
        Double expectedSavings = 12.0;
        Double ans = bears.calculateSavings();
        assertEquals(expectedSavings, ans, 0.005);
    }
    
    /**
     * Test examines a BearFactory with 1 bear which has 10 pieces of clothing on.
     * Savings of $17.8 are expected.  
     */
    @Test
    public void oneBearTest10clothingsExpectSaving() {
        BearWorkshop bears = null;
        try {
            bears = createBearWorkshop("AZ");
        } catch (Exception e) {
        }
        Bear bear1 = new Bear(Stuffing.stuffing.BASE);
        bears.addBear(bear1);

        bear1.clothing.add(new Clothing(4, "Hat"));
        bear1.clothing.add(new Clothing(4, "Sunglasses"));
        bear1.clothing.add(new Clothing(4, "Shoes"));
        bear1.clothing.add(new Clothing(4, "Jordans"));
        bear1.clothing.add(new Clothing(4, "Hoodie"));
        bear1.clothing.add(new Clothing(4, "Socks"));
        bear1.clothing.add(new Clothing(4, "Boxers"));
        bear1.clothing.add(new Clothing(4, "Tshirt"));
        bear1.clothing.add(new Clothing(4, "Pants"));
        bear1.clothing.add(new Clothing(4, "Jacket"));
	    
        Double expectedSavings = 17.8;
        Double ans = bears.calculateSavings();
        assertEquals(expectedSavings, ans, 0.005);
    }

    /**
     * Test examines a BearFactory with 1 bear which has 11 pieces of clothing on.
     * Savings of $19.4 are expected.  
     */
    @Test
    public void oneBearTest11clothingsExpectSaving() {
        BearWorkshop bears = null;
        try {
            bears = createBearWorkshop("AZ");
        } catch (Exception e) {
        }
        Bear bear1 = new Bear(Stuffing.stuffing.BASE);
        bears.addBear(bear1);

        bear1.clothing.add(new Clothing(4, "Hat"));
        bear1.clothing.add(new Clothing(4, "Sunglasses"));
        bear1.clothing.add(new Clothing(4, "Shoes"));
        bear1.clothing.add(new Clothing(4, "Jordans"));
        bear1.clothing.add(new Clothing(4, "Hoodie"));
        bear1.clothing.add(new Clothing(4, "Socks"));
        bear1.clothing.add(new Clothing(4, "Boxers"));
        bear1.clothing.add(new Clothing(4, "Tshirt"));
        bear1.clothing.add(new Clothing(4, "Pants"));
        bear1.clothing.add(new Clothing(4, "Jacket"));
        bear1.clothing.add(new Clothing(4, "Scarf"));

        Double expectedSavings = 19.4;
        Double ans = bears.calculateSavings();
        assertEquals(expectedSavings, ans, 0.005);
    }


}
