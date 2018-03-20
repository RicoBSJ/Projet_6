package org.exemple.demo.consumer.impl.dao;

import org.exemple.demo.consumer.contract.dao.UtilisateurDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;

@Named
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

    public int getCountUser() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrUser = vJdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM user",
                Integer.class);

        return vNbrUser;
    }
}
