package jp.co.systena.tora.webjava.mid.api.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The Class ApiValidationExceptionHandler.
 */
@ControllerAdvice
public class ApiValidationExceptionHandler extends ResponseEntityExceptionHandler {

    //    @Override
    //    protected ResponseEntity<Object> handleMethodArgumentNotValid(
    //            final MethodArgumentNotValidException ex,
    //            final HttpHeaders headers,
    //            final HttpStatus status,
    //            final WebRequest request) {
    //        BindingResult bindingResult = ex.getBindingResult();
    //
    //        final List<ApiFieldError> apiFieldErrors = bindingResult
    //                .getFieldErrors()
    //                .stream()
    //                .map(fieldError -> new ApiFieldError(
    //                        fieldError.getField(),
    //                        fieldError.getCode(),
    //                        fieldError.getRejectedValue()))
    //                .collect(Collectors.toList());
    //
    //        final List<ApiGlobalError> apiGlobalErrors = bindingResult
    //                .getGlobalErrors()
    //                .stream()
    //                .map(globalError -> new ApiGlobalError(
    //                        globalError.getCode()))
    //                .collect(Collectors.toList());
    //
    //        return new ResponseEntity<>(new InvoiceError(apiFieldErrors, apiGlobalErrors),
    //                HttpStatus.UNPROCESSABLE_ENTITY);
    //    }
}