package jp.co.systena.tora.webjava.mid.api;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

import jp.co.systena.tora.webjava.mid.api.request.model.RequestPostInvoice;
import jp.co.systena.tora.webjava.mid.api.response.model.ResponseInvoice;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(classes = { InvoiceConfing.class, DaoConfiguration.class })
//@Transactional
@TestExecutionListeners({ DbUnitTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class })
@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class // ここでCSVでデータ読み込むReplacementDataSetLoaderのクラスを指定
)
@Slf4j
public class InvoiceApiTest extends InvoiceApiTestBase {

    //    @Test
    //    @DatabaseSetup(InvoiceApiTestBase.TEST_RESOURCE_PATH_BASE + "case01/input/")
    //    @ExpectedDatabase(//
    //            value = InvoiceApiTestBase.TEST_RESOURCE_PATH_BASE + "case01/output/", //
    //            assertionMode = DatabaseAssertionMode.NON_STRICT) // DatabaseAssertionMode.NON_STRICT で指定したテーブルと列だけを検証
    //    public void getInvoiceTest() {
    //        String url = "/api/inovice/";
    //        ResponseEntity<List<ResponseInvoice>> response = this.testRestTemplate.exchange(url, HttpMethod.GET, null,
    //                new ParameterizedTypeReference<List<ResponseInvoice>>() {
    //                });
    //
    //        assertEquals(HttpStatus.OK, response.getStatusCode());
    //
    //        log.info(response.getBody().toString());
    //
    //    }

    @Test
    public void postInvoiceTest() {
        String url = "/api/inovice/";

        RequestPostInvoice parm = new RequestPostInvoice();
        parm.setClientNo("20001");
        parm.setCreateUser("create_user");
        parm.setInvoiceStartDate("2018-01-05 00:00:00");
        parm.setInvoiceEndDate("2018-01-05 23:59:59");

        HttpEntity<RequestPostInvoice> httpEntity = new HttpEntity<RequestPostInvoice>(parm);
        ResponseEntity<ResponseInvoice> response = this.testRestTemplate.exchange(
                url,
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<ResponseInvoice>() {
                });

        assertEquals(HttpStatus.OK, response.getStatusCode());

        log.info(response.getBody().toString());

    }

}
