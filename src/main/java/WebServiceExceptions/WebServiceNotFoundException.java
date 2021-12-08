package WebServiceExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This service does not exist")
public class WebServiceNotFoundException extends RuntimeException{
}
