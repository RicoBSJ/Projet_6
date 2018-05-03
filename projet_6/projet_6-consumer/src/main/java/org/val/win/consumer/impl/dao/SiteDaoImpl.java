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
     * @return
     */
    @Override
    public List<Site> getListSite() {
        String vSQL = "SELECT * FROM public.site";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Site> vRowMapper = new RowMapper<Site>() {
            public Site mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Site vSite = new Site(pRS.getInt("id_site"));
                vSite.setNom_site(pRS.getString("nom"));
                vSite.setAltitudePiedVoie(pRS.getFloat("AltitudePiedVoie"));
                vSite.setDescription(pRS.getString("description"));
                return vSite;
            }
        };
        List<Site> vListSite = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListSite;
    }

    /**
     * Creer un nouveau site
     * @param pSite
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
        vParams.addValue("idTopo", pSite.getId_topo());
        vParams.addValue("nomSite", pSite.getNom_site());
        vParams.addValue("altitudePiedVoie", pSite.getaltitudePiedVoie());
        vParams.addValue("description", pSite.getDescription());

        KeyHolder holder = new GeneratedKeyHolder();
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams, holder, new String[]{"id_site"});
        pSite.setId(holder.getKey().intValue());
        return pSite;

    }

    /**
     * Mettre a jour les informations du site
     * @param pSite
     */
    @Override
    public void updateInfoVoie(Site pSite) {
        String vSQL = "UPDATE public.site " +
                "SET description = :description,\n" +
                "nom_site = :nom_site,\n" +
                "id_topo = :id_topo,\n" +
                "altitudepiedvoie = :altitudepiedvoie " +
                "WHERE id = :id";
        SqlParameterSource vParams = new BeanPropertySqlParameterSource(pSite);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }
}
