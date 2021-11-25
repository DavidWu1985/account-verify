package proj.david.game803.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import proj.david.api.R;

import java.util.HashMap;
import java.util.Map;



@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleMethodArgument(MethodArgumentNotValidException e){
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        R r = new R();
        Map<String, Object> state = new HashMap<>();
        state.put("msg", objectError.getDefaultMessage());
        state.put("code", 9000);
        r.setState(state);
        return r;
    }


    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R handleError(Throwable e) {
        e.printStackTrace();
        log.error("服务器异常", e);
        R r = new R();
        r.setMsg(e.getMessage());
        return r;
    }

}
