package jp.co.systena.tora.webjava.mid.api.excepiton;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum InvoiceErrorCode {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR);

    private HttpStatus returnStatus;
    //    private String errorCode;
    //    private String errorMsgForDeveloper;
    //    private String errorMsgForUser;
}
