package org.val.win.consumer.impl.dao;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
     * Récupérér les commentaires d'un topo.
     * @return liste de commentaire
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
     * @param pCommentaire commentaire a creer
     */
    @Override
    public Commentaire insertCommentaire(Commentaire pCommentaire) {
        String vSQL = "INSERT INTO public.commentaire " +
                "  (id_topo,\n" +
                "  id_utilisateur_com,\n" +
                "  texte_com)\n" +
                "VALUES\n" +
                "(:idTopo,:idUtil,:com)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("idTopo", pCommentaire.getIdTopo());
        vParams.addValue("idUtil", pCommentaire.getIdUtil());
        vParams.addValue("com", pCommentaire.getText());

        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate
                = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams, holder, new String[]{"id_commentaire"});
        pCommentaire.setId(holder.getKey().intValue());
        return pCommentaire;
    }
}
