package fr.feedelio.pagode;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        // You can add any custom logic here to handle the exception
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
}
