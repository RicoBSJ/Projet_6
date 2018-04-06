package org.exemple.demo.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDaoImpl {

    @Inject
    @Named("dataSourceP6")
    private DataSource dataSource;


    protected DataSource getDataSource() {
        return dataSource;
    }

}