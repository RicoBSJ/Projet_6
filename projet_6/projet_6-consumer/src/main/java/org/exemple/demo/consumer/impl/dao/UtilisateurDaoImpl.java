package org.exemple.demo.consumer.impl.dao;

import org.exemple.demo.consumer.contract.dao.UtilisateurDao;
import org.exemple.demo.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

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
                vUtilisateur.setPseudonyme(pRS.getString("pseudonyme"));
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

    /*
    @Override
    public List<Utilisateur> getUtilisateur(Utilisateur pUtilisateur) {
        String vSQL
                = "SELECT * FROM public.utilisateur "
                + "WHERE id_utilisateur = ?";


        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Utilisateur> vRowMapper = new RowMapper<Utilisateur>() {
            public Utilisateur mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Utilisateur vUtilisateur = new Utilisateur(pRS.getInt("id_utilisateur"));
                vUtilisateur.setNom(pRS.getString("nom"));
                vUtilisateur.setPrenom(pRS.getString("prenom"));
                vUtilisateur.setPseudonyme(pRS.getString("pseudonyme"));
                vUtilisateur.setMail(pRS.getString("mail"));
                vUtilisateur.setTel(pRS.getInt("telephone"));
                vUtilisateur.setMotDePasse(pRS.getString("mot_de_passe"));
                vUtilisateur.setAdmin(pRS.getBoolean("admin"));
                return vUtilisateur;
            }
        };

        List<Utilisateur> vListUtilisateur = vJdbcTemplate.queryForObject(vSQL, vRowMapper, pUtilisateur.getId());

        return vListUtilisateur;
    }
    */

    @Override
    public Utilisateur getUtilisateur(Integer id) {
        String vSQL = "SELECT * FROM public.utilisateur " +
                      "WHERE id_utilisateur = ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Utilisateur utilisateur = vJdbcTemplate.queryForObject( vSQL, Utilisateur.class, id);
        return utilisateur;
    }



    @Override
    public void insertUtilisateur(Utilisateur pUtilisateur) {
        String vSQL = "INSERT INTO public.utilisateur " +
                "  (id_utilisateur,\n" +
                "  nom,\n" +
                "  pseudonyme,\n" +
                "  prenom,\n" +
                "  mail,\n" +
                "  telephone,\n" +
                "  mot_de_passe,\n" +
                "  admin)\n" +
                "VALUES\n" +
                "( '?', '?', '?', '?', '?', '?', '?', '?')";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id_utilisateur", pUtilisateur.getId());
        vParams.addValue("nom", pUtilisateur.getNom());
        vParams.addValue("pseudonyme", pUtilisateur.getPseudonyme());
        vParams.addValue("prenom", pUtilisateur.getPrenom());
        vParams.addValue("mail", pUtilisateur.getMail());
        vParams.addValue("telephone", pUtilisateur.getTel());
        vParams.addValue("mot_de_passe", pUtilisateur.getMotDePasse());
        vParams.addValue("admin", pUtilisateur.getAdmin());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public void updateEtat(Utilisateur pUtilisateur) {
        String vSQL = "UPDATE public.utilisateur SET admin = :admin WHERE id = :id";
        SqlParameterSource vParams = new BeanPropertySqlParameterSource(pUtilisateur);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }

}

