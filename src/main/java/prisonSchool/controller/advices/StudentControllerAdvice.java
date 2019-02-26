package prisonSchool.controller.advices;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import prisonSchool.exceptions.EntityNotFoundException;

import java.util.Optional;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class StudentControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<VndErrors> entityNotFoundException(final EntityNotFoundException e) {
        return error(e, HttpStatus.NOT_FOUND, "");            // ha ez az exception dobódik, akkor ezt a statuszkódot adja vissza:  HttpStatus.NOT_FOUND -> 404
    }

    private ResponseEntity<VndErrors> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
    }

    /*@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<VndErrors> assertionException(final IllegalArgumentException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getLocalizedMessage());
    }*/

}
