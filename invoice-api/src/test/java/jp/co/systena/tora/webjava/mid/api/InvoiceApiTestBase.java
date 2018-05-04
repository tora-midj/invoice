package jp.co.systena.tora.webjava.mid.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

public class InvoiceApiTestBase {

    public static final String TEST_RESOURCE_PATH_BASE = "/jp/co/systena/tora/webjava/mid/it/";

    public static final String TEST_RESOURCE_PATH_BASE2 = "/jp/co/systena/tora/webjava/mid/it/";
    @Autowired
    protected TestRestTemplate testRestTemplate;
}
