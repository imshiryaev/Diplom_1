package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    Burger burger;

    @Before
    public void setUp() throws Exception {
        burger = new Burger();
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(20F);
        Mockito.when(ingredient.getPrice()).thenReturn(1F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Assert.assertEquals(41, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
    }
}