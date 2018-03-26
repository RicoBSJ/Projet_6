package org.exemple.demo.consumer.impl.dao;

import org.exemple.demo.consumer.contract.dao.UtilisateurDao;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

    @Override
    public List<Utilisateur> getUtilisateur() {
        String vSQL = "SELECT * FROM public.utilisateur";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Utilisateur> vRowMapper = new RowMapper<Utilisateur>() {
            public Utilisateur mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Utilisateur vUtilisateur = new Utilisateur(pRS.getInt("id_utilisateur"));
                vUtilisateur.setNom(pRS.getString("nom"));
                vUtilisateur.setMail(pRS.getString("mail"));
                vUtilisateur.setTel(pRS.getInt("telephone"));
                return vUtilisateur;
            }
        };
        List<Utilisateur> vListStatut = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListStatut;
    }
}

