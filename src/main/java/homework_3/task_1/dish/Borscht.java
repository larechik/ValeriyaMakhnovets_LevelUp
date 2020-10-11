package homework_3.task_1.dish;

import homework_3.task_1.products.Ingredient;

import java.util.List;

public class Borscht extends Soup {
    String name = "borscht";

    public Borscht(List<Ingredient> ingredients) {
        super(ingredients);
        super.setName(name);

    }

}



