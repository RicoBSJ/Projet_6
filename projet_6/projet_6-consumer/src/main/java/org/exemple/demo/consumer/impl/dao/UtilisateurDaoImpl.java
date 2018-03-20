package org.exemple.demo.consumer.impl.dao;

import org.exemple.demo.consumer.contract.dao.UtilisateurDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;

@Named
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

    @Override
    public int getUserName() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vUserName = vJdbcTemplate.queryForObject(
                "SELECT id, nom FROM public.utilisateur",
                Integer.class);

        return vUserName;
    }
}
