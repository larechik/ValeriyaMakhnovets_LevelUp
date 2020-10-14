package homework_3.task_1.cooks;

import homework_3.task_1.dinner.DinnerWithTwoDish;
import homework_3.task_1.dish.Borscht;
import homework_3.task_1.dish.Dish;
import homework_3.task_1.dish.Salad;
import homework_3.task_1.products.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chef {

    public static void main(String[] args) {
        System.out.println("Chef start work");
        List<Ingredient> ingredientsInRefrigerator = createIngredientInRefrigerator();
        List<Ingredient> ingredientsForBorscht = createIngredientListForBorscht();
        List<Ingredient> ingredientsForSalad = createIngredientListForSalad();
        Dish borscht = new Borscht(ingredientsForBorscht);
        Dish salad = new Salad(ingredientsForSalad);
        DinnerWithTwoDish dinner = new DinnerWithTwoDish(salad, borscht);
        System.out.println("---------------------------");
        System.out.println("Chef make a dinner");
        dinner.cook();
        System.out.println("---------------------------");
        System.out.println("Chef count calories in the dinner");
        dinner.calcCalories();
        System.out.println("---------------------------");
        System.out.println("Chef sort vegetables in salad from dinner");
        List<Ingredient> sortVegetablesInSalad = salad.sortVegetablesByCalories();
        printIngredientList(sortVegetablesInSalad);
        System.out.println("---------------------------");
        System.out.println("Chef sort vegetables in borscht from dinner");
        List<Ingredient> getIngredientsByFilter =
                borscht.getIngredientsByFilter(30, 50, 100, 150);
        printIngredientList(getIngredientsByFilter);

    }

    public static List<Ingredient> createIngredientInRefrigerator() {
        System.out.println("Create ingredients in refrigerator");
        return Arrays.asList(new Beef(500), new Beet(2300),
                new Potatoes(1000), new Onion(500), new Cabbage(2000),
                new Carrot(800), new Tomato(1500));
    }

    public static List<Ingredient> createIngredientListForBorscht() {
        System.out.println("Get ingredients for borscht");
        return Arrays.asList(new Beef(500), new Beet(330), new Potatoes(350),
                new Onion(130), new Cabbage(300), new Carrot(130));
    }

    public static List<Ingredient> createIngredientListForSalad() {
        System.out.println("Get ingredients for salad");
        return Arrays.asList(new Beef(100), new Cabbage(150),
                new Carrot(250), new Tomato(300));
    }

    public static void printIngredientList(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.toString());
        }
    }

}
