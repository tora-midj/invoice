package jp.co.systena.tora.webjava.mid.api.converter;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jp.co.systena.tora.webjava.mid.api.response.model.InvoiceResult;
import jp.co.systena.tora.webjava.mid.dao.entity.InvoiceEntity;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class InvoiceResultConverter implements Converter<InvoiceEntity, InvoiceResult> {

    @Override
    public InvoiceResult convert(@NonNull final InvoiceEntity source) {
        final InvoiceResult invoiceResult = new InvoiceResult();

        try {
            BeanUtils.copyProperties(invoiceResult, source);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("", e);
        }
        return invoiceResult;
    }

}
