package org.exemple.demo.consumer.impl.dao;

import org.exemple.demo.consumer.contract.dao.CommentaireDao;
import org.exemple.demo.model.bean.utilisateur.Commentaire;
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

    @Override
    public List<Commentaire> getListCommentaire() {
        String vSQL = "SELECT * FROM public.commentaire";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Commentaire> vRowMapper = new RowMapper<Commentaire>() {
            public Commentaire mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Commentaire vCommentaire = new Commentaire(pRS.getInt("id_commentaire"));
                vCommentaire.setText(pRS.getString("text"));
                return vCommentaire;
            }
        };
        List<Commentaire> vListCommentaire = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListCommentaire;
    }

    @Override
    public String getCommentaire (Commentaire pCommentaire) {
        String vSQL
                = "SELECT texte_com FROM public.commentaire"
                + " WHERE id_topo = :topo_id"
                + "   AND id_commentaire = :id_com";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id_com", pCommentaire.getId_com());
        vParams.addValue("topo_id", pCommentaire.getId_topo());

        String comTopo = vJdbcTemplate.queryForObject(vSQL, vParams, String.class);

        return comTopo;
    }
}
