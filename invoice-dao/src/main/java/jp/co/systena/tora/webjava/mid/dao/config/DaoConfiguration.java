package jp.co.systena.tora.webjava.mid.dao.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Class DataSource.
 */
@Configuration
@EnableTransactionManagement
public class DaoConfiguration {

    /** The datasource url. */
    @Value("${datasource.url}")
    private String datasourceUrl;

    /** The datasource username. */
    @Value("${datasource.username}")
    private String datasourceUsername;

    /** The datasource password. */
    @Value("${datasource.password}")
    private String datasourcePassword;

    /** The datasource driver class name. */
    @Value("${datasource.driver-class-name}")
    private String datasourceDriverClassName;

    /**
     * Data source.
     *
     * @return the data source
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(this.datasourceDriverClassName);
        dataSource.setUrl(this.datasourceUrl);
        dataSource.setUsername(this.datasourceUsername);
        dataSource.setPassword(this.datasourcePassword);
        return dataSource;
    }

    /**
     * Jpa vendor adapter.
     *
     * @return the jpa vendor adapter
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setShowSql(true);

        return hibernateJpaVendorAdapter;
    }

    /**
     * Entity manager factory.
     *
     * @return the local container entity manager factory bean
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(jpaVendorAdapter());
        factory.setDataSource(dataSource());
        return factory;
    }

    /**
     * Transaction manager.
     *
     * @param entityManagerFactory the entity manager factory
     * @return the platform transaction manager
     */
    @Bean
    public PlatformTransactionManager transactionManager(
            final EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }

    /**
     * Jdbc template.
     *
     * @param dataSource the data source
     * @return the jdbc template
     */
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(final DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}