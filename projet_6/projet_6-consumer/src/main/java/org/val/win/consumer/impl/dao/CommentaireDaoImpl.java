package org.val.win.consumer.impl.dao;

import org.val.win.consumer.contract.dao.CommentaireDao;
import org.val.win.model.bean.utilisateur.Commentaire;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class CommentaireDaoImpl extends AbstractDaoImpl implements CommentaireDao {

    /**
     * Récuperer tous les commentaires
     * @return
     */
    @Override
    public List<Commentaire> getListCommentaire() {
        String vSQL = "SELECT * FROM public.commentaire";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Commentaire> vRowMapper = new RowMapper<Commentaire>() {
            public Commentaire mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Commentaire vCommentaire = new Commentaire(pRS.getInt("id_commentaire"));
                vCommentaire.setText(pRS.getString("texte_com"));
                vCommentaire.setIdTopo(pRS.getInt("id_topo"));
                vCommentaire.setIdUtil(pRS.getInt("id_utilisateur"));
                return vCommentaire;
            }
        };
        List<Commentaire> vListCommentaire = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListCommentaire;
    }

    /**
     * Récupérer un commentaire précis d'un topo
     * @param pCommentaire
     * @return
     */
    @Override
    public String getCommentaire(Commentaire pCommentaire) {
        String vSQL
                = "SELECT texte_com FROM public.commentaire"
                + " WHERE id_topo = :topo_id"
                + "   AND id_commentaire = :id_com";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id_com", pCommentaire.getIdCom());
        vParams.addValue("topo_id", pCommentaire.getIdTopo());

        String comTopo = vJdbcTemplate.queryForObject(vSQL, vParams, String.class);

        return comTopo;
    }

    /**
     * Récupérér les commentaires d'un topo
     * @param id
     * @return
     */
    @Override
    public List<Commentaire> getCommentaireTopo(Integer id) {
        String vSQL = "SELECT * FROM public.commentaire" +
                        " WHERE id_topo = ?";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Commentaire> vRowMapper = new RowMapper<Commentaire>() {
            public Commentaire mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Commentaire vCommentaire = new Commentaire(pRS.getInt("id_commentaire"));
                vCommentaire.setText(pRS.getString("texte_com"));
                vCommentaire.setIdTopo(pRS.getInt("id_topo"));
                vCommentaire.setIdUtil(pRS.getInt("id_utilisateur_com"));
                return vCommentaire;
            }
        };
        List<Commentaire> vListCommentaire = vJdbcTemplate.query(vSQL, vRowMapper, id);

        return vListCommentaire;
    }

    /**
     * Creer un nouveau commentaire
     * @param pCommentaire
     */
    @Override
    public void insertCommentaire(Commentaire pCommentaire) {
        String vSQL = "INSERT INTO public.commentaire " +
                "  (id_topo,\n" +
                "  id_utilisateur_com,\n" +
                "  texte_com)\n" +
                "VALUES\n" +
                "('0', '0', '?')";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id_topo", pCommentaire.getIdTopo());
        vParams.addValue("id_utilisateur", pCommentaire.getIdUtil());
        vParams.addValue("texte_com", pCommentaire.getText());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }
}
