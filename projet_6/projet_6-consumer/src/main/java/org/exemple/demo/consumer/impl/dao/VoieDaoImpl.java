package org.exemple.demo.consumer.impl.dao;

import org.exemple.demo.consumer.contract.dao.VoieDao;
import org.exemple.demo.model.bean.grimpe.Voie;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;

@Named
public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao {


    public int getInfoVoie(Voie pvoie) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNumVoie = vJdbcTemplate.queryForObject(
                "SELECT id, nom, hauteur, cotation, description FROM public.voie",
                Integer.class);

        return vNumVoie;
    }
}
