package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "TestSauce", 100);
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