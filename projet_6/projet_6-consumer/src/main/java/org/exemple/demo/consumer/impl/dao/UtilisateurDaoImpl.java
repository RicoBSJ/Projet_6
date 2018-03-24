package org.exemple.demo.consumer.impl.dao;

import org.exemple.demo.consumer.contract.dao.UtilisateurDao;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;


@Named
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {


    public int getCountUser(Utilisateur pUtilisateur) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrUser = vJdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM utilisateur",
                Integer.class);

        return vNbrUser;
    }

}

