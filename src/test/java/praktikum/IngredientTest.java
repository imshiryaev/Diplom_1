package praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setUp() throws Exception {
        ingredient = new Ingredient(IngredientType.SAUCE, "TestSauce", 100);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(100, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("TestSauce", ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}