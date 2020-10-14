package homework_3.task_1.dish;

import homework_3.task_1.products.Ingredient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Dish {
    private String name;
    private List<Ingredient> ingredients;

    Dish(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Double calcCalories() {
        Double calories = new Double(0);
        for (Ingredient ingredient : ingredients) {
            calories += ingredient.getFullCalories();
        }
        return calories;
    }

    public void makeADish() {
        System.out.println("Make a dish: " + name);
        for (Ingredient ingredient : ingredients) {
            ingredient.prepare();
            ingredient.addToDish();
        }
    }

    ;

    public List<Ingredient> sortVegetablesByCalories() {
        List<Ingredient> resultIngredients = new ArrayList<>();
        for (Ingredient ingredient : getIngredients()) {
            if (ingredient.getVegetable()) resultIngredients.add(ingredient);
        }
        Collections.sort(resultIngredients, new Comparator<Ingredient>() {
            @Override
            public int compare(Ingredient lhs, Ingredient rhs) {
                return lhs.getCalories() > rhs.getCalories() ? -1 : (lhs.getCalories() < rhs.getCalories()) ? 1 : 0;
            }
        });
        return resultIngredients;
    }

    public List<Ingredient> getIngredientsByFilter(int gteCalories, int lteCalories,
                                                   int gteWeight, int lteWeight) {
        List<Ingredient> resultIngredients = new ArrayList<>();
        for (Ingredient ingredient : getIngredients()) {
            if (ingredient.getCalories() >= gteCalories &&
                    ingredient.getCalories() <= lteCalories &&
                    ingredient.getWeight() >= gteWeight &&
                    ingredient.getWeight() <= lteWeight)
                resultIngredients.add(ingredient);
        }
        return resultIngredients;

    }
}
