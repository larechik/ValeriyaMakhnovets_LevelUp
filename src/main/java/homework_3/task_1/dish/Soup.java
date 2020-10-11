package homework_3.task_1.dish;

import homework_3.task_1.products.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Soup extends Dish {
    String name="soup";

    Soup(List<Ingredient> ingredients) {
        super(ingredients);
        super.setName(name);
    }




}



