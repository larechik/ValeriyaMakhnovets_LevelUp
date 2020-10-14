package homework_3.task_1.dish;

import homework_3.task_1.products.Ingredient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Salad extends Dish {
    String name="salad";

    public Salad(List<Ingredient> ingredients) {
        super(ingredients);
        super.setName(name);
    }




}



