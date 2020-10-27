package homework_4.task_1;

import homework_3.task_1.dinner.DinnerWithTwoDish;
import homework_3.task_1.dish.Borscht;
import homework_3.task_1.dish.Dish;
import homework_3.task_1.dish.Salad;
import homework_3.task_1.products.Carrot;
import homework_3.task_1.products.Ingredient;
import homework_3.task_1.products.Potatoes;
import homework_4.task_1.exception.PositionInIngredientListOutOfBoundException;
import homework_4.task_1.exception.WrongDishInMenuException;

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.startFirstExceptionMethod();
        task1.startSecondExceptionMethod();
        task1.startOutOfBoundExceptionMethod();
    }

     void startOutOfBoundExceptionMethod() {
        Dish dish = new Borscht(Arrays.asList(new Potatoes(300)));
        Ingredient carrot = new Carrot(500);
        addIngredientToDishInPosition(dish, carrot, 1);
    }

     void startFirstExceptionMethod() {
        Dish dish = new Salad(Arrays.asList(new Potatoes(300)));
        DinnerWithTwoDish dinner = new DinnerWithTwoDish(dish, dish);
        try {
            checkDinner(dinner);
        } catch (WrongDishInMenuException e) {
            e.printStackTrace();
        }
    }

     void startSecondExceptionMethod() {
        Dish secondDish = new Borscht(Arrays.asList(new Potatoes(300)));
        Dish firstDish = new Salad(Arrays.asList(new Potatoes(300)));
        DinnerWithTwoDish dinner = new DinnerWithTwoDish(firstDish, secondDish);
        try {
            checkDinner(dinner);
        } catch (WrongDishInMenuException e) {
            e.printStackTrace();
        }
    }

     void addIngredientToDishInPosition(Dish dish, Ingredient ingredient, int position) {
        try {
            dish.getIngredients().set(position, ingredient);
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new PositionInIngredientListOutOfBoundException();
        }
    }

     void checkDinner(DinnerWithTwoDish dinner) throws WrongDishInMenuException {
        if (!dinner.getDishOne().getName().equals("salad") ||
                !dinner.getDishTwo().getName().equals("soup") ||
                dinner.getDishOne().getName().equals(dinner.getDishTwo().getName())) {
            throw new WrongDishInMenuException();
        }
    }
}
