package org.val.win.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDaoImpl {


    /**
     * Bean datasource
     */
    @Inject
    @Named("dataSourceP6")
    private DataSource dataSource;

    /**
     * Récupérer la datasource
     * @return
     */
    protected DataSource getDataSource() {
        return dataSource;
    }

}