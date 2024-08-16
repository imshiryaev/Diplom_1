package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class BunTest {
    String name;
    float price;

    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return  new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {"12345", Float.MAX_VALUE},
                {"324556", Float.MIN_VALUE},
        };
    }

    @Test
    public void getNameTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, bun.getPrice(), 0);
    }
}