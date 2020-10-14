package homework_3.task_1.dinner;

import homework_3.task_1.dish.Dish;

public class DinnerWithTwoDish implements CookDinner {
    Dish dishOne;
    Dish dishTwo;

    public DinnerWithTwoDish(Dish dishOne, Dish dishTwo) {
        this.dishOne = dishOne;
        this.dishTwo = dishTwo;
    }


    @Override
    public void cook() {
        System.out.println("Making first dish...");
        dishOne.makeADish();
        System.out.println("----");
        System.out.println("Making second dish...");
        dishTwo.makeADish();
    }

    @Override
    public void calcCalories() {
        System.out.println("Calories in dinner: "+ (dishOne.calcCalories()+dishTwo.calcCalories()));
    }
}
