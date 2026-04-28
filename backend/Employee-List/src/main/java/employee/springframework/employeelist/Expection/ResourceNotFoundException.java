package employee.springframework.employeelist.Expection;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;




@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static  final long serialVersionUID = 1L;   // this is the version of the class

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
