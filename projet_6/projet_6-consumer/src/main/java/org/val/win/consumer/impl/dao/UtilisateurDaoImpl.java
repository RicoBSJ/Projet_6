package org.val.win.consumer.impl.dao;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.val.win.consumer.contract.dao.UtilisateurDao;
import org.val.win.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.inject.Named;
import java.sql.*;
import java.util.List;

/**
 * Implementation des DAO pour l'utilisateur.
 */
@Named
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

    /**
     * Récupérer tous les utilisateurs
     * @return liste d'utilisateur
     */
    @Override
    public List<Utilisateur> getListUtilisateur() {
        String vSQL = "SELECT * FROM public.utilisateur";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Utilisateur> vRowMapper = new RowMapper<Utilisateur>() {
            public Utilisateur mapRow(final ResultSet pRS, final int pRowNum) throws SQLException {
                Utilisateur vUtilisateur = new Utilisateur(pRS.getInt("id_utilisateur"));
                vUtilisateur.setNom(pRS.getString("nom"));
                vUtilisateur.setPrenom(pRS.getString("prenom"));
                vUtilisateur.setPseudonyme(pRS.getString("pseudonyme"));
                vUtilisateur.setMail(pRS.getString("mail"));
                vUtilisateur.setTel(pRS.getString("telephone"));
                vUtilisateur.setMotDePasse(pRS.getString("mot_de_passe"));
                vUtilisateur.setAdmin(pRS.getBoolean("admin"));
                return vUtilisateur;
            }
        };
        List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListUtilisateur;
    }

    /**
     * Récupérer un utilisateur précis
     * @param id id de utilisateur
     * @return un utilisateur
     */
    @Override
    public Utilisateur getUtilisateur(final Integer id) {
        String vSQL = "SELECT * FROM public.utilisateur " +
                      "WHERE id_utilisateur = ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Utilisateur utilisateur = vJdbcTemplate.queryForObject(vSQL, Utilisateur.class, id);
        return utilisateur;
    }

    /**
     * Creer un utilisateur
     * @param pUtilisateur utilisateur en parametre
     * @return utilisateur creer
     */

    @Override
    public Utilisateur insertUtilisateur(final Utilisateur pUtilisateur) {
        String vSQL = "INSERT INTO public.utilisateur " +
                "  (nom,\n" +
                "  pseudonyme,\n" +
                "  prenom,\n" +
                "  mail,\n" +
                "  telephone,\n" +
                "  mot_de_passe,\n" +
                "  admin)\n" +
                "VALUES\n" +
                "(:nom,:pseudonyme,:prenom,:mail,:tel,:mdp,:admin)";

        KeyHolder holder = new GeneratedKeyHolder();
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", pUtilisateur.getNom());
        vParams.addValue("pseudonyme", pUtilisateur.getPseudonyme());
        vParams.addValue("prenom", pUtilisateur.getPrenom());
        vParams.addValue("mail", pUtilisateur.getMail());
        vParams.addValue("tel", pUtilisateur.getTel());
        vParams.addValue("mdp", pUtilisateur.getMotDePasse());
        vParams.addValue("admin", pUtilisateur.getAdmin());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams, holder, new String[]{"id_utilisateur"});
        pUtilisateur.setIdUtilisateur(holder.getKey().intValue());
        return pUtilisateur;
    }


    /**
     * Mettre a jour l'etat (ADMIN) de l'utilisateur
     * @param pUtilisateur utilisateur en parametre
     */
    @Override
    public void updateEtat(final Utilisateur pUtilisateur) {
        String vSQL = "UPDATE public.utilisateur SET admin = :admin WHERE id_utilisateur = :id";
        SqlParameterSource vParams = new BeanPropertySqlParameterSource(pUtilisateur);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    /**
     * Mettre a jour les informations de l'utilisateur
     * @param pUtilisateur utilisateur a modifier
     */
    @Override
    public void updateInfoUtil(final Utilisateur pUtilisateur) {
        String vSQL = "UPDATE public.utilisateur " +
                "SET admin = :admin,\n" +
                "nom = :nom,\n" +
                "prenom = :prenom,\n" +
                "pseudonyme = :pseudonyme,\n" +
                "mail = :mail,\n" +
                "telephone = :telephone,\n" +
                "mot_de_passe = :mot_de_passe " +
                "WHERE id_utilisateur = :id";
        SqlParameterSource vParams = new BeanPropertySqlParameterSource(pUtilisateur);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

}

