package homework_3.task_1.products;

public class Ingredient implements PrepareIngredient {
    private Integer calories;
    private String name;
    private Integer weight;
    private Boolean vegetable;

    public Ingredient(String name, Integer calories, Integer weight, Boolean vegetable) {
        this.name = name;
        this.calories = calories;
        this.weight = weight;
        this.vegetable = vegetable;
    }

    @Override
    public void prepare() {
        System.out.println("prepare ingredient " + name);
    }

    @Override
    public void addToDish() {
        System.out.println("add to dish ingredient " + name);
    }

    public Double getFullCalories() {
        return (double) weight * calories / 100;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getVegetable() {
        return vegetable;
    }

    public void setVegetable(Boolean vegetable) {
        this.vegetable = vegetable;
    }

    @Override
    public String toString() {
        return String.format("Name: %s; Weight: %d; Calories: %d",name,weight,calories);
    }
}
