package org.exemple.demo.consumer.impl.dao;

import org.exemple.demo.consumer.contract.dao.SiteDao;
import org.exemple.demo.model.bean.grimpe.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
}
