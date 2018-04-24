package org.val.win.consumer.impl.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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

    @Override
    public void insertSite(Site pSite) {
        String vSQL = "INSERT INTO public.site " +
                "  (id_topo,\n" +
                "  nom_site,\n" +
                "  altitudepiedvoie,\n" +
                "  description)\n" +
                "VALUES\n" +
                "( '?', '?', '?', '?')";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id_site", pSite.getId_site());
        vParams.addValue("id_topo", pSite.getId_topo());
        vParams.addValue("nom_site", pSite.getNom_site());
        vParams.addValue("altitudepiedvoie", pSite.getaltitudePiedVoie());
        vParams.addValue("description", pSite.getDescription());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        int vNbrLigneMaJ = vJdbcTemplate.update(vSQL, vParams);
    }

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
