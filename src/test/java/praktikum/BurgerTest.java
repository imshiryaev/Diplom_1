package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientTwo;

    Burger burger;

    @Before
    public void setUp() {
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
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(0,1);

        Assert.assertEquals(ingredient, burger.ingredients.get(1));
        Assert.assertEquals(ingredientTwo, burger.ingredients.get(0));
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
        Mockito.when(bun.getPrice()).thenReturn(20F);
        Mockito.when(bun.getName()).thenReturn("black buns");

        Mockito.when(ingredient.getPrice()).thenReturn(1F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");

        Mockito.when(ingredientTwo.getPrice()).thenReturn(1F);
        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientTwo.getName()).thenReturn("cutlet");

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);

        Assert.assertEquals(String.format("(==== %s ====)%n= sauce %s =%n= filling %s =%n(==== %s ====)%n%nPrice: %.6f%n",
                "black buns", "hot sauce", "cutlet", "black buns", burger.getPrice()), burger.getReceipt());
    }
}