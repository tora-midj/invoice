package jp.co.systena.tora.webjava.mid.api;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.csv.CsvURLDataSet;
import org.springframework.core.io.Resource;

import com.github.springtestdbunit.dataset.AbstractDataSetLoader;

public class CsvDataSetLoader extends AbstractDataSetLoader {
    public CsvDataSetLoader() {
    }

    @Override
    protected IDataSet createDataSet(final Resource resource) throws Exception {
        return new CsvURLDataSet(resource.getURL());
    }
}
