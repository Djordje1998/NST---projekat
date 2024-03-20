package nst.springboot.restexample01.exception;

public class DepartmentAlreadyExistException extends RuntimeException{

    public DepartmentAlreadyExistException(String message) {
        super(message);
    }
    
}
