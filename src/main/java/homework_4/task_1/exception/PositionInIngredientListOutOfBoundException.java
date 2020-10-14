package homework_4.task_1.exception;

public class PositionInIngredientListOutOfBoundException extends ArrayIndexOutOfBoundsException {
    public PositionInIngredientListOutOfBoundException(){
        super("Found wrong position to new ingredient");
    }
}
