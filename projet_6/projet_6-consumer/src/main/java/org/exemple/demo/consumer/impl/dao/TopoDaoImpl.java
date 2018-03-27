package org.exemple.demo.consumer.impl.dao;

import org.exemple.demo.consumer.contract.dao.TopoDao;
import org.exemple.demo.model.bean.grimpe.Topo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {


    @Override
    public List<Topo> getTopo() {
        String vSQL = "SELECT * FROM public.topo";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Topo> vRowMapper = new RowMapper<Topo>() {
            public Topo mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Topo vTopo = new Topo(pRS.getInt("id_utilisateur"));
                vTopo.setNom_topo(pRS.getString("nom_topo"));
                vTopo.setAncrage(pRS.getString("ancrage"));
                vTopo.setDescription(pRS.getString("description"));
                vTopo.setEtat(pRS.getBoolean("etat"));
                vTopo.setLieu(pRS.getString("lieu"));
                vTopo.setProfil(pRS.getString("profil"));
                vTopo.setRegion(pRS.getString("region"));
                vTopo.setRelai(pRS.getString("relai"));
                vTopo.setRoche((pRS.getString("roche")));
                return vTopo;
            }
        };
        List<Topo> vListTopo = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListTopo;
    }
}
