package org.exemple.demo.consumer.impl.dao;

import org.exemple.demo.consumer.contract.dao.UtilisateurDao;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

    @Override
    public List<Utilisateur> getListUtilisateur() {
        String vSQL = "SELECT * FROM public.utilisateur";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Utilisateur> vRowMapper = new RowMapper<Utilisateur>() {
            public Utilisateur mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Utilisateur vUtilisateur = new Utilisateur(pRS.getInt("id_utilisateur"));
                vUtilisateur.setNom(pRS.getString("nom"));
                vUtilisateur.setPrenom(pRS.getString("prenom"));
                vUtilisateur.setMail(pRS.getString("mail"));
                vUtilisateur.setTel(pRS.getInt("telephone"));
                vUtilisateur.setMotDePasse(pRS.getString("mot_de_passe"));
                vUtilisateur.setAdmin(pRS.getBoolean("admin"));
                return vUtilisateur;
            }
        };
        List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListUtilisateur;
    }

}

