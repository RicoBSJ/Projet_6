package org.exemple.demo.consumer.impl.dao;

import org.exemple.demo.consumer.contract.dao.TopoDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;

@Named
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {


    public int getInfoTopo() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vInfoTopo = vJdbcTemplate.queryForObject(
                "SELECT id_possesseur, description, etat FROM public.topo",
                Integer.class);

        return vInfoTopo;
    }
}
