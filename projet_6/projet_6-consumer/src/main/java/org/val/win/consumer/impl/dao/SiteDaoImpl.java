package org.val.win.consumer.impl.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.val.win.consumer.contract.dao.SiteDao;
import org.val.win.model.bean.grimpe.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {

    /**
     * Récupérer tous les sites
     * @param id l'id d'un topo
     * @return liste de site
     */
    @Override
    public List<Site> getListSite(Integer id) {
        String vSQL = "SELECT * FROM public.site" +
                      " WHERE id_topo = ?";
        RowMapper<Site> vRowMapper = new RowMapper<Site>() {
            public Site mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Site vSite = new Site(pRS.getInt("id_site"));
                vSite.setIdTopo(pRS.getInt("id_topo"));
                vSite.setNomSite(pRS.getString("nom_site"));
                vSite.setAltitudePiedVoie(pRS.getFloat("altitudepiedvoie"));
                vSite.setDescription(pRS.getString("description"));
                return vSite;
            }
        };

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Site> vListSite = vJdbcTemplate.query(vSQL, vRowMapper, id);

        return vListSite;
    }

    /**
     * Creer un nouveau site
     * @param pSite id d'un topo
     * @return le site creer
     */
    @Override
    public Site insertSite(Site pSite) {
        String vSQL = "INSERT INTO public.site " +
                "  (id_topo,\n" +
                "  nom_site,\n" +
                "  altitudepiedvoie,\n" +
                "  description)\n" +
                "VALUES\n" +
                "(:idTopo,:nomSite,:altitudePiedVoie,:description)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("idTopo", pSite.getIdTopo());
        vParams.addValue("nomSite", pSite.getNomSite());
        vParams.addValue("altitudePiedVoie", pSite.getAltitudePiedVoie());
        vParams.addValue("description", pSite.getDescription());

        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams, holder, new String[]{"id_site"});
        pSite.setIdSite(holder.getKey().intValue());
        return pSite;

    }

    /**
     * Mettre a jour les informations du site
     * @param pSite site a modifier en paramètre
     */
    @Override
    public void updateInfoVoie(Site pSite) {
        String vSQL = "UPDATE public.site " +
                "SET description = :description,\n" +
                "nom_site = :nom_site,\n" +
                "id_topo = :id_topo,\n" +
                "altitudepiedvoie = :altitudepiedvoie " +
                "WHERE id_site = :idSite";
        SqlParameterSource vParams = new BeanPropertySqlParameterSource(pSite);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }
}
