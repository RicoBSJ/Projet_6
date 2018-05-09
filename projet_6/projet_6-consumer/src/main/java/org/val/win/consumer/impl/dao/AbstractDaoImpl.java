package org.val.win.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

/**
 * class pour récuprer la DB.
 */
public abstract class AbstractDaoImpl {


    /**
     * Bean datasource.
     */
    @Inject
    @Named("dataSourceP6")
    private DataSource dataSource;

    /**
     * Récupérer la datasource.
     * @return dataSource
     */
    protected DataSource getDataSource() {
        return dataSource;
    }

}