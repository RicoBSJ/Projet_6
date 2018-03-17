package org.exemple.demo.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDaoImpl {

    private DataSource dataSource;

    protected DataSource getDataSource() {
        return dataSource;
    }

}