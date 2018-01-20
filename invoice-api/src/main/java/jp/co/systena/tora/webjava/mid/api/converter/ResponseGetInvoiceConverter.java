package jp.co.systena.tora.webjava.mid.api.converter;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jp.co.systena.tora.webjava.mid.api.response.model.ResponseGetInvoice;
import jp.co.systena.tora.webjava.mid.dao.model.Invoice;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ResponseGetInvoiceConverter
        implements
        Converter<Invoice, ResponseGetInvoice> {

    @Override
    public ResponseGetInvoice convert(@NonNull final Invoice source) {
        final ResponseGetInvoice responseGetInvoice = new ResponseGetInvoice();

        try {
            BeanUtils.copyProperties(responseGetInvoice, source);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("", e);
        }
        return responseGetInvoice;
    }

}
