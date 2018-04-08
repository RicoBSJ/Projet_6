package org.exemple.demo.consumer.impl.dao;


import org.exemple.demo.consumer.contract.dao.VoieDao;
import org.exemple.demo.model.bean.grimpe.Secteur;
import org.exemple.demo.model.bean.grimpe.Voie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao {


    @Override
    public List<Voie> getListVoie() {
        String vSQL = "SELECT * FROM public.voie";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<Voie> vRowMapper = new RowMapper<Voie>() {
            public Voie mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Voie vVoie = new Voie(pRS.getInt("id_voie"));
                vVoie.setNom(pRS.getString("nom_voie"));
                vVoie.setCotation(pRS.getString("cotation"));
                vVoie.setDescription(pRS.getString("description"));
                vVoie.setHauteur(pRS.getFloat("hauteur"));
                return vVoie;
            }
        };
        List<Voie> vListVoie = vJdbcTemplate.query(vSQL, vRowMapper);

        return vListVoie;
    }

    @Override
    public int getCountVoieSec(Secteur pSecteur) {
        String vSQL
                = "SELECT COUNT(*) FROM public.voie"
                + " WHERE id_secteur = :id_secteur";

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id_secteur", pSecteur.getNbrVoie());

        int vNbrVoie = vJdbcTemplate.queryForObject(vSQL, vParams, Integer.class);

        return vNbrVoie;
    }
}
