package homework_4.task_1.exception;


public class WrongDishInMenuException extends Exception{
    public WrongDishInMenuException(){
        super("In menu should be soup and salad");
    }
}
