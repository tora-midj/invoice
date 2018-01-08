package jp.co.systena.tora.webjava.mid.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.systena.tora.webjava.mid.api.request.model.RequestPostInvoice;
import jp.co.systena.tora.webjava.mid.api.response.model.ResponseGetInvoice;
import jp.co.systena.tora.webjava.mid.api.response.model.ResponsePostInvoice;

@RestController
@RequestMapping("/api/inovice")
public class InvoiceController {

    @Resource
    InvoiceService invoiceService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<ResponseGetInvoice> getInvoice() {
        return invoiceService.getInvoices();
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponsePostInvoice postInvoice(
            @Validated @RequestBody RequestPostInvoice requestPostInvoice,
            BindingResult result) {

        return invoiceService.createInvoices(new RequestPostInvoice());
    }
}
