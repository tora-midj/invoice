package jp.co.systena.tora.webjava.mid.api.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import jp.co.systena.tora.webjava.mid.api.request.model.RequestPostInvoice;

@Component
public class ProductCreateRequestValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return RequestPostInvoice.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        boolean f = false;
        if (f) {
            errors.rejectValue("hogeField", "hogeCode");
        }

        //        return true;
        //        ProductCreateRequest productCreateRequest = (ProductCreateRequest) target;
        //
        //        if (productRepository.exists(productCreateRequest.toProduct())) {
        //            errors.reject(ALREADY_EXISTS.getCode());
        //        }
    }
}